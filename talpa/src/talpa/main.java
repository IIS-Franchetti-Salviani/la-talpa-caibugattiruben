/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package talpa;

/**
 *
 * @author ruben
 */
public class main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Classifica classifica = new Classifica();
        GestoreGioco gestore = new GestoreGioco(classifica);
        gestore.avvia();
    }
    
}
