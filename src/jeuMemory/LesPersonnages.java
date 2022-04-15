package jeuMemory;

import java.util.ArrayList;


public class LesPersonnages {
    
    private ArrayList<Personnage> persos;

    public ArrayList<Personnage> getPersos() {
        return persos;
    }
    
    public LesPersonnages() {
      this.persos = new ArrayList<Personnage>();
     }
         
     public int getTaille() { 
         return this.persos.size(); 
     }
     
    public int getScore(){   
        int sc = 0;
        for(int i=0; i<getTaille(); i++)    //Pour chaque personnage
           sc+=getPerso(i).getValeur();     //On ajoute au score précédent la valeur du personnage à l'indice i
        return sc;
    }
    
    public ArrayList getFamilles() {
    ArrayList<String> l= new ArrayList <String>();      //On initialise une ArrayList
    boolean ok=false;
        for(int i=0; i<this.getTaille(); i++)           //Pour chaque personnage
        {
            ok=false;                                   //Ok est défini sur false
            for(int j=0; j<l.size();j++) {              //Pour chaque personnage de l'ArrayList
                if(getPerso(i).getFamille().equals(l.get(j))) //Si le pesonnage à l'indice i de la liste de personnages à la même famille que celui à l'indice j de l'ArrayList créée ci-dessus
                    ok=true;                            //Ok prends la valeur true (c'est à dire, la famille est déja présente dans l'arrayList l)
            }              
            if (ok==false)                              //Si la famille du personnage à l'indice i n'est pas dans l'ArrayList l                 
                l.add(getPerso(i).getFamille());        //On ajoute cette famille à l'ArrayList l
        }
    return l;                                           //On return la liste des familles existantes
    }
    
    public Personnage getPerso(int i){
        if (i>=0 && i<this.persos.size())
             return this.persos.get(i);
        else return null;
    }
    
    public LesPersonnages getPersosFamille(String f)
    {   LesPersonnages lp = new LesPersonnages();   //On initialise une liste de personnage
        for(int i=0; i<getTaille(); i++)            //Pour chaque personnage
            if(getPerso(i).getFamille().equals(f))  //Si la famille du personnage est égale à la famile placée en paramètre
                lp.ajoutePerso(getPerso(i));        //Alors on l'ajoute à la liste de personnages
        return lp;
    }
    
    public void retirePerso(Personnage p)
    { 
        int i=0; 
        boolean trouve = false;
        while(i<getTaille() && !trouve){    //Tant qu'il y a un personnage à l'indice i et que le personnage n'as pas été trouvé
          if (getPerso(i).getNom().equals(p.getNom())){ //Si le personnage à l'indice i a le même nom que celui en paramètre
              this.persos.remove(i);                    //On le retire
              trouve = true;                            //trouve prends la valeur true
          } 
          else i++;                                     //Sinon on passe à l'indice suivant
        }      
    }
    
   public LesPersonnages retirePersos(int n)
    { LesPersonnages lcr = new LesPersonnages();
        for (int i=0; i<=n; i++)
        {
            lcr.ajoutePerso(getPerso(0));
            this.persos.remove(0);  
        }
        return lcr;
    } 
    
    public LesPersonnages retirePersosFamille(String f)
    { 
        LesPersonnages lcr = new LesPersonnages();
        int i = 0;
        while(i<getTaille()){
            if (getPerso(i).getFamille().equals(f)) {
                lcr.ajoutePerso(getPerso(i));
                this.persos.remove(i);  
            }
            else i++;
        }
        return lcr;
    }
     
    public void retireCartes()
    { 
           persos.clear();
    }
    
	@Override
    public String toString() {
        String s = "";
        for(int i=0; i<getTaille(); i++)
            s+=i+"- "+getPerso(i).toString();
       return s;
    }
    //Constructeur avec paramètres
    public LesPersonnages(int nc) {
        this.persos = new ArrayList<Personnage>();
        if (nc >= 4){ // 2 familles (correspond à la difficulté enfant)
            ajoutePerso(new Personnage("communs", "assault-trooper", 10));
            ajoutePerso(new Personnage("communs", "commando", 20));
            ajoutePerso(new Personnage("rares", "absolute-zero", 10));
            ajoutePerso(new Personnage("rares", "arctice-assassin", 20));
        }
        if (nc >= 10){ // 4 familles (correspond à la difficulté débutant)
            ajoutePerso(new Personnage("communs", "devestrator", 30));
            ajoutePerso(new Personnage("rares", "brawler", 30));
            ajoutePerso(new Personnage("alpins-femmes", "mogul-master", 10));
            ajoutePerso(new Personnage("alpins-femmes", "mogul-master-can", 20));
            ajoutePerso(new Personnage("as-des-pistes", "alpine-ace", 10));
            ajoutePerso(new Personnage("as-des-pistes", "alpine-ace-can", 20));
        }
        if (nc >= 18){ // 4 familles (correspond à la difficulté avancé)

            ajoutePerso(new Personnage("alpins-femmes", "mogul-master-chn", 30));
            ajoutePerso(new Personnage("as-des-pistes", "alpine-ace-chn", 30));
            ajoutePerso(new Personnage("legendaires", "power-chord", 10));
            ajoutePerso(new Personnage("legendaires", "raptor", 20));
            ajoutePerso(new Personnage("legendaires", "raven", 30));
            ajoutePerso(new Personnage("epiques", "burnout", 10));
            ajoutePerso(new Personnage("epiques", "funk-ops", 20));
            ajoutePerso(new Personnage("epiques", "rex", 30));
        }
        if (nc == 32){ // 6 familles (correspond à la difficulté expert)
            ajoutePerso(new Personnage("communs", "dominator", 40));
            ajoutePerso(new Personnage("communs", "highrise-assault-trooper", 50));
            ajoutePerso(new Personnage("communs", "jungle-scout", 60));
            ajoutePerso(new Personnage("communs", "pathfinder", 70));
            ajoutePerso(new Personnage("rares", "brilliant-striker", 40));
            ajoutePerso(new Personnage("rares", "brite-bomber", 50));
            ajoutePerso(new Personnage("rares", "circuit-breaker", 60));
            ajoutePerso(new Personnage("rares", "dazzle", 70));
            ajoutePerso(new Personnage("alpins-femmes", "mogul-master-fra", 40));
            ajoutePerso(new Personnage("alpins-femmes", "mogul-master-gbr", 50));
            ajoutePerso(new Personnage("as-des-pistes", "alpine-ace-fra", 40));
            ajoutePerso(new Personnage("as-des-pistes", "alpine-ace-gbr", 50));
            ajoutePerso(new Personnage("legendaires", "red-knight", 40));
            ajoutePerso(new Personnage("epiques", "shadow-ops", 40));
        }
    }
    
   public void ajoutePerso (Personnage p){
   
   this.persos.add(p);
   }
   public void ajoutePersos (LesPersonnages lp){
   for(int i=0;i<lp.getTaille();i++){
   
   this.persos.add(lp.getPerso(i));
   
   }
       
   } 
    
}

