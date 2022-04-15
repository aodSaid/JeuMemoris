package jeuMemory;

public class Transfert extends Action {
    //Attributs
    private Joueur cible;   //Joueur cible
    private String fp;      //Famille séléectionnée nommée
    private LesPersonnages cartesTransferees;
    
    //Constructeurs avec paramétres
    public Transfert(Joueur sc, Joueur cible, String fp){ 
        super(sc,"Transfert de cartes");//appelle aux constructeurs de la classe ancêtre ici (Action)
        //initialisation des attributs de la classe
        this.cible=cible;
        this.fp=fp;
        cartesTransferees = null;
    }
    @Override
    //Rédefinition de la methode execute
    public int execute() {
        if (!fp.equals(null)) //condition pour vérifier la séléction est differente de null
        {   
            //affectation du ou des cartes correspondant au nom de la famille aux cartes à transferer
            cartesTransferees = cible.getPaquet().getPersosFamille(fp);
            //retirer les cartes au joueur ciblé
            cible.getPaquet().retirePersosFamille(fp);     
            //ajout des cartes aux joueur courant
            super.getJ().getPaquet().ajoutePersos(cartesTransferees);
            //le deroulement de l'action
            super.setDeroulement(super.getJ().getPseudo() + " a récupéré les cartes de la famille " + fp + " à " + cible.getPseudo());
            //retourner la taille des cartes transferées
            return cartesTransferees.getTaille();
        }
        else
            return 0;
    }
    
    //Accesseurs
    public Joueur getJoueurCible() {
        return cible;
    }
    
    public LesPersonnages getCartesTransferees() {
        return cartesTransferees;
    }
    
}
