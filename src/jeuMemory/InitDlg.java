package jeuMemory;

import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.ImageIcon;

public class InitDlg extends javax.swing.JDialog {
   //Attributs
    private int nc;//variable pour selectionner le niveau(4,10,18,32)
    private LesJoueurs lj;//la liste des joueurs 
    private boolean ok;//true pour valider /false pour annuler
    private PanneauImage PanImage;// pour ajout du composant de type «PanneauImage»
    
    
    //constructeurs
    public InitDlg(java.awt.Frame parent, boolean modal) {
        super(parent, modal);//appel du constructeur par défaut de la classe ancêtre, ici de «JDialog»
        initComponents();// construction de l’interface avec l’EDI, sans les composants spécifiques
        this.nc=4;//nombre de personnades par defaut
        jRadioButton1.setSelected(true);//le bouton radio selectionné par defaut
        this.lj= new LesJoueurs();//initialisation de liste de joueurs
        this.PanImage = new PanneauImage();// création de l’ instance de «PanneauImage»
        PhotoImg.add(PanImage);//ajout de cette instance dans le panneau
        this.ok=false;
    }
    
    //Accesseurs
    public int getNc() {
        return nc;
    }

    public LesJoueurs getLj() {
        return lj;
    }

    public boolean isOk() {
        return ok;
    }

    public void setNc(int nc) {
        this.nc = nc;
    }

    public void setLj(LesJoueurs lj) {
        this.lj = lj;
    }

    public void setOk(boolean ok) {
        this.ok = ok;
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        Annuler = new javax.swing.JButton();
        Valider = new javax.swing.JButton();
        PhotoImg = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        Edition = new javax.swing.JTextArea();
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jRadioButton1 = new javax.swing.JRadioButton();
        jRadioButton2 = new javax.swing.JRadioButton();
        jRadioButton3 = new javax.swing.JRadioButton();
        jRadioButton4 = new javax.swing.JRadioButton();
        jPanel6 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        CaseLara = new javax.swing.JCheckBox();
        CaseJack = new javax.swing.JCheckBox();
        CaseJs = new javax.swing.JCheckBox();
        CaseAmadeus = new javax.swing.JCheckBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setLayout(new java.awt.GridLayout(1, 2));

        Annuler.setText("Annuler");
        Annuler.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AnnulerActionPerformed(evt);
            }
        });
        jPanel1.add(Annuler);

        Valider.setText("Valider");
        Valider.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ValiderActionPerformed(evt);
            }
        });
        jPanel1.add(Valider);

        getContentPane().add(jPanel1, java.awt.BorderLayout.SOUTH);

        PhotoImg.setLayout(new java.awt.GridLayout(2, 1));

        Edition.setColumns(20);
        Edition.setRows(5);
        jScrollPane1.setViewportView(Edition);

        PhotoImg.add(jScrollPane1);

        getContentPane().add(PhotoImg, java.awt.BorderLayout.EAST);

        jPanel3.setLayout(new java.awt.GridLayout(1, 2));

        jPanel4.setLayout(new java.awt.BorderLayout());

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Choisissez la taille du jeu");
        jPanel4.add(jLabel1, java.awt.BorderLayout.NORTH);

        jPanel5.setLayout(new java.awt.GridLayout(4, 1));

        buttonGroup1.add(jRadioButton1);
        jRadioButton1.setText("enfant(4 personnages,2 familles)");
        jRadioButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton1ActionPerformed(evt);
            }
        });
        jPanel5.add(jRadioButton1);

        buttonGroup1.add(jRadioButton2);
        jRadioButton2.setText("débutant(10 personnages,4 familles)");
        jRadioButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton2ActionPerformed(evt);
            }
        });
        jPanel5.add(jRadioButton2);

        buttonGroup1.add(jRadioButton3);
        jRadioButton3.setText("avancé(18 personnages,4 familles)");
        jRadioButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton3ActionPerformed(evt);
            }
        });
        jPanel5.add(jRadioButton3);

        buttonGroup1.add(jRadioButton4);
        jRadioButton4.setText("expert(32 personnages,6 familles)");
        jRadioButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton4ActionPerformed(evt);
            }
        });
        jPanel5.add(jRadioButton4);

        jPanel4.add(jPanel5, java.awt.BorderLayout.CENTER);

        jPanel3.add(jPanel4);

        jPanel6.setLayout(new java.awt.BorderLayout());

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Choisissez les joueurs créés par défaut");
        jPanel6.add(jLabel2, java.awt.BorderLayout.NORTH);

        jPanel7.setLayout(new java.awt.GridLayout(4, 1));

        CaseLara.setText("Lara");
        CaseLara.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CaseLaraActionPerformed(evt);
            }
        });
        jPanel7.add(CaseLara);

        CaseJack.setText("Jack");
        CaseJack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CaseJackActionPerformed(evt);
            }
        });
        jPanel7.add(CaseJack);

        CaseJs.setText("Jean-Sebastien");
        CaseJs.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CaseJsActionPerformed(evt);
            }
        });
        jPanel7.add(CaseJs);

        CaseAmadeus.setText("Amadeus");
        CaseAmadeus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CaseAmadeusActionPerformed(evt);
            }
        });
        jPanel7.add(CaseAmadeus);

        jPanel6.add(jPanel7, java.awt.BorderLayout.CENTER);

        jPanel3.add(jPanel6);

        getContentPane().add(jPanel3, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents
    //Gestionnaire du clic sur les boutons radio
    private void jRadioButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton1ActionPerformed
        this.nc=4;//4 personnages (8 cartes)
    }//GEN-LAST:event_jRadioButton1ActionPerformed

    private void jRadioButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton2ActionPerformed
        this.nc=10;//10 personnages (20 cartes)
    }//GEN-LAST:event_jRadioButton2ActionPerformed

    private void jRadioButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton3ActionPerformed
        this.nc=18;//18 personnages (36 cartes)
    }//GEN-LAST:event_jRadioButton3ActionPerformed

    private void jRadioButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton4ActionPerformed
        this.nc=32;//32 personnages (64 cartes)
    }//GEN-LAST:event_jRadioButton4ActionPerformed
    //Gestionnaire du clic sur le bouton valider
    private void ValiderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ValiderActionPerformed
        if(CaseLara.isSelected())//si la case lara est sélectionnée
            {
            Joueur j=new Joueur("Lara","épiques");//créer le joueur
            j.setPhoto(new ImageIcon(getClass().getResource("/jeuMemory/img/lara.jpg")));//affectation de l'image au joueur
            this.lj.ajouteJoueur(j);//ajoute le joueur dans la liste
            }
        if(CaseJack.isSelected())//si la case Jack est sélectionnée
            {
            Joueur j=new Joueur("Jack","rares");//créer le joueur
            j.setPhoto(new ImageIcon(getClass().getResource("/jeuMemory/img/jack.png")));//affectation de l'image au joueur
            this.lj.ajouteJoueur(j);//ajoute le joueur dans la liste
            }
        if(CaseJs.isSelected())//si la case Jeau est sélectionnée
            {
            Joueur j=new Joueur("Jean-Sébastien","alpins-femmes");//créer le joueur
            j.setPhoto(new ImageIcon(getClass().getResource("/jeuMemory/img/bach.jpg")));//affectation de l'image au joueur
            this.lj.ajouteJoueur(j);//ajoute le joueur dans la liste
            }
        if(CaseAmadeus.isSelected())//si la case Amadeus est sélectionnée
            {
            Joueur j=new Joueur("Amadeus","communs");//créer le joueur
            j.setPhoto(new ImageIcon(getClass().getResource("/jeuMemory/img/mozart.jpg")));//affectation de l'image au joueur
            this.lj.ajouteJoueur(j);//ajoute le joueur dans la liste
            }
        this.ok=true;
        this.setVisible(false);
        this.dispose();
    }//GEN-LAST:event_ValiderActionPerformed

    private void CaseLaraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CaseLaraActionPerformed
        Joueur j=new Joueur("Lara", "epiques");//créer le joueur 
        
        // création d’une image
        Image img = Toolkit.getDefaultToolkit().getImage(getClass().getResource("/jeuMemory/img/lara.jpg"));
        // affectation de l’image au composant «PanImage», ce qui provoque également son affichage
        PanImage.setImage(img);
        Edition.setText(j.toString());//afficher les informations du joueur dans la zone d'edition
       
    }//GEN-LAST:event_CaseLaraActionPerformed
    //Gestionnaire du clic sur le bouton Annuler
    private void AnnulerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AnnulerActionPerformed
        this.setVisible(false);
        this.dispose();
    }//GEN-LAST:event_AnnulerActionPerformed

    private void CaseJackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CaseJackActionPerformed
        Joueur j=new Joueur("Jack", "rares");//créer le joueur
        
         // création d’une image
        Image img = Toolkit.getDefaultToolkit().getImage(getClass().getResource("/jeuMemory/img/jack.png"));
        // affectation de l’image au composant «PanImage», ce qui provoque également son affichage
        PanImage.setImage(img);
        Edition.setText(j.toString());//afficher les informations du joueur dans la zone d'edition
    }//GEN-LAST:event_CaseJackActionPerformed

    private void CaseJsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CaseJsActionPerformed
        Joueur j=new Joueur("Jean-Sebastien", "alpins-femmes");//créer le joueur
  
        // création d’une image
         Image img = Toolkit.getDefaultToolkit().getImage(getClass().getResource("/jeuMemory/img/bach.jpg"));
         // affectation de l’image au composant «PanImage», ce qui provoque également son affichage
        PanImage.setImage(img);
        Edition.setText(j.toString());//afficher les informations du joueur dans la zone d'edition
    }//GEN-LAST:event_CaseJsActionPerformed

    private void CaseAmadeusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CaseAmadeusActionPerformed
        Joueur j=new Joueur("Amadeus", "communs");//créer le joueur
       
        // création d’une image
        Image img = Toolkit.getDefaultToolkit().getImage(getClass().getResource("/jeuMemory/img/mozart.jpg"));
        // affectation de l’image au composant «PanImage», ce qui provoque également son affichage
        PanImage.setImage(img);
        Edition.setText(j.toString());//afficher les informations du joueur dans la zone d'edition
    }//GEN-LAST:event_CaseAmadeusActionPerformed

   
 

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Annuler;
    private javax.swing.JCheckBox CaseAmadeus;
    private javax.swing.JCheckBox CaseJack;
    private javax.swing.JCheckBox CaseJs;
    private javax.swing.JCheckBox CaseLara;
    private javax.swing.JTextArea Edition;
    private javax.swing.JPanel PhotoImg;
    private javax.swing.JButton Valider;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JRadioButton jRadioButton3;
    private javax.swing.JRadioButton jRadioButton4;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
