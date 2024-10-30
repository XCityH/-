package main.java.com.design.flyweight;

import java.util.*;
/**
 * @notes 享元模式
 * 摘自：2021年11月真题
 */

enum  PieceColor {BLACK,WHITE}   //棋子颜色

class PiecePos{  //棋子位置
    private int x;
    private int y;
    public PiecePos(int a,int b){
        x = a;
        y = b;
    }
    public int getX(){
        return x;
    }
    public int getY(){
        return y;
    }
}

abstract class Piece{  //棋子定义
    protected  PieceColor m_color; // 颜色
    protected  PiecePos m_pos; // 位置
    public Piece(PieceColor color,PiecePos pos){
        m_color = color;
        m_pos = pos;
    }

    public abstract void draw();
}
class BlackPiece extends Piece{
    public BlackPiece(PieceColor color,PiecePos pos){
        super(color,pos);
    };
    public void draw(){
        System.out.println("draw a black piece");
    }
}

class WhitePiece extends Piece{
    public WhitePiece(PieceColor color,PiecePos pos){
        super(color,pos);
    };
    public void draw(){
        System.out.println("draw a white piece");
    }
}

class PieceBoard{
    private static final ArrayList<Piece> m_arrayPiece = new ArrayList();
    private String m_blackName; //黑方名称
    private String m_whiteName; //白方名称

    public PieceBoard(String black,String white){
        this.m_blackName = black;
        this.m_whiteName = white;
    }

    public  void SetPiece(PieceColor color,PiecePos pos){
        Piece piece = null;
        if(color == PieceColor.BLACK){    //放黑子
            piece = new BlackPiece(color,pos); //获取一颗黑子
            System.out.println(m_blackName + "在位置（"+pos.getX()+"."+pos.getY());
            piece.draw();
        }else{
            piece = new WhitePiece(color,pos); //获取一颗黑子
            System.out.println(m_whiteName + "在位置（"+pos.getX()+"."+pos.getY());
            piece.draw();
        }
        m_arrayPiece.add(piece);
    }
}


//public class Flyweight {
//
//}
