public class MaquinaRadio implements Radio {

    static final String UNDER_DEVELOPMENT_METHOD = "Method is under development";
    boolean encendido;
    String estacionGuardada;
    int currentAmStation = 550;
    int maxCurrentAmStation = 1610;
    int minCurrentAmStation = 530;
    double currentFmStation = 90.1;
    boolean tipoFrecuencia = false;   // false para FM, true para AM
    ArrayList <Double>[12] botonesAM;
    ArrayList <Double>[12] botonesFM;


    // hay que darle la estacion que va a estar en ese momento
    double currentStation;
    

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
                    currentAmStation = maxCurrentAmStation
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

//***********************INCOMPLETE METHODS*****************************************************************************

    public void guardarEstacion(double estacion, boolean tipoFrecuencia, int boton){

        boton -=1;
        //if AM --------else FM
        if (tipoFrecuencia) {
            botonesAM[boton] = estacion
        } else {
            botonesFM[boton] = estacion
        }
    }

    public double seleccionarEstacion(boolean tipoFrecuencia, int boton) {
        System.out.println(UNDER_DEVELOPMENT_METHOD);
        return -1;
    }



    // Methods to obtain current value of variables; getters

    public double getCurrentFmStation() {
        return this.currentFmStation;
    }

    public boolean isEncendido() {
        return encendido;
    }

    public String getEstacionGuardada() {
        return estacionGuardada;
    }

    public int getCurrentAmStation() {
        return currentAmStation;
    }

    public boolean isTipoFrecuencia() {
        return tipoFrecuencia;
    }
}
