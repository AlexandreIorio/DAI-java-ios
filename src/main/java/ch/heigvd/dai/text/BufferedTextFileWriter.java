package ch.heigvd.dai.text;

import ch.heigvd.dai.Writable;

import java.io.*;
import java.nio.charset.StandardCharsets;

public class BufferedTextFileWriter implements Writable {
    @Override
    public void write(String filename, int sizeInBytes) throws IOException {
        BufferedWriter writer = new BufferedWriter(
                new OutputStreamWriter(
                        new FileOutputStream(filename),
                        StandardCharsets.UTF_8
                )
        );
        byte b = "A".getBytes(StandardCharsets.UTF_8)[0];
        for (int i = 0; i < sizeInBytes; ++i) {
            writer.write(b);
        }

        writer.flush();
        writer.close();
    }
}
