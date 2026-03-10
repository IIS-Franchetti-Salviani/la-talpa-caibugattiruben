/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package talpa;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

/**
 *
 * @author caibugatti.ruben
 */
public class GestoreGioco {
    private int punteggioAttuale=0;
    Buco[] buchi=new Buco[9];
    private Talpa talpa;
    ImageIcon iconaTalpa=new ImageIcon("talpa.png");
    ImageIcon iconaBuco=new ImageIcon("buco.png");
    Timer t;
    private int tempoSec=60;
    
    public GestoreGioco(JPanel panel) {
        JLabel punti=new JLabel("0");
        JLabel tempo=new JLabel("");
        int k = 0;
        
        //creo le buche
        for (int r = 0; r < 4; r++) {
            for (int c = 0; c < 4; c++) {

                if (r == 0 && c == 0) {
                    panel.add(tempo);
                } 
                else if (r == 1 && c == 0) {
                    panel.add(punti);
                } 
                else if (r >= 1 && c >= 1) {
                    buchi[k] = new Buco(null){
                        @Override
                        protected void paintComponent(Graphics g) {
                            super.paintComponent(g); 
                            Graphics2D g2d = (Graphics2D) g.create();

                            g2d.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);

                            g2d.drawImage(iconaBuco.getImage(), 0, 0, getWidth(), getHeight(), this);

                            g2d.dispose();
                        }
                    };
                    panel.add(buchi[k]);
                    k++;
                } 
                else {
                    panel.add(new JLabel(""));
                }

            }
        }
        Thread tread = new Thread(talpa);
        tread.start();
        
        //creo la talpa
        talpa = new Talpa(buchi, null, 100, 300){
                        @Override
                        protected void paintComponent(Graphics g) {
                            super.paintComponent(g); 
                            Graphics2D g2d = (Graphics2D) g.create();

                            g2d.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);

                            g2d.drawImage(iconaTalpa.getImage(), 0, 0, getWidth(), getHeight(), this);

                            g2d.dispose();
                        }
                    };
        
        t= new Timer(1000, e -> {
            if(tempoSec==0){
                t.stop();
            }
            else{
                scorriTempo(tempo,tempoSec);
                tempoSec=tempoSec-1;
            }
            
        });
        t.start();
    }
    
    public void scorriTempo(JLabel tempo,int t){
        tempo.setText(String.valueOf(t));
    }
    
  
   
    
}
