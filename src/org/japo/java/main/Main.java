/*
 * Copyright 2020 Noelia Cremades Gómez - noelia.cremades.alum@iescamp.es.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.japo.java.main;

import java.util.Locale;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author Noelia Cremades Gómez - noelia.cremades.alum@iescamp.es
 */
public class Main {

    public static final Scanner SCN
            = new Scanner(System.in, "Windows-1252")
                    .useLocale(Locale.ENGLISH).useDelimiter("\\s+");

    public static final Random RND = new Random();

    public static void main(String[] args) {
        System.out.println("Parking Morvedre");
        System.out.println("----------------");
        int horaEntrada = 0;
        int minutoEntrada = 0;
        int tiempoEntrada;
        int tiempoSalida;
        int duracion;
        double tarifa = 0.15;
        
        // Scan de hora de entrada
        try {
            System.out.print("Hora de entrada ....: ");
            horaEntrada = SCN.nextInt();
        } catch (Exception e) {
            System.out.println("Entrada incorrecta, reinicie el proceso");
            System.out.println("---------------------------------------");
            System.exit(0); // Salida esperada por fallo.
        } finally {
            SCN.nextLine();
        }

        // Scan de minuto de entrada
        try {
            System.out.print("Minuto de entrada ..: ");
            minutoEntrada = SCN.nextInt();
        } catch (Exception e) {
            System.out.println("Entrada incorrecta, reinicie el proceso.");
            System.out.println("----------------------------------------");
            System.exit(0); // Salida esperada por fallo.
        } finally {
            SCN.nextLine();
        }
        
        // Separador cosmético
        System.out.println("---");

        // Random para hora de salida.
        tiempoEntrada = horaEntrada * 60 + minutoEntrada;

        tiempoSalida = RND.nextInt(1439 - tiempoEntrada + 1) + tiempoEntrada;
        duracion = tiempoSalida - tiempoEntrada;

        // Variables de Salida
        int horaSalida = tiempoSalida / 60;
        int minutoSalida = tiempoSalida % 60;
        double importe = tarifa * duracion;

        // Salida por consola
        System.out.printf("Momento entrada ....: %02d:%02dh - Manual%n",
                horaEntrada, minutoEntrada);
        System.out.printf("Momento salida .....: %02d:%02dh - Aleatorio%n",
                horaSalida, minutoSalida);

        // Separador cosmético
        System.out.println("---");

        // Salida por consola
        System.out.printf(Locale.ENGLISH, "Tarifa .............: %.2f €/min%n",
                tarifa);
        System.out.printf("Tiempo facturado ...: %d minutos (%02dh + %02dm)%n",
                duracion, horaSalida, minutoSalida);
        System.out.printf(Locale.ENGLISH, "Importe ............: %.2f €%n",
                importe);
    }
}
