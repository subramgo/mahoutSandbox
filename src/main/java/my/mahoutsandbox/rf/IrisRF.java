/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package my.mahoutsandbox.rf;

import java.util.Random;
import my.mahoutsandbox.app.IrisModel;
import my.mahoutsandbox.app.myModel;
import org.apache.mahout.classifier.df.DecisionForest;
import org.apache.mahout.classifier.df.builder.DefaultTreeBuilder;
import org.apache.mahout.classifier.df.data.Instance;
import org.apache.mahout.classifier.df.ref.SequentialBuilder;
import org.apache.mahout.common.RandomUtils;
import org.uncommons.maths.Maths;

/**
 * Implements Random Forest Algorithm
 * on Iris data set
 * @author gopi
 */
public class IrisRF extends IrisModel implements myModel{

    public IrisRF() {
        super();
    }

    public void process() {

        int m = (int) Math.floor(Maths.log(2, this.irisdata.getDataset().nbAttributes()) + 1);
        int numberTrees = 5;
        Random rng = RandomUtils.getRandom();
        DefaultTreeBuilder treeBuilder = new DefaultTreeBuilder();
        SequentialBuilder foresBuilder = new SequentialBuilder(rng, treeBuilder, irisTrain.clone());
        treeBuilder.setM(m);

        DecisionForest dforest = foresBuilder.build(5);

        int numberCorrect = 0;
        for (int i = 0; i < this.irisTest.size(); i++) {
            Instance inst = this.irisTest.get(i);
            double actual = inst.get(4);
            //System.out.println("actual = " + actual);
            int actuallabel = this.irisdataset.valueOf(4, String.valueOf((int) actual));
            //System.out.println("actuallabel = " + actuallabel);
            double classify = dforest.classify(irisdataset, rng, inst);
            //System.out.println("classify = " + classify);
            int predictedlabel = this.irisdataset.valueOf(4, String.valueOf((int) classify));
            //System.out.println("Predicted Label = " + predictedlabel);

            if (actuallabel == predictedlabel) {
                numberCorrect++;
            }

        }
        System.out.println("Success rate =" + (double) numberCorrect / (double) this.irisTest.size());
    }

    public static void main(String[] args) {
        IrisRF objrf = new IrisRF();
        objrf.process();

    }
}
