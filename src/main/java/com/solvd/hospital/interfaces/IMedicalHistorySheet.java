package com.solvd.hospital.interfaces;

import com.solvd.hospital.exceptions.NullMedicalHistorySheetException;

public interface IMedicalHistorySheet {

    void showMedicalHistory() throws NullMedicalHistorySheetException;
    void updateMedicalHistory() throws NullMedicalHistorySheetException;

}
