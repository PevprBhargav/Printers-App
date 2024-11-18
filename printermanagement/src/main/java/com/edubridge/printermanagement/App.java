package com.edubridge.printermanagement;

import java.util.List;
import java.util.Scanner;

import com.edubridge.printermanagement.model.Printer;
import com.edubridge.printermanagement.service.PrinterService;

public class App {
    public static void main(String[] args) {
        int option = 0;
        Scanner in = new Scanner(System.in);
        PrinterService service = new PrinterService();
        String name, model, status;
        name = model = status = null;

        do {
            System.out.println("Welcome to Printer Management Application");
            System.out.println("=========================================");
            System.out.println("1. Add Printer");
            System.out.println("2. View All Printers");
            System.out.println("3. Search Printer");
            System.out.println("4. Update Printer");
            System.out.println("5. Delete Printer");
            System.out.println("6. Delete All Printers");
            System.out.println("0. Exit");
            System.out.print("Please choose an option: ");
            option = in.nextInt();

            switch (option) {
                case 1:
                    System.out.println("Add New Printer");
                    System.out.println("---------------");
                    System.out.print("Enter Printer Name: ");
                    name = in.next();
                    System.out.print("Enter Printer Model: ");
                    model = in.next();
                    System.out.print("Enter Printer Status (e.g., Online, Offline): ");
                    status = in.next();

                    Printer printer = new Printer();
                    printer.setName(name);
                    printer.setModel(model);
                    printer.setStatus(status);

                    service.addPrinter(printer);
                    break;

                case 2:
                    System.out.println("View All Printers");
                    System.out.println("-----------------");
                    List<Printer> printers = service.getAllPrinters();
                    if (!printers.isEmpty()) {
                        for (Printer p : printers) {
                            System.out.println(p.getId() + "\t" + p.getName() + "\t" + p.getModel() + "\t" + p.getStatus());
                        }
                    } else {
                        System.out.println("No printers found.");
                    }
                    break;

                case 3:
                    System.out.println("Search Printer");
                    System.out.println("--------------");
                    System.out.print("Please enter printer id: ");
                    int id = in.nextInt();
                    Printer p = service.getPrinterById(id);
                    if (p != null) {
                        System.out.println("Printer Name: " + p.getName());
                        System.out.println("Printer Model: " + p.getModel());
                        System.out.println("Printer Status: " + p.getStatus());
                    } else {
                        System.out.println("No printer found with id: " + id);
                    }
                    break;

                case 4:
                    System.out.println("Update Printer Details");
                    System.out.println("-----------------------");
                    System.out.print("Enter Printer Id: ");
                    int printerId = in.nextInt();
                    System.out.print("Enter Printer Name: ");
                    name = in.next();
                    System.out.print("Enter Printer Model: ");
                    model = in.next();
                    System.out.print("Enter Printer Status: ");
                    status = in.next();

                    Printer updatedPrinter = new Printer();
                    updatedPrinter.setId(printerId);
                    updatedPrinter.setName(name);
                    updatedPrinter.setModel(model);
                    updatedPrinter.setStatus(status);
                    service.updatePrinter(updatedPrinter);
                    break;

                case 5:
                    System.out.println("Delete Printer");
                    System.out.println("--------------");
                    System.out.print("Please enter printer id: ");
                    int pid = in.nextInt();
                    service.deletePrinter(pid);
                    break;

                case 6:
                    System.out.println("Are you sure you want to delete all printers? [Y/N]");
                    String confirm = in.next();
                    if (confirm.equalsIgnoreCase("Y")) {
                        service.deleteAllPrinters();
                    }
                    break;

                case 0:
                    System.out.println("Goodbye!");
                    System.exit(0);
                    break;

                default:
                    System.out.println("Please choose a valid option.");
                    break;
            }

        } while (option != 0);
    }
}
