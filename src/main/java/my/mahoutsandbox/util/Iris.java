/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package my.mahoutsandbox.util;

/**
 *
 * @author gopi
 */
public class Iris {
    double sepalLength;
    double sepalWidth;
    double petalLength;
    double petalWidth;
    String irisName;

    public String getIrisName() {
        return irisName;
    }

    public void setIrisName(String irisName) {
        this.irisName = irisName;
    }

    public double getPetalLength() {
        return petalLength;
    }

    public void setPetalLength(double petalLength) {
        this.petalLength = petalLength;
    }

    public double getPetalWidth() {
        return petalWidth;
    }

    public void setPetalWidth(double petalWidth) {
        this.petalWidth = petalWidth;
    }

    public double getSepalLength() {
        return sepalLength;
    }

    public void setSepalLength(double sepalLength) {
        this.sepalLength = sepalLength;
    }

    public double getSepalWidth() {
        return sepalWidth;
    }

    public void setSepalWidth(double sepalWidth) {
        this.sepalWidth = sepalWidth;
    }

    @Override
    public String toString() {
        return this.sepalLength + "," + this.sepalWidth
                + "," + this.petalLength + "," +
                this.petalWidth + "," + this.irisName;
    }
    
    
}
