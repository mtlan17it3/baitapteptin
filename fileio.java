package test;
import java.io.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class fileio extends JFrame implements ActionListener{
	JTextArea ta=new JTextArea();
	JButton saveas=new JButton("save as..");
	JFileChooser chooser;
	FileWriter f;
	public fileio()
	{
		Container cont=this.getContentPane();
		saveas.addActionListener(this);
		cont.add(ta);
		cont.add(saveas, "South");
		this.setSize(400, 400);
		this.setVisible(true);
		
	}
	public void actionPerformed(ActionEvent e)
	{
		chooser=new JFileChooser();
		chooser.setCurrentDirectory(new java.io.File("."));
		chooser.setDialogTitle("save as");
		if(chooser.showSaveDialog(this)==JFileChooser.APPROVE_OPTION)
		{
			String filename=chooser.getSelectedFile().getAbsolutePath();
			fileio(filename);
			
		}
		
	}
public void fileio(String filename)
{
	try {
		String content=ta.getText();
		f=new FileWriter(filename);
		f.write(content);
		f.flush();
		f.close();
	} catch (Exception e) {
		e.printStackTrace();
		
		// TODO: handle exception
	}
}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new fileio();
		
	}

}
