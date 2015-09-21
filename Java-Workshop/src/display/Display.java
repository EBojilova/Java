package display;

import javax.swing.*;
import java.awt.*;

// extendvame Canvas za da mojem posle da polzvame metodite mu
public class Display extends Canvas {

    //Creating our Window frame
    private JFrame frame;

    //Creating a field on which we draw
    private Canvas canvas;

    private String title;

    private int width, height;

    public Display(String title, int width, int height) {
        this.title = title;
        this.width = width;
        this.height = height;

        //Creating the JFrame
        this.createDisplay();
    }

    //Creating a getter to access the Canvas object from other classes
    public Canvas getCanvas() {
        return this.canvas;
    }

    private void createDisplay() {
        this.setCanvas();
        this.setFrame();

    }

    private void setCanvas() {
        //Pazi goleminata na samia proekt
        Dimension dimentions= new Dimension(this.width, this.height);
        //Initializing Canvas in the window- predstavliava stativa varhu koito ste risuvame, kato stativa triabva da go postavim v prozoreca
        this.canvas = new Canvas();
        //Setting the size of the Canvas. It works only with Dimension argument
        this.canvas.setPreferredSize(dimentions);
        //Making sure the Canvas will stay with the given width and playerHeight
        this.canvas.setMaximumSize(dimentions);
        this.canvas.setMinimumSize(dimentions);
        //http://stackoverflow.com/questions/22724286/keylistener-active-only-after-click-on-canvas
        // za da moje InputHandler da deistva varhu geroia da se dviji
        this.canvas.setFocusable(true);
    }

    private void setFrame() {
        //Creates a new Frame with a title
        this.frame = new JFrame(this.title);
        //Sets the frame's size
        this.frame.setSize(this.width, this.height);
        //Ensures that when the exit button is clicked the whole app stops
        this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //Frame cannot be resizable
        this.frame.setResizable(false);
        //Set the default position of the frame in the center of the monitor
        this.frame.setLocationRelativeTo(null);
        //Frame is not visible by default, so we enable the visibility
        this.frame.setVisible(true);
        //Enabling the frame to be focusable
        //this.frame.setFocusable(true);
        //Linking the canvas onto the frame
        this.frame.add(this.canvas);
        //Resizing a little bit to ensure that everything on the canvas is visible
        frame.pack();
    }

}
