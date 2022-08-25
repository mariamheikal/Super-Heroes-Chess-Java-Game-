package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;




import model.game.Game;
import model.game.Player;
import model.pieces.Piece;
import model.pieces.heroes.ActivatablePowerHero;
import model.pieces.heroes.Armored;
import model.pieces.heroes.Medic;
import model.pieces.heroes.Ranged;
import model.pieces.heroes.Speedster;
import model.pieces.heroes.Super;
import model.pieces.heroes.Tech;
import model.pieces.sidekicks.SideKick;



public class GameGUI extends JPanel {
	
private JPanel main;
///////////////////////////////
 private JPanel gameBoard;
 ///////////////////////////////
 private JLabel imgLabel;
 private JLabel imgLabel2;
 ///////////////////////////////////////
 private JPanel healthbarPanelP2;
 private JProgressBar healthbarP2;
 /////////////////////////////////////
 private JPanel healthbarPanelP1;
 private JProgressBar healthbarP1;
 ////////////////////////////////////////
 JPanel ready;
 private JButton cancel;
 private JButton perform;
 private JTextArea showCurrentPlayer;

 ////////////////////////////////////////
 private MyButton [][] pieceButtons;
 private ArrayList<Piece> deadCharactersP1;
 private String [] deadCharactersP1List;
 private JComboBox<String> deadCharactersP1Dropdown;
 private ArrayList<Piece> deadCharactersP2;
 private String [] deadCharactersP2List;
 private JComboBox<String> deadCharactersP2Dropdown; 
 private MyButton [] deadCharactersP1B;
 private MyButton [] deadCharactersP2B;
 private JButton viewP2DeadCharacters;

 private JPanel eastPanel;
 
 ////////////////////////////////////////////
 private JFrame deadCharP1;
 private JFrame deadCharP2;
 private JPanel deadP1;
 private JPanel deadP2;
 private ButtonGroup groupP1;
 private ButtonGroup groupP2;
private JButton [] buttonsP1;
private JButton[] buttonsP2;

private static Game game;

 /////////////////////////////////////////////




private Icon Progress_bar_0image=new ImageIcon("C:\\Users\\nadaa\\workspace\\M3Updated\\src\\view\\Charcters PNG\\workshopResize40060-00.png");
private Icon Progress_bar_1image=new ImageIcon("C:\\Users\\nadaa\\workspace\\M3Updated\\src\\view\\Charcters PNG\\workshopResize40060-01.png");
private Icon Progress_bar_2image = new ImageIcon("C:\\Users\\nadaa\\workspace\\M3Updated\\src\\view\\Charcters PNG\\workshopResize40060-02.png");
private Icon Progress_bar_3image= new ImageIcon("C:\\Users\\nadaa\\workspace\\M3Updated\\src\\view\\Charcters PNG\\workshopResize40060-03.png");
private Icon Progress_bar_4image= new ImageIcon("C:\\Users\\nadaa\\workspace\\M3Updated\\src\\view\\Charcters PNG\\workshopResize40060-04.png");
private Icon Progress_bar_5image= new ImageIcon("C:\\Users\\nadaa\\workspace\\M3Updated\\src\\view\\Charcters PNG\\workshopResize40060-05.png");
private Icon Progress_bar_6image= new ImageIcon("C:\\Users\\nadaa\\workspace\\M3Updated\\src\\view\\Charcters PNG\\workshopResize40060-06.png");
private Icon Progress_bar_7image= new ImageIcon("C:\\Users\\nadaa\\workspace\\M3Updated\\src\\view\\Charcters PNG\\workshopResize40060-07.png");
 /////////////////////////////////////////////

private Icon space  =new ImageIcon("C:\\Users\\nadaa\\workspace\\M3Updated\\src\\view\\Charcters PNG\\topp.gif");
private JLabel label_space= new JLabel(space);	  



private Icon blacksidekick_img = new ImageIcon("C:\\Users\\nadaa\\workspace\\M3Updated\\src\\view\\Charcters PNG\\blacksidekick1.png");
private JLabel blacksidekick_label;

private Icon blackmedic_img=new ImageIcon("C:\\Users\\nadaa\\workspace\\M3Updated\\src\\view\\Charcters PNG\\blackmedic1.png");
private JLabel blackmedic_label;

private Icon blacktec_img=new ImageIcon("C:\\Users\\nadaa\\workspace\\M3Updated\\src\\view\\Charcters PNG\\blacktech1.png");
private JLabel blacktec_label;

private Icon blacksuper_img=new ImageIcon("C:\\Users\\nadaa\\workspace\\M3Updated\\src\\view\\Charcters PNG\\blacksuper1.png");
private JLabel blacksuper_label1;

private Icon blacrangeded_img=new ImageIcon("C:\\Users\\nadaa\\workspace\\M3Updated\\src\\view\\Charcters PNG\\blackranged1.png");
private JLabel blackranged_label;

private Icon blackarmored_img=new ImageIcon("C:\\Users\\nadaa\\workspace\\M3Updated\\src\\view\\Charcters PNG\\blackarmored1.png");
private JLabel blackarmored_label;

private Icon blackspeedster_img=new ImageIcon("C:\\Users\\nadaa\\workspace\\M3Updated\\src\\view\\Charcters PNG\\blackspeedster1.png");
private JLabel blackspeedster_label;
//////////////////////////////////////////////////////////



////

private Icon tech_p2 = new ImageIcon("C:\\Users\\nadaa\\workspace\\M3Updated\\src\\view\\Charcters PNG\\techplayer2...gif");
private Icon sidekick_p2=new ImageIcon("C:\\Users\\nadaa\\workspace\\M3Updated\\src\\view\\Charcters PNG\\sidekickplayer2...gif");

private Icon medic_p2 = new ImageIcon("C:\\Users\\nadaa\\workspace\\M3Updated\\src\\view\\Charcters PNG\\medicplayer2...4.gif");

private Icon super_p2 =new ImageIcon("C:\\Users\\nadaa\\workspace\\M3Updated\\src\\view\\Charcters PNG\\superplayer2....gif");

private Icon ranged_p2 =new ImageIcon("C:\\Users\\nadaa\\workspace\\M3Updated\\src\\view\\Charcters PNG\\rangedplayer2.....gif");

private Icon armored_p2 = new ImageIcon("C:\\Users\\nadaa\\workspace\\M3Updated\\src\\view\\Charcters PNG\\armoredplayer2....gif");

private Icon speedster_p2 = new ImageIcon("C:\\Users\\nadaa\\workspace\\M3Updated\\src\\view\\Charcters PNG\\speedplayer2....gif");
//////////////////////////////////////////////////////////////////////////////




//////////////////////////////////////////////////////////////////////////////////
private Icon speedster_p1 = new ImageIcon("C:\\Users\\nadaa\\workspace\\M3Updated\\src\\view\\Charcters PNG\\speedsterspeed.gif");
private Icon sidekick_p1= new ImageIcon("C:\\Users\\nadaa\\workspace\\M3Updated\\src\\view\\Charcters PNG\\sidekickplayer1.gif");


private Icon tech_p1 = new ImageIcon("C:\\Users\\nadaa\\workspace\\M3Updated\\src\\view\\Charcters PNG\\techplayer1.gif");
private Icon ranged_p1 = new ImageIcon("C:\\Users\\nadaa\\workspace\\M3Updated\\src\\view\\Charcters PNG\\rangedplayer1.gif");
private Icon medic_p1 = new ImageIcon("C:\\Users\\nadaa\\workspace\\M3Updated\\src\\view\\Charcters PNG\\medicplayer1.gif");
private Icon super_p1 =new ImageIcon("C:\\Users\\nadaa\\workspace\\M3Updated\\src\\view\\Charcters PNG\\superplayer1.gif");
private Icon armored_p1 = new ImageIcon("C:\\Users\\nadaa\\workspace\\M3Updated\\src\\view\\Charcters PNG\\armoredplayer1.gif");

/////////////////////////////////////////////////////////////////////////////

private Icon armoredability_p1 = new ImageIcon("C:\\Users\\nadaa\\workspace\\M3Updated\\src\\view\\Charcters PNG\\armoredabilityplayer1.gif");
private Icon armoredability_p2 = new ImageIcon("C:\\Users\\nadaa\\workspace\\M3Updated\\src\\view\\Charcters PNG\\armordabilityplayer2....gif");








/////////////////////////////////////////////////
 public static void main(String[] args) throws IOException {
	 Player p1 = new Player("s");
	 Player p2= new Player("a");
	   
	  	
	   game = new Game(p1,p2);
	//new GameGUI(game,p1,p2);
 }
 
 
 
 public GameGUI(Game game, Player p1, Player p2, ActionListener listener) throws IOException {
  
	

	  setBounds(50, 50, 800, 600);
	  
	  
	  //creating the board with the pieces
	  gameBoard = new JPanel();
	  gameBoard.setLayout(new GridLayout(7, 6));
	  pieceButtons = new MyButton [7][6];
	   for (int i = 0; i < 7; i++){
	    for(int j =0; j <6; j++){
	     
	    	Piece p = game.getCellAt(i, j).getPiece();
	     if(p!=null){
	     if (p instanceof Super) 
	      {
	     MyButton button = new MyButton();
	     button.setToolTipText("Hero Type: Super \n " +" Hero Name "+p.getName()+"\n"+" Power Used: "+ getPowerState(p)+";"+" Owner "+p.getOwner().getName());
	     gameBoard.add(button);
        // button.setBackground(new Color(0xa2, 0x65, 0x3e));
	   
	     button.setI(p.getPosI());
	     button.setJ(p.getPosJ());
	     pieceButtons [i][j] = button;
	     if(p.getOwner()==game.getPlayer1())
		     button.setIcon(super_p1);
		
		 else
		     button.setIcon(super_p2);
	      }
	     if (p instanceof Ranged) 
	     {
	    	 MyButton button = new MyButton();
	  
	     button.setToolTipText("Hero Type: Ranged\n " +" Hero Name "+p.getName()+"\n"+" Power Used: "+ getPowerState(p)+";"+" Owner "+p.getOwner().getName());
	     gameBoard.add(button);
         button.setBackground(new Color(0xa2, 0x65, 0x3e));
	     button.setI(p.getPosI());
	     button.setJ(p.getPosJ());
	     pieceButtons [i][j] = button;
	     if(p.getOwner()==game.getPlayer1())
		     button.setIcon(ranged_p1);
	     else
		     button.setIcon(ranged_p2);
	      }
	     if (p instanceof Medic) 
	     {MyButton button = new MyButton();
	     button.setToolTipText("Hero Type: Medic\n " +" Hero Name "+p.getName()+"\n"+" Power Used: "+ getPowerState(p)+";"+" Owner "+p.getOwner().getName());
	     gameBoard.add(button);
         button.setBackground(new Color(0xa2, 0x65, 0x3e));
	     button.setI(p.getPosI());
	     button.setJ(p.getPosJ());
	     pieceButtons [i][j] = button;
	     if(p.getOwner()==game.getPlayer1())
		     button.setIcon(medic_p1);
	     else
		     button.setIcon(medic_p2);
	      }
	     if (p instanceof Armored)
	     
	     {
	    	 MyButton button = new MyButton();
	     button.setToolTipText("Hero Type: Armored\n " +" Hero Name "+p.getName()+"\n"+" Armor State: "+ getPowerState(p)+";"+" Owner "+p.getOwner().getName());
	     gameBoard.add(button);
         button.setBackground(new Color(0xbe, 0xfd, 0x73));
	     button.setI(p.getPosI());
	     button.setJ(p.getPosJ());
	     pieceButtons [i][j] = button;
	     if(p.getOwner()==game.getPlayer1()){
	    	 if(((Armored) p).isArmorUp())
		     button.setIcon(armored_p1);
		     else button.setIcon(armoredability_p1);

	       }
		 else{
		     if(((Armored) p).isArmorUp())
			 button.setIcon(armored_p2);
		     else button.setIcon(armoredability_p2);
		     }
	     }
	     
	    
	     else if (p instanceof Speedster) 
	     {
	    	   MyButton button = new MyButton();
	     button.setToolTipText("Hero Type: Speedster\n " +" Hero Name "+p.getName()+"\n"+" Power State: "+ getPowerState(p)+";"+" Owner "+p.getOwner().getName());
	     gameBoard.add(button);
         button.setBackground(new Color(0xb1, 0xff, 0x65));
	     button.setI(p.getPosI());
	     button.setJ(p.getPosJ());
	     pieceButtons [i][j] = button;
	     if(p.getOwner()==game.getPlayer1())
		     button.setIcon(speedster_p1);
	     else
		     button.setIcon(speedster_p2);


	     }
	     else if (p instanceof Tech)  
	     {
		 
	     MyButton button = new MyButton();
	   
         button.setBackground(new Color(0xfd, 0xfd, 0xfe));
	     button.setToolTipText("Hero Type: Tech \n " +" Hero Name "+p.getName()+"\n"+" Power Used: "+ getPowerState(p)+";"+" Owner "+p.getOwner().getName());
	     gameBoard.add(button);
	     button.setI(p.getPosI());
	     button.setJ(p.getPosJ());
	     pieceButtons [i][j] = button;
	     if(p.getOwner()==game.getPlayer1())
		     button.setIcon(tech_p1);
	     else{
	    	 System.out.println("tech");
		    button.setIcon(tech_p2);
	     }

	     }
	     else  if (p instanceof SideKick) 
	     {
	    	MyButton button = new MyButton();
	    	
	     button.setToolTipText("Hero Type: SideKick \n "+" Owner "+p.getOwner().getName());     
	     button.setI(p.getPosI());
	     button.setJ(p.getPosJ());
	     gameBoard.add(button);
         button.setBackground(new Color(0xfd, 0xfd, 0xfe));
	     pieceButtons [i] [j] = button;
	     if(p.getOwner()==game.getPlayer1())
		     button.setIcon(sidekick_p1);
	     else
		     button.setIcon(sidekick_p2);
	
	     }
	     } 
	    else
	    { MyButton button = new MyButton();
	         gameBoard.add(button); 
	         button.setI(i);
	         button.setJ(j);
	         button.setBackground( new Color(0x9d, 0xbc, 0xd4));
	         pieceButtons [i] [j] = button;

	    
	         }
	     
	    }
	   }
	 
	   
	   
	  
		
		for (int i = 0; i < 7; i++) {
			for (int j = 0; j < 6; j++) {
				getPieceButtons()[i][j].addActionListener(listener);
				    	 getPieceButtons()[i][j].setBackground(Color.GRAY);
				 

	
			}
		}
		
		
	   
	   
	  add(gameBoard,BorderLayout.CENTER);
	   
  //////////////////////////////////////////////////////////////////////////////////////////////
	   
	/////////////////////////////   
	   
	    ready = new JPanel();
	    cancel = new JButton();
	    cancel.setActionCommand("Reset");
	   // perform = new JButton();
	    //perform.setActionCommand("Perform Action");
	    //ready.add(perform, BorderLayout.CENTER);
	    ready.add(cancel, BorderLayout.CENTER);
	    ready.setPreferredSize(new Dimension(130,70));
	   	cancel.addActionListener(listener);
		//perform.addActionListener(listener);
		cancel.setBackground(Color.black);
		//perform.setBackground(Color.black);
		cancel.setIcon(new ImageIcon("C:\\Users\\nadaa\\workspace\\M3Updated\\src\\view\\Charcters PNG\\res.png"));
       cancel.setRolloverIcon(new ImageIcon("C:\\Users\\nadaa\\workspace\\M3Updated\\src\\view\\Charcters PNG\\reset2.png"));
       
		
		
  //text area that shows the current player 
  showCurrentPlayer = new JTextArea("Current Player\n" + game.getCurrentPlayer().getName());
  showCurrentPlayer.setPreferredSize(new Dimension(110, 50));
  showCurrentPlayer.setEditable(false);
 showCurrentPlayer.setFont(new Font("NoirPro-Medium", Font.BOLD, 16));
 showCurrentPlayer.setForeground(new Color(0x5e, 0x81, 0x9d));
 showCurrentPlayer.setWrapStyleWord(true);
  showCurrentPlayer.setBackground(Color.BLACK);
  //showCurrentPlayer.setOpaque(false);
  ready.add(showCurrentPlayer, BorderLayout.EAST);
  ready.setBounds(300, 300, 100,30);
ready.setBackground(Color.black);
 
  ready.add(new JLabel("C:\\Users\\nadaa\\workspace\\M3Updated\\src\\view\\Charcters PNG\\.gif"));

//ready.setBackground(new Color(0x5e, 0x81, 0x9d));
  add(ready, BorderLayout.EAST);
  
  
  
  
  
  


	      
		  
//HEALTHBAR P2  
		  
		    healthbarPanelP2= new JPanel();
			healthbarPanelP2.setBounds(300, 300, 500, 30);
			healthbarPanelP2.setBackground(Color.LIGHT_GRAY);
		  
			int x2 = game.getPlayer2().getPayloadPos();
			if (x2 == 0)
				imgLabel = new JLabel(Progress_bar_0image);
			if (x2 == 1)
				imgLabel = new JLabel(Progress_bar_1image);
			if (x2 == 2)
				imgLabel = new JLabel(Progress_bar_2image);
			if (x2 == 3)
				imgLabel = new JLabel(Progress_bar_3image);
			if (x2 == 4)
				imgLabel = new JLabel(Progress_bar_4image);
			if (x2 == 5)
				imgLabel = new JLabel(Progress_bar_6image);
			
			if (x2 == 6)
				imgLabel = new JLabel(Progress_bar_7image);
			
			healthbarPanelP2.add(imgLabel);




				//deadCharactersP2
							  deadCharP2 = new JFrame();
							  deadCharP2.setVisible(false);
							  deadCharP2.setLayout(new FlowLayout());
							  deadCharactersP2= game.getPlayer2().getDeadCharacters();
							  deadCharactersP2List = new String [7];
							  groupP2 = new ButtonGroup();
							  for(int j =0; j<deadCharactersP2.size(); j++){
								  String s = deadCharactersP2.get(j).getName();
								  JRadioButton option2 = new JRadioButton(s);
								  groupP2.add(option2);
								  deadCharactersP2List [j]= s;
								  deadCharP2.add(option2);
								  }
							 deadCharactersP2Dropdown = new JComboBox<String>(deadCharactersP2List);
							  deadCharactersP2Dropdown.setEditable(true);
							  deadCharactersP2Dropdown.addActionListener(listener);
					 
							//COMBOBOX P2
							   JTextField t1 = new JTextField("Player 2's dead chracters:");
								//  t.setBounds(300, 300, 500, 30);
							   JPanel comBx2 = new JPanel(new FlowLayout());
							   comBx2.add(t1);
							   comBx2.add(deadCharactersP2Dropdown);
							   deadCharactersP2Dropdown.setPreferredSize(new Dimension(100,25));
							   healthbarPanelP2.add(comBx2);

   
                          add(healthbarPanelP2, BorderLayout.NORTH);

                          
                          
  //HEALTHBAR P1
	healthbarPanelP1= new JPanel();
	healthbarPanelP1.setBounds(300, 300, 500, 30);
	healthbarPanelP1.setBackground(Color.LIGHT_GRAY);

	int x1 = game.getPlayer1().getPayloadPos();
	if (x1 == 0)
		imgLabel2 = new JLabel(Progress_bar_0image);
	if (x1 == 1)
		imgLabel2 = new JLabel(Progress_bar_1image);
	if (x1 == 2)
		imgLabel2 = new JLabel(Progress_bar_2image);
	if (x1 == 3)
		imgLabel2 = new JLabel(Progress_bar_3image);
	if (x1 == 4)
		imgLabel2 = new JLabel(Progress_bar_4image);
	if (x1 == 5)
		imgLabel2 = new JLabel(Progress_bar_6image);
	
	if (x1 == 6)
		imgLabel2 = new JLabel(Progress_bar_7image);
	
	healthbarPanelP1.add(imgLabel2);

	
	
	//deadCharactersP1
	//deadCharactersP1
	  deadCharP1 = new JFrame();
	  deadCharP1.setVisible(false);
	  deadCharP1.setLayout(new FlowLayout());
	  deadCharactersP1= new ArrayList<Piece>();
	  deadCharactersP1= game.getPlayer1().getDeadCharacters();
	  deadCharactersP1List = new String [7];
	  for(int i =0; i<deadCharactersP1.size(); i++){
		  String m = deadCharactersP1.get(i).getName();
		  deadCharactersP1List [i]= m;
		  }
	     
		  deadCharactersP1Dropdown = new JComboBox<String>(deadCharactersP1List);
		  deadCharactersP1Dropdown.setEditable(true);


	deadCharactersP1Dropdown = new JComboBox<String>(deadCharactersP1List);
	  deadCharactersP1Dropdown.setEditable(true);
	  deadCharactersP1Dropdown.addActionListener(listener);
		//COMBOBOX P1
		JTextField t2 = new JTextField("Player 1's dead chracters:");
		//  t.setBounds(300, 300, 500, 30);
		  JPanel comBx1 = new JPanel(new FlowLayout());
		  comBx1.add(t2);
		  comBx1.add(deadCharactersP1Dropdown);
		  healthbarPanelP1.add(comBx1);
		 add(healthbarPanelP1, BorderLayout.SOUTH);
		 healthbarPanelP1.setVisible(true);
		 healthbarPanelP2.setVisible(true);

	
	 add(healthbarPanelP1, BorderLayout.SOUTH);

      this.setVisible(true);

  
  
 }
 
  
  
  
  
  
  
  
  
  
  
  
  
  
  
 
 
 public String getPowerState(Piece p){
	 if(p instanceof ActivatablePowerHero){
		 return (((ActivatablePowerHero) p).isPowerUsed() == true) ? "Yes" : "No";
	 }
	 else return (p instanceof Armored)? (((Armored) p).isArmorUp() == true)? "Up": "Down": "Unlimited Power";
	
	
 }
 public MyButton editHover(Piece p, MyButton b){
     b.setToolTipText("Hero Type: "+ p.getClass().getSimpleName() +" Hero Name "+p.getName()+"\n"+" Power Used: "+ getPowerState(p)+";"+" Owner "+p.getOwner().getName());
     return b;
}

public MyButton[][] getPieceButtons() {
	return pieceButtons;
}

public void setPieceButtons(MyButton[][] pieceButtons) {
	this.pieceButtons = pieceButtons;
}

public JButton getCancel() {
	return cancel;
}

public void setCancel(JButton cancel) {
	this.cancel = cancel;
}

public JButton getPerform() {
	return perform;
}

public void setPerform(JButton perform) {
	this.perform = perform;
}
 
public void setButton(MyButton b, Point p, ActionListener x){
	pieceButtons[p.x][p.y].setToolTipText(b.getToolTipText());
	pieceButtons[p.x][p.y].setIcon(b.getIcon());
	pieceButtons[p.x][p.y].setText(b.getText());
	pieceButtons[p.x][p.y].addActionListener(x);
}

public JComboBox<String> getDeadCharactersP1Dropdown() {
	return deadCharactersP1Dropdown;
}

/*public void setDeadCharactersP1Dropdown(
		JComboBox<String> deadCharacters
		
		
		P1Dropdown) {
	this.deadCharactersP1Dropdown = deadCharactersP1Dropdown;
}*/

public JFrame getDeadCharP1() {
	return deadCharP1;
}

public JFrame getDeadCharP2(){
	return deadCharP2;
}

/*public void setDeadCharP1(JFrame deadCharP1) {
	this.deadCharP1 = deadCharP1;
}*/

public JFrame getDeadChar(Game game) {
	return 	(game.getCurrentPlayer() == game.getPlayer1()) ? deadCharP1 : deadCharP2;
}



public ButtonGroup getGroup(Game game) {
	return 	(game.getCurrentPlayer() == game.getPlayer1()) ? groupP1 : groupP2;
}

public JButton[] getButtonsForDead(Game game) {
	return 	(game.getCurrentPlayer() == game.getPlayer1()) ? buttonsP1 : buttonsP2;
}

public JPanel getGameBoard() {
	return gameBoard;
}

public void setGameBoard(JPanel gameBoard) {
	this.gameBoard = gameBoard;
}

public JPanel getHealthbarPanelP2() {
	return healthbarPanelP2;
}

public void setHealthbarPanelP2(JPanel healthbarPanelP2) {
	this.healthbarPanelP2 = healthbarPanelP2;
}

public JPanel getHealthbarPanelP1() {
	return healthbarPanelP1;
}

public void setHealthbarPanelP1(JPanel healthbarPanelP1) {
	this.healthbarPanelP1 = healthbarPanelP1;
}

public JPanel getReady() {
	return ready;
}

public void setReady(JPanel ready) {
	this.ready = ready;
}

public JComboBox<String> getDeadCharactersDropdown(Game g) {
	if(g==null) System.out.println("NULL GAAAMMMEEE");
return 	(g.getCurrentPlayer() == g.getPlayer1()) ? deadCharactersP1Dropdown : deadCharactersP2Dropdown;
}


public ArrayList <Piece>  getDeadCharacters(Game game){
	return 	(game.getCurrentPlayer() == game.getPlayer1()) ? deadCharactersP1 : deadCharactersP2;
}

 
 
}