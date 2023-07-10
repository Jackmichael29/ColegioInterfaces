/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Interfaz;

import BusinessLayer.AlumnoApoderadoBO;
import BusinessLayer.AlumnoBO;
import BusinessLayer.ApoderadoBO;
import BusinessLayer.AsistenciaAlumnoBO;
import BusinessLayer.CursoBO;
import BusinessLayer.HistorialNotasBO;
import JavaBean.Alumno;
import JavaBean.Apoderado;
import JavaBean.AsistenciaAlumno;
import JavaBean.Curso;
import JavaBean.alumnoApoderado;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author black
 */
public class VentanaHistorialAsistenciaAlumnos extends javax.swing.JFrame {

    /**
     * Creates new form VentanaAlumnoApoderado
     */
    public VentanaHistorialAsistenciaAlumnos() {
        initComponents();
        modeloHistorialAsistencia = (DefaultTableModel) jtblHistorialAsistenciasAlumnos.getModel();
        try {
            asistenciaAlumnos = asisalumBO.listarAsistenciaAlumno();
            System.out.println(asistenciaAlumnos.size());
            alumnos = alumBO.buscarPorAlumno("");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        actualizarTablaHistorialAsistenciaAlumnos(asistenciaAlumnos);
        actualizarTablaFiltroAlumnos(alumnos);
    }
    
    ArrayList<Character> gr = new ArrayList<>();
    ArrayList<Character> gr1 = new ArrayList<>();
    
    private ArrayList<Curso> cursosXNivel = new ArrayList<>();
    private ArrayList<Curso> cursosXNivelA = new ArrayList<>();
    private ArrayList<Curso> cursosXGrado = new ArrayList<>();
    private DefaultTableModel modeloHistorialAsistencia;
    private DefaultTableModel modeloHistorialAsistencia2;
    private DefaultTableModel modeloHistorialAsistencia3;
    private DefaultTableModel modeloFiltroAlumnos;
    private AlumnoBO alumBO = new AlumnoBO();
    private AsistenciaAlumnoBO asisalumBO = new AsistenciaAlumnoBO();
    private ArrayList<Alumno> alumnos;
    private ArrayList<AsistenciaAlumno> asistenciaAlumnos;
    private String nivelF="I";
    private String nivelF1="I";
    
    
    private CursoBO cursoBO = new CursoBO();

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jScrollPane6 = new javax.swing.JScrollPane();
        jtblHistorialAsistenciasAlumnos = new javax.swing.JTable();
        jLabel5 = new javax.swing.JLabel();
        tfAlumnoFiltro = new javax.swing.JTextField();
        tfFechaFiltro = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        cbNivelHistorialAsistenciaAlumnos = new javax.swing.JComboBox<>();
        ckbFechaFiltro = new javax.swing.JCheckBox();
        dcCalendarHistorialAsistenciaAlumnos = new com.toedter.calendar.JDateChooser();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        cbGradoHistorialAsistenciaAlumnos = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane8 = new javax.swing.JScrollPane();
        jtblFiltroAlumnos = new javax.swing.JTable();
        btnBuscarFiltroAlumno = new javax.swing.JButton();
        txtFiltroAlumnoNombres = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        cbNivelFiltroAlumnos = new javax.swing.JComboBox<>();
        cbGradoFiltroAlumnos = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Historial Asistencia"));

        jtblHistorialAsistenciasAlumnos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "DNI", "Apellidos y Nombres", "Observacion"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jtblHistorialAsistenciasAlumnos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtblHistorialAsistenciasAlumnosMouseClicked(evt);
            }
        });
        jScrollPane6.setViewportView(jtblHistorialAsistenciasAlumnos);
        if (jtblHistorialAsistenciasAlumnos.getColumnModel().getColumnCount() > 0) {
            jtblHistorialAsistenciasAlumnos.getColumnModel().getColumn(0).setResizable(false);
            jtblHistorialAsistenciasAlumnos.getColumnModel().getColumn(0).setPreferredWidth(60);
            jtblHistorialAsistenciasAlumnos.getColumnModel().getColumn(0).setHeaderValue("DNI");
            jtblHistorialAsistenciasAlumnos.getColumnModel().getColumn(1).setPreferredWidth(150);
            jtblHistorialAsistenciasAlumnos.getColumnModel().getColumn(2).setPreferredWidth(60);
            jtblHistorialAsistenciasAlumnos.getColumnModel().getColumn(2).setHeaderValue("Observacion");
        }

        jLabel5.setText("Alumno:");

        tfAlumnoFiltro.setText("Todos");
        tfAlumnoFiltro.setEnabled(false);

        tfFechaFiltro.setText("Historico");
        tfFechaFiltro.setEnabled(false);

        jLabel6.setText("Fecha:");

        cbNivelHistorialAsistenciaAlumnos.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Inicial", "Primaria", "Secundaria" }));
        cbNivelHistorialAsistenciaAlumnos.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
                cbNivelHistorialAsistenciaAlumnosPopupMenuWillBecomeInvisible(evt);
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
            }
        });

        jLabel1.setText("Fecha:");

        jLabel3.setText("Nivel:");

        cbGradoHistorialAsistenciaAlumnos.setEnabled(false);
        cbGradoHistorialAsistenciaAlumnos.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
                cbGradoHistorialAsistenciaAlumnosPopupMenuWillBecomeInvisible(evt);
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
            }
        });

        jLabel4.setText("Grado:");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tfAlumnoFiltro)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tfFechaFiltro, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap(21, Short.MAX_VALUE)
                        .addComponent(dcCalendarHistorialAsistenciaAlumnos, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ckbFechaFiltro)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(72, 72, 72)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(cbNivelHistorialAsistenciaAlumnos, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(cbGradoHistorialAsistenciaAlumnos, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(cbNivelHistorialAsistenciaAlumnos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(cbGradoHistorialAsistenciaAlumnos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(dcCalendarHistorialAsistenciaAlumnos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ckbFechaFiltro, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel6)
                        .addComponent(tfFechaFiltro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel5)
                        .addComponent(tfAlumnoFiltro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 413, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder("Filtrar por Alumno"));

        jtblFiltroAlumnos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null},
                {null},
                {null},
                {null}
            },
            new String [] {
                "Apellidos y Nombres"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jtblFiltroAlumnos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtblFiltroAlumnosMouseClicked(evt);
            }
        });
        jScrollPane8.setViewportView(jtblFiltroAlumnos);
        if (jtblFiltroAlumnos.getColumnModel().getColumnCount() > 0) {
            jtblFiltroAlumnos.getColumnModel().getColumn(0).setPreferredWidth(150);
        }

        btnBuscarFiltroAlumno.setText("Buscar");
        btnBuscarFiltroAlumno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarFiltroAlumnoActionPerformed(evt);
            }
        });

        jLabel2.setText("Nombres:");

        cbNivelFiltroAlumnos.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Inicial", "Primaria", "Secundaria" }));
        cbNivelFiltroAlumnos.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
                cbNivelFiltroAlumnosPopupMenuWillBecomeInvisible(evt);
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
            }
        });

        cbGradoFiltroAlumnos.setEnabled(false);
        cbGradoFiltroAlumnos.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
                cbGradoFiltroAlumnosPopupMenuWillBecomeInvisible(evt);
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
            }
        });

        jLabel7.setText("Grado:");

        jLabel8.setText("Nivel:");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGap(12, 12, 12)
                                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cbNivelFiltroAlumnos, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cbGradoFiltroAlumnos, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtFiltroAlumnoNombres, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnBuscarFiltroAlumno)))
                        .addGap(0, 11, Short.MAX_VALUE))))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(jLabel7)
                    .addComponent(cbNivelFiltroAlumnos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbGradoFiltroAlumnos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtFiltroAlumnoNombres, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(btnBuscarFiltroAlumno))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 427, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jPanel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jtblHistorialAsistenciasAlumnosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtblHistorialAsistenciasAlumnosMouseClicked
        // TODO add your handling code here:
            
    }//GEN-LAST:event_jtblHistorialAsistenciasAlumnosMouseClicked

    private void btnBuscarFiltroAlumnoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarFiltroAlumnoActionPerformed
        try {
            alumnos = alumBO.buscarPorAlumno(txtFiltroAlumnoNombres.getText());
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        actualizarTablaFiltroAlumnos(alumnos);
    }//GEN-LAST:event_btnBuscarFiltroAlumnoActionPerformed

    private void jtblFiltroAlumnosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtblFiltroAlumnosMouseClicked
        // TODO add your handling code here:
        int index = jtblFiltroAlumnos.getSelectedRow();
        try {
            asistenciaAlumnos = asisalumBO.buscarAsistenciaAlumnoPorAlumnoId(alumnos.get(index).getAlumno_id());
        } catch (Exception ex) {
            System.out.println(ex);
            Logger.getLogger(VentanaHistorialAsistenciaAlumnos.class.getName()).log(Level.SEVERE, null, ex);
        }
        tfAlumnoFiltro.setText(alumnos.get(index).getApellidosNombres());
        actualizarTablaHistorialAsistenciaAlumnosFiltroNombre(asistenciaAlumnos);
    }//GEN-LAST:event_jtblFiltroAlumnosMouseClicked

    private void cbNivelFiltroAlumnosPopupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_cbNivelFiltroAlumnosPopupMenuWillBecomeInvisible
        // TODO add your handling code here:
        int fila = cbNivelFiltroAlumnos.getSelectedIndex();
        System.out.println("Seleccionando =" + fila);
        switch (fila) {
            case 0 -> {
                try {
                    cursosXNivelA = cursoBO.buscarPorNivel("I");
                    nivelF1="I";
                } catch (Exception ex) {
                    System.out.println(ex);
                    Logger.getLogger(Inicio.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

            case 1 -> {
                try {
                    cursosXNivelA = cursoBO.buscarPorNivel("P");
                    nivelF1="P";
                    System.out.println(nivelF1);
                } catch (Exception ex) {
                    System.out.println(ex);
                    Logger.getLogger(Inicio.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

            case 2 -> {
                try {
                    cursosXNivelA = cursoBO.buscarPorNivel("S");
                    nivelF1="S";
                } catch (Exception ex) {
                    System.out.println(ex);
                    Logger.getLogger(Inicio.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

            default -> throw new AssertionError();
        }
        for(Curso c : cursosXNivelA){
            gr1.add(c.getGrado());
        }
        HashSet<Character> hashset = new HashSet<>();
        hashset.addAll(gr1);
        gr1 = new ArrayList<>(hashset);
        Collections.sort(gr1);
        cbGradoFiltroAlumnos.removeAllItems();
        for(Character ch : gr1){
            System.out.println("Willgo sleeap=== " + String.valueOf(ch)+"' grado");
            cbGradoFiltroAlumnos.addItem(String.valueOf(ch)+"' grado");
        }
        cbGradoFiltroAlumnos.setEnabled(true);
    }//GEN-LAST:event_cbNivelFiltroAlumnosPopupMenuWillBecomeInvisible

    private void cbGradoHistorialAsistenciaAlumnosPopupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_cbGradoHistorialAsistenciaAlumnosPopupMenuWillBecomeInvisible
        // TODO add your handling code here:
        int selectedIndex = cbGradoHistorialAsistenciaAlumnos.getSelectedIndex();
        Date fechaFiltro;
        
        if(ckbFechaFiltro.isSelected()){
            fechaFiltro = dcCalendarHistorialAsistenciaAlumnos.getDate();
            System.out.println("fechita === " + dcCalendarHistorialAsistenciaAlumnos.getDateFormatString());
            java.sql.Date sqlDate = (java.sql.Date) java.sql.Date.valueOf(new SimpleDateFormat("yyyy-MM-dd").format(fechaFiltro));
            System.out.println("sql === " + sqlDate);
            try {
                asistenciaAlumnos = asisalumBO.listarAsistenciaGrupoFecha(sqlDate,nivelF, String.valueOf(gr.get(selectedIndex)));
                actualizarTablaHistorialAsistenciaAlumnosFiltroFecha(asistenciaAlumnos);
            } catch (Exception ex) {
                System.out.println(ex);
                Logger.getLogger(VentanaHistorialAsistenciaAlumnos.class.getName()).log(Level.SEVERE, null, ex);
            }
        }else{
            try {
                asistenciaAlumnos = asisalumBO.listarAsistenciaGrupo(nivelF,String.valueOf(gr.get(selectedIndex)));
                actualizarTablaHistorialAsistenciaAlumnosFiltroNG(asistenciaAlumnos);
            } catch (Exception ex) {
                System.out.println(ex);
                Logger.getLogger(VentanaHistorialAsistenciaAlumnos.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
    }//GEN-LAST:event_cbGradoHistorialAsistenciaAlumnosPopupMenuWillBecomeInvisible

    private void cbNivelHistorialAsistenciaAlumnosPopupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_cbNivelHistorialAsistenciaAlumnosPopupMenuWillBecomeInvisible
        // TODO add your handling code here:
        int fila = cbNivelHistorialAsistenciaAlumnos.getSelectedIndex();
        switch (fila) {
            case 0 -> {
                try {
                    cursosXNivel = cursoBO.buscarPorNivel("I");
                    nivelF="I";
                } catch (Exception ex) {
                    System.out.println(ex);
                    Logger.getLogger(Inicio.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

            case 1 -> {
                try {
                    cursosXNivel = cursoBO.buscarPorNivel("P");
                    nivelF="P";
                } catch (Exception ex) {
                    System.out.println(ex);
                    Logger.getLogger(Inicio.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

            case 2 -> {
                try {
                    cursosXNivel = cursoBO.buscarPorNivel("S");
                    nivelF="S";
                } catch (Exception ex) {
                    System.out.println(ex);
                    Logger.getLogger(Inicio.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

            default -> throw new AssertionError();
        }
        
        for(Curso c : cursosXNivel){
            gr.add(c.getGrado());
        }
        HashSet<Character> hashset = new HashSet<>();
        hashset.addAll(gr);
        gr = new ArrayList<>(hashset);
        Collections.sort(gr);
        cbGradoHistorialAsistenciaAlumnos.removeAllItems();
        for(Character ch : gr){
            cbGradoHistorialAsistenciaAlumnos.addItem(String.valueOf(ch)+"' grado");
        }
        cbGradoHistorialAsistenciaAlumnos.setEnabled(true);
        
        
    }//GEN-LAST:event_cbNivelHistorialAsistenciaAlumnosPopupMenuWillBecomeInvisible

    private void cbGradoFiltroAlumnosPopupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_cbGradoFiltroAlumnosPopupMenuWillBecomeInvisible
        try {
            // TODO add your handling code here:
            alumnos = alumBO.buscarPorAlumnoxSalon(String.valueOf(gr1.get(cbGradoFiltroAlumnos.getSelectedIndex())), nivelF1);
        } catch (Exception ex) {
            System.out.println(ex);
            Logger.getLogger(VentanaHistorialAsistenciaAlumnos.class.getName()).log(Level.SEVERE, null, ex);
        }
        actualizarTablaFiltroAlumnos(alumnos);
                
    }//GEN-LAST:event_cbGradoFiltroAlumnosPopupMenuWillBecomeInvisible

    private void actualizarTablaHistorialAsistenciaAlumnos(ArrayList<AsistenciaAlumno> listaAsistentes) {
        modeloHistorialAsistencia.setRowCount(0);
        tfFechaFiltro.setText("Historico");
        tfAlumnoFiltro.setText("Todos");
        
        try {
            for(AsistenciaAlumno aa: listaAsistentes){
                Alumno a = alumBO.buscarPorId(aa.getAlumno_id());
                System.out.println("Imprimiendo valor wanna sleep: " + aa.getAlumno_id());
                Object[] fila = new Object[]{a.getDni(), a.getApellidosNombres(), aa.getObservacion()};
                modeloHistorialAsistencia.addRow(fila);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        jtblHistorialAsistenciasAlumnos.setModel(modeloHistorialAsistencia);
    }
    
    private void actualizarTablaHistorialAsistenciaAlumnosFiltroFecha(ArrayList<AsistenciaAlumno> listaAsistentes) {
        modeloHistorialAsistencia.setRowCount(0);
        tfFechaFiltro.setText(String.valueOf(listaAsistentes.get(0).getFecha()));
        
        try {
            for(AsistenciaAlumno aa: listaAsistentes){
                Alumno a = alumBO.buscarPorId(aa.getAlumno_id());
                Object[] fila = new Object[]{a.getDni(), a.getApellidosNombres(), aa.getObservacion()};
                modeloHistorialAsistencia.addRow(fila);
            }
        } catch (Exception e) {
            System.out.println(e);
            System.out.println(e.getMessage());
        }
        jtblHistorialAsistenciasAlumnos.setModel(modeloHistorialAsistencia);
    }
    
    private void actualizarTablaHistorialAsistenciaAlumnosFiltroNG(ArrayList<AsistenciaAlumno> listaAsistentes) {
        modeloHistorialAsistencia3 = new DefaultTableModel();
        modeloHistorialAsistencia3.addColumn("ID Asistencia");
        modeloHistorialAsistencia3.addColumn("Alumno");
        modeloHistorialAsistencia3.addColumn("Fecha");
        modeloHistorialAsistencia3.addColumn("Observacion");
        modeloHistorialAsistencia3.setRowCount(0);
        tfFechaFiltro.setText("Historico");
        tfAlumnoFiltro.setText("Todos");
        
        try {
            for(AsistenciaAlumno aa: listaAsistentes){
                Alumno a = alumBO.buscarPorId(aa.getAlumno_id());
                Object[] fila = new Object[]{aa.getAsistencia_alumno_id(), a.getApellidosNombres(), aa.getFecha(), aa.getObservacion()};
                modeloHistorialAsistencia3.addRow(fila);
            }
        } catch (Exception e) {
            System.out.println(e);
            System.out.println(e.getMessage());
        }
        jtblHistorialAsistenciasAlumnos.setModel(modeloHistorialAsistencia3);
    }
    
    private void actualizarTablaHistorialAsistenciaAlumnosFiltroNombre(ArrayList<AsistenciaAlumno> listaAsistentes) {       
        modeloHistorialAsistencia2 = new DefaultTableModel();
        modeloHistorialAsistencia2.addColumn("ID Asistencia");
        modeloHistorialAsistencia2.addColumn("Fecha");
        modeloHistorialAsistencia2.addColumn("Observacion");
        modeloHistorialAsistencia2.setRowCount(0);
        System.out.println("say hi");
        
        try {
            for(AsistenciaAlumno aa: listaAsistentes){
                Object[] fila = new Object[]{aa.getAsistencia_alumno_id(),aa.getFecha(), aa.getObservacion()};
                modeloHistorialAsistencia2.addRow(fila);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        jtblHistorialAsistenciasAlumnos.setModel(modeloHistorialAsistencia2);
    }
    
    private void actualizarTablaFiltroAlumnos(ArrayList<Alumno> listaFiltroAlumnos) {       
        modeloFiltroAlumnos = (DefaultTableModel) jtblFiltroAlumnos.getModel();
        modeloFiltroAlumnos.setRowCount(0);
        
        try {
            for(Alumno a: listaFiltroAlumnos){
                
                Object[] fila = new Object[]{a.getApellidosNombres()};
                modeloFiltroAlumnos.addRow(fila);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(VentanaHistorialAsistenciaAlumnos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VentanaHistorialAsistenciaAlumnos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VentanaHistorialAsistenciaAlumnos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VentanaHistorialAsistenciaAlumnos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VentanaHistorialAsistenciaAlumnos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscarFiltroAlumno;
    private javax.swing.JComboBox<String> cbGradoFiltroAlumnos;
    private javax.swing.JComboBox<String> cbGradoHistorialAsistenciaAlumnos;
    private javax.swing.JComboBox<String> cbNivelFiltroAlumnos;
    private javax.swing.JComboBox<String> cbNivelHistorialAsistenciaAlumnos;
    private javax.swing.JCheckBox ckbFechaFiltro;
    private com.toedter.calendar.JDateChooser dcCalendarHistorialAsistenciaAlumnos;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JTable jtblFiltroAlumnos;
    private javax.swing.JTable jtblHistorialAsistenciasAlumnos;
    private javax.swing.JTextField tfAlumnoFiltro;
    private javax.swing.JTextField tfFechaFiltro;
    private javax.swing.JTextField txtFiltroAlumnoNombres;
    // End of variables declaration//GEN-END:variables
}
