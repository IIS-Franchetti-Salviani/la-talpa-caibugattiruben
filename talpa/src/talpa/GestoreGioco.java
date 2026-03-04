/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package talpa;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author caibugatti.ruben
 */
public class GestoreGioco {
    private int punteggioAttuale=0;
    Buco[] buchi=new Buco[9];
    private Talpa talpa;
    ImageIcon iconaTalpa=new ImageIcon("talpa.png");
    
    public GestoreGioco(JPanel panel) {
        JLabel punti=new JLabel("0");
        JLabel vuoto=new JLabel("");
        JLabel tempo=new JLabel("0");
        panel.add(punti);
        panel.add(vuoto);
        panel.add(tempo);
        
        for(int i=0; i<9; i++){
            buchi[i] = new Buco();
            panel.add(buchi[i]);
        }
        
        
        
        talpa = new Talpa(buchi, iconaTalpa, 400, 1700);
        Thread t = new Thread(talpa);
        t.start();
        
        
    }
    
  
   
    
}
