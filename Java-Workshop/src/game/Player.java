package game;

import graphics.Assets;

import java.awt.*;

public class Player {

    private int x;

    private int y;

    private int speed;

    private int gravity;

    private int health;

    public Rectangle boundingBox;

    public static boolean goingUp, goingDown, goingLeft, goingRight;

    public static boolean isIdle, hasJumped;

    private int playerCutX = 0;

    public Player(int x, int y) {
        this.x = x;
        this.y = y;
        this.health = 50;
        this.speed = 2;
        this.gravity = 1;
        // because the picture of the girl is in the center of 95x130(there is emplty space arround the girl)
        this.boundingBox = new Rectangle(Assets.playerWidth - 33, Assets.playerHeight - 19);

//        goingUp = false;
//        goingDown = false;
        goingLeft = false;
        goingRight = false;
        isIdle = true;
        hasJumped = false;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setGravity(int gravity) {
        this.gravity = gravity;
    }

    public int getHealth() {
        return this.health;
    }

    //Checks if the player areOverlaped with something
    public boolean areOverlaped(Rectangle otherRectangle) {
        if (this.boundingBox.intersects(otherRectangle) || otherRectangle.intersects(this.boundingBox)) {
            return true;
        }
        return false;
    }

    //Update the movement of the player
    public void tick() {
        //Update the bounding box's position
        this.boundingBox.setBounds(this.x + 15, this.y + 11, Assets.playerWidth - 33, Assets.playerHeight - 19);
        this.y += this.gravity;
        if (hasJumped) {
            this.y -= this.speed;
            this.gravity = this.speed - 1;
        }

//        else if (goingUp) {
//            this.y -= this.speed;
//        }
//        else if (goingDown) {
//            this.y += this.speed;
//        }
        if (goingLeft) {
            this.x -= this.speed;
        }
        else if (goingRight) {
            this.x += this.speed;
        }
// Animation(runing) of the girl, 7 are the pictures on one row
        playerCutX++;
        if (playerCutX >= 7) {
            playerCutX = 0;
        }
    }

    //Draws the player
    public void render(Graphics graphics) {
        int newPlayerX;
        int newPlayerY;
        if (isIdle) {
            newPlayerX = Assets.playerWidth * 6;
            newPlayerY = Assets.playerHeight * 1;
        }
        else if (hasJumped) {
            newPlayerX = Assets.playerWidth * 3;
            newPlayerY = Assets.playerHeight * 1;
        }
        else {
            newPlayerX = Assets.playerWidth * playerCutX;
            newPlayerY = Assets.playerHeight;
        }

        Assets.changePlayerImage(newPlayerX, newPlayerY);
        graphics.drawImage(Assets.player, this.x, this.y, null);
    }
}
