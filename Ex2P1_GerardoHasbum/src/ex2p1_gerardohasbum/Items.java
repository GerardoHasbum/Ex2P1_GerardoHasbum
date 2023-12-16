//fila 2 silla 7
package ex2p1_gerardohasbum;

import java.util.ArrayList;

public class Items {

    ArrayList<String> mochila = new ArrayList<String>();
    String Nombre;
    int heal, mana;

    public Items(String Nombre, int heal, int mana) {
        this.Nombre = Nombre;
        this.heal = heal;
        this.mana = mana;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public int getHeal() {
        return heal;
    }

    public void setHeal(int heal) {
        this.heal = heal;
    }

    public int getMana() {
        return mana;
    }

    public void setMana(int mana) {
        this.mana = mana;
    }

    
    @Override
    public String toString() {
        return "Item: " + Nombre + ", HPpoints = " + heal + ", MPpoints = " + mana;
    }
    
    
}
