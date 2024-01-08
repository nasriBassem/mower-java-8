package org.mower.example;

import org.mower.example.exception.MowerException;
import org.mower.example.utilities.MowerManagementErrors;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class RunProgram {

    public static void main(final String... args) throws MowerException, IOException {
        if (args.length == 1) {
            final File file = new File(args[0]);
            RunProgram principal = new RunProgram();
            principal.launchTreatmentsMowers(file);
        } else {
            throw new IllegalArgumentException();
        }
    }

    private void launchTreatmentsMowers(final File file) throws MowerException, IOException {
        if (!file.isFile()) {
            throw new MowerException(MowerManagementErrors.NOT_FOUND_FILE_ERROR);
        } else {
            Scanner scanner = new Scanner(file);
            try {
            } finally {
                if (scanner != null) {
                    scanner.close();
                }
            }
        }
    }

}
