/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sk.uniza.fri.worldOfFri.mapa;

import sk.uniza.fri.worldOfFri.hlavny.Hrac;

/**
 *
 * @author janik
 */
class Portal implements IDvere {

    private final String nazov;
    private Portal portal;
    private Miestnost miestnost;

    Portal(String nazov) {
        this.nazov = nazov;
        this.portal = null;
        this.miestnost = null;
    }

    @Override
    public Miestnost getVychod() {
        return this.portal.miestnost;
    }

    @Override
    public boolean mozePrejst() {
        return this.portal.miestnost != null;
    }

    @Override
    public void hracPresiel(Hrac hrac) {
        System.out.format("Presiel si %sm portalom%n", this.nazov);
    }

    void prepoj(Portal portal) {
        this.portal = portal;
    }

    void presunDo(Miestnost miestnost) {
        if (this.miestnost != null) {
            this.miestnost.zrusVychod(this.nazov);
        }
        
        this.miestnost = miestnost;
        
        this.miestnost.nastavVychod(this.nazov, this);
    }

    public String getNazov() {
        return this.nazov;
    }
    
}