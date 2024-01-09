package org.mower.example.services;

import org.mower.example.entities.MowerTreatment;
import org.mower.example.exception.MowerException;
import org.mower.example.parser.DataFormatter;
import org.mower.example.entities.DataLineFile;
import org.mower.example.parser.DataParser;
import org.mower.example.utilities.MowerManagementErrorsUtilities;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class ParseInputFileService {

    public static List<String> parseDataMapper(final Scanner scanner) throws MowerException {
        final List<String> positionsList = new ArrayList<>();
        final DataLineFile dataLineFile = new DataLineFile();
        dataLineFile.setLawn(extractLine(scanner));
        dataLineFile.setMower(extractLine(scanner));
        dataLineFile.setInstructions(extractLine(scanner));
        positionsList.add(parserEtLancerTreatment(dataLineFile));
        return positionsList;
    }

    private static String extractLine(final Scanner scanner) throws MowerException {
        if (scanner.hasNext()) {
            return scanner.nextLine();
        } else {
            throw new MowerException(MowerManagementErrorsUtilities.INCORRECT_DATA_ERROR);
        }
    }

    private static String parserEtLancerTreatment(final DataLineFile dataLineFile) throws MowerException {
        if (!DataParser.executeParse(dataLineFile)) {
            throw new MowerException(MowerManagementErrorsUtilities.INCORRECT_DATA_ERROR);
        }
        final MowerTreatment treatmentMower = new MowerTreatment();
        treatmentMower.setMaxMowerPosition(DataFormatter.formatLineLawn(dataLineFile.getLawn()));
        treatmentMower.setActualMowerPosition(DataFormatter.formatLineMower(dataLineFile.getMower()));
        treatmentMower.setInstructionList(DataFormatter.formatterLineInstruction(dataLineFile.getInstructions()));
        /**
         * Launch Treatment Mower
         */
        MowerExecuteInstructionService.executeInstructions(treatmentMower);
        System.out.println(treatmentMower);
        return treatmentMower.toString();
    }
}
