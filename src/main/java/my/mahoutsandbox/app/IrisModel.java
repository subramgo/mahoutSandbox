/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package my.mahoutsandbox.app;

import my.mahoutsandbox.util.MyDataLoader;
import org.apache.mahout.classifier.df.data.Data;
import org.apache.mahout.classifier.df.data.DataLoader;
import org.apache.mahout.classifier.df.data.Dataset;
import org.apache.mahout.classifier.df.data.DescriptorException;
import org.apache.mahout.classifier.df.split.RegressionSplit;
import org.apache.mahout.classifier.df.split.Split;
import org.apache.mahout.common.RandomUtils;

/**
 *
 * @author gopi
 */
public class IrisModel {
    protected   Dataset irisdataset;
    protected Data irisdata;
    protected Data irisTrain;
    protected Data irisTest;
    
    protected String[] rawdata;
    protected CharSequence attributeSequence = "N N N N L";
 
    public IrisModel(){
        init();
    }
    private void init(){
        loadIrisData();
        splitTrainTest();
    }
    
    protected void loadIrisData(){
        try{
        this.rawdata = MyDataLoader.loadIrisStringArray();
        this.irisdataset = DataLoader.generateDataset(this.attributeSequence, false,this.rawdata );
      
        this.irisdata = DataLoader.loadData(irisdataset, this.rawdata);
        }catch(DescriptorException e){
            e.printStackTrace();
        }
    }
    
    protected void splitTrainTest(){
        RegressionSplit rsplit = new RegressionSplit();
        Split sp = rsplit.computeSplit(irisdata, 4);
        
        this.irisTrain = this.irisdata.bagging(RandomUtils.getRandom());
        this.irisTest = this.irisdata.bagging(RandomUtils.getRandom());
    }
 
}
