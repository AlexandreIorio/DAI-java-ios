package ch.heigvd.dai;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;
import java.security.cert.TrustAnchor;
import java.util.ArrayList;
import java.util.List;

import ch.heigvd.dai.Color;
import ch.heigvd.dai.text.BufferedTextFileWriter;

public class Main {

    public static void main(String[] args) throws IOException {

        final int MAX_POWER = 20;
        final int INTERVAL = 2;
        final String CSV = "data.csv";

        StringBuilder csvContent = new StringBuilder("Name;Type;Buffered;Size;WTime;RTime\n");



        System.out.println(Color.GREEN);
        System.out.println("---------------------------");
        System.out.println("|Binary files not buffered|");
        System.out.println("---------------------------");
        System.out.println(Color.RESET);

        for (int i = 0; i <= MAX_POWER; i+= INTERVAL) {
            int byteSize = (int)Math.pow(2,i);
            String fileName = "binary_nBuffered_"+byteSize+".bin";
            long wTime = Measure.write(fileName, byteSize, false, Measure.FileType.BINARY) / 1000000;
            long rTime = Measure.read(fileName, false, Measure.FileType.BINARY) / 1000000;
            csvContent.append(fileName +";"+Measure.FileType.BINARY+";"+false+";"+byteSize+";"+wTime + ";" + rTime + '\n');

        }

        System.out.println(Color.GREEN);
        System.out.println("---------------------------");
        System.out.println("|Binary files buffered    |");
        System.out.println("---------------------------");
        System.out.println(Color.RESET);

        for (int i = 0; i <= MAX_POWER; i+= INTERVAL) {
            int byteSize = (int)Math.pow(2,i);
            String fileName = "binary_Buffered_"+byteSize+".bin";
            long wTime = Measure.write(fileName, byteSize, true, Measure.FileType.BINARY) / 1000000;
            long rTime = Measure.read(fileName, true, Measure.FileType.BINARY) / 1000000;
            csvContent.append(fileName +";"+Measure.FileType.BINARY+";"+true+";"+byteSize+";"+wTime + ";" + rTime + '\n');
        }

        System.out.println(Color.GREEN);
        System.out.println("---------------------------");
        System.out.println("|Text files not buffered  |");
        System.out.println("---------------------------");
        System.out.println(Color.RESET);

        for (int i = 0; i <= MAX_POWER; i+= INTERVAL) {
            int byteSize = (int)Math.pow(2,i);
            String fileName = "text_nBuffered_"+byteSize+".txt";
            long wTime = Measure.write(fileName, byteSize, false, Measure.FileType.TEXT) / 1000000;
            long rTime = Measure.read(fileName, false, Measure.FileType.TEXT) / 1000000;
            csvContent.append(fileName +";"+Measure.FileType.TEXT+";"+false+";"+byteSize+";"+wTime + ";" + rTime + '\n');
        }

        System.out.println(Color.GREEN);
        System.out.println("---------------------------");
        System.out.println("|Text files  buffered     |");
        System.out.println("---------------------------");
        System.out.println(Color.RESET);

        for (int i = 0; i <= MAX_POWER; i+= INTERVAL) {
            int byteSize = (int)Math.pow(2,i);
            String fileName = "text_Buffered_"+byteSize+".txt";
            long wTime = Measure.write(fileName, byteSize, true, Measure.FileType.TEXT) / 1000000;
            long rTime = Measure.read(fileName, true, Measure.FileType.TEXT) / 1000000;
            csvContent.append(fileName +";"+Measure.FileType.TEXT+";"+ true +";"+byteSize+";"+wTime + ";" + rTime + '\n');
        }



        BufferedWriter csvWriter = new BufferedWriter(
                new OutputStreamWriter(
                        new FileOutputStream(CSV),
                        StandardCharsets.UTF_8
                )
        );

        for (int i = 0; i < csvContent.length(); ++i) {
            csvWriter.write(csvContent.charAt(i));
        }

        csvWriter.flush();
        csvWriter.close();

        System.out.println(CSV + " created");
    }
}
