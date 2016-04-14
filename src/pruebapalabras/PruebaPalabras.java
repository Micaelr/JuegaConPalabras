/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pruebapalabras;

import java.util.Vector;
import javax.swing.JOptionPane;

/**
 *
 * @author Micael
 */
public class PruebaPalabras {

    /**
     * @param args the command line arguments
     */
    
    static int ultimaSilaba;
    
    static String cadenaIntro = "";
    static String silaba2 = "";
    static String controlPalabra = "";
    static String textoPantalla = "";
    static String cadenaBucle = "";

    private static Vector getPalabras(String cadena) {
        Vector palabras = new Vector();
        String palabra = "";
        cadena = cadena.trim().toLowerCase() + " ";
        char[] c = cadena.toCharArray();
        int i;
        for (i = 0; i < cadena.length(); i++) {
            if (c[i] == ' ') {
                palabras.add(palabra);
                palabra = "";
            } else {
                palabra = palabra + String.valueOf(c[i]);
            }
        }
        return palabras;
    }

    private static boolean Verificar(String cadena) {
        String s;
        char c[], x;
        int i, j, k;
        int error = 0;
        s = " abcdefghijklmnñopqrstuvwxyzáéíóúü";
        c = s.toCharArray();
        for (i = 0; i < cadena.length() && error == 0; i++) {
            x = cadena.charAt(i);
            k = 0;
            for (j = 0; j < s.length() && k == 0; j++) {
                if (x == c[j]) {
                    k++;
                }
            }
            if (k == 0) {
                error++;
            }
        }
        if (error == 0) {
            return true;
        } else {
            return false;
        }
    }

    public static  void Silabear() {

        cadenaIntro = JOptionPane.showInputDialog("Introduce la primera palabra");
        char[] palabraGuardada = cadenaIntro.toCharArray();

        if (Verificar(cadenaIntro)) {
            Vector palabras = getPalabras(cadenaIntro);
            pruebapalabras.SeparaSilabas s = new pruebapalabras.SeparaSilabas();
            int i;
            //txtSilabeo.setText("");
            for (i = 0; i < palabras.size(); i++) {
                s.setString((String) palabras.get(i));
                textoPantalla = controlPalabra+s.silabear();
                System.out.println(textoPantalla);
                //txtSilabeo.setText(txtSilabeo.getText() + " " + s.silabear());
            }

        } else {
            controlPalabra = "Palabra no válida";
        }
        
        ultimaSilaba();
        
       
        
        
    }

    public static void ultimaSilaba(){
        String palabra = textoPantalla;
        
        String[] palabraSeparada = palabra.split("-");
        
        silaba2 = "";
        for(int i = 0; i < palabraSeparada.length; i++){
            ultimaSilaba = palabraSeparada.length-1;
            silaba2 = palabraSeparada[ultimaSilaba];
        }
        System.out.println("ultima silaba: "+ silaba2);
        JOptionPane.showMessageDialog(null, "ESTA ES TU PALABRA:  "+textoPantalla+"\nESTA ES LA ULTIMA SILABA DE TU PALABRA:  "+silaba2);
          
    }
    
    
    public static void bucle(){
        cadenaBucle = cadenaIntro;
        while(cadenaBucle != ""){
            
            Silabear();
        }
    }
    

    public static void main(String[] args) {
        
        Silabear();
        bucle();
        
    }

}
