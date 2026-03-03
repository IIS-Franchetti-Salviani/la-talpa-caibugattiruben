/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package talpa;

import java.util.ArrayList;

/**
 *
 * @author caibugatti.ruben
 */
public class GestoreGioco {
    private int punteggioAttuale=0;
    ArrayList<Buco> buchi=new ArrayList();
    
    public void creoBuchi(){
        for(int i=0;i<9;i++){
            buchi.add(new Buco());
        }
    }
   
    
}
