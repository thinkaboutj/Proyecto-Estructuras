/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */


import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 *Esta es la clase donde problamos lo de los grafos
 * 
 * NOTA: no tiene imagen del grafo porque en las indicaciones dice GRAFICA O TABLA y decidimos 
 * @author Jesus Medina ID:00000247527 y Diana Bastidad ID:00000245804
 */
public class pruebas {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner tec = new Scanner(System.in);
        
        List<Aristas> edge = Arrays.asList(
                // Guadalajara
                new Aristas(0, 1, 7.9),
                new Aristas(0, 2, 10.5),
                new Aristas(0, 3, 12.8),
                new Aristas(0, 4, 4.6),
                new Aristas(0, 5, 8.1),
                // Zapopan
                new Aristas(1, 0, 7.9),
                new Aristas(1, 2, 5.2),
                new Aristas(1, 4, 8.7),
                // Tlaquepaque
                new Aristas(2, 0, 10.5),
                new Aristas(2, 1, 5.2),
                new Aristas(2, 3, 7.6),
                new Aristas(2, 4, 12.3),
                // Tonala
                new Aristas(3, 0, 12.8),
                new Aristas(3, 2, 7.6),
                new Aristas(3, 5, 11.4),
                // Tlajomulco de Zuniga
                new Aristas(4, 0, 4.6),
                new Aristas(4, 1, 8.7),
                new Aristas(4, 2, 12.3),
                // El Salto
                new Aristas(5, 0, 8.1),
                new Aristas(5, 3, 11.4),
                // Puerto Vallarta
                new Aristas(6, 7, 5.8),
                new Aristas(6, 8, 84),
                // Tepatitlan de Morelos
                new Aristas(7, 6, 5.8),
                new Aristas(7, 8, 62),
                new Aristas(7, 9, 53),
                // Ciudad Guzman
                new Aristas(8, 6, 84),
                new Aristas(8, 7, 62),
                new Aristas(8, 9, 66),
                new Aristas(8, 10, 51),
                // Lagos de Moreno
                new Aristas(9, 7, 53),
                new Aristas(9, 8, 66),
                new Aristas(9, 10, 36),
                // Ocotlan
                new Aristas(10, 8, 51),
                new Aristas(10, 9, 36),
                new Aristas(10, 11, 12),
                // La Barca
                new Aristas(11, 10, 12),
                new Aristas(11, 12, 9.4),
                // Sayula
                new Aristas(12, 11, 9.4),
                new Aristas(12, 13, 22),
                // Autlan de Navarro
                new Aristas(13, 12, 22),
                new Aristas(13, 14, 30),
                // Chapala
                new Aristas(14, 13, 30),
                new Aristas(14, 15, 19),
                // Arandas
                new Aristas(15, 14, 19),
                new Aristas(15, 16, 20),
                // Tequila
                new Aristas(16, 15, 20),
                new Aristas(16, 17, 26),
                // Ameca
                new Aristas(17, 16, 26),
                new Aristas(17, 18, 25),
                // Atotonilco el Alto
                new Aristas(18, 17, 25),
                new Aristas(18, 19, 17),
                // Zapotlanejo
                new Aristas(19, 18, 17),
                new Aristas(19, 20, 15),
                // Tamazula de Gordiano
                new Aristas(20, 19, 15),
                new Aristas(20, 21, 12),
                // Tala
                new Aristas(21, 20, 12),
                new Aristas(21, 22, 22),
                // Tototlan
                new Aristas(22, 21, 22),
                new Aristas(22, 23, 14),
                // Degollado
                new Aristas(23, 22, 14),
                new Aristas(23, 24, 27),
                // Acatlan de Juarez
                new Aristas(24, 23, 27)
        );
        Grafo grafo = new Grafo(edge);
        grafo.generateEdge();
        int seleccion = 0;
        boolean flag = true;
        String localidad = "";
        String localidadAdy = "";

        while (seleccion != 4) {
            System.out.println(" ------------------------------------------------------");
            System.out.println("| 1. Grafo                                             |");
            System.out.println("| 2. Mostrar arbol de esparcimiento minimo             |");
            System.out.println("| 3. Ruta mas corta entre dos ciudades                 |");
            System.out.println("| 4. Salir                                             |");
            System.out.println(" ------------------------------------------------------");
            System.out.printf(" Opcion: ");
            seleccion = tec.nextInt();

            switch (seleccion) {
                case 1:
                    Grafo.print(grafo);

                    break;
                case 2:
                    System.out.println("");
                    List<Aristas> e = ArbolEparcimientoMinimo.Kruskal(edge, 25);
                    ArbolEparcimientoMinimo.print(e);
                    break;
                case 3:
                    tec.nextLine();
                    while (flag) {
                        System.out.print("Localidad origen: ");
                        localidad = tec.nextLine();
                        System.out.print("Localidad destino: ");
                        localidadAdy = tec.nextLine();
                        if (grafo.findLocation(localidad) < 0 || grafo.findLocation(localidadAdy) < 0) {
                            System.out.println("Error al introducir la localidad");
                        } else {
                            flag = false;
                        }
                    }
                    flag = true;
                    CaminoCorto.shortRoute(Grafo.getEdges(), Grafo.getLocates().length, grafo.findLocation(localidad), grafo.findLocation(localidadAdy));
                    break;
                case 4:
                    System.out.println("GRACIAS POR EL CURSO PROFE ^^");
                    break;
            }
        }
    }
}