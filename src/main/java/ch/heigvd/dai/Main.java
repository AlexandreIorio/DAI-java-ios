package ch.heigvd.dai;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

import ch.heigvd.dai.Color;
import ch.heigvd.dai.text.BufferedTextFileWriter;

public class Main {

    public static void main(String[] args) throws IOException {

        int maxPower = 20;
        int interval = 2;

        if (args.length == 2 && isNumber(args[0]) && isNumber(args[1])) {
             maxPower = Integer.parseInt(args[0]);
             interval = Integer.parseInt(args[1]);
        }

        final String CSV = "data.csv";

        StringBuilder csvContent = new StringBuilder("Name;Type;Buffered;Size;WTime;RTime\n");



        System.out.println(Color.GREEN);
        System.out.println("---------------------------");
        System.out.println("|Binary files not buffered|");
        System.out.println("---------------------------");
        System.out.println(Color.RESET);

        for (int i = 0; i <= maxPower; i+= interval) {
            int byteSize = (int)Math.pow(2,i);
            String fileName = "binary_nBuffered_"+byteSize+".bin";
            long wTime = Measure.write(fileName, byteSize, false, Measure.FileType.BINARY) / 1000000;
            long rTime = Measure.read(fileName, false, Measure.FileType.BINARY) / 1000000;
            csvContent.append(fileName +";"+Measure.FileType.BINARY+";"+false+";"+byteSize+";"+wTime + ";" + rTime + '\n');
            File file = new File(fileName);
            file.delete();

        }

        System.out.println(Color.GREEN);
        System.out.println("---------------------------");
        System.out.println("|Binary files buffered    |");
        System.out.println("---------------------------");
        System.out.println(Color.RESET);

        for (int i = 0; i <= maxPower; i+= interval) {
            int byteSize = (int)Math.pow(2,i);
            String fileName = "binary_Buffered_"+byteSize+".bin";
            long wTime = Measure.write(fileName, byteSize, true, Measure.FileType.BINARY) / 1000000;
            long rTime = Measure.read(fileName, true, Measure.FileType.BINARY) / 1000000;
            csvContent.append(fileName +";"+Measure.FileType.BINARY+";"+true+";"+byteSize+";"+wTime + ";" + rTime + '\n');
            Files.delete(Paths.get(fileName));
        }

        System.out.println(Color.GREEN);
        System.out.println("---------------------------");
        System.out.println("|Text files not buffered  |");
        System.out.println("---------------------------");
        System.out.println(Color.RESET);

        for (int i = 0; i <= maxPower; i+= interval) {
            int byteSize = (int)Math.pow(2,i);
            String fileName = "text_nBuffered_"+byteSize+".txt";
            long wTime = Measure.write(fileName, byteSize, false, Measure.FileType.TEXT) / 1000000;
            long rTime = Measure.read(fileName, false, Measure.FileType.TEXT) / 1000000;
            csvContent.append(fileName +";"+Measure.FileType.TEXT+";"+false+";"+byteSize+";"+wTime + ";" + rTime + '\n');
            new File(fileName).delete();
        }

        System.out.println(Color.GREEN);
        System.out.println("---------------------------");
        System.out.println("|Text files  buffered     |");
        System.out.println("---------------------------");
        System.out.println(Color.RESET);

        for (int i = 0; i <= maxPower; i+= interval) {
            int byteSize = (int)Math.pow(2,i);
            String fileName = "text_Buffered_"+byteSize+".txt";
            long wTime = Measure.write(fileName, byteSize, true, Measure.FileType.TEXT) / 1000000;
            long rTime = Measure.read(fileName, true, Measure.FileType.TEXT) / 1000000;
            csvContent.append(fileName +";"+Measure.FileType.TEXT+";"+ true +";"+byteSize+";"+wTime + ";" + rTime + '\n');
            new File(fileName).delete();
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

    public static boolean isNumber(String string) {
        Scanner scanner = new Scanner(string);
        if (scanner.hasNextInt()) {
            scanner.nextInt();
            return !scanner.hasNext();
        }
        return false;
    }
}
