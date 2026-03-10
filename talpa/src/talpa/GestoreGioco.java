/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package talpa;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.RenderingHints;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.Timer;

/**
 *
 * @author caibugatti.ruben
 */
public class GestoreGioco {
    private JLabel punti;
    private JLabel tempo;
    private Buco[] buchi = new Buco[9];
    private Talpa talpa;
    private Thread threadTalpa;
    private Timer t;
    private int tempoSec = 60;
    private int punteggioAttuale = 0;
    private ImageIcon iconaTalpa = new ImageIcon("talpa.png");
    private ImageIcon iconaBuco = new ImageIcon("buco.png");
    private Classifica c;

    public GestoreGioco(Classifica c) {
        this.c = c;
        punti = new JLabel("");
        tempo = new JLabel("");
    }
    
    public void avvia(){
        FormAvvio a=new FormAvvio(this,c);
        a.setVisible(true);
    }
    public void preparaPannello(JPanel panel) {
        int k = 0;

        for (int r = 0; r < 4; r++) {
            for (int col = 0; col < 4; col++) {

                if (r == 0 && col == 0) {
                    panel.add(creaPannelloConLabel(tempo));
                } else if (r == 1 && col == 0) {
                    panel.add(creaPannelloConLabel(punti));
                } else if (r >= 1 && col >= 1) {
                    buchi[k] = creaBuco();
                    panel.add(buchi[k]);
                    k++;
                } else {
                    panel.add(new JLabel(""));
                }

            }
        }

        talpa = creaTalpa();
    }

    private JPanel creaPannelloConLabel(JLabel label) {
        JPanel p = new JPanel() {
            Image imgSfondo = new ImageIcon("cassetta.png").getImage();
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(imgSfondo, 0, 0, getWidth(), getHeight(), this);
            }
        };
        p.setOpaque(false);
        p.setLayout(new GridLayout(1, 1, 20, 20));
        p.add(label);
        label.setHorizontalAlignment(SwingConstants.CENTER);
        label.setVerticalAlignment(SwingConstants.CENTER);
        label.setForeground(Color.WHITE);
        label.setFont(new Font("Arial", Font.BOLD, 30));
        return p;
    }

    private Buco creaBuco() {
        return new Buco(this) {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Graphics2D g2d = (Graphics2D) g.create();
                g2d.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
                g2d.drawImage(iconaBuco.getImage(), 0, 0, getWidth(), getHeight(), this);
                g2d.dispose();
            }
        };
    }

    private Talpa creaTalpa() {
        return new Talpa(buchi, null, 100, 300, this) {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Graphics2D g2d = (Graphics2D) g.create();
                g2d.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
                g2d.drawImage(iconaTalpa.getImage(), 0, 0, getWidth(), getHeight(), this);
                g2d.dispose();
            }
        };
    }

    public void avviaGioco() {
        punti.setText("0");
        t = new Timer(1000, e -> aggiornaTempo());
        t.start();
        threadTalpa = new Thread(talpa);
        threadTalpa.start();
    }

    private void aggiornaTempo() {
        if (tempoSec == -1) {
            t.stop();
            threadTalpa.interrupt();
            JOptionPane.showMessageDialog(null, "Il tempo è finito!!!!!!");
            if (c.isInTop10(punteggioAttuale)) {
                String nome = JOptionPane.showInputDialog(null, "Inserisci il tuo nome:");
                c.gestioneNuovoEntrato(nome, punteggioAttuale);
            } else {
                JOptionPane.showMessageDialog(null, "Non sei in top 10");
            }
        } else {
            scorriTempo(tempo, tempoSec);
            tempoSec--;
        }
    }

    private void scorriTempo(JLabel tempoLabel, int t) {
        tempoLabel.setText(String.valueOf(t));
    }
    
    public synchronized void aggiungiPunto(int v) {
        punteggioAttuale=punteggioAttuale+v;
        punti.setText(String.valueOf(punteggioAttuale));
    }
   
    
}
