package coopetica.logica;

import coopetica.datos.AsociadoArchivoDAO;
import coopetica.modelo.Asociado;
import java.io.IOException;
import java.util.ArrayList;

public class AsociadoServicio {

    private AsociadoArchivoDAO dao;

    public AsociadoServicio() throws IOException {
        this.dao = new AsociadoArchivoDAO();
    }

    public ArrayList<Asociado> listar() throws IOException {
        return dao.listar();
    }
    
    public int obtenerCantidadAsociados() throws IOException {
        return dao.listar().size();
    }
    
    public double obtenerTotalAportes() throws IOException {
        double total = 0;
        
         for  (Asociado asociado : dao.listar()){
             total+= asociado.getSaldoAportes();
            
         }
         return total;
    }
    
    public Asociado buscarPorCedula(String cedula) throws IOException {
        
        for (Asociado asociado : dao.listar()){
        if (asociado.getCedula().equals(cedula)){
            return asociado;
        }
    }
    return null;    
    }
    
    public String registrar(Asociado a)
            throws IOException {

        if (a.getCedula().isEmpty() || a.getNombre().isEmpty()) {
            return "La cedula y el nombre son obligatorios.";
        }

        
        if (a.getSaldoAportes() < 0) {
            return "El saldo no puede ser negativo.";
        }

        for (Asociado asociado : dao.listar()) {
            if (asociado.getCedula().equals(a.getCedula())) {
                return "Ya existe un asociado con esa cedula.";
            }
        }

        dao.agregar(a);
        return "OK";
    }
}