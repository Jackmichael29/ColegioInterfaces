/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataAccessLayer;

import Connection.UConnection;
import JavaBean.Alumno;
import JavaBean.HistorialNotas;
import Utilities.Bitacora;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.ArrayList;

public class AlumnoDao {

    public void insertar(Alumno alumno) throws Exception {
        Connection con = null;
        CallableStatement csmt = null;

        try {
            con = UConnection.getConnection();
            String sql = "";
            sql = "call sp_alumno_insertar2(?,?,?,?,?,?)";
            csmt = con.prepareCall(sql);
            //csmt.registerOutParameter(1, java.sql.Types.INTEGER);

            if (alumno.getDni().isEmpty()) {
                csmt.setNull(1, java.sql.Types.VARCHAR);
            } else {
                csmt.setString(1, alumno.getDni());
            }
            csmt.setString(2, alumno.getApellido_paterno());
            csmt.setString(3, alumno.getApellido_materno());
            csmt.setString(4, alumno.getNombres());
            csmt.setDate(5, Date.valueOf(alumno.getFecha_nacimiento()));
            if (alumno.getCorreo_electrico().isEmpty()) {
                csmt.setNull(6, java.sql.Types.VARCHAR);
            } else {
                csmt.setString(6, alumno.getCorreo_electrico());
            }

            csmt.execute();
            //alumno.setAlumno_id(csmt.getInt(1));

        } catch (Exception e) {
            if (e.getMessage().contains("idx_alumno_dni")) {
                throw new Exception("El DNI ingresado ya existe en la base de datos");
            }
            if (e.getMessage().contains("idx_alumno_correo_electronico")) {
                throw new Exception("El Correo electrónico ingresado ya existe en la base de datos");
            }
            throw e;
        } finally {
            try {
                if(csmt!=null)csmt.close();
            } catch (Exception e) {
                throw e; 
            }
            }
    }
    
    public void actualizar(Alumno alumno) throws Exception{        
        
        Connection con=null;
        CallableStatement csmt = null;    
        
        try {
            con=UConnection.getConnection();
            String sql="";            
            sql="call sp_alumno_actualizar(?,?,?,?,?,?,?)";
            csmt=con.prepareCall(sql);
            csmt.setInt(1, alumno.getAlumno_id());
            if(alumno.getDni().isEmpty())csmt.setNull(2,java.sql.Types.VARCHAR);
            else csmt.setString(2, alumno.getDni());            
            csmt.setString(3, alumno.getApellido_paterno());
            csmt.setString(4, alumno.getApellido_materno());
            csmt.setString(5, alumno.getNombres());
            
            csmt.setDate(6, Date.valueOf(alumno.getFecha_nacimiento()));
            
            if(alumno.getCorreo_electrico().isEmpty())csmt.setNull(7,java.sql.Types.VARCHAR);
            else csmt.setString(7, alumno.getCorreo_electrico());
            
            csmt.executeUpdate(); //se puede usar .execute() para todas las operaciones
             
        }catch (Exception e) {         
            if(e.getMessage().contains("idx_alumno_dni")) {
                throw new Exception("El DNI ingresado ya existe en la base de datos");
            }
            if(e.getMessage().contains("idx_correo_electronico")) {
                throw new Exception("El Correo electrónico ingresado ya existe en la base de datos");
            }
            Bitacora.registrar(e);
            throw new Exception("Error crítico: Comunicarse con el administrador del sistema");
        }finally{
            try {
                if(csmt!=null)csmt.close();            
            } catch (Exception e) {
                Bitacora.registrar(e);
            }        
        }    
    }
    
    public void eliminar(int id) throws Exception{    
        
        Connection con=null;
        CallableStatement cstm = null;    
        
        try {
            con=UConnection.getConnection();
            String sql="";            
            sql="call sp_alumno_eliminar(?)";
            cstm=con.prepareCall(sql);
            cstm.setInt(1, id);
         
            cstm.executeUpdate(); //se puede usar .execute() para todas las operaciones
             
        }catch (Exception e) {           
            Bitacora.registrar(e);            
            throw new Exception("Error crítico: Comunicarse con el administrador del sistema");
            
        }finally{
            try {
                if(cstm!=null)cstm.close();             
            } catch (Exception e) {
                Bitacora.registrar(e);
            }        
        }        
    }
    
