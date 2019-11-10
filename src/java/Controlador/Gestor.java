/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Controlador;

import DTO.ListadoOrdenes;
import DTO.ListadoProfesionales;
import DTO.ReporteInstructor;
import DTO.ReportePaciente;
import DTO.ReporteProfesional;
import Modelo.Disciplina;
import Modelo.Inscripcion;
import Modelo.Orden;
import Modelo.Paciente;
import Modelo.Profesional;
import Modelo.Usuario;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * 
 * @author Eugenia Revol <euge.revol@gmail.com>
 */
public class Gestor {
    
    private Connection conn;
    private final String conexion = "jdbc:sqlserver://DESKTOP-C7M3HAG\\SQLEXPRESS:1433;databaseName=cm_database";
    private final String user = "sa";
    private final String password = "admin";
    
    private void abrirConexion() throws SQLException {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            conn = DriverManager.getConnection(conexion, user, password);
            
            System.out.println("Conexión a la BD");
        } catch (ClassNotFoundException ex) {
            System.out.println("Error en conexión");
        } 
    }
    
    private void cerrarConexion() {
        try {
            if(conn != null && !conn.isClosed())
                conn.close();
        } catch (Exception e) {
            System.out.println("Error al cerrar conexión");
        }
    }
    
    public Usuario obtenerUsuario(String nombre, String contrasena) {
        Usuario usuario = null;
        
        try {
            abrirConexion();
            String sql = "SELECT * FROM Usuario WHERE nombre = ? and contrasena = ? ";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, nombre);
            ps.setString(2, contrasena);
            
            ResultSet rs = ps.executeQuery();
            boolean esCorrecto = rs.next();
            
            if (esCorrecto) {
                usuario = new Usuario(rs.getString("nombre"), rs.getString("contrasena"));
                System.out.println("Usuario " + nombre + " logueado.");
            } else {
                System.out.println("Usuario invalido.");
            }
            
            rs.close();
        } catch(Exception exc) {
            exc.printStackTrace();
        } finally {
            cerrarConexion();
        }
        
        return usuario;
    }
//    ____                _               __             
//   / __ \ ____ _ _____ (_)___   ____   / /_ ___   _____
//  / /_/ // __ `// ___// // _ \ / __ \ / __// _ \ / ___/
// / ____// /_/ // /__ / //  __// / / // /_ /  __/(__  ) 
///_/     \__,_/ \___//_/ \___//_/ /_/ \__/ \___//____/  
//                                                       
    public ArrayList<Paciente> obtenerPacientes() {
        ArrayList<Paciente> pacientes = new ArrayList();
        
        try {
            abrirConexion();
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM PACIENTE WHERE NOMBRE not LIKE 'NO_ACTIVO-%'");
            while(rs.next()) {
                int idPaciente = rs.getInt("id_paciente");
                String nombre = rs.getString("nombre");
                String apellido = rs.getString("apellido");
                Date fechaNac = rs.getDate("fecha_nac");
                int dni = rs.getInt("dni");
                String direccion = rs.getString("direccion");
                String obraSocial = rs.getString("obra_social");
                String telefono = rs.getString("telefono");
                String telefonoUrg = rs.getString("telefono_urgencia");
                float altura = rs.getFloat("altura");
                float peso = rs.getFloat("peso");
                
                Paciente p = new Paciente(idPaciente, nombre, apellido,
                        new SimpleDateFormat("MM/dd/yyyy").format(fechaNac), dni, direccion, obraSocial, telefono, 
                        telefonoUrg, altura, peso);
                
                pacientes.add(p);
            }
            rs.close();
            st.close();
        } catch (SQLException ex) {
        } finally {
            cerrarConexion();
        }
        
        return pacientes;
    }
    
    public Paciente obtenerPacientePorId(int id) {
        Paciente paciente = null;
        
        try {
            abrirConexion();
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM PACIENTE where id_paciente = ?");
            ps.setInt(1, id);
            
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()) {
                int idPaciente = rs.getInt("id_paciente");
                String nombre = rs.getString("nombre");
                String apellido = rs.getString("apellido");
                Date fechaNac = rs.getDate("fecha_nac");
                int dni = rs.getInt("dni");
                String direccion = rs.getString("direccion");
                String obraSocial = rs.getString("obra_social");
                String telefono = rs.getString("telefono");
                String telefonoUrg = rs.getString("telefono_urgencia");
                float altura = rs.getFloat("altura");
                float peso = rs.getFloat("peso");
                
                paciente = new Paciente(idPaciente, nombre, apellido,
                        new SimpleDateFormat("MM/dd/yyyy").format(fechaNac), dni, direccion, obraSocial, telefono, 
                        telefonoUrg, altura, peso);
            }
            rs.close();
            ps.close();
        } catch (SQLException ex) {
        } finally {
            cerrarConexion();
        }
        
        return paciente;
    }
    
    public boolean agregarPaciente(Paciente p) {
        boolean bandera = false;
        
        try {
            abrirConexion();
            System.out.println(p.toString());
            PreparedStatement pst = conn.prepareStatement("INSERT into PACIENTE"
                    + "(nombre,apellido,fecha_nac,dni,direccion,obra_social,"
                    + "telefono,telefono_urgencia,altura,peso)"
                    + " VALUES(?,?,?,?,?,?,?,?,?,?)");
            pst.setString(1, p.getNombre());
            pst.setString(2, p.getApellido());
            try {
                pst.setDate(3, new java.sql.Date(new SimpleDateFormat("MM/dd/yyyy").parse(p.getFechaNac()).getTime()));
            } catch (ParseException ex) {
                Logger.getLogger(Gestor.class.getName()).log(Level.SEVERE, null, ex);
            }
            pst.setInt(4, p.getDni());
            pst.setString(5, p.getDireccion());
            pst.setString(6, p.getObraSocial());
            pst.setString(7, p.getTelefono());
            pst.setString(8, p.getTelefonoUrg());
            pst.setFloat(9, p.getAltura());
            pst.setFloat(10, p.getPeso());
            
            int resultado = pst.executeUpdate();
            
            if (resultado > 0) {
                bandera = true;
                System.out.println("Agrego un paciente");
            }
            pst.close();
        } catch (SQLException ex) { System.out.println("Error de SQL: " + ex);}
        finally { cerrarConexion(); }
        
        return bandera;
    }
    
    public boolean modificarPaciente(Paciente p) {
        boolean bandera = false;
        
        try {
            abrirConexion();
            PreparedStatement pst = conn.prepareStatement("EXEC PROC_ModificarPaciente "
                    + "@id_paciente = ?, "
                    + "@nombre = ?, "
                    + "@apellido = ?, "
                    + "@fecha_nac = ?, "
                    + "@dni = ?, "
                    + "@direccion = ?, "
                    + "@obra_social = ?, "
                    + "@telefono = ?, "
                    + "@telefono_urgencia = ?, "
                    + "@altura = ?, "
                    + "@peso = ?");
            
            pst.setInt(1, p.getIdPaciente());
            pst.setString(2, p.getNombre());
            pst.setString(3, p.getApellido());
            try {
                pst.setDate(4, new java.sql.Date(new SimpleDateFormat("MM/dd/yyyy").parse(p.getFechaNac()).getTime()));
            } catch (ParseException ex) {
                Logger.getLogger(Gestor.class.getName()).log(Level.SEVERE, null, ex);
            }
            pst.setInt(5, p.getDni());
            pst.setString(6, p.getDireccion());
            pst.setString(7, p.getObraSocial());
            pst.setString(8, p.getTelefono());
            pst.setString(9, p.getTelefonoUrg());
            pst.setFloat(10, p.getAltura());
            pst.setFloat(11, p.getPeso());
            
            int resultado = pst.executeUpdate();
            
            if (resultado > 0) {
                bandera = true;
                System.out.println("Modifico un paciente");
            }
            pst.close();
        } catch (SQLException e) {}
        finally { cerrarConexion(); }
        
        return bandera;
    }
    
    public boolean modificarEstadoPaciente(int id) {
        boolean bandera = false;
        
        try {
            abrirConexion();
            PreparedStatement pst = conn.prepareStatement("UPDATE PACIENTE SET"
                    + " NOMBRE = CONCAT('NO_ACTIVO-', NOMBRE) WHERE id_paciente = ?");
            
            pst.setInt(1, id);
            
            int resultado = pst.executeUpdate();
            
            if (resultado > 0) {
                bandera = true;
                System.out.println("Modifico el estado de un paciente");
            }
            pst.close();
        } catch (SQLException e) {}
        finally { cerrarConexion(); }
        
        return bandera;
    }
    
    public boolean eliminarPaciente(int id) {
        boolean bandera = false;
        
        try {
            abrirConexion();
            PreparedStatement pst = conn.prepareStatement("DELETE FROM PACIENTE WHERE id_paciente = ?");
            
            pst.setInt(1, id);
            
            int resultado = pst.executeUpdate();
            
            if (resultado > 0) {
                bandera = true;
                System.out.println("Elimino un paciente");
            }
            pst.close();
        } catch (SQLException e) {}
        finally { cerrarConexion(); }
        
        return bandera;
    }
//    ____                ____             _                       __           
//   / __ \ _____ ____   / __/___   _____ (_)____   ____   ____ _ / /___   _____
//  / /_/ // ___// __ \ / /_ / _ \ / ___// // __ \ / __ \ / __ `// // _ \ / ___/
// / ____// /   / /_/ // __//  __/(__  )/ // /_/ // / / // /_/ // //  __/(__  ) 
///_/    /_/    \____//_/   \___//____//_/ \____//_/ /_/ \__,_//_/ \___//____/  
//                                                                              
    public ArrayList<ListadoProfesionales> obtenerProfesionales() {
        ArrayList<ListadoProfesionales> profesionales = new ArrayList();
        
        try {
            abrirConexion();
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM PROFESIONAL, "
                    + "TIPO_PROFESIONAL WHERE id_tipo = id_tipo_profesional "
                    + "AND NOMBRE not LIKE 'NO_ACTIVO-%'");
            while(rs.next()) {
                int idProfesional = rs.getInt("id_profesional");
                int idTipo = rs.getInt("id_tipo");
                int legajo = rs.getInt("legajo");
                String nombre = rs.getString("nombre");
                String apellido = rs.getString("apellido");
                Date fechaNac = rs.getDate("fecha_nac");
                int dni = rs.getInt("dni");
                String direccion = rs.getString("direccion");
                String telefono = rs.getString("telefono");
                String matricula = rs.getString("matricula");
                String urlFoto = rs.getString("url_foto");
                String posicion = rs.getString("posicion");
                
                ListadoProfesionales p = new ListadoProfesionales(idProfesional, idTipo, legajo, nombre, 
                        apellido, new SimpleDateFormat("MM/dd/yyyy").format(fechaNac),
                        dni, direccion, telefono, matricula, urlFoto, posicion);
                
                profesionales.add(p);
            }
            rs.close();
            st.close();
        } catch (SQLException ex) {
        } finally {
            cerrarConexion();
        }
        
        return profesionales;
    }
    
    public Profesional obtenerProfesionalPorId(int id) {
        Profesional profesional = null;
        
        try {
            abrirConexion();
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM PROFESIONAL, "
                    + "TIPO_PROFESIONAL WHERE id_tipo = id_tipo_profesional and id_profesional = ?");
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()) {
                int idProfesional = rs.getInt("id_profesional");
                int idTipo = rs.getInt("id_tipo");
                int legajo = rs.getInt("legajo");
                String nombre = rs.getString("nombre");
                String apellido = rs.getString("apellido");
                Date fechaNac = rs.getDate("fecha_nac");
                int dni = rs.getInt("dni");
                String direccion = rs.getString("direccion");
                String telefono = rs.getString("telefono");
                String matricula = rs.getString("matricula");
                String urlFoto = rs.getString("url_foto");
                
                profesional = new Profesional(idProfesional, idTipo, legajo, nombre, 
                        apellido, new SimpleDateFormat("MM/dd/yyyy").format(fechaNac),
                        dni, direccion, telefono, matricula, urlFoto);
            }
            rs.close();
            ps.close();
        } catch (SQLException ex) {
        } finally {
            cerrarConexion();
        }
        
        return profesional;
    }
    
    public boolean agregarProfesional(Profesional p) {
        boolean bandera = false;
        
        try {
            abrirConexion();
            System.out.println(p.toString());
            PreparedStatement pst = conn.prepareStatement("INSERT into PROFESIONAL"
                    + "(id_tipo,legajo,nombre,apellido,fecha_nac,dni,direccion,telefono,"
                    + "matricula,url_foto)"
                    + " VALUES(?,?,?,?,?,?,?,?,?,?)");
            pst.setInt(1, p.getIdTipo());
            pst.setInt(2, p.getLegajo());
            pst.setString(3, p.getNombre());
            pst.setString(4, p.getApellido());
            try {
                pst.setDate(5, new java.sql.Date(new SimpleDateFormat("MM/dd/yyyy").parse(p.getFechaNac()).getTime()));
            } catch (ParseException ex) {
                Logger.getLogger(Gestor.class.getName()).log(Level.SEVERE, null, ex);
            }
            pst.setInt(6, p.getDni());
            pst.setString(7, p.getDireccion());
            pst.setString(8, p.getTelefono());
            pst.setString(9, p.getMatricula());
            pst.setString(10, p.getUrlFoto());
            
            int resultado = pst.executeUpdate();
            
            if (resultado > 0) {
                bandera = true;
                System.out.println("Agrego un profesional");
            }
            pst.close();
        } catch (SQLException ex) { System.out.println("Error de SQL: " + ex);}
        finally { cerrarConexion(); }
        
        return bandera;
    }
    
    public boolean modificarProfesional(Profesional p) {
        boolean bandera = false;
        
        try {
            abrirConexion();
            PreparedStatement pst = conn.prepareStatement("EXEC PROC_ModificarProfesional "
                    + "@id_profesional = ?, "
                    + "@id_tipo = ?, "
                    + "@legajo = ?, "
                    + "@nombre = ?, "
                    + "@apellido = ?, "
                    + "@fecha_nac = ?, "
                    + "@dni = ?, "
                    + "@direccion = ?, "
                    + "@telefono = ?, "
                    + "@matricula = ?, "
                    + "@url_foto = ?");
            
            pst.setInt(1, p.getIdProfesional());
            pst.setInt(2, p.getIdTipo());
            pst.setInt(3, p.getLegajo());
            pst.setString(4, p.getNombre());
            pst.setString(5, p.getApellido());
            try {
                pst.setDate(6, new java.sql.Date(new SimpleDateFormat("MM/dd/yyyy").parse(p.getFechaNac()).getTime()));
            } catch (ParseException ex) {
                Logger.getLogger(Gestor.class.getName()).log(Level.SEVERE, null, ex);
            }
            pst.setInt(7, p.getDni());
            pst.setString(8, p.getDireccion());
            pst.setString(9, p.getTelefono());
            pst.setString(10, p.getMatricula());
            pst.setString(11, p.getUrlFoto());
            
            int resultado = pst.executeUpdate();
            
            if (resultado > 0) {
                bandera = true;
                System.out.println("Modifico un profesional");
            }
            pst.close();
        } catch (SQLException e) {}
        finally { cerrarConexion(); }
        
        return bandera;
    }
    
    public boolean modificarEstadoProfesional(int id) {
        boolean bandera = false;
        
        try {
            abrirConexion();
            PreparedStatement pst = conn.prepareStatement("UPDATE PROFESIONAL SET"
                    + " NOMBRE = CONCAT('NO_ACTIVO-', NOMBRE) WHERE id_profesional = ?");
            
            pst.setInt(1, id);
            
            int resultado = pst.executeUpdate();
            
            if (resultado > 0) {
                bandera = true;
                System.out.println("Modifico el estado de un profesional");
            }
            pst.close();
        } catch (SQLException e) {}
        finally { cerrarConexion(); }
        
        return bandera;
    }
    
    public boolean eliminarProfesional(int id) {
        boolean bandera = false;
        
        try {
            abrirConexion();
            PreparedStatement pst = conn.prepareStatement("DELETE FROM PROFESIONAL WHERE id_profesional = ?");
            
            pst.setInt(1, id);
            
            int resultado = pst.executeUpdate();
            
            if (resultado > 0) {
                bandera = true;
                System.out.println("Elimino un profesional");
            }
            pst.close();
        } catch (SQLException e) {}
        finally { cerrarConexion(); }
        
        return bandera;
    }
//    ____   _              _         __ _                    
//   / __ \ (_)_____ _____ (_)____   / /(_)____   ____ _ _____
//  / / / // // ___// ___// // __ \ / // // __ \ / __ `// ___/
// / /_/ // /(__  )/ /__ / // /_/ // // // / / // /_/ /(__  ) 
///_____//_//____/ \___//_// .___//_//_//_/ /_/ \__,_//____/  
//                        /_/                                 
    public ArrayList<Disciplina> obtenerDisciplinas() {
        ArrayList<Disciplina> disciplinas = new ArrayList();
        try {
            abrirConexion();
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM DISCIPLINA WHERE"
                    + " NOMBRE not LIKE 'NO_ACTIVO-%'");
            while(rs.next()) {
                int idDisciplina = rs.getInt("id_disciplina");
                String nombre = rs.getString("nombre");
                Disciplina d = new Disciplina(idDisciplina, nombre);
                
                disciplinas.add(d);
            }
            rs.close();
            st.close();
        } catch (SQLException ex) {
        } finally {
            cerrarConexion();
        }
        
        return disciplinas;
    }
    
    public Disciplina obtenerDisciplinaPorId(int id) {
        Disciplina disciplina = null;
        try {
            abrirConexion();
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM DISCIPLINA where id_disciplina = ?");
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
                int idDisciplina = rs.getInt("id_disciplina");
                String nombre = rs.getString("nombre");
                disciplina = new Disciplina(idDisciplina, nombre);
            }
            rs.close();
            ps.close();
        } catch (SQLException ex) {
        } finally {
            cerrarConexion();
        }
        
        return disciplina;
    }
    
    public boolean agregarDisciplina(Disciplina d) {
        boolean bandera = false;
        
        try {
            abrirConexion();
            System.out.println(d.toString());
            PreparedStatement pst = conn.prepareStatement("INSERT into "
                    + "DISCIPLINA(nombre) VALUES(?)");
            pst.setString(1, d.getNombre());
            
            int resultado = pst.executeUpdate();
            
            if (resultado > 0) {
                bandera = true;
                System.out.println("Agrego una disciplina");
            }
            pst.close();
        } catch (SQLException ex) { System.out.println("Error de SQL: " + ex);}
        finally { cerrarConexion(); }
        
        return bandera;
    }
    
    public boolean modificarDisciplina(Disciplina d) {
        boolean bandera = false;
        
        try {
            abrirConexion();
            PreparedStatement pst = conn.prepareStatement("EXEC PROC_ModificarDisciplina @id_disciplina = ?, @nombre = ?;");
            
            pst.setInt(1, d.getIdDisciplina());
            pst.setString(2, d.getNombre());
            
            int resultado = pst.executeUpdate();
            
            if (resultado > 0) {
                bandera = true;
                System.out.println("Modifico una disciplina");
            }
            pst.close();
        } catch (SQLException e) {}
        finally { cerrarConexion(); }
        
        return bandera;
    }
    
    public boolean modificarEstadoDisciplina(int id) {
        boolean bandera = false;
        
        try {
            abrirConexion();
            PreparedStatement pst = conn.prepareStatement("UPDATE DISCIPLINA SET"
                    + " NOMBRE = CONCAT('NO_ACTIVO-', NOMBRE) WHERE id_disciplina = ?");
            
            pst.setInt(1, id);
            
            int resultado = pst.executeUpdate();
            
            if (resultado > 0) {
                bandera = true;
                System.out.println("Modifico el estado de una disciplina");
            }
            pst.close();
        } catch (SQLException e) {}
        finally { cerrarConexion(); }
        
        return bandera;
    }
    
    public boolean eliminarDisciplina(int id) {
        boolean bandera = false;
        
        try {
            abrirConexion();
            PreparedStatement pst = conn.prepareStatement("DELETE FROM DISCIPLINA WHERE id_disciplina = ?");
            
            pst.setInt(1, id);
            
            int resultado = pst.executeUpdate();
            
            if (resultado > 0) {
                bandera = true;
                System.out.println("Elimino una disciplina");
            }
            pst.close();
        } catch (SQLException e) {}
        finally { cerrarConexion(); }
        
        return bandera;
    }
//    ____                             __             
//   / __ \ ___   ____   ____   _____ / /_ ___   _____
//  / /_/ // _ \ / __ \ / __ \ / ___// __// _ \ / ___/
// / _, _//  __// /_/ // /_/ // /   / /_ /  __/(__  ) 
///_/ |_| \___// .___/ \____//_/    \__/ \___//____/  
//            /_/                                     
    // Listado de todos los pacientes de una disciplina
    public ArrayList<Paciente> obtenerReportePacientesXDisciplina(int idDisciplina) {
        ArrayList<Paciente> pacientes = new ArrayList();
        
        try {
            abrirConexion();
            PreparedStatement ps = conn.prepareStatement("EXEC PROC_Consulta1 @idDisciplina = ?");
            ps.setInt(1, idDisciplina);
            
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()) {
                int idPaciente = rs.getInt("id_paciente");
                String nombre = rs.getString("nombre");
                String apellido = rs.getString("apellido");
                Date fechaNac = rs.getDate("fecha_nac");
                int dni = rs.getInt("dni");
                String direccion = rs.getString("direccion");
                String obraSocial = rs.getString("obra_social");
                String telefono = rs.getString("telefono");
                String telefonoUrg = rs.getString("telefono_urgencia");
                float altura = rs.getFloat("altura");
                float peso = rs.getFloat("peso");
                
                Paciente p = new Paciente(idPaciente, nombre, apellido,
                        new SimpleDateFormat("MM/dd/yyyy").format(fechaNac), dni, direccion, obraSocial, telefono, 
                        telefonoUrg, altura, peso);
                
                pacientes.add(p);
            }
            rs.close();
            ps.close();
        } catch (SQLException ex) {
        } finally {
            cerrarConexion();
        }
        
        return pacientes;
    }
    //Listado para honorarios de los profesionales: 
    //debe mostrar por cada profesional la cantidad total
    //de inscripciones ordenadas.
    public ArrayList<ReporteProfesional> obtenerReporteProfesionales() {
        ArrayList<ReporteProfesional> profesionales = new ArrayList();
        
        try {
            abrirConexion();
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM vista_profesionales order by mes, año, apellido, legajo");
            while(rs.next()) {
                int legajo = rs.getInt("legajo");
                String apellido = rs.getString("apellido");
                String nombre = rs.getString("nombre");
                int ordenes = rs.getInt("ordenes");
                int mes = rs.getInt("MES");
                int anio = rs.getInt("AÑO");
                ReporteProfesional rp = new ReporteProfesional(legajo, apellido, nombre, ordenes, mes, anio);
                
                profesionales.add(rp);
            }
            rs.close();
            st.close();
        } catch (SQLException ex) {
        } finally {
            cerrarConexion();
        }
        
        return profesionales;
    }
//    Listado para honorarios de los instructores: debe mostrar por cada
//    instructor el total de pacientes atendidos, la cantidad y
//    la sumatoria de minutos de todas prácticas controladas.
    public ArrayList<ReporteInstructor> obtenerReporteInstructores() {
        ArrayList<ReporteInstructor> instructores = new ArrayList();
        
        try {
            abrirConexion();
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM vista_instructores");
            while(rs.next()) {
                int legajo = rs.getInt("legajo");
                String apellido = rs.getString("apellido");
                String nombre = rs.getString("nombre");
                int cantPracticasControladas = rs.getInt("cant_practicas_controladas");
                int totalMin = rs.getInt("total_min");
                int pacientesAtendidos = rs.getInt("pacientes_atendidos");
                ReporteInstructor ri = new ReporteInstructor(legajo, apellido, nombre,
                        cantPracticasControladas, totalMin, pacientesAtendidos);
                
                instructores.add(ri);
            }
            rs.close();
            st.close();
        } catch (SQLException ex) {
        } finally {
            cerrarConexion();
        }
        
        return instructores;
    }
//    Consulta de paciente: para un paciente seleccionado mostrar el listado de
//    todas sus inscripciones y las prácticas realizadas indicando 
//    si la suma de minutos y la cantidad de prácticas 
//    cumplen con las solicitadas por el profesional.
    public ArrayList<ReportePaciente> obtenerReportePaciente(int id) {
        ArrayList<ReportePaciente> pacientes = new ArrayList();
        
        try {
            abrirConexion();
            PreparedStatement ps = conn.prepareStatement("EXEC PROC_Consulta4 @idPaciente = ?");
            ps.setInt(1, id);
            
            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
                int idOrden = rs.getInt("id_orden");
                int idInscripcion = rs.getInt("id_inscripcion");
                int idPaciente = rs.getInt("id_paciente");
                String nombre = rs.getString("nombre");
                String apellido = rs.getString("apellido");
                int minMensuales = rs.getInt("min_mensuales");
                int minRestantes = rs.getInt("min_restantes");
                int practicasRestantes = rs.getInt("practicas_restantes");
                String finalizado = rs.getString("finalizado");
                ReportePaciente paciente = new ReportePaciente(idOrden, idInscripcion,
                    idPaciente, nombre, apellido, minMensuales, minRestantes, 
                    practicasRestantes, finalizado);
                
                System.out.println("report pac "+ paciente);
                pacientes.add(paciente);
                
            }
            rs.close();
            ps.close();
        } catch (SQLException ex) {
        } finally {
            cerrarConexion();
        }
        
        return pacientes;
    }
//    
//   ____             __                        
//  / __ \ _____ ____/ /___   ____   ___   _____
// / / / // ___// __  // _ \ / __ \ / _ \ / ___/
/// /_/ // /   / /_/ //  __// / / //  __/(__  ) 
//\____//_/    \__,_/ \___//_/ /_/ \___//____/  
//                                              
    public ArrayList<ListadoOrdenes> obtenerOrdenes() {
        ArrayList<ListadoOrdenes> ordenes = new ArrayList();
        try {
            abrirConexion();
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM vista_ordenes_por_inscripciones");
            while(rs.next()) {
                int idOrden = rs.getInt("id_orden");
                int idPaciente = rs.getInt("id_paciente");
                int idProfesional = rs.getInt("id_profesional");
                int idDisciplina = rs.getInt("id_disciplina");
                int cantPracticas = rs.getInt("cant_practicas");
                int minMensuales = rs.getInt("min_mensuales");
                Date fecha = rs.getDate("fecha");
                String inscripto = rs.getString("inscripto");
                ListadoOrdenes o = new ListadoOrdenes(idOrden, idPaciente, idProfesional, 
                        idPaciente, cantPracticas, minMensuales, 
                        new SimpleDateFormat("MM/dd/yyyy").format(fecha), inscripto);
                
                ordenes.add(o);
            }
            rs.close();
            st.close();
        } catch (SQLException ex) {
        } finally {
            cerrarConexion();
        }
        
        return ordenes;
    }
    
    public boolean agregarOrden(Orden o) {
        boolean bandera = false;
        
        try {
            abrirConexion();
            System.out.println(o.toString());
            PreparedStatement pst = conn.prepareStatement("INSERT into ORDEN"
                    + "(id_paciente,id_profesional,id_disciplina,cant_practicas,min_mensuales)"
                    + " VALUES(?,?,?,?,?)");
            pst.setInt(1, o.getIdPaciente());
            pst.setInt(2, o.getIdProfesional());
            pst.setInt(3, o.getIdDisciplina());
            pst.setInt(4, o.getCantPracticas());
            pst.setInt(5, o.getMinMensuales());
            
            int resultado = pst.executeUpdate();
            
            if (resultado > 0) {
                bandera = true;
                System.out.println("Agrego una orden");
            }
            pst.close();
        } catch (SQLException ex) { System.out.println("Error de SQL: " + ex);}
        finally { cerrarConexion(); }
        
        return bandera;
    }
