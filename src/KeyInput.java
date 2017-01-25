import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyInput extends KeyAdapter {

    private Game game;

    public KeyInput(Game game) {
        this.game = game;
    }

    @Override
    public void keyPressed(KeyEvent e) {

        int key = e.getKeyCode();

    }

    @Override
    public void keyReleased(KeyEvent e) {

        int key = e.getKeyCode();

    }
}
