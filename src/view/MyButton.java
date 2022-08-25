package view;

import javax.swing.*;

import model.pieces.Piece;

import java.awt.*;
public class MyButton extends JButton
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	int i; 
	int j;
	int clicks;
    public static void main(String[] args)
    { MyButton buttonGUI = new MyButton();
	buttonGUI.setVisible(true);
    }


    public MyButton()
{
    	
}
    public MyButton(Point p)
    {
        	i = p.x;
        	j = p.y;
    }


	public MyButton(String string) {
		setText(string);
	}


	public int getI() {
		return i;
	}


	public void setI(int i) {
		this.i = i;
	}


	@Override
	public String toString() {
		return "MyButton [i=" + i + ", j=" + j + ", clicks=" + clicks + "]";
	}


	public int getJ() {
		return j;
	}


	public void setJ(int j) {
		this.j = j;
	}


	public int getClicks() {
		return clicks;
	}


	public void setClicks(int clicks) {
		this.clicks = clicks;
	}


	

}
