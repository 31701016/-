package cn.edu.zucc.personplan.ui;

import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;
 
 
public class Station {
 
    private String name;
    public Station prev; 
    public Station next;
    public String line;//存放该站为几号线
    private Map<Station,LinkedHashSet<Station>> orderSetMap = new HashMap<Station,LinkedHashSet<Station>>();
 
    public Station (String name){
        this.name = name;
        this.line = name;
    }
 
    public String getName() {
        return name;
    }
 
    public void setName(String name) {
        this.name = name;
 
    }
 
    public LinkedHashSet<Station> getAllPassedStations(Station station) {
        if(orderSetMap.get(station) == null){
            LinkedHashSet<Station> set = new LinkedHashSet<Station>();
            set.add(this);
            orderSetMap.put(station, set);
        }
        return orderSetMap.get(station);
    }
 
    public Map<Station, LinkedHashSet<Station>> getOrderSetMap() {
        return orderSetMap;
    }
 
    @Override
    public boolean equals(Object obj) {
        if(this == obj){
            return true;
        } else if(obj instanceof Station){
            Station s = (Station) obj;
            if(s.getName().equals(this.getName())){
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }
 
    @Override
    public int hashCode() {
        return this.getName().hashCode();
    }
    public void setLine(String station){
        this.line=station;
    }
    public String getline(){
        return this.line;
    }
}
