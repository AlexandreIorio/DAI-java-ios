package ch.heigvd.dai;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {

        Measure.write("binary_1B.bin", 1, false, Measure.FileType.BINARY);
        Measure.write("binary_1024B.bin", 1024, false, Measure.FileType.BINARY);
        Measure.write("binary_1MB.bin", 1024 * 1024, false, Measure.FileType.BINARY);

        // Measure the time to read the same file

        Measure.read("binary_1B.bin", true, Measure.FileType.BINARY);
        Measure.read("binary_1024B.bin", true, Measure.FileType.BINARY);
        Measure.read("binary_1MB.bin", true, Measure.FileType.BINARY);

        Measure.write("binary_1B.bin", 1, true, Measure.FileType.BINARY);
        Measure.write("binary_1024B.bin", 1024, true, Measure.FileType.BINARY);
        Measure.write("binary_1MB.bin", 1024 * 1024, true, Measure.FileType.BINARY);

        // Measure the time to read the same file

        Measure.read("binary_1B.bin", true, Measure.FileType.BINARY);
        Measure.read("binary_1024B.bin", true, Measure.FileType.BINARY);
        Measure.read("binary_1MB.bin", true, Measure.FileType.BINARY);
    }
}
