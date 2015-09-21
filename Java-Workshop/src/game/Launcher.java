package game;

public class Launcher {

    public static void main(String[] args) {
        Game game = new Game("Title game!", 800, 600);
        // medota start e sinhroniziran i ste izvika metoda run na nova nishka
        game.start();
        // game.run(); v tozi variant metoda ste se izvika na sastata nishka
    }
}
