package de.phib.punycode;

import java.io.IOException;
import java.net.IDN;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Converts internationalized domain names (IDN) from Punycode to ASCII or the other way around.
 */
public class PunycodeConverter {

    private static boolean TO_UNICODE = true;
    private static boolean TO_ASCII = false;

    /**
     * Converts internationalized names from ASCII to Unicode or the other way around.
     *
     * @param toUnicode true for conversion from ASCII to Unicode, false for conversion from Unicode to ASCII
     * @param inputFileName the name of the input file from which the domain names to be converted should be read
     * @param outputFileName the name of the output file to which the converted domain names should be written
     */
    private void convert(boolean toUnicode, String inputFileName, String outputFileName) {
        try {
            Path inputPath = Paths.get(getClass().getClassLoader().getResource(inputFileName).toURI());
            Stream<String> inputLines = Files.lines(inputPath);

            Path outputPath = Paths.get(outputFileName);

            List<String> outputLines = inputLines.map(toUnicode ? IDN::toUnicode : IDN::toASCII)
                    .collect(Collectors.toList());
            Files.write(outputPath, outputLines);
        } catch (URISyntaxException | IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        PunycodeConverter converter = new PunycodeConverter();

        converter.convert(TO_UNICODE, "input-ascii-to-unicode.txt", "output-ascii-to-unicode.txt");
        converter.convert(TO_ASCII, "input-unicode-to-ascii.txt", "output-unicode-to-ascii.txt");
    }

}