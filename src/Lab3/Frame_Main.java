package Lab3;

import java.util.*;
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;

public class Frame_Main extends javax.swing.JFrame {
    Variables v = new Variables();
    String regex = "[a-zA-Z0-9.]+@[a-zA-Z]+\\.[a-z]+";
    ObjectInputStream ois;
    ObjectOutputStream oos;

    void ois(Variables v)throws IOException, ClassNotFoundException{
        ois = new ObjectInputStream(new FileInputStream("Resources/List.txt"));
        this.v = (Variables)ois.readObject();
        ois.close();
    }
    void oos(Variables v)throws IOException, ClassNotFoundException{
        oos = new ObjectOutputStream(new FileOutputStream("Resources/List.txt"));
        oos.writeObject(v);
        oos.close();
    }

    public Frame_Main(){
        initComponents();
        this.v.source = new ArrayList<>();
        DefaultComboBoxModel<String>  model = new DefaultComboBoxModel<>(new Vector<>(v.source));
        listOfContent.setModel(model);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        listOfContent = new javax.swing.JList<>();
        textFieldText = new javax.swing.JTextField();
        buttonEdit = new javax.swing.JButton();
        buttonDelete = new javax.swing.JButton();
        buttonAdd = new javax.swing.JButton();
        buttonTakeListFromFile = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        listOfContent.setToolTipText("");
        listOfContent.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jScrollPane1.setViewportView(listOfContent);

        textFieldText.setToolTipText("");

        buttonEdit.setText("Редактировать");
        buttonEdit.setToolTipText("Чтобы отредактировать элемент списка выберите этот элемент, нажмите кнопку Редактировать, измените его в текстовой строке, и нажмите редактировать снова");
        buttonEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonEditActionPerformed(evt);
            }
        });

        buttonDelete.setText("Удалить");
        buttonDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonDeleteActionPerformed(evt);
            }
        });

        buttonAdd.setText("Добавить");
        buttonAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonAddActionPerformed(evt);
            }
        });

        buttonTakeListFromFile.setText("Взять лист из файла");
        buttonTakeListFromFile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonTakeListFromFileActionPerformed(evt);
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
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addComponent(buttonAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(buttonEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(buttonDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                        .addComponent(textFieldText)
                                                        .addComponent(jScrollPane1))
                                                .addGap(0, 0, Short.MAX_VALUE))
                                        .addComponent(buttonTakeListFromFile, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addContainerGap())
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(textFieldText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(buttonAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(buttonEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(buttonDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(buttonTakeListFromFile, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 8, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>

    private void buttonAddActionPerformed(java.awt.event.ActionEvent evt) {
        if(textFieldText.getText().matches(regex)){
            try {
                v.source.add(textFieldText.getText());
                oos(v);
                textFieldText.setText("");
                DefaultComboBoxModel<String>  model = new DefaultComboBoxModel<>(new Vector<>(v.source));
                listOfContent.setModel(model);
            } catch (IOException | ClassNotFoundException ex) {
                Logger.getLogger(Frame_Main.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        else{
            JOptionPane.showMessageDialog(null, "Почта введена неправильно!\nПример: myemail@email.com");
        }
    }

    private void buttonEditActionPerformed(java.awt.event.ActionEvent evt) {
        if(!listOfContent.isSelectionEmpty()){
            if(textFieldText.getText().isEmpty()){
                textFieldText.setText(v.source.get(listOfContent.getSelectedIndex()));
            }
            else{
                if(textFieldText.getText().matches(regex)){
                    try {
                        v.source.set(listOfContent.getSelectedIndex(), textFieldText.getText());
                        oos(v);
                        textFieldText.setText("");
                        DefaultComboBoxModel<String>  model = new DefaultComboBoxModel<>(new Vector<>(v.source));
                        listOfContent.setModel(model);
                    } catch (IOException | ClassNotFoundException ex) {
                        Logger.getLogger(Frame_Main.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                else{
                    JOptionPane.showMessageDialog(null, "Почта введена неправильно!\nПример: myemail@email.com");
                }
            }
        }
        else{
            JOptionPane.showMessageDialog(null, "Ничего не выбрано!");
        }
    }

    private void buttonDeleteActionPerformed(java.awt.event.ActionEvent evt) {
        if(!listOfContent.isSelectionEmpty()){
            try {
                v.source.remove(listOfContent.getSelectedIndex());
                oos(v);
                DefaultComboBoxModel<String>  model = new DefaultComboBoxModel<>(new Vector<>(v.source));
                listOfContent.setModel(model);
            } catch (IOException | ClassNotFoundException ex) {
                Logger.getLogger(Frame_Main.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        else{
            JOptionPane.showMessageDialog(null, "Ничего не выбрано!");
        }
    }

    private void buttonTakeListFromFileActionPerformed(java.awt.event.ActionEvent evt) {
        try {
            ois(v);
            DefaultComboBoxModel<String>  model = new DefaultComboBoxModel<>(new Vector<>(v.source));
            listOfContent.setModel(model);
        } catch (IOException | ClassNotFoundException ex) {
            Logger.getLogger(Frame_Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]){
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
            java.util.logging.Logger.getLogger(Frame_Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Frame_Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Frame_Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Frame_Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Frame_Main().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify
    private javax.swing.JButton buttonAdd;
    private javax.swing.JButton buttonDelete;
    private javax.swing.JButton buttonEdit;
    private javax.swing.JButton buttonTakeListFromFile;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JList<String> listOfContent;
    private javax.swing.JTextField textFieldText;
    // End of variables declaration
}
