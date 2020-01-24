public interface Radio {

    //Cambio de frecuencia e.g. 99.9 al 100.0
    public double cambioEstacion(boolean tipo, boolean tipoFrecuencia);

    // Cambio de AM <-> FM
    public boolean cambioTipoFrecuencia(boolean tipo);

    // Encender y apagar la radio
    public boolean encenderApagar();

    // Guardar la estacion escuchada
    public void guardarEstacion(double estacion, boolean tipoFrecuencia, int boton);

    // Seleccionar la estacion guardada en el boton
    public double seleccionarEstacion(boolean tipoFrecuencia, int boton);

    public double getEstacion();

    public boolean getTipoFrecuencia();

    public boolean getEstado();

}
