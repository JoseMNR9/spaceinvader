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
public class Enemy {
    private Point2D position;
    private int widht=6;
    private int height=2;
    private Bullet bullets[];
    private TextColor color;
    private TextColor backgroundcolor;
    private static int max_bullets = 5;
    private String cartoon[]= {          
            "⣴⡶⢿⡿⢶⣦",
             "⣉⠽⠫⠝⠯⣉"};
    public Enemy(){
       this.position=new Point2D();
       this.bullets = new Bullet[Enemy.max_bullets];
    }
    public Enemy(Point2D position){
       this.position= position;
       this.bullets = new Bullet[Enemy.max_bullets];
    }
    public Enemy(int x, int y){
        this.position= new Point2D(x,y);
        this.bullets = new Bullet[Enemy.max_bullets];
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

    /**
     * @return the bullets
     */
    public Bullet[] getBullets() {
        return bullets;
    }

    /**
     * @param bullets the bullets to set
     */
    public void setBullets(Bullet[] bullets) {
        this.bullets = bullets;
    }
     public void paint(Screen s){
        char c;
        for(int i=0;i<this.height;i++){
            for (int j=0;j<this.getWidht();j++){
               c=this.cartoon[i].charAt(j);
               s.setCharacter(this.getPosition().getX() + j, this.getPosition().getY() + i, new TextCharacter (c, TextColor.ANSI.WHITE, TextColor.ANSI.BLACK));
               
           }
       }
        for(int i=0; i<this.getBullets().length;i++){
           if(this.getBullets()[i] != null){
               this.getBullets()[i].paint(s);
           }
       }
    }
    public void shoot(){
        boolean encontrado=false;
        for(int i=0; i<this.max_bullets && !encontrado;i++){
            if (this.getBullets()[i]==null){
                this.getBullets()[i]= new Bullet(this.position.getX() + this.widht/2, this.position.getY()+2);
                encontrado = true;
            }    
        }
    }
     public void moveBullet(){
        for(int i=0; i<this.getBullets().length;i++){
            if(this.getBullets()[i] != null){
                this.getBullets()[i].moveVertical(1, 0, 24);
               if(this.getBullets()[i].getPosition().getY() >= 22){
                   this.getBullets()[i]=null;
               }
            }
        }
    }
}
