package view;

import javax.swing.*;

public class InterfaceView extends JFrame {
    public static void definirIcone(JFrame frame) {
        ImageIcon img = new ImageIcon("./senac-logo.png");
        frame.setIconImage(img.getImage());
    }
}