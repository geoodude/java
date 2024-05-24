import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class LlibreDAO {
    public void afegirLlibre(Llibre llibre) {
        String sql = "INSERT INTO llibres (Títol, Autor, ISBN, Editorial, Any_Publicació, Categoria, Estat) VALUES (?, ?, ?, ?, ?, ?, ?)";

        try (Connection conn = Conexio_Basedades.getConexio();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, llibre.getTitol());
            stmt.setString(2, llibre.getAutor());
            stmt.setString(3, llibre.getIsbn());
            stmt.setString(4, llibre.getEditorial());
            java.sql.Date dataPublicacio = new java.sql.Date(llibre.getDataPublicacio().getTime());
            stmt.setDate(5, dataPublicacio);
            stmt.setString(6, llibre.getCategoria());
            stmt.setString(7, llibre.getEstat());

            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void modificarLlibre(Llibre llibre) {
        String sql = "UPDATE llibres SET Títol = ?, Autor = ?, ISBN = ?, Editorial = ?, Any_Publicació = ?, Categoria = ?, Estat = ? WHERE ID_Llibre = ?";

        try (Connection conn = Conexio_Basedades.getConexio();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, llibre.getTitol());
            stmt.setString(2, llibre.getAutor());
            stmt.setString(3, llibre.getIsbn());
            stmt.setString(4, llibre.getEditorial());
            java.sql.Date dataPublicacio = new java.sql.Date(llibre.getDataPublicacio().getTime());
            stmt.setDate(5, dataPublicacio);
            stmt.setString(6, llibre.getCategoria());
            stmt.setString(7, llibre.getEstat());
            stmt.setInt(8, llibre.getIdLlibre());

            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void eliminarLlibre(int idLlibre) {
        String sql = "DELETE FROM llibres WHERE ID_Llibre = ?";

        try (Connection conn = Conexio_Basedades.getConexio();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, idLlibre);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
