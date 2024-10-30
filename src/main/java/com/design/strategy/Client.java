package main.java.com.design.strategy;

/**
 * @notes 策略模式
 * 摘自：2023年5月软考真题
 *
 */
enum TYPE {COMMA,DOTS,LINE}
interface  PrintStrategy{
    public void doPrint(Interval val);   //考点
}

class Interval{
    private double lowerBound;
    private double upBound;

    public Interval(double pLower,double pUpper){
        this.lowerBound  = pLower;
        this.upBound = pLower;
    }

    public void printInterval(PrintStrategy ps){
        ps.doPrint(this);   //考点
    }

    public double getLower(){
        return lowerBound;
    }

    public double getUpper() {
        return upBound;
    }
}

class PrintIntervalLine implements PrintStrategy{
    public void doPrint(Interval val){
        System.out.println("["+val.getLower()+"-"+val.getUpper()+"]");
    }
}

class PrintIntervalDots implements PrintStrategy{
    public void doPrint(Interval val){
        System.out.println("["+val.getLower()+"-"+val.getUpper()+"]");
    }
}

class PrintIntervalComma implements PrintStrategy{
    public void doPrint(Interval val){
        System.out.println("["+val.getLower()+"-"+val.getUpper()+"]");
    }
}

public class Client {
    public static  PrintStrategy getStrategy(TYPE type){
        PrintStrategy st = null;
        switch (type){
            case COMMA:
                st = new PrintIntervalComma();   //考点
                break;
            case DOTS:
                st = new PrintIntervalDots();  //考点
                break;
            case LINE:
                st = new PrintIntervalLine();  //考点
                break;
        }

        return st;
    }


    public static void main(String[] args){
        Interval interval = new Interval(1.7,2.1);
        interval.printInterval(getStrategy(TYPE.COMMA));
        interval.printInterval(getStrategy(TYPE.LINE));
        interval.printInterval(getStrategy(TYPE.DOTS));
    }

}
