package main.java.com.design.facade;

import java.util.*;
/**
 * @notes外观模式 2022年11月软考
 * 
 *  定义：定义一个高层接口，为子系统中的一个接口提供一个一致的外观，从而简化了该子系统的使用
 */

interface Patient{
    public String getName();  //考点
}

interface Disposer{
    public void dispose(Patient patient);  //考点
}

class Registry implements Disposer{  //挂号
    public void dispose(Patient patient){
        System.out.println("register:"+patient.getName());
    }
}

class Doctor implements Disposer{  //医生门诊
    public void dispose(Patient patient){
        System.out.println("register:"+patient.getName());
    }
}

class Pharmacy implements Disposer{  //取药
    public void dispose(Patient patient){
        System.out.println("register:"+patient.getName());
    }
}

class Facade{
    private Patient patient;
    public Facade(Patient patient){
        this.patient = patient;
    }
    public void dispose(){
        Registry registry = new Registry();
        Doctor doctor = new Doctor();
        Pharmacy pharmacy = new Pharmacy();

        registry.dispose(this.patient);
        doctor.dispose(this.patient);
        pharmacy.dispose(this.patient);
    }
}

class ConcretePatient implements  Patient{
    private String name;
    public ConcretePatient(String name){   //构造函数用于初始化
        this.name = name;
    }
    public String getName() {
        return this.name;
    }
}

class FacadeTest {
    public static void main(String[] args){
        Patient patient = new ConcretePatient("测试");    //考点
        Facade f= new Facade(patient); //考点
        f.dispose();        //考点
    }
}
