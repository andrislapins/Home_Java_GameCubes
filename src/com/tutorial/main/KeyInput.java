package com.tutorial.main;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import com.tutorial.main.Game.STATE;

public class KeyInput extends KeyAdapter{
	
	private Handler handler;
	private boolean[] keyDown = new boolean[4];
	
	// Game game = new Game();
	
	public KeyInput(Handler handler) {
		this.handler = handler;
		
		keyDown[0] = false;
		keyDown[1] = false;
		keyDown[2] = false;
		keyDown[3] = false;
		
	}
	
	public void keyPressed(KeyEvent e){
		int key = e.getKeyCode();
		
		for(int i = 0; i< handler.object.size(); i++) {
			
			GameObject tempObject = handler.object.get(i);
			// key events for player 1
			if(tempObject.getId() == ID.Player) {
				if(key == KeyEvent.VK_W) { tempObject.setVelY(-handler.spd); keyDown[0]=true; }
				if(key == KeyEvent.VK_S) { tempObject.setVelY(handler.spd); keyDown[1]=true; }
				if(key == KeyEvent.VK_A) { tempObject.setVelX(-handler.spd); keyDown[2]=true; }
				if(key == KeyEvent.VK_D) { tempObject.setVelX(handler.spd); keyDown[3]=true; }
			}
			/* key events for player 2
			if(tempObject.getId() == ID.Player2) {
				if(key == KeyEvent.VK_UP) tempObject.setVelY(-5);
				if(key == KeyEvent.VK_DOWN) tempObject.setVelY(5);
				if(key == KeyEvent.VK_LEFT) tempObject.setVelX(-5);
				if(key == KeyEvent.VK_RIGHT) tempObject.setVelX(5);
			}
			*/
		}
		if(key == KeyEvent.VK_P)
		{
			if(Game.gameState == STATE.Game) {
				if(Game.paused) Game.paused = false;
				else Game.paused = true;
			}
		}
		if(key == KeyEvent.VK_ESCAPE) System.exit(1);
		
		if(key == KeyEvent.VK_SPACE) {
			if(Game.gameState == STATE.Game) Game.gameState = STATE.Shop;
			else if (Game.gameState == STATE.Shop) Game.gameState = STATE.Game;
		}
	}
	public void keyReleased(KeyEvent e){
		int key = e.getKeyCode();
		
		for(int i = 0; i< handler.object.size(); i++) {
			
			GameObject tempObject = handler.object.get(i);		
			// key events for player 1
			if(tempObject.getId() == ID.Player) {
				if(key == KeyEvent.VK_W) keyDown[0]=false; // tempObject.setVelY(0);
				if(key == KeyEvent.VK_S) keyDown[1]=false; // tempObject.setVelY(0);
				if(key == KeyEvent.VK_A) keyDown[2]=false; // tempObject.setVelX(0);
				if(key == KeyEvent.VK_D) keyDown[3]=false; // tempObject.setVelX(0);
				
				// vertical movement
				if (!keyDown[0] && !keyDown[1]) tempObject.setVelY(0);
				// horizontal movement
				if (!keyDown[2] && !keyDown[3]) tempObject.setVelX(0);
			}
			/* key events for player 2
			if(tempObject.getId() == ID.Player2) {
				if(key == KeyEvent.VK_UP) tempObject.setVelY(0);
				if(key == KeyEvent.VK_DOWN) tempObject.setVelY(0);
				if(key == KeyEvent.VK_LEFT) tempObject.setVelX(0);
				if(key == KeyEvent.VK_RIGHT) tempObject.setVelX(0);
				}
			*/
		}
	}
}