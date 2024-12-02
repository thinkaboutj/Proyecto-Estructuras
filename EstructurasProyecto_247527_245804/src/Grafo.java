

import java.util.ArrayList;
import java.util.List;

/**
 *Esta es la clase donde se hace el grafo y eso 
 * @author Jesus Medina ID:00000247527 y Diana Bastidad ID:00000245804
 */
public class Grafo {

    List<List<Vertices>> vertex = new ArrayList<>();
    static String[] locates = new String[25];
    static List<Aristas> edges = new ArrayList<>();
    int x = 0;

    public static String[] getLocates() {
        return locates;
    }

    public static List<Aristas> getEdges() {
        return edges;
    }

    public Grafo(List<Aristas> Edge) {
        locates[0] = "Guadalajara";
        locates[1] = "Zapopan";
        locates[2] = "Tlaquepaque";
        locates[3] = "Tonala";
        locates[4] = "Tlajomulco de Zuniga";
        locates[5] = "El Salto";
        locates[6] = "Ixtlahuacan de los Membrillos";
        locates[7] = "Tequila";
        locates[8] = "Amatitan";
        locates[9] = "Tala";
        locates[10] = "El Arenal";
        locates[11] = "Juanacatlan";
        locates[12] = "Etzatlan";
        locates[13] = "Mascota";
        locates[14] = "Mixtlan";
        locates[15] = "Tomatlan";
        locates[16] = "Cihuatlan";
        locates[17] = "La Huerta";
        locates[18] = "Autlan de Navarro";
        locates[19] = "Tamazula de Gordiano";
        locates[20] = "Sayula";
        locates[21] = "Zapotlan el Grande";
        locates[22] = "Guachinango";
        locates[23] = "San Martin Hidalgo";
        locates[24] = "Tapalpa";
        
        for (Aristas e : Edge) {
            x = Integer.max(x, Integer.max(e.origen, e.destino));
        }

        for (int i = 0; i <= x; i++) {
            vertex.add(i, new ArrayList<>());
        }

        for (Aristas e : Edge) {
            vertex.get(e.origen).add(new Vertices(e.destino, e.kilometros));
            vertex.get(e.destino).add(new Vertices(e.origen, e.kilometros));
        }
    }

    public static void print(Grafo grafo) {
        int origen = 0;
        int tam = grafo.vertex.size();
        System.out.printf("Localidad                      | Localidad adyacente            | Kilometros \n");
        System.out.println("-------------------------------|--------------------------------|-----------");
        while (origen < tam) {
            for (Vertices arista : grafo.vertex.get(origen)) {
                System.out.printf("%-30s | %-30s | %-11s\n", locates[origen], locates[arista.valor], arista.kilometros);
            }
            origen++;
        }
    }

    public void generateEdge() {
        int origen = 0;
        int tam = this.vertex.size();
        while (origen < tam) {
            for (Vertices arista : this.vertex.get(origen)) {
                edges.add(new Aristas(origen, arista.valor, arista.kilometros));
            }
            origen++;
        }
    }

    public int findLocation(String localidad) {
        for (int i = 0; i < locates.length; i++) {
            if (locates[i].equalsIgnoreCase(localidad)) {
                return i;
            }
        }
        return -1;
    }
}
