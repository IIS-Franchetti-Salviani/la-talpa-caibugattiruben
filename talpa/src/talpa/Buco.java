/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package talpa;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;

/**
 *
 * @author caibugatti.ruben
 */
public class Buco extends JButton {
    boolean presenzaTalpa;
    private Talpa talpa;
    
    public void creoAction(){
        this.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(presenzaTalpa==false){
                    System.out.println("ciao");
                }
            }
        });
    }
    
    public void setTalpa(Talpa t) {
        this.talpa = t;
    }

    public Talpa getTalpa() {
        return talpa;
    }
    
    public void disattivoTasto(){
        this.setEnabled(false);
    }
    
    public void attivoTasto(){
        this.setEnabled(true);
    }
}
