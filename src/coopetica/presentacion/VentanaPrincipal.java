/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package coopetica.presentacion;

import coopetica.logica.AsociadoServicio;
import coopetica.modelo.Asociado;
import java.io.IOException;
import java.util.ArrayList;
import java.awt.*;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;


public class VentanaPrincipal extends JFrame {
    
    private JTextField txtCedula;
    private JTextField txtNombre;
    private JTextField txtSaldo;
    
    private JButton btnRegistrar;
    private JButton btnLista;
    private JButton btnResumen;
    
    private JTextField txtBuscarCedula;
    private JButton btnBuscar;
    
    private JTextArea txtAreaLista; 
    
    private AsociadoServicio servicio;
    
    public VentanaPrincipal() throws IOException {
        
        servicio = new AsociadoServicio();
        
        setTitle("Coopetica - Keilly Valeria Brenes Sáenz");
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        txtCedula = new JTextField(15);
        txtNombre = new JTextField(15);
        txtSaldo = new JTextField(15);
        
        btnRegistrar = new JButton("Registrar");
        btnLista = new JButton("Listar");
        btnResumen = new JButton("Resumen");
        
        txtAreaLista = new JTextArea(10, 30);
        txtAreaLista.setEditable(false);
        
        txtBuscarCedula = new JTextField(15);
        btnBuscar = new JButton ("Buscar");
        
        setLayout(new FlowLayout());     
        
        add(new JLabel("Cédula; "));
        add(txtCedula);
    
        add(new JLabel("Nombre; "));
        add(txtNombre);
    
        add(new JLabel("Saldo de aportes; "));
        add(txtSaldo);
    
        add(btnRegistrar);
        add(btnLista);
        add(btnResumen);
    
        add(new JLabel("Buscar por cédula;"));
        add(txtBuscarCedula);
        add(btnBuscar);
    
        add(new JScrollPane(txtAreaLista));
        
        btnLista.addActionListener(e -> {
            
            try {
                ArrayList<Asociado> lista = servicio.listar();
                String texto = "";
                
                for (Asociado asociado : lista) {
                    texto += asociado.toString() + "\n";
                }
                txtAreaLista.setText(texto);
                
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(this, ex.getMessage());
            }
            
        });
        
        btnRegistrar.addActionListener(e-> {
            
            String cedula = txtCedula.getText();
            String nombre = txtNombre.getText();
            String saldoTexto = txtSaldo.getText();
            
            try {
                double saldo = Double.parseDouble(saldoTexto);
                
                Asociado asociado = new Asociado(cedula, nombre, saldo);
                
                String respuesta = servicio.registrar(asociado);
                
                if (respuesta.equals("OK")){
                    JOptionPane.showMessageDialog(
                            this,
                            "Asociado registraro correctamente"
                    );
                    
                    txtCedula.setText("");
                    txtNombre.setText("");
                    txtSaldo.setText("");
                    
                } else {
                    JOptionPane.showMessageDialog(this, respuesta);
                }
                
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(
                        this,
                        "El saldo debe ser un numero."
                );
                
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(this, ex.getMessage());
                
            }
        });
        
        btnResumen.addActionListener (e-> {
            try{
                int cantidad = servicio.obtenerCantidadAsociados();
                double total = servicio.obtenerTotalAportes();
                
                JOptionPane.showMessageDialog(this,
                        "Cantidad de asociados; " + cantidad
                        + "\nTotal de aportes: " + total);
            }catch (IOException ex){
                JOptionPane.showMessageDialog(this, ex.getMessage());
            }
        });
        
        btnBuscar.addActionListener (e-> {
            
            String cedula = txtBuscarCedula.getText().trim();
            Asociado asociado = null;
            
            try {
                asociado = servicio.buscarPorCedula(cedula);
            
            }catch (IOException ex) {
                JOptionPane.showMessageDialog(this, ex.getMessage());
            }
            if (asociado != null){
                JOptionPane.showMessageDialog(this,
                        asociado.toString());
            }else {
                JOptionPane.showMessageDialog(this,
                        "No se encontro un asociado con esa cedula.");
            }
            
        });
        
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
        
    }
    
public static void main (String [] arg) {
    try {
        new VentanaPrincipal();
    }catch (IOException ex){
        ex.printStackTrace();
    }
    
}
     
}
