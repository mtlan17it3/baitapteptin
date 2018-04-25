package test;

import java.awt.EventQueue;
import java.awt.Label;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;



import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.lang.System.Logger.Level;
import java.util.logging.Logger;
import java.awt.event.ActionEvent;

public class test_bai2 {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private FileWriter f=null;
	private PrintWriter pr=null;
	private BufferedWriter bw=null;
	private BufferedReader br=null;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					test_bai2 window = new test_bai2();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public test_bai2() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblHoTen = new JLabel("ho ten");
		lblHoTen.setBounds(81, 11, 46, 14);
		frame.getContentPane().add(lblHoTen);
		
		textField = new JTextField();
		textField.setBounds(223, 8, 133, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblNgaySinh = new JLabel("ngay sinh");
		lblNgaySinh.setBounds(81, 57, 46, 14);
		frame.getContentPane().add(lblNgaySinh);
		
		textField_1 = new JTextField();
		textField_1.setBounds(223, 54, 133, 20);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblEmail = new JLabel("email");
		lblEmail.setBounds(81, 107, 46, 14);
		frame.getContentPane().add(lblEmail);
		
		textField_2 = new JTextField();
		textField_2.setBounds(223, 104, 133, 20);
		frame.getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblDienThoai = new JLabel("dien thoai");
		lblDienThoai.setBounds(81, 159, 58, 14);
		frame.getContentPane().add(lblDienThoai);
		
		textField_3 = new JTextField();
		textField_3.setBounds(223, 153, 133, 20);
		frame.getContentPane().add(textField_3);
		textField_3.setColumns(10);
		
		JButton btnSave = new JButton("save");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				FileInputStream fis=null;
				FileOutputStream fos=null;
				String filename="demo.txt";
				try {
					String st=textField.getText();
					String st1=textField_1.getText();
					String st2=textField_2.getText();
					String st3=textField_3.getText();
					//FileWriter f = new FileWriter(new File(filename));
			        //BufferedWriter bw = new BufferedWriter(f);
					FileOutputStream fileOutputStream = new FileOutputStream(filename);
		            ObjectOutputStream objectOutputStream =  new ObjectOutputStream(fileOutputStream);
		            objectOutputStream.writeObject(st);
		            objectOutputStream.writeObject(st1);
		            objectOutputStream.writeObject(st2);
		            objectOutputStream.writeObject(st3);
		            objectOutputStream.close();
		            fileOutputStream.close();
				} catch (Exception e) {
					  Logger.getLogger(test_bai2.class.getName()).log(Level.SEVERE, null, e);
					// TODO: handle exception
				}
				 try {
			            FileInputStream fileInputStream = new FileInputStream(filename);
			            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
			            
			            Object st = objectInputStream.readObject();
			            Object st1 = objectInputStream.readObject();
			            Object st2 = objectInputStream.readObject();
			            Object st3 = objectInputStream.readObject();
			        } catch (FileNotFoundException ex) {
			            Logger.getLogger(test_bai2.class.getName()).log(Level.SEVERE, null, ex);
			        }catch ( Exception ex){
			            Logger.getLogger(test_bai2.class.getName()).log(Level.SEVERE, null, ex);    
			        }
			/*try {
					 FileReader fileReader = new FileReader(new File(filename));
			         BufferedReader br = new BufferedReader(fileReader);
			         String target = "";
			         target = br.readLine();
			         System.out.println(target);
				} catch (Exception e) {
					// TODO: handle exception
				}
				finally {
					try {
						
						f.close();
						bw.close();
						br.close();
						fos.close();
						fis.close();
					} catch (Exception e) {
					System.out.println(e.getMessage());
						
						// TODO: handle exception
					}
				}*/
			}
			
		});
		btnSave.setBounds(56, 211, 89, 23);
		frame.getContentPane().add(btnSave);
		
		JButton btnCancel = new JButton("cancel");
		btnCancel.setBounds(236, 211, 89, 23);
		frame.getContentPane().add(btnCancel);
	}
}
