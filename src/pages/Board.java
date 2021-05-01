package pages;

import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.awt.geom.Rectangle2D;
import elements.*;
import elements.Bead;
import main.Player;

import static main.Config.*;
import static main.Globals.players;


public class Board extends JFrame {
    private final JPanel configPanel;
    JButton subBtn;
    JButton resBtn;
    public Board() throws HeadlessException {
        setLayout(null) ;
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
        configPanel.setSize(150,getHEIGHT()*40 + 1);
        configPanel.setLocation(getWIDTH()*40 + 3,1);
        BtnListener btnListener = new BtnListener();
        subBtn.addActionListener(btnListener);
        resBtn.addActionListener(btnListener);
        // whole page
        setSize(getWIDTH()*40 + 20 + 150 , getHEIGHT() * 40 + 42);
        setLocation(500, 100);
        setTitle("Game");
        setResizable(false);
        Image img = new ImageIcon("E:\\University\\Semester 2\\Advance Programming\\Projects\\midProject_JavaSwing\\src\\elements\\assets\\logo.jpg").getImage();
        setIconImage(img);
        add(configPanel);
        Bead b0=new Bead(0,0,0,true);
        Bead b1=new Bead(getWIDTH()-1,getWIDTH()-1,1,false);
        players[0]=new Player(b0);
        players[1]=new Player(b1);
        add(b0); // btn >> jPanel >> Jframe
        add(b1); // btn >> jPanel >> Jframe


        for(int i=0;i<getHEIGHT();i++)
            for(int j=0;j<getWIDTH();j++)
                add(new Tile(j,i));
    }
    class BtnListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
           if(e.getSource()==subBtn){
              configPanel.setSize(0,0);
           }
           else if(e.getSource()==resBtn)
               configPanel.setBackground(Color.blue);
        }
    }
}

class BoardComponent extends JComponent{
    @Override
    protected void paintComponent(Graphics g) {
        Rectangle2D rectangle2D;
        Graphics2D graphics2D = (Graphics2D)g;
//        Image BackImg1 = new ImageIcon("E:\\University\\Semester 2\\Advance Programming\\Projects\\midProject_JavaSwing\\src\\elements\\assets\\download.png").getImage();
//        Image BackImg2 = new ImageIcon("E:\\University\\Semester 2\\Advance Programming\\Projects\\midProject_JavaSwing\\src\\elements\\assets\\download1.png").getImage();
//        for(int i=0;i<getHEIGHT();i++)
//            for(int j = 0; j<getWIDTH();j++){
//                rectangle2D = new Rectangle2D.Double(j*getTile_Size(),i*getTile_Size(),getTile_Size(),getTile_Size());
//                if((i+j)%2==0)
//                    graphics2D.setPaint(new Color(102, 255, 0, 195));
//                else
//                    graphics2D.setPaint(new Color(10, 0, 255, 173));
//                graphics2D.fill(rectangle2D);
//                graphics2D.draw(rectangle2D);
//            }

        //add(new Bead(1,3),1);

        Font font = new Font("B Sahar",Font.BOLD,28);
        g.drawString("Join the Game",getWIDTH()*40 + 30,20);
    }
    @Override
    public Dimension getPreferredSize() {
        return new Dimension(getWIDTH()*40 + 1, getHEIGHT()*40 + 1);
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