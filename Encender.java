public class MaquinaRadio implements Radio {

    private boolean encendido;
    private String estacionGuardada;
    private int currentAmStation = 550;
    private double currentFmStation = 90.1;
    private boolean tipoFrecuencia = false;   // false para FM, true para AM

    public void encender() {
        this.encendido = true;
    }

    public void apagar() {
        this.encendido = false;
    }

    public void cambioTipoFrecuencia(boolean tipo) {
        if(tipo) {
            this.tipoFrecuencia = !this.tipoFrecuencia;
        }
    }

    public void cambioEstacion(boolean tipo, boolean tipoFrecuencia) {
        // AM frequency 
        if(tipoFrecuencia) {
            if(tipo && this.currentAmStation < 1610) {
                this.currentAmStation += 10;
            } else {
                this.currentAmStation -= 10;
            }

            // Checks if the station is within the defined range, and overflows or underflows accordingly
            if(this.currentAmStation > 1610) {
                this.currentAmStation = 530;
            } else if(this.currentAmStation < 530) {
                this.currentAmStation = 1610;
            }

        // FM frequency
        } else {
            if(tipo && this.currentFmStation < 107.9) {
                this.currentFmStation += 0.2;
            } else {
                this.currentFmStation -= 0.2;
            }

            // Checks if the station is within the defined range, and overflows or underflows accordingly
            if(this.currentFmStation > 107.9) {
                this.currentFmStation = 87.9;
            } else if(this.currentFmStation < 87.9) {
                this.currentFmStation = 107.9;
            }
        }
    }
    
    public double getCurrentFmStation() {
        return this.currentFmStation;
    }


}
