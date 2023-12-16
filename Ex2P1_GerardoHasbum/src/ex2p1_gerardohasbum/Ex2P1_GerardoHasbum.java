//fila 2 silla 7
package ex2p1_gerardohasbum;

import java.util.Scanner;
import java.util.Random;
import java.util.ArrayList;

public class Ex2P1_GerardoHasbum {

    static Scanner jhin = new Scanner(System.in);
    static Random ran = new Random();

    public static void main(String[] args) {
        char res_us = 's';
        while (res_us == 's' || res_us == 'S') {//repeticion de proyecto
            int opcion = 0;
            int cont_combate = 3;
            Personajes p1 = new Personajes("Sora 👤", 300, 300, 75, .15);//creacion de personajes
            Personajes p2 = new Personajes("Donald 👤", 150, 450, 45, .10);
            Personajes p3 = new Personajes("Goofy 👤", 450, 100, 150, .50);
            Personajes p4 = new Personajes("Mickey 👤", 100, 500, 75, .35);
            Personajes p5 = new Personajes("Roxas 👤", 300, 300, 15, .75);
            Personajes p6 = new Personajes("Kairi 👤", 200, 200, 50, .15);
            ArrayList<Personajes> party = new ArrayList<Personajes>();//creacion de la lista de los personajes
            party.add(p1);
            party.add(p2);
            party.add(p3);
            ArrayList<Personajes> reserva = new ArrayList<Personajes>();//creacion de la lista de los personajes de reserva
            reserva.add(p4);
            reserva.add(p5);
            reserva.add(p6);
            Items o1 = new Items("Pocion", 50, 0);//creacion de items
            Items o2 = new Items("Ether", 0, 50);
            Items o3 = new Items("Elixir", 100, 100);
            ArrayList<Items> mochila = new ArrayList<Items>();//creacion de lista de items
            mochila.add(o1);
            mochila.add(o2);
            mochila.add(o3);
            for (int i = 1; i <= 20; i++) {//rondas
                System.out.println("♥♥♥ Se encuentra en el Cuarto " + i + " ♥♥♥");//identificador de cuarto
                int x = 1 + ran.nextInt(5);//randomizador de encuentro
                int cont_vivos = 0;
                for (int j = 0; j < party.size(); j++) {//valida que los de la party no esten muertos
                    if (party.get(j).getHp() <= 0) {
                        party.get(j).setHp(0);
                    } else {
                        cont_vivos++;
                    }
                }
                
                if (cont_vivos == 0) {
                    System.out.println("Tus personajes estan muertos y no puedes continuar jugando :C");
                    break;
                }
                switch (x) {
                    case 1://encuentro heartless
                        int y = 1 + ran.nextInt(3);//creacion de cantidad de heartless
                        System.out.println("Se ha encontrado con " + y + " hearless!");
                        int hp_heart = 75 * y;//vida total de los heartless
                        int atk_heart = 25 * y;//atk total de los heartless
                        while (hp_heart > 0) {//valida que cuando se mueran los heartless pare el loop
                            cont_combate = 0;//para validar que la party este viva en pleno combate y si se mueren no continuar y reiniciar el proyecto
                            for (int j = 0; j < party.size(); j++) {//valida que la party este viva para empezar
                                if (party.get(j).getHp() <= 0) {
                                    party.get(j).setHp(0);
                                } else {
                                    cont_combate++;
                                }
                            }
                            if (cont_combate == 0) {//si la party esta completamente muerta entonces no se continua
                                System.out.println("Tu party ha muerto y no puedes continuar jugando :c");
                                break;
                            }
                            if (hp_heart <= 0) {//hace que sin importar cuanto daño se le haga al heartless quede en 0 HP
                                hp_heart = 0;
                            }
                            PrintP(party);//imprime la party
                            System.out.print("Eliga el personaje: ");
                            int opcionP = jhin.nextInt();//Eleccion de personaje
                            while (opcionP < 0 || opcionP > 2) {//valida que no ponga un numero que no deberia de elegir
                                System.out.print("Ese valor no se puede usar porfavor ingrese otro: ");
                                opcionP = jhin.nextInt();
                            }
                            Personajes temporal = party.get(opcionP);//crea un personaje para el intercambio
                            System.out.println("♥♥♥ MENU ♥♥♥");//menu
                            System.out.println("1. Ataque ⚔︎");
                            System.out.println("2. Item 💼");
                            System.out.println("3. Magia ★");
                            System.out.println("4. Cambio ↔");
                            System.out.println("♥♥♥♥♥♥♥♥♥♥♥");
                            System.out.print("Eliga su opcion: ");
                            int opcionM = jhin.nextInt() - 1;
                            while (opcionM < 0 || opcionM > 3) {//validacion que no ponga un valor que no
                                System.out.print("Ese valor no se puede usar porfavor ingrese otro: ");
                                opcionM = jhin.nextInt();
                            }
                            if (temporal.getHp() == 0) {//si el personaje esta muerto solo lo dejara cambiarlo por otro
                                while (opcionM != 3) {
                                    System.out.println("Ese personaje no puede hacer esa accion eliga cambiar personaje: ");
                                    System.out.println("♥♥♥ MENU ♥♥♥");
                                    System.out.println("0. Ataque ⚔︎");
                                    System.out.println("1. Item 💼");
                                    System.out.println("2. Magia ★");
                                    System.out.println("3. Cambio ↔");
                                    System.out.println("♥♥♥♥♥♥♥♥♥♥♥");
                                    System.out.print("Eliga su opcion: ");
                                    opcionM = jhin.nextInt();
                                }
                            }
                            switch (opcionM) {
                                case 0://ataque
                                    double truatk = atk_heart - (atk_heart * temporal.def);
                                    System.out.println(temporal.getNombre() + " Recibe el daño");
                                    hp_heart = hp_heart - temporal.getAtk();
                                    if (hp_heart <= 0) {
                                        hp_heart = 0;
                                    }
                                    System.out.println("Los heartless les queda " + hp_heart + " de vida");
                                    temporal.setHp(temporal.getHp() - truatk);
                                    party.remove(opcionP);
                                    party.add(opcionP, temporal);
                                    break;

                                case 1://item
                                    if (mochila.size() == 0) {
                                        System.out.println("!!!!!No tiene items :c!!!!!");
                                    } else {
                                        PrintM(mochila);
                                        System.out.print("Eliga que item desea usar: ");
                                        int opcionI = jhin.nextInt();
                                        Items temp = mochila.get(opcionI);
                                        mochila.remove(opcionI);
                                        temporal.setHp(temp.getHeal() + temporal.getHp());
                                        temporal.setMp(temp.getMana() + temporal.getMp());
                                        System.out.println(temporal.getNombre() + " uso " + temp.getNombre());
                                        truatk = atk_heart - (atk_heart * temporal.def);
                                        System.out.println(temporal.getNombre() + " Recibe el daño");
                                        System.out.println("Los heartless les queda " + hp_heart + " de vida");
                                        temporal.setHp(temporal.getHp() - truatk);
                                        party.remove(opcionP);
                                        party.add(opcionP, temporal);
                                    }
                                    break;

                                case 2://magia
                                    System.out.println("1.- Blizzard 🌪️  50MP - 50ATK");
                                    System.out.println("2.- Firaga   🔥  25MP - 25ATK");
                                    System.out.println("3.- Gravity  💀  75MP - 100ATK");
                                    System.out.print("Eliga que magia usar: ");
                                    int opcionMP = jhin.nextInt() - 1;
                                    switch (opcionMP) {
                                        case 0:
                                            if (temporal.getMp() == 0) {
                                                System.out.println("!!!!!No puede usar ese hechizo :c!!!!!");
                                            } else {

                                                temporal.setMp(temporal.getMp() - 50);
                                                if (temporal.getMp() <= 0) {
                                                    temporal.setMp(0);
                                                }
                                                System.out.println(temporal.getNombre() + " uso Blizzard 🌪");
                                                truatk = atk_heart - (atk_heart * temporal.def);
                                                System.out.println(temporal.getNombre() + " Recibe el daño");
                                                hp_heart = hp_heart - 50;
                                                if (hp_heart <= 0) {
                                                    hp_heart = 0;
                                                }
                                                System.out.println("Los heartless les queda " + hp_heart + " de vida");
                                                temporal.setHp(temporal.getHp() - truatk);
                                                party.remove(opcionP);
                                                party.add(opcionP, temporal);
                                            }
                                            break;

                                        case 1:
                                            if (temporal.getMp() == 0) {
                                                System.out.println("!!!!!No puede usar ese hechizo :c!!!!!");
                                            } else {
                                                temporal.setMp(temporal.getMp() - 25);
                                                if (temporal.getMp() <= 0) {
                                                    temporal.setMp(0);
                                                }
                                                System.out.println(temporal.getNombre() + " uso Firaga 🔥");
                                                truatk = atk_heart - (atk_heart * temporal.def);
                                                System.out.println(temporal.getNombre() + " Recibe el daño");
                                                hp_heart = hp_heart - 25;
                                                if (hp_heart <= 0) {
                                                    hp_heart = 0;
                                                }
                                                System.out.println("Los heartless les queda " + hp_heart + " de vida");
                                                temporal.setHp(temporal.getHp() - truatk);
                                                party.remove(opcionP);
                                                party.add(opcionP, temporal);
                                            }
                                            break;

                                        case 2:
                                            if (temporal.getMp() == 0) {
                                                System.out.println("!!!!!No puede usar ese hechizo :c!!!!!");
                                            } else {
                                                temporal.setMp(temporal.getMp() - 75);
                                                if (temporal.getMp() <= 0) {
                                                    temporal.setMp(0);
                                                }
                                                System.out.println(temporal.getNombre() + " uso Gravity 💀");
                                                truatk = atk_heart - (atk_heart * temporal.def);
                                                System.out.println(temporal.getNombre() + " Recibe el daño");
                                                hp_heart = hp_heart - 100;
                                                if (hp_heart <= 0) {
                                                    hp_heart = 0;
                                                }
                                                System.out.println("Los heartless les queda " + hp_heart + " de vida");
                                                temporal.setHp(temporal.getHp() - truatk);
                                                party.remove(opcionP);
                                                party.add(opcionP, temporal);
                                            }
                                            break;
                                    }
                                    break;

                                case 3://cambio
                                    PrintP(reserva);
                                    System.out.print("Eliga por cual personaje desea cambiarlo: ");
                                    int opcionR = jhin.nextInt();
                                    Personajes temporal2 = reserva.get(opcionR);
                                    reserva.remove(opcionR);
                                    reserva.add(opcionP, temporal);
                                    party.remove(opcionP);
                                    party.add(opcionP, temporal2);

                                    break;
                            }
                        }
                        if (cont_combate > 0) {//por si el ultimo personaje vivo se muere en el ultimo intercambio
                            System.out.println("Desea continuar?");
                            jhin.next();
                            break;
                        } else {
                            System.out.println("Todos tus personajes murieron en combate, intentar de nuevo?");
                            break;
                        }

                    case 2://cofre pocion
                        System.out.println("Ha encontrado un cofre con una pocion 💼 :D");
                        mochila.add(o1);
                        System.out.println("Desea continuar?");
                        jhin.next();
                        break;

                    case 3://cofre ether
                        mochila.add(o2);
                        System.out.println("ha encontrado un cofre con un Ether 💼 :D");
                        System.out.println("Desea continuar?");
                        jhin.next();
                        break;

                    case 4://cofre elixir
                        System.out.println("Ha encontrado un cofre con un Elixir 💼 :D");
                        mochila.add(o3);
                        System.out.println("Desea continuar?");
                        jhin.next();
                        break;

                    case 5://amigos en peril
                        System.out.println("Se ha encontrado amigos que necesitan de su ayuda! 👨‍👩‍👦‍👦");

                        if (mochila.size() == 0) {//valida que hayan objetos en la mochila para dar
                            System.out.println("No tienes suficientes objetos para ayudarlos :c");
                        } else {//si hay objetos hace esto para regalarlos
                            int dar = 1 + ran.nextInt(mochila.size());
                            for (int j = 0; j < dar; j++) {
                                mochila.remove(0);
                            }
                            System.out.println("Les has regalado " + dar + " objetos!");
                        }
                        System.out.println("Desea continuar?");
                        jhin.next();
                        break;
                }
                if (cont_combate < 0) {//valida de nuevo si los personajes de la party estan muertos y si lo estan se sale del juego
                    break;
                }
            }
            System.out.print("Desea volver a jugar? [s/n]: ");//loop para repetir el proyecto
            res_us = jhin.next().charAt(0);
        }
    }

    public static void PrintP(ArrayList<Personajes> perso) {//metodo para imprimir party
        for (int i = 0; i < perso.size(); i++) {
            System.out.println(i + ".- " + perso.get(i).toString());
        }
    }

    public static void PrintM(ArrayList<Items> moch) {//metodo para imprimir objetos
        for (int i = 0; i < moch.size(); i++) {
            System.out.println(i + ".- " + moch.get(i).toString() + " 💼");
        }
    }
}
