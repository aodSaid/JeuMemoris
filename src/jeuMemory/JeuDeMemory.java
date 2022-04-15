package jeuMemory;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import static java.lang.Integer.parseInt;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.Timer;

class JeuDeMemory extends javax.swing.JFrame {
    private LesPersonnages persos;
    private LesJoueurs joueurs;
    private Jeu monJeu;  // pour la gestion d’un tour de jeu
    private int l1, c1, l2, c2;// pour les cartes sélectionnées à chaque tour de jeu
    

    public JeuDeMemory()
    {
        initComponents();//Création de l'interface par l'IDE
        this.persos=new LesPersonnages();
        this.joueurs=new LesJoueurs();
        l1=-1;c1=-1;
        l2=-1;c2=-1;
    }
 
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Panneau = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        Edition = new javax.swing.JTextArea();
        jPanel4 = new javax.swing.JPanel();
        demarreButton = new javax.swing.JButton();
        restartButton = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        Options = new javax.swing.JMenuItem();
        AjouterJoueur = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        Joueur = new javax.swing.JMenuItem();
        Carte = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        Bataille_Test = new javax.swing.JMenuItem();
        Transfert_Test = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        Panneau.setLayout(new java.awt.GridLayout(4, 5));
        getContentPane().add(Panneau, java.awt.BorderLayout.CENTER);

        jPanel2.setPreferredSize(new java.awt.Dimension(300, 163));
        jPanel2.setLayout(new java.awt.BorderLayout());

        jPanel3.setLayout(new java.awt.GridLayout(3, 1));

        jLabel1.setText("Nombre de personnage trouvés :");
        jPanel3.add(jLabel1);

        jLabel2.setText("Nombre de personnages restants:");
        jPanel3.add(jLabel2);

        jLabel3.setFont(new java.awt.Font("Tahoma", 3, 14)); // NOI18N
        jPanel3.add(jLabel3);

        jPanel2.add(jPanel3, java.awt.BorderLayout.NORTH);

        Edition.setEditable(false);
        Edition.setColumns(20);
        Edition.setRows(5);
        jScrollPane1.setViewportView(Edition);

        jPanel2.add(jScrollPane1, java.awt.BorderLayout.CENTER);

        jPanel4.setLayout(new java.awt.GridLayout(1, 2));

        demarreButton.setText("Démarrer");
        demarreButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                demarreButtonActionPerformed(evt);
            }
        });
        jPanel4.add(demarreButton);

        restartButton.setText("Recommencer");
        restartButton.setEnabled(false);
        restartButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                restartButtonActionPerformed(evt);
            }
        });
        jPanel4.add(restartButton);

        jPanel2.add(jPanel4, java.awt.BorderLayout.SOUTH);

        getContentPane().add(jPanel2, java.awt.BorderLayout.WEST);

        jMenu1.setText("Paramètres");

        Options.setText("Options");
        Options.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                OptionsActionPerformed(evt);
            }
        });
        jMenu1.add(Options);

        AjouterJoueur.setText("Ajouter un joueur");
        AjouterJoueur.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AjouterJoueurActionPerformed(evt);
            }
        });
        jMenu1.add(AjouterJoueur);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Visualiser");

        Joueur.setText("Joueur");
        Joueur.setEnabled(false);
        Joueur.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JoueurActionPerformed(evt);
            }
        });
        jMenu2.add(Joueur);

        Carte.setText("Carte");
        Carte.setEnabled(false);
        Carte.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CarteActionPerformed(evt);
            }
        });
        jMenu2.add(Carte);

        jMenuBar1.add(jMenu2);

        jMenu3.setText("Tests");

        Bataille_Test.setText("Bataille");
        Bataille_Test.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Bataille_TestActionPerformed(evt);
            }
        });
        jMenu3.add(Bataille_Test);

        Transfert_Test.setText("Transfert");
        Transfert_Test.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Transfert_TestActionPerformed(evt);
            }
        });
        jMenu3.add(Transfert_Test);

        jMenuBar1.add(jMenu3);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    public LesJoueurs getJoueurs() {
        return joueurs;
    }

    public LesPersonnages getPersos() {
        return persos;
    }

    public int getL1() {
        return l1;
    }

    public int getC1() {
        return c1;
    }

    public int getL2() {
        return l2;
    }

    public int getC2() {
        return c2;
    }
    
    
    
    private void OptionsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_OptionsActionPerformed
 
        InitDlg choix = new InitDlg(this,true);//Déclaration d'une variable de type objet et appelle au constructeur
        choix.setSize(600,350);//taille de la fenêtre respectivement largeur et hauteur
        choix.setLocationRelativeTo(this);//affiche la fenêtre au milieu de l'ecran
        choix.setTitle("Options");
        choix.setVisible(true);//Affiche la fenêtre
        if (choix.isOk()) {
              // ajoute les joueurs sélectionnés aux joueurs existants
              LesJoueurs mesJ=choix.getLj();
              for(int i=0; i<mesJ.getNbJoueurs(); i++)
              { this.joueurs.ajouteJoueur(mesJ.getJoueur(i));
              }
              // initialise les personnages et le niveau de jeu
              this.persos = new LesPersonnages(choix.getNc());
              // pour vérification
              monJeu = new Jeu(persos,joueurs,persos.getTaille());
              Edition.setText(this.joueurs.toString());
        }
    }//GEN-LAST:event_OptionsActionPerformed
     //Gestionnaire du clic sur le menu "Carte"
    private void CarteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CarteActionPerformed
        VisuPersonnagesDlg diag=new VisuPersonnagesDlg(this,true,monJeu.getJoueurCourant());    //Déclaration d'une variable de type objet et appelle au constructeur
        diag.setSize(600, 350);                                         //taille de la fenêtre respectivement largeur et hauteur
        diag.setLocationRelativeTo(this);                               //affiche la fenêtre au milieu de l'ecran
        diag.setTitle("Visualisateur de cartes");
        diag.setVisible(true);                                          //Affiche la fenêtre
    }//GEN-LAST:event_CarteActionPerformed
    //Gestionnaire du clic sur le menu "Joueur" 
    private void JoueurActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JoueurActionPerformed
        VisuJoueursDlg diag=new VisuJoueursDlg(this,true,this.joueurs);//Déclaration d'une variable de type objet et appelle au constructeur
        diag.setSize(600, 350);//taille de la fenêtre respectivement largeur et hauteur
        diag.setLocationRelativeTo(this);//affiche la fenêtre au milieu de l'ecran
        diag.setTitle("Visualisateur de joueurs");
        diag.setVisible(true);// Affiche la fenêtre
        
    }//GEN-LAST:event_JoueurActionPerformed
    //Gesionnaire du clic sur le menu "Ajouter un joueur" 
    private void AjouterJoueurActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AjouterJoueurActionPerformed
        SaisieJoueurDlg diag=new SaisieJoueurDlg(this,true,this.persos);//Appelle au constructeur
        diag.setSize(600, 350);//taille de la fenêtre respectivement largeur et hauteur
        diag.setLocationRelativeTo(this);//affiche la fenêtre au milieu de l'ecran
        diag.setTitle("Ajouter un joueur");
        diag.setVisible(true); //Affiche la fenêtre
        if (diag.isOk())    
            {this.joueurs.ajouteJoueur(diag.getJ());
              Edition.setText(this.joueurs.toString());
            }
    }//GEN-LAST:event_AjouterJoueurActionPerformed

    private void Bataille_TestActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Bataille_TestActionPerformed
           // ajout de cartes aux 2 premiers joueurs
            this.joueurs.getJoueur(0).initPaquetTest();
            this.joueurs.getJoueur(1).getPaquet().ajoutePerso(new Personnage("epiques", "burnout", 20));
            this.joueurs.getJoueur(1).getPaquet().ajoutePerso(new Personnage("epiques", "funk-ops", 30));
            // ouverture de la boîte de dialogue, avec le 1er joueur en joueur courant.
            BatailleDlg diag = new BatailleDlg(this, true, this.joueurs, 0);
            diag.setSize(1000,600);
            diag.setLocationRelativeTo(this);
            diag.setTitle("Bataille");
            diag.setVisible(true);
    }//GEN-LAST:event_Bataille_TestActionPerformed

    private void Transfert_TestActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Transfert_TestActionPerformed
        Joueur j1=new Joueur("FanMemory0", "rares");
        j1.getPaquet().ajoutePerso(new Personnage("communs", "assault-trooper", 10));
        j1.getPaquet().ajoutePerso(new Personnage("communs", "commando", 20));
        j1.getPaquet().ajoutePerso(new Personnage("rares", "absolute-zero", 10));
        Joueur j2=new Joueur("FanMemory1", "communs");
        j2.getPaquet().ajoutePerso(new Personnage("epiques", "burnout", 20));
        j2.getPaquet().ajoutePerso(new Personnage("epiques", "funk-ops", 30));
        j2.getPaquet().ajoutePerso(new Personnage("alpins-femmes", "mogul-master", 10));
        j2.getPaquet().ajoutePerso(new Personnage("epiques", "burnout", 20));
        j2.getPaquet().ajoutePerso(new Personnage("epiques", "funk-ops", 30));
        j2.getPaquet().ajoutePerso(new Personnage("alpins-femmes", "mogul-master", 10));
        j2.getPaquet().ajoutePerso(new Personnage("epiques", "burnout", 20));
        j2.getPaquet().ajoutePerso(new Personnage("epiques", "funk-ops", 30));
        j2.getPaquet().ajoutePerso(new Personnage("alpins-femmes", "mogul-master", 10));
        this.joueurs.ajouteJoueur(j1);this.joueurs.ajouteJoueur(j2);
        TransfertDlg diag = new TransfertDlg(this,true,joueurs,0);
        diag.setLocationRelativeTo(this);
        diag.setTitle("Transfert");
        diag.setVisible(true);
        
    }//GEN-LAST:event_Transfert_TestActionPerformed

    private void demarreButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_demarreButtonActionPerformed
        if (joueurs.getNbJoueurs()<2)
            Edition.setText("Erreur, nombre de joueurs insufissant (minimum 2)");
        else {
            //On définit l'état des boutons du jeu
            demarreButton.setEnabled(false);
            restartButton.setEnabled(true);
            Options.setEnabled(false);
            AjouterJoueur.setEnabled(false);
            Joueur.setEnabled(true);
            Carte.setEnabled(true);
            jLabel1.setText("Nb de personnage trouvés : " + (persos.getTaille()-monJeu.getPlateau().getNbp()));
            jLabel2.setText("Nb de personnages restants : " + monJeu.getPlateau().getNbp());
            jLabel3.setText("C'est à " + monJeu.getLesJ().getJoueur(monJeu.getIndC()).getPseudo() + " de jouer !");
            Panneau.setLayout(new java.awt.GridLayout(monJeu.getPlateau().getNblig(), monJeu.getPlateau().getNbcol())); //On initialise la disposition du panneau acceuillant les cartes
            for (int i=0;i<2*monJeu.getPlateau().getNbp();i++) {    //Pour chaques cartes du jeu
                JButton bt = new JButton();                         //On crée un bouton
                bt.setName("" + i);                                 //On l'appelle par l'indice du composant dans le panneau
                bt.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent evt) {
                        boutonActionPerformed(evt);                 //On lui ajoute un Listener en cas d'action faite, appelant la méthode boutonActionPerformed()
                    }
                });
                Panneau.add(bt);                                    //On ajoute ce bouton au panneau
            }
        }
    }//GEN-LAST:event_demarreButtonActionPerformed

    private void restartButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_restartButtonActionPerformed
        this.Edition.setText("");
        this.jLabel1.setText("Nombre de personnage trouvés: 0");
        this.jLabel2.setText("Nombre de personnage restants: 0");
        this.jLabel3.setText("");
        this.joueurs = new LesJoueurs();
        this.persos=new LesPersonnages();
        Panneau.removeAll();
        Panneau.repaint();
        Options.setEnabled(true);
        AjouterJoueur.setEnabled(true);
        Joueur.setEnabled(false);
        Carte.setEnabled(false);
        demarreButton.setEnabled(true);
    }//GEN-LAST:event_restartButtonActionPerformed

    private void boutonActionPerformed(ActionEvent evt) {
        JButton bt = (JButton)evt.getSource();  //On récupère le bouton cliqué
        int name = parseInt(bt.getName());      //Puis son indice
        int l=0;
        int temp=name;                          
        //On détermine la ligne du bouton. A chaque nombre de colonnes retiré à temp, le nombre de ligne augmente, tant que temp est supérieur ou égal au nombre de colonnes
        while(temp>=monJeu.getPlateau().getNbcol()) {
            temp-=monJeu.getPlateau().getNbcol();
            l++;
        }
        //On détermine la colonne du bouton en soustrayant à name la l'indice de la ligne du déterminée, multipliée par le nombre de colonnes
        int c=name-(l*monJeu.getPlateau().getNbcol());
        Personnage p = persos.getPerso(monJeu.getPlateau().getCase(l, c));  //On récupère le personnage qui correspond à la case
        Image img = p.getPhoto().getScaledInstance(bt.getWidth(), bt.getHeight(), Image.SCALE_SMOOTH);  //On applique l'image du personnage sur le bouton
        bt.setIcon(new ImageIcon(img));
        //Si c'est le premier personnage cliqué, ses coordonnés vont dans les variables lui correspondant
        if (l1==-1 && c1==-1) {
            l1=l;
            c1=c;
        }
        //Si c'est le second personnage cliqué, ses coordonnés vont dans les variables lui correspondant
        else if (l!=l1 || c!=c1) {  //La présence d'un "else if" évite la possibilité de sélectionner deux fois la même carte
            l2=l;
            c2=c;
            startTimer(); //On lance la méthode startTimer()
        }
    }
    
    public void startTimer() {
        //définit un timer qui lance la vérification des deux personnages au bout d'une demi-seconde
        Timer t = new Timer(500, new ActionListener() {
            public void actionPerformed(ActionEvent ae) { 
                verifPersos();
            }
        });
        t.setRepeats(false);t.start();
    }
    
    public void verifPersos() {
        //Place les indices des personnages séléectionnés dans deux variable pour plus de clarté
        int i1 = monJeu.getPlateau().getCase(l1, c1);       
        int i2 = monJeu.getPlateau().getCase(l2, c2);       
            
        if(i1==i2) {      //Si les deux cases contiennent les mêmes cartes
            String fam = persos.getPerso(i1).getFamille(); //On récupère la famille de la première carte
            int bonus = monJeu.traiterTour(monJeu.getJoueurCourant(), i1);  //On détermine le bonus avec les paramètres correspondant
            if (bonus>=0) {   
                Edition.append("\n" + monJeu.getJoueurCourant().getPseudo() + " a gagné tous les personnages de la famille " + fam);
                if (bonus==0) {
                   
                    Edition.append("\n" + monJeu.getJoueurCourant().getPseudo() + " possède toutes les cartes de sa famille préférée, il a gagné !");
                    for (int i=0;i<monJeu.getPlateau().getNbc();i++) {
                        JButton bt = (JButton)Panneau.getComponent(i);
                        bt.setEnabled(false);
                        
                    }
                }
                else if (bonus==1) { //Si le bonus vaut 1, on ouvre la fenêtre le transfert
                    TransfertDlg diag = new TransfertDlg(this,true,joueurs,monJeu.getIndC());
                    diag.setLocationRelativeTo(this);
                    diag.setTitle("Transfert");
                    diag.setVisible(true);
                   // Edition.append(diag.getTc().getDeroulement());
                }
                else if (bonus==2) {  //Si le bonus vaut 2, on ouvre la fenêtre le bataille
                    BatailleDlg diag = new BatailleDlg(this, true,joueurs,monJeu.getIndC());
                    diag.setSize(1000,600);
                    diag.setLocationRelativeTo(this);
                    diag.setTitle("Bataille");
                    diag.setVisible(true);
                   // Edition.append(diag.getB().getDeroulement());
                }
                bonus=-1;
                monJeu.setIndC(monJeu.getIndSuivant(monJeu.getIndC())); //On passe au joueur suivant
            }
            
            monJeu.getPlateau().invalide(l1, c1, l2, c2);   //On invalide les cartes sélectionnés
            if (monJeu.getPlateau().jeuVide()) {            //Si le plateau est vide
                LesJoueurs gagnant = monJeu.getLesJ().getGagnants();    //On détermine les gagnants
                Edition.append("\n\nGagnants : ");
                
                
                for (int i=0;i<gagnant.getNbJoueurs();i++)
                    Edition.append(gagnant.getJoueur(i).getPseudo());   //On affiche leurs pseudo dans la zone d'édition
            }
            //On actualise les labels et on désactive les boutons
            jLabel3.setText("C'est à " + monJeu.getLesJ().getJoueur(monJeu.getIndC()).getPseudo() + " de jouer !");
            jLabel1.setText("Nb de personnage trouvés : " + (persos.getTaille()-monJeu.getPlateau().getNbp()));
            jLabel2.setText("Nb de personnages restants : " + monJeu.getPlateau().getNbp());
            JButton bt1 = (JButton)Panneau.getComponent(l1*monJeu.getPlateau().getNbcol()+c1);
            JButton bt2 = (JButton)Panneau.getComponent(l2*monJeu.getPlateau().getNbcol()+c2);
            bt1.setEnabled(false);
            bt2.setEnabled(false);
        }
        else //Si les cartes sont différentes, on retire les images des boutons
        {
            JButton bt1 = (JButton)Panneau.getComponent(l1*monJeu.getPlateau().getNbcol()+c1);
            JButton bt2 = (JButton)Panneau.getComponent(l2*monJeu.getPlateau().getNbcol()+c2);
            bt1.setIcon(null);
            bt2.setIcon(null);
            monJeu.setIndC(monJeu.getIndSuivant(monJeu.getIndC())); //On passe au joueur suivant
            jLabel3.setText("C'est à " + monJeu.getLesJ().getJoueur(monJeu.getIndC()).getPseudo() + " de jouer !");
            Edition.setText(this.joueurs.toString());
        }
        l1=-1;c1=-1;l2=-1;c2=-1;
    }
    
    public static void main(String args[]) {
        /* Set the Windows look and feel if available, else set the Nimbus look and feel*/
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
                else 
                    javax.swing.UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(JeuDeMemory.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JeuDeMemory.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JeuDeMemory.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JeuDeMemory.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                    JeuDeMemory jm=new JeuDeMemory();//Déclaration d'une variable de type objet et appelle au constructeur
                    jm.setSize(1280, 720);//taille de la fenêtre respectivement largeur et hauteur
                    jm.setLocationRelativeTo(null);//affiche la fenêtre au milieu de l'ecran
                    jm.setVisible(true);//affiche la fenêtre
                    jm.setTitle("Memory");//Titre de la fenêtre
           
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem AjouterJoueur;
    private javax.swing.JMenuItem Bataille_Test;
    private javax.swing.JMenuItem Carte;
    private javax.swing.JTextArea Edition;
    private javax.swing.JMenuItem Joueur;
    private javax.swing.JMenuItem Options;
    private javax.swing.JPanel Panneau;
    private javax.swing.JMenuItem Transfert_Test;
    private javax.swing.JButton demarreButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton restartButton;
    // End of variables declaration//GEN-END:variables
}
