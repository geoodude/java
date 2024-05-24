import java.sql.*;
import java.util.Date;

public class PrestecDAO {
    public void afegirPrestec(Prestec prestec) {
        String sql = "INSERT INTO prestecs (ID_Llibre, ID_Usuari, Data_Préstec, Data_Retorn_Prevista, Data_Retorn_Real, Estat) VALUES (?, ?, ?, ?, ?, ?)";

        try (Connection conn = Conexio_Basedades.getConexio();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, prestec.getID_Llibre());
            stmt.setInt(2, prestec.getID_Usuari());
            stmt.setDate(3, new java.sql.Date(prestec.getData_Prestec().getTime()));
            stmt.setDate(4, new java.sql.Date(prestec.getData_Retorn_Prevista().getTime()));
            if (prestec.getData_Retorn_Real() != null) {
                stmt.setDate(5, new java.sql.Date(prestec.getData_Retorn_Real().getTime()));
            } else {
                stmt.setNull(5, Types.NULL);
            }
            stmt.setString(6, prestec.getEstat());

            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void modificarPrestec(Prestec prestec) {
        String sql = "UPDATE prestecs SET ID_Llibre = ?, ID_Usuari = ?, Data_Préstec = ?, Data_Retorn_Prevista = ?, Data_Retorn_Real = ?, Estat = ? WHERE ID_Préstec = ?";

        try (Connection conn = Conexio_Basedades.getConexio();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, prestec.getID_Llibre());
            stmt.setInt(2, prestec.getID_Usuari());
            stmt.setDate(3, new java.sql.Date(prestec.getData_Prestec().getTime()));
            stmt.setDate(4, new java.sql.Date(prestec.getData_Retorn_Prevista().getTime()));
            if (prestec.getData_Retorn_Real() != null) {
                stmt.setDate(5, new java.sql.Date(prestec.getData_Retorn_Real().getTime()));
            } else {
                stmt.setNull(5, Types.NULL);
            }
            stmt.setString(6, prestec.getEstat());
            stmt.setInt(7, prestec.getID_Prestec());

            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void eliminarPrestec(int idPrestec) {
        String sql = "DELETE FROM prestecs WHERE ID_Préstec = ?";

        try (Connection conn = Conexio_Basedades.getConexio();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, idPrestec);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

