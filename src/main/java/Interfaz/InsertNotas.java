/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Interfaz;

import BusinessLayer.AlumnoBO;
import BusinessLayer.AsistenciaDocenteBO;
import BusinessLayer.CursoBO;
import BusinessLayer.DocenteBO;
import BusinessLayer.HistorialNotasBO;
import BusinessLayer.NotasBO;
import BusinessLayer.UsuarioBO;
import JavaBean.Alumno;
import JavaBean.AsistenciaDocente;
import JavaBean.Curso;
import JavaBean.Docente;
import JavaBean.HistorialNotas;
import JavaBean.Notas;
import JavaBean.Usuario;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import java.util.Collections;
import java.util.HashSet;
import javax.swing.JOptionPane;

/**
 *
 * @author black
 */
public class InsertNotas extends javax.swing.JFrame {

    private AsistenciaDocente adocente = new AsistenciaDocente();
    private Docente docente = new Docente();
    private Usuario usuario = new Usuario();
    private Notas notas = new Notas();
    private int codigoHnotas = -1;
    
    /// BUSSINESSLAYER
    private AsistenciaDocenteBO asisdocBO = new AsistenciaDocenteBO();
    private DocenteBO docenteBO = new DocenteBO();
    private UsuarioBO usuarioBO = new UsuarioBO();
    private CursoBO cursoBO = new CursoBO();
    private NotasBO notasBO = new NotasBO();
    private HistorialNotasBO hnotasBO = new HistorialNotasBO();
    private AlumnoBO alumBO = new AlumnoBO();
    
    /// ARRAYS
    private ArrayList<Curso> cursosXNivel = new ArrayList<>();
    private ArrayList<Curso> cursosXGrado = new ArrayList<>();
    public static ArrayList<String> dniUsuarios = new ArrayList<>();
    private ArrayList<HistorialNotas> hnotaslist = new ArrayList<>();
    private ArrayList<Alumno> alumnosXCurso = new ArrayList<>();
    
    /// MODELOS DE TABLAS
    private DefaultTableModel modeloAdocentes = new DefaultTableModel();
    private DefaultTableModel modeloUsuarios = new DefaultTableModel();
    private DefaultTableModel modeloNotas = new DefaultTableModel();
    private DefaultTableModel modeloAlumnosxCurso = new DefaultTableModel();
    
    /**
     * Creates new form InsertNotas
     */
    public InsertNotas() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        cbCursoNotaInsert = new javax.swing.JComboBox<>();
        cbNivelNotaInsert = new javax.swing.JComboBox<>();
        cbGradoNotaInsert = new javax.swing.JComboBox<>();
        jLabel21 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblAlumnosDelCurso = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        txtNota5 = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtNota4 = new javax.swing.JTextField();
        txtNota3 = new javax.swing.JTextField();
        txtNota2 = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtNota1 = new javax.swing.JTextField();
        btnInsertarNotas = new javax.swing.JButton();
        btnDescartarNotas = new javax.swing.JButton();
        txtAlumnoNombreNotaInsertar = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txtBuscarNombre = new javax.swing.JTextField();
        btnBuscarAlumno = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Seleccionar Alumno"));

        cbCursoNotaInsert.setEnabled(false);
        cbCursoNotaInsert.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
                cbCursoNotaInsertPopupMenuWillBecomeInvisible(evt);
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
            }
        });

        cbNivelNotaInsert.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Inicial", "Primaria", "Secundaria" }));
        cbNivelNotaInsert.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
                cbNivelNotaInsertPopupMenuWillBecomeInvisible(evt);
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
            }
        });

        cbGradoNotaInsert.setEnabled(false);
        cbGradoNotaInsert.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
                cbGradoNotaInsertPopupMenuWillBecomeInvisible(evt);
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
            }
        });

        jLabel21.setText("Nivel:");

        jLabel23.setText("Grado:");

        jLabel22.setText("Curso:");

        tblAlumnosDelCurso.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Alumnos"
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
        tblAlumnosDelCurso.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblAlumnosDelCursoMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblAlumnosDelCurso);
        if (tblAlumnosDelCurso.getColumnModel().getColumnCount() > 0) {
            tblAlumnosDelCurso.getColumnModel().getColumn(0).setResizable(false);
        }

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel22))
                        .addGap(1, 1, 1)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cbGradoNotaInsert, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbCursoNotaInsert, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbNivelNotaInsert, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(110, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel21, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(cbNivelNotaInsert, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbGradoNotaInsert, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel23))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel22)
                    .addComponent(cbCursoNotaInsert, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 376, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Insertar Notas"));
        jPanel3.setMaximumSize(new java.awt.Dimension(275, 680));
        jPanel3.setMinimumSize(new java.awt.Dimension(275, 680));
        jPanel3.setName(""); // NOI18N
        jPanel3.setPreferredSize(new java.awt.Dimension(275, 680));

        jLabel7.setText("Nota 5: ");

        jLabel8.setText("Nota 4: ");

        jLabel6.setText("Nota 3: ");

        jLabel5.setText("Nota 2: ");

        jLabel4.setText("Nota 1: ");

        btnInsertarNotas.setText("Insertar");
        btnInsertarNotas.setEnabled(false);
        btnInsertarNotas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInsertarNotasActionPerformed(evt);
            }
        });

        btnDescartarNotas.setText("Descartar");
        btnDescartarNotas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDescartarNotasActionPerformed(evt);
            }
        });

        txtAlumnoNombreNotaInsertar.setEnabled(false);
        txtAlumnoNombreNotaInsertar.setMaximumSize(new java.awt.Dimension(250, 22));
        txtAlumnoNombreNotaInsertar.setMinimumSize(new java.awt.Dimension(250, 22));
        txtAlumnoNombreNotaInsertar.setName(""); // NOI18N
        txtAlumnoNombreNotaInsertar.setPreferredSize(new java.awt.Dimension(250, 22));

        jLabel1.setText("Alumno:");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(60, 60, 60)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtNota1, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtNota2, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtNota3, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtNota4, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtNota5, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(42, 42, 42)
                        .addComponent(btnInsertarNotas)
                        .addGap(28, 28, 28)
                        .addComponent(btnDescartarNotas)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(txtAlumnoNombreNotaInsertar, javax.swing.GroupLayout.DEFAULT_SIZE, 265, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtAlumnoNombreNotaInsertar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtNota1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtNota2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtNota3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(txtNota4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txtNota5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnInsertarNotas)
                    .addComponent(btnDescartarNotas))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder("Buscar"));

        jLabel2.setText("Nombres:");

        txtBuscarNombre.setEnabled(false);

        btnBuscarAlumno.setText("Buscar");
        btnBuscarAlumno.setEnabled(false);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtBuscarNombre)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnBuscarAlumno)
                .addGap(96, 96, 96))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtBuscarNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnBuscarAlumno)
                .addContainerGap(10, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(46, 46, 46))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnDescartarNotasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDescartarNotasActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_btnDescartarNotasActionPerformed

    private void cbCursoNotaInsertPopupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_cbCursoNotaInsertPopupMenuWillBecomeInvisible
        try {
            // TODO add your handling code here:
            String name= cursosXGrado.get(0).getNombre();
            String grado = String.valueOf(cursosXGrado.get(0).getGrado());
            String nivel = String.valueOf(cbNivelNotaInsert.getItemAt(cbNivelNotaInsert.getSelectedIndex()).charAt(0));
            alumnosXCurso = alumBO.buscarPorAlumnoxCurso(name,grado,nivel);
            mostrarTablaAlumnosDelCurso(alumnosXCurso);
            if(alumnosXCurso.size()>=1){
                txtBuscarNombre.setEnabled(true);
                btnBuscarAlumno.setEnabled(true);
            }
        } catch (Exception ex) {
            Logger.getLogger(Inicio.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_cbCursoNotaInsertPopupMenuWillBecomeInvisible

    private void cbGradoNotaInsertPopupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_cbGradoNotaInsertPopupMenuWillBecomeInvisible
        try {
            // TODO add your handling code here:
            char val = String.valueOf(cbGradoNotaInsert.getSelectedItem()).charAt(0);
            cursosXGrado = cursoBO.buscarPorGrado(String.valueOf(cursosXNivel.get(0).getNivel()), String.valueOf(val));
        } catch (Exception ex) {
            System.out.println(ex);
            Logger.getLogger(Inicio.class.getName()).log(Level.SEVERE, null, ex);
        }
        cbCursoNotaInsert.removeAllItems();
        for(Curso cg: cursosXGrado){
            cbCursoNotaInsert.addItem(cg.getNombre());
        }
        cbCursoNotaInsert.setEnabled(true);
    }//GEN-LAST:event_cbGradoNotaInsertPopupMenuWillBecomeInvisible

    private void cbNivelNotaInsertPopupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_cbNivelNotaInsertPopupMenuWillBecomeInvisible
        // TODO add your handling code here:
        int fila = cbNivelNotaInsert.getSelectedIndex();
        switch (fila) {
            case 0 -> {
                try {
                    cursosXNivel = cursoBO.buscarPorNivel("I");
                } catch (Exception ex) {
                    System.out.println(ex);
                    Logger.getLogger(Inicio.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

            case 1 -> {
                try {
                    cursosXNivel = cursoBO.buscarPorNivel("P");
                } catch (Exception ex) {
                    System.out.println(ex);
                    Logger.getLogger(Inicio.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

            case 2 -> {
                try {
                    cursosXNivel = cursoBO.buscarPorNivel("S");
                } catch (Exception ex) {
                    System.out.println(ex);
                    Logger.getLogger(Inicio.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

            default -> throw new AssertionError();
        }
        ArrayList<Character> gr = new ArrayList<>();
        for(Curso c : cursosXNivel){
            gr.add(c.getGrado());
        }
        HashSet<Character> hashset = new HashSet<>();
        hashset.addAll(gr);
        gr = new ArrayList<>(hashset);
        Collections.sort(gr);
        cbGradoNotaInsert.removeAllItems();
        for(Character ch : gr){
            cbGradoNotaInsert.addItem(String.valueOf(ch)+"' grado");
        }
        cbGradoNotaInsert.setEnabled(true);
    }//GEN-LAST:event_cbNivelNotaInsertPopupMenuWillBecomeInvisible

    private void btnInsertarNotasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInsertarNotasActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_btnInsertarNotasActionPerformed

    private void tblAlumnosDelCursoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblAlumnosDelCursoMouseClicked
        // TODO add your handling code here:
        if(tblAlumnosDelCurso.getSelectedRow()!=-1){
            txtAlumnoNombreNotaInsertar.setText(alumnosXCurso.get(tblAlumnosDelCurso.getSelectedRow()).getApellidosNombres());
            btnInsertarNotas.setEnabled(true);
            inicializarNotas();
        }
    }//GEN-LAST:event_tblAlumnosDelCursoMouseClicked

    ///
    ///////    Funciones
    ///
    
    public void mostrarTablaAlumnosDelCurso(ArrayList<Alumno> alucurso){
        modeloNotas = (DefaultTableModel) tblAlumnosDelCurso.getModel();
        modeloNotas.setRowCount(0);
        
        System.out.println(alucurso.size());
        try {
            for (Alumno hhh : alucurso) {
                Object [] fila = new Object[] {hhh.getApellidosNombres()};
                modeloNotas.addRow(fila);
            }
            tblAlumnosDelCurso.setModel(modeloNotas);
        } catch (Exception e) {
            System.out.println(e);
            System.out.println(e.getMessage());
        }
    }
    
    
    public void inicializarNotas(){
        txtNota1.setText("0");
        txtNota2.setText("0");
        txtNota3.setText("0");
        txtNota4.setText("0");
        txtNota5.setText("0");
    }
    
    public void obtenerValores() throws Exception{
        boolean ver = false;
        double n1=0,n2=0,n3=0,n4=0,n5=0;
        notas = null;
        notas.setHistorial_notas_id(1);
        try {
            n1 = Double.parseDouble(txtNota1.getText());
            n2 = Double.parseDouble(txtNota2.getText());
            n3 = Double.parseDouble(txtNota3.getText());
            n4 = Double.parseDouble(txtNota4.getText());
            n5 = Double.parseDouble(txtNota5.getText());
            ver = true;
        } catch (Exception e) {
            System.out.println(e);
            JOptionPane.showMessageDialog(null, "Error en las notas, verifique los valores");
        }
        
        if(ver){
            notas.setNota1(n1);
            notas.setNota2(n2);
            notas.setNota3(n3);
            notas.setNota4(n4);
            notas.setNota5(n5);
            try {
                notasBO.insertar(notas);
            } catch (Exception e) {
                System.out.println(e);
            }
            
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
            java.util.logging.Logger.getLogger(InsertNotas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(InsertNotas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(InsertNotas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(InsertNotas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new InsertNotas().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscarAlumno;
    private javax.swing.JButton btnDescartarNotas;
    private javax.swing.JButton btnInsertarNotas;
    private javax.swing.JComboBox<String> cbCursoNotaInsert;
    private javax.swing.JComboBox<String> cbGradoNotaInsert;
    private javax.swing.JComboBox<String> cbNivelNotaInsert;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblAlumnosDelCurso;
    private javax.swing.JTextField txtAlumnoNombreNotaInsertar;
    private javax.swing.JTextField txtBuscarNombre;
    private javax.swing.JTextField txtNota1;
    private javax.swing.JTextField txtNota2;
    private javax.swing.JTextField txtNota3;
    private javax.swing.JTextField txtNota4;
    private javax.swing.JTextField txtNota5;
    // End of variables declaration//GEN-END:variables
}
