package jeuMemory;

import java.awt.Image;
import java.awt.event.ActionEvent;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

public class TransfertDlg extends javax.swing.JDialog {
    
    private LesJoueurs lj; //collection des joueurs, pour initialiser la liste déroulante avec les pseudos des joueurs 
    private int indj; //indice joueur courant
    private Transfert tc;//action ici transfert
    private boolean ok; // indicateur pour savoir le transfert a bien été effectué.
    private int indjs; //indice du joueur sélectionné dans la liste déroulante
    private String fs; //famille du personnage sélectionné en cliquant sur un des personnages du joueur sélectionné
    private boolean valide;//indicateur qui permet de savoir si la carte à transferer a été séléctionner    
    
    public TransfertDlg(java.awt.Frame parent, boolean modal, LesJoueurs lj, int indj) {
        super(parent, modal);   //appelle aux constructeurs de la classe ancêtre ici (JeuMmory)
        initComponents();       //appelle à la methode de construction de l'EDI par l'interface
        this.lj = lj;
        this.indj = indj;
        this.tc=null;
        this.ok=false;
        this.fs=null;
        this.valide=false;
        initCombo();            // méthode pour remplir la liste déroulante
        indjs = 0;
        Message.setText("Le joueur "+lj.getJoueur(indj).getPseudo()+" a obtenu une famille complète");
        Infos.setText("Personnages de "+lj.getJoueur(indj).getPseudo()+" : \n"+lj.getJoueur(indj).getPaquet());
    }
    //methode pour remplir la liste combo
    public void initCombo() {
        //boucle pour parcourir tous les elements de la liste des joueurs
        //ajouter le nom du joueur à la position i à chaque tour de boucle
        for (int i=0;i<lj.getNbJoueurs();i++) {
            String s = lj.getJoueur(i).getPseudo();//affectation à la variable s(String) du nom du joueur à la positon 
            ComboJoueurs.addItem(s);//ajoute le nom à la liste 
        }
    }
    
    
    //Accesseurs
    public boolean getOk() {
        return ok;
    }
    
    
    public Transfert getTc() {
        return tc;
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        PanneauG = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        Message = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        ComboJoueurs = new javax.swing.JComboBox<>();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        Infos = new javax.swing.JTextArea();
        jPanel6 = new javax.swing.JPanel();
        TransfertButton = new javax.swing.JButton();
        FermerButton = new javax.swing.JButton();
        PanneauD = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        PanneauG.setPreferredSize(new java.awt.Dimension(100, 300));

        javax.swing.GroupLayout PanneauGLayout = new javax.swing.GroupLayout(PanneauG);
        PanneauG.setLayout(PanneauGLayout);
        PanneauGLayout.setHorizontalGroup(
            PanneauGLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        PanneauGLayout.setVerticalGroup(
            PanneauGLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        getContentPane().add(PanneauG, java.awt.BorderLayout.WEST);

        jPanel2.setLayout(new java.awt.GridLayout(2, 1));

        jPanel4.setLayout(new java.awt.GridLayout(4, 1));

        Message.setText("jLabel1");
        jPanel4.add(Message);

        jLabel2.setText("Il peut prendre toutes les cartes d'une même famille d'un joueur");
        jPanel4.add(jLabel2);

        jLabel3.setText("Sélectionnez le joueur dont vous voulez voir les cartes");
        jPanel4.add(jLabel3);

        ComboJoueurs.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ComboJoueursActionPerformed(evt);
            }
        });
        jPanel4.add(ComboJoueurs);

        jPanel2.add(jPanel4);

        jPanel5.setLayout(new java.awt.BorderLayout());

        Infos.setColumns(20);
        Infos.setRows(5);
        jScrollPane1.setViewportView(Infos);

        jPanel5.add(jScrollPane1, java.awt.BorderLayout.CENTER);

        jPanel6.setLayout(new java.awt.GridLayout(1, 2));

