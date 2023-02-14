/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jm.ieslaencanta.com.spaceinvaderjm;

import com.googlecode.lanterna.TextCharacter;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.screen.Screen;

/**
 *
 * @author DAWTarde
 */
public class Wall {
     private Point2D position;
     private int widht=7;
     private int height=2;
     private char[][] cartoon = {{'⣿','⣿','⣿','⣿','⣿','⣿','⣿'},
                                 {'⣿','⣿','⣿','⣿','⣿','⣿','⣿',}};
     public Wall(){
          this.position=new Point2D();
     }
     public Wall(Point2D position){
         this.position= position;
     }
     public Wall(int x, int y){
         this.position= new Point2D(x,y);
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
    public void paint(Screen s){
         char c;
         for(int i=0;i<this.height;i++){
           for (int j=0;j<this.getWidht();j++){
               c= this.cartoon[i][j];
               s.setCharacter(this.getPosition().getX() + j, this.getPosition().getY() + i, new TextCharacter (c, TextColor.ANSI.WHITE, TextColor.ANSI.BLACK));
               
           }
        }
    }
    public boolean collision(Bullet bullets){
        for(int i=0;i<this.cartoon.length;i++){
            for(int j=0; j<this.cartoon.length;j++){
                if(this.getPosition()==bullets.getPosition()){
                    this.position=null;
                }
            }
        }    
        return true;
    }
}
