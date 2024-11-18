package com.edubridge.printermanagement.dao;


import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.edubridge.printermanagement.model.Printer;
import com.edubridge.printermanagement.utils.HibernateUtils;

public class PrinterDao implements PrinterDaoI {

    @Override
    public void addPrinter(Printer printer) {
        Transaction tx = null;
        try (Session session = HibernateUtils.getSessionFactory().openSession()) {
            tx = session.beginTransaction();
            session.persist(printer);  // Save the printer
            tx.commit();
            System.out.println("New printer added!");
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        }
    }

    @Override
    public List<Printer> getAllPrinters() {
        List<Printer> printers = new ArrayList<>();
        try (Session session = HibernateUtils.getSessionFactory().openSession()) {
            String hql = "from Printer";
            Query query = session.createQuery(hql, Printer.class);
            printers = query.list();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return printers;
    }

    @Override
    public Printer getPrinterById(Integer id) {
        Printer printer = null;
        try (Session session = HibernateUtils.getSessionFactory().openSession()) {
            printer = session.get(Printer.class, id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return printer;
    }

    @Override
    public void updatePrinter(Printer printer) {
        Transaction tx = null;
        try (Session session = HibernateUtils.getSessionFactory().openSession()) {
            tx = session.beginTransaction();
            session.merge(printer);  // Update the printer
            tx.commit();
            System.out.println("Printer updated!");
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        }
    }

    @Override
    public void deletePrinter(Integer id) {
        Transaction tx = null;
        try (Session session = HibernateUtils.getSessionFactory().openSession()) {
            tx = session.beginTransaction();
            Printer printer = session.get(Printer.class, id);

            if (printer != null) {
                session.remove(printer);
                tx.commit();
                System.out.println("Printer deleted!");
            } else {
                System.out.println("No printer found with id: " + id);
            }
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        }
    }

    @Override
    public void deleteAllPrinters() {
        Transaction tx = null;
        try (Session session = HibernateUtils.getSessionFactory().openSession()) {
            tx = session.beginTransaction();
            String hql = "delete from Printer";
            Query query = session.createQuery(hql);
            query.executeUpdate();
            tx.commit();
            System.out.println("All printers deleted!");
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        }
    }
}