        TransfertButton.setText("Transferer");
        TransfertButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TransfertButtonActionPerformed(evt);
            }
        });
        jPanel6.add(TransfertButton);

        FermerButton.setText("Fermer");
        FermerButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FermerButtonActionPerformed(evt);
            }
        });
        jPanel6.add(FermerButton);

        jPanel5.add(jPanel6, java.awt.BorderLayout.SOUTH);

        jPanel2.add(jPanel5);

        getContentPane().add(jPanel2, java.awt.BorderLayout.CENTER);

        PanneauD.setPreferredSize(new java.awt.Dimension(100, 300));
        PanneauD.setLayout(new java.awt.GridLayout(2, 1));
        getContentPane().add(PanneauD, java.awt.BorderLayout.EAST);

        pack();
    }// </editor-fold>//GEN-END:initComponents
    //Gestionnaire du clique sur un element de la liste
    private void ComboJoueursActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ComboJoueursActionPerformed
        this.indjs = ComboJoueurs.getSelectedIndex();
        if (indjs != -1) {
            if (this.indjs == this.indj) {
                Infos.setText("Sélectionnez un joueur différent du joueur courant !");
                PanneauG.removeAll();
                PanneauG.repaint();
            }
            else
              if(this.lj.getJoueur(indjs).getNbCartes()==0)
                  Infos.setText("Veuillez sélectionner un joueur possédant au moins une carte");  
                else
                {
                    Infos.setText("\nJoueur sélectionné: "+lj.getJoueur(indjs).toString());
                    initPanneau();
                    affichePanneau();
                }
        }
    }//GEN-LAST:event_ComboJoueursActionPerformed
    //Gestionnaire du clique sur le bouton fermer
    private void FermerButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FermerButtonActionPerformed
        this.setVisible(false);//fermer la fenêtre
        this.ok=false;
        this.dispose();//liberer de l'espace memoire
    }//GEN-LAST:event_FermerButtonActionPerformed
    //Gestionnaire du clique sur le bouton transfert
    private void TransfertButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TransfertButtonActionPerformed
       
        if(this.valide==false)//Aucune carte n'est séléctionnée pour le transfert
          Infos.setText("Veillez séléctionner les cartes à transferer d'abord!");
        else
           //une condition pour vérifier si c'est pas le joueur courant qui est séléctionné et vérifer le nom de famille
            if (indjs!=-1 && !fs.equals(null)) 
            {   //création d'une instance Transfert et appelle aux constructeurs  
                Transfert tc = new Transfert(lj.getJoueur(indj), lj.getJoueur(indjs), fs);
                if (tc.execute()>0) //condition pour vérifier si la valeur renvoyée est superieur à 0
                {
                    LesPersonnages lp = tc.getCartesTransferees();//affecte les cartes transferées à la variable lp de type personnage
                    this.creePanneau(PanneauD, lp);//créer le panneau en fonction des cartes transferées
                    this.dessinePanneau(PanneauD, lp);//dessiner le panneau (bouton avec l'image des cartes)
                    LesPersonnages lp2 = lj.getJoueur(indjs).getPaquet();//affectation du paquet du joueur courant  à la variable lp2 de type personnage
                    this.creePanneau(PanneauG, lp2);//créer le panneau en fonction des cartes restant
                    this.dessinePanneau(PanneauG, lp2);//redessiner le panneau (bouton avec l'image des cartes)
                    ok=true;//pour valider l'opération
                    TransfertButton.setEnabled(false);//suspend la disponibilité du bouton transfert
                }
            }
        else
            //message à affficher si le condition n'est pas vérifier
            Infos.setText("Veuillez sélectionner un joueur possédant au moins une carte");
    }//GEN-LAST:event_TransfertButtonActionPerformed

    private void initPanneau() {
        PanneauG.removeAll();
        this.repaint();
            Joueur j = lj.getJoueur(ComboJoueurs.getSelectedIndex());
        LesPersonnages lcs = j.getPaquet();
        int t = lcs.getTaille();
        int n = 1+(t-1)/4;
        PanneauG.setLayout(new java.awt.GridLayout(4, n));
        for (int i =0; i<t; i++) {
            JButton bt = new JButton();
            bt.setName(lcs.getPerso(i).getFamille());
            bt.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    boutonActionPerformed(evt);
                }
            });
            PanneauG.add(bt);
        }
        this.pack();
        
    }
    
    //methode pour afficher le panneau
    private void affichePanneau() {
        //affecter le joueur séléctionné à la variable j 
        Joueur j = lj.getJoueur(ComboJoueurs.getSelectedIndex());
        //affecter les cartes du joueur à la variable lcs
        LesPersonnages lcs = j.getPaquet();
        JButton jb;//déclaration d'une variable bouton
        //boucle pour parcourir les cartes du joueur et  
        // affecter aux boutons l'image de la carte correspondans à chaque tour de boucle
        for (int i =0; i<lcs.getTaille();i++) {
            jb = (JButton)PanneauG.getComponent(i);
            Image img=lcs.getPerso(i).getPhoto().getScaledInstance(jb.getWidth(), jb.getHeight(), Image.SCALE_SMOOTH);
            jb.setIcon(new ImageIcon (img));//affecter l'image au bouton
        }
    }
    
    private void boutonActionPerformed(ActionEvent evt){
        LesPersonnages lp = lj.getJoueur(indjs).getPaquet();    //récupère la liste de personnage du joueur séléctionné
        int t = lp.getTaille();                                 //Récupère sa taille
        JButton bt=(JButton) evt.getSource();                   //récupère le composant JButton
        fs = bt.getName();                                      //la proprité Name, contient ici le nom du personnage affiché sur le bouton
        for(int i = 0; i < t; i++) {                            //Pour i parcourant tous les JButton du PanneauG 
            JButton b = (JButton)(PanneauG.getComponent(i));    //On récupère le JButton de l'indice actuel
            if (b.getName().equals(fs))                         //Si le JButton a pour nom le nom du premier JButton sélectionné
                b.setBorder(BorderFactory.createMatteBorder(10, 10, 10, 10, new java.awt.Color(255, 0, 0)));    //Alors on lui applique une bordure rouge
             else                                                //Sinon
                b.setBorder(null);                              //On ne lui applique aucune bordure
        }
        LesPersonnages lps = lp.getPersosFamille(fs);           //On récupère les personnages ayant pour famille la famille du JButton sélectionnée
        Infos.setText("Vous pouvez récupérer "+lps.getTaille()+" personnages : \n"+lps);    //On indique le nombre de personnages récupérable
        this.valide=true;//alors on peut effectuer un transfert
    }
    //methode pour creer le panneau
    private void creePanneau(JPanel jp, LesPersonnages lc) {
        jp.removeAll();//pour tout effacer
        int n = 1+(lc.getTaille()-1)/4;//instruction pour trouver le nombres de colonnes 
        PanneauG.setLayout(new java.awt.GridLayout(4, n));//construire la grille du panneau (ligne et colonne)
        for (int i=0;i<lc.getTaille();i++)//boucle pour parcourir et ajouter les boutons dans le panneau 
        {
            JButton jb = new JButton();//un objet de type JButton
            jp.add(jb);//ajouter le bouton
        }
        this.pack();
    }
    //Méthode pour dessiner le panneau
    private void dessinePanneau(JPanel jp, LesPersonnages lc) {
        for (int i=0;i<lc.getTaille();i++) //boucle pour parcourir les cartes
        {
            JButton jb = (JButton)jp.getComponent(i);//affecter à jb le bouton à la position i
            Image img=lc.getPerso(i).getPhoto().getScaledInstance(jb.getWidth(), jb.getHeight(), Image.SCALE_SMOOTH);//redimentionner l'image
            jb.setIcon(new ImageIcon (img));//affecter l'image au bouton 
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> ComboJoueurs;
    private javax.swing.JButton FermerButton;
    private javax.swing.JTextArea Infos;
    private javax.swing.JLabel Message;
    private javax.swing.JPanel PanneauD;
    private javax.swing.JPanel PanneauG;
    private javax.swing.JButton TransfertButton;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
