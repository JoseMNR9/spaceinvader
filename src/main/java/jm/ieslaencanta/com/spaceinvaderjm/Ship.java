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
    private int widht=7;
    private int height=2;
    private Bullet bullets[];
    private TextColor color;
    private TextColor backgroundcolor;
    private static int max_bullets = 3;
    private String cartoon[]={
         " ⢀⣀⣾⣷⣀⡀ ",
          " ⣿⣿⣿⣿⣿⣿ "
    };
    public Ship(){
       this.position=new Point2D();
       this.bullets = new Bullet[Ship.max_bullets];
       //this.init();
    }
    public Ship(Point2D position){
        this.position = position;
        this.bullets = new Bullet[Ship.max_bullets];
        //this.init();
    }
    public Ship(int x, int y){
        this.position= new Point2D(x,y);
        this.bullets = new Bullet[Ship.max_bullets];
        //this.init();
    }

    /**
     * @return the position
     */
    public Point2D getPosition() {
        return position;
    }

    /**
     * @param position the position to set
     */
    public void setPosition(Point2D position) {
        this.position = position;
    }

    /**
     * @return the widht
     */
    public int getWidht() {
        return widht;
    }

    /**
     * @param widht the widht to set
     */
    public void setWidht(int widht) {
        this.widht = widht;
    }

   
    /*private void init() {
        this.color = TextColor.ANSI.GREEN;
        this.backgroundcolor = TextColor.ANSI.BLACK;
        this.bullets = new Bullet[Ship.max_bullets];
    }
    */
    public void moveHorizontal(int incx,int minx, int maxx){
        if (this.getPosition().getX() + incx - this.getWidht() / 2 >= minx && this.getPosition().getX() + incx + this.getWidht() / 2 < maxx){
            this.getPosition().addx(incx);
        } else {
                Toolkit.getDefaultToolkit().beep();
            }

    }
    public void paint(Screen s){
        char c;
       for(int i=0;i<this.height;i++){
           for (int j=0;j<this.getWidht();j++){
               c= this.cartoon[i].charAt(j);
               s.setCharacter(this.getPosition().getX() + j, this.getPosition().getY() + i, new TextCharacter (c, TextColor.ANSI.WHITE, TextColor.ANSI.BLACK));
               
           }
       }
       for(int i=0; i<this.bullets.length;i++){
           if(this.bullets[i] != null){
               this.bullets[i].paint(s);
           }
       }
    }
    public void shoot(){
        boolean encontrado=false;
        for(int i=0; i<this.max_bullets && !encontrado;i++){
            if (this.bullets[i]==null){
                this.bullets[i]= new Bullet(this.position.getX() + this.widht/2, this.position.getY()-1);
                encontrado = true;
            }    
        }
    }
    public void moveBullet(){
        for(int i=0; i<this.bullets.length;i++){
            if(this.bullets[i] != null){
               this.bullets[i].moveVertical(-1, 0, 24);
               if(this.bullets[i].getPosition().getY()<=0){
                   this.bullets[i]=null;
               }
            }
        }
    }
}
