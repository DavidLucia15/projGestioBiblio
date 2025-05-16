public class Llibre implements Comparable<Llibre>{
    private String titol;
    private String autor;
    private boolean prestat;
    private String categoria;

    public Llibre(String titol, String autor, String categoria) {
    this.titol = titol;
    this.autor = autor;
    this.prestat = false;
    this.categoria = categoria;
    }

    public String getTitol() { return titol; }
    public String getAutor() { return autor; }
    public boolean esPrestat() { return prestat; }
    public String getCategoria() {return this.categoria;}
    // Comprovar disponibilitat
    public void comprovarDisp(){
        if(!this.prestat){
            System.out.println("El llibre és disponible");
        }
        else{
            System.out.println("El llibre NO és disponible");
        }
    }

    public void prestar() { prestat = true; }
    public void retornar() { prestat = false; }

    @Override
    public String toString() {
        return titol + " de " + autor + (prestat ? " (En préstec)" : " (Disponible)") + "\nCategoria: " + this.categoria;
    }

    @Override
    public int compareTo(Llibre llibre2) {
        return this.categoria.compareToIgnoreCase(llibre2.categoria);
    }
}