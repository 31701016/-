package cn.edu.zucc.personplan.ui;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

import cn.edu.zucc.personplan.util.BaseException;
import cn.edu.zucc.personplan.util.DbException;
 
 
public class data {
 
    public static List<Station> line1 = new ArrayList<Station>();
    public static List<Station> line2 = new ArrayList<Station>();
    public static List<Station> line4 = new ArrayList<Station>();
    public static List<Station> line5 = new ArrayList<Station>();
    public static List<Station> line6 = new ArrayList<Station>();

    public static List<String> list = new ArrayList<String>();
     
    public static Set<List<Station>> lineSet = new HashSet<List< Station>>();//所有线集合
    public static int totalStaion = 0; //总的站点数量
    static {
    	
    	Scanner sc = null;
		try {
			sc = new Scanner(new File("C:\\Users\\dell\\Desktop\\bjdtxl.txt"));
			String str = null;
			while (sc.hasNext()) {
			      str = sc.next();
			      list.add(str);
		        }	        
//		        return list;
			
            
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} 
    	
        String pathname = "C:\\Users\\dell\\Desktop\\bjdtxl.txt";
   
        
        try (FileReader reader = new FileReader(pathname);
             BufferedReader br = new BufferedReader(reader) 
        ) {
            String line;
            int flag=1;
            while ((line = br.readLine()) != null) {
                if(flag==1){
                String line1Str =line;
                String[] line1Arr = line1Str.split(" ");
                for(String s : line1Arr){
                    if(line1.size()!=0){
                    Station station=new Station(s);
                    station.setLine(line1.get(0).getName());
                    line1.add(station);
                    }
                    else
                    line1.add(new Station(s));
                }
                for(int i =0;i<line1.size();i++){
                    if(i<line1.size()-1){
                        line1.get(i).next = line1.get(i+1);
                        line1.get(i+1).prev = line1.get(i);
                    }
                }
                flag++;
            }
                else if(flag==2){
                    String line2Str =line;
                    String[] line2Arr = line2Str.split(" ");
                    for(String s : line2Arr){
                        if(line2.size()!=0){
                            Station station=new Station(s);
                            station.setLine(line2.get(0).getName());
                            line2.add(station);
                        }
                        else
                            line2.add(new Station(s));
                    }
                    for(int i =0;i<line2.size();i++){
                        if(i<line2.size()-1){
                            line2.get(i).next = line2.get(i+1);
                            line2.get(i+1).prev = line2.get(i);
                        }
                    }
                    flag++;
                }
                else if(flag==3){
                    String line4Str =line;
                    String[] line4Arr = line4Str.split(" ");
                    for(String s : line4Arr){
                        if(line4.size()!=0){
                            Station station=new Station(s);
                            station.setLine(line4.get(0).getName());
                            line4.add(station);
                        }
                        else
                            line4.add(new Station(s));
                    }
                    for(int i =0;i<line4.size();i++){
                        if(i<line4.size()-1){
                            line4.get(i).next = line4.get(i+1);
                            line4.get(i+1).prev = line4.get(i);
                        }
                    }
                    flag++;
                }
                else if(flag==4){
                    String line5Str =line;
                    String[] line5Arr = line5Str.split(" ");
                    for(String s : line5Arr){
                        if(line5.size()!=0){
                            Station station=new Station(s);
                            station.setLine(line5.get(0).getName());
                            line5.add(station);
                        }
                        else
                            line5.add(new Station(s));
                    }
                    for(int i =0;i<line5.size();i++){
                        if(i<line5.size()-1){
                            line5.get(i).next = line5.get(i+1);
                            line5.get(i+1).prev = line5.get(i);
                        }
                    }
                    flag++;
                }
                else if(flag==5){
                    String line6Str =line;
                    String[] line6Arr = line6Str.split(" ");
                    for(String s : line6Arr){
                        if(line6.size()!=0){
                            Station station=new Station(s);
                            station.setLine(line6.get(0).getName());
                            line6.add(station);
                        }
                        else
                            line6.add(new Station(s));
                    }
                    for(int i =0;i<line6.size();i++){
                        if(i<line6.size()-1){
                            line6.get(i).next = line6.get(i+1);
                            line6.get(i+1).prev = line6.get(i);
                        }
                    }
                    flag++;
                }  
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
 
        lineSet.add(line1);
        lineSet.add(line2);
        lineSet.add(line4);
        lineSet.add(line5);
        lineSet.add(line6);
      
        totalStaion  = line1.size() + line2.size() + line4.size() + line5.size() + line6.size() ;
    }

//    public static void main(String[] args) throws BaseException {
//    	
//    	data d=new data();
//    	d.getdtxl();
//    	for(int i = 0;i < list.size();i++){
//    	    System.out.println(list.get(i));
//    	}
////    	System.out.print("");
//    }
 
}