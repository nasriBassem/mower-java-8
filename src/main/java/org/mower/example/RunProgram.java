package org.mower.example;

import org.mower.example.entities.DataLineFile;
import org.mower.example.exception.MowerException;
import org.mower.example.services.ParseInputFileService;
import org.mower.example.utilities.MowerManagementErrorsUtilities;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Scanner;

public class RunProgram {

    protected static List<String> listResults;

    public static void main(final String... args) throws MowerException, FileNotFoundException {
        //Check Args
        if (args == null || args.length != 1) {
            throw new IllegalArgumentException();
        }
        //Get input file
        final File file = new File(args[0]);
        if (!file.isFile()) {
            throw new MowerException(MowerManagementErrorsUtilities.NOT_FOUND_FILE_ERROR);
        }
        try (final Scanner scanner = new Scanner(file)) {
            final DataLineFile dataLineFile = new DataLineFile();
            listResults = ParseInputFileService.parseLawnAndMowerAndInstructionData(dataLineFile, scanner);
        }
    }

}
