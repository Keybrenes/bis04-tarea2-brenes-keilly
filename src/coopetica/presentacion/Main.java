/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package coopetica.presentacion;
import java.io.IOException;

/**
 *
 * @author keybr
 */
public class Main {
    public static void main(String[] args) {
        try{
            new VentanaPrincipal();
        }catch (IOException ex){
            ex.printStackTrace();
        }
    }
    
}
