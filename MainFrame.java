import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

public class MainFrame extends JFrame {
    private UsuariDAO UsuariDAO;

    private JTextField txtID, txtNom, txtCognom, txtEmail, txtRol;
    private JButton btnInsertar, btnActualitzar, btnEliminar, btnBuscar;

    public MainFrame() {
        UsuariDAO = new UsuariDAO();
        initUI();
    }

    private void initUI() {
        setTitle("Gestió d'Usuaris");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel(new GridLayout(7, 2));

        panel.add(new JLabel("ID:"));
        txtID = new JTextField();
        panel.add(txtID);

        panel.add(new JLabel("Nom:"));
        txtNom = new JTextField();
        panel.add(txtNom);
        
        panel.add(new JLabel("Cognom:"));
        txtCognom = new JTextField();
        panel.add(txtCognom);

        panel.add(new JLabel("Email:"));
        txtEmail = new JTextField();
        panel.add(txtEmail);

        panel.add(new JLabel("Rol:"));
        txtRol = new JTextField();
        panel.add(txtRol);

        btnInsertar = new JButton("Insertar");
        btnInsertar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                insartaUsuari();
            }
        });
        panel.add(btnInsertar);

        btnActualitzar = new JButton("Actualitzar");
        btnActualitzar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                actualizarUsuari();
            }
        });
        panel.add(btnActualitzar);

        btnEliminar = new JButton("Eliminar");
        btnEliminar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                elimiarUsuari();
            }
        });
        panel.add(btnEliminar);

        btnBuscar = new JButton("Buscar");
        btnBuscar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                buscarUsuari();
            }
        });
        panel.add(btnBuscar);

        add(panel);
    }

    private void insartaUsuari() {
        String nom = txtNom.getText();
        String cognom = txtCognom.getText();
        String email = txtEmail.getText();
        String rol = txtRol.getText();
        Date dateRegistre = new Date();

        Usuari Usuari = new Usuari(0, nom, cognom, email, rol, dateRegistre);
        UsuariDAO.insartaUsuari(Usuari);
        JOptionPane.showMessageDialog(this, "Usuari insertat correctament.");
        limpiarCampos();
    }

    private void actualizarUsuari() {
        int id = Integer.parseInt(txtID.getText());
        String nom = txtNom.getText();
        String cognom = txtCognom.getText();
        String email = txtEmail.getText();
        String rol = txtRol.getText();
        Date dateRegistre = new Date();

        Usuari Usuari = new Usuari(id, nom, cognom, email, rol, dateRegistre);
        UsuariDAO.actualizarUsuari(Usuari);
        JOptionPane.showMessageDialog(this, "Usuari actualitzat correctament.");
        limpiarCampos();
    }

    private void elimiarUsuari() {
        int id = Integer.parseInt(txtID.getText());
        UsuariDAO.elimiarUsuari(id);
        JOptionPane.showMessageDialog(this, "Usuari eliminat correctament.");
        limpiarCampos();
    }

    private void buscarUsuari() {
        int id = Integer.parseInt(txtID.getText());
        Usuari Usuari = UsuariDAO.obtenerUsuariPorID(id);
        if (Usuari != null) {
            txtNom.setText(Usuari.getNom());
            txtCognom.setText(Usuari.getCognom());
            txtEmail.setText(Usuari.getEmail());
            txtRol.setText(Usuari.getRol());
        } else {
            JOptionPane.showMessageDialog(this, "Usuari no trobat.");
        }
    }

    private void limpiarCampos() {
        txtID.setText("");
        txtNom.setText("");
        txtCognom.setText("");
        txtEmail.setText("");
        txtRol.setText("");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                MainFrame frame = new MainFrame();
                frame.setVisible(true);
            }
        });
    }
}
