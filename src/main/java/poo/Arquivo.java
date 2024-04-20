package poo;

import java.io.*;

public class Arquivo {

    public static void writeScores(Integer score, Integer i) {

        OutputStream os = null;
        OutputStreamWriter osw = null;
        BufferedWriter bw = null;

        try {

            os = new FileOutputStream("ArquivoPontos.txt", true);
            osw = new OutputStreamWriter(os);
            bw = new BufferedWriter(osw);

            bw.write("Pontuações da tentativa " + i + ":");
            bw.newLine();
            bw.write(score + "\n");

        } catch (Exception e) {

            System.out.println(e);

        } finally {

            try {
                bw.close();
            } catch (Exception e) {
                System.out.println(e);
            }
        }

    }
}
