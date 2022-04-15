package jeuMemory;

import java.awt.Image;
import javax.swing.*;


public class Personnage {
    private String famille;
    private String nom;
    private int valeur;
    private Image photo;
   
    
    public Personnage(){
        this.famille="anonyme";
        this.nom="anonyme";
        this.valeur=0;
        this.photo=new ImageIcon(getClass().getResource("/jeuMemory/img/anonyme.png")).getImage();
        
    }
    public Personnage(String famille,String nom, int valeur){
        this.famille=famille;
        this.nom=nom;
        this.valeur=valeur;
        this.photo=new ImageIcon(getClass().getResource("/jeuMemory/img/"+nom+".jpg")).getImage();
    }
    public void setFamille(String famille){
        this.famille=famille;
    }
     public void setNom(String nom){
        this.nom=nom;
    }
     
    public void setValeur(int valeur){     
        this.valeur=valeur;
    }
    
    public String getFamille(){
        return this.famille;
    }
    public String getNom(){
        return this.nom;
    }
    public int getValeur(){
        return this.valeur;
    }
    public String toString(){
        String s="";
        s+="\n famille:"+this.famille+"\n nom:"+nom+"\n valeur:"+valeur;
        return s;
    }
    
    
    public Image getPhoto(){
        return this.photo;
    }
    
    
    
}
