package ch.heigvd.dai.text;

import ch.heigvd.dai.Writable;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class TextFileWriter implements Writable {

    @Override
    public void write(String filename, int sizeInBytes) throws IOException {

        FileWriter writer = new FileWriter(filename);

        for (int i = 0; i < sizeInBytes; i++){
            writer.write('A');
        }
        writer.flush();
        writer.close();
    }
}
