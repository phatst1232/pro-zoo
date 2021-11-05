/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package animalpkg;

/**
 *
 * @author phats
 */
public class AnimalType {
    public static final int ZLA=1, BFLA=2, BFA=3,FLA=4;
    int typeCode;
    String desc;
    int numLegs;
    int numWings;
    String movingMethod;
    boolean canFly;
    boolean canSing;
    boolean canGrowl;
    String food;
    double maxWeight;

    public AnimalType(int typeCode, String desc, int numLegs, int numWings, String movingMethod, boolean canFly, boolean canSing, boolean canGrowl, String food, double maxWeight) {
        this.typeCode = typeCode;
        this.desc = desc;
        this.numLegs = numLegs;
        this.numWings = numWings;
        this.movingMethod = movingMethod;
        this.canFly = canFly;
        this.canSing = canSing;
        this.canGrowl = canGrowl;
        this.food = food;
        this.maxWeight = maxWeight;
    }

    public int getTypeCode() {
        return typeCode;
    }

    public void setTypeCode(int typeCode) {
        this.typeCode = typeCode;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public int getNumLegs() {
        return numLegs;
    }

    public void setNumLegs(int numLegs) {
        this.numLegs = numLegs;
    }

    public int getNumWings() {
        return numWings;
    }

    public void setNumWings(int numWings) {
        this.numWings = numWings;
    }

    public String getMovingMethod() {
        return movingMethod;
    }

    public void setMovingMethod(String movingMethod) {
        this.movingMethod = movingMethod;
    }

    public boolean isCanFly() {
        return canFly;
    }

    public void setCanFly(boolean canFly) {
        this.canFly = canFly;
    }

    public boolean isCanSing() {
        return canSing;
    }

    public void setCanSing(boolean canSing) {
        this.canSing = canSing;
    }

    public boolean isCanGrowl() {
        return canGrowl;
    }

    public void setCanGrowl(boolean canGrowl) {
        this.canGrowl = canGrowl;
    }

    public String getFood() {
        return food;
    }

    public void setFood(String food) {
        this.food = food;
    }

    public double getMaxWeight() {
        return maxWeight;
    }

    public void setMaxWeight(double maxWeight) {
        this.maxWeight = maxWeight;
    }

    @Override
    public String toString() {
        return "AnimalType{" + "desc=" + desc + ", numLegs=" + numLegs + ", numWings=" + numWings + ", movingMethod=" + movingMethod + ", canFly=" + canFly + ", canSing=" + canSing + ", canGrowl=" + canGrowl + ", food=" + food + ", maxWeight=" + maxWeight + '}';
    }
    
    
}
