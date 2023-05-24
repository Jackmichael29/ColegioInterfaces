/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package JavaBean;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author black
 */
public class Notas {
    private int historial_notas_id;
    private double nota1;
    private double nota2;
    private double nota3;
    private double nota4;
    private double nota5;
    
    private Map<String,String> errores = new HashMap<>();
    
    public Map<String, String> getErrores() {
        return errores;
    }

    public void setErrores(Map<String, String> errores) {
        this.errores = errores;
    }

    public Notas() {
    }

    public int getHistorial_notas_id() {
        return historial_notas_id;
    }

    public void setHistorial_notas_id(int historial_notas) {
        this.historial_notas_id = historial_notas;
    }

    public double getNota1() {
        return nota1;
    }

    public void setNota1(double nota1){
        if(nota1<0){
            errores.put("nota1","El valor ingresado para el campo Nota1 debe ser mayor o igual a 0");
        }
        this.nota1 = nota1;
    }

    public double getNota2() {
        return nota2;
    }

    public void setNota2(double nota2){
        if(nota1<0){
            errores.put("nota2","El valor ingresado para el campo Nota2 debe ser mayor o igual a 0");
        }
        this.nota2 = nota2;
    }

    public double getNota3() {
        return nota3;
    }

    public void setNota3(double nota3){
        if(nota1<0){
            errores.put("nota3","El valor ingresado para el campo Nota3 debe ser mayor o igual a 0");
        }
        this.nota3 = nota3;
    }

    public double getNota4() {
        return nota4;
    }

    public void setNota4(double nota4){
        if(nota1<0){
            errores.put("nota4","El valor ingresado para el campo Nota4 debe ser mayor o igual a 0");
        }
        this.nota4 = nota4;
    }

    public double getNota5() {
        return nota5;
    }

    public void setNota5(double nota5){
        if(nota1<0){
            errores.put("nota5","El valor ingresado para el campo Nota5 debe ser mayor o igual a 0");
        }
        this.nota5 = nota5;
    }
}
