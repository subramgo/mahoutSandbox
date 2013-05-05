/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package my.mahoutsandbox.util;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import org.apache.mahout.classifier.df.split.Split;

/**
 *
 * @author gopi
 */
public class MyDataLoader {
 
   public static List<String[]> getTestTrainIris(){
       List<String[]> testTrainsplit = null;
       
       return testTrainsplit;
   } 
    
   public static String[] loadIrisStringArray(){
       String[] output ;
       List<Iris> irdata = MyDataLoader.loadIris();
       output = new String[irdata.size()];
       int count=0;
       for(Iris ir:irdata){
           output[count] = ir.toString();
           count++;
       }
       return output;
   }
    
    public static List<Iris> loadIris(){
        List<Iris> irisData = new ArrayList<Iris>();
        String fileName="src/main/resources/data/iris.data";
        try{
        BufferedReader br = new BufferedReader(new FileReader(fileName));
        String line ="";
        Iris irobj = null;
        while( (line=br.readLine()) != null){
            String[] instance = line.split(",");
            irobj = new Iris();
            irobj.setSepalLength(Double.valueOf(instance[0]));
            irobj.setSepalWidth(Double.valueOf(instance[1]));
            irobj.setPetalLength(Double.valueOf(instance[2]));
            irobj.setPetalWidth(Double.valueOf(instance[3]));
            irobj.setIrisName(instance[4]);
            irisData.add(irobj);
        }
            
        }catch(Exception e){
         
        }
        
        
        return irisData;
    }
}
