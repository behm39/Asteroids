import java.awt.Graphics2D;

public class Ship implements GameObject {

    Vector pos, vel, acc;
    double heading;
    boolean thrusting;
    Rotation rotation;
    Game game;

    public Ship(Game game) {
        this.game = game;
        this.heading = 0;
        this.rotation = Rotation.None;

        this.pos = new Vector(game.getWidth() / 2, game.getHeight() / 2);
        this.vel = new Vector();
        this.acc = new Vector();
    }

    @Override
    public void tick() {
        // TODO Auto-generated method stub

    }

    @Override
    public void render(Graphics2D g2d) {
        // TODO Auto-generated method stub

    }

}
