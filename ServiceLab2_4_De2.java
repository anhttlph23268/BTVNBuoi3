
package Service;

import ViewModel.DongVat;
import java.util.ArrayList;


public class ServiceLab2_4_De2 {
    private final ArrayList<DongVat> listDV;
    
    public ServiceLab2_4_De2(){
        this.listDV = new ArrayList<>();
        this.listDV.add(new DongVat("DV1","Động vật 1",1,true,2007));
        this.listDV.add(new DongVat("DV2","Động vật 2",2,false,2006));
        this.listDV.add(new DongVat("DV3","Động vật 3",3,true,2005));
        this.listDV.add(new DongVat("DV4","Động vật 4",4,false,2004));
        this.listDV.add(new DongVat("DV5","Động vật 5",5,true,2003));
    }
    
    public ArrayList<DongVat> getList(){
        return this.listDV;
    }
    
    public ArrayList<DongVat> getListSearchByName(String name){
        ArrayList<DongVat> ldv = new ArrayList<>();
        for (DongVat dv : this.listDV) {
            if(dv.getTenDv().equals(name)){
              ldv.add(dv);
              break;
            }
        }
        return ldv;
    }
    
     public ArrayList<DongVat> getListSearch(int max, int min){
        ArrayList<DongVat> ldv = new ArrayList<>();
        for (DongVat dv : this.listDV) {
            if(dv.getCanNang() > (min -1) && dv.getCanNang() < (max + 1)){
              ldv.add(dv);
            }
        }
        return ldv;
    }
    
    public void addList(DongVat dv){
            this.listDV.add(dv);
    }
    
    
}
