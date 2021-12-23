import java.util.*;

public class Ejercicio_3 {
    public static Scanner tc = new Scanner(System.in);
    public static int adecuacion_funcional[][] = { { 0, 0, 0 }, { 1, 1, 2 }, { 2, 1, 2 }, { 2, 2, 3 }, { 3, 3, 4 }, { 4, 5, 5 } };
    public static int mantenibilidad[][] = { { 0, 0, 0, 0 }, { 1, 1, 0, 1, 1 }, { 2, 2, 1, 2, 1 }, { 2, 2, 2, 3, 2 },
            { 3, 3, 3, 4, 4 }, { 4, 5, 5, 5, 4 } };
    static int calidad_global[][] = { { 1, 1, 1, 1, 1 }, { 1, 2, 2, 2, 2 }, { 2, 2, 3, 3, 3 }, { 3, 3, 3, 3, 4 },
            { 3, 3, 4, 4, 5 } };
    public static int rang;
    public static int completitud;
    public static int  correcion;
    public static int pertinencia;
    public static int modulo;
    public static int reusable;
    public static int analiza;
    public static int cm;
    public static int cp;
    public static int af;
    public static int min;

    public static void main(String[] args) throws Exception {
        principal();

    }
    public static boolean principal() {
        boolean a=true;

            boolean certificable = false;
            System.out.println("1. Calcular Calidad Global y posibilidad de Certificación");
            System.out.println("2. Salir");

            try {
                int opcion=1;

                            System.out.println("Rellene los siguientes datos: ");
                            af = adecuacion_menu();
                            int mang = mantenibilidad_menu();

                            System.out.println("\nAdecuación Funcional: " + af);

                            System.out.println("\nMantenibilidad: " + mang);
                            System.out.println("\nCalculado calidad global...\n");
                            int cfg = calcular_cg(mang, af, calidad_global);
                            System.out.println("Calidad Global: " + cfg);
                            if (cfg >= 3)
                                certificable = true;
                            if (certificable) {
                                System.out.println("\nSe puede certificar el Producto Software\n");

                            } else {
                                System.out.println(
                                        "\nMe temo que el producto no cumple con los requerimientos para ser certificado...\n");
                            }
                            System.out.println("\nSaliendo");

            } catch (InputMismatchException e) {
                System.out.println("\nIntroduzca Unicamente números\n");
                a=false;
                tc.next();
            }

        return a;


    }

    public static int adecuacion_menu() {

        System.out.println("Inserte la completitud funcional");
        completitud = 10;
        System.out.println("Inserte la corrección funcional");
        correcion = 34;
        System.out.println("Inserte la pertinencia funcional");
        pertinencia = 85;

        af = calcular_af(completitud, correcion, pertinencia, adecuacion_funcional);
        System.out.println("La adecuacion es de: "+af);

        return af;

    }

    public static int mantenibilidad_menu() {
        System.out.println("Inserte la modularidad");
        modulo = 66;
        System.out.println("Inserte la reusabilidad");
        reusable = 9;
        System.out.println("Inserte la analizabilidad");
        analiza = 54;
        System.out.println("Inserte la capacidad para de ser modificado");
        cm = 90;
        System.out.println("Inserte la capacidad para de ser probado");
        cp = 23;

        min = mantenibilidad(modulo, reusable, analiza, cm, cp, mantenibilidad);
        System.out.println("La manteabilidad es de: "+min);

        return min;

    }

    public static int insertarNumero() {
        int n = tc.nextInt();
        if (n < 0 || n > 100) {
            while (n < 0 || n > 100) {
                System.out.println("Error, inserte de nuevo");
                n = tc.nextInt();
            }
        }
        return n;
    }

    public static int calcular_af(int completitud, int correcion, int pertinencia, int adecuacion_funcional[][]) {
        int valor_completitud = adecuacion_funcional[rango_mediciones(completitud)][0];
        int valor_correccion = adecuacion_funcional[rango_mediciones(correcion)][1];
        int valor_pertinencia = adecuacion_funcional[rango_mediciones(pertinencia)][2];
        int[] array_af = { valor_completitud, valor_correccion, valor_pertinencia };
        return min(array_af);
    }

    public static int min(int[] nums) {
        int min = 0;
        if (nums != null) {
            min = nums[0];
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < min) {
                min = nums[i];
            }
        }
        return min;
    }

    public static int rango_mediciones(int rango) {
        rang=rango;
        int fila = 0;
        System.out.println("Valor de rang: "+Ejercicio_3.rang);
        if (rang >= 0 && rang < 10) {
            fila = 0;
        }
        if (rang >= 10 && rang < 35) {
            fila = 1;
        }
        if (rang >= 35 && rang < 50) {
            fila = 2;
        }
        if (rang >= 50 && rang < 70) {
            fila = 3;
        }
        if (rang >= 70 && rang < 90) {
            fila = 4;
        }
        if (rang >= 90 && rang <= 100) {
            fila = 5;
        }
        if (rang < 0 || rang > 100) {
            fila = -1;
        }
        ;

        return fila;
    }

    public static int mantenibilidad(int modularidad, int reusabilidad, int analizabilidad,
                                     int capacidad_de_ser_modificado, int capacidad_de_ser_probado, int manteabilidad[][]) {
        int mini = 0;
        int vector_manteabilidad[] = new int[5];
        for (int i = 0; i < manteabilidad.length; i++) {

            if (i == 0) {
                int r = rango_mediciones(modularidad);
                vector_manteabilidad[i] = manteabilidad[r][0];
            } else if (i == 1) {
                int r = rango_mediciones(reusabilidad);
                vector_manteabilidad[i] = manteabilidad[r][1];
            } else if (i == 2) {
                int r = rango_mediciones(analizabilidad);
                vector_manteabilidad[i] = manteabilidad[r][2];
            } else if (i == 3) {
                int r = rango_mediciones(capacidad_de_ser_modificado);
                vector_manteabilidad[i] = manteabilidad[r][3];
            } else if (i == 4) {
                int r = rango_mediciones(capacidad_de_ser_probado);
                vector_manteabilidad[i] = manteabilidad[r][4];
            }

        }
        mini = min(vector_manteabilidad);
        return mini;
    }

    public static int calcular_cg(int mantenibilidad, int adecuacion_funcional, int[][] calidad_global) {
        return calidad_global[adecuacion_funcional][mantenibilidad];
    }

}
