/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package my.mahoutsandbox.nb;

import java.util.List;
import my.mahoutsandbox.app.IrisModel;
import my.mahoutsandbox.app.myModel;
import my.mahoutsandbox.util.MahoutUtils;
import my.mahoutsandbox.util.MyDataLoader;
import org.apache.mahout.classifier.df.data.Data;
import org.apache.mahout.classifier.df.data.DataLoader;
import org.apache.mahout.classifier.df.data.Dataset;
import org.apache.mahout.classifier.df.data.DescriptorException;
import org.apache.mahout.classifier.df.split.RegressionSplit;
import org.apache.mahout.classifier.df.split.Split;
import org.apache.mahout.classifier.naivebayes.NaiveBayesModel;
import org.apache.mahout.classifier.naivebayes.StandardNaiveBayesClassifier;
import org.apache.mahout.classifier.sgd.CrossFoldLearner;
import org.apache.mahout.classifier.sgd.PriorFunction;
import org.apache.mahout.classifier.sgd.UniformPrior;
import org.apache.mahout.common.RandomUtils;
import org.apache.mahout.math.DenseVector;
import org.apache.mahout.math.Vector;

/**
 *
 * @author gopi
 */
public class IrisNb extends IrisModel implements myModel{

    public void process(){
        int numcategories = this.irisdataset.nblabels();
        int numfeatures = this.irisdataset.nbAttributes();
        /**
         * Train a model
         */
        List<Vector> trainVectors = MahoutUtils.dataToDenseVectors(this.irisdataset, this.irisTrain);
        
        
        
    }
}
