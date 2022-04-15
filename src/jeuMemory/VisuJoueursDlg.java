    package jeuMemory;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;
import static java.lang.Integer.parseInt;
import javax.swing.ImageIcon;
import javax.swing.JButton;


public class VisuJoueursDlg extends javax.swing.JDialog {
    //Attributs
    private LesJoueurs lj;// la liste des joueurs récupérée
    private BoutonImage BtImage;// pour ajout du composantde type «BoutonImage»
     
    //constructeurs
    public VisuJoueursDlg(java.awt.Frame parent, boolean modal,LesJoueurs lstj) {
        super(parent, modal);//appel du constructeur par défaut de la classe ancêtre, ici de «JDialog»
        initComponents();// construction de l’interface avec l’EDI, sans les composants spécifiques
        this.lj=lstj;//initialisation de la liste
        initTrombi();//appelle de la methode pour completer la construction de l'interface 
    }
    //methode pour créer les bouton dynamiquement
    private void initTrombi(){
        int nb = this.lj.getNbJoueurs();//affecter le nombre de joueurs dans la variable nb
        Panneau.setLayout(new GridLayout(1,nb));//disposition du panneau
         for (int i=0; i<nb; i++){              //Pour chaque joueurs enregistrés dans la partie
          //  JButton jb= new JButton();          //On crée un bouton
            BoutonImage jb = new BoutonImage(); // création de l’instance de «BoutonImage»
            Joueur j= lj.getJoueur(i);          //On récupère le joueur à l'indice 
            jb.setName(""+i);                   //nommé le bouton
            jb.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    AfficheInfosJoueur(evt);    //On ajoute un Listener au bouton qui exécute la fonction AfficheInfosJoueur() en cas d'action faite sur ce dernier
                }
            });
          Panneau.add(jb);//ajout de cette instance dans le panneau
        }
        this.pack();
    }   
    //Gestionnaire du clic sur les images
    private void AfficheInfosJoueur(java.awt.event.ActionEvent evt){
      
        BoutonImage bt=(BoutonImage)evt.getSource();
        String i=bt.getName();
        int j=parseInt(i);      //On récupère l'indice du bouton (et donc du joueur) cliqué
        Edition.setText(lj.getJoueur(j).toString());    //On affiche les informations du personnage dans la zone de texte Edition
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        titrePanel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        Panneau = new javax.swing.JPanel();
        TextAreaPanel = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        Edition = new javax.swing.JTextArea();
        ButtonPanel = new javax.swing.JPanel();
        afficherButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setText("Choisissez un joueur pour voir ses caractéristiques");
        titrePanel.add(jLabel1);

        getContentPane().add(titrePanel, java.awt.BorderLayout.NORTH);

        javax.swing.GroupLayout PanneauLayout = new javax.swing.GroupLayout(Panneau);
        Panneau.setLayout(PanneauLayout);
        PanneauLayout.setHorizontalGroup(
            PanneauLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        PanneauLayout.setVerticalGroup(
            PanneauLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        getContentPane().add(Panneau, java.awt.BorderLayout.CENTER);

        TextAreaPanel.setLayout(new java.awt.GridLayout(1, 1));

        Edition.setEditable(false);
        Edition.setColumns(20);
        Edition.setRows(5);
        jScrollPane1.setViewportView(Edition);

        TextAreaPanel.add(jScrollPane1);

        getContentPane().add(TextAreaPanel, java.awt.BorderLayout.EAST);

        ButtonPanel.setLayout(new java.awt.GridLayout(1, 1));

        afficherButton.setText("Afficher");
        afficherButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                afficherButtonActionPerformed(evt);
            }
        });
        ButtonPanel.add(afficherButton);

        getContentPane().add(ButtonPanel, java.awt.BorderLayout.SOUTH);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void afficherButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_afficherButtonActionPerformed
      
        BoutonImage bt;//variable de type BoutonImage
        int nb = this.lj.getNbJoueurs();//affecter le nombre de joueurs dans la variable nb
        //boucle qui parcour les joueurs
        for(int i=0;i<nb;i++)           //Pour chaque boutons (correspondant au nombre de joueurs, on applique la photo du joueur sur le bouton
        {   
           
            bt=(BoutonImage)Panneau.getComponent(i);//récupèrer le bouton à la position i dans la variable bt
          
            Joueur j=this.lj.getJoueur(i);//récuperé le joueur à l'indice i
           // création d’une instance de type Image, puis récuperer l'image du joueur 
           Image img=j.getPhoto().getImage().getScaledInstance(bt.getWidth(), bt.getHeight(), Image.SCALE_SMOOTH);
           // affectation de cette image au composant“bt”, ce qui provoque également son affichage
           bt.setImage(img);
        }
    }//GEN-LAST:event_afficherButtonActionPerformed

 
   
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel ButtonPanel;
    private javax.swing.JTextArea Edition;
    private javax.swing.JPanel Panneau;
    private javax.swing.JPanel TextAreaPanel;
    private javax.swing.JButton afficherButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel titrePanel;
    // End of variables declaration//GEN-END:variables
}
