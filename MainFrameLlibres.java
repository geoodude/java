import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MainFrameLlibres extends JFrame {
    private LlibreDAO llibreDAO;

    private JTextField txtID, txtTitol, txtAutor, txtISBN, txtEditorial, txtAnyPublicacio, txtCategoria, txtEstat;
    private JButton btnInsertar, btnActualitzar, btnEliminar;

    public MainFrameLlibres() {
        llibreDAO = new LlibreDAO();
        initUI();
    }

    private void initUI() {
        setTitle("Gestió de Llibres");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel(new GridLayout(9, 2));

        panel.add(new JLabel("ID:"));
        txtID = new JTextField();
        panel.add(txtID);

        panel.add(new JLabel("Títol:"));
        txtTitol = new JTextField();
        panel.add(txtTitol);

        panel.add(new JLabel("Autor:"));
        txtAutor = new JTextField();
        panel.add(txtAutor);

        panel.add(new JLabel("ISBN:"));
        txtISBN = new JTextField();
        panel.add(txtISBN);

        panel.add(new JLabel("Editorial:"));
        txtEditorial = new JTextField();
        panel.add(txtEditorial);

        panel.add(new JLabel("Any Publicació (dd-MM-yyyy):"));
        txtAnyPublicacio = new JTextField();
        panel.add(txtAnyPublicacio);

        panel.add(new JLabel("Categoria:"));
        txtCategoria = new JTextField();
        panel.add(txtCategoria);

        panel.add(new JLabel("Estat:"));
        txtEstat = new JTextField();
        panel.add(txtEstat);

        btnInsertar = new JButton("Insertar");
        btnInsertar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                inserirLlibre();
            }
        });
        panel.add(btnInsertar);

        btnActualitzar = new JButton("Actualitzar");
        btnActualitzar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                actualitzarLlibre();
            }
        });
        panel.add(btnActualitzar);

        btnEliminar = new JButton("Eliminar");
        btnEliminar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                eliminarLlibre();
            }
        });
        panel.add(btnEliminar);

        add(panel);
    }

    private void inserirLlibre() {
        String titol = txtTitol.getText();
        String autor = txtAutor.getText();
        String isbn = txtISBN.getText();
        String editorial = txtEditorial.getText();
        String dataPublicacioString = txtAnyPublicacio.getText();
        String categoria = txtCategoria.getText();
        String estat = txtEstat.getText();

        Date anyPublicacio = null;
        try {
            anyPublicacio = new SimpleDateFormat("dd-MM-yyyy").parse(dataPublicacioString);
        } catch (ParseException e) {
            JOptionPane.showMessageDialog(this, "Format de data incorrecte. Utilitza el format dd-MM-yyyy.");
            return;
        }

        Llibre llibre = new Llibre(0, titol, autor, isbn, editorial, anyPublicacio, categoria, estat);
        llibreDAO.afegirLlibre(llibre);
        JOptionPane.showMessageDialog(this, "Llibre inserit correctament.");
        netejarCamps();
    }

    private void actualitzarLlibre() {
        int id = Integer.parseInt(txtID.getText());
        String titol = txtTitol.getText();
        String autor = txtAutor.getText();
        String isbn = txtISBN.getText();
        String editorial = txtEditorial.getText();
        String dataPublicacioString = txtAnyPublicacio.getText();
        String categoria = txtCategoria.getText();
        String estat = txtEstat.getText();

        Date anyPublicacio = null;
        try {
            anyPublicacio = new SimpleDateFormat("dd-MM-yyyy").parse(dataPublicacioString);
        } catch (ParseException e) {
            JOptionPane.showMessageDialog(this, "Format de data incorrecte. Utilitza el format dd-MM-yyyy.");
            return;
        }

        Llibre llibre = new Llibre(id, titol, autor, isbn, editorial, anyPublicacio, categoria, estat);
        llibreDAO.modificarLlibre(llibre);
        JOptionPane.showMessageDialog(this, "Llibre actualitzat correctament.");
        netejarCamps();
    }

    private void eliminarLlibre() {
        int id = Integer.parseInt(txtID.getText());
        llibreDAO.eliminarLlibre(id);
        JOptionPane.showMessageDialog(this, "Llibre eliminat correctament.");
        netejarCamps();
    }

    private void netejarCamps() {
        txtID.setText("");
        txtTitol.setText("");
        txtAutor.setText("");
        txtISBN.setText("");
        txtEditorial.setText("");
        txtAnyPublicacio.setText("");
        txtCategoria.setText("");
        txtEstat.setText("");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                MainFrameLlibres frame = new MainFrameLlibres();
                frame.setVisible(true);
            }
        });
    }
}
