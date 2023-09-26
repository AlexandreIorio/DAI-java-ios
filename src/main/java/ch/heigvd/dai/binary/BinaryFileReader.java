package ch.heigvd.dai.binary;

import ch.heigvd.dai.Readable;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class BinaryFileReader implements Readable {

    @Override
    public void read(String filename) throws IOException {

        try {
            FileInputStream fis = new FileInputStream(filename);
            int b; // is -1 if end of file or byte value 0-255
            while ((b = fis.read()) != -1) {
                //do nothing
            }
            fis.close();
        }
        catch (FileNotFoundException ex) {
            System.out.println("File : " + filename + "not found\n" + ex.getMessage());
        }



    }
}
