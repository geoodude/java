import java.util.Date;

public class Llibre {
    private int idLlibre;
    private String titol;
    private String autor;
    private String isbn;
    private String editorial;
    private Date dataPublicacio;
    private String categoria;
    private String estat;

    public Llibre(int idLlibre, String titol, String autor, String isbn, String editorial, Date dataPublicacio, String categoria, String estat) {
        this.idLlibre = idLlibre;
        this.titol = titol;
        this.autor = autor;
        this.isbn = isbn;
        this.editorial = editorial;
        this.dataPublicacio = dataPublicacio;
        this.categoria = categoria;
        this.estat = estat;
    }

    public int getIdLlibre() {
        return idLlibre;
    }

    public void setIdLlibre(int idLlibre) {
        this.idLlibre = idLlibre;
    }

    public String getTitol() {
        return titol;
    }

    public void setTitol(String titol) {
        this.titol = titol;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getEditorial() {
        return editorial;
    }

    public void setEditorial(String editorial) {
        this.editorial = editorial;
    }

    public Date getDataPublicacio() {
        return dataPublicacio;
    }

    public void setDataPublicacio(Date dataPublicacio) {
        this.dataPublicacio = dataPublicacio;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getEstat() {
        return estat;
    }

    public void setEstat(String estat) {
        this.estat = estat;
    }
}
