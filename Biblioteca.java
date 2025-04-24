import java.util.ArrayList;
import java.util.List;

public class Biblioteca {
    private List<Llibre> llibres;
    private List<Usuari> usuaris;

    public Biblioteca() {
        this.llibres = new ArrayList<>();
    }

    public void afegirLlibre(Llibre llibre) {
        llibres.add(llibre);
    }

    public Llibre buscarLlibre(String titol) {
        for (Llibre llibre : llibres) {
            if (llibre.getTitol().equalsIgnoreCase(titol)) {
                return llibre;
            }
        }
        return null;
    }

    public void registrarUsuari(Usuari usuari){
        this.usuaris.add(usuari);
    }

    public Usuari usuariMesActiu(){
        int maxim = Integer.MIN_VALUE;
        Usuari usuariMaxim;
        for(int i = 0; i < usuaris.size(); i++){
            if(usuaris.get(i).getHistorial().size() > maxim){
                maxim = usuaris.get(i).historialPrestecs.length();
                usuariMaxim = usuaris.get(i);
            }
        }
        return usuariMaxim;
    }

    public List<Llibre> getLlibres() {
        return llibres;
    }
}
