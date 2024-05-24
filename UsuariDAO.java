import java.sql.*;

public class UsuariDAO {
    public void insartaUsuari(Usuari Usuari) {
        String sql = "INSERT INTO Usuaris (Nom, Cognoms, Email, Rol, Data_Registre) VALUES (?, ?, ?, ?, ?)";

        try (Connection conn = Conexio_Basedades.getConexio();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, Usuari.getNom());
            stmt.setString(2, Usuari.getCognom());
            stmt.setString(3, Usuari.getEmail());
            stmt.setString(4, Usuari.getRol());
            stmt.setDate(5, new java.sql.Date(Usuari.getDateRegistre().getTime()));

            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Usuari obtenerUsuariPorID(int id) {
        String sql = "SELECT * FROM Usuaris WHERE ID_Usuari = ?";
        Usuari Usuari = null;

        try (Connection conn = Conexio_Basedades.getConexio();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    Usuari = new Usuari(
                        rs.getInt("ID_Usuari"),
                        rs.getString("Nom"),
                        rs.getString("Cognoms"),
                        rs.getString("Email"),
                        rs.getString("Rol"),
                        rs.getDate("Data_Registre")
                    );
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return Usuari;
    }

    public void actualizarUsuari(Usuari Usuari) {
        String sql = "UPDATE Usuaris SET Nom = ?, Cognoms = ?, Email = ?, Rol = ?, Data_Registre = ? WHERE ID_Usuari = ?";

        try (Connection conn = Conexio_Basedades.getConexio();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, Usuari.getNom());
            stmt.setString(2, Usuari.getCognom());
            stmt.setString(3, Usuari.getEmail());
            stmt.setString(4, Usuari.getRol());
            stmt.setDate(5, new java.sql.Date(Usuari.getDateRegistre().getTime()));
            stmt.setInt(6, Usuari.getID_Usuari());

            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void elimiarUsuari(int id) {
        String sql = "DELETE FROM Usuaris WHERE ID_Usuari = ?";

        try (Connection conn = Conexio_Basedades.getConexio();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
