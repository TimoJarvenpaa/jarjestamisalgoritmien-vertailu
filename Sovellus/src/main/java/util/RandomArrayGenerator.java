package util;

import java.util.concurrent.ThreadLocalRandom;

public class RandomArrayGenerator {

    private int length;
    private int[] array;

    /**
     *
     * @param length generoitavan taulukon pituus
     */
    public RandomArrayGenerator(int length) {
        this.length = length;
        this.array = new int[length];
    }

    /**
     * Metodi palauttaa taulukon, joka sisältää satunnaisia kokonaislukuja yhden
     * ja annetun ylärajan väliltä.
     *
     * @param upperBound generoitavien lukujen yläraja
     * @return taulukko, joka sisältää satunnaisia kokonaislukuja annetun
     * ylärajan ja yhden välillä
     */
    public int[] getRandomArray(int upperBound) {
        for (int i = 0; i < this.array.length; i++) {
            this.array[i] = getRandomInt(1, upperBound);
        }
        return this.array;
    }

    /**
     * Metodi palauttaa satunnaisen kokonaisluvun annetulta väliltä.
     *
     * @param min alaraja
     * @param max yläraja
     * @return
     */
    public int getRandomInt(int min, int max) {
        int randomInt = ThreadLocalRandom.current().nextInt(min, max + 1);
        return randomInt;
    }

}
