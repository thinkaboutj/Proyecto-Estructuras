

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *Esta es la clase que nos hace el arbol de esparcimiento minimo
 * @author Jesus Medina ID:00000247527 y Diana Bastidad ID:00000245804
 */
public class ArbolEparcimientoMinimo {

    Map<Integer, Integer> mapa = new HashMap<>();

    public void makeSet(int n) {
        for (int i = 0; i < n; i++) {
            mapa.put(i, i);
        }
    }

    private int find(int k) {
        if (mapa.get(k) == k) {
            return k;
        }
        return find(mapa.get(k));
    }

    private void union(int a, int b) {
        int x = find(a);
        int y = find(b);
        mapa.put(x, y);
    }

    public static List<Aristas> Kruskal(List<Aristas> aristas, int num) {
        List<Aristas> minimos = new ArrayList<>();
        ArbolEparcimientoMinimo arboles = new ArbolEparcimientoMinimo();
        arboles.makeSet(num);
        int index = 0;
        Collections.sort(aristas, Comparator.comparingDouble(e -> e.kilometros));
        while (minimos.size() != num - 1 && index < aristas.size()) { // Agregar condición index < aristas.size()
            Aristas siguienteArista = aristas.get(index++);
            int x = arboles.find(siguienteArista.origen);
            int y = arboles.find(siguienteArista.destino);
            if (x != y) {
                minimos.add(siguienteArista);
                arboles.union(x, y);
            }
        }
        return minimos;
    }

    public static void print(List<Aristas> e) {
        String localidades[] = Grafo.getLocates();
        System.out.printf("Localidad                      | Localidad adyacente            | Kilometros \n");
        System.out.println("-------------------------------|--------------------------------|-----------");
        for (int i = 0; i < Math.min(e.size(), 25); i++) {
            System.out.printf("%-30s | %-30s | %-11s\n", localidades[e.get(i).origen], localidades[e.get(i).destino], e.get(i).kilometros);
        }
    }
}
