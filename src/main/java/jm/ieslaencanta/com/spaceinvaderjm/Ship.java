/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jm.ieslaencanta.com.spaceinvaderjm;

import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TextCharacter;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.screen.Screen;
import java.awt.Toolkit;

/**
 *
 * @author DAWTarde
 */
public class Ship {
    private Point2D position;
    private int widht;
    private int height;
    private Bullet bullets[];
    private TextColor color;
    private TextColor backgroundcolor;
    private static int max_bullets = 3;
    public Ship(){
       this.position=new Point2D();
       this.bullets = new Bullet[Ship.max_bullets];
       this.init();
    }
    public Ship(Point2D position){
        this.position = position;
        this.bullets = new Bullet[Ship.max_bullets];
        this.init();
    }
    public Ship(int x, int y){
        this.position= new Point2D(x,y);
        this.bullets = new Bullet[Ship.max_bullets];
        this.init();
    }

   
    private void init() {
        this.color = TextColor.ANSI.GREEN;
        this.backgroundcolor = TextColor.ANSI.BLACK;
        this.bullets = new Bullet[Ship.max_bullets];
    }
    
    public void moveHorizontal(int incx,int minx, int maxx){
        if (this.position.getX() + incx - this.widht / 2 >= minx && this.position.getX() + incx + this.widht / 2 < maxx){
            this.position.addx(incx);
        } else {
                Toolkit.getDefaultToolkit().beep();
            }

    }
    public void paint(Screen s){
       for(int i=0;i<this.height;i++){
           for (int j=0;j<this.widht;j++){
               s.setCharacter(this.position.getX(), this.position.getY());
           }
       }
    }

}
