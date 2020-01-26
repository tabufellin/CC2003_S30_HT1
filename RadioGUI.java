/**
 * <h1>RadioGUI/h1>
 * This class includes the elements used in the GUI and the logic behind button presses.
 * <p>
 *
 *
 * @author Sebastian Gonzales (tabufellin) Pablo Ruiz (PingMaster99)
 * @version 2.0
 * @since 2020-01-19
 */
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;

public class RadioGUI extends JFrame {

    private JPanel mainPanel;
    private JButton onOffButton;
    private JButton back;
    private JButton forward;
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
    private JButton AMFMButton;
    private JButton guardarButton;
    private JTextField radioTextField;


    public RadioGUI () {
        // Uses the designed interface
        add(mainPanel);

        setTitle("Radio Matrix");
        setSize(570, 300);

        HandlerClass handler = new HandlerClass();
        onOffButton.addActionListener(handler);
        AMFMButton.addActionListener(handler);
        back.addActionListener(handler);
        forward.addActionListener(handler);
        a1Button.addActionListener(handler);
        a2Button.addActionListener(handler);
        a3Button.addActionListener(handler);
        a4Button.addActionListener(handler);
        a5Button.addActionListener(handler);
        a6Button.addActionListener(handler);
        a7Button.addActionListener(handler);
        a8Button.addActionListener(handler);
        a9Button.addActionListener(handler);
        a10Button.addActionListener(handler);
        a11Button.addActionListener(handler);
        a12Button.addActionListener(handler);
        guardarButton.addActionListener(handler);





    }


    private class HandlerClass implements ActionListener {

        MaquinaRadio radio = new MaquinaRadio();
        int botonParaGuardad = 0;
        double stationPlayed;

        public void actionPerformed(ActionEvent event) {


            // Turn radio on and off
            if (event.getSource() == onOffButton) {
                if (radio.getEstado()) {
                    radio.encenderApagar();
                    System.out.println("se apago");
                    System.out.println(radio.getEstado());
                } else {
                    radio.encenderApagar();
                    System.out.println("se encendio");
                    System.out.println(radio.getEstado());
                }
            }

            boolean on = radio.getEstado();

            if (on) {

                // Changes frequency
                if (event.getSource() == AMFMButton) {
                    if (radio.getTipoFrecuencia()) {
                        radio.cambioTipoFrecuencia(false);
                        System.out.println("Se cambio a FM");
                        System.out.println(radio.getTipoFrecuencia());

                    } else {
                        radio.cambioTipoFrecuencia(true);
                        System.out.println("Se cambio a AM");
                        System.out.println(radio.getTipoFrecuencia());

                    }
                }

                // Reduces the station
                if (event.getSource() == back) {
                    boolean whichFrequency = radio.getTipoFrecuencia();
                    radio.cambioEstacion(false, whichFrequency);
                    System.out.println(whichFrequency);
                    System.out.println(radio.currentFmStation);
                    System.out.println(radio.currentAmStation);
                }

                // Increases the station
                if (event.getSource() == forward) {
                    boolean whichFrequency = radio.getTipoFrecuencia();
                    radio.cambioEstacion(true, whichFrequency);
                    System.out.println(whichFrequency);
                    System.out.println(radio.currentFmStation);
                    System.out.println(radio.currentAmStation);
                }

                /// Gets the button that is pressed and displays the station
                if (event.getSource() == a1Button) {

                    int x = 1;
                    boolean whichFrequency = radio.getTipoFrecuencia();
                    stationPlayed = radio.seleccionarEstacion(whichFrequency, x);
                    botonParaGuardad = x;

                    System.out.println(radio.getEstacion());


                }

                if (event.getSource() == a2Button) {

                    int x = 2;
                    boolean whichFrequency = radio.getTipoFrecuencia();
                    stationPlayed = radio.seleccionarEstacion(whichFrequency, x);
                    botonParaGuardad = x;

                    System.out.println(radio.getEstacion());

                }

                if (event.getSource() == a3Button) {

                    int x = 3;
                    boolean whichFrequency = radio.getTipoFrecuencia();
                    stationPlayed = radio.seleccionarEstacion(whichFrequency, x);
                    botonParaGuardad = x;
                    System.out.println(radio.getEstacion());

                }

                if (event.getSource() == a4Button) {

                    int x = 4;
                    boolean whichFrequency = radio.getTipoFrecuencia();
                    stationPlayed = radio.seleccionarEstacion(whichFrequency, x);
                    botonParaGuardad = x;

                    System.out.println(stationPlayed);

                }

                if (event.getSource() == a5Button) {

                    int x = 5;
                    boolean whichFrequency = radio.getTipoFrecuencia();
                    stationPlayed = radio.seleccionarEstacion(whichFrequency, x);
                    botonParaGuardad = x;

                    System.out.println(stationPlayed);

                }

                if (event.getSource() == a6Button) {

                    int x = 6;
                    boolean whichFrequency = radio.getTipoFrecuencia();
                    stationPlayed = radio.seleccionarEstacion(whichFrequency, x);
                    botonParaGuardad = x;

                    System.out.println(stationPlayed);

                }

                if (event.getSource() == a7Button) {

                    int x = 7;
                    boolean whichFrequency = radio.getTipoFrecuencia();
                    stationPlayed = radio.seleccionarEstacion(whichFrequency, x);
                    botonParaGuardad = x;

                    System.out.println(stationPlayed);

                }

                if (event.getSource() == a8Button) {

                    int x = 8;
                    boolean whichFrequency = radio.getTipoFrecuencia();
                    stationPlayed = radio.seleccionarEstacion(whichFrequency, x);
                    botonParaGuardad = x;

                    System.out.println(stationPlayed);

                }

                if (event.getSource() == a9Button) {

                    int x = 9;
                    boolean whichFrequency = radio.getTipoFrecuencia();
                    stationPlayed = radio.seleccionarEstacion(whichFrequency, x);
                    botonParaGuardad = x;

                    System.out.println(stationPlayed);

                }

                if (event.getSource() == a10Button) {

                    int x = 10;
                    boolean whichFrequency = radio.getTipoFrecuencia();
                    stationPlayed = radio.seleccionarEstacion(whichFrequency, x);
                    botonParaGuardad = x;

                    System.out.println(stationPlayed);

                }

                if (event.getSource() == a11Button) {

                    int x = 11;
                    boolean whichFrequency = radio.getTipoFrecuencia();
                    stationPlayed = radio.seleccionarEstacion(whichFrequency, x);
                    botonParaGuardad = x;

                    System.out.println(stationPlayed);

                }

                if (event.getSource() == a12Button) {

                    int x = 12;
                    boolean whichFrequency = radio.getTipoFrecuencia();
                    stationPlayed = radio.seleccionarEstacion(whichFrequency, x);
                    botonParaGuardad = x;

                    System.out.println(stationPlayed);

                }

                // Saves the station in the last button pressed
                if (event.getSource() == guardarButton) {

                    boolean whichFrequency = radio.getTipoFrecuencia();
                    int whichBoton = botonParaGuardad;
                    stationPlayed = radio.getEstacion();
                    System.out.println(whichBoton);
                    System.out.println(stationPlayed);

                    radio.guardarEstacion(stationPlayed, whichFrequency, whichBoton);
                    System.out.println("pasa");
                }

                // Formats the station to be displayed on screen
                double station = radio.getEstacion();
                DecimalFormat df = new DecimalFormat("0.00");

                if(radio.getTipoFrecuencia()) {
                    df = new DecimalFormat("0");
                    radioTextField.setText(df.format(station) + " AM");
                } else {
                    radioTextField.setText(df.format(station) + " FM");

                }
            //Display when radio is off
            } else {
                radioTextField.setText("----");

            }
        }


    }
    }





