package pages;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.Rectangle2D;
import elements.*;
import elements.Bead;
import main.Config;
import main.Globals;
import main.Player;
import static main.Config.*;
import static main.Globals.players;


public class Board extends JFrame {

    private final JPanel configPanel;
    JButton subBtn;
    JButton resBtn;
    public static Star[] stars = new Star[Config.getHEIGHT()*Config.getWIDTH()];
    public static Wall[] walls = new Wall[Config.getHEIGHT()*Config.getWIDTH()];
    public static Snail[] snails = new Snail[Config.getHEIGHT()*Config.getWIDTH()];
    public static ElementType[][] xyItem = new ElementType[Config.getWIDTH()][Config.getHEIGHT()];
    public static void setElement(ElementType item,int x,int y){
        xyItem[x][y] = item;
    }
    public static ElementType getItem(int x,int y){
        return xyItem[x][y];
    }

    public Board() throws HeadlessException {
        setLayout(null);
        configPanel = new JPanel();//config panel
        try {
            UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
            SwingUtilities.updateComponentTreeUI(configPanel);
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        }
        subBtn = new JButton("Submit");
        resBtn = new JButton("Reset");
        configPanel.add(subBtn);
        configPanel.add(resBtn);
        configPanel.setSize(150, getHEIGHT() * 40 + 1);
        configPanel.setLocation(getWIDTH() * 40 + 3, 1);
        BtnListener btnListener = new BtnListener();
        subBtn.addActionListener(btnListener);
        resBtn.addActionListener(btnListener);
        // whole page
        setSize(getWIDTH() * 40 + 20 + 150, getHEIGHT() * 40 + 42);
        setLocation(500, 100);
        setTitle("Game");
        setResizable(false);
        Image img = new ImageIcon("E:\\University\\Semester 2\\Advance Programming\\Projects\\midProject_JavaSwing\\src\\elements\\assets\\logo.jpg").getImage();
        setIconImage(img);
        add(configPanel);
        Bead b0 = new Bead(0, 0, 0, true);
        Bead b1 = new Bead(getWIDTH() - 1, getWIDTH() - 1, 1, false);
        players[0] = new Player(b0);
        players[1] = new Player(b1);
        add(b0); // btn >> jPanel >> Jframe
        add(b1); // btn >> jPanel >> Jframe


        for (int i = 0; i < getHEIGHT(); i++)
            for (int j = 0; j < getWIDTH(); j++)
                add(new Tile(j, i));

        for(int i=0;i<stars.length;i++) {
            stars[i] = new Star(-1,-1);
            add(stars[i],1);
        }
        for(int i=0;i<walls.length;i++) {
            walls[i] = new Wall(-1,-1);
            add(walls[i],1);
        }
        for(int i=0;i<snails.length;i++) {
            snails[i] = new Snail(-1,-1);
            add(snails[i],1);
        }
    }

    class BtnListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == subBtn) {
                configPanel.setSize(0, 0);
                Globals.PREPARE = false;
            } else if (e.getSource() == resBtn)
                configPanel.setBackground(Color.blue);
        }
    }

}

class BoardComponent extends JComponent {
    @Override
    protected void paintComponent(Graphics g) {
        Rectangle2D rectangle2D;
        Graphics2D graphics2D = (Graphics2D) g;
        Font font = new Font("B Sahar", Font.BOLD, 28);
        g.drawString("Join the Game", getWIDTH() * 40 + 30, 20);
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(getWIDTH() * 40 + 1, getHEIGHT() * 40 + 1);
    }
}


//class ConfigPanel extends JPanel{
//    JPanel jPanel;
//    public ConfigPanel(JPanel jPanel) {
//        JButton subBtn = new JButton("Submit");
//        JButton resBtn = new JButton("Reset");
//        jPanel.add(subBtn);
//        jPanel.add(resBtn);
//        jPanel.setSize(150,getHEIGHT()*40 + 1);
//        jPanel.setLocation(getWIDTH()*40 + 3,1);
//    }
//
//    @Override
//    protected void paintComponent(Graphics g) {
//        super.paintComponent(g);
//    }
//
//    @Override
//    public Dimension getPreferredSize() {
//        return super.getPreferredSize();
//    }
//
//    public ConfigPanel() {
//
//    }
//}