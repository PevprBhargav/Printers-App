package com.edubridge.printermanagement.service;

import java.util.List;

import com.edubridge.printermanagement.dao.PrinterDao;
import com.edubridge.printermanagement.model.Printer;

public class PrinterService implements PrinterServiceI {
    private PrinterDao dao;

    public PrinterService() {
        dao = new PrinterDao();  // Use PrinterDao instead of ContactDao
    }

    @Override
    public void addPrinter(Printer printer) {
        dao.addPrinter(printer);  // Call PrinterDao's addPrinter method
    }

    @Override
    public List<Printer> getAllPrinters() {
        return dao.getAllPrinters();  // Call PrinterDao's getAllPrinters method
    }

    @Override
    public Printer getPrinterById(Integer id) {
        return dao.getPrinterById(id);  // Call PrinterDao's getPrinterById method
    }

    @Override
    public void updatePrinter(Printer printer) {
        dao.updatePrinter(printer);  // Call PrinterDao's updatePrinter method
    }

    @Override
    public void deletePrinter(Integer id) {
        dao.deletePrinter(id);  // Call PrinterDao's deletePrinter method
    }

    @Override
    public void deleteAllPrinters() {
        dao.deleteAllPrinters();  // Call PrinterDao's deleteAllPrinters method
    }
}
