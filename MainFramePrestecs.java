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
    private JButton btnPrestec, btnDevolucio;

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

        btnPrestec = new JButton("Prestec");
        btnPrestec.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                prestar();
            }
        });
        panel.add(btnPrestec);

        btnDevolucio = new JButton("Devolucio");
        btnDevolucio.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                retornar();
            }
        });
        panel.add(btnDevolucio);

        add(panel);
    }

    private void prestar() {
        int idLlibre = Integer.parseInt(txtIDLlibre.getText());
        int idUsuari = Integer.parseInt(txtIDUsuari.getText());
        Date dataPrestec = parseDate(txtDataPrestec.getText());
        Date dataRetornPrevista = parseDate(txtDataRetornPrevista.getText());
        Date dataRetornReal = null; 
        String estat = "actiu"; 

        Prestec prestec = new Prestec(idLlibre, idUsuari, dataPrestec, dataRetornPrevista, dataRetornReal, estat);
        prestecDAO.afegirPrestec(prestec);
        JOptionPane.showMessageDialog(this, "Préstec inserit correctament.");
        netejarCamps();
    }

    private void retornar() {
        int idPrestec = Integer.parseInt(txtID.getText());
        Prestec prestec = prestecDAO.obtenirPrestecPerId(idPrestec);
        if (prestec != null) {
            prestec.setData_Retorn_Real(new Date()); // Set the return date to current date
            prestec.setEstat("completat"); // Update status to completed
            prestecDAO.modificarPrestec(prestec);
            JOptionPane.showMessageDialog(this, "Préstec retornat correctament.");
        } else {
            JOptionPane.showMessageDialog(this, "No s'ha trobat cap préstec amb aquest ID.");
        }
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
