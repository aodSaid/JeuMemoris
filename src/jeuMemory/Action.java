    
package jeuMemory;

public abstract class Action {
    //Attributs
    private Joueur j; // joueur à l'origine de l'action
    private String descriptif; //nature de l'action
    private String deroulement; // description de ce qui s’est passé durant l’action
    
    //Methode abstraite
    public abstract int execute();
    //constructeurs avec paramétres
    public Action(Joueur sc, String s) {
        //initialisations des attributs de la classe
        this.j=sc;
        this.descriptif=s;
        this.deroulement="";
    }
    
    //Accesseurs
    public Joueur getJ() {
        return j;
    }

    public void setJ(Joueur j) {
        this.j = j;
    }

    public String getDescriptif() {
        return descriptif;
    }

    public void setDescriptif(String descriptif) {
        this.descriptif = descriptif;
    }

    public String getDeroulement() {
        return deroulement;
    }

    public void setDeroulement(String deroulement) {
        this.deroulement = deroulement;
    }
 
 
    public String toString()
    { return "Action effectuée par "+j.getPseudo()+ " : " +descriptif+"\n"+this.deroulement+"\n";}
   }
