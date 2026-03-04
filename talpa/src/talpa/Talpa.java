/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package talpa;

import java.util.Random;
import javax.swing.ImageIcon;
import javax.swing.JButton;

/**
 *
 * @author caibugatti.ruben
 */
public class Talpa extends JButton implements Runnable{
    private Buco[] buche;      
    private Random random = new Random();
    
    private int tempoMinAttesa;   
    private int tempoMaxAttesa;
    
    public Talpa(Buco[] buche, ImageIcon icona, int tempoMinAttesa, int tempoMaxAttesa) {
        super(icona);
        this.buche = buche;
        this.tempoMinAttesa = tempoMinAttesa;
        this.tempoMaxAttesa = tempoMaxAttesa;
        this.setVisible(false);
        this.setFocusable(false);

        this.addActionListener(e -> this.setVisible(false));
    }
    
    @Override
    public void run() {
        while(true) {

            try {
                
                int attesa = tempoMinAttesa + random.nextInt(tempoMaxAttesa - tempoMinAttesa + 1);
                Thread.sleep(attesa);

                int i = random.nextInt(buche.length);
                Buco b = buche[i];
                
                this.setContentAreaFilled(false);
                this.setBorderPainted(false);
                this.setFocusPainted(false);
                this.setOpaque(false);
                
                b.add(this);
                b.setTalpa(this);
                b.getTalpa().setVisible(true);
                b.setEnabled(false);

                Thread.sleep(3000);

                b.getTalpa().setVisible(false);
                b.setEnabled(true);
                b.remove(this);
            } 
            catch (InterruptedException e) {}
        }
    }
}
