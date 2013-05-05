/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package my.mahoutsandbox.util;

import java.util.ArrayList;
import java.util.List;
import org.apache.mahout.classifier.df.data.Data;
import org.apache.mahout.classifier.df.data.Dataset;
import org.apache.mahout.classifier.df.data.Instance;
import org.apache.mahout.math.DenseVector;
import org.apache.mahout.math.Vector;

/**
 *
 * @author gopi
 */
public class MahoutUtils {
 
    public static List<Vector> dataToDenseVectors(Dataset dataset,Data data){
        List<Vector> outputVectorList = new ArrayList<Vector> ();
        /**
         * Number of attributes
         */
        int numattributes = dataset.nbAttributes();
        int numinstances = dataset.nbInstances();
        
        for(int i=0; i< numinstances ; i++){
            Instance instance = data.get(i);
            Vector instanceasvector = MahoutUtils.instanceToDenseVector(dataset, instance);
            outputVectorList.add(instanceasvector);
        }
        
        return outputVectorList;
    }
    /**
     * Return an instance as a dense vector
     * @param dataset
     * @param instance
     * @return 
     */
    public static Vector instanceToDenseVector(Dataset dataset,Instance instance){
        Vector outputVector=null;
        
        /**
         * Number of attributes
         */
        int numattributes = dataset.nbAttributes();
        int labelattribute = dataset.getLabelId();
        /*
         * Cardinality excludes the label attribute
         */
        outputVector = new DenseVector(numattributes-1);
        /**
         * Extract each attribute value to create a vector
         */
        for(int i=0; i < numattributes ; i++){
            if(i != labelattribute)
                outputVector.set(i, instance.get(i));
        }
        
        return outputVector;
    }
    
}
