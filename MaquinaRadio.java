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


    public boolean encenderApagar() {
        this.estado = !this.estado;
        return this.estado;
    }

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

    // bien
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

     // bien
    public boolean getEstado() {
        return estado;
    }

    //bien
    public boolean getTipoFrecuencia() {
        return tipoFrecuencia;
    }

    //bien
    public double getEstacion() {
        return currentStation;
    }

}