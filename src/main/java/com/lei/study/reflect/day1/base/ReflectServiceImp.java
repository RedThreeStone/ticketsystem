package com.lei.study.reflect.day1.base;

/**
 * @author Admin
 */
public class ReflectServiceImp implements  ReflectService{
    private  String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    private  int age=10;
    public  ReflectServiceImp(String name){
        this.name=name;
    }
    public  ReflectServiceImp(){

    }
    public  void  sayMyName(String myName){
        if("".equals(myName) || myName==null){
            System.out.println("my name is "+name+";age="+age);
        }else {
            System.out.println("my name is "+myName+";age="+age);
        }
    }
}
