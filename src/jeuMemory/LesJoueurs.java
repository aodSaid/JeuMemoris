package jeuMemory;

import java.util.ArrayList;

public class LesJoueurs {
    private ArrayList<Joueur> lstJ;

    
    
    public LesJoueurs() {
      this.lstJ = new ArrayList<Joueur>();
    }
    
    public Joueur getJoueur(int i){
        if (i>=0 && i<this.lstJ.size())
             return this.lstJ.get(i);
        else return null;
    }
     
    public int getIndiceJoueur(Joueur j){        
            return this.lstJ.indexOf(j);
        }
 
    public int getNbJoueurs(){
        return this.lstJ.size();
    }
    public void ajouteJoueur (Joueur j){
         this.lstJ.add(j);
    }
    
    public void ajouteJoueurs(LesJoueurs lj)
    {
        for(int i=0;i<lj.getNbJoueurs();i++)
        {
            this.lstJ.add(lj.getJoueur(i));
        }       
    }
             
    public Joueur rechJoueur(String s){
        Joueur j;
        int ind=0;
        for(int i=0;i<this.lstJ.size();i++)                 //Pour chaque joueurs
        {  
            if(s.equals(this.getJoueur(i).getPseudo()))     //Si le joueur à l'indice i à le même pseudo que celui en paramètre
                {
                    j=this.getJoueur(i);                    //On récupère ce joueur
                    ind=i;
                }                 
        }
        if(s.equals(this.getJoueur(ind).getPseudo()))       //Si le joueur à l'indice ind à le même pseudo que celui en paramètre
            return this.getJoueur(ind);                     //On retourne ce joueur
        else                                                //Sinon
            return null;                                    //On retourne null
    }

    public void supprimeJoueur(Joueur j){ 
    String s=j.getPseudo();
        for(int i=0;i<this.lstJ.size();i++)                 //Pour chaque joueurs
            if(s.equals(this.getJoueur(i).getPseudo()))     //Si le joueur à l'indice i à le même pseudo que celui en paramètre
                    this.lstJ.remove(i);                    //Alors il est supprimé
    }
    
    public String toString() {
       
        String res="";
        for(int i=0; i<this.getNbJoueurs();i++)
            res+=(i+1)+" "+this.getJoueur(i)+"\n";
        return res;
    }

    public LesJoueurs getGagnants(){  
        LesJoueurs lst=new LesJoueurs();                //On initialise une liste de gagnants 
        int max=getJoueur(0).getScore();                //On initialise le score max à celui du joueur à l'indice 0
                                                    //On va chercher à déterminer le meilleur score parmis tous les joueurs
        for(int i=1; i<getNbJoueurs();i++)              //Pour chaque joueurs de la partie
            if (getJoueur(i).getScore()>max)            //Si son score est supérieur au maximum
                max=this.getJoueur(i).getScore();       //Son score prends la valeur du maximum
                                                    //On va enfin déterminer quels joueurs ont obtenus ce score (permet de gérer les égalités)
        for(int i=0; i<getNbJoueurs();i++)              //Pour chaque joueurs de la partie
            if (getJoueur(i).getScore()==max)           //Si son score est égal au maximum
                lst.ajouteJoueur(getJoueur(i));         //Il est ajouté à la liste des gagnants
        
        return lst;
    }
}
     
     
     



