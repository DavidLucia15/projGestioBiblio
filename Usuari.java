import java.util.ArrayList;
import java.util.List;

public class Usuari {
private String nom;
private List<Llibre> llibresPrestats;
private List<Llibre> historialPrestecs;

public Usuari(String nom) {
this.nom = nom;
this.llibresPrestats = new ArrayList<>();
}

public String getNom() { return nom; }
public List<Llibre> getLlibresPrestats() { return llibresPrestats; }
public List<Llibre> getHistorial(){
    return this.historialPrestecs;
}
public void afegirLlibre(Llibre llibre) { 
    llibresPrestats.add(llibre); 
    historialPrestecs.add(llibre);
}
public void consultarHistorial(){System.out.println(this.historialPrestecs);}
public void retornarLlibre(Llibre llibre) { llibresPrestats.remove(llibre); } 
}