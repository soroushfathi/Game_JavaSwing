package main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import elements.Tile;
import pages.ConfigWindow;
import pages.Board;

public class Main {
    public static void main(String[] args) {

        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                boolean flagDimension = true;
                String wOption ;
                do{
                    wOption = JOptionPane.showInputDialog("Enter the Width: ");
                    try{
                        Config.setWIDTH(Integer.parseInt(wOption));
                        flagDimension = true;
                    }catch (NumberFormatException | IndexOutOfBoundsException nfe){
                        flagDimension = false;
                        JOptionPane.showMessageDialog(null,"wrong value, try again");
                        System.err.println(nfe.getMessage());
                    }
                }while(Integer.parseInt(wOption)<=0 || !flagDimension);
                flagDimension = true;
                String hOption;
                do {
                    hOption = JOptionPane.showInputDialog("Enter the Height : ");
                    try{
                        Config.setHEIGHT(Integer.parseInt(hOption));
                        flagDimension = true;
                    }catch (NumberFormatException | IndexOutOfBoundsException nfe){
                        flagDimension = false;
                        JOptionPane.showMessageDialog(null,"wrong value, try again");
                        System.err.println(nfe.getMessage());
                    }
                }while (Integer.parseInt(hOption)<=0 || !flagDimension);
                Board window = new Board();
                window.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
                window.setVisible(true);
                window.toFront();
                window.addWindowListener(new IWindowListener());
            }
        });
        String[] fonts = GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames();
        UIManager.LookAndFeelInfo[] infos = UIManager.getInstalledLookAndFeels();
    }
}

class IWindowListener implements WindowListener {
    @Override
    public void windowOpened(WindowEvent e) {
        System.out.println("Window Opened");
    }

    @Override
    public void windowClosing(WindowEvent e) {
        System.out.println("Window Closing");
    }

    @Override
    public void windowClosed(WindowEvent e) {
        System.out.println("Window Closed");
    }

    @Override
    public void windowIconified(WindowEvent e) {
        System.out.println("Window Iconified");
    }

    @Override
    public void windowDeiconified(WindowEvent e) {
        System.out.println("Window Deiconified");
    }

    @Override
    public void windowActivated(WindowEvent e) {
        System.out.println("Window Activated");
    }

    @Override
    public void windowDeactivated(WindowEvent e) {
        System.out.println("Window Deactivated");
    }
}
