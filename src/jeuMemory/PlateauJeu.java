package jeuMemory;

class PlateauJeu {
   //Attributs
   private int tab[][];//un tableau à 2D
   private int nbp; // nombre de personnages sur le plateau qui diminue au cours du jeu
   private int nblig;//nombre de lignes du plateau
   private int nbcol;///nombre de colonne du plateau   
   
   
   //constructeurs
    public PlateauJeu(int n)
    { 
     //initialisation des attributs
     this.nbp=n;
     this.nblig=(int)(Math.sqrt(nbp*2));//donner le nombre de ligne en fonction du nombre de personnage
     this.nbcol=nbp*2/nblig;//donner le nombre de colonne en fonction du nombre de personnage
     this.tab=new int [this.nblig][this.nbcol];//initialisation du tableau
     initPlateauJeu();//appelle à la methode pour initialiser le plateau
   }
    
    //Accesseurs
    public int getNbp() {
        return nbp;
    }

    public int getNblig() {
        return nblig;
    }

    public int getNbcol() {
        return nbcol;
    }
    
    public int getCase(int l, int c) {   
        return tab[l][c];  }
    
    public int getNbc() {   
        return this.nblig*this.nbcol/2;  }
    
    //methode pour initialiser le plateau
    public void initPlateauJeu()
    {  
        int k=0;//variable de type entier
        //les boucles parcour respectivement les lignes et colonnes
        for(int i=0; i<this.nblig; i++)
            for(int j=0; j<this.nbcol; j++)
                tab[i][j]=(k++)%this.nbp;//l'instruction pour donner l'element à la position ij
        melange();//appelle à la méthode qui permet de mélanger les elements
    }
    //methode utiliser pour dire le jeu est invalide
    public void invalide(int l1, int c1, int l2, int c2)
    {
        tab[l1][c1]=-1;
        tab[l2][c2]=-1;
        nbp--;          //On décrémente le nombre de personnages restant
    }
    
    //methode pour mélanger le plateau
    public void melange(){
        int temp,l1,c1,l2,c2;//variables de type entier
        
        for(int i=0;i<1000;i++){
            l1=(int)(Math.random()*nblig);
            c1=(int)(Math.random()*nbcol);
            l2=(int)(Math.random()*nblig);
            c2=(int)(Math.random()*nbcol);
           //echanger les cases
            temp=tab[l1][c1];
            tab[l1][c1]=tab[l2][c2];
            tab[l2][c2]=temp;
        }
    }
    // //methode utilisée pour déterminer si le jeu est vide
    public boolean jeuVide(){
        return this.nbp==0;
    }
     //methode utiliser pour déterminer si le jeu est valide
    public boolean estValide(int l,int c){
        return tab[l][c]!=-1;
    }
    //methode pour terminer le jeu
    public void termineJeu()
    {   //les boucles parcours respectivement les lignes et les colonnes
        for(int i=0;i<this.nblig;i++)
            for(int j=0;j<this.nbcol;j++)
                tab[i][j]=-1;//la valeur -1 à la case correspondante
    }
}

   
  
