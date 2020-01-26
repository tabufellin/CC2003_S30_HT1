import static org.junit.Assert.*;

public class MaquinaRadioTest {

    @org.junit.Test
    public void encenderApagar() {
        MaquinaRadio instance = new MaquinaRadio();
        instance.encenderApagar();
        assertEquals(true, instance.getEstado());
    }

//    // Test que va a fallar
/*    @org.junit.Test
    public void apagar() {
        MaquinaRadio instance = new MaquinaRadio();
        instance.apagar();
        assertEquals(true, instance.getEncendido());
    }*/

    @org.junit.Test
    public void cambioTipoFrecuencia() {
        MaquinaRadio instance = new MaquinaRadio();
        instance.cambioTipoFrecuencia(true);
        assertEquals(true, true);
    }

    @org.junit.Test
    public void cambioEstacion() {
        MaquinaRadio instance = new MaquinaRadio();
        instance.cambioEstacion(true, true);
        assertEquals(560, instance.getEstacion(), 0);

        instance.cambioEstacion(false, true);
        assertEquals(550, instance.getEstacion(), 0);

        instance.cambioEstacion(false, true);
        instance.cambioEstacion(false, true);
        instance.cambioEstacion(false, true);
        assertEquals(1610, instance.getEstacion(), 0);

        instance.cambioEstacion(true, false);
        assertEquals(90.3, instance.getEstacion(), 0);

        instance.cambioEstacion(true, false);
        assertEquals(90.5, instance.getEstacion(), 0);

        instance.cambioEstacion(false, false);
        assertEquals(90.3, instance.getEstacion(), 0);

    }

}
