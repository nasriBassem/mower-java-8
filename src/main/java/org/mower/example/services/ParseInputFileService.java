package org.mower.example.services;

import org.mower.example.entities.MowerTreatment;
import org.mower.example.exception.MowerException;
import org.mower.example.parser.DataParser;
import org.mower.example.entities.DataLineFile;
import org.mower.example.parser.DataParserChecker;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static org.mower.example.utilities.MowerManagementErrorsUtilities.INCORRECT_DATA_ERROR;

/**
 *  Service Class to scan and read input file
 *
 * @author bassem
 */

public class ParseInputFileService {

    private ParseInputFileService() {
    }

    public static List<String> parseLawnAndMowerAndInstructionData(final DataLineFile dataLineFile, final Scanner scanner) throws MowerException {
        final List<String> positionsList = new ArrayList<>();
        if (!scanner.hasNext()) {
            throw new MowerException(INCORRECT_DATA_ERROR);
        } else {
            dataLineFile.setLawn(scanner.nextLine());
        }
        if (!scanner.hasNext()) {
            throw new MowerException(INCORRECT_DATA_ERROR);
        } else {
            while (scanner.hasNext()) {
                dataLineFile.setMower(scanner.nextLine());
                if (scanner.hasNext()) {
                    dataLineFile.setInstructions(scanner.nextLine());
                    positionsList.add(parserAndLunchTreatment(dataLineFile));
                } else {
                    throw new MowerException(INCORRECT_DATA_ERROR);
                }
            }
        }
      return positionsList;
    }

    private static String parserAndLunchTreatment(final DataLineFile dataLineFile) throws MowerException {
        if (!DataParserChecker.executeParseCheck(dataLineFile)) {
            throw new MowerException(INCORRECT_DATA_ERROR);
        }
        final MowerTreatment treatmentMower = new MowerTreatment();
        treatmentMower.setMaxMowerPosition(DataParser.parseLineLawn(dataLineFile.getLawn()));
        treatmentMower.setActualMowerPosition(DataParser.parseLineMower(dataLineFile.getMower()));
        treatmentMower.setInstructionList(DataParser.parseLineInstruction(dataLineFile.getInstructions()));

        // Launch Treatment Mower
        MowerExecuteInstructionService.executeInstructions(treatmentMower);
        return treatmentMower.toString();
    }
}
