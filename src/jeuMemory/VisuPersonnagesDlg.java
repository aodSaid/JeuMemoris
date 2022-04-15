package jeuMemory;

import java.awt.GridLayout;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class VisuPersonnagesDlg extends javax.swing.JDialog {
    private Joueur j; 

    public VisuPersonnagesDlg(java.awt.Frame parent, boolean modal, Joueur j) {
        super(parent, modal);
        initComponents();
        this.j=j;
        initPanneau();
    }

    public void initPanneau()  {
        int nb = this.j.getPaquet().getTaille();        //On récupère le nombre de personnage que possède le joueur
        int nbL1, nbL2;                                 
        if (nb%2==0) {                                  //Si ce nombre est pair
            nbL1=(int)(nb/2);                           //nbL1 vaut la moitié du nombre
            nbL2=(int)(nb/2);                           //nbL2 vaut la moitié du nombre
        }                           
        else {                                          //Sinon
            nbL1=(int)(nb/2)+1;                         //nbL1 vaut la moitié du nombre+1
            nbL2=(int)(nb/2);                           //nbL2 vaut toujours la moitié du nombre
        }
        Panneau.setLayout(new GridLayout(2,nbL1));      //Le panneau a pour disposition une grille de 2 lignes et de nbL1 colonnes
        
        int k=0;
        for (int i=0; i<nbL1; i++) {
            JButton jb= new JButton();                  //On crée une ligne de boutons
            jb.setName(""+i);                           //Leur nom est l'indice de i
            jb.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {                
                }
            });
            Panneau.add(jb);                            //On ajoute le bouton au panneau
            k=k+1;
        }
            
        for (int j=k; j<nbL2+k; j++) {                 //Pour j allant de la valeur de k à nbL2+k; Même principe que pour la boucle précédente, s'occupant cette fois de créer les boutons de la 2e ligne
            JButton jb= new JButton();                 
            jb.setName(""+j);
            jb.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                }
            });
            Panneau.add(jb);
        }           
    this.pack();
    }
    
    
    
    
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        carteLabel = new javax.swing.JLabel();
        Panneau = new javax.swing.JPanel();
        sPanel = new javax.swing.JPanel();
        Scorelabel = new javax.swing.JLabel();
        Afficher = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        carteLabel.setText("Cartes du joueur: ");
        getContentPane().add(carteLabel, java.awt.BorderLayout.NORTH);

        javax.swing.GroupLayout PanneauLayout = new javax.swing.GroupLayout(Panneau);
        Panneau.setLayout(PanneauLayout);
        PanneauLayout.setHorizontalGroup(
            PanneauLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 200, Short.MAX_VALUE)
        );
        PanneauLayout.setVerticalGroup(
            PanneauLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 240, Short.MAX_VALUE)
        );

        getContentPane().add(Panneau, java.awt.BorderLayout.CENTER);

        sPanel.setLayout(new java.awt.GridLayout(2, 1));

        Scorelabel.setText("Score: ");
        sPanel.add(Scorelabel);

        Afficher.setText("Afficher");
        Afficher.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AfficherActionPerformed(evt);
            }
        });
        sPanel.add(Afficher);

        getContentPane().add(sPanel, java.awt.BorderLayout.SOUTH);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void AfficherActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AfficherActionPerformed
        JButton bt;
        int nb = this.j.getPaquet().getTaille();
        for(int i=0;i<nb;i++)                           //Pour chaque personnages que possède le joueur, on récupère le bouton à l'indice i puis on lui attribut l'image du personnage.
        {   
            bt=(JButton)Panneau.getComponent(i);        
            Personnage p=this.j.getPaquet().getPerso(i);          
            Image img=p.getPhoto().getScaledInstance(bt.getWidth(), bt.getHeight(), Image.SCALE_SMOOTH);
            bt.setIcon(new ImageIcon (img));
        }
        this.carteLabel.setText("Cartes du joueur: "+j.getPseudo());
        this.Scorelabel.setText("Score: "+j.getPaquet().getScore());
        
    }//GEN-LAST:event_AfficherActionPerformed



    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Afficher;
    private javax.swing.JPanel Panneau;
    private javax.swing.JLabel Scorelabel;
    private javax.swing.JLabel carteLabel;
    private javax.swing.JPanel sPanel;
    // End of variables declaration//GEN-END:variables
}
