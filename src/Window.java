import javax.swing.JFrame;

public class Window {

    public Window(Game game) {

        JFrame frame = new JFrame(Game.TITLE);
        frame.setVisible(true);

        frame.setSize(Game.WIDTH, Game.HEIGHT);
        game.setSize(Game.WIDTH, Game.HEIGHT);

        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);

        frame.add(game);
        frame.pack();

    }

}
