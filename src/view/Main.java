package view;



import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;






import model.game.Game;
import model.game.Player;


public class Main extends JFrame{
	
	    private JButton start ;
	    private JButton help ;
	    private JButton exit ;
	    private JLayeredPane lpane = new JLayeredPane();
	    private JPanel background;
	    private JLabel label;
	    private MenuPanel menuPanel;
	    private JPanel names;
	    
	    private JLabel pic_label;
	    private Icon pic_image = new ImageIcon("C:\\Users\\nadaa\\workspace\\M3Updated\\src\\view\\Charcters PNG\\picintro.png");
	    
	    
	    private Icon Startbutton = new ImageIcon("C:\\Users\\nadaa\\workspace\\M3Updated\\src\\view\\Charcters PNG\\StartFont_resize_tkhen.png");
	    private Icon helpbutton = new ImageIcon("C:\\Users\\nadaa\\workspace\\M3Updated\\src\\view\\Charcters PNG\\helpFont_resize_rofe3.png");
	    private Icon exitbutton = new ImageIcon("C:\\Users\\nadaa\\workspace\\M3Updated\\src\\view\\Charcters PNG\\ExitFont_resize_rofe3.png");

	   

	    public JFrame getFrame(){
	    	return this;
	    }
	    public JButton getStart() {
			return start;
		}


		public void setStart(JButton start) {
			this.start = start;
		}


		public JButton getHelp() {
			return help;
		}


		public void setHelp(JButton help) {
			this.help = help;
		}


		public JButton getExit() {
			return exit;
		}


		public void setExit(JButton exit) {
			this.exit = exit;
		}


	


		public void setBackground(JPanel background) {
			this.background = background;
		}


		public MenuPanel getMenuPanel() {
			return menuPanel;
		}


		public void setMenuPanel(MenuPanel menuPanel) {
			this.menuPanel = menuPanel;
		}

	

		public Main() throws IOException
	    {
//			frame = new JFrame();
			setLayout(new BorderLayout());
	        add(lpane, BorderLayout.CENTER);
	       setExtendedState(JFrame.MAXIMIZED_BOTH); 
	      setDefaultCloseOperation(EXIT_ON_CLOSE);
	        
	     
            
	        
	        

	       
	      
	    	menuPanel = new MenuPanel();
            //menuPanel.add(label2);
	    
	        TitledBorder border = new TitledBorder("Super Heros Chess");
			   border.setTitleFont(new Font ("BOLD" ,Font.ROMAN_BASELINE,35));
			   border.setTitleJustification(TitledBorder.CENTER);
			   border.setTitlePosition(TitledBorder.DEFAULT_JUSTIFICATION);
			   menuPanel.setBorder(border);	
	       
	
	       add(menuPanel);
		//	add(lpane);
	        pack();
	        setVisible(true);
	     
	    }
		
		
		
		

	    ///////// MENUPANEL CLASS ////////
	    
	   
	    
	    
	    public class MenuPanel extends JPanel //implements ActionListener {
	    	
	    {
	     
	    	MenuPanel() throws IOException {
	    		
	    		
	    		
	    		

	    		
	    		
	    		
	    		
	    		
	            setOpaque(true);
	            setLayout(new FlowLayout());
	            
	          

	            start = new JButton();
		      	start.setFont(new Font("arial",Font.BOLD,30));
		      	start.setActionCommand("Start");
		      	start.setBackground(new Color(0x5e, 0x81, 0x9d));
		      	start.setIcon(Startbutton);
	      	  
		      	
		      	///help button
		      	// help = new JButton();
		      	 // help.setFont(new Font("arial",Font.BOLD,30));
		      	// help.setIcon(helpbutton);
		      	 
		      	  //help.setActionCommand("Help");
	              //help.setBackground(new Color(0x5e, 0x81, 0x9d));
	              
	              /////exit buttton
	              
	              exit = new JButton();
		      	  exit.setActionCommand("Exit");
		      	  exit.setFont(new Font("arial",Font.BOLD,30));
		      	 exit.setBackground(new Color(0x5e, 0x81, 0x9d));
		      	  exit.setIcon(exitbutton);
		      	    
	      	
		      	 
		      	

		      	  //////backgrounddd 
		      	  
			     	label = new JLabel(new ImageIcon("C:\\Users\\nadaa\\workspace\\M3Updated\\src\\view\\Charcters PNG\\topp.gif"));
			      	  
		          
		      	
	            
	            
		      	  
		      	  /////add to frame all 
		      	  
		      	add(label, BorderLayout.SOUTH);
			 	   add(start,BorderLayout.CENTER);
		     	   add(exit,BorderLayout.CENTER);
		     	    //add(help,BorderLayout.CENTER);
			       setName("Super Heroes Chess");
			       
			       
			        ////imageee
		      	
		      	 
		      	  pic_label=new JLabel();
		      	  pic_label.setIcon(pic_image);
		      	  add(pic_label,BorderLayout.NORTH);

	      	  
			       setBackground( new Color(0x5e, 0x81, 0x9d));

	      	   
	      	    setVisible(true);
	      	





	        }
	    	
	    	
	    }

	}



