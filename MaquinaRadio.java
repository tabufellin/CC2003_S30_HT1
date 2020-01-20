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
    int botonParaGuardad;


    // hay que darle la estacion que va a estar en ese momento
    double currentStation;

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


    public void encender() {
        this.encendido = true;
    }

    public void apagar() {
        this.encendido = false;
    }

    // Creo que ya esta terminado este metodo
    public void cambioTipoFrecuencia(boolean tipo) {
        this.tipoFrecuencia = !this.tipoFrecuencia;
        if (tipo) {
            currentStation=  currentAmStation;
        } else {
            currentStation = currentFmStation;
        }

    }

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

        if (tipoFrecuencia) {
            currentStation = currentAmStation;
        } else {
            currentStation = currentFmStation;
        }
    }

//***********************INCOMPLETE METHODS*****************************************************************************

    public void guardarEstacion(double estacion, boolean tipoFrecuencia, int boton){

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

    public double getCurrentFmStation() {
        return this.currentFmStation;
    }

    public boolean getEncendido() {
        return encendido;
    }

    public String getEstacionGuardada() {
        return estacionGuardada;
    }

    public int getCurrentAmStation() {
        return currentAmStation;
    }

    public boolean getTipoFrecuencia() {
        return tipoFrecuencia;
    }

    public void setEncendido (boolean valor){
        encendido = valor;
    }

    public double[] getBotonesAM () {
        return botonesAM;
    }

    public double[] getBotonesFM () {
        return botonesFM;
    }

    public int getBotonParaGuardad() {
        return botonParaGuardad;
    }

    public void setBotonParaGuardad(int botonParaGuardad) {
        this.botonParaGuardad = botonParaGuardad;
    }

    public double getCurrentStation() {
        return currentStation;
    }

    public void setCurrentStation(double currentStation) {
        this.currentStation = currentStation;
    }
}