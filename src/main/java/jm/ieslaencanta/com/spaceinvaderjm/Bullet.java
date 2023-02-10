/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jm.ieslaencanta.com.spaceinvaderjm;

import com.googlecode.lanterna.Symbols;
import com.googlecode.lanterna.TextCharacter;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.screen.Screen;

/**
 *
 * @author DAWTarde
 */
public class Bullet {
    private Point2D position;
    private TextColor color;
    private TextColor backgroundcolor;
    private TextCharacter bulletsymbol;
    private static int CUENTER_MAX=30;
    private int counter=CUENTER_MAX;
    
    public Bullet(){
        this.position= new Point2D();
        this.init();
    }
    public Bullet(Point2D position) {
        this.position = position;
        this.init();
    }
    public Bullet(int x, int y){
        this.position= new Point2D(x,y);
        this.init();
    }
    private void init(){
        this.color = TextColor.ANSI.GREEN;
        this.backgroundcolor = TextColor.ANSI.GREEN;
        this.bulletsymbol = TextCharacter.fromCharacter(Symbols.ARROW_UP)[0].withBackgroundColor(this.backgroundcolor);
    }
    public void paint(Screen s){
        s.setCharacter(this.position.getX(), this.position.getY(),this.bulletsymbol);
    }
    public void moveVertical(int incy,int miny, int maxy){
         this.counter--;
        if(this.counter<=0){
            this.counter=CUENTER_MAX;
            if(this.position.getY() + incy >= miny && this.position.getY() + incy < maxy){
            this.position.addy(incy);
            }
        }
    }
}
