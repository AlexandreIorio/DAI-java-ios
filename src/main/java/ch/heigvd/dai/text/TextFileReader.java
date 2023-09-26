package ch.heigvd.dai.text;

import ch.heigvd.dai.Readable;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class TextFileReader implements Readable {
    @Override
    public void read(String filename) throws IOException {
        FileReader reader = new FileReader(filename);

        int c; // is -1 if end of file or char value 0-65535
        while ((c = reader.read()) != -1) {
            // Do nothing
        }
        reader.close();
    }
}
