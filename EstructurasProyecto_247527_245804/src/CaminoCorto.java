/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *Esta es la clase que nos calcula el Camino Corto
 * @author Jesus Medina ID:00000247527 y Diana Bastidad ID:00000245804
 */
public class CaminoCorto {

    static String locates[] = Grafo.getLocates();

    static void getCamino(int ruta[], int valor, List<String> camino) {
        if (valor < 0) {
            return;
        }
        getCamino(ruta, ruta[valor], camino);
        camino.add(locates[valor]);
    }

    public static void shortRoute(List<Aristas> aristas, int numLocalidades, int origen, int destino) {
        double distancia[] = new double[numLocalidades];
        int ruta[] = new int[numLocalidades];
        Arrays.fill(distancia, Integer.MAX_VALUE);
        distancia[origen] = 0;
        Arrays.fill(ruta, -1);
        for (int i = 0; i < numLocalidades - 1; i++) {
            for (Aristas arista : aristas) {
                int aristaOrigen = arista.origen;
                int aristaDestino = arista.destino;
                double kilometros = arista.kilometros;
                if (distancia[aristaOrigen] != Integer.MAX_VALUE && distancia[aristaOrigen] + kilometros < distancia[aristaDestino]) {
                    distancia[aristaDestino] = distancia[aristaOrigen] + kilometros;
                    ruta[aristaDestino] = aristaOrigen;
                }
            }
        }

        for (Aristas edge : aristas) {
            int u = edge.origen;
            int v = edge.destino;
            double w = edge.kilometros;

            if (distancia[u] != Integer.MAX_VALUE && distancia[u] + w < distancia[v]) {
                System.out.println("Negativo");
                return;
            }
        }

        for (int i = 0; i < numLocalidades; i++) {
            if (i != origen && distancia[i] < Integer.MAX_VALUE) {
                if (i == destino) {
                    List<String> camino = new ArrayList<>();
                    getCamino(ruta, i, camino);
                    System.out.println("------------------------------------------------------------------------------------");
                    System.out.printf("La distancia de la localidad %s a la localidad %s es de %.1f km\nSu camino es %s\n", locates[origen], locates[i], distancia[i], camino);
                    System.out.println("------------------------------------------------------------------------------------");
                }
            }
        }
    }
}
