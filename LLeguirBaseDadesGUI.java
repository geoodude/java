import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.sql.*;

public class LLeguirBaseDadesGUI {

    private static final String URL = "jdbc:mysql://localhost:3306/llibreria";
    private static final String USER = "biblotecari";
    private static final String PASSWORD = "password";

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Llibres Database Reader");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(800, 600);

            String[] columnNames = {"ID_Llibre", "Títol", "Autor", "ISBN", "Editorial", "Any_Publicació", "Categoria", "Estat"};
            DefaultTableModel tableModel = new DefaultTableModel(columnNames, 0);
            JTable table = new JTable(tableModel);

            try {
                Connection conexio = DriverManager.getConnection(URL, USER, PASSWORD);
                Statement statement = conexio.createStatement();
                String queryLlibres = "SELECT * FROM llibres";
                ResultSet resultSet = statement.executeQuery(queryLlibres);

                while (resultSet.next()) {
                    int idLlibre = resultSet.getInt("ID_Llibre");
                    String titol = resultSet.getString("Títol");
                    String autor = resultSet.getString("Autor");
                    String isbn = resultSet.getString("ISBN");
                    String editorial = resultSet.getString("Editorial");
                    int anyPublicacio = resultSet.getInt("Any_Publicació");
                    String categoria = resultSet.getString("Categoria");
                    String estat = resultSet.getString("Estat");

                    Object[] row = {idLlibre, titol, autor, isbn, editorial, anyPublicacio, categoria, estat};
                    tableModel.addRow(row);
                }

                resultSet.close();
                statement.close();
                conexio.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }

            JScrollPane scrollPane = new JScrollPane(table);
            frame.add(scrollPane, BorderLayout.CENTER);

            frame.setVisible(true);
        });

        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Usuaris Database Reader");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(800, 600);

            String[] columnNames = {"ID_Usuari", "Nom", "Cognom", "Email", "Telèfon", "Rol", "Data_register"};
            DefaultTableModel tableModel = new DefaultTableModel(columnNames, 0);
            JTable table = new JTable(tableModel);

            try {
                Connection conexio = DriverManager.getConnection(URL, USER, PASSWORD);
                Statement statement = conexio.createStatement();
                String queryUsuaris = "SELECT * FROM usuari";
                ResultSet resultSet = statement.executeQuery(queryUsuaris);

                while (resultSet.next()) {
                    int idUsuari = resultSet.getInt("ID_Usuari");
                    String nom = resultSet.getString("Nom");
                    String cognom = resultSet.getString("Cognom");
                    String email = resultSet.getString("Email");
                    String telefon = resultSet.getString("Telèfon");
                    String rol = resultSet.getString("Rol");
                    Date dataRegister = resultSet.getDate("Data_register");

                    Object[] row = {idUsuari, nom, cognom, email, telefon, rol, dataRegister};
                    tableModel.addRow(row);
                }

                resultSet.close();
                statement.close();
                conexio.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }

            JScrollPane scrollPane = new JScrollPane(table);
            frame.add(scrollPane, BorderLayout.CENTER);

            frame.setVisible(true);
        });

        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Prestecs Database Reader");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(800, 600);

            String[] columnNames = {"ID_Prestec", "ID_Llibre", "ID_Usuari", "Data_Préstec", "Data_Retorn_Prevista", "Data_Retorn_Real", "Estat"};
            DefaultTableModel tableModel = new DefaultTableModel(columnNames, 0);
            JTable table = new JTable(tableModel);

            try {
                Connection conexio = DriverManager.getConnection(URL, USER, PASSWORD);
                Statement statement = conexio.createStatement();
                String queryPrestecs = "SELECT * FROM prestecs";
                ResultSet resultSet = statement.executeQuery(queryPrestecs);

                while (resultSet.next()) {
                    int idPrestec = resultSet.getInt("ID_Prestec");
                    int idLlibre = resultSet.getInt("ID_Llibre");
                    int idUsuari = resultSet.getInt("ID_Usuari");
                    Date dataPrestec = resultSet.getDate("Data_Préstec");
                    Date dataRetornPrevista = resultSet.getDate("Data_Retorn_Prevista");
                    Date dataRetornReal = resultSet.getDate("Data_Retorn_Real");
                    String estat = resultSet.getString("Estat");

                    Object[] row = {idPrestec, idLlibre, idUsuari, dataPrestec, dataRetornPrevista, dataRetornReal, estat};
                    tableModel.addRow(row);
                }

                resultSet.close();
                statement.close();
                conexio.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }

            JScrollPane scrollPane = new JScrollPane(table);
            frame.add(scrollPane, BorderLayout.CENTER);

            frame.setVisible(true);
        });
    }

}
