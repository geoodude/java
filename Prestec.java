import java.util.Date;

public class Prestec {
    private int ID_Prestec;
    private int ID_Llibre;
    private int ID_Usuari;
    private Date Data_Prestec;
    private Date Data_Retorn_Prevista;
    private Date Data_Retorn_Real;
    private String Estat;

    public Prestec(int ID_Llibre, int ID_Usuari, Date Data_Prestec, Date Data_Retorn_Prevista, Date Data_Retorn_Real, String Estat) {
        this.ID_Llibre = ID_Llibre;
        this.ID_Usuari = ID_Usuari;
        this.Data_Prestec = Data_Prestec;
        this.Data_Retorn_Prevista = Data_Retorn_Prevista;
        this.Data_Retorn_Real = Data_Retorn_Real;
        this.Estat = Estat;
    }

    public int getID_Prestec() {
        return ID_Prestec;
    }

    public void setID_Prestec(int ID_Prestec) {
        this.ID_Prestec = ID_Prestec;
    }

    public int getID_Llibre() {
        return ID_Llibre;
    }

    public void setID_Llibre(int ID_Llibre) {
        this.ID_Llibre = ID_Llibre;
    }

    public int getID_Usuari() {
        return ID_Usuari;
    }

    public void setID_Usuari(int ID_Usuari) {
        this.ID_Usuari = ID_Usuari;
    }

    public Date getData_Prestec() {
        return Data_Prestec;
    }

    public void setData_Prestec(Date Data_Prestec) {
        this.Data_Prestec = Data_Prestec;
    }

    public Date getData_Retorn_Prevista() {
        return Data_Retorn_Prevista;
    }

    public void setData_Retorn_Prevista(Date Data_Retorn_Prevista) {
        this.Data_Retorn_Prevista = Data_Retorn_Prevista;
    }

    public Date getData_Retorn_Real() {
        return Data_Retorn_Real;
    }

    public void setData_Retorn_Real(Date Data_Retorn_Real) {
        this.Data_Retorn_Real = Data_Retorn_Real;
    }

    public String getEstat() {
        return Estat;
    }

    public void setEstat(String Estat) {
        this.Estat = Estat;
    }
}
