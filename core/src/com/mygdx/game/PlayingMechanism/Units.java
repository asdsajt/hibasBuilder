package com.mygdx.game.PlayingMechanism;

import static com.mygdx.game.PlayingMechanism.Statistics.*;

/**
 * Created by tanulo on 2017. 02. 01..
 */
public class Units {

    public static int kardosLetszam = 0;
    public static int ijjaszLetszam = 0;
    public static int lovasLetszam = 0;
    public static int agyusLetszam = 0;

    static int kardosEro = 1;
    static int ijjaszEro = 2;
    static int lovasEro = 3;
    static int agyusEro = 4;


    //lakos,fa,ko,arany
    public static int[] kardosKoltseg = {1,1,1,2};
    public static int[] ijjaszKoltseg = {1,3,1,3};
    public static int[] lovasKoltseg = {2,1,1,4};
    public static int[] agyusKoltseg = {3,2,3,5};

    static public int getLetszam(){
        int i = 0;
        i+=kardosLetszam;
        i+=ijjaszLetszam;
        i+=lovasLetszam*lovasKoltseg[0];
        i+=agyusLetszam*agyusKoltseg[0];
        return i;
    }
    
    static public int harc(int[] egy,int[] ketto){
        int csapategy = egy[0]*kardosEro + egy[1]*ijjaszEro + egy[2]*lovasEro + egy[3]*agyusEro;
        int csapatketto = ketto[0]*kardosEro + ketto[1]*ijjaszEro + ketto[2]*lovasEro + ketto[3]*agyusEro;

        return csapategy-csapatketto;
    }

    static public void kivon(int egyseg){
        boolean[] t;
        for (int i = 0; i < egyseg; i++) {
            t = new boolean[]{kardosLetszam > 0, ijjaszLetszam > 0, lovasLetszam > 0, agyusLetszam > 0};
            if(t[0] || t[1] || t[2] || t[3]){
                int a = TimeStepper.vel(0,3);
                levon(a);
            }
        }
    }

    static void levon(int a){
        boolean sikerult = false;
        while(!sikerult){
            if(a == 0) {
                if(kardosLetszam>0){
                    kardosLetszam--;
                    sikerult = true;
                }
            }else if(a == 1){
                if(ijjaszLetszam>0){
                    ijjaszLetszam--;
                    sikerult = true;
                }
            }else if(a == 2){
                if(lovasLetszam>0){
                    lovasLetszam--;
                    sikerult = true;
                }
            }else if(a == 3){
                if(agyusLetszam>0){
                    agyusLetszam--;
                    sikerult = true;
                }
            }
            a++;
            if(a>3) a=0;
        }
    }

    public static int getEro() {
        int ero = kardosLetszam*kardosEro + ijjaszLetszam*ijjaszEro + lovasLetszam*lovasEro + agyusLetszam*agyusEro;
        return ero;
    }

    //lakos,fa,ko,arany

    public static void ujAgyus() {
        if(lakosokszama >= agyusKoltseg[0] && fa >= agyusKoltseg[1] && ko >= agyusKoltseg[2] && arany >= agyusKoltseg[3]){
            lakosokszama -= agyusKoltseg[0];
            fa -= agyusKoltseg[1];
            ko -= agyusKoltseg[2];
            arany -= agyusKoltseg[3];
            agyusLetszam++;
        }
    }

    public static void ujLovas() {
        if(lakosokszama >= lovasKoltseg[0] && fa >= lovasKoltseg[1] && ko >= lovasKoltseg[2] && arany >= lovasKoltseg[3]){
            lakosokszama -= lovasKoltseg[0];
            fa -= lovasKoltseg[1];
            ko -= lovasKoltseg[2];
            arany -= lovasKoltseg[3];
            lovasLetszam++;
        }
    }

    public static void ujKardos() {
        if(lakosokszama >= kardosKoltseg[0] && fa >= kardosKoltseg[1] && ko >= kardosKoltseg[2] && arany >= kardosKoltseg[3]){
            lakosokszama -= kardosKoltseg[0];
            fa -= kardosKoltseg[1];
            ko -= kardosKoltseg[2];
            arany -= kardosKoltseg[3];
            kardosLetszam++;
        }
    }

    public static void ujIjjasz() {
        if(lakosokszama >= ijjaszKoltseg[0] && fa >= ijjaszKoltseg[1] && ko >= ijjaszKoltseg[2] && arany >= ijjaszKoltseg[3]){
            lakosokszama -= ijjaszKoltseg[0];
            fa -= ijjaszKoltseg[1];
            ko -= ijjaszKoltseg[2];
            arany -= ijjaszKoltseg[3];
            ijjaszLetszam++;
        }
    }

    public static int getZsold() {
        int zsold = kardosLetszam*kardosKoltseg[0] + ijjaszLetszam*ijjaszKoltseg[0] + lovasLetszam*lovasKoltseg[0] + agyusLetszam*agyusKoltseg[0];
        return zsold;
    }
}

