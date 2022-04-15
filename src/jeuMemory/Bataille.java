package jeuMemory;

public class Bataille extends Action{
    //Attributs
    private Joueur adversaire;
    
  //Constructeurs avec paramétres
    public Bataille(Joueur sc, Joueur a) {
        super(sc, "Bataille");//appelle aux constructeurs de la classe ancêtre ici (Action)
        //initialisation de l'attributs
        this.adversaire = a; 
    }
     
    //Methode execute
    @Override
    //Rédefiniton de la methode execute
    public int execute() {
        int res=0;
        Personnage c1=new Personnage();     //On initialise le personnage 1
        Personnage c2=new Personnage();     //On initialise le personnage 2
        if(super.getJ().getPaquet().getTaille()>0 && this.adversaire.getPaquet().getTaille()>0) {   //Si le paquet du joueur est positif et que le paquet de l'adversaire est positif
            res=-1;                                                             //res vaut -1
            c1=super.getJ().getPaquet().getPerso(0);                            //c1 prends la valeur du personnage à l'indice 0 du joueur
            c2=this.adversaire.getPaquet().getPerso(0);                         //c2 prends la valeur du personnage à l'indice 0 de l'adversaire
            //On retire les deux personnages de leurs paquets respectifs
            super.getJ().getPaquet().retirePerso(c1);                           
            this.adversaire.getPaquet().retirePerso(c2);
           
            if(c1.getValeur()==c2.getValeur()) {        //Si la valeur des deux cartes est la même, on replace les personnages de leurs paquets respectifs
                res=0;
                super.getJ().getPaquet().ajoutePerso(c1);
                this.adversaire.getPaquet().ajoutePerso(c2);
            }
            else {                                      
                if(c1.getValeur()>c2.getValeur()) {     //Si la valeur de la carte du joueur courant est supérieur à celle de l'adversaire
                    res=1;                  
                    //Le joueur courant a gagné la bataille, il récupère sa carte et celle de son adversaire
                    super.getJ().getPaquet().ajoutePerso(c1);   
                    super.getJ().getPaquet().ajoutePerso(c2);
                }
                else {                                  //Si la valeur de la carte du joueur courant est inférieur à celle de l'adversaire
                     res=2;
                     //L'adversaire a gagné la bataille, il récupère sa carte et celle du joueur courant
                     this.adversaire.getPaquet().ajoutePerso(c1);
                     this.adversaire.getPaquet().ajoutePerso(c2);
                }
            }
        }
        if(super.getJ().getPaquet().getTaille()==0 || this.adversaire.getPaquet().getTaille()==0) { //Si le joueur courant ou l'advairsaire ne possèdent plus de cartes 
            String t;
            //On récupère celui qui n'as plus de cartes, dont on place son pseudo dans la variable t
            if (super.getJ().getPaquet().getTaille()==0)
                t = this.adversaire.getPseudo();    
            else
                t = super.getJ().getPseudo();
            String s = super.getJ().getPseudo() + " a joué contre " + this.adversaire.getPseudo() + " : " + t + " a gagné !";
            super.setDeroulement(s);
        }  
        return res;
    }
}
