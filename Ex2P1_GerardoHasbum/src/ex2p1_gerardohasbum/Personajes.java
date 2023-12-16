//fila 2 silla 7
package ex2p1_gerardohasbum;

import java.util.ArrayList;
import java.util.Random;

public class Personajes {

    static Random ran = new Random();
    String nombre;
    double hp;
    int mp, atk, truatk;
    double def;

    public Personajes(String nombre, double hp, int mp, int atk, double def) {
        this.nombre = nombre;
        this.hp = hp;
        this.mp = mp;
        this.atk = atk;
        this.def = def;
    }

    public static Random getRan() {
        return ran;
    }

    public static void setRan(Random ran) {
        Personajes.ran = ran;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getHp() {
        return hp;
    }

    public void setHp(double hp) {
        this.hp = hp;
    }

    public int getMp() {
        return mp;
    }

    public void setMp(int mp) {
        this.mp = mp;
    }

    public int getAtk() {
        return atk;
    }

    public void setAtk(int atk) {
        this.atk = atk;
    }

    public int getTruatk() {
        return truatk;
    }

    public void setTruatk(int truatk) {
        this.truatk = truatk;
    }

    public double getDef() {
        return def;
    }

    public void setDef(double def) {
        this.def = def;
    }

    @Override
    public String toString() {
        return nombre+"\n"+"HP = "+hp+"\n"+"MP = "+mp+"\n"+"Attack points = "+atk+"\n"+"Defense points = "+def;
    }
    
    

}
