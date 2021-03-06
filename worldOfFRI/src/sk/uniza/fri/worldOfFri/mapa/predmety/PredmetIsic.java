/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sk.uniza.fri.worldOfFri.mapa.predmety;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import sk.uniza.fri.worldOfFri.hlavny.Hrac;
import sk.uniza.fri.worldOfFri.mapa.Budova;
import sk.uniza.fri.worldOfFri.mapa.dvere.IDvere;
import sk.uniza.fri.worldOfFri.mapa.dvere.InteligentneDvere;
import sk.uniza.fri.worldOfFri.mapa.Miestnost;


public class PredmetIsic implements IPredmet {

    @Override
    public String getNazov() {
        return "isic";
    }

    @Override
    public void pouziSa(Hrac hrac) {
        boolean otovrilSom = false;
        Miestnost aktualna = hrac.getAktualnaMiestnost();
        
        for (IDvere dvere : aktualna.getVsetkyDvere()) {
            if (dvere instanceof InteligentneDvere) {
                InteligentneDvere inteligentneDvere = (InteligentneDvere)dvere;
                inteligentneDvere.odomkni();
                otovrilSom = true;
            }
        }
        if (otovrilSom) {
            System.out.println("Otvaram dvere, pozor aby ta nebuchli");
        } else {
            System.out.println("Ako chces ten ISIC pouzit? Vsetky dvere okolo teba su blbe, potrebujes inteligentne");
        }
    }

    @Override
    public void ulozPoziciu(DataOutputStream pozicia) {
        
    }

    @Override
    public void nacitajPoziciu(DataInputStream pozicia, Budova budova, int verzia) {
        
    }
    
}
