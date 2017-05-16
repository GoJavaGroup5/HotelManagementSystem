package group5.hotelms;

import group5.hotelms.db.DataLoader;
import group5.hotelms.gui.form;
import group5.hotelms.model.Data;

import javax.swing.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * Start point for application.
 * @author voksus 13.05.2017
 */
public class Main {

    public static void main(String[] args) {

        loadData(false);

        JFrame jFrame = new JFrame();
        setJFrameParam(jFrame);

    }

    private static void setJFrameParam(JFrame jFrame) {
        try {
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        jFrame.setTitle("Hotel Management System");
        jFrame.setContentPane(new form().getMainPanel());
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //saveData());
        jFrame.setResizable(false);
        jFrame.setLocation(520, 150);
        jFrame.pack();
        jFrame.setVisible(true);
        jFrame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                super.windowClosing(e);
                if (e.getID() == WindowEvent.WINDOW_CLOSING) {
                    /**
                     * Here the Data saving before close application
                     */
                    System.out.println("Saving data.....");
                    DataLoader.save();
                    System.out.println("Saving complete!");
                    System.exit(0);
                }
            }
        });
    }

    private static void loadData(boolean show_loaded_data) {

//         1 - load existing data DataLoader.load()
//         2 - creates a new data DataLoader.testdata()
        int dataSource = 1;

        switch (dataSource) {
            case 1:
                System.out.println("loading.....");
                DataLoader.load();
                System.out.println("Loading complete!");
                break;
            case 2:
                System.out.println("Generating new Data....");
                DataLoader.testdata();
                System.out.println("Generating complete!");
        }

        if (show_loaded_data) {
            System.out.println(Data.getHotels());
            System.out.println(Data.getUsers());
        }
    }

}