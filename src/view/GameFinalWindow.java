
package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;






import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import exceptions.InvalidMovementException;
import exceptions.InvalidPowerUseException;
import exceptions.OccupiedCellException;
import exceptions.UnallowedMovementException;
import exceptions.WrongTurnException;
import model.game.Cell;
import model.game.Direction;
import model.game.Game;
import model.game.Player;
import model.pieces.Piece;
import model.pieces.heroes.ActivatablePowerHero;
import model.pieces.heroes.Medic;
import model.pieces.heroes.Ranged;
import model.pieces.heroes.Speedster;
import model.pieces.heroes.Super;
import model.pieces.heroes.Tech;
import model.pieces.sidekicks.SideKick;
import view.GameGUI;
import view.Main;
import view.MyButton;

public class GameFinalWindow extends JFrame implements ActionListener{

	private Main mainWindow;
	private Game game;
	private Player p1;
	private Player p2;
	private GameGUI temp;
	private JFrame gamePlay;
	private JPanel board;
	private JPanel payLoadP1;
	private JPanel payLoadP2;
	private JPanel ready;
	
	private Cell current;
	private Cell targetPos;
	private Cell targetPiece;
	
	private MyButton currButton;
	private MyButton targetButton;
	
	private Cell teleportOrResurrect;
	private MyButton telOrResButton;
	
	private Piece currentP;
	private Piece targetPosP;
	private Piece targetPowP;
	
	private Piece resurrect;
	private JPanel winner;
	private JPanel dead;
	
	
	
	
	
	
	
	
	
	JButton b=new JButton("Play again");
	
	
	
	
	
	
	
	
	private Icon techability_p2 = new ImageIcon("C:\\Users\\nadaa\\workspace\\M3Updated\\src\\view\\Charcters PNG\\techabilityplayer2.gif");

	private Icon medicability_p2 = new ImageIcon("C:\\Users\\nadaa\\workspace\\M3Updated\\src\\view\\Charcters PNG\\medicplayer2...gif");

	private Icon superability_p2 = new ImageIcon("C:\\Users\\nadaa\\workspace\\M3Updated\\src\\view\\Charcters PNG\\superabilityplayer2.gif");

	private Icon rangedability_p2 =  new ImageIcon("C:\\Users\\nadaa\\workspace\\M3Updated\\src\\view\\Charcters PNG\\rangedabilityplayer2.gif");



////////////////////////////////////////////
	

private Icon techability_p1 = new ImageIcon("C:\\Users\\nadaa\\workspace\\M3Updated\\src\\view\\Charcters PNG\\Tech-Ability.gif");

private Icon rangedability_p1 =new ImageIcon("C:\\Users\\nadaa\\workspace\\M3Updated\\src\\view\\Charcters PNG\\rangedabilityplayer1.gif");

private Icon medicability_p1 = new ImageIcon("C:\\Users\\nadaa\\workspace\\M3Updated\\src\\view\\Charcters PNG\\medicabilityplayer1.gif");

private Icon superability_p1 = new ImageIcon("C:\\Users\\nadaa\\workspace\\M3Updated\\src\\view\\Charcters PNG\\superabilityplayer1.gif");


////////////////////////////////

	
	
	
	
	
	
	
	
	
	
	public static void main(String [] args) throws IOException{
		new GameFinalWindow();
	}
	
	
/// Constructor	
	
	public GameFinalWindow() throws IOException{
			
		
		
		

		
		
		
		
		
	  	String firstplayer = JOptionPane.showInputDialog("Enter name:");
	    String secondplayer = JOptionPane.showInputDialog("Enter name:");
	    p1 = new Player(firstplayer);
	    p2= new Player(secondplayer);
	  
		
		
		
	    game = new Game(p1,p2);
	 	
	    b.addActionListener(this);
		b.setBackground(Color.LIGHT_GRAY);
		
		mainWindow = new Main();
		mainWindow.getStart().addActionListener(this);
		//mainWindow.getHelp().addActionListener(this);
		mainWindow.getExit().addActionListener(this);
		
	
	}
	
	
///////////////////////////////////////////////////////////////////////////////////////////////////////
	@Override
	public void actionPerformed(ActionEvent e) {
	 if(game!=null){
		if(e.getSource()==mainWindow.getStart()){
			
			mainWindow.getFrame().setVisible(false);
			
				try {
					gamePlay = new JFrame();
					temp = new GameGUI(game, p1, p2,this);
					board = temp.getGameBoard();
					payLoadP1 = temp.getHealthbarPanelP1();
					payLoadP2 = temp.getHealthbarPanelP2();
					ready = temp.getReady();
					gamePlay.add(board, BorderLayout.CENTER);
					gamePlay.add(payLoadP1,  BorderLayout.SOUTH);
					gamePlay.add(payLoadP2, BorderLayout.NORTH);
					gamePlay.add(ready, BorderLayout.EAST);
					gamePlay.setVisible(true);
					gamePlay.setExtendedState(JFrame.MAXIMIZED_BOTH); 
				    
					gamePlay.setDefaultCloseOperation(EXIT_ON_CLOSE);
				        
			
					//gamePlay.setDefaultCloseOperation();
				} catch (IOException e1) {
					JOptionPane.showMessageDialog(null, e1.getMessage());
				}
			
		}
/////////////////////////////	
		
		else if(e.getSource()==mainWindow.getExit())
			 System.exit(0);
		
////////////////////////////
		
		
		else if(e.getSource()==findPieceButton(e))
		{ 	
				System.out.println(targetPowP==null);
				
				if(((current==null || currButton==findPieceButton(e))) && game.getCellAt(findPieceButton(e).getI(), findPieceButton(e).getJ()).getPiece()!=null /*&& game.getCellAt(findPieceButton(e).getI(), findPieceButton(e).getJ()).getPiece().getOwner()==game.getCurrentPlayer()*/){

					current = game.getCellAt(findPieceButton(e).getI(), findPieceButton(e).getJ());
					currentP = current.getPiece();
					currButton = findPieceButton(e);
					findPieceButton(e).setClicks(findPieceButton(e).getClicks()+1);
					if(currButton.getClicks()%2==0){
					if(currentP instanceof Medic && resurrect==null){
						if(currentP.getOwner()==game.getPlayer1())
						currButton.setIcon(medicability_p1);
						else currButton.setIcon(medicability_p2);
						
					}
					else if(currentP instanceof Ranged && targetPowP==null){
						if(currentP.getOwner()==game.getPlayer1())
							currButton.setIcon(rangedability_p1);
							else currButton.setIcon(rangedability_p2);
					}
					
					
					else if(currentP instanceof Tech && targetPowP==null){
						if(currentP.getOwner()==game.getPlayer1())
							currButton.setIcon(techability_p1);
							else currButton.setIcon(techability_p2);
								}
					
					else if(currentP instanceof Super && targetPowP==null){
						if(currentP.getOwner()==game.getPlayer1())
							currButton.setIcon(superability_p1);
							else currButton.setIcon(superability_p2);
					}
					}
				System.out.println(game.getCurrentPlayer().getName());
				System.out.println("ok2");
			  }
				

				else if (current!=null && current.getPiece()!=null && currButton!=null && currButton.getClicks()%2!=0){

					targetPos = game.getCellAt(findPieceButton(e).getI(), findPieceButton(e).getJ());
					targetPosP = targetPos.getPiece();
					targetButton= findPieceButton(e);
					System.out.println("ok3");
				

					action();
	              }
				
					
			
				else if(current!=null && current.getPiece()!=null && currButton!=null && currButton.getClicks()%2==0 && targetPowP==null && !(currentP instanceof Medic))//&& game.getCellAt(findPieceButton(e).getI(), findPieceButton(e).getJ()).getPiece()!=null)
				{ 
				  targetPiece = game.getCellAt(findPieceButton(e).getI(), findPieceButton(e).getJ());
				  targetPowP = targetPiece.getPiece();
				  targetButton=findPieceButton(e);
				  System.out.println("ok4");

				  if(!(currentP instanceof Tech))
					action();

				  }
				
				
				
				
				else if((targetPowP!=null || resurrect!=null) &&( (currentP instanceof Tech) || (currentP instanceof Medic) ) )
				{
				teleportOrResurrect = game.getCellAt(findPieceButton(e).getI(), findPieceButton(e).getJ());		
	            telOrResButton = findPieceButton(e);	
	      		action();
	              System.out.println("ok5");
				}
				
			}
			
		///////////////////////////////////////
		
			else if(currentP instanceof Medic && resurrect==null && currButton.getClicks()%2==0){
				
				System.out.println("Hi");
				if(game==null)
				System.out.println("NULL GAME FINAL");
				String s = (String) temp.getDeadCharactersDropdown(game).getSelectedItem();
				System.out.println(s);
				resurrect = checkSelect(s);
System.out.println(resurrect==null);
				 }
				


			else if(e.getSource()==temp.getCancel()){

				currButton.setClicks(0);
				current=null;
				currentP=null;
				targetPos=null;
				targetPiece=null;
				targetButton=null;
				resurrect = null;
				System.out.println(targetButton==null);
				if(targetButton!=null)
				targetButton.setClicks(0);
				targetPosP=null;
				targetPowP=null;
				teleportOrResurrect=null;
				telOrResButton=null;
				if(telOrResButton!=null)
				telOrResButton.setClicks(0);
				System.out.println("Cancel");
			}
		 
		 else if(e.getSource().equals(b)){
			 System.out.println("BBBBBBBBBBBBBBBBBBBBB");
			try {
				new GameFinalWindow();
			} catch (IOException e1) {
			 JOptionPane.showMessageDialog(null, e1.getMessage());
			}
		 }
		 }
			else JOptionPane.showMessageDialog(null, "The game ended.");
		}
			
////////////////////////////////////////////////////////////////////////////////////////////////////////
	

	public void actionHelper() throws InvalidPowerUseException, InvalidMovementException, WrongTurnException, UnallowedMovementException, IOException{

		if(currButton.getClicks()%2!=0){
			  Direction d = getMoveDirection();
			if(d==null){
			    System.out.println("Null direc");
				if(currentP instanceof Speedster){
				JOptionPane.showMessageDialog(null, "Speedster can not move more or less than 2 steps.");
				}
				else {
				JOptionPane.showMessageDialog(null, ""+currentP.getClass().getSimpleName()+" can not move more than 1 step.");
				}
				}
			else{                    
System.out.println(d.name());
			//MOVE
		try {
			current.getPiece().move(d);

			  		  
		}	  catch (UnallowedMovementException e1) {
					JOptionPane.showMessageDialog(null, e1.getMessage());

} 
				catch (OccupiedCellException e) {
					JOptionPane.showMessageDialog(null, "Cell is not empty!");
				} 
		catch(WrongTurnException e1){
			JOptionPane.showMessageDialog(null, e1.getMessage());

		}
			}
		}
			else if(currButton.getClicks()%2==0){
System.out.println("Power use");
				//USE POWER
				Direction d = getPowerDir();
					if(current.getPiece() instanceof ActivatablePowerHero){
						ActivatablePowerHero p = (ActivatablePowerHero) current.getPiece();
					try {
							
						if(p instanceof Tech || p instanceof Medic){
								System.out.println("TorM");
							
						if(p instanceof Tech){
									
								System.out.println("Tech");
							if(telOrResButton!=null){
								p.usePower(d, targetPiece.getPiece(), new Point(telOrResButton.getI(),telOrResButton.getJ()));
                              
							}
							else{
								p.usePower(d, targetPiece.getPiece(), null);
								
							   }
						}
						
						else if(p instanceof Medic){
							System.out.println(d==null);
							System.out.println(resurrect==null);
							System.out.println(telOrResButton==null);
							p.usePower(d, resurrect, new Point(telOrResButton.getI(),telOrResButton.getJ()));
                            
							
						}
													
				}	else{
							    
								if(p instanceof Super){
									
									if(d !=null){
										System.out.println(4);
										System.out.println(targetButton==null);

									p.usePower(d, targetPiece.getPiece(), null);
									}
									else{
										System.out.println(p.isPowerUsed());
										JOptionPane.showMessageDialog(null, "Super applies its power on adjacent cells only.");
									}
							    }
								
								else if(p instanceof Ranged){
								  if(d !=null){
							
									p.usePower(d, targetPiece.getPiece(), null);
									
								}
								
								else{
									JOptionPane.showMessageDialog(null, "This is not a valid direction.");
								}
								}
							    
							}
						
						} catch (InvalidPowerUseException e) {
							JOptionPane.showMessageDialog(null, e.getMessage());
						}
					catch (WrongTurnException e)
					{ JOptionPane.showMessageDialog(null, e.getMessage());
					}
					}
				
			}
    temp.getCancel().doClick();
    updateBoard();
	System.out.println("e");
	}
		
		
	
	
	
	
///////////////////////////////////////////////////////////////////////////////////////////////////
	public MyButton findPieceButton(ActionEvent e){
		for (int i = 0; i < 7; i++) {
			for (int j = 0; j < 6; j++) {
			if(e.getSource()==temp.getPieceButtons()[i][j])
					return (MyButton) temp.getPieceButtons()[i][j];
				}
		}
		return null;
	}
	
	
///////////////////////////////////////////////////////////////////////////////////////////////////
	
	public Piece findResurrect(ActionEvent e){
		
			for (int j = 0; j < 12; j++) {
			if(e.getSource().equals(temp.getButtonsForDead(game)[j]))
				       return game.getCurrentPlayer().getDeadCharacters().get(j);
				}
		return null;
	}
	
	
	public JButton findButton(ActionEvent e){
		
		for (int j = 0; j < 12; j++) {
		if(e.getSource().equals(temp.getButtonsForDead(game)[j]))
			       return temp.getButtonsForDead(game)[j];
			}
	
	return null;
}
	
	
	
	
	
	
/////////////////////////////////////////////////////////////////////////////////////////////////////////	//
	
	public void updateBoard() throws IOException{
		  
		  if (game.getPlayer1().getPayloadPos()==6 || game.getPlayer2().getPayloadPos() == 6){
	
			gamePlay.remove(board);
			gamePlay.remove(payLoadP1);
			gamePlay.remove(payLoadP2);
			gamePlay.remove(ready);
			//b.addActionListener(this);
			//b.setBackground(Color.LIGHT_GRAY);
			temp.getCancel().doClick();
			winner = new JPanel();
			winner.setBackground(new Color(0x5e, 0x81, 0x9d));
		  //  winner.add(new JLabel(new ImageIcon("C:\\Users\\Mariam Heikal\\Downloads\\M2_Code\\SHC_M2\\resources\\Space-Bottom.gif")));
		    
		    JTextField win = new JTextField("Winner player is \n"+game.getCurrentPlayer().getName());
			win.setEditable(false);
		    win.setBackground(new Color(0x5e, 0x81, 0x9d));
		    win.setFont(new Font("System", Font.BOLD, 30));
			winner.add(win, BorderLayout.WEST);
		    JPanel again= new JPanel();
		    
		    winner.add(b, BorderLayout.EAST);
		    gamePlay.add(winner, BorderLayout.CENTER);
		    gamePlay.add(again, BorderLayout.SOUTH);
			gamePlay.repaint();
          gamePlay.revalidate();
		  }


	  
	  else{
			gamePlay.remove(board);
			gamePlay.remove(payLoadP1);
			gamePlay.remove(payLoadP2);
			gamePlay.remove(ready);
			
			temp = new GameGUI(game, p1, p2,this);
			board = temp.getGameBoard();
			payLoadP1 = temp.getHealthbarPanelP1();
			payLoadP2 = temp.getHealthbarPanelP2();
			ready = temp.getReady();
			gamePlay.add(board, BorderLayout.CENTER);
			gamePlay.add(payLoadP1,  BorderLayout.SOUTH);
			gamePlay.add(payLoadP2, BorderLayout.NORTH);
			gamePlay.add(ready, BorderLayout.EAST);
			gamePlay.repaint();
          gamePlay.revalidate();
			gamePlay.setVisible(true);
		  }
	  }
	
	
	
	
	
	
	
////////////////////////////////////////////////////////////////////////////////////////////
	public Point Border(Point p){
		if(p.y<0)
			p.y+=6;
		else if(p.y>5)
			p.y%=6;
		if(p.x<0)
			p.x+=7;
		else if(p.x>6)
			p.x%=7;
		return p;
}

	
	
	
	
	
//////////////////////////////////////////////////////////////////////////////////////////////////////	
	public Direction getMoveDirection()
	{
	//Movement directions:
		//Only returns direction if it is a possible move
		// d is null law direction gher el 8
		int i = currButton.getI();
		int j = currButton.getJ();
        int iNew = (currentP instanceof Medic && currButton.getClicks()%2==0) ? telOrResButton.getI() : targetButton.getI();
        int jNew = (currentP instanceof Medic && currButton.getClicks()%2==0) ? telOrResButton.getJ() : targetButton.getJ();


		Point myPos = new Point(i,j);
		Point targPos = new Point(iNew,jNew);
		int s = 0;
		if(currentP instanceof Speedster)
			s=1;
		System.out.println("s: "+s);
		if ( (j==jNew && i-1-s==iNew) || ((i==0 || i==0+s) &&(i-1-s+7)==iNew)) return Direction.UP;
		 else if (j==jNew && ((i+1+s==iNew) || ((i==6 || i==6-s) &&(i+1+s-7)==iNew))) return Direction.DOWN;
		 else if (i==iNew && (j-1-s==jNew || ((j==0 || j==0+s) &&(j-1-s+6)==jNew))) return Direction.LEFT;
		 else if (i==iNew && (j+1+s==jNew || ((j==0 || j==0+s) &&(j+1+s+6)==jNew))) return Direction.RIGHT;
		 System.out.println("iorg= "+i+" jorg= "+j);
		 System.out.println("i="+targetButton.getI()+" j="+targetButton.getJ());
		Point test= new Point(myPos.x+1+s,myPos.y+1+s);
		System.out.println("i="+test.x+" j="+test.y);
		 if(Border(test).equals(targPos))
			 return Direction.DOWNRIGHT;
		 
		test= new Point(myPos.x+1+s,myPos.y-1-s);
		System.out.println("i="+test.x+" j="+test.y);
		 if(Border(test).equals(targPos))
			 return Direction.DOWNLEFT;
		 
		
		test= new Point(myPos.x-1-s,myPos.y-1-s);
		System.out.println("i="+test.x+" j="+test.y);
		 if(Border(test).equals(targPos))
			 return Direction.UPLEFT;
		
		test= new Point(myPos.x-1-s,myPos.y+1+s);
		System.out.println("i="+test.x+" j="+test.y);
		 if(Border(test).equals(targPos))
			 return Direction.UPRIGHT;
		
		 else return null;
		
		}
	
	
	
	
	
/////////////////////////////////////////////////////////////////////////////////////////////////////

	public Direction getPowerDir(){
	if(targetButton!=null || telOrResButton!=null){
		int i = current.getPiece().getPosI();
		int j = current.getPiece().getPosJ();
		int iTarg = (currentP instanceof Medic) ? telOrResButton.getI() : targetButton.getI();
        int jTarg = (currentP instanceof Medic) ? telOrResButton.getJ() : targetButton.getJ();
		
		if(current.getPiece() instanceof Super){
			if (j==jTarg && i-1==iTarg) return Direction.UP;
			 else if (j==jTarg && i+1==iTarg) return Direction.DOWN;
			 else if (i==iTarg && j-1==jTarg) return Direction.LEFT;
			 else if (i==iTarg && j+1==jTarg) return Direction.RIGHT;
			 else if(i+1==iTarg && j+1==jTarg) return Direction.DOWNRIGHT;
			 else if (i+1==iTarg && j-1==jTarg) return Direction.DOWNLEFT;
			 else if(i-1==iTarg && j-1==jTarg) return Direction.UPLEFT;
			 else if(i-1==iTarg && j+1==jTarg) return Direction.UPRIGHT;
			 else return null;
			
		}
		
		else if(current.getPiece() instanceof Ranged){
			if(i==iTarg && j<jTarg) return Direction.RIGHT;
			else if(i==iTarg && j>jTarg) return Direction.LEFT;
			else if(j==jTarg && i<iTarg) return Direction.DOWN;
			else if(j==jTarg && i>iTarg) return Direction.UP;
			else if(j>jTarg && i>iTarg && i-iTarg==j-jTarg) return Direction.UPLEFT;
			else if(j>jTarg && i<iTarg && j-jTarg==iTarg-i) return Direction.DOWNLEFT;
			else if(j<jTarg && i>iTarg && jTarg-j==i-iTarg) return Direction.UPRIGHT;
			else if(j<jTarg && i<iTarg && jTarg-j==iTarg-i) return Direction.DOWNRIGHT;
			else return null;
		}
		
		else if(currentP instanceof Medic){
			return getMoveDirection();
		}
		
		else return null;
	}
	else{
		JOptionPane.showMessageDialog(null, "You must choose a target piece or a target position.");
	} 
	return null;
		
	}
//////////////////////////////////////////////////////////////////////////////////////////////////
	public Piece firstEnemy(Direction d){
		Piece hit = null;
		if (d == Direction.RIGHT) {
			for (int j = currentP.getPosJ() + 1; j < game.getBoardWidth(); j++) {
				hit =  game.getCellAt(currentP.getPosI(), j).getPiece();
				if (hit != null) {
					break;
				}
			}
		} else if (d == Direction.LEFT) {
			for (int j = currentP.getPosJ() - 1; j >= 0; j--) {
				hit = game.getCellAt(currentP.getPosI(), j).getPiece();
				if (hit != null) {
					break;
				}
			}
		} else if (d == Direction.UP) {
			for (int i = currentP.getPosI() - 1; i >= 0; i--) {
				hit = game.getCellAt(i, currentP.getPosJ()).getPiece();
				if (hit != null) {
					break;
				}
			}
		} else if (d == Direction.DOWN) {
			for (int i = currentP.getPosI() + 1; i < game.getBoardHeight(); i++) {
				hit = game.getCellAt(i, currentP.getPosJ()).getPiece();
				if (hit != null) {
					break;
				}
			}
		}
		return hit;
	}
///////////////////////////////////////////////////////////////////////////////////////////////	
	

	public Piece checkSelect(String s){
		  for(int i =0; i<game.getCurrentPlayer().getDeadCharacters().size();i++){
		  if(game.getCurrentPlayer().getDeadCharacters().get(i).getName().equals(s))
			  return game.getCurrentPlayer().getDeadCharacters().get(i);
		  }
		  return null;
		  
	  }
	
	
	  public void action(){
		  if(!(currentP instanceof SideKick && currButton.getClicks()%2==0)){
				try {
					actionHelper();
				} catch (InvalidPowerUseException e1) {
					JOptionPane.showMessageDialog(null, e1.getMessage());
					e1.printStackTrace();
				} catch (InvalidMovementException e1) {
					JOptionPane.showMessageDialog(null, e1.getMessage());
				} catch (WrongTurnException e1) {
					JOptionPane.showMessageDialog(null, e1.getMessage());
				} catch (IOException e1) {
					JOptionPane.showMessageDialog(null, e1.getMessage());
				}

				System.out.println("perform");
			}
			else{ 
				temp.getCancel().doClick();
				JOptionPane.showMessageDialog(null, "SideKicks has no power ability.");
				}
	  }
	
	

}
