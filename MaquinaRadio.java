/**
* <h1>Main</h1>
* This is the main class to run the Radio application, it displays
* the radio window which simulates the behavior of a traditional 
* radio.
* <p>
*
*
* @author Sebastian Gonzales (tabufellin) Pablo Ruiz (PingMaster99)
* @version 1.0
* @since 2020-01-19
*/

public class MaquinaRadio implements Radio {

    static final String UNDER_DEVELOPMENT_METHOD = "Method is under development";
    boolean encendido;
    String estacionGuardada;
    int currentAmStation = 550;
    int maxCurrentAmStation = 1610;
    int minCurrentAmStation = 530;
    double currentFmStation = 90.1;
    boolean tipoFrecuencia = false;   // false para FM, true para AM
    double[] botonesAM ;
    double[] botonesFM;


    // hay que darle la estacion que va a estar en ese momento
    double currentStation;

   /**
   * This method is used to set the radio as on;
   * it also creates arrays used for the buttons
   * needed to save stations.
   * @param Unused
   * @return Nothing
   */
    public MaquinaRadio() {
        int cuantasEstaciones = 12;

        encendido = true;
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
   * This method is used to set the radio as on.
   * @param Unused
   * @return Nothing
   */
    public void encender() {
        this.encendido = true;
    }

   /**
   * This method is used to set the radio as off.
   * @param Unused
   * @return Nothing
   */
    public void apagar() {
        this.encendido = false;
    }

   /**
   * This method is used to change the frequency used in 
   * the radio (AM or FM). 
   * @param tipo changes the frequency to AM or FM
   * @return Nothing
   */
    public void cambioTipoFrecuencia(boolean tipo) {
        this.tipoFrecuencia = !this.tipoFrecuencia;
        if (tipo) {
            currentStation=  currentAmStation;
        } else {
            currentStation = currentFmStation;
        }

    }

   /**
   * This method is used to change the current station in the radio.
   * @param tipo boolean indicates if the station will increase or decrease
   * @param tipoFrecuencia indicates AM (true) or FM (false) frequency
   * @return Nothing
   */
    public void cambioEstacion(boolean tipo, boolean tipoFrecuencia) {
        // AM frequency
        if (tipoFrecuencia) {
            if (tipo) {
                if (currentAmStation < maxCurrentAmStation) {
                    currentAmStation += 10;
                }
                else {
                    // falta asignarle el valor
                    currentAmStation = minCurrentAmStation;
                }

            } else {
                if (currentAmStation > minCurrentAmStation + 10) {
                    currentAmStation -= 10;
                }
                else {
                    currentAmStation = maxCurrentAmStation;
                }
            }

            // FM frequency
        } else {
            if (tipo && currentFmStation < 107.9) {
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
    }

   /**
   * This method is used to change the current station in the radio.
   * @param tipo boolean indicates if the station will increase or decrease
   * @param tipoFrecuencia indicates AM (true) or FM (false) frequency
   * @return Nothing
   */
    public void guardarEstacion(double estacion, boolean tipoFrecuencia, int boton){

        boton -=1;
        //if AM --------else FM
        if (tipoFrecuencia) {
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

            currentStation = botonesAM[boton];

        } else {

            currentStation = botonesFM[boton];

        }

        return currentStation;
    }



    // Methods to obtain current value of variables; getters
    
   /**
   * This method gets the current FM station 
   * @param Unused
   * @return double with current FM station 
   */
    public double getCurrentFmStation() {
        return this.currentFmStation;
    }

   /**
   * This method gets the on/off state 
   * @param Unused
   * @return boolean that indicates if the radio is on (true) or off (false)
   */
    public boolean getEncendido() {
        return encendido;
    }

   /**
   * This method gets the saved station  
   * @param Unused
   * @return String with the saved station
   */
    public String getEstacionGuardada() {
        return estacionGuardada;
    }

   /**
   * This method gets the current AM station 
   * @param Unused
   * @return int with the current AM station 
   */
    public int getCurrentAmStation() {
        return currentAmStation;
    }

   /**
   * This method gets the frequency type
   * @param Unused
   * @return boolean that indicates AM (true) or FM (false) frequency
   */
    public boolean getTipoFrecuencia() {
        return tipoFrecuencia;
    }

   /**
   * This method sets the on / off value of the radio
   * @param boolean valor that indicates on (true) or off (false)
   * @return Nothing
   */
    public void setEncendido (boolean valor){
        encendido = valor;
    }
}
