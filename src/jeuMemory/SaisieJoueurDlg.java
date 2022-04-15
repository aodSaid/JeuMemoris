
package jeuMemory;

import java.awt.Color;
import java.awt.Image;
import java.awt.Toolkit;
import java.util.ArrayList;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;

public class SaisieJoueurDlg extends javax.swing.JDialog {
    private Joueur j;
    private boolean ok;
    private ImageIcon photo;
    private LesPersonnages lp;   
    private  ArrayList <String> l;
    private PanneauImage PanImage;
    private BoutonImage BtImage;
        
        
    public SaisieJoueurDlg(java.awt.Frame parent, boolean modal,LesPersonnages lp) {
        super(parent, modal);//appel du constructeur de l'ancêtre ici JDialod 
        initComponents();//Creation de l'interface par IDE
        //initialisation des données (attributs)
        this.lp = lp;
        this.l = this.lp.getFamilles();
        initListeFamilles();//appelle de methode qui remplie la liste avec le nom de famille de joueur
        this.PanImage= new PanneauImage();
        this.DPanel.add(PanImage);
        
    }
    
    public Joueur getJ() {return j;}
    public void setJ(Joueur j) {this.j = j;}
    public boolean isOk() {return ok;}
    public void setOk(boolean ok) {this.ok = ok;}
    public ImageIcon getPhoto() {return photo;}
    public void setPhoto(ImageIcon photo) {this.photo = photo;}
    public LesPersonnages getLp() {return lp;}
    public void setLp(LesPersonnages lp) {this.lp = lp;}
    
    
    private void initListeFamilles() {                  //Méthode pour remplir la liste avec le nom de famille des joueurs
        DefaultListModel mod=new DefaultListModel();    //Création du modele
        for(int i=0;i<l.size();i++)                     //Boucle pour parcourir la liste entière
        {mod.addElement(l.get(i));}                     //Ajout de l'élément indice i à la liste
        ListeFamille.setModel(mod);                     //Associe le modele à la liste
    }
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        titreLabel = new javax.swing.JLabel();
        ContenuPanel = new javax.swing.JPanel();
        GPanel = new javax.swing.JPanel();
        pseudoPanel = new javax.swing.JPanel();
        PseudoLabel = new javax.swing.JLabel();
        pseudoScrollPane = new javax.swing.JScrollPane();
        Pseudo = new javax.swing.JTextArea();
        famillePanel = new javax.swing.JPanel();
        FamilleLabel = new javax.swing.JLabel();
        familleScrollPane = new javax.swing.JScrollPane();
        ListeFamille = new javax.swing.JList<>();
        photoPanel = new javax.swing.JPanel();
        photoLabel = new javax.swing.JLabel();
        ParcourirButton = new javax.swing.JButton();
        DPanel = new javax.swing.JPanel();
        buttonsPanel = new javax.swing.JPanel();
        AnnulerButton = new javax.swing.JButton();
        ValiderButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        titreLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        titreLabel.setText("Créez votre joueur !");
        getContentPane().add(titreLabel, java.awt.BorderLayout.NORTH);

        ContenuPanel.setLayout(new java.awt.GridLayout(1, 2));

        GPanel.setLayout(new java.awt.GridLayout(3, 1));

        pseudoPanel.setLayout(new java.awt.BorderLayout());

        PseudoLabel.setText("Donnez votre pseudo :");
        PseudoLabel.setVerticalTextPosition(javax.swing.SwingConstants.TOP);
        pseudoPanel.add(PseudoLabel, java.awt.BorderLayout.NORTH);

        Pseudo.setColumns(20);
        Pseudo.setRows(5);
        pseudoScrollPane.setViewportView(Pseudo);

        pseudoPanel.add(pseudoScrollPane, java.awt.BorderLayout.CENTER);

        GPanel.add(pseudoPanel);

        famillePanel.setLayout(new java.awt.BorderLayout());

        FamilleLabel.setText("Quelle est votre famille préférée de personnages ? ");
        famillePanel.add(FamilleLabel, java.awt.BorderLayout.NORTH);

        familleScrollPane.setViewportView(ListeFamille);

        famillePanel.add(familleScrollPane, java.awt.BorderLayout.CENTER);

        GPanel.add(famillePanel);

        photoPanel.setLayout(new java.awt.BorderLayout());

        photoLabel.setText("Choisissez une photo :");
        photoPanel.add(photoLabel, java.awt.BorderLayout.NORTH);

        ParcourirButton.setText("Parcourir");
        ParcourirButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ParcourirButtonActionPerformed(evt);
            }
        });
        photoPanel.add(ParcourirButton, java.awt.BorderLayout.CENTER);

        GPanel.add(photoPanel);

        ContenuPanel.add(GPanel);

        DPanel.setLayout(new java.awt.BorderLayout());

        buttonsPanel.setLayout(new java.awt.GridLayout(1, 2));

        AnnulerButton.setText("Annuler");
        AnnulerButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AnnulerButtonActionPerformed(evt);
            }
        });
        buttonsPanel.add(AnnulerButton);

        ValiderButton.setText("Valider");
        ValiderButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ValiderButtonActionPerformed(evt);
            }
        });
        buttonsPanel.add(ValiderButton);

        DPanel.add(buttonsPanel, java.awt.BorderLayout.SOUTH);

        ContenuPanel.add(DPanel);

        getContentPane().add(ContenuPanel, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents
    //Gestionnaire du clic sur le bouton annuler
    private void AnnulerButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AnnulerButtonActionPerformed
            this.ok=false;//Ferme la fenêtre 
            this.setVisible(false);//
            this.dispose();//libere de la memoire
    }//GEN-LAST:event_AnnulerButtonActionPerformed
    //Gestionnaire du clic sur le bouton Parcourir
    private void ParcourirButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ParcourirButtonActionPerformed
        JFileChooser jf=new JFileChooser();
        if(jf.showOpenDialog(this)==JFileChooser.APPROVE_OPTION)
        {
            String path = jf.getSelectedFile().getPath(); // chemin complet;
            Image img =Toolkit.getDefaultToolkit().getImage(path);
            PanImage.setImage(img);
        }
    }//GEN-LAST:event_ParcourirButtonActionPerformed
    //Gestionnaire du clic sur le bouton valider
    private void ValiderButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ValiderButtonActionPerformed
        if (Pseudo.getText().equals(""))
            {
            PseudoLabel.setForeground(Color.red);
            }
        else
            {
            if(ListeFamille.getSelectedIndex()==-1)
                {FamilleLabel.setForeground(Color.red);}
            else
                {
                this.j=new Joueur(Pseudo.getText(),l.get(ListeFamille.getSelectedIndex()));
                if (this.photo!=null)
                    {
                    this.j.setPhoto(photo);
                    }
                this.ok=true;
                this.setVisible(false);
                this.dispose();
                }
            }
    }//GEN-LAST:event_ValiderButtonActionPerformed



    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AnnulerButton;
    private javax.swing.JPanel ContenuPanel;
    private javax.swing.JPanel DPanel;
    private javax.swing.JLabel FamilleLabel;
    private javax.swing.JPanel GPanel;
    private javax.swing.JList<String> ListeFamille;
    private javax.swing.JButton ParcourirButton;
    private javax.swing.JTextArea Pseudo;
    private javax.swing.JLabel PseudoLabel;
    private javax.swing.JButton ValiderButton;
    private javax.swing.JPanel buttonsPanel;
    private javax.swing.JPanel famillePanel;
    private javax.swing.JScrollPane familleScrollPane;
    private javax.swing.JLabel photoLabel;
    private javax.swing.JPanel photoPanel;
    private javax.swing.JPanel pseudoPanel;
    private javax.swing.JScrollPane pseudoScrollPane;
    private javax.swing.JLabel titreLabel;
    // End of variables declaration//GEN-END:variables
}
