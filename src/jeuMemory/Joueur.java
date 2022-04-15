package jeuMemory;

import javax.swing.*;

public class Joueur {
    private String pseudo;
    private String famille;
    private LesPersonnages paquet;
    private ImageIcon photo;
    
    public Joueur(){
        this.pseudo="anonyme";
        this.famille="anonyme";
        this.paquet=new LesPersonnages();
        this.photo=new ImageIcon(getClass().getResource("/jeuMemory/img/anonyme.png"));
    }   
    public Joueur(String pseudo,String famille){
        this.pseudo=pseudo;
        this.famille=famille;
        this.paquet=new LesPersonnages();
        this.photo=new ImageIcon(getClass().getResource("/jeuMemory/img/anonyme.png"));
    }
    public String getPseudo(){
    return this.pseudo;
    }     
    public int getNbCartes() { 
        return this.paquet.getTaille();  
    }
    public String getFamille(){
    return this.famille;
    }  
    public LesPersonnages getPaquet(){
    return this.paquet;
    }
    public ImageIcon getPhoto(){
    return this.photo;
    }
     public void setPseudo(String pseudo){
    this.pseudo=pseudo;
    }     
    public void setFamille(String famille){
    this.famille=famille;
    }  
    public void setPaquet(LesPersonnages paquet){
    this.paquet=paquet;
    }
    public void setPhoto(ImageIcon photo){
    this.photo=photo;
    }
   
     public String toString() {
        String res= "Joueur " + this.pseudo +" "+
                "\nfamille préférée : "+ famille +
                "\nen possession des personnages :\n" + paquet
                + "\nscore : "+this.getScore();
        return res;
    }
     
    public int getScore(){       
    return this.getPaquet().getScore();
    }
    
    
    
    public void ajoutePersoPaquet(Personnage p) {
        this.paquet.ajoutePerso(p);
    }
    public void initPaquetTest(){       //Utilisé pour des tests dans le développement du jeu (à conserver en cas de besoin)
        ajoutePersoPaquet(new Personnage("communs","assault-trooper", 10));
        ajoutePersoPaquet(new Personnage("communs", "commando", 20));
        ajoutePersoPaquet(new Personnage("rares", "absolute-zero", 10));
    }
}
    
    
    
    
    

