/**
 * <h1>Main</h1>
 * This is the main class to run the Radio application, it displays
 * the radio window which simulates the behavior of a traditional
 * radio.
 * <p>
 *
 *
 * @author Sebastian Gonzales (tabufellin) Pablo Ruiz (PingMaster99)
 * @version 2.0
 * @since 2020-01-19
 */
public class MaquinaRadio implements Radio {

    boolean estado;
    int currentAmStation = 550;
    double currentFmStation = 90.1;
    boolean tipoFrecuencia = false;   // false para FM, true para AM
    double[] botonesAM ;
    double[] botonesFM;


    // hay que darle la estacion que va a estar en ese momento
    double currentStation;

    /**
     * Constructor used in MaquinaRadio
     */
// el constructor parece estar bien aun con los nuevos cambios
    public MaquinaRadio() {
        int cuantasEstaciones = 12;

        estado = true;
        botonesAM = new double[12];
       for (int i = 0; i <= cuantasEstaciones-1; i++) {
            botonesAM[i] = 550;
        }
        botonesFM = new double[12];
       for (int i = 0; i <= cuantasEstaciones-1; i++) {
            botonesFM[i] = 90.1;
        }
    }

    /**
     * This method is used to turn the radio on and off
     * @return boolean
     */
    public boolean encenderApagar() {
        this.estado = !this.estado;
        return this.estado;
    }

    /**
     * This method is used to change the frequency used in
     * the radio (AM or FM).
     * @param tipo changes the frequency to AM or FM
     * @return boolean
     */
    // bien
    public boolean cambioTipoFrecuencia(boolean tipo) {
        this.tipoFrecuencia = !this.tipoFrecuencia;
        if (tipo) {
            currentStation =  currentAmStation;
        } else {
            currentStation = currentFmStation;
        }

        return this.tipoFrecuencia;
    }

    /**
     * This method is used to change the current station in the radio.
     * @param tipo boolean indicates if the station will increase or decrease
     * @param tipoFrecuencia indicates AM (true) or FM (false) frequency
     * @return double
     */
    public double cambioEstacion(boolean tipo, boolean tipoFrecuencia) {
        // AM frequency
        if (tipoFrecuencia) {
            if (tipo) {
                currentAmStation += 10;
            } else {
                currentAmStation -= 10;
            }

            if (currentAmStation > 1610) {
                currentAmStation = 530;
            } else if (currentAmStation < 530) {
                currentAmStation = 1610;
            }

            // FM frequency
        } else {
            if (tipo) {
                currentFmStation += 0.2;
            } else {
                currentFmStation -= 0.2;
            }

            // Checks if the station is within the defined range, and overflows or underflows accordingly
            if (currentFmStation > 107.9) {
                currentFmStation = 87.9;
            } else if (currentFmStation < 87.9) {
                currentFmStation = 107.9;
            }

        }

        if (tipoFrecuencia) {
            currentStation = currentAmStation;
        } else {
            currentStation = currentFmStation;
        }

        return currentStation;
    }

    /**
     * This method is used to change the current station in the radio.
     * @param estacion double indicates the station to be saved
     * @param tipoFrecuencia indicates AM (true) or FM (false) frequency
     * @param boton indicates the button to which the station will be saved
     * @return Nothing
     */
    public void guardarEstacion(double estacion, boolean tipoFrecuencia, int boton) {

        boton -=1;
        //if AM --------else FM
        if (tipoFrecuencia) {
           System.out.println("estoy dentro");
           System.out.println(estacion);
            botonesAM[boton] = estacion;
        } else {
            botonesFM[boton] = estacion;
        }
    }

    /**
     * This method is used to select a saved station in a button.
     * @param tipoFrecuencia indicates AM (true) or FM (false) frequency
     * @param boton one of the 12 buttons present in the radio
     * @return double with the station that is played
     */
    public double seleccionarEstacion(boolean tipoFrecuencia, int boton) {

        boton -= 1;

        // if AM tipoFrecuencia = true
        // y else FM = false
        if (tipoFrecuencia){

            currentStation = botonesAM[boton] ;

        } else {

            currentStation = botonesFM[boton];

        }

        return currentStation;
    }



    // Methods to obtain current value of variables; getters

    /**
     * This method gets the on/off state
     * @return boolean that indicates if the radio is on (true) or off (false)
     */
    public boolean getEstado() {
        return estado;
    }

    /**
     * This method gets the frequency type
     * @return boolean that indicates AM (true) or FM (false) frequency
     */
    public boolean getTipoFrecuencia() {
        return tipoFrecuencia;
    }

    /**
     * This method gets the current station
     * @return double that represents the station number
     */
    public double getEstacion() {
        return currentStation;
    }

}