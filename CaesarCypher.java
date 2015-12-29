/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package caesarcypher;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

/**
 *
 * @author Vahan Babushkin
 */
public class CaesarCypher extends JFrame{
        JTextArea jtfCyphertext = new JTextArea(2,10);
        JComboBox jcbShift = new JComboBox(new Object[]{"1", "2", "3", "4","5","6","7","8","9","10","11","12","13","14","15","16","17","18","19","20","21","22","23"});
        JTextArea jtfPlaintext = new JTextArea(2,10);
        JButton decrypt = new JButton("Decrypt");
        JButton encrypt = new JButton("Encrypt");
    /**
     * @param args the command line arguments
     */
    public CaesarCypher(){
        setLayout(new FlowLayout());
        JPanel p1 = new JPanel(new GridLayout(4, 2,5,5));
        JPanel p2 = new JPanel(new FlowLayout());
        jtfCyphertext.setLineWrap(true);
        jtfPlaintext.setLineWrap(true);
        p1.add(new JLabel("Shifting parameter"));
        jcbShift.setForeground(Color.red);
        jcbShift.setBackground(Color.white);
        jcbShift.setSelectedItem("1");
        
        p1.add(jcbShift);
        p1.add(new JLabel("Cyphertext"));
        p1.add(jtfCyphertext);
        p1.add(new JLabel("Plaintext"));
        p1.add(jtfPlaintext);
        p1.setBorder(new TitledBorder("Caesar's Cypher"));
        p1.add(decrypt);
        p1.add(encrypt);
        add(p1);
     
        decrypt.addActionListener(new ActionListener() {
            @Override 
            public void actionPerformed(ActionEvent e) {
                String caesar =jtfCyphertext.getText();
                String plainText="";
                char newChar;
                int shift=jcbShift.getSelectedIndex()+1;
                for(int i=0;i<caesar.length(); i++){
                    if(Character.isLetter((char)(caesar.charAt(i)-shift)))
                    newChar=(char)(caesar.charAt(i)-shift);
                else
                    newChar=(char)(26+caesar.charAt(i)-shift);
                    plainText=plainText+newChar;
                }
                jtfPlaintext.setText(plainText);
                System.out.println("shift = "+shift+": "+plainText);
                plainText="";      
            }
        });
        encrypt.addActionListener(new ActionListener() {
            @Override 
            public void actionPerformed(ActionEvent e) {
                String caesar =jtfPlaintext.getText();
                String cyphertext="";
               
                char newChar;
                int shift=jcbShift.getSelectedIndex()+1;
                for(int i=0;i<caesar.length(); i++){
                    if(Character.isLetter((char)(caesar.charAt(i)+shift)))
                    newChar=(char)(caesar.charAt(i)+shift);
                else
                    newChar=(char)(caesar.charAt(i)+shift-26);
                    cyphertext=cyphertext+newChar;
                }
                jtfCyphertext.setText(cyphertext);
                System.out.println("shift = "+shift+": "+cyphertext);
                cyphertext="";  
            }
        });
        
    }
    public static void main(String[] args) {
        CaesarCypher frame = new CaesarCypher();
        frame.setTitle("Caesar Cypher");
        frame.pack();
        frame.setLocationRelativeTo(null); // Center the frame   
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
