import java.util.Date;

public class Usuari {
    private int ID_Usuari;
    private String Nom;
    private String Cognom;
    private String Email;
    private String Rol;
    private Date DateRegistre;

    public Usuari(int ID_Usuari, String Nom, String Cognom, String Email, String Rol, Date DateRegistre) {
        this.ID_Usuari = ID_Usuari;
        this.Nom = Nom;
        this.Cognom = Cognom;
        this.Email = Email;
        this.Rol = Rol;
        this.DateRegistre = DateRegistre;
    }

    public int getID_Usuari() {
        return ID_Usuari;
    }

    public String getNom() {
        return Nom;
    }

    public String getCognom() {
        return Cognom;
    }

    public String getEmail() {
        return Email;
    }

    public String getRol() {
        return Rol;
    }

    public Date getDateRegistre() {
        return DateRegistre;
    }

    public void setID_Usuari(int ID_Usuari) {
        this.ID_Usuari = ID_Usuari;
    }

    public void setNom(String Nom) {
        this.Nom = Nom;
    }

    public void setCognom(String Cognom) {
        this.Cognom = Cognom;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public void setRol(String Rol) {
        this.Rol = Rol;
    }

    public void setDateRegistre(Date DateRegistre) {
        this.DateRegistre = DateRegistre;
    }
}
