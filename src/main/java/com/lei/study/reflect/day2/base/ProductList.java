package com.lei.study.reflect.day2.base;
/**订阅-观察者模式,主要类Observable,需要单例产品
 * @author Admin
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

public class ProductList extends Observable{
    private  static List<String> products = null;
    private  static ProductList productList;
    private  ProductList(){

    }
    public static ProductList getInstance(){
        if(productList==null){
            synchronized (ProductList.class){
                if(productList==null){
                    productList = new ProductList();
                    products=new ArrayList<>();
                }
            }
        }
        return  productList;
    }
    public void addProductObserver(Observer observer){
        addObserver(observer);
    }
    public void addProduct(String productName){
        products.add(productName);
        System.out.println("增加了一个产品:"+productName);
        setChanged();
        notifyObservers(productName);

    }
}
