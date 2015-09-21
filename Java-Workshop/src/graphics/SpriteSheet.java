package graphics;

import java.awt.image.BufferedImage;

public class SpriteSheet {

    private BufferedImage bufferedImage;

    public SpriteSheet(BufferedImage bufferedImage) {
        this.bufferedImage = bufferedImage;
    }

    //Method that cuts the bufferedImage from x to width and from y to playerHeight
    public BufferedImage cutImage(int x, int y, int width, int height) {
        //Returns a new image in the area we specified
        return this.bufferedImage.getSubimage(x, y, width, height);
    }
}
