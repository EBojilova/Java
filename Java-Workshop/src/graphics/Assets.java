package graphics;

import java.awt.image.BufferedImage;

public class Assets {

    public static final int playerWidth = 95, playerHeight = 130;

    public static BufferedImage player;

    private static SpriteSheet spriteSheet;

    //Loads every resource needed for the game
    public static void initializeSpriteSheet() {
        spriteSheet = new SpriteSheet(ImageLoader.loadImage("/textures/player.png"));
    }

    public static void changePlayerImage(int x, int y) {
        player = spriteSheet.cutImage(x, y, playerWidth, playerHeight);
    }
}
