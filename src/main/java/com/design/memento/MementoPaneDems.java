package main.java.com.design.memento;

import java.util.*;
/**
 * @notes 备忘录模式
 * 摘自：2022年5月软考
 *
 */

class Memento{
    private String state;
    public Memento(String state){
        this.state = state;
    }

    public String getState(){
        return this.state;
    }
}

class Originator {
    private  String state;
    public void setState(String state){
        this.state = state;
    }
    public String getState(){
        return this.state;
    }
    public Memento saveStateToMemento(){
        return  new Memento(this.state);
    }

    public void getStateFromMemento(Memento memento){
        state = memento.getState();
    }

}

class CareTaker{
    private  List<Memento> list = new ArrayList<>();
    public  void add(Memento state){
        list.add(state);
    }

    public Memento get(int index) {
        return list.get(index);
    }
}

class MementoPaneDems {
    public static void main(String[] args) {
        Originator originator = new Originator();
        CareTaker careTaker = new CareTaker();
        originator.setState("state 1");
        originator.setState("state 2");
        careTaker.add(originator.saveStateToMemento());
        originator.setState("state 3");
        careTaker.add(originator.saveStateToMemento());
        originator.setState("state 4");
        System.out.println("CurrentState"+originator.getState());
        originator.getStateFromMemento(careTaker.get(0));
        System.out.println("First saved state"+originator.getState());
        originator.getStateFromMemento(careTaker.get(1));
        System.out.println("second saved state"+originator.getState());
    }
}
