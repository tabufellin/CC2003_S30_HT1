/**
 * <h1>MaquinaRadioTest</h1>
 * Junit tests used.
 * <p>
 *
 *
 * @author Sebastian Gonzales (tabufellin) Pablo Ruiz (PingMaster99)
 * @version 2.0
 * @since 2020-01-19
 */
import static org.junit.Assert.*;

public class MaquinaRadioTest {

    @org.junit.Test
    public void encenderApagar() {
        MaquinaRadio instance = new MaquinaRadio();
        instance.encenderApagar();
        assertEquals(false, instance.getEstado());
    }


    @org.junit.Test
    public void cambioTipoFrecuencia() {
        MaquinaRadio instance = new MaquinaRadio();
        instance.cambioTipoFrecuencia(true);
        assertEquals(true, instance.getTipoFrecuencia());
    }

    // Test que va a fallar
    @org.junit.Test
    public void getEstacion() {
        MaquinaRadio instance = new MaquinaRadio();
        instance.cambioEstacion(true,true);
        instance.getEstacion();
        assertEquals(2527414.8, instance.getEstacion(), 0);
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
