package logiikka.robottiralli.lautaelementtienhallinta;

import logiikka.robottiralli.robottienhallinta.Robotti;

public interface Elementti {
    /**
     * @return Palauttaa minkälainen elementti on kyseessä.
     */
    String tyyppi();
    /**
     * Aktivoi lautaelementin ja suorittaa elementin toiminnon
     * @param robo Robotti, jolle lautaelementti tekee jotain.
     * @param vuoro Monta korttia pelaajien ohjelmista on paljastettu.
     */
    void aktivoidu(Robotti robo, int vuoro);
    /**
     * @return Palauttaa elementistä riippuen luvun, jota grafiikkapiirturi
     * tarvitsee.
     */
    int getGrafiikkaluku();
       
}
