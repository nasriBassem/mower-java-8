package org.mower.example;

import org.mower.example.exception.MowerException;
import org.mower.example.services.ParseInputFileService;
import org.mower.example.utilities.MowerManagementErrorsUtilities;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class RunProgram {

    protected static List<String> listResults;

    public static void main(final String... args) throws MowerException, IOException {
        /**
         * Check Args
         */
        if (args == null || args.length == 0) {
            throw new IllegalArgumentException();
        }

        /**
         *  Get input file
         */
        final File file = new File(args[0]);
        if (!file.isFile()) {
            throw new MowerException(MowerManagementErrorsUtilities.NOT_FOUND_FILE_ERROR);
        }
        try (final Scanner scanner = new Scanner(file)) {
            listResults =  ParseInputFileService.parseDataMapper(scanner);
        }
    }

}
