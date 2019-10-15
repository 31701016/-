package cn.edu.zucc.personplan.ui;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Scanner;

public class subway {
    public String line="0";
    public String hh = "";
    private List<Station> outList = new ArrayList<Station>();
    public void calculate(Station s1,Station s2){
        if(outList.size() == data.totalStaion){
            int flag=0;
            for(Station station : s1.getAllPassedStations(s2)){
                if(!station.getline().equals(line)&&flag==1){
                    line=station.getline();
//                    System.out.print("(请乘坐"+line+")");
                    hh+="(请乘坐"+line+")";
//                    System.out.print("->"+station.getName());
                    hh+="->"+station.getName();
                }
                else if(!station.getline().equals(line)&&flag==0) {
//                    System.out.print(station.getName());
                    hh+=station.getName();
                    flag=1;
                }
                else{
//                    System.out.print("->"+station.getName());
                    hh+="->"+station.getName();
                }
            }
            return ;
        }
        if(!outList.contains(s1)){
            outList.add(s1);
        }
        if(s1.getOrderSetMap().isEmpty()){
            List<Station> Linkedstations = getAllLinkedStations(s1);
            for(Station s : Linkedstations){
                s1.getAllPassedStations(s).add(s);
            }
        }
        
        Station parent = getShortestPath(s1);
        if(parent == s2){
            for(Station station : s1.getAllPassedStations(s2)){
                if(!station.getline().equals(line)){
                    line=station.getline();
//                  System.out.print("(请乘坐"+line+")");
                  hh+="(请乘坐"+line+")";
//                  System.out.print("->"+station.getName());
                  hh+="->"+station.getName();
                }
                else
//                  System.out.print("->"+station.getName());
                  hh+="->"+station.getName();
            }
            return ;
        }
        for(Station child : getAllLinkedStations(parent)){
            if(outList.contains(child)){
                continue;
            }
            int shortestPath = (s1.getAllPassedStations(parent).size()-1) + 1;
            if(s1.getAllPassedStations(child).contains(child)){
                if((s1.getAllPassedStations(child).size()-1) > shortestPath){
                    s1.getAllPassedStations(child).clear();
                    s1.getAllPassedStations(child).addAll(s1.getAllPassedStations(parent));
                    s1.getAllPassedStations(child).add(child);
                }
            } else {       
            	s1.getAllPassedStations(child).addAll(s1.getAllPassedStations(parent));
                s1.getAllPassedStations(child).add(child);
            }
        }
        outList.add(parent);
        calculate(s1,s2);
    }
    private Station getShortestPath(Station station){
        int minPatn = Integer.MAX_VALUE;
        Station rets = null;
        for(Station s :station.getOrderSetMap().keySet()){
            if(outList.contains(s)){
                continue;
            }
            LinkedHashSet<Station> set  = station.getAllPassedStations(s);
            if(set.size() < minPatn){
                minPatn = set.size();
                rets = s;
            }
        }
        return rets;
    }
    private List<Station> getAllLinkedStations(Station station){
        List<Station> linkedStaions = new ArrayList<Station>();
        for(List<Station> line : data.lineSet){
            if(line.contains(station)){
                Station s = line.get(line.indexOf(station));
                if(s.prev != null){
                    linkedStaions.add(s.prev);
                }
                if(s.next != null){
                    linkedStaions.add(s.next);
                }
            }
        }
        return linkedStaions;
    }

    public static void main(String[] args) {
        
        long t1 = System.currentTimeMillis();
        subway sw = new subway();
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入起点站：");
        String s1 = sc.nextLine();
        System.out.println("请输入终点站：");
        String s2 = sc.nextLine();
        sw.calculate(new Station(s1), new Station(s2));
    }
}