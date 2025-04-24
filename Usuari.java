import java.util.ArrayList;
import java.util.List;

public class Usuari {
    private String nom;
    private List<Llibre> Historial;
    private List<Llibre> llibresPrestats;

    public Usuari(String nom) {
        this.nom = nom;
        this.Historial = new ArrayList<>(); // Inicialitzem el historial
        this.llibresPrestats = new ArrayList<>();
    }

    public String getNom() {
        return nom;
    }

    public void afegirHistorial(Llibre llibre) {
        Historial.add(llibre); 
    }

    public List<Llibre> getLlibresPrestats() {
        return llibresPrestats;
    }

    public void afegirLlibre(Llibre llibre) {
        afegirHistorial(llibre);
        llibresPrestats.add(llibre);
    }

    public void retornarLlibre(Llibre llibre) {
        llibresPrestats.remove(llibre);
        afegirHistorial(llibre); // Puedes aprovechar para moverlo al historial
    }

    public List<Llibre> getHistorial() {
        return Historial;
    }
}
