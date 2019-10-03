package ehu.isad;

public class Argazki {
    private String izena;
    private String foto;

    public Argazki(String izena, String foto) {
        this.izena = izena;
        this.foto = foto;
    }

    public String getIzena() {
        return this.izena;
    }

    public String getFoto() {
        return this.foto;
    }

    @Override
    public String toString() {
        return String.format(this.izena);
    }
}
