package jeuMemory;


import java.awt.*;
import java.awt.event.ActionListener;
import javax.swing.*;

public class PanneauImage extends JPanel {
    
    private Image img;
    
    public PanneauImage()
    {
        super();
        this.img=null;
    }
    
    public PanneauImage(Image im)
    {   super();
        this.img=im;
    }
    
    public Image getImage () { return this.img;}
    public void setImage (Image im) { this.img=im;this.repaint();
    }

    @Override   
    public void paint(Graphics g){
        super.paint(g);
        if(this.img!=null){
            g.drawImage(img,0 ,0 ,this.getWidth(), this.getHeight(), this);
        }
    }

    void addActionListener(ActionListener actionListener) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

   


}
