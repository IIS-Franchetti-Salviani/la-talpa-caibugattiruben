/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package talpa;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;

/**
 *
 * @author caibugatti.ruben
 */
public class Buco extends JButton {
    boolean presenzaTalpa;
    private Talpa talpa;
    GestoreGioco g;
    
    public Buco(ImageIcon icona){
        super(icona);
        this.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               
            }
        });
        this.setContentAreaFilled(false);
        this.setBorderPainted(false);
        this.setFocusPainted(false);
        this.setOpaque(false);
    }
    
    
    public void setTalpa(Talpa t) {
        this.talpa = t;
    }

    public Talpa getTalpa() {
        return talpa;
    }
    

}
