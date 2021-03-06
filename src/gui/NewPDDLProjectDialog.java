/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * NewPDDLProjectDialog.java
 *
 * Created on Jun 4, 2012, 12:48:37 PM
 */

package src.gui;

import java.awt.Frame;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
//import java.nio.charset.Charset;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import org.jdom.Document;
import org.jdom.Element;
import org.jdom.output.XMLOutputter;

/**
 *
 * @author sanpedro
 */
public class NewPDDLProjectDialog extends javax.swing.JDialog
{
    private File projectFolder;
    private String projectName;
    private Frame parent;
    private boolean canOpen = false;

    /** Creates new form NewPDDLProjectDialog */
    public NewPDDLProjectDialog(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        this.parent = parent;
    }

    private void createPDDLFile(String filename, String data)
    {
        File pddlFile;
        pddlFile = new File(projectFolder + "/" + filename + ".pddl");
        try
        {
            pddlFile.createNewFile();
            //System.out.println("New file \"myfile.txt\" has been created to the current directory");
        }
        catch (IOException ex)
        {
            Logger.getLogger(NewPDDLProjectDialog.class.getName()).log(Level.SEVERE, null, ex);
        }
       
        
        BufferedWriter writer;
        try
        {
            writer = new BufferedWriter(new FileWriter(pddlFile));
            writer.write(data);
            writer.flush();
        }
        catch (IOException ex)
        {
            Logger.getLogger(NewPDDLProjectDialog.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void createItProjectFile()
    {
        XMLOutputter outputter = new XMLOutputter();
        FileWriter file;
        Document doc = null;

        Element root = new Element("pddlproject");
        root.addContent(new Element("name").setText(projectName));
        root.addContent(new Element("description"));

        Element generalInfo = new Element("generalInformation");
        generalInfo.addContent(new Element("tool").setText("itSIMPLE"));
        generalInfo.addContent(new Element("version").setText("4.0.10"));
        root.addContent(generalInfo);

        Element pddldomains = new Element("pddldomains");
        Element pddldomain = new Element("pddldomain");
        pddldomain.addContent(new Element("name").setText("domain.pddl"));
        pddldomains.addContent(pddldomain);
        root.addContent(pddldomains);
        root.addContent(new Element("problemFolder"));
        root.addContent(new Element("problemInstances"));

        doc = new Document(root);
        String filePath = projectFolder.getPath()+"/itProject.xml";
        try
        {
            file = new FileWriter(filePath);
            outputter.output(doc, file);
            file.close();
        }
        catch (IOException ex) {
            Logger.getLogger(NewPDDLProjectDialog.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public String getPDDLProjectFilePath()
    {
        return projectFolder.getPath() + "/itProject.xml";
    }

    public boolean isCanOpen() {
        return canOpen;
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("New PDDL Project Folder");
        setLocationByPlatform(true);

        jLabel1.setText("Project Name:");

        jLabel2.setText("Project Folder:");

        jButton1.setText("...");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Cancel");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Ok");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextField1, javax.swing.GroupLayout.DEFAULT_SIZE, 273, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jTextField2, javax.swing.GroupLayout.DEFAULT_SIZE, 240, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(jButton1))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2)
                    .addComponent(jButton3))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        this.dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        String lastOpenFolder = "";
        Element lastOpenFolderElement = ItSIMPLE.getItSettings().getChild("generalSettings").getChild("lastOpenFolder");
        if (lastOpenFolderElement != null)
            lastOpenFolder = lastOpenFolderElement.getText();

        JFileChooser fc = new JFileChooser(lastOpenFolder);
        fc.setDialogTitle("Select Project Folder");
        fc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        //fc.setFileFilter(new PNMLfileFilter());

        int returnVal = fc.showOpenDialog(ItSIMPLE.getItSIMPLEFrame());
        if (returnVal == JFileChooser.APPROVE_OPTION)
        {
            projectFolder = fc.getSelectedFile();
            jTextField2.setText(projectFolder.getPath());
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        projectName = jTextField1.getText();
        if (projectName.equals(""))
        {
            JOptionPane.showMessageDialog(
                                        this.parent,
                                        "Sorry, project's name could not be blank"/* + typedText + "\" "
                                        + "isn't a valid response.\n"
                                        + "Please enter "
                                        + magicWord */+ ".",
                                        "Name Error",
                                        JOptionPane.ERROR_MESSAGE);
            //typedText = null;
            jTextField1.requestFocusInWindow();
        }
        else if (projectFolder == null)
        {
            JOptionPane.showMessageDialog(
                                        this.parent,
                                        "Sorry, project's folder could not be blank"/* + typedText + "\" "
                                        + "isn't a valid response.\n"
                                        + "Please enter "
                                        + magicWord */+ ".",
                                        "Folder Error",
                                        JOptionPane.ERROR_MESSAGE);
            //typedText = null;
            jTextField2.requestFocusInWindow();
        }
        else
        {
            String domainData = "(define (domain "+projectName+")\n"+
                       "(:requirements :typing)\n\n" +
                       "(:types\n\n" +
                       ")\n\n" +
                       "(:predicates\n\n" +
                       ")\n\n\n" +
                       ")";
            createPDDLFile("domain", domainData);

            String problemData = "(define (problem problem1)\n"+
                                 "(:domain "+projectName+")\n"+
                                 "(:objects\n\n"+
                                 ")\n\n"+
                                 "(:init\n\n"+
                                 ")\n\n"+
                                 "(:goal\n\n"+
                                 ")\n"+
                                 ")";
            createPDDLFile("problem", problemData);
            createItProjectFile();
            canOpen = true;
            this.setVisible(false);
        }
    }//GEN-LAST:event_jButton3ActionPerformed


//    /**
//    * @param args the command line arguments
//    */
//    public static void main(String args[]) {
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                NewPDDLProjectDialog dialog = new NewPDDLProjectDialog(new javax.swing.JFrame(), true);
//                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
//                    public void windowClosing(java.awt.event.WindowEvent e) {
//                        System.exit(0);
//                    }
//                });
//                dialog.setVisible(true);
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    // End of variables declaration//GEN-END:variables

}
