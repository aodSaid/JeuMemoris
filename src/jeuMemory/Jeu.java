package jeuMemory;

class Jeu {
    //Attributs
    private LesPersonnages lesPers;  //Personnages utilisés pour les cartes   
    private PlateauJeu monP;         //Le plateau de jeu
    private LesJoueurs lesJ;         //Les joueurs de la partie
    private int indC;                //L'indice du joueur courant
    private Action act;              //L'action que va réaliser le joueur
    
    //constructeurs avec paramétres
    public Jeu(LesPersonnages lp, LesJoueurs lj, int nbc)
    {   //initialisation des attributs de la classe
        this.lesPers=lp;
        this.monP=new PlateauJeu(nbc);
        this.lesJ=lj;
        this.act=null;
        this.indC=0;
    }
    
    //Accesseurs
    public LesPersonnages getLesPers() {
        return lesPers;
    }

    public PlateauJeu getPlateau() {
        return monP;
    }

    public LesJoueurs getLesJ() {
        return lesJ;
    }

    public int getIndC() {
        return indC;
    }

    public Action getAct() {
        return act;
    }

    public void setIndC(int indC) {
        this.indC = indC;
    }
    //methode pour retourner l'indice du joueur suivant
    public int getIndSuivant(int j)
    { return (j+1)%lesJ.getNbJoueurs(); }
    //methode pour retourner le joueur courant
    public Joueur getJoueurCourant()
    {return lesJ.getJoueur(indC);}
    //methode pour retourner le joueur suivant
    public Joueur getJoueurSuivant(int j)
    { return lesJ.getJoueur(getIndSuivant(j)); }
    
    //methode pour marquer la fin du jeu
    public boolean finJeu(){ 
        return monP.jeuVide();
    }
    //methode pour retourner le nombre de joueurs
    public int nbPers()
    {
        int n = 0;//variable de type entier
        // boucle pour parcourir le nombre des joueurs
        for(int i = 0; i < lesJ.getNbJoueurs(); i++)
            if (i !=this.indC)  //verifier si l'indice i est différent du l'indice du joueur courant
                n+=lesJ.getJoueur(i).getNbCartes();//recuperer le nombre de carte du joueur à la position i dans n à chaque tour de boucle
        return n; //retourner n
    }
    
    //methode pour gerer les tour des joueur
    public int traiterTour(Joueur jo, int s)
    {
        int bonus=-1;                                                   //initialisation du bonus à -1
        Personnage pers = this.lesPers.getPerso(s);                     //Récupération du personnage à l'indice s du jeu
        jo.ajoutePersoPaquet(pers);                                     //On ajoute le personnage au paquet du joueur
        String f = pers.getFamille();                                   //On récupère la famille du personnage récupéré
        int npf = this.lesPers.getPersosFamille(f).getTaille();         //Le nombre de personnages de la famille favorite du joueur dans le jeu
            int nbj = jo.getPaquet().getPersosFamille(f).getTaille();       //Le nombre de personnages de la famille favorite du joueur dans son paquet
        if(npf==nbj)                                                    //Si les deux nombres ci-dessus sont égaux
        {
            if(f==jo.getFamille())  //Si la famille du personnage est la même que celle favorite du joueur, le bonus vaut 0 et la partie est terminée
            {
                bonus = 0;
                this.monP.termineJeu();
            }
            else
            {
                int ind = lesJ.getIndiceJoueur(jo); //On récupère l'indice du joueur
                boolean cartes = false;             
                for(int i=0;i<lesJ.getNbJoueurs();i++)  //Pour chaque joueurs de la partie
                {
                    if(i!=ind && lesJ.getJoueur(i).getNbCartes()!=0)    //Si le nombre de cartes du joueur à l'indice i vaut 0 et que i est différent de l'indice du joueur courant
                        cartes=true;                                    //cartes prends la valeur true
                    if(cartes) {                                         //Si la condition précédente est validée
                        if(f.equals("rares") || f.equals("communs"))    //Et que la famille vaut commun ou rares
                            bonus=1;                                    //Le bonus vaut 1
                        else if(f.equals("legendaires") || f.equals("epiques")) //Si la famille vaut légendaire ou epiques
                            bonus=2;                                    //Le bonus vaut 2
                        else                                            //Sinon le bonus vaut 3
                            bonus=3;
                    }
                }
            }
        }
        return bonus;
    }
}
