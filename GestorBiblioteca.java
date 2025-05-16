import java.time.LocalDate;
import java.util.*;

public class GestorBiblioteca {
    private List<Prestec> prestecs;
    private Map<String, Integer> comptadorPrestecs;
    private Map<String, Integer> prestecsPerCategoria;

    public GestorBiblioteca() {
        this.prestecs = new ArrayList<>();
        this.comptadorPrestecs = new HashMap<>();
        this.prestecsPerCategoria = new HashMap<>();
    }

    public void prestarLlibre(Usuari usuari, Llibre llibre) {
        if (!llibre.esPrestat()) {
            llibre.prestar();
            Prestec prestec = new Prestec(usuari, llibre, LocalDate.now());
            prestecs.add(prestec);
            usuari.afegirLlibre(llibre);

            // Comptador per títol
            String titol = llibre.getTitol();
            comptadorPrestecs.put(titol, comptadorPrestecs.getOrDefault(titol, 0) + 1);

            // Comptador per categoria
            String categoria = llibre.getCategoria();
            prestecsPerCategoria.put(categoria, prestecsPerCategoria.getOrDefault(categoria, 0) + 1);

            System.out.println(usuari.getNom() + " ha agafat el llibre: " + titol);
        } else {
            System.out.println("Aquest llibre ja està prestat.");
        }
    }

    public void mostrarEstadistiques() {
        System.out.println("----- Estadístiques de préstecs -----");
      
        System.out.println("\nLlibres més prestats:");
        comptadorPrestecs.entrySet().stream()
            .sorted((a, b) -> b.getValue() - a.getValue())
            .forEach(entry ->
                System.out.println(entry.getKey() + " - " + entry.getValue() + " préstecs")
            );

        System.out.println("\nCategories més prestades:");
        prestecsPerCategoria.forEach((categoria, comptador) ->
            System.out.println(categoria + ": " + comptador + " préstecs")
        );
    }
}
