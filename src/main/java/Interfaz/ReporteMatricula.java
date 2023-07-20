/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Interfaz;

import Connection.UConnection;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import javax.swing.ComboBoxModel;
import javax.swing.JOptionPane;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author xbest
 */
public class ReporteMatricula extends javax.swing.JFrame {
    
    public ComboBoxModel modeloGrado;

    /**
     * Creates new form ReporteMatricula
     */
    public ReporteMatricula() {
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

        cbReporteNivel = new javax.swing.JComboBox<>();
        cbReporteGrado = new javax.swing.JComboBox<>();
        txtNombreAlumno = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        ycYear = new com.toedter.calendar.JYearChooser();
        btnGenerarReporte = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        cbReporteNivel.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " ", "Inicial", "Primaria", "Secundaria" }));
        cbReporteNivel.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
                cbReporteNivelPopupMenuWillBecomeInvisible(evt);
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
            }
        });

        jLabel1.setText("Estudiante:");

        jLabel2.setText("Nivel:");

        jLabel3.setText("Grado:");

        jLabel4.setText("Year:");

        btnGenerarReporte.setText("Generar Reporte");
        btnGenerarReporte.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGenerarReporteActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel5.setText("FILTRO PARA EL REPORTE");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(102, 102, 102)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(32, 32, 32))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(32, 32, 32))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(cbReporteGrado, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cbReporteNivel, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtNombreAlumno, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(ycYear, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addComponent(btnGenerarReporte)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 38, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(100, 100, 100))
            .addGroup(layout.createSequentialGroup()
                .addGap(74, 74, 74)
                .addComponent(jLabel5)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNombreAlumno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbReporteNivel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbReporteGrado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(ycYear, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(btnGenerarReporte)
                .addGap(23, 23, 23))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnGenerarReporteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGenerarReporteActionPerformed
        // TODO add your handling code here:
        try {
            
            Map<String, Object> params = new HashMap<String, Object>();
            String year = String.valueOf(ycYear.getYear());
            String nivel = obtenerNivel();
            String grado = obtenerGrado();
            if(grado == null){
                grado=" ";
            }
            System.out.println("nivel: " + nivel);
            System.out.println("grado: " + grado);
            
            String rutaimg = System.getProperty("user.dir")+"/src/main/java/Interfaz/logoHD.jpg";
            params.put("url", rutaimg);
            params.put("year", year);
            params.put("nivel", nivel);
            params.put("grado", grado);

            Connection con=UConnection.getConnection();
            
            String rutaReporte=System.getProperty("user.dir")+"/src/main/java/Reportes/ReporteMatriculas.jasper";
            
            JasperReport jasperReport= (JasperReport)JRLoader.loadObjectFromFile(rutaReporte);
            JasperPrint print= JasperFillManager.fillReport(jasperReport,params,con);
//            JasperPrint print= JasperFillManager.fillReport(jasperReport,null,con);
            JasperViewer view = new JasperViewer(print,false);
            view.setVisible(true);
            
            
//            String fileJasper=System.getProperty("user.dir")+"\\src\\Reports\\AlumnosNotasPorCursoBimestreTurno.jrxml";
//            JasperDesign jasperDesign= JRXmlLoader.load(fileJasper);
//            JasperReport jasperReport= JasperCompileManager.compileReport(jasperDesign);
//            JasperPrint jasperPrint= JasperFillManager.fillReport(jasperReport,params,con);
//            JasperViewer jasperViewer = new JasperViewer(jasperPrint,true);
//            jasperViewer.setVisible(true);
            
        } catch (Exception e) {
            
             JOptionPane.showMessageDialog(null,e.getMessage(),"Aviso",JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnGenerarReporteActionPerformed

    private void cbReporteNivelPopupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_cbReporteNivelPopupMenuWillBecomeInvisible
        // TODO add your handling code here:
        String nivel = (String) cbReporteNivel.getSelectedItem();
        switch (nivel) {
            case "Inicial":
                Inicial();
                break;
            case "Primaria":
                Primaria();
                break;
            case "Secundaria":
                Secundaria();
                break;
            default:
                throw new AssertionError();
        }
    }//GEN-LAST:event_cbReporteNivelPopupMenuWillBecomeInvisible

    public String obtenerNivel(){
        String nivel = (String) cbReporteNivel.getSelectedItem();
        return String.valueOf(nivel.charAt(0));
    }

    public String obtenerGrado(){
        String grado = (String) cbReporteGrado.getSelectedItem();
        return String.valueOf(grado.charAt(0));
    }
    
    public void Inicial(){
        ArrayList<Character> gr = new ArrayList<>();
        for(int i = 3; i<6; i++){
            gr.add(String.valueOf(i).charAt(0));
        }
        HashSet<Character> hashset = new HashSet<>();
        hashset.addAll(gr);
        gr = new ArrayList<>(hashset);
        Collections.sort(gr);
        cbReporteGrado.removeAllItems();
        for (Character ch : gr) {
            cbReporteGrado.addItem(String.valueOf(ch) + " años");
        }
    }
    
    public void Primaria(){
        ArrayList<Character> gr = new ArrayList<>();
        for(int i = 1; i<7; i++){
            gr.add(String.valueOf(i).charAt(0));
        }
        HashSet<Character> hashset = new HashSet<>();
        hashset.addAll(gr);
        gr = new ArrayList<>(hashset);
        Collections.sort(gr);
        cbReporteGrado.removeAllItems();
        for (Character ch : gr) {
            cbReporteGrado.addItem(String.valueOf(ch) + "' grado");
        }
    }
    
    public void Secundaria(){
        ArrayList<Character> gr = new ArrayList<>();
        for(int i = 1; i<6; i++){
            gr.add(String.valueOf(i).charAt(0));
        }
        HashSet<Character> hashset = new HashSet<>();
        hashset.addAll(gr);
        gr = new ArrayList<>(hashset);
        Collections.sort(gr);
        cbReporteGrado.removeAllItems();
        for (Character ch : gr) {
            cbReporteGrado.addItem(String.valueOf(ch) + "' grado");
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
            java.util.logging.Logger.getLogger(ReporteMatricula.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ReporteMatricula.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ReporteMatricula.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ReporteMatricula.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ReporteMatricula().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnGenerarReporte;
    private javax.swing.JComboBox<String> cbReporteGrado;
    private javax.swing.JComboBox<String> cbReporteNivel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JTextField txtNombreAlumno;
    private com.toedter.calendar.JYearChooser ycYear;
    // End of variables declaration//GEN-END:variables
}
