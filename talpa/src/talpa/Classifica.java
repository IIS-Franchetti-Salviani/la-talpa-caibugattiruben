/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package talpa;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;


/**
 *
 * @author caibugatti.ruben
 */
public class Classifica {
    String file = "classifica.txt";
    Giocatore mioGiocatore;
    ArrayList<Giocatore> lista = new ArrayList<>();

    public void leggoClassifica(){
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String riga;
            while ((riga = br.readLine()) != null) {
                String[] parti = riga.split(",");
                String nome = parti[0];
                int punti = Integer.parseInt(parti[1]);
                lista.add(new Giocatore(nome, punti));
            }
        }catch (Exception e) {  }
    }
    
    public void gestioneLista(){
        lista.add(mioGiocatore);
        lista.sort((a, b) -> b.punti - a.punti);
        if (lista.size() > 10) {
            lista = new ArrayList<>(lista.subList(0, 10));
        }
    }
       
    public void creoGiocatore(String n,int p){
        mioGiocatore= new Giocatore(n,p);
    }
    
    public void scrivoClassifica(){
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(file))) {
            for (Giocatore g : lista) {
                bw.write(g.nome + "," + g.punti);
                bw.newLine();
            }
        } catch (Exception e) {}
    }
        
    public void gestioneNuovoEntrato(String n,int p){
        creoGiocatore(n,p);
        gestioneLista();
        scrivoClassifica();
    }
      
    public boolean isInTop10(int punteggio) {
        lista.clear();
        leggoClassifica();
        lista.sort((a, b) -> b.punti - a.punti);
        int numeroGiocatori = lista.size();
        if (numeroGiocatori < 10) {
            return true;
        }
        int punteggioUltimoTop10 = lista.get(9).punti;
        return punteggio >= punteggioUltimoTop10;
    }
}