//
//    ____                          _               _                          
//   /  _/____   _____ _____ _____ (_)____   _____ (_)____   ____   ___   _____
//   / / / __ \ / ___// ___// ___// // __ \ / ___// // __ \ / __ \ / _ \ / ___/
// _/ / / / / /(__  )/ /__ / /   / // /_/ // /__ / // /_/ // / / //  __/(__  ) 
///___//_/ /_//____/ \___//_/   /_// .___/ \___//_/ \____//_/ /_/ \___//____/  
//                                /_/                                          

    public ArrayList<Inscripcion> obtenerInscripciones() {
        ArrayList<Inscripcion> inscripciones = new ArrayList();
        try {
            abrirConexion();
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM Inscripcion");
            while(rs.next()) {
                int idInscripcion = rs.getInt("id_inscripcion");
                int idOrden = rs.getInt("id_orden");
                String usuario = rs.getString("usuario");
                Date fecha = rs.getDate("fecha");
                Inscripcion i = new Inscripcion(idInscripcion, idOrden, usuario,
                        new SimpleDateFormat("MM/dd/yyyy").format(fecha));
                
                inscripciones.add(i);
            }
            rs.close();
            st.close();
        } catch (SQLException ex) {
        } finally {
            cerrarConexion();
        }
        
        return inscripciones;
    }
    
    public boolean agregarInscripcion(int orderId, String usuario) {
        boolean bandera = false;
        
        try {
            abrirConexion();
            PreparedStatement pst = conn.prepareStatement("INSERT into INSCRIPCION"
                    + "(id_orden,usuario)"
                    + " VALUES(?,?)");
            pst.setInt(1, orderId);
            pst.setString(2, usuario);
            
            int resultado = pst.executeUpdate();
            
            if (resultado > 0) {
                bandera = true;
                System.out.println("Agrego una inscripcion");
            }
            pst.close();
        } catch (SQLException ex) { System.out.println("Error de SQL: " + ex);}
        finally { cerrarConexion(); }
        
        return bandera;
    }
}
