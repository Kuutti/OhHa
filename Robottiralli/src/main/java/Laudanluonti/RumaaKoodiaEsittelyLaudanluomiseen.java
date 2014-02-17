

package Laudanluonti;

import logiikka.robottiralli.lautaelementit.Checkpoint;
import logiikka.robottiralli.lautaelementit.Kaantaja;
import logiikka.robottiralli.lautaelementit.Korjaaja;
import logiikka.robottiralli.lautaelementit.Kuoppa;
import logiikka.robottiralli.lautaelementit.Liukuhihna;
import logiikka.robottiralli.lautaelementit.Murskain;
import logiikka.robottiralli.lautaelementit.Tyonnin;
import logiikka.robottiralli.lautaelementtienhallinta.Laser;
import logiikka.robottiralli.lautaelementtienhallinta.Lauta;
import logiikka.robottiralli.lautaelementtienhallinta.Ruutu;


public class RumaaKoodiaEsittelyLaudanluomiseen {

    public RumaaKoodiaEsittelyLaudanluomiseen() {
    }
    //yhtä pitkät liukuhihnan pätkät voi laittaa samaan forlooppiin
    /**
     * Luo laudalle liukuhihnoja, kuoppia ja muita vastaavia lautaelementtejä
     * @param lauta luodaan elementit.
     */
    public void teeLauta(Lauta lauta){
        
       
        Ruutu[][] pelilauta=lauta.getPelilauta(); 

        
        for (int i = 6; i < 9; i++) {
            pelilauta[1][i].lisaaElementti(new Liukuhihna(pelilauta[1][i+1],0,0));
        }
        pelilauta[1][9].lisaaElementti(new Kuoppa());
        for (int i = 5; i > 3; i--) {
            pelilauta[2][i].lisaaElementti(new Liukuhihna(pelilauta[2][i-1],0,2));
        }
        pelilauta[2][3].lisaaElementti(new Liukuhihna(pelilauta[2][3],3,2));
        for (int i = 2; i < 7; i++) {
            pelilauta[i][2].lisaaElementti(new Liukuhihna(pelilauta[i+1][2],0,1));
        }
        pelilauta[7][2].lisaaElementti(new Liukuhihna(pelilauta[8][2],3,1));
        pelilauta[8][2].lisaaElementti(new Liukuhihna(pelilauta[8][3],0,0));
        pelilauta[8][3].lisaaElementti(new Liukuhihna(pelilauta[8][4],0,0));
        pelilauta[8][4].lisaaElementti(new Liukuhihna(pelilauta[8][5],3,0));
        for (int i = 8; i > 3; i--) {
            pelilauta[i][5].lisaaElementti(new Liukuhihna(pelilauta[i-1][5],0,3));
        }
        pelilauta[3][5].lisaaElementti(new Liukuhihna(pelilauta[2][5],3,3));
        pelilauta[3][3].lisaaElementti(new Checkpoint(1,pelilauta[10][20]));
        lauta.setAloitus(pelilauta[3][3]);
        lauta.addSeina(pelilauta[5][3], pelilauta[6][3]);
        lauta.addSeina(pelilauta[7][4],pelilauta[8][4]);
        lauta.addLaser(new Laser(pelilauta[7][4],3));
        lauta.addLaser(new Laser(pelilauta[6][3],1));
        lauta.addSeina(new Ruutu(16,3), new Ruutu(15,3));
        pelilauta[10][4].lisaaElementti(new Kuoppa());
        pelilauta[10][7].lisaaElementti(new Kuoppa());
        pelilauta[10][10].lisaaElementti(new Kuoppa());
        lauta.addSeina(pelilauta[4][7], pelilauta[4][8]);
        lauta.addLaser(new Laser(pelilauta[4][7],2));
        lauta.addSeina(pelilauta[7][7], pelilauta[7][8]);
        lauta.addLaser(new Laser(pelilauta[7][7],2));
        for (int i = 8; i > 3; i--) {
            pelilauta[i][6].lisaaElementti(new Liukuhihna(pelilauta[i-1][6],0,3));
        }
        pelilauta[3][6].lisaaElementti(new Liukuhihna(pelilauta[2][6],1,3));
        for (int i = 6; i < 10; i++) {
            pelilauta[2][i].lisaaElementti(new Liukuhihna(pelilauta[2][i+1],0,0));
        }
        pelilauta[2][10].lisaaElementti(new Liukuhihna(pelilauta[2][11],1,0));
        for (int i = 2; i <7; i++) {
            pelilauta[i][11].lisaaElementti(new Liukuhihna(pelilauta[i+1][11],0,1));
        }
        pelilauta[7][11].lisaaElementti(new Liukuhihna(pelilauta[8][11],1,1));
        for (int i = 11; i > 7; i--) {
            pelilauta[8][i].lisaaElementti(new Liukuhihna(pelilauta[8][i+1],0,2));
        }
        pelilauta[8][7].lisaaElementti(new Liukuhihna(pelilauta[8][6],1,2));
        lauta.addSeina(new Ruutu(3,9),new Ruutu(3,10));
        lauta.addSeina(new Ruutu(5,9), new Ruutu(5,10));
        pelilauta[5][9].lisaaElementti(new Checkpoint(3,pelilauta[18][16]));
        lauta.addSeina(new Ruutu(6,9), new Ruutu(6,8));
        lauta.addSeina(new Ruutu(7,9), new Ruutu(8,9));
        for (int i = 11; i > 3; i--) {
            pelilauta[11][i].lisaaElementti(new Liukuhihna(pelilauta[11][i-1],0,2));
        }
        pelilauta[11][3].lisaaElementti(new Liukuhihna(pelilauta[11][2],1,2));
        pelilauta[11][2].lisaaElementti(new Liukuhihna(pelilauta[10][2],0,3));
        pelilauta[10][2].lisaaElementti(new Liukuhihna(pelilauta[9][2],1,3));
        for (int i = 2; i < 10; i++) {
            pelilauta[9][i].lisaaElementti(new Liukuhihna(pelilauta[9][i+1],0,0));
        }
        pelilauta[9][10].lisaaElementti(new Liukuhihna(pelilauta[9][10],1,0));
        pelilauta[9][11].lisaaElementti(new Liukuhihna(pelilauta[10][11],0,1));
        pelilauta[10][11].lisaaElementti(new Liukuhihna(pelilauta[11][11],1,1));
        pelilauta[10][6].lisaaElementti(new Korjaaja(1));
        lauta.addLaser(new Laser(pelilauta[8][9],1));
        //toinen neljännes
        for (int i = 15; i > 0; i--) {
            pelilauta[14][i].lisaaElementti(new Liukuhihna(pelilauta[14][i-1],0,2));
        }
        for (int i = 8; i < 12; i++) {
            pelilauta[15][i].lisaaElementti(new Liukuhihna(pelilauta[15][i+1],0,0));
        }
        pelilauta[15][12].lisaaElementti(new Kuoppa());
        pelilauta[15][1].lisaaElementti(new Liukuhihna(pelilauta[15][2],0,0));
        pelilauta[15][2].lisaaElementti(new Liukuhihna(pelilauta[15][3],0,0));
        pelilauta[15][3].lisaaElementti(new Liukuhihna(pelilauta[15][4],1,0));
        pelilauta[15][4].lisaaElementti(new Liukuhihna(pelilauta[16][4],0,1));
        pelilauta[15][5].lisaaElementti(new Liukuhihna(pelilauta[16][5],0,1));
        pelilauta[15][6].lisaaElementti(new Liukuhihna(pelilauta[15][5],3,2));
        pelilauta[15][7].lisaaElementti(new Liukuhihna(pelilauta[15][6],0,2));
        pelilauta[16][4].lisaaElementti(new Kuoppa());
        pelilauta[16][5].lisaaElementti(new Kuoppa());
        lauta.addSeina(new Ruutu(16,9), new Ruutu(17,9));
        lauta.addSeina(new Ruutu(16,2), new Ruutu(17,2));
        pelilauta[20][10].lisaaElementti(new Checkpoint(2,pelilauta[5][9]));
        pelilauta[19][11].lisaaElementti(new Kaantaja(3));
        pelilauta[21][11].lisaaElementti(new Kaantaja(3));
        pelilauta[21][10].lisaaElementti(new Kaantaja(3));
        pelilauta[20][9].lisaaElementti(new Kaantaja(3));
        pelilauta[20][11].lisaaElementti(new Kaantaja(1));
        pelilauta[19][10].lisaaElementti(new Kaantaja(1));
        pelilauta[19][9].lisaaElementti(new Kaantaja(1));
        pelilauta[21][9].lisaaElementti(new Kaantaja(1));
        lauta.addSeina(new Ruutu(24,10), new Ruutu(24,11));
        lauta.addSeina(new Ruutu(24,2), new Ruutu(24,3));
        lauta.addSeina(new Ruutu(23,6), new Ruutu(23,7));
        lauta.addLaser(new Laser(pelilauta[24][3],0));
        pelilauta[20][4].lisaaElementti(new Korjaaja(2));
        for (int i = 0; i < 3; i++) {
            pelilauta[18+i][8].lisaaElementti(new Liukuhihna(pelilauta[19+i][9],0,1));
            pelilauta[22][8+i].lisaaElementti(new Liukuhihna(pelilauta[22][9+i],0,0));
            pelilauta[22-i][12].lisaaElementti(new Liukuhihna(pelilauta[21-i][12],0,3));
            pelilauta[18][12-i].lisaaElementti(new Liukuhihna(pelilauta[18][11-i],0,2));
            pelilauta[18+i][6].lisaaElementti(new Liukuhihna(pelilauta[19+i][6],0,1));
            pelilauta[22][6-i].lisaaElementti(new Liukuhihna(pelilauta[22][5-1],0,2));
            pelilauta[22-i][2].lisaaElementti(new Liukuhihna(pelilauta[21-i][2],0,3));
            pelilauta[18][i+2].lisaaElementti(new Liukuhihna(pelilauta[18][3+i],0,0));
        }
        pelilauta[21][8].lisaaElementti(new Liukuhihna(pelilauta[22][8],3,1));
        pelilauta[22][11].lisaaElementti(new Liukuhihna(pelilauta[22][12],3,0));
        pelilauta[19][12].lisaaElementti(new Liukuhihna(pelilauta[18][12],3,3));
        pelilauta[18][9].lisaaElementti(new Liukuhihna(pelilauta[18][8],3,2));
        pelilauta[21][6].lisaaElementti(new Liukuhihna(pelilauta[22][8],1,1));
        pelilauta[22][3].lisaaElementti(new Liukuhihna(pelilauta[22][2],1,2));
        pelilauta[19][2].lisaaElementti(new Liukuhihna(pelilauta[18][2],1,3));
        pelilauta[18][5].lisaaElementti(new Liukuhihna(pelilauta[18][6],1,0));
        pelilauta[19][5].lisaaElementti(new Kaantaja(1));
        pelilauta[21][5].lisaaElementti(new Kaantaja(1));
        pelilauta[21][4].lisaaElementti(new Kaantaja(1));
        pelilauta[20][3].lisaaElementti(new Kaantaja(1));
        pelilauta[20][5].lisaaElementti(new Kaantaja(3));
        pelilauta[19][4].lisaaElementti(new Kaantaja(3));
        pelilauta[19][3].lisaaElementti(new Kaantaja(3));
        pelilauta[21][3].lisaaElementti(new Kaantaja(3));
        
        //kolmas neljännes
        for (int i = 0; i < 8; i++) {
            pelilauta[2][15+i].lisaaElementti(new Liukuhihna(pelilauta[2][16+i],0,0));
            pelilauta[3+i][23].lisaaElementti(new Liukuhihna(pelilauta[4+i][23],0,1));
            pelilauta[11][22-i].lisaaElementti(new Liukuhihna(pelilauta[11][21-i],0,2));
            pelilauta[10-i][14].lisaaElementti(new Liukuhihna(pelilauta[9-i][14],0,3));
        }
        for (int i = 0; i < 6; i++) {
            pelilauta[4+i][15].lisaaElementti(new Liukuhihna(pelilauta[5+i][15],0,1));
            pelilauta[10][16+i].lisaaElementti(new Liukuhihna(pelilauta[6+i][10],0,0));
            pelilauta[9-i][22].lisaaElementti(new Liukuhihna(pelilauta[8-i][22],0,3));
            pelilauta[3][21-i].lisaaElementti(new Liukuhihna(pelilauta[3][20-i],0,2));
        }
        for (int i = 0; i < 2; i++) {
            pelilauta[5][17+i].lisaaElementti(new Liukuhihna(pelilauta[5][8+i],0,0));
            pelilauta[5+i][20].lisaaElementti(new Liukuhihna(pelilauta[6+i][20],0,1));
            pelilauta[8][20-i].lisaaElementti(new Liukuhihna(pelilauta[8][19-i],0,2));
            pelilauta[8-i][17].lisaaElementti(new Liukuhihna(pelilauta[7-i][17],0,3));
        }
        pelilauta[5][19].lisaaElementti(new Liukuhihna(pelilauta[5][20],1,0));
        pelilauta[7][20].lisaaElementti(new Liukuhihna(pelilauta[8][20],1,1));
        pelilauta[8][18].lisaaElementti(new Liukuhihna(pelilauta[8][17],1,2));
        pelilauta[6][17].lisaaElementti(new Liukuhihna(pelilauta[5][17],1,3));
        lauta.addSeina(new Ruutu(4,20), new Ruutu(5,20));
        lauta.addSeina(new Ruutu(8,20), new Ruutu(9,20));
        lauta.addSeina(new Ruutu(4,18), new Ruutu(5,18));
        lauta.addSeina(new Ruutu(8,18), new Ruutu(9,18));
        lauta.addSeina(new Ruutu(6,16), new Ruutu(6,17));
        lauta.addSeina(new Ruutu(6,20), new Ruutu(6,21));
        lauta.addSeina(new Ruutu(8,20), new Ruutu(8,21));
        lauta.addSeina(new Ruutu(8,16), new Ruutu(8,17));
        pelilauta[4][16].lisaaElementti(new Korjaaja(1));
        pelilauta[12][13].lisaaElementti(new Korjaaja(2));
        pelilauta[9][21].lisaaElementti(new Korjaaja(1));
        pelilauta[6][18].lisaaElementti(new Checkpoint(4,pelilauta[21][20]));
        pelilauta[7][19].lisaaElementti(new Kaantaja(1));
        pelilauta[2][14].lisaaElementti(new Murskain(0));
        pelilauta[3][15].lisaaElementti(new Murskain(1));
        pelilauta[2][23].lisaaElementti(new Murskain(0));
        pelilauta[11][23].lisaaElementti(new Murskain(0));
        pelilauta[11][14].lisaaElementti(new Murskain(0));
        pelilauta[3][22].lisaaElementti(new Murskain(1));
        pelilauta[10][22].lisaaElementti(new Murskain(1));
        pelilauta[10][15].lisaaElementti(new Murskain(1));
        pelilauta[4][18].lisaaElementti(new Tyonnin(pelilauta[3][18],1,3));
        pelilauta[4][20].lisaaElementti(new Tyonnin(pelilauta[3][18],0,3));
        pelilauta[6][21].lisaaElementti(new Tyonnin(pelilauta[6][22],1,0));
        pelilauta[8][21].lisaaElementti(new Tyonnin(pelilauta[8][22],0,0));
        pelilauta[9][20].lisaaElementti(new Tyonnin(pelilauta[10][20],1,1));
        pelilauta[9][18].lisaaElementti(new Tyonnin(pelilauta[10][18],0,1));
        pelilauta[8][16].lisaaElementti(new Tyonnin(pelilauta[8][15],1,2));
        pelilauta[6][16].lisaaElementti(new Tyonnin(pelilauta[6][15],0,2));
        
        //viimeinen
        pelilauta[21][20].lisaaElementti(new Checkpoint(5,null));
        pelilauta[13][22].lisaaElementti(new Kuoppa());
        pelilauta[13][19].lisaaElementti(new Kuoppa());
        pelilauta[13][17].lisaaElementti(new Kuoppa());
        pelilauta[15][18].lisaaElementti(new Kuoppa());
        pelilauta[15][14].lisaaElementti(new Kuoppa());
        pelilauta[19][23].lisaaElementti(new Kuoppa());
        pelilauta[23][23].lisaaElementti(new Kuoppa());
        pelilauta[22][14].lisaaElementti(new Kuoppa());
        lauta.addSeina(new Ruutu(13,20), new Ruutu(13,21));
        lauta.addSeina(new Ruutu(14,15), new Ruutu(14,16));
        lauta.addSeina(new Ruutu(14,17), new Ruutu(15,17));
        lauta.addSeina(new Ruutu(14,22), new Ruutu(15,22));
        lauta.addSeina(new Ruutu(15,19), new Ruutu(15,20));
        lauta.addSeina(new Ruutu(15,15), new Ruutu(16,15));
        lauta.addSeina(new Ruutu(17,14), new Ruutu(17,13));
        lauta.addSeina(new Ruutu(18,20), new Ruutu(19,20));
        lauta.addSeina(new Ruutu(18,18), new Ruutu(19,18));
        lauta.addSeina(new Ruutu(19,21), new Ruutu(19,20));
        lauta.addSeina(new Ruutu(19,14), new Ruutu(19,13));
        lauta.addSeina(new Ruutu(19,17), new Ruutu(20,17));
        lauta.addSeina(new Ruutu(19,19), new Ruutu(20,19));
        lauta.addSeina(new Ruutu(20,19), new Ruutu(21,19));
        lauta.addSeina(new Ruutu(21,20), new Ruutu(21,21));
        lauta.addSeina(new Ruutu(21,20), new Ruutu(22,20));
        lauta.addSeina(new Ruutu(21,16), new Ruutu(21,17));
        lauta.addSeina(new Ruutu(22,14), new Ruutu(22,15));
        lauta.addSeina(new Ruutu(23,20), new Ruutu(23,19));
        lauta.addSeina(new Ruutu(23,17), new Ruutu(24,17));
        lauta.addSeina(new Ruutu(22,15), new Ruutu(22,14));
        pelilauta[13][21].lisaaElementti(new Korjaaja(1));
        lauta.addLaser(new Laser(pelilauta[15][22],1));
        lauta.addLaser(new Laser(pelilauta[16][15],1));
        lauta.addLaser(new Laser(pelilauta[17][14],0));
        lauta.addLaser(new Laser(pelilauta[22][15],0));
        pelilauta[13][20].lisaaElementti(new Tyonnin(pelilauta[13][19],1,2));
        pelilauta[14][17].lisaaElementti(new Tyonnin(pelilauta[13][17],0,3));
        pelilauta[15][16].lisaaElementti(new Tyonnin(pelilauta[15][15],0,2));
        pelilauta[18][18].lisaaElementti(new Tyonnin(pelilauta[17][18],1,3));
        pelilauta[18][20].lisaaElementti(new Tyonnin(pelilauta[17][20],0,3));
        pelilauta[19][21].lisaaElementti(new Tyonnin(pelilauta[19][22],1,0));
        pelilauta[19][19].lisaaElementti(new Tyonnin(pelilauta[18][19],0,3));
        pelilauta[19][17].lisaaElementti(new Tyonnin(pelilauta[18][17],0,3));
        pelilauta[19][14].lisaaElementti(new Tyonnin(pelilauta[19][15],1,0));
        pelilauta[21][16].lisaaElementti(new Tyonnin(pelilauta[21][15],1,2));
        pelilauta[23][17].lisaaElementti(new Tyonnin(pelilauta[22][17],1,3));
        pelilauta[21][19].lisaaElementti(new Tyonnin(pelilauta[22][19],0,1));
        
        
    }
}
