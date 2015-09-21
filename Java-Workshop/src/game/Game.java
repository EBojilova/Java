package game;

import display.Display;
import graphics.Assets;
import graphics.ImageLoader;
import states.*;

import java.awt.*;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;

public class Game implements Runnable {

    private static final int playerLevelOnTheGround = 420;

    public static Player player;

    public static Rectangle enemy;

    public int width, height;

    public String title;

    private Display display;

    private boolean isRuning = false;

    // nova nishka v koiato da izvikvame run methoda
    private Thread thread;

    private InputHandler inputHandler;

    private BufferStrategy bufferStrategy;

    private Graphics graphics;

    private BufferedImage bufferedImage;

    //Example for SpriteSheet https://www.quora.com/How-do-you-use-emoji-on-Facebook-Chat
    //private SpriteSheet spriteSheet;

    //States
    private State gameState;

    private State menuState;

    private State settingsState;

    private Rectangle bottomFlore;

    public Game(String title, int width, int height) {
        this.width = width;
        this.height = height;
        this.title = title;
    }

    //Implementing the interface's method
    @Override
    public void run() {
        this.initialize();

        //Sets the frames per seconds
        int framesPerSecond = 30;
        //1 000 000 000 nanoseconds in a second. Thus we measure time in nanoseconds
        //to be more specific. Maximum allowed time to run the tick() and render() methods
        double timePerTick = 1_000_000_000.0 / framesPerSecond;
        //How much time we have until we need to call our tick() and render() methods
        double delta = 0;
        //The current time in nanoseconds
        long now;
        //Returns the amount of time in nanoseconds that our computer runs.
        long lastTime = System.nanoTime();
        long timer = 0;
        int ticks = 0;

        while (isRuning) {
            //Sets the now variable to the current time in nanoseconds
            now = System.nanoTime();
            //Amount of time passed divided by the max amount of time allowed.
            delta += (now - lastTime) / timePerTick;
            //Adding to the timer the time passed
            timer += now - lastTime;
            //Setting the lastTime with the values of now time after we have calculated the delta
            lastTime = now;

            //If enough time has passed we need to tick() and render() to achieve 60 framesPerSecond
            if (delta >= 1) {
                this.tick();
                this.render();
                //Reset the delta
                ticks++;
                delta--;
            }

            if (timer >= 1_000_000_000) {
                System.out.println("Ticks and Frames: " + ticks);
                ticks = 0;
                timer = 0;
            }
        }

        //Calls the stop method to ensure everything has been stopped
        stop();
    }

    //Initializes all the graphics and it will get
    //everything ready for our game
    private void initialize() {
        //Initializing a new display.Display object
        display = new Display(this.title, this.width, this.height);
        bufferedImage = ImageLoader.loadImage("/textures/background.jpg");
//        spriteSheet = new SpriteSheet(ImageLoader.loadImage("/textures/player.png"));

        Assets.initializeSpriteSheet();

        //Initializing all the states
        gameState = new GameState();
        menuState = new MenuState();
        settingsState = new SettingsState();
        //Setting the currentState to gameState because we do not have
        //any more states set up
        StateManager.setState(gameState);

        player = new Player(250, playerLevelOnTheGround);
        enemy = new Rectangle(50, 50, 20, 20);
        this.inputHandler = new InputHandler(this.display);
        this.bottomFlore = new Rectangle(0, 540, this.width, this.height - 540);
    }

    //The method that will update all the variables
    private void tick() {
        //Checks if a State exists and tick()
        if (StateManager.getState() != null) {
            StateManager.getState()
                        .tick();
        }

        this.player.tick();

        if (this.player.areOverlaped(this.bottomFlore)) {
            this.player.setGravity(0);
        }

        if (player.areOverlaped(enemy)) {
            System.out.print("You died");
            stop();
        }

    }

    //The method that will draw everything on the canvas
    private void render() {
        //Setting the bufferStrategy to be the one used in our canvas
        //Gets the number of buffers that the canvas should use.
        this.bufferStrategy = display.getCanvas()
                                     .getBufferStrategy();
        //If our bufferStrategy doesn't know how many buffers to use
        //we create some manually
        if (this.bufferStrategy == null) {
            //Create 2 buffers in Linux, if they are 3 in Linux there are some problems
            this.display.getCanvas()
                        .createBufferStrategy(3);
            //returns out of the method to prevent errors
            return;
        }
        //Instantiates the graphics related to the bufferStrategy
        this.graphics = bufferStrategy.getDrawGraphics();
        //Clear the screen at every frame
        this.graphics.clearRect(0, 0, this.width, this.height);

        //START DRAWING things on the screen
        this.graphics.drawImage(bufferedImage, 0, 0, this.width, this.height, null);

        // for checking the bottom rectangle and the bounding box arround player
//        graphics.setColor(Color.red);
//        graphics.fillRect(this.bottomFlore.x, this.bottomFlore.y, this.bottomFlore.width, this.bottomFlore.height);
//        graphics.setColor(Color.black);
//        graphics.fillRect(this.player.boundingBox.x, this.player.boundingBox.y, this.player.boundingBox.width, this.player.boundingBox.height);

        // triabva zadaljitelno playera da go chertaem sled backgrounda, tai kato inache niama da se vijda
        player.render(graphics);
        graphics.setColor(Color.red);
        graphics.fillRect(this.enemy.x, this.enemy.y, this.enemy.width, this.enemy.height);

        //Checks if a State exists and render()
        if (StateManager.getState() != null) {
            StateManager.getState()
                        .render(this.graphics);
        }

        //END DRAWING objects

        //Enables the buffer
        bufferStrategy.show();
        //Shows everything stored in the Graphics object
        graphics.dispose();
    }

    //Creating a start method for the Thread to start our game
    //Synchronized is used because our method is working with threads
    //so we ensure ourselves that nothing will go bad
    public synchronized void start() {
        //If the game is isRuning exit the method
        //This is done in order to prevent the game to initializeSpriteSheet
        //more than enough threads
        if (this.isRuning) {
            return;
        }
        //Setting the while-game-loop to run
        this.isRuning = true;
        //Initialize the thread that will work with "this" class (game.Game)
        this.thread = new Thread(this);
        //The start method will call start the new thread and it will call
        //the run method in our class, because it implements Runable
        this.thread.start();
    }

    //Creating a stop method for the Thread to stop our game
    public synchronized void stop() {
        //If the game is not isRuning exit the method
        //This is done to prevent the game from stopping a
        //non-existing thread and cause errors
        if (!this.isRuning) {
            return;
        }
        this.isRuning = false;
        //The join method stops the current method from executing and it
        //must be surrounded in try-catch in order to work
        try {
            this.thread.join();
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
