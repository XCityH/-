package main.java.com.design.composite;

import java.util.ArrayList;
import java.util.List;

/**
 * @组合模式
 * 摘自：2021年5月真题
 */

abstract class MenuComponent{
    protected String name;    //考点   使用protected
    public abstract List<MenuComponent> getElement();   //考点  使用抽象关键字  abstract
    public abstract boolean removeComponent(MenuComponent menuComponent);  //考点  使用抽象关键字  abstract
    public abstract boolean addMenuElement(MenuComponent menuComponent);  //考点  使用抽象关键字  abstract
}

class MenuItem extends  MenuComponent{
    public MenuItem(String name){
        this.name  = name;   //考点  调用父类的name 用this去引用
    }
    public boolean removeComponent(MenuComponent menuComponent) {  //考点 当父类定义了抽象方法时，子类必须去实现该方法
        return false;
    }
    public boolean addMenuElement(MenuComponent element){ //考点 当父类定义了抽象方法时，子类必须去实现该方法
        return false;
    }
    public List<MenuComponent> getElement(){  //考点 当父类定义了抽象方法时，子类必须去实现该方法
        return null;
    }
}

class Menu extends  MenuComponent{
    private List<MenuComponent> elementList;   //考点   注意数组类型<MenuComponent>
    public Menu(String name){
        this.name = name;
        this.elementList = new ArrayList<MenuComponent>();
    }
    public boolean addMenuElement(MenuComponent element){
        return elementList.add(element);
    }
    public List<MenuComponent> getElement(){
        return elementList;
    }
    public boolean removeComponent(MenuComponent element) {
        return elementList.remove(element);
    }
}

public class CompositeTest {
    public static void main(String[] args){
        MenuComponent mainMenu  = new Menu("Insert");     //考点 主菜单
        MenuComponent subMenu  = new Menu("Chart");       //考点 子菜单
        MenuComponent element  = new MenuItem("On this sheet"); //考点 子菜单 下的子菜单
        mainMenu.addMenuElement(subMenu);    //考点
        subMenu.addMenuElement(element);
        printMenus(mainMenu);
    }
    private  static void printMenus(MenuComponent ifile){
        List<MenuComponent> children = ifile.getElement();
        if(children == null){
            return ;
        }
        for (MenuComponent element: children) {
            printMenus(element);
        }
    }

}
