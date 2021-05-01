package pages;

import main.Config;
import javax.swing.*;
import java.awt.*;

public class ConfigWindow extends JFrame {
    public ConfigWindow() throws HeadlessException {
        JButton btn = new JButton("Submit");
        btn.setSize(90,28);
        btn.setLocation(35,400);
        add(btn);
        setSize(180, 480);
        setLocation(504+ Config.getWIDTH()*41, 150);
        setTitle(" ");
        setResizable(false);
        ConfigComponent cmp = new ConfigComponent();
        add(cmp);
    }
}
class ConfigComponent extends JComponent {

    @Override
    public void paint(Graphics g) {
        Font font = new Font("Calibri", Font.BOLD,17);
        g.setFont(font);
        g.setColor(Color.blue);
        g.drawString("config form",35,25);
    }
    @Override
    public Dimension getPreferredSize() {
        return new Dimension(30, 170);
    }
}