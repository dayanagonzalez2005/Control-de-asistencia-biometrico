/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentacion;

import BD.ConexionBD;
import BD.MetodosDao;
import com.digitalpersona.onetouch.DPFPDataPurpose;
import com.digitalpersona.onetouch.DPFPFeatureSet;
import com.digitalpersona.onetouch.DPFPGlobal;
import com.digitalpersona.onetouch.DPFPSample;
import com.digitalpersona.onetouch.DPFPTemplate;
import com.digitalpersona.onetouch.capture.DPFPCapture;
import com.digitalpersona.onetouch.capture.event.DPFPDataAdapter;
import com.digitalpersona.onetouch.capture.event.DPFPDataEvent;
import com.digitalpersona.onetouch.capture.event.DPFPErrorAdapter;
import com.digitalpersona.onetouch.capture.event.DPFPErrorEvent;
import com.digitalpersona.onetouch.capture.event.DPFPReaderStatusAdapter;
import com.digitalpersona.onetouch.capture.event.DPFPReaderStatusEvent;
import com.digitalpersona.onetouch.capture.event.DPFPSensorAdapter;
import com.digitalpersona.onetouch.capture.event.DPFPSensorEvent;
import com.digitalpersona.onetouch.processing.DPFPEnrollment;
import com.digitalpersona.onetouch.processing.DPFPFeatureExtraction;
import com.digitalpersona.onetouch.processing.DPFPImageQualityException;
import static com.digitalpersona.onetouch.processing.DPFPTemplateStatus.TEMPLATE_STATUS_READY;
import com.digitalpersona.onetouch.verification.DPFPVerification;
import com.digitalpersona.onetouch.verification.DPFPVerificationResult;
import MaterialEfectos.MaterialColor;
import java.awt.Color;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javafx.scene.paint.Material;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

/**
 * s
 *
 * @author JORDI MORA V
 */
public class frmRegistroEstudiante extends javax.swing.JFrame {

    public String usuario;
    public String codigoEstudiante;
    public String grupo = null;
    ImageIcon iconoError = new ImageIcon("src/Presentacion/imagenes/icons8-error-14.png");
    ImageIcon iconoOk = new ImageIcon("src/Presentacion/imagenes/icons8-ok-14.png");
    ImageIcon iconoAlert = new ImageIcon("src/Presentacion/imagenes/icons8-atención-14.png");
    static IFormularioReceptor _formularioInstanciador;

    /*
     * Guarda los datos de la huella digital actual en la base de datos
     */
    public void GuardarEstudiante() {
        //Obtiene los datos del template de la huella actual

        ByteArrayInputStream datosHuella = new ByteArrayInputStream(template.serialize());
        Integer tamañoHuella = template.serialize().length;

        //datos de la persona a la cual corresponde dicha huella
        String codigo = this.txtCodigo.getText();
        String nombre = this.txtNombre.getText();
        String apellido = this.txtApellido.getText();
        String correo = this.txtCorreo.getText();
        String telefono = this.txtTelefono.getText();
        String grupo_codigo = (grupo.split(":")[1]).trim();
        System.out.println("datosHuella:" + datosHuella);

        try {
            if (!identificarHuella()) {
                try {
                    //Establece los valores para la sentencia SQL
                    Connection c = con.conectar(); //establece la conexion con la BD

                    PreparedStatement guardarStmt = c.prepareStatement("INSERT INTO estudiante(codigo, nombre, apellido, correo, telefono, huella,grupo_codigo) VALUES (?,?,?,?,?,?,?)");

                    guardarStmt.setString(1, codigo);
                    guardarStmt.setString(2, nombre);
                    guardarStmt.setString(3, apellido);
                    guardarStmt.setString(4, correo);
                    guardarStmt.setString(5, telefono);
                    guardarStmt.setBinaryStream(6, datosHuella, tamañoHuella);
                    guardarStmt.setString(7, grupo_codigo);
                    //Ejecuta la sentencia
                    guardarStmt.execute();
                    guardarStmt.close();
                    JOptionPane.showMessageDialog(null, "Estudiante Registrado Correctamente");
                    con.desconectar();
                    restablecerFormulario();
                } catch (SQLException ex) {
                    //Si ocurre un error lo indica en la consola
                    System.err.println("Error al guardar los datos del estudiante.");
                    JOptionPane.showMessageDialog(this, "Error al guardar los datos del estudiante");
                    System.err.println("Mas detalle " + ex);
                } finally {
                    con.desconectar();
                }
            }
        } catch (IOException ex) {

        }
    }

    /**
     * Creates new form frmRegistroEstudiante
     *
     * @param formularioInstanciador
     */
    public frmRegistroEstudiante(IFormularioReceptor formularioInstanciador) {
        setIconImage(new ImageIcon(getClass().getResource("imagenes/logoupc.png")).getImage());
        initComponents();
        setExtendedState(MAXIMIZED_BOTH);
        setLocationRelativeTo(null);
        this._formularioInstanciador = formularioInstanciador;

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelContenedor = new javax.swing.JPanel();
        panelTitulo = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel18 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        materialButtomPanel3 = new MaterialSwing.MaterialButtomPanel();
        jLabel10 = new javax.swing.JLabel();
        panelRegistrar = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtArea = new javax.swing.JTextArea();
        panHuellas = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        lblImagenHuella = new javax.swing.JLabel();
        btnRegistrar = new MaterialSwing.MaterialButtonIcon();
        jPanel5 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        txtTelefono = new MaterialSwing.MaterialTextField();
        jLabel5 = new javax.swing.JLabel();
        txtCorreo = new MaterialSwing.MaterialTextField();
        jLabel2 = new javax.swing.JLabel();
        txtNombre = new MaterialSwing.MaterialTextField();
        jLabel3 = new javax.swing.JLabel();
        txtApellido = new MaterialSwing.MaterialTextField();
        jLabel1 = new javax.swing.JLabel();
        txtCodigo = new MaterialSwing.MaterialTextField();
        lblIconIdentificacion = new javax.swing.JLabel();
        lblIconNombre = new javax.swing.JLabel();
        lblIconApellido = new javax.swing.JLabel();
        lblIconCorreo = new javax.swing.JLabel();
        lblIconTelefono = new javax.swing.JLabel();
        lblErrorIdentificacion = new javax.swing.JLabel();
        lblErrorNombre = new javax.swing.JLabel();
        lblErrorApellido = new javax.swing.JLabel();
        lblErrorCorreo = new javax.swing.JLabel();
        lblErrorTelefono = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        panelContenedor.setBackground(new java.awt.Color(255, 255, 255));
        panelContenedor.setMinimumSize(new java.awt.Dimension(811, 600));
        panelContenedor.setPreferredSize(new java.awt.Dimension(160, 128));

        panelTitulo.setBackground(new java.awt.Color(255, 255, 255));
        org.jdesktop.swingx.border.DropShadowBorder dropShadowBorder1 = new org.jdesktop.swingx.border.DropShadowBorder();
        dropShadowBorder1.setShadowSize(10);
        dropShadowBorder1.setShowRightShadow(false);
        panelTitulo.setBorder(dropShadowBorder1);

        jPanel2.setBackground(new java.awt.Color(112, 182, 32));

        jLabel18.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(255, 255, 255));
        jLabel18.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Presentacion/imagenes/icons8-añadir-usuario-grupo-mujer-hombre-48.png"))); // NOI18N
        jLabel18.setText("Registro");
        jLabel18.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        jLabel18.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

        jLabel17.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setText("Ingenieria del sofware");

        jLabel13.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Presentacion/imagenes/logoupcmediano.png"))); // NOI18N

        jPanel1.setBackground(new java.awt.Color(75, 146, 45));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 18, Short.MAX_VALUE)
        );

        jLabel7.setFont(new java.awt.Font("Segoe UI Semilight", 1, 24)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel18)
                        .addGap(54, 54, 54)
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 639, Short.MAX_VALUE)
                        .addComponent(jLabel13))
                    .addComponent(jLabel17))
                .addGap(31, 31, 31))
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(3, 3, 3)
                                .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(53, 53, 53)
                        .addComponent(jLabel7)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 13, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout panelTituloLayout = new javax.swing.GroupLayout(panelTitulo);
        panelTitulo.setLayout(panelTituloLayout);
        panelTituloLayout.setHorizontalGroup(
            panelTituloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        panelTituloLayout.setVerticalGroup(
            panelTituloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 121, Short.MAX_VALUE)
        );

        materialButtomPanel3.setBackground(new java.awt.Color(112, 182, 32));
        materialButtomPanel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                materialButtomPanel3MouseClicked(evt);
            }
        });

        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Presentacion/imagenes/icons8-long-arrow-left-24.png"))); // NOI18N
        jLabel10.setText("Regresar");

        javax.swing.GroupLayout materialButtomPanel3Layout = new javax.swing.GroupLayout(materialButtomPanel3);
        materialButtomPanel3.setLayout(materialButtomPanel3Layout);
        materialButtomPanel3Layout.setHorizontalGroup(
            materialButtomPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(materialButtomPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel10)
                .addContainerGap(21, Short.MAX_VALUE))
        );
        materialButtomPanel3Layout.setVerticalGroup(
            materialButtomPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(materialButtomPanel3Layout.createSequentialGroup()
                .addComponent(jLabel10)
                .addGap(0, 14, Short.MAX_VALUE))
        );

        panelRegistrar.setBackground(new java.awt.Color(255, 255, 255));
        org.jdesktop.swingx.border.DropShadowBorder dropShadowBorder2 = new org.jdesktop.swingx.border.DropShadowBorder();
        dropShadowBorder2.setShowLeftShadow(true);
        dropShadowBorder2.setShowTopShadow(true);
        panelRegistrar.setBorder(dropShadowBorder2);
        panelRegistrar.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                panelRegistrarComponentShown(evt);
            }
        });

        txtArea.setEditable(false);
        txtArea.setColumns(20);
        txtArea.setRows(5);
        jScrollPane1.setViewportView(txtArea);

        panHuellas.setBackground(new java.awt.Color(255, 255, 255));
        panHuellas.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Huella Digital Capturada", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION));
        panHuellas.setPreferredSize(new java.awt.Dimension(400, 270));
        panHuellas.setLayout(new java.awt.BorderLayout());

        jPanel4.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jPanel4.setLayout(new java.awt.BorderLayout());
        jPanel4.add(lblImagenHuella, java.awt.BorderLayout.CENTER);

        panHuellas.add(jPanel4, java.awt.BorderLayout.CENTER);

        btnRegistrar.setBackground(new java.awt.Color(112, 182, 32));
        btnRegistrar.setForeground(new java.awt.Color(255, 255, 255));
        btnRegistrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Presentacion/imagenes/icons8-add-user-male-24 (2).png"))); // NOI18N
        btnRegistrar.setText("Registrar");
        btnRegistrar.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnRegistrar.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btnRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarActionPerformed(evt);
            }
        });

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Datos de Usuario", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION));

        jLabel6.setText("Telefono:");

        txtTelefono.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtTelefonoFocusLost(evt);
            }
        });
        txtTelefono.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTelefonoActionPerformed(evt);
            }
        });
        txtTelefono.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtTelefonoKeyTyped(evt);
            }
        });

        jLabel5.setText("correo:");

        txtCorreo.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtCorreoFocusLost(evt);
            }
        });
        txtCorreo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCorreoKeyTyped(evt);
            }
        });

        jLabel2.setText("Nombres:");

        txtNombre.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtNombreFocusLost(evt);
            }
        });
        txtNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNombreActionPerformed(evt);
            }
        });
        txtNombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNombreKeyTyped(evt);
            }
        });

        jLabel3.setText("Apellidos:");

        txtApellido.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtApellidoFocusLost(evt);
            }
        });
        txtApellido.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtApellidoKeyTyped(evt);
            }
        });

        jLabel1.setText("Identificacion:");

        txtCodigo.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtCodigoFocusLost(evt);
            }
        });
        txtCodigo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCodigoKeyTyped(evt);
            }
        });

        lblErrorIdentificacion.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        lblErrorIdentificacion.setForeground(new java.awt.Color(255, 0, 0));

        lblErrorNombre.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        lblErrorNombre.setForeground(new java.awt.Color(255, 0, 0));

        lblErrorApellido.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        lblErrorApellido.setForeground(new java.awt.Color(255, 0, 0));

        lblErrorCorreo.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        lblErrorCorreo.setForeground(new java.awt.Color(255, 0, 0));

        lblErrorTelefono.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        lblErrorTelefono.setForeground(new java.awt.Color(255, 0, 0));

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(txtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblIconTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtNombre, javax.swing.GroupLayout.DEFAULT_SIZE, 114, Short.MAX_VALUE)
                                    .addComponent(lblErrorNombre, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txtCodigo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel5Layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(lblIconNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(txtApellido, javax.swing.GroupLayout.DEFAULT_SIZE, 121, Short.MAX_VALUE)
                                            .addComponent(lblErrorApellido, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                    .addGroup(jPanel5Layout.createSequentialGroup()
                                        .addGap(14, 14, 14)
                                        .addComponent(lblIconIdentificacion, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addComponent(txtCorreo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lblIconApellido, javax.swing.GroupLayout.DEFAULT_SIZE, 17, Short.MAX_VALUE)
                            .addComponent(lblIconCorreo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addComponent(lblErrorCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblErrorTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblErrorIdentificacion, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblIconIdentificacion, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel1)))
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtApellido, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblIconApellido, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblIconNombre, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(1, 1, 1))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(lblErrorIdentificacion, javax.swing.GroupLayout.PREFERRED_SIZE, 11, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblErrorNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblErrorApellido, javax.swing.GroupLayout.DEFAULT_SIZE, 15, Short.MAX_VALUE))
                .addGap(4, 4, 4)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblIconCorreo, javax.swing.GroupLayout.DEFAULT_SIZE, 15, Short.MAX_VALUE)
                    .addComponent(txtCorreo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(1, 1, 1)
                .addComponent(lblErrorCorreo, javax.swing.GroupLayout.DEFAULT_SIZE, 23, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblIconTelefono, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel6)))
                .addGap(1, 1, 1)
                .addComponent(lblErrorTelefono, javax.swing.GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE)
                .addGap(21, 21, 21))
        );

        javax.swing.GroupLayout panelRegistrarLayout = new javax.swing.GroupLayout(panelRegistrar);
        panelRegistrar.setLayout(panelRegistrarLayout);
        panelRegistrarLayout.setHorizontalGroup(
            panelRegistrarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRegistrarLayout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(panelRegistrarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelRegistrarLayout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 511, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnRegistrar, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelRegistrarLayout.createSequentialGroup()
                        .addComponent(panHuellas, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(49, 49, 49)
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(35, Short.MAX_VALUE))
        );
        panelRegistrarLayout.setVerticalGroup(
            panelRegistrarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRegistrarLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelRegistrarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panHuellas, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGroup(panelRegistrarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelRegistrarLayout.createSequentialGroup()
                        .addGap(42, 42, 42)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelRegistrarLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnRegistrar, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(34, 34, 34))))
        );

        javax.swing.GroupLayout panelContenedorLayout = new javax.swing.GroupLayout(panelContenedor);
        panelContenedor.setLayout(panelContenedorLayout);
        panelContenedorLayout.setHorizontalGroup(
            panelContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelTitulo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(panelContenedorLayout.createSequentialGroup()
                .addComponent(materialButtomPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelContenedorLayout.createSequentialGroup()
                .addContainerGap(86, Short.MAX_VALUE)
                .addComponent(panelRegistrar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(98, Short.MAX_VALUE))
        );
        panelContenedorLayout.setVerticalGroup(
            panelContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelContenedorLayout.createSequentialGroup()
                .addComponent(panelTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, Short.MAX_VALUE)
                .addComponent(panelRegistrar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 99, Short.MAX_VALUE)
                .addComponent(materialButtomPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelContenedor, javax.swing.GroupLayout.DEFAULT_SIZE, 974, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panelContenedor, javax.swing.GroupLayout.DEFAULT_SIZE, 698, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void panelRegistrarComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_panelRegistrarComponentShown
        // TODO add your handling code here:
        btnRegistrar.setEnabled(false);
    }//GEN-LAST:event_panelRegistrarComponentShown

    private void materialButtomPanel3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_materialButtomPanel3MouseClicked
        // TODO add your handling code here:
        _formularioInstanciador.setVisible(true);
        this.dispose();
        if (DPFP.Lector.isStarted()) {
            DPFP.Lector.stopCapture();
            DPFP.Reclutador.clear();
        }
    }//GEN-LAST:event_materialButtomPanel3MouseClicked
    boolean codigoValido = false;
    boolean correValido = false;
    boolean nombreValido = false;
    boolean apellidoValido = false;
    boolean telefonoValido = false;
    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        // TODO add your handling code here:
        Iniciar();
        start();
        EstadoHuellas();
        btnRegistrar.setEnabled(true);
    }//GEN-LAST:event_formWindowOpened

    private void btnRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarActionPerformed
        // TODO add your handling code here:
        if (grupo != null) {
            if (validarCampos()) {
                if (DPFP.Reclutador.getTemplateStatus() == TEMPLATE_STATUS_READY) {
                    GuardarEstudiante();
                    DPFP.Reclutador.clear();
                    lblImagenHuella.setIcon(null);
                    start();
                } else {
                    JOptionPane.showMessageDialog(this, "No se ha capturado la huella dactilar del estudiante aun ", "Huella No Capturada", JOptionPane.ERROR_MESSAGE);
                }
            }
        } else {
            JOptionPane.showMessageDialog(this, "No existe un grupo asosciado Para realizar el registro", "Error de grupo", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnRegistrarActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        // TODO add your handling code here:
        _formularioInstanciador.setVisible(true);
        if (DPFP.Lector.isStarted()) {
            DPFP.Lector.stopCapture();
            DPFP.Reclutador.clear();
        }
    }//GEN-LAST:event_formWindowClosing

    private void txtTelefonoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtTelefonoFocusLost
        // TODO add your handling code here:

        if (txtTelefono.getText().isEmpty()) {
            txtTelefono.setBackground(new Color(253, 227, 227));
            //lblIconTelefono.setIcon(new ImageIcon("src/vista/imagenes/icons8-error-14.png"));
            ///txtTelefono.setBackground(Color.red);
            lblIconTelefono.setIcon(iconoError);

            telefonoValido = false;
        } else {
            txtTelefono.setBackground(new Color(0, 0, 0, 0));
            //lblIconTelefono.setIcon(new ImageIcon("src/vista/imagenes/icons8-ok-14.png"));
            ///txtTelefono.setBackground(new Color(0, 0, 0,0));
            lblIconTelefono.setIcon(iconoOk);
            telefonoValido = true;
        }
    }//GEN-LAST:event_txtTelefonoFocusLost

    private void txtTelefonoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTelefonoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTelefonoActionPerformed

    private void txtTelefonoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTelefonoKeyTyped
        // TODO add your handling code here:
        char caracter = evt.getKeyChar();

        // Verificar si la tecla pulsada no es un digito
        if (((caracter < '0') || (caracter > '9')) && (caracter != '+')) {
            evt.consume();  // ignorar el evento de teclado
            Toolkit.getDefaultToolkit().beep();
            lblErrorTelefono.setText("Escribe telefono valido");
        } else {
            lblErrorTelefono.setText("");
        }
    }//GEN-LAST:event_txtTelefonoKeyTyped

    private void txtCorreoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtCorreoFocusLost
        // TODO add your handling code here:
        Pattern pattern = Pattern
                .compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                        + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
        // El email a validar
        String email = txtCorreo.getText();

        Matcher mather = pattern.matcher(email);

        if (txtCorreo.getText().isEmpty()) {
            txtCorreo.setBackground(new Color(253, 227, 227));
            ///txtCorreo.setBackground(Color.red);t
            lblIconCorreo.setIcon(iconoError);
            correValido = false;
        }
        if (mather.find() != true) {
            txtCorreo.setBackground(new Color(253, 227, 227));
            //txtCorreo.setBackground(Color.red);
            lblIconCorreo.setIcon(iconoError);
            correValido = false;
            lblErrorCorreo.setText("Escribe Correo valido");
        } else {
            txtCorreo.setBackground(new Color(0, 0, 0, 0));
            ///txtCorreo.setBackground(new Color(0, 0, 0,0));
            lblIconCorreo.setIcon(iconoOk);
            correValido = true;
            lblErrorCorreo.setText("");

        }
    }//GEN-LAST:event_txtCorreoFocusLost

    private void txtCorreoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCorreoKeyTyped

    }//GEN-LAST:event_txtCorreoKeyTyped

    private void txtNombreFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtNombreFocusLost
        // TODO add your handling code here:
        if (txtNombre.getText().isEmpty()) {
            txtNombre.setBackground(new Color(253, 227, 227));
            lblIconNombre.setIcon(iconoError);
            nombreValido = false;
        } else {
            txtNombre.setBackground(new Color(0, 0, 0, 0));
            ///txtNombre.setBackground(new Color(0, 0, 0,0));
            lblIconNombre.setIcon(iconoOk);
            nombreValido = true;
        }
    }//GEN-LAST:event_txtNombreFocusLost

    private void txtNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNombreActionPerformed

    private void txtNombreKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombreKeyTyped
        // Verificar si la tecla pulsada no es un digito

        if (!Character.isLetter(evt.getKeyChar())
                && !(evt.getKeyChar() == KeyEvent.VK_SPACE)
                && !(evt.getKeyChar() == KeyEvent.VK_BACK_SPACE)) {
            evt.consume();
            Toolkit.getDefaultToolkit().beep();
            lblErrorNombre.setText("Escribe solo letras");
        } else {
            lblErrorNombre.setText("");
        }
    }//GEN-LAST:event_txtNombreKeyTyped

    private void txtApellidoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtApellidoFocusLost
        // TODO add your handling code here:
        // comprueba que no contenga caracteres prohibidos
        Pattern p = Pattern.compile("[^0-9.@_-~#*'¡!%]+");
        Matcher mather = p.matcher(txtApellido.getText());
        if (txtApellido.getText().isEmpty()) {
            txtApellido.setBackground(new Color(253, 227, 227));
            ///txtApellido.setBackground(Color.red);
            lblIconApellido.setIcon(iconoError);
            apellidoValido = false;
        } else {
            txtApellido.setBackground(new Color(0, 0, 0, 0));
            ///txtApellido.setBackground(new Color(0, 0, 0,0));
            lblIconApellido.setIcon(iconoOk);
            apellidoValido = true;
        }
    }//GEN-LAST:event_txtApellidoFocusLost

    private void txtApellidoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtApellidoKeyTyped
        // TODO add your handling code here
        if (!Character.isLetter(evt.getKeyChar()) && !(evt.getKeyChar() == KeyEvent.VK_SPACE) && !(evt.getKeyChar() == KeyEvent.VK_BACK_SPACE)) {
            Toolkit.getDefaultToolkit().beep();
            lblErrorApellido.setText("Escribe solo letras");
            evt.consume();
        } else {
            lblErrorApellido.setText("");
        }
    }//GEN-LAST:event_txtApellidoKeyTyped

    private void txtCodigoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtCodigoFocusLost
        // TODO add your handling code here:
        MetodosDao metodos = new MetodosDao();

        if (metodos.validarCodigo(txtCodigo.getText()) == 1 || txtCodigo.getText().isEmpty() || txtCodigo.getText().length() < 8 || txtCodigo.getText().length() > 11) {
            txtCodigo.setBackground(new Color(253, 227, 227));
            ///txtCodigo.setBackground(Color.red);
            lblIconIdentificacion.setIcon(iconoError);
            lblErrorIdentificacion.setText("Codigo no valido");
            codigoValido = false;
        } else {
            txtCodigo.setBackground(new Color(0, 0, 0, 0));
            lblIconIdentificacion.setIcon(iconoOk);
            codigoValido = true;
            lblErrorIdentificacion.setText("");
        }
    }//GEN-LAST:event_txtCodigoFocusLost

    private void txtCodigoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCodigoKeyTyped
        // TODO add your handling code here:
        char caracter = evt.getKeyChar();

        // Verificar si la tecla pulsada no es un digito
        if (((caracter < '0') || (caracter > '9')) && (caracter != '.')) {
            evt.consume();  // ignorar el evento de teclado
            Toolkit.getDefaultToolkit().beep();
            lblErrorIdentificacion.setText("Caracter no valido");
        } else {
            lblErrorIdentificacion.setText("");
        }
    }//GEN-LAST:event_txtCodigoKeyTyped

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
            java.util.logging.Logger.getLogger(frmRegistroEstudiante.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmRegistroEstudiante.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmRegistroEstudiante.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmRegistroEstudiante.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmRegistroEstudiante(_formularioInstanciador).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private MaterialSwing.MaterialButtonIcon btnRegistrar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblErrorApellido;
    private javax.swing.JLabel lblErrorCorreo;
    private javax.swing.JLabel lblErrorIdentificacion;
    private javax.swing.JLabel lblErrorNombre;
    private javax.swing.JLabel lblErrorTelefono;
    private javax.swing.JLabel lblIconApellido;
    private javax.swing.JLabel lblIconCorreo;
    private javax.swing.JLabel lblIconIdentificacion;
    private javax.swing.JLabel lblIconNombre;
    private javax.swing.JLabel lblIconTelefono;
    private javax.swing.JLabel lblImagenHuella;
    private MaterialSwing.MaterialButtomPanel materialButtomPanel3;
    private javax.swing.JPanel panHuellas;
    private javax.swing.JPanel panelContenedor;
    private javax.swing.JPanel panelRegistrar;
    private javax.swing.JPanel panelTitulo;
    private MaterialSwing.MaterialTextField txtApellido;
    private javax.swing.JTextArea txtArea;
    private MaterialSwing.MaterialTextField txtCodigo;
    private MaterialSwing.MaterialTextField txtCorreo;
    private MaterialSwing.MaterialTextField txtNombre;
    private MaterialSwing.MaterialTextField txtTelefono;
    // End of variables declaration//GEN-END:variables

//Variable que para crear el template de la huella luego de que se hallan creado las caracteriticas
// necesarias de la huella si no ha ocurrido ningun problema
    private DPFPTemplate template;
    public static String TEMPLATE_PROPERTY = "template";

    protected void Iniciar() {
        DPFP.Lector.addDataListener(new DPFPDataAdapter() {
            @Override
            public void dataAcquired(final DPFPDataEvent e) {
                SwingUtilities.invokeLater(new Runnable() {
                    public void run() {
                        EnviarTexto("La Huella Digital ha sido Capturada");
                        ProcesarCaptura(e.getSample());
                    }
                });
            }
        });

        DPFP.Lector.addReaderStatusListener(new DPFPReaderStatusAdapter() {
            @Override
            public void readerConnected(final DPFPReaderStatusEvent e) {
                SwingUtilities.invokeLater(new Runnable() {
                    public void run() {
                        EnviarTexto("El Sensor de Huella Digital esta Activado o Conectado");
                    }
                });
            }

            @Override
            public void readerDisconnected(final DPFPReaderStatusEvent e) {
                SwingUtilities.invokeLater(new Runnable() {
                    public void run() {
                        EnviarTexto("El Sensor de Huella Digital esta Desactivado o no Conectado");
                    }
                });
            }
        });

        DPFP.Lector.addSensorListener(new DPFPSensorAdapter() {
            @Override
            public void fingerTouched(final DPFPSensorEvent e) {
                SwingUtilities.invokeLater(new Runnable() {
                    public void run() {
                        EnviarTexto("El dedo ha sido colocado sobre el Lector de Huella");
                    }
                });
            }

            @Override
            public void fingerGone(final DPFPSensorEvent e) {
                SwingUtilities.invokeLater(new Runnable() {
                    public void run() {
                        EnviarTexto("El dedo ha sido quitado del Lector de Huella");
                    }
                });
            }
        });

        DPFP.Lector.addErrorListener(new DPFPErrorAdapter() {
            public void errorReader(final DPFPErrorEvent e) {
                SwingUtilities.invokeLater(new Runnable() {
                    public void run() {
                        EnviarTexto("Error: " + e.getError());
                    }
                });
            }
        });
    }

    public DPFPFeatureSet featuresinscripcion;
    public DPFPFeatureSet featuresverificacion;

    public void ProcesarCaptura(DPFPSample sample) {

        // Procesar la muestra de la huella y crear un conjunto de características con el propósito de inscripción.
        featuresinscripcion = extraerCaracteristicas(sample, DPFPDataPurpose.DATA_PURPOSE_ENROLLMENT);

        // Procesar la muestra de la huella y crear un conjunto de características con el propósito de verificacion.
        featuresverificacion = extraerCaracteristicas(sample, DPFPDataPurpose.DATA_PURPOSE_VERIFICATION);

        // Comprobar la calidad de la muestra de la huella y lo añade a su reclutador si es bueno
        if (featuresinscripcion != null) {
            try {
                System.out.println("Las Caracteristicas de la Huella han sido creada");
                DPFP.Reclutador.addFeatures(featuresinscripcion);// Agregar las caracteristicas de la huella a la plantilla a crear
                // Dibuja la huella dactilar capturada.
                Image image = CrearImagenHuella(sample);
                DibujarHuella(image);

//                btnVerificar.setEnabled(true);
//                btnIdentificar.setEnabled(true);
            } catch (DPFPImageQualityException ex) {
                System.err.println("Error: " + ex.getMessage());
            } finally {
                EstadoHuellas();
                // Comprueba si la plantilla se ha creado.
                switch (DPFP.Reclutador.getTemplateStatus()) {
                    case TEMPLATE_STATUS_READY:	// informe de éxito y detiene  la captura de huellas
                        stop();
                        setTemplate(DPFP.Reclutador.getTemplate());
                        EnviarTexto("La Plantilla de la Huella ha Sido Creada");
//                        btnIdentificar.setEnabled(false);
//                        btnVerificar.setEnabled(false);
//                        btnGuardar.setEnabled(true);
//                        btnGuardar.grabFocus();
                        break;

                    case TEMPLATE_STATUS_FAILED: // informe de fallas y reiniciar la captura de huellas
                        DPFP.Reclutador.clear();
                        stop();
                        EstadoHuellas();
                        setTemplate(null);
                        JOptionPane.showMessageDialog(frmRegistroEstudiante.this, "La Plantilla de la Huella no pudo ser creada, Repita el Proceso", "Inscripcion de Huellas Dactilares", JOptionPane.ERROR_MESSAGE);
                        start();
                        break;
                }
            }
        }
    }

    public DPFPFeatureSet extraerCaracteristicas(DPFPSample sample, DPFPDataPurpose purpose) {
        DPFPFeatureExtraction extractor = DPFPGlobal.getFeatureExtractionFactory().createFeatureExtraction();
        try {
            return extractor.createFeatureSet(sample, purpose);
        } catch (DPFPImageQualityException e) {
            return null;
        }
    }

    public Image CrearImagenHuella(DPFPSample sample) {
        return DPFPGlobal.getSampleConversionFactory().createImage(sample);
    }

    public void DibujarHuella(Image image) {
        lblImagenHuella.setIcon(new ImageIcon(
                image.getScaledInstance(lblImagenHuella.getWidth(), lblImagenHuella.getHeight(), Image.SCALE_DEFAULT)));
        repaint();
    }

    public void EstadoHuellas() {
        EnviarTexto("Muestra de Huellas Necesarias para Guardar Template " + DPFP.Reclutador.getFeaturesNeeded());
    }

    public void EnviarTexto(String string) {
        txtArea.append(string + "\n");
    }

    public void start() {
        DPFP.Lector.startCapture();
        EnviarTexto("Utilizando el Lector de Huella Dactilar ");
    }

    public void stop() {
        DPFP.Lector.stopCapture();
        EnviarTexto("No se está usando el Lector de Huella Dactilar ");
    }

    public DPFPTemplate getTemplate() {
        return template;
    }

    public void setTemplate(DPFPTemplate template) {
        DPFPTemplate old = this.template;
        this.template = template;
        firePropertyChange(TEMPLATE_PROPERTY, old, template);
    }

    ConexionBD con = new ConexionBD();

    /**
     * Identifica a una persona registrada por medio de su huella digital
     */
    public boolean identificarHuella() throws IOException {
        try {
            //Establece los valores para la sentencia SQL
            Connection c = con.conectar();

            //Obtiene todas las huellas de la bd
            PreparedStatement identificarStmt = c.prepareStatement("SELECT * FROM estudiante");
            ResultSet rs = identificarStmt.executeQuery();

            //Si se encuentra el nombre en la base de datos
            while (rs.next()) {
                //Lee la plantilla de la base de datos
                byte templateBuffer[] = rs.getBytes("huella");
                String nombre = rs.getString("nombre");
                //Crea una nueva plantilla a partir de la guardada en la base de datos
                DPFPTemplate referenceTemplate = DPFPGlobal.getTemplateFactory().createTemplate(templateBuffer);
                //Envia la plantilla creada al objeto contendor de Template del componente de huella digital
                setTemplate(referenceTemplate);

                // Compara las caracteriticas de la huella recientemente capturda con la
                // alguna plantilla guardada en la base de datos que coincide con ese tipo
                DPFPVerificationResult result = DPFP.Verificador.verify(featuresverificacion, getTemplate());

                //compara las plantilas (actual vs bd)
                //Si encuentra correspondencia dibuja el mapa
                //e indica el nombre de la persona que coincidió.
                if (result.isVerified()) {
                    //crea la imagen de los datos guardado de las huellas guardadas en la base de datos
                    JOptionPane.showMessageDialog(null, "Las huella capturada ya esta registrada, es de " + nombre, "Verificacion de Huella", JOptionPane.ERROR_MESSAGE);
                    return true;
                }
            }

        } catch (SQLException e) {
            //Si ocurre un error lo indica en la consola
            System.err.println("Error al identificar huella dactilar." + e.getMessage());
        } finally {
            con.desconectar();
        }
        return false;
    }

    private boolean validarCampos() {
        if (!codigoValido) {
            JOptionPane.showMessageDialog(this, "el campo codigo tiene errores o esta vacio", "error", JOptionPane.ERROR_MESSAGE);
            return false;
        } else if (!nombreValido) {
            JOptionPane.showMessageDialog(this, "el campo codigo tiene errores o esta vacio", "error", JOptionPane.ERROR_MESSAGE);
            return false;
        } else if (!apellidoValido) {
            JOptionPane.showMessageDialog(this, "el campo codigo tiene errores o esta vacio", "error", JOptionPane.ERROR_MESSAGE);
            return false;
        } else if (!correValido) {
            JOptionPane.showMessageDialog(this, "el campo codigo tiene errores o esta vacio", "error", JOptionPane.ERROR_MESSAGE);
            return false;
        } else if (!telefonoValido) {
            JOptionPane.showMessageDialog(this, "el campo codigo tiene errores o esta vacio", "error", JOptionPane.ERROR_MESSAGE);
            return false;
        } else {
            return true;
        }
    }

    private void restablecerFormulario() {
        this.txtCodigo.setText("");
        this.txtNombre.setText("");
        this.txtApellido.setText("");
        this.txtCorreo.setText("");
        this.txtTelefono.setText("");
        this.lblIconIdentificacion.setIcon(null);
        this.lblIconNombre.setIcon(null);
        this.lblIconApellido.setIcon(null);
        this.lblIconCorreo.setIcon(null);
        this.lblIconTelefono.setIcon(null);
    }

}
