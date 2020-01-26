/**
 * <h1>Radio</h1>
 * This is the interface used in the radio program.
 * <p>
 *
 *
 * @author Sebastian Gonzales (tabufellin) Pablo Ruiz (PingMaster99)
 * @version 2.0
 * @since 2020-01-19
 */
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
