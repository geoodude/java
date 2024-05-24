import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MainFramePrestecs extends JFrame {
    private PrestecDAO prestecDAO;

    private JTextField txtID, txtIDLlibre, txtIDUsuari, txtDataPrestec, txtDataRetornPrevista, txtDataRetornReal, txtEstat;
    private JButton btnInsertar, btnActualitzar, btnEliminar;

    public MainFramePrestecs() {
        prestecDAO = new PrestecDAO();
        initUI();
    }

    private void initUI() {
        setTitle("Gestió de Préstecs");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel(new GridLayout(8, 2));

        panel.add(new JLabel("ID:"));
        txtID = new JTextField();
        panel.add(txtID);

        panel.add(new JLabel("ID Llibre:"));
        txtIDLlibre = new JTextField();
        panel.add(txtIDLlibre);

        panel.add(new JLabel("ID Usuari:"));
        txtIDUsuari = new JTextField();
        panel.add(txtIDUsuari);

        panel.add(new JLabel("Data Préstec (dd-MM-yyyy):"));
        txtDataPrestec = new JTextField();
        panel.add(txtDataPrestec);

        panel.add(new JLabel("Data Retorn Prevista (dd-MM-yyyy):"));
        txtDataRetornPrevista = new JTextField();
        panel.add(txtDataRetornPrevista);

        panel.add(new JLabel("Data Retorn Real (dd-MM-yyyy):"));
        txtDataRetornReal = new JTextField();
        panel.add(txtDataRetornReal);

        panel.add(new JLabel("Estat:"));
        txtEstat = new JTextField();
        panel.add(txtEstat);

        btnInsertar = new JButton("Insertar");
        btnInsertar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                inserirPrestec();
            }
        });
        panel.add(btnInsertar);

        btnActualitzar = new JButton("Actualitzar");
        btnActualitzar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                actualitzarPrestec();
            }
        });
        panel.add(btnActualitzar);

        btnEliminar = new JButton("Eliminar");
        btnEliminar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                eliminarPrestec();
            }
        });
        panel.add(btnEliminar);

        add(panel);
    }

    private void inserirPrestec() {
        int idLlibre = Integer.parseInt(txtIDLlibre.getText());
        int idUsuari = Integer.parseInt(txtIDUsuari.getText());
        Date dataPrestec = parseDate(txtDataPrestec.getText());
        Date dataRetornPrevista = parseDate(txtDataRetornPrevista.getText());
        Date dataRetornReal = parseDate(txtDataRetornReal.getText());
        String estat = txtEstat.getText();

        Prestec prestec = new Prestec(idLlibre, idUsuari, dataPrestec, dataRetornPrevista, dataRetornReal, estat);
        prestecDAO.afegirPrestec(prestec);
        JOptionPane.showMessageDialog(this, "Préstec inserit correctament.");
        netejarCamps();
    }

    private void actualitzarPrestec() {
        int id = Integer.parseInt(txtID.getText());
        int idLlibre = Integer.parseInt(txtIDLlibre.getText());
        int idUsuari = Integer.parseInt(txtIDUsuari.getText());
        Date dataPrestec = parseDate(txtDataPrestec.getText());
        Date dataRetornPrevista = parseDate(txtDataRetornPrevista.getText());
        Date dataRetornReal = parseDate(txtDataRetornReal.getText());
        String estat = txtEstat.getText();

        Prestec prestec = new Prestec(idLlibre, idUsuari, dataPrestec, dataRetornPrevista, dataRetornReal, estat);
        prestec.setID_Prestec(id);
        prestecDAO.modificarPrestec(prestec);
        JOptionPane.showMessageDialog(this, "Préstec actualitzat correctament.");
        netejarCamps();
    }

    private void eliminarPrestec() {
        int id = Integer.parseInt(txtID.getText());
        prestecDAO.eliminarPrestec(id);
        JOptionPane.showMessageDialog(this, "Préstec eliminat correctament.");
        netejarCamps();
    }

    private Date parseDate(String dateString) {
        try {
            return new SimpleDateFormat("dd-MM-yyyy").parse(dateString);
        } catch (ParseException e) {
            JOptionPane.showMessageDialog(this, "Format de data incorrecte. Utilitza el format dd-MM-yyyy.");
            return null;
        }
    }

    private void netejarCamps() {
        txtID.setText("");
        txtIDLlibre.setText("");
        txtIDUsuari.setText("");
        txtDataPrestec.setText("");
        txtDataRetornPrevista.setText("");
        txtDataRetornReal.setText("");
        txtEstat.setText("");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                MainFramePrestecs frame = new MainFramePrestecs();
                frame.setVisible(true);
            }
        });
    }
}

