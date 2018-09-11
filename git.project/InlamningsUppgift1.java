package InlamningsUppgifter;

import java.util.HashMap;
import java.util.Scanner;

public class InlamningsUppgift1 {
    private static int antalKast;
    private static int antalSidor = 6;
    private static int spelare;
    //1
    private static HashMap<Integer, Integer> wins = new HashMap<>();

    public static void main(String[] args) {

        String svar;
        Scanner scan = new Scanner(System.in);
        Scanner input = new Scanner(System.in);

        while (true) {
            // Print leaderboard
            System.out.println("-------[ Highscore ]-------");
            for (int key : wins.keySet()) {
                System.out.println("\tSpelare " + key + " -> " + wins.get(key)+" poäng");
            }

            System.out.println("hur många spelare?");
            spelare = scan.nextInt();

            System.out.println("Hur många kast?");
            antalKast = scan.nextInt();
            //2
            if (spelare == 1) {

                // Initierar en array med integer och allokerar minne för två integer
                int[] kastArray = new int[2];
                int[] spelareSumma = new int[2];
                // Skapar tärningskast för två spelare lika många gånger som variabeln

                for (int i = 0; i < antalKast; i++) {
                    for (int j = 0; j < kastArray.length; j++) {
                        kastArray[j] = (int) (1 + antalSidor * Math.random());

                        System.out.printf("Spelare : Kast: %d är %d\n", i+1, kastArray[j]);
                        System.out.printf("Dator   : Kast: %d är %d\n", i+1, kastArray[j]);

                        spelareSumma[j] += kastArray[j];
                    }
                    System.out.println("\n");
                }

                System.out.println("-------[ Summa ]-------");
                System.out.printf("\tSpelare -> %d poäng\n", spelareSumma[0]);
                System.out.printf("\tDator -> %d poäng\n", spelareSumma[1]);


                System.out.println("");

                int sDator = spelareSumma[1];
                int sSpelare = spelareSumma[0];

                if (sDator > sSpelare) {
                    System.out.println("Datorn vann!!");
                }
                else if (sSpelare > sDator) {
                    System.out.println("Spelare vann!!");
                }
                else if (sDator == sSpelare) {
                    System.out.println("Det blev lika");
                }
                //3
            } else {

                int[] kastArray = new int[spelare];
                int[] spelareSumma = new int[spelare];

                for (int i = 0; i < antalKast; i++) {
                    for (int j = 0; j < kastArray.length; j++) {
                        kastArray[j] = (int) (1 + antalSidor * Math.random());

                        System.out.printf("Spelare %d : Kast: %d är %d\n", (j + 1), (i + 1), kastArray[j]);

                        spelareSumma[j] += kastArray[j];
                    }
                    System.out.println("\n");
                }

                System.out.println("-------[ Summa Spelare ]-------");
                for (int i = 0; i < spelareSumma.length; i++) {
                    System.out.printf("\tSpelare %d -> %d poäng\n", (i + 1), spelareSumma[i]);
                }

                int winner = checkWin(spelareSumma);

                //lägg till den i en key   - value storage (key:player - value:score)
                wins.put(winner + 1, spelareSumma[winner]);

                System.out.printf("\nSpelare %d vann med %d poäng :)\n\n", (winner + 1), spelareSumma[winner]);
            }
            //4
            System.out.println("Vill du köra igen? (ja/nej)");
            svar = input.nextLine();

            switch (svar) {
                case "ja":
                    // Om ja så forsätter man med loopen
                    break;
                case "nej":
                    System.out.println("\n-----[ Tack för att du spelade! ]-----");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Det var inget val.");
                    break;
            }
        }
    }

    //5 
    public static int checkWin(int[] players) {
        int highest = 0;
        int highestIndex = 0;

        for (int i = 0; i < players.length; i++) {
            if (players[i] > highest) {
                highest = players[i];
                highestIndex = i;
            }
        }

        return highestIndex;
    }
}

