/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package znamkovac;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author Martin
 */
public class Znamkovac {

    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     */
    public static void main(String[] args) throws IOException {

        System.out.print("Zadejte maximální počet bodů:");
        double maximalniPocetBodu = readDouble();
        if (maximalniPocetBodu <= 0) {
            System.err.print("Maximální počet bodů musí být větší než 0.");
            System.exit(1);
        }

        double ziskanyPocetBodu;
        do {
            System.out.print("Zadejte získaný počet bodů:");
            ziskanyPocetBodu = readDouble();
            if (ziskanyPocetBodu == -1) {
                System.err.print("Program byl ukončen.");
                System.exit(1);
            } else if (ziskanyPocetBodu != -1 && ziskanyPocetBodu < 0) {
                System.err.print("Získaný počet bodů musí být alespoň 0.");
                System.exit(1);
            } else if (ziskanyPocetBodu > maximalniPocetBodu) {
                System.err.print("Získaný počet bodů nesmí být vyšší než maximální počet bodů.");
                System.exit(1);
            }

            double procentualniUspesnost = ziskanyPocetBodu / maximalniPocetBodu * 100;
            
            double procentualniUspesnostZaokrouhlena = zaokrouhleni(procentualniUspesnost);
            
            int ziskanaZnamka = 0;

            if (procentualniUspesnostZaokrouhlena <= 100 && procentualniUspesnostZaokrouhlena >= 85) {
                ziskanaZnamka = 1;
            } else if (procentualniUspesnostZaokrouhlena < 85 && procentualniUspesnostZaokrouhlena >= 70) {
                ziskanaZnamka = 2;
            } else if (procentualniUspesnostZaokrouhlena < 70 && procentualniUspesnostZaokrouhlena >= 55) {
                ziskanaZnamka = 3;
            } else if (procentualniUspesnostZaokrouhlena < 55 && procentualniUspesnostZaokrouhlena >= 40) {
                ziskanaZnamka = 4;
            } else if (procentualniUspesnostZaokrouhlena < 40 && procentualniUspesnostZaokrouhlena >= 0) {
                ziskanaZnamka = 5;
            }
           
            System.out.println("procenta: " + procentualniUspesnostZaokrouhlena + ", známka: " + ziskanaZnamka);
        } while (ziskanyPocetBodu != -1);
    }

    public static int readInt() throws IOException {
        BufferedReader reader;
        reader = new BufferedReader(new InputStreamReader(System.in));
        return Integer.parseInt(reader.readLine());
    }

    public static double readDouble() throws IOException {
        BufferedReader reader;
        reader = new BufferedReader(new InputStreamReader(System.in));
        return Double.parseDouble(reader.readLine());
    }
    
    public static double zaokrouhleni(double cislo) {
        return Math.round(cislo * 10.0) / 10.0;
    }
}