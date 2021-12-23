import org.junit.Assert;
import org.junit.Test;

public class Ejercicio_3Test {


    @Test
    public void principal() {
        Ejercicio_3.completitud = 10;
        Ejercicio_3.correcion = 34;
        Ejercicio_3.pertinencia = 85;
        Assert.assertEquals(true,Ejercicio_3.principal());

    }
    @Test
    public void adecuacion_menu() {

          Ejercicio_3.completitud = 10;
          Ejercicio_3.correcion = 34;
          Ejercicio_3.pertinencia = 85;

        Assert.assertTrue(Ejercicio_3.adecuacion_menu() <= 5);

    }
    @Test
    public void adecuacion_menu2() {
         Ejercicio_3.completitud = 10;
         Ejercicio_3.correcion = 34;
         Ejercicio_3.pertinencia = 85;
        Assert.assertTrue( Ejercicio_3.adecuacion_menu()>=0);

    }


    @Test
    public void mantenibilidad_menu() {

        Ejercicio_3.modulo = 66;
        Ejercicio_3.reusable = 9;
        Ejercicio_3.analiza = 54;
        Ejercicio_3.cm = 90;
        Ejercicio_3.cp = 23;

        Assert.assertTrue(Ejercicio_3.mantenibilidad_menu()<=4);
    }

    @Test
    public void mantenibilidad_menu1() {

      Ejercicio_3.modulo = 66;
      Ejercicio_3.reusable = 9;
      Ejercicio_3.analiza = 54;
      Ejercicio_3.cm = 90;
      Ejercicio_3.cp = 23;

        Assert.assertTrue( Ejercicio_3.mantenibilidad_menu()>=0);
    }




    @Test
    public void rango_mediciones() {
        Assert.assertTrue(Ejercicio_3.rang >= 0 && Ejercicio_3.rang < 100);
    }

    @Test
    public void manteabilidad() {
        Assert.assertTrue(Ejercicio_3.mantenibilidad_menu()>=0);
    }
    @Test
    public void manteabilidad1() {
        Assert.assertTrue(Ejercicio_3.mantenibilidad_menu()<=5);
    }

}