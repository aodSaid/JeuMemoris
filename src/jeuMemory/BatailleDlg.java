package jeuMemory;

import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;

public class BatailleDlg extends javax.swing.JDialog {
 //attributs   
 private LesJoueurs lj;//stocke l'ensemble des joueurs
 private int indj;//indice du joueur courant 
 private Joueur adversaire; //le joueur adversaire
 private boolean ok;//variable boolean pour valider ou annuler
 private Bataille b; //action ici bataille
 
    //constructeurs avec parametres
    public BatailleDlg(java.awt.Frame parent, boolean modal,LesJoueurs lj,int jc) {
        super(parent, modal);//appelle aux constructeurs de la classe ancêtre ici (JeuMemory)
        initComponents();//appelle à la methode de construction de l'EDI par l'interface
        //initialisation de l'interface
        this.lj= lj;  
        this.indj=jc;
        this.ok=false;
        this.b=null;
        initListeJ();//appelle à la methode iniListeJ() 
        Annuler.setVisible(false);//le bouton annuler est désactivé
        MessageJ.setText(lj.getJoueur(indj).getPseudo()+" va effectuer une bataille contre : ");//message qui s'affiche 
    }
    
    //Méthode pour remplir la liste des joueurs
    public void initListeJ() {
        //création du modéle de la liste
        DefaultListModel ml = new DefaultListModel();
        ListeJ.setModel(ml);//affectation du model à la liste
        //Boucle pour parcourir les elements de la liste
        for (int i=0; i<lj.getNbJoueurs();i++) {
            ml.addElement(lj.getJoueur(i).getPseudo());//ajout du nom de l'élément à la position i dans la liste
        }
    }
    
    //Accesseurs
    public LesJoueurs getLj() {
        return lj;
    }

    public void setLj(LesJoueurs lj) {
        this.lj = lj;
    }

    public int getIndj() {
        return indj;
    }

    public void setIndj(int indj) {
        this.indj = indj;
    }

    public Joueur getAdversaire() {
        return adversaire;
    }

    public void setAdversaire(Joueur adversaire) {
        this.adversaire = adversaire;
    }

    public boolean isOk() {
        return ok;
    }

    public void setOk(boolean ok) {
        this.ok = ok;
    }

    public Bataille getB() {
        return b;
    }

    //Accesseurs
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        MessageJ = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        ListeJ = new javax.swing.JList<>();
        jPanel2 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        Joueur = new javax.swing.JLabel();
        Adversaire = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        InfosCarte1 = new javax.swing.JTextArea();
        Carte1 = new javax.swing.JButton();
        Carte2 = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        InfosCarte2 = new javax.swing.JTextArea();
        jPanel3 = new javax.swing.JPanel();
        Vainqueur = new javax.swing.JLabel();
        Annuler = new javax.swing.JButton();
        Demarrer = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setLayout(new java.awt.GridLayout(1, 2));

        MessageJ.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPanel1.add(MessageJ);

        ListeJ.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ListeJMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(ListeJ);

        jPanel1.add(jScrollPane1);

        getContentPane().add(jPanel1, java.awt.BorderLayout.NORTH);

        jPanel2.setLayout(new java.awt.BorderLayout());

        jPanel4.setLayout(new java.awt.GridLayout(1, 2));

        Joueur.setText("joueur");
        jPanel4.add(Joueur);

        Adversaire.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        Adversaire.setText("Adversaire");
        jPanel4.add(Adversaire);

        jPanel2.add(jPanel4, java.awt.BorderLayout.NORTH);

        jPanel5.setLayout(new java.awt.GridLayout(1, 4));

        InfosCarte1.setColumns(20);
        InfosCarte1.setRows(5);
        jScrollPane2.setViewportView(InfosCarte1);

        jPanel5.add(jScrollPane2);

        Carte1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/jeuMemory/img/anonyme.png"))); // NOI18N
        jPanel5.add(Carte1);

        Carte2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/jeuMemory/img/anonyme.png"))); // NOI18N
        Carte2.setPreferredSize(new java.awt.Dimension(100, 135));
        jPanel5.add(Carte2);

        InfosCarte2.setColumns(20);
        InfosCarte2.setRows(5);
        jScrollPane3.setViewportView(InfosCarte2);

        jPanel5.add(jScrollPane3);

        jPanel2.add(jPanel5, java.awt.BorderLayout.CENTER);

        getContentPane().add(jPanel2, java.awt.BorderLayout.CENTER);

        jPanel3.setLayout(new java.awt.GridLayout(1, 3));

        Vainqueur.setText("Gagnant");
        jPanel3.add(Vainqueur);

        Annuler.setText("Annuler/fermer");
        Annuler.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AnnulerActionPerformed(evt);
            }
        });
        jPanel3.add(Annuler);

        Demarrer.setText("Demarrer");
        Demarrer.setEnabled(false);
        Demarrer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DemarrerActionPerformed(evt);
            }
        });
        jPanel3.add(Demarrer);

        getContentPane().add(jPanel3, java.awt.BorderLayout.SOUTH);

        pack();
    }// </editor-fold>//GEN-END:initComponents
    //Gestionnaire du clique sur le bouton Demarrer
    private void DemarrerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DemarrerActionPerformed
        InfosCarte1.setText(lj.getJoueur(indj).getPaquet().getPerso(0).toString());
        InfosCarte2.setText(this.adversaire.getPaquet().getPerso(0).toString());
        int res=this.b.execute();
       
        switch(res)
        {
            case -1:break;
            case 0:
            {
                InfosCarte1.setText("Il y a égalité!");
                InfosCarte2.setText("Il y a égalité!");
                Vainqueur.setText("Vainqueur : Aucun");
                break;
            }
            case 1:
            {
                InfosCarte1.setText("Le gagnant est : "+lj.getJoueur(indj).getPseudo()); 
                InfosCarte2.setText("Le gagnant est : "+lj.getJoueur(indj).getPseudo());
                Vainqueur.setText("Vainqueur : "+lj.getJoueur(indj).getPseudo());
                break;
            }
            case 2:
            {
                InfosCarte1.setText("Le gagnant est : "+adversaire.getPseudo());
                InfosCarte1.setText("Le gagnant est : "+adversaire.getPseudo());
                Vainqueur.setText("Vainqueur : "+this.adversaire.getPseudo());
                break;
            }
        }
        this.ok=true;
        
        if((lj.getJoueur(indj).getPaquet().getTaille()<1) || (this.adversaire.getPaquet().getTaille()<1))
        {
               Demarrer.setVisible(false);
               Annuler.setText("Fermer");
        }
        else
        {
                InfosCarte1.append(lj.getJoueur(indj).getPaquet().getPerso(0).toString()+"\n");
                InfosCarte2.append(this.adversaire.getPaquet().getPerso(0).toString()+"\n");
                Carte1.setIcon(new ImageIcon(lj.getJoueur(indj).getPaquet().getPerso(0).getPhoto()));
                Carte2.setIcon(new ImageIcon(this.adversaire.getPaquet().getPerso(0).getPhoto()));
        }
    }//GEN-LAST:event_DemarrerActionPerformed
    
    //Gestionnaire du clique sur le bouton Annuler
    private void AnnulerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AnnulerActionPerformed
        this.ok=false;
        //Condition pour vérifier si le text actuel du bouton est "Annuler"
        if (Annuler.getText().equals("Annuler"))
            this.b.setDeroulement("Bataille interrompue en cours de partie");//message du deroulement
        this.setVisible(false);//ferme la fenêtre
        this.dispose();//libre de l'espace memoire
    }//GEN-LAST:event_AnnulerActionPerformed
    //Gestionnaire du clique sur un element de la liste
    private void ListeJMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ListeJMouseClicked
        //condition pour verifier si c'est le joueur courant qui est séléctionné 
        if(ListeJ.isSelectedIndex(indj))
          {
             MessageJ.setText("Erreur! Vous avez choisi le joueur courant.");
             Demarrer.setEnabled(false);//désactiver le bouton demarrer ou non disponible
          }    
          else
          { 
             Demarrer.setEnabled(true);//sinon le bouton demarrer est disponible
             InfosCarte1.append(lj.getJoueur(indj).getPaquet().getPerso(0).toString()+"\n");//informations du joueur courant 
             MessageJ.setText("Vous allez affronter "+this.lj.getJoueur(ListeJ.getSelectedIndex()).getPseudo());//message à afficher
             Joueur joueurSelect=lj.getJoueur(ListeJ.getSelectedIndex());//affectation du joueur séléctionné à la variable de type joueur
             b= new Bataille(lj.getJoueur(indj),joueurSelect);//effectue la bataille entre le joueur courant et l'adversaire
             Annuler.setVisible(true);//bouton annuler est visible
             Joueur.setText(lj.getJoueur(indj).getPseudo());//affiche le nom du joueur courant 
             Adversaire.setText(joueurSelect.getPseudo());//affiche le nom du joueur adversaire
             InfosCarte1.setText(lj.getJoueur(indj).getPaquet().toString());//affiche les informations du joueur courant dans sa zone de text
             InfosCarte1.setText(joueurSelect.getPaquet().toString());//affiche les informations du joueur adversaire dans sa zone de text
             this.adversaire=joueurSelect;//affectation du joueur selectionné à l'attribut adversaire
          }
          
    }//GEN-LAST:event_ListeJMouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Adversaire;
    private javax.swing.JButton Annuler;
    private javax.swing.JButton Carte1;
    private javax.swing.JButton Carte2;
    private javax.swing.JButton Demarrer;
    private javax.swing.JTextArea InfosCarte1;
    private javax.swing.JTextArea InfosCarte2;
    private javax.swing.JLabel Joueur;
    private javax.swing.JList<String> ListeJ;
    private javax.swing.JLabel MessageJ;
    private javax.swing.JLabel Vainqueur;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    // End of variables declaration//GEN-END:variables
}
