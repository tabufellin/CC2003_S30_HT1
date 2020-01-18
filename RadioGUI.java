package com;

import javax.swing.*;

public class RadioGUI extends JFrame {
    public RadioGUI () {
        // Uses the designed interface
        add(mainPanel);

        setTitle("Radio Matrix");
        setSize(570, 300);
    }
    private JPanel mainPanel;
    private JButton offButton;
    private JButton onButton;
    private JRadioButton AMFMRadioButton;
    private JTextField radioMatrixTextField;
    private JButton button1;
    private JButton button2;
    private JButton a12Button;
    private JButton a11Button;
    private JButton a8Button;
    private JButton a7Button;
    private JButton a5Button;
    private JButton a9Button;
    private JButton a6Button;
    private JButton a10Button;
    private JButton a1Button;
    private JButton a2Button;
    private JButton a3Button;
    private JButton a4Button;
    private JRadioButton guardarEstaciónRadioButton;
}
