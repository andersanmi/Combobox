package ehu.isad;

public class Argazki {
    private String izena;
    private String fitx;

    public Argazki(String izena, String fitx) {
        this.izena = izena;
        this.fitx = fitx;
    }

    public String getIzena() {
        return this.izena;
    }

    public String getFitx() {
        return this.fitx;
    }

    @Override
    public String toString() {
        return String.format(this.izena);
    }
}
