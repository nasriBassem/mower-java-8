package org.mower.example.services;

import lombok.Data;
import org.mower.example.entities.MowerInstruction;
import org.mower.example.entities.MowerPosition;
import org.mower.example.exception.MowerException;

import java.util.List;

@Data
public class MowerManagementService {
    private MowerPosition maxMowerPosition;
    private MowerPosition  actualMowerPosition;
    private List<MowerInstruction> instructionList;
    public void executeInstructions() throws MowerException{
        MowerExecuteInstructionService mowerExecuteInstructionService = new MowerExecuteInstructionService();
        for(MowerInstruction instruction : instructionList){
            mowerExecuteInstructionService.executeInstruction(instruction, this.actualMowerPosition);
        }
    }

}
