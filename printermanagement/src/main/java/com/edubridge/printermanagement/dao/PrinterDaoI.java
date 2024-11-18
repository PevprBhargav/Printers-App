package com.edubridge.printermanagement.dao;

import com.edubridge.printermanagement.model.Printer;

import java.util.List;

public interface PrinterDaoI {

    // Add a new printer
    void addPrinter(Printer printer);

    // Get all printers
    List<Printer> getAllPrinters();

    // Get a printer by ID
    Printer getPrinterById(Integer id);

    // Update printer details
    void updatePrinter(Printer printer);

    // Delete printer by ID
    void deletePrinter(Integer id);

    // Delete all printers
    void deleteAllPrinters();
}
