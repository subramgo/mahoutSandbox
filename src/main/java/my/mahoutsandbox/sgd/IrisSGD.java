/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package my.mahoutsandbox.sgd;

import java.util.List;
import my.mahoutsandbox.app.IrisModel;
import my.mahoutsandbox.app.myModel;
import my.mahoutsandbox.util.MahoutUtils;
import org.apache.mahout.classifier.df.data.Instance;
import org.apache.mahout.classifier.sgd.CrossFoldLearner;
import org.apache.mahout.classifier.sgd.OnlineLogisticRegression;
import org.apache.mahout.classifier.sgd.PriorFunction;
import org.apache.mahout.classifier.sgd.UniformPrior;
import org.apache.mahout.math.Vector;
/**
 *
 * @author gopi
 */
public class IrisSGD extends IrisModel implements myModel{
    
    public void process() {
       
        int numcategories = this.irisdataset.nblabels();
        int numfeatures = this.irisdataset.nbAttributes();
        /**
         * No regularization is applied to the model
         * UniformPrior does not apply any regularization
         */
        PriorFunction pf = new UniformPrior();
        CrossFoldLearner cflearner = new CrossFoldLearner(5, numcategories, numfeatures-1, pf);
        
        
        /**
         * Train a model
         */
        List<Vector> trainVectors = MahoutUtils.dataToDenseVectors(this.irisdataset, this.irisTrain);
        for (int i = 0; i < this.irisTrain.size(); i++) {
            Instance inst = this.irisTest.get(i);
            double actual = inst.get(4);
            System.out.println("actual = " + actual);
            cflearner.train((int)actual, trainVectors.get(i));
        }
        
        /**
         * Test the model
         */
        List<Vector> testVectors = MahoutUtils.dataToDenseVectors(irisdataset, this.irisTest);
        int errorRate=0;
        for(int i=0; i < this.irisTest.size() ; i++){
            Instance inst = this.irisTest.get(i);
            double actual = inst.get(4);
            Vector prediction = cflearner.classify(testVectors.get(i));
            double probsum=0.0;
            for(int j=0; j < prediction.size() ; j++){
                probsum +=prediction.get(j);
            }
            double category1prediction = 1- probsum;
            double maxprob = prediction.maxValue();
            int maxindex = prediction.maxValueIndex();
            if(maxprob < category1prediction)
                maxindex =0;
            
            
            
            
            
            if(actual != (double)maxindex)
                errorRate++;
            
        }
        System.out.println("Error Rate = " + (double)errorRate/(double)testVectors.size());
     }
    
    public static void main(String[] args){
        IrisSGD sgdobj = new IrisSGD();
        sgdobj.process();
    }
}