    public ArrayList<Alumno> buscarPorAlumno(String cadena) throws Exception{
     
        ArrayList<Alumno>alumnos=new ArrayList<>();
        Alumno alumno=null;
        
        Connection con=null;
        CallableStatement cstm = null;  
        ResultSet rs=null;
        
        try {            
            con=UConnection.getConnection();
            String sql="";            
            sql="call sp_alumno_buscar_por_alumno(?)";
            cstm=con.prepareCall(sql);
            cstm.setString(1, cadena);
         
            rs=cstm.executeQuery(); //se puede usar .execute() para todas las operaciones         
            
            while(rs.next()){
                alumno = new Alumno();
                alumno.setAlumno_id(rs.getInt("alumno_id"));
                alumno.setDni(rs.getString("dni"));
                //alumno.setApellidosNombres(rs.getString("apellidos_nombres"));
                String[] nombres = rs.getString("apellidos_nombres").replace(",", "").split(" ");
                System.out.println(rs.getString("apellidos_nombres"));
                alumno.setApellido_paterno(nombres[0]);
                alumno.setApellido_materno(nombres[1]);
                
                if (nombres.length < 4) alumno.setNombres(nombres[2]);
                else alumno.setNombres(nombres[2]+" "+nombres[3]); 
                
                alumno.setCorreo_electrico(rs.getString("correo_electronico"));
                System.out.println(rs.getString("correo_electronico"));
                alumno.setFecha_nacimiento(rs.getDate("fecha_nacimiento").toLocalDate());
                
                alumnos.add(alumno);
            }
            
        }catch (Exception e) {         
            Bitacora.registrar(e);
            System.out.println(e);
            throw new Exception("Error crítico: Comunicarse con el administrador del sistema");
        }finally{
            try {
                if(rs!=null)rs.close();
                if(cstm!=null)cstm.close();                
            } catch (Exception e) {
                Bitacora.registrar(e);
            }        
        }        
        return alumnos;     
     }
    //------------------------------------------------------------------------------------- 
     public Alumno buscarPorDNI(String dni) throws Exception{     
        
        Alumno alumno=null;
        
        Connection con=null;
        CallableStatement cstm = null;  
        ResultSet rs=null;
        
        try {            
            con=UConnection.getConnection();
            String sql="";            
            sql="call sp_alumno_buscar_por_dni(?)";
            cstm=con.prepareCall(sql);
            cstm.setString(1, dni);
         
            rs=cstm.executeQuery(); //se puede usar .execute() para todas las operaciones         
            
            while(rs.next()){
                alumno = new Alumno();
                alumno.setAlumno_id(rs.getInt("alumno_id"));
                alumno.setDni(rs.getString("dni"));
                alumno.setApellidosNombres(rs.getString("apellidos_nombres"));               
            }
            
        }catch (Exception e) {         
            Bitacora.registrar(e);
            throw new Exception("Error crítico: Comunicarse con el administrador del sistema");
        }finally{
            try {
                if(rs!=null)rs.close();
                if(cstm!=null)cstm.close();                
            } catch (Exception e) {
                Bitacora.registrar(e);
            }        
        }       
        
        return alumno;     
     }     
     
     public Alumno buscarPorId(int id) throws Exception{        
       
        Alumno alumno=null;
        
        Connection con=null;
        CallableStatement cstm = null;  
        ResultSet rs=null;
        
        try {            
            con=UConnection.getConnection();
            String sql="";            
            sql="call sp_alumno_buscar_por_id(?)";
            cstm=con.prepareCall(sql);
            cstm.setInt(1, id);
         
            rs=cstm.executeQuery(); //se puede usar .execute() para todas las operaciones
            
            while(rs.next()){
                alumno = new Alumno();
                alumno.setAlumno_id(rs.getInt("alumno_id"));
                alumno.setDni(rs.getString("dni"));
                alumno.setApellidosNombres(rs.getString("apellidos_nombres"));                             
            }
            
        } catch (Exception e) {         
            Bitacora.registrar(e);
            throw new Exception("Error crítico: Comunicarse con el administrador del sistema");
        }finally{
            try {
                if(rs!=null)rs.close();
                if(cstm!=null)cstm.close();                
            } catch (Exception e) {
                Bitacora.registrar(e);
            }        
        }        
        return alumno;     
    }
     
    public ArrayList<Alumno> buscarPorAlumnoxCursoBuscar(String cadena, String nombre, String grado, String nivel) throws Exception{
     
        ArrayList<Alumno>alumnos=new ArrayList<>();
        Alumno alumno=null;
        
        Connection con=null;
        CallableStatement cstm = null;  
        ResultSet rs=null;
        
        try {            
            con=UConnection.getConnection();
            String sql="";            
            sql="call sp_alumno_buscar_por_alumno(?,?,?,?)";
            cstm=con.prepareCall(sql);
            cstm.setString(1, cadena);
            cstm.setString(2, nombre);
            cstm.setString(3, grado);
            cstm.setString(4, nivel);
         
            rs=cstm.executeQuery(); //se puede usar .execute() para todas las operaciones         
            
            while(rs.next()){
                alumno = new Alumno();
                alumno.setAlumno_id(rs.getInt("alumno_id"));
                alumno.setDni(rs.getString("dni"));
                //alumno.setApellidosNombres(rs.getString("apellidos_nombres"));
                String[] nombres = rs.getString("apellidos_nombres").replace(",", "").split(" ");
                System.out.println(rs.getString("apellidos_nombres"));
                alumno.setApellido_paterno(nombres[0]);
                alumno.setApellido_materno(nombres[1]);
                
                if (nombres.length < 4) alumno.setNombres(nombres[2]);
                else alumno.setNombres(nombres[2]+" "+nombres[3]); 
                
                alumno.setCorreo_electrico(rs.getString("correo_electronico"));
                System.out.println(rs.getString("correo_electronico"));
                alumno.setFecha_nacimiento(rs.getDate("fecha_nacimiento").toLocalDate());
                
                alumnos.add(alumno);
            }
            
        }catch (Exception e) {         
            Bitacora.registrar(e);
            System.out.println(e);
            throw new Exception("Error crítico: Comunicarse con el administrador del sistema");
        }finally{
            try {
                if(rs!=null)rs.close();
                if(cstm!=null)cstm.close();                
            } catch (Exception e) {
                Bitacora.registrar(e);
            }        
        }        
        return alumnos;     
     }
    
    
    public ArrayList<Alumno> buscarPorAlumnoxCurso(String nombre, String grado, String nivel) throws Exception{
     
        ArrayList<Alumno>alumnos=new ArrayList<>();
        Alumno alumno= new Alumno();
        HistorialNotas hn = new HistorialNotas();
        
        Connection con=null;
        CallableStatement cstm = null;  
        ResultSet rs=null;
        
        try {            
            con=UConnection.getConnection();
            String sql="";            
            sql="call sp_alumno_buscar_alumno_por_curso(?,?,?)";
            cstm=con.prepareCall(sql);
            cstm.setString(1, nombre);
            cstm.setString(2, nivel);
            cstm.setString(3, grado);
         
            rs=cstm.executeQuery(); //se puede usar .execute() para todas las operaciones         
            
            while(rs.next()){
                alumno = new Alumno();
                hn = new HistorialNotas();
                
                alumno.setAlumno_id(rs.getInt("alumno_id"));
                alumno.setApellidosNombres(rs.getString("Apellidos y Nombres"));

                hn.setHistorial_id(rs.getInt("historial_notas_id"));
                System.out.println("este valor viene del DAO +++ " + rs.getInt("historial_notas_id"));
                hn.setCurso_id(rs.getInt("curso_id"));
                hn.setAlumno_id(rs.getInt("alumno_id"));
//                if (nombres.length < 4) alumno.setNombres(nombres[2]);
//                else alumno.setNombres(nombres[2]+" "+nombres[3]);
                alumno.setHnot(hn);
                System.out.println("valores anadidos por el dao en el objeto: "+ hn.getHistorial_id());
                System.out.println("valor cambiado en el alumno: " + alumno.getHnot().getHistorial_id());
                alumnos.add(alumno);
            }
            
        }catch (Exception e) {         
            Bitacora.registrar(e);
            System.out.println(e);
            throw new Exception("Error crítico: Comunicarse con el administrador del sistema");
        }finally{
            try {
                if(rs!=null)rs.close();
                if(cstm!=null)cstm.close();                
            } catch (Exception e) {
                Bitacora.registrar(e);
            }        
        }
        System.out.println("DAOOOO+++");
        System.out.println(alumnos.get(0).getApellidosNombres());
        System.out.println(alumnos.get(0).getHnot().getHistorial_id());
        System.out.println(alumnos.get(1).getApellidosNombres());
        System.out.println(alumnos.get(1).getHnot().getHistorial_id());
        System.out.println("DAOOOO+++");
        
        return alumnos;     
    }
    
    public ArrayList<Alumno> buscarPorAlumnoxSalon(String grado, String nivel) throws Exception{
     
        ArrayList<Alumno>alumnos=new ArrayList<>();
        Alumno alumno= new Alumno();
        HistorialNotas hn = new HistorialNotas();
        
        Connection con=null;
        CallableStatement cstm = null;  
        ResultSet rs=null;
        
        try {            
            con=UConnection.getConnection();
            String sql="";            
            sql="call sp_alumno_buscar_alumno_por_salon(?,?)";
            cstm=con.prepareCall(sql);
            cstm.setString(1, nivel);
            cstm.setString(2, grado);
         
            rs=cstm.executeQuery(); //se puede usar .execute() para todas las operaciones         
            
            while(rs.next()){
                alumno = new Alumno();
                hn = new HistorialNotas();
                
                alumno.setAlumno_id(rs.getInt("alumno_id"));
                alumno.setApellidosNombres(rs.getString("Apellidos y Nombres"));
                alumno.setDni(rs.getString("dni"));
                alumnos.add(alumno);
            }
            
        }catch (Exception e) {         
            Bitacora.registrar(e);
            System.out.println(e);
            throw new Exception("Error crítico: Comunicarse con el administrador del sistema");
        }finally{
            try {
                if(rs!=null)rs.close();
                if(cstm!=null)cstm.close();                
            } catch (Exception e) {
                Bitacora.registrar(e);
            }        
        }
        
        return alumnos;     
     }
}




