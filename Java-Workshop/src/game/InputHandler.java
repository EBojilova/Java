package game;

import display.Display;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class InputHandler implements KeyListener {

    public InputHandler(Display display) {
        display.getCanvas()
               .addKeyListener(this);
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int keyCode = e.getKeyCode();

        Game.player.isIdle = false;
//       else  if (keyCode == KeyEvent.VK_UP) {
//            Game.player.goingUp = true;
//        }
//        else if (keyCode == KeyEvent.VK_DOWN) {
//            Game.player.goingDown = true;
//        }
        if (keyCode == KeyEvent.VK_LEFT) {
            Game.player.goingLeft = true;
        }
        else if (keyCode == KeyEvent.VK_RIGHT) {
            Game.player.goingRight = true;
        }
        else if (keyCode == KeyEvent.VK_SPACE) {
            Game.player.hasJumped = true;
        }
        else if (keyCode == KeyEvent.VK_ESCAPE) {
            System.exit(0);
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyReleased(KeyEvent e) {
        int keyCode = e.getKeyCode();

        Game.player.isIdle = true;
//        else if (keyCode == KeyEvent.VK_UP) {
//            Game.player.goingUp = false;
//        }
//        else if (keyCode == KeyEvent.VK_DOWN) {
//            Game.player.goingDown = false;
//        }
        if (keyCode == KeyEvent.VK_LEFT) {
            Game.player.goingLeft = false;
        }
        else if (keyCode == KeyEvent.VK_RIGHT) {
            Game.player.goingRight = false;
        }
        else if (keyCode == KeyEvent.VK_SPACE) {
            Game.player.hasJumped = false;
        }
    }
}
