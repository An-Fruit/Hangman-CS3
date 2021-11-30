import java.awt.Graphics;
import java.awt.Color;
import java.awt.Canvas;
import java.util.*;
import java.awt.event.*;

public class KeyTrapper extends Canvas implements KeyListener, Runnable
{
	private String notes = "q2we4r5ty7u8i9op-[=zxdcfvgbnjmk,.;/' ";
	private String key;
	private GuitarStringTester Guitar;
	private Stack<Character> stack;
	private String play;
	private boolean correct;
	private boolean pressedDown;
	Thread t;
	
		//this is the constructor
	@Override
	public void run() {
		// TODO Auto-generated method stub
		Guitar.playNotes(key.charAt(0));
		repaint();
		
	}

	public String returnKey() {
		return key;
	}
	public KeyTrapper( )
	{	
		Guitar  = new GuitarStringTester();
		addKeyListener( this );
		setFocusable( true );
	}
	public void chooseRand(Graphics window) {
		int i = (int)(Math.random() * notes.length());
		play = notes.substring(i,i+1);
		window.drawString(play,  250,  250);
		if(key.equals(play)) {
			correct = true;
		}
		else {
			correct = false;
		}
		if(correct) {
			window.setColor(Color.GREEN);
			window.drawString( play, 250, 250 );
		}
		else {
			window.setColor(Color.RED);
			window.drawString( play, 250, 250 );
		}
	}
	public void paint( Graphics window )
	{
		//window.setColor(Color.WHITE);
		//window.fillRect(0,0,800,600);	
		chooseRand(window);
		
			
		
			
	}
	
	public void keyTyped(KeyEvent e)
	{
		pressedDown = false;
		System.out.println(e.getKeyChar() + " pressed");			
	}
		
	public void keyPressed(KeyEvent e)
	{
		pressedDown = true;
		
		key = e.getKeyChar()+"";
		//System.out.println(key);
		t = new Thread(this);
		t.start();
		
	}
				
	public void keyReleased(KeyEvent e)
	{
		System.out.println(e.getKeyChar() + " released");	
		
		
	}


	
	

}