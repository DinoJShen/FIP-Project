package application;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.File;
import java.io.FileFilter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.plaf.basic.BasicFileChooserUI;

public class RawApplication extends javax.swing.JFrame {
    File file;
    ArrayList<Integer> generateRaw=new ArrayList<Integer>();
    String generateFileName="none";
    int Width,Height,afterWidth,afterHeight;
    public RawApplication(File file){
        this.file=file;
        initComponents();
        String width="",height="";
        while(!width.matches("[0-9]+")){
            width= JOptionPane.showInputDialog("Enter width of raw :");
        }
        while(!height.matches("[0-9]+")){
            height= JOptionPane.showInputDialog("Enter height of raw :");
        }
        this.Width=Integer.valueOf(width);
        this.Height=Integer.valueOf(height);
        rawToPng(lblPictureBefore,file,Integer.valueOf(width),Integer.valueOf(height));
    }
    
    private void rawToPng(JLabel label,File file,int width,int height){
        application.function.ReadRaw readRaw = new application.function.ReadRaw(file.getName(),"png",width,height);
        File pngFile=readRaw.generateImage();
        int newWidth = width;
        int newHeight = height;
        if (width > label.getWidth()){
            newWidth = label.getWidth();
            newHeight = (newWidth * height) / width;
        }
        if (newHeight > label.getHeight()){
            newHeight = label.getHeight();
            newWidth = (newHeight * width) / height;
        }
        label.setIcon(new application.function.Resize(pngFile.toString(),newWidth,newHeight).Resize());
        label.setText(null);
        while(pngFile.exists()){
            pngFile.delete();
        }
    }
    
    private void setImage(int width,int height){
        File newFile=new File(generateFileName);
        application.function.ReadRaw extractRaw = new application.function.ReadRaw(generateFileName);
        generateRaw.clear();
        generateRaw.addAll(extractRaw.readRaw());
        rawToPng(lblPictureAfter,newFile,width,height);
        while(newFile.exists()){
            newFile.delete();
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblPictureAfter = new javax.swing.JLabel();
        lblPictureBefore = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        btnPatterning = new javax.swing.JButton();
        btnD1 = new javax.swing.JButton();
        btnD2 = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        btnDFLeft = new javax.swing.JButton();
        btnDFRight = new javax.swing.JButton();
        btnDFTopLeft = new javax.swing.JButton();
        btnDFBottomLeft = new javax.swing.JButton();
        btnDFBottom = new javax.swing.JButton();
        btnDFBottomRight = new javax.swing.JButton();
        btnDFTop = new javax.swing.JButton();
        btnDFTopRight = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        btnEnhancement = new javax.swing.JButton();
        btnBlur1 = new javax.swing.JButton();
        btnBlur2 = new javax.swing.JButton();
        btnSharp = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        jSliderHighlight = new javax.swing.JSlider();
        jPanel7 = new javax.swing.JPanel();
        jSliderHighboost = new javax.swing.JSlider();
        btnGenerate2 = new javax.swing.JButton();
        btnBack = new javax.swing.JButton();
        btnExit = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lblPictureAfter.setBackground(java.awt.SystemColor.controlHighlight);
        lblPictureAfter.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblPictureAfter.setText("After Picture"); // NOI18N
        lblPictureAfter.setAlignmentY(0.0F);
        lblPictureAfter.setAutoscrolls(true);
        lblPictureAfter.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED), javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED)));
        lblPictureAfter.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        lblPictureAfter.setFocusable(false);
        lblPictureAfter.setIconTextGap(0);
        lblPictureAfter.setInheritsPopupMenu(false);

        lblPictureBefore.setBackground(java.awt.SystemColor.controlHighlight);
        lblPictureBefore.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblPictureBefore.setText("Before Picture"); // NOI18N
        lblPictureBefore.setAlignmentY(0.0F);
        lblPictureBefore.setAutoscrolls(true);
        lblPictureBefore.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED), javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED)));
        lblPictureBefore.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        lblPictureBefore.setFocusable(false);
        lblPictureBefore.setIconTextGap(0);
        lblPictureBefore.setInheritsPopupMenu(false);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Halfoning", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Tahoma", 1, 12))); // NOI18N

        btnPatterning.setText("Patterning");
        btnPatterning.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPatterningActionPerformed(evt);
            }
        });

        btnD1.setText("<html>\n<body>\nDithering\n<a style=\"vertical-align: super;\n    font-size: 8px;\">1</a>\n</body>\n</html>\n"); // NOI18N
        btnD1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnD1ActionPerformed(evt);
            }
        });

        btnD2.setText("<html> <body> Dithering <a style=\"vertical-align: super;     font-size: 8px;\">2</a> </body> </html> "); // NOI18N
        btnD2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnD2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnPatterning)
            .addComponent(btnD1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(btnD2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(btnPatterning)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnD1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnD2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Directional Filtering", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Tahoma", 1, 12))); // NOI18N

        btnDFLeft.setText("<html>\n&#8592;\n</html>");
        btnDFLeft.setAlignmentY(0.0F);
        btnDFLeft.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnDFLeft.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        btnDFLeft.setMinimumSize(new java.awt.Dimension(0, 0));
        btnDFLeft.setPreferredSize(new java.awt.Dimension(0, 0));
        btnDFLeft.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDFLeftActionPerformed(evt);
            }
        });

        btnDFRight.setText("<html> &#8594;</html>");
        btnDFRight.setAlignmentY(0.0F);
        btnDFRight.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnDFRight.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        btnDFRight.setMinimumSize(new java.awt.Dimension(0, 0));
        btnDFRight.setPreferredSize(new java.awt.Dimension(0, 0));
        btnDFRight.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDFRightActionPerformed(evt);
            }
        });

        btnDFTopLeft.setText("<html> &#8598; </html>");
        btnDFTopLeft.setAlignmentY(0.0F);
        btnDFTopLeft.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnDFTopLeft.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        btnDFTopLeft.setMinimumSize(new java.awt.Dimension(0, 0));
        btnDFTopLeft.setPreferredSize(new java.awt.Dimension(0, 0));
        btnDFTopLeft.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDFTopLeftActionPerformed(evt);
            }
        });

        btnDFBottomLeft.setText("<html>&#8601; </html>");
        btnDFBottomLeft.setAlignmentY(0.0F);
        btnDFBottomLeft.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnDFBottomLeft.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        btnDFBottomLeft.setMinimumSize(new java.awt.Dimension(0, 0));
        btnDFBottomLeft.setPreferredSize(new java.awt.Dimension(0, 0));
        btnDFBottomLeft.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDFBottomLeftActionPerformed(evt);
            }
        });

        btnDFBottom.setText("<html> &#8595; </html>");
        btnDFBottom.setAlignmentY(0.0F);
        btnDFBottom.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnDFBottom.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        btnDFBottom.setMinimumSize(new java.awt.Dimension(0, 0));
        btnDFBottom.setPreferredSize(new java.awt.Dimension(0, 0));
        btnDFBottom.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDFBottomActionPerformed(evt);
            }
        });

        btnDFBottomRight.setText("<html> &#8600; </html>");
        btnDFBottomRight.setAlignmentY(0.0F);
        btnDFBottomRight.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnDFBottomRight.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        btnDFBottomRight.setMinimumSize(new java.awt.Dimension(0, 0));
        btnDFBottomRight.setPreferredSize(new java.awt.Dimension(0, 0));
        btnDFBottomRight.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDFBottomRightActionPerformed(evt);
            }
        });

        btnDFTop.setText("<html>&#8593;</html>");
        btnDFTop.setAlignmentY(0.0F);
        btnDFTop.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnDFTop.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        btnDFTop.setMinimumSize(new java.awt.Dimension(0, 0));
        btnDFTop.setPreferredSize(new java.awt.Dimension(0, 0));
        btnDFTop.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDFTopActionPerformed(evt);
            }
        });

        btnDFTopRight.setText("<html> &#8599; </html>");
        btnDFTopRight.setAlignmentY(0.0F);
        btnDFTopRight.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnDFTopRight.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        btnDFTopRight.setMinimumSize(new java.awt.Dimension(0, 0));
        btnDFTopRight.setPreferredSize(new java.awt.Dimension(0, 0));
        btnDFTopRight.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDFTopRightActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(btnDFLeft, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(52, 52, 52)
                        .addComponent(btnDFRight, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(btnDFTopLeft, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnDFTop, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnDFTopRight, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(btnDFBottomLeft, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnDFBottom, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnDFBottomRight, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnDFTopLeft, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnDFTop, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnDFTopRight, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(8, 8, 8)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnDFLeft, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnDFRight, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnDFBottomLeft, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnDFBottom, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnDFBottomRight, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        jPanel5.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        btnEnhancement.setText("Enhancement");
        btnEnhancement.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEnhancementActionPerformed(evt);
            }
        });

        btnBlur1.setText("<html> <body> Blur <a style=\"vertical-align: super;     font-size: 8px;\">1</a> </body> </html> ");
        btnBlur1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBlur1ActionPerformed(evt);
            }
        });

        btnBlur2.setText("<html> <body> Blur <a style=\"vertical-align: super;     font-size: 8px;\">2</a> </body> </html> ");
        btnBlur2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBlur2ActionPerformed(evt);
            }
        });

        btnSharp.setText("Sharping");
        btnSharp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSharpActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(btnEnhancement)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(btnSharp, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 97, Short.MAX_VALUE)
                            .addComponent(btnBlur1, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnBlur2, javax.swing.GroupLayout.Alignment.LEADING))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnEnhancement, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnBlur1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnBlur2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnSharp)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Highlight", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Tahoma", 1, 12))); // NOI18N

        jSliderHighlight.setMaximum(4);
        jSliderHighlight.setValue(0);
        jSliderHighlight.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jSliderHighlightMouseReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jSliderHighlight, javax.swing.GroupLayout.DEFAULT_SIZE, 93, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSliderHighlight, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        jPanel7.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "High boost filtering", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Tahoma", 1, 11))); // NOI18N

        jSliderHighboost.setMaximum(4);
        jSliderHighboost.setPaintLabels(true);
        jSliderHighboost.setSnapToTicks(true);
        jSliderHighboost.setValue(0);
        jSliderHighboost.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jSliderHighboostMouseReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jSliderHighboost, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSliderHighboost, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        btnGenerate2.setText("Generate Image");
        btnGenerate2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGenerate2ActionPerformed(evt);
            }
        });

        btnBack.setText("Back");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        btnExit.setText("Exit");
        btnExit.setToolTipText("");
        btnExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExitActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(lblPictureBefore, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
                .addComponent(lblPictureAfter, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnGenerate2, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnBack, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(34, 34, 34)
                        .addComponent(btnExit, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblPictureAfter, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblPictureBefore, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnGenerate2, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnBack, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnExit, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    private void btnPatterningActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPatterningActionPerformed
        new application.function.Patterning(file.getName(),Width);
        generateFileName=file.getName().substring(0, file.getName().length()-4)+" (Patterning).raw";
        afterWidth=Width*3;afterHeight=Height*3;
        setImage(afterWidth,afterHeight);
    }//GEN-LAST:event_btnPatterningActionPerformed
    private void btnD1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnD1ActionPerformed
        new application.function.Dithering(1,file.getName(),Width);
        generateFileName=file.getName().substring(0, file.getName().length()-4)+" (D1).raw";
        afterWidth=Width;afterHeight=Height;
        setImage(afterWidth,afterHeight);
    }//GEN-LAST:event_btnD1ActionPerformed
    private void btnD2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnD2ActionPerformed
        new application.function.Dithering(2,file.getName(),Width);
        generateFileName=file.getName().substring(0, file.getName().length()-4)+" (D2).raw";
        afterWidth=Width;afterHeight=Height;
        setImage(afterWidth,afterHeight);
    }//GEN-LAST:event_btnD2ActionPerformed
    private void btnEnhancementActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEnhancementActionPerformed
        new application.function.Enhancement(file.getName());
        generateFileName=file.getName().substring(0, file.getName().length()-4)+" (Enhancement).raw";
        afterWidth=Width;afterHeight=Height;
        setImage(afterWidth,afterHeight);
    }//GEN-LAST:event_btnEnhancementActionPerformed
    private void btnBlur1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBlur1ActionPerformed
        new application.function.KernelConvolution3x3(file.getName(),Width,"Blur1",new ArrayList<>(Arrays.asList(1,1,1,
                                                                                                            1,1,1,
                                                                                                            1,1,1)));
        generateFileName=file.getName().substring(0, file.getName().length()-4)+" (Blur1).raw";
        afterWidth=Width;afterHeight=Height;
        setImage(afterWidth,afterHeight);
    }//GEN-LAST:event_btnBlur1ActionPerformed
    private void btnDFLeftActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDFLeftActionPerformed
        new application.function.KernelConvolution3x3(file.getName(),Width,"DFLeft",new ArrayList<>(Arrays.asList(1,0,-1,
                                                                                                            1,0,-1,
                                                                                                            1,0,-1)));
        generateFileName=file.getName().substring(0, file.getName().length()-4)+" (DFLeft).raw";
        afterWidth=Width;afterHeight=Height;
        setImage(afterWidth,afterHeight);
    }//GEN-LAST:event_btnDFLeftActionPerformed
    private void btnDFTopLeftActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDFTopLeftActionPerformed
        new application.function.KernelConvolution3x3(file.getName(),Width,"DFTopLeft",new ArrayList<>(Arrays.asList(1,1,0,
                                                                                                            1,0,-1,
                                                                                                            0,-1,-1)));
        generateFileName=file.getName().substring(0, file.getName().length()-4)+" (DFTopLeft).raw";
        afterWidth=Width;afterHeight=Height;
        setImage(afterWidth,afterHeight);
    }//GEN-LAST:event_btnDFTopLeftActionPerformed
    private void btnDFTopActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDFTopActionPerformed
        new application.function.KernelConvolution3x3(file.getName(),Width,"DFTop",new ArrayList<>(Arrays.asList(1,1,1,
                                                                                                            0,0,0,
                                                                                                            -1,-1,-1)));
        generateFileName=file.getName().substring(0, file.getName().length()-4)+" (DFTop).raw";
        afterWidth=Width;afterHeight=Height;
        setImage(afterWidth,afterHeight);
    }//GEN-LAST:event_btnDFTopActionPerformed
    private void btnDFTopRightActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDFTopRightActionPerformed
        new application.function.KernelConvolution3x3(file.getName(),Width,"DFTopRight",new ArrayList<>(Arrays.asList(0,1,1,
                                                                                                           -1,0,1,
                                                                                                           -1,-1,0)));
        generateFileName=file.getName().substring(0, file.getName().length()-4)+" (DFTopRight).raw";
        afterWidth=Width;afterHeight=Height;
        setImage(afterWidth,afterHeight);
    }//GEN-LAST:event_btnDFTopRightActionPerformed
    private void btnDFRightActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDFRightActionPerformed
        new application.function.KernelConvolution3x3(file.getName(),Width,"DFRight",new ArrayList<>(Arrays.asList(-1,0,1,
                                                                                                             -1,0,1,
                                                                                                             -1,0,1)));
        generateFileName=file.getName().substring(0, file.getName().length()-4)+" (DFRight).raw";
        afterWidth=Width;afterHeight=Height;
        setImage(afterWidth,afterHeight);
    }//GEN-LAST:event_btnDFRightActionPerformed
    private void btnDFBottomLeftActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDFBottomLeftActionPerformed
        new application.function.KernelConvolution3x3(file.getName(),Width,"DFBottomLeft",new ArrayList<>(Arrays.asList(0,-1,-1,
                                                                                                                  1,0,-1,
                                                                                                                  1,1,0)));
        generateFileName=file.getName().substring(0, file.getName().length()-4)+" (DFBottomLeft).raw";
        afterWidth=Width;afterHeight=Height;
        setImage(afterWidth,afterHeight);
    }//GEN-LAST:event_btnDFBottomLeftActionPerformed
    private void btnDFBottomActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDFBottomActionPerformed
        new application.function.KernelConvolution3x3(file.getName(),Width,"DFBottom",new ArrayList<>(Arrays.asList(-1,-1,-1,
                                                                                                            0,0,0,
                                                                                                            1,1,1)));
        generateFileName=file.getName().substring(0, file.getName().length()-4)+" (DFBottom).raw";
        afterWidth=Width;afterHeight=Height;
        setImage(afterWidth,afterHeight);
    }//GEN-LAST:event_btnDFBottomActionPerformed
    private void btnDFBottomRightActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDFBottomRightActionPerformed
        new application.function.KernelConvolution3x3(file.getName(),Width,"DFBottomRight",new ArrayList<>(Arrays.asList(-1,-1,0,
                                                                                                            -1,0,1,
                                                                                                            0,1,1)));
        generateFileName=file.getName().substring(0, file.getName().length()-4)+" (DFBottomRight).raw";
        afterWidth=Width;afterHeight=Height;
        setImage(afterWidth,afterHeight);
    }//GEN-LAST:event_btnDFBottomRightActionPerformed

    private void jSliderHighlightMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jSliderHighlightMouseReleased
        ArrayList<Integer>a=null;
        if(jSliderHighlight.getValue()==1){
            a=new ArrayList<>(Arrays.asList(1,-2,1,
                                            -2,4,-2,
                                            1,-2,1));
        }else if(jSliderHighlight.getValue()==2){
            a=new ArrayList<>(Arrays.asList(0,-1,0,
                                            -1,4,-1,
                                            0,-1,0));
        }else if(jSliderHighlight.getValue()==3){
            a=new ArrayList<>(Arrays.asList(-2,1,-2,
                                            1,4,1,
                                            -2,1,-2));
        }else if(jSliderHighlight.getValue()==4){
            a=new ArrayList<>(Arrays.asList(-1,-1,-1,
                                            -1,8,-1,
                                            -1,-1,-1));
        }else{
            lblPictureAfter.setIcon(lblPictureBefore.getIcon());
            lblPictureAfter.setText(null);
            generateFileName="none";
            return;
        }
        new application.function.KernelConvolution3x3(file.getName(),Width,"Highlight"+jSliderHighlight.getValue(),a);
        generateFileName=file.getName().substring(0, file.getName().length()-4)+" (Highlight"+jSliderHighlight.getValue()+").raw";
        afterWidth=Width;afterHeight=Height;
        setImage(afterWidth,afterHeight);
    }//GEN-LAST:event_jSliderHighlightMouseReleased

    private void btnBlur2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBlur2ActionPerformed
        new application.function.KernelConvolution5x5(file.getName(),Width,"Blur2",new ArrayList<>(Arrays.asList(1,1,1,1,1,
                                                                                                                1,1,1,1,1,
                                                                                                                1,1,1,1,1,
                                                                                                                1,1,1,1,1,
                                                                                                                1,1,1,1,1)));
        generateFileName=file.getName().substring(0, file.getName().length()-4)+" (Blur2).raw";
        afterWidth=Width;afterHeight=Height;
        setImage(afterWidth,afterHeight);
    }//GEN-LAST:event_btnBlur2ActionPerformed

    private void btnSharpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSharpActionPerformed
        new application.function.KernelConvolution3x3(file.getName(),Width,"Sharping",new ArrayList<>(Arrays.asList(1,1,1,
                                                                                                                    1,9,1, 
                                                                                                                    1,1,1)));
        generateFileName=file.getName().substring(0, file.getName().length()-4)+" (Sharping).raw";
        afterWidth=Width;afterHeight=Height;
        setImage(afterWidth,afterHeight);
    }//GEN-LAST:event_btnSharpActionPerformed

    private void jSliderHighboostMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jSliderHighboostMouseReleased
        int c=8;
        if(jSliderHighboost.getValue()>0&&jSliderHighboost.getValue()<5){
            c+=jSliderHighboost.getValue();
        }else{
            lblPictureAfter.setIcon(lblPictureBefore.getIcon());
            lblPictureAfter.setText(null);
            generateFileName="none";
            return;
        }
        new application.function.KernelConvolution3x3(file.getName(),Width,"High Boost",new ArrayList<>(Arrays.asList(-1,-1,-1,
                                                                                                                    -1,c,-1, 
                                                                                                                    -1,1,-1)));
        generateFileName=file.getName().substring(0, file.getName().length()-4)+" (High Boost).raw";
        afterWidth=Width;afterHeight=Height;
        setImage(afterWidth,afterHeight);
    }//GEN-LAST:event_jSliderHighboostMouseReleased

    private void btnGenerate2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGenerate2ActionPerformed
        if(generateFileName.equals("none")){
            JOptionPane.showMessageDialog(null, "Unable to generate image file which same as original or empty","Error", JOptionPane.WARNING_MESSAGE);
            return;
        }
        try{
            JFrame parentFrame = new JFrame();
            File fileToSave=null;
            JFileChooser fileChooser = new JFileChooser();
            fileChooser.addPropertyChangeListener(JFileChooser.FILE_FILTER_CHANGED_PROPERTY, new PropertyChangeListener(){
                public void propertyChange(PropertyChangeEvent e) {
                    if((fileChooser.getFileFilter().getDescription().equals("PNG Image"))){
                        fileChooser.setSelectedFile(new File(generateFileName.substring(0,generateFileName.length()-4)+".png"));
                    }else if((fileChooser.getFileFilter().getDescription().equals("Raw Image"))){
                        fileChooser.setSelectedFile(new File(generateFileName.substring(0,generateFileName.length()-4)+".raw"));
                    }else if((fileChooser.getFileFilter().getDescription().equals("JPG Image"))){
                        fileChooser.setSelectedFile(new File(generateFileName.substring(0,generateFileName.length()-4)+".jpg"));
                    }
                }
            });
            fileChooser.setDialogTitle("Specify a file to save");
            fileChooser.addChoosableFileFilter(new FileNameExtensionFilter("Raw Image", "raw"));
            fileChooser.addChoosableFileFilter(new FileNameExtensionFilter("PNG Image", "png"));
            fileChooser.addChoosableFileFilter(new FileNameExtensionFilter("JPG Image", "jpg"));
            int userSelection = fileChooser.showSaveDialog(parentFrame);
            if (userSelection == JFileChooser.APPROVE_OPTION) {
                fileToSave = fileChooser.getSelectedFile();
                if(fileToSave==null){
                    return;
                }
                if((fileChooser.getFileFilter().getDescription().equals("Raw Image"))||(fileToSave.getPath().endsWith(".raw"))){
                    FileOutputStream MyOutputFile=new FileOutputStream(fileToSave.getPath());
                    for(int value:generateRaw){
                        MyOutputFile.write(value);
                    }
                    MyOutputFile.close();
                    JOptionPane.showMessageDialog(null,"The file ("+fileToSave.getPath()+") is saved! ","Error", JOptionPane.WARNING_MESSAGE);
                }else if((fileChooser.getFileFilter().getDescription().equals("PNG Image"))||(fileToSave.getPath().endsWith(".png"))||(fileChooser.getFileFilter().getDescription().equals("JPG Image"))||(fileToSave.getPath().endsWith(".jpg"))){
                    String format=fileToSave.getPath().substring(fileToSave.getPath().length()-3,fileToSave.getPath().length());
                    FileOutputStream MyOutputFile=new FileOutputStream(fileToSave.getPath().substring(0,fileToSave.getPath().length()-4)+".tmp");
                    for(int value:generateRaw){
                        MyOutputFile.write(value);
                    }
                    MyOutputFile.close();
                    application.function.ReadRaw readRaw = new application.function.ReadRaw(fileToSave.getPath().substring(0,fileToSave.getPath().length()-4)+".tmp",format,afterWidth,afterHeight);
                    File file=readRaw.generateImage();
                    while(new File(fileToSave.getPath().substring(0,fileToSave.getPath().length()-4)+".tmp").exists()){
                        new File(fileToSave.getPath().substring(0,fileToSave.getPath().length()-4)+".tmp").delete();
                    }
                    JOptionPane.showMessageDialog(null,"The file ("+fileToSave.getPath()+") is saved! ","Error", JOptionPane.WARNING_MESSAGE);
                }else{
                    JOptionPane.showMessageDialog(null, "Only Support .png & .jpg & .raw & .tif","Error", JOptionPane.WARNING_MESSAGE);
                }
            }
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Something is wrong! Please try again correctly!","Error", JOptionPane.WARNING_MESSAGE);
        }
        
    }//GEN-LAST:event_btnGenerate2ActionPerformed

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        setVisible(false);
        application.Application form = new application.Application();
        form.setVisible(true);
        form.setLocationRelativeTo(null);
    }//GEN-LAST:event_btnBackActionPerformed

    private void btnExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExitActionPerformed
        System.exit(0);
    }//GEN-LAST:event_btnExitActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnBlur1;
    private javax.swing.JButton btnBlur2;
    private javax.swing.JButton btnD1;
    private javax.swing.JButton btnD2;
    private javax.swing.JButton btnD3;
    private javax.swing.JButton btnD4;
    private javax.swing.JButton btnD5;
    private javax.swing.JButton btnD6;
    private javax.swing.JButton btnDFBottom;
    private javax.swing.JButton btnDFBottomLeft;
    private javax.swing.JButton btnDFBottomRight;
    private javax.swing.JButton btnDFLeft;
    private javax.swing.JButton btnDFRight;
    private javax.swing.JButton btnDFTop;
    private javax.swing.JButton btnDFTopLeft;
    private javax.swing.JButton btnDFTopRight;
    private javax.swing.JButton btnEnhancement;
    private javax.swing.JButton btnExit;
    private javax.swing.JButton btnGenerate;
    private javax.swing.JButton btnGenerate1;
    private javax.swing.JButton btnGenerate2;
    private javax.swing.JButton btnPatterning;
    private javax.swing.JButton btnPatterning1;
    private javax.swing.JButton btnPatterning2;
    private javax.swing.JButton btnSharp;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JSlider jSliderHighboost;
    private javax.swing.JSlider jSliderHighlight;
    private static javax.swing.JLabel lblPictureAfter;
    private static javax.swing.JLabel lblPictureBefore;
    // End of variables declaration//GEN-END:variables
}
