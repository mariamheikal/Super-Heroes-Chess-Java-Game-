package view;
import java.awt.Color;
import java.awt.Container;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javafx.scene.control.*;
import java.awt.*;
import javax.swing.*;
import javax.swing.event.MouseInputAdapter;


public class Help extends JFrame implements MouseListener{
 JFrame f;
 JLabel label;
  
 
 public static void infoBox(String infoMessage, String titleBar, String headerMessage)
 {
  
	
 }
 public static void main(String [] args){
	 new Help();
 }
	
	


 public Help(){
 JFrame frame = new JFrame();
 frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
 frame.setLayout(new FlowLayout());
 frame.setSize(new Dimension(200, 100));
 frame.setTitle("A frame");

 JLabel label = new JLabel();
 label.setText("Move the mouse over me!");
 frame.add(label);
ImageIcon i = new ImageIcon("C:\\Users\\Mariam Heikal\\Downloads\\M2_Code\\SHC_M2\\resources\\health-bar-color-change.gif");
JLabel n = new JLabel(i);
frame.add(n);
MovementListener mListener = new MovementListener(); 
 label.addMouseListener(mListener);
 label.addMouseMotionListener(mListener);

 frame.setVisible(true);
 }

@Override
public void mouseClicked(MouseEvent arg0) {
	// TODO Auto-generated method stub
	
}

@Override
public void mouseEntered(MouseEvent arg0) {
	// TODO Auto-generated method stub
	
}

@Override
public void mouseExited(MouseEvent arg0) {
	// TODO Auto-generated method stub
	
}

@Override
public void mousePressed(MouseEvent arg0) {
	// TODO Auto-generated method stub
	
}

@Override
public void mouseReleased(MouseEvent arg0) {
	// TODO Auto-generated method stub
	
}
 
	
	
public class MovementListener extends MouseInputAdapter {
 public void mouseEntered(MouseEvent event) {
 JOptionPane.showMessageDialog(null, "Mouse entered!");
 }
 }
	
	
		
}
