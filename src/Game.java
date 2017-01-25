import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferStrategy;

@SuppressWarnings("serial")
public class Game extends Canvas implements Runnable {

    public static final String TITLE = "TITLE";
    public static final int WIDTH = 1080, HEIGHT = 720;

    private Thread thread;
    private boolean running;
    private Handler handler;

    public Game() {

        this.thread = new Thread(this);
        this.running = false;

        new Window(this);
        this.handler = new Handler();

        this.start();
        this.addKeyListener(new KeyInput(this));

    }

    public void start() {
        this.thread.start();
        this.running = true;
    }

    public void stop() {
        try {
            this.thread.join();
            this.running = false;
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void tick() {
        this.handler.tick();
    }

    public void render() {
        BufferStrategy bs = this.getBufferStrategy();
        if (bs == null) {
            this.createBufferStrategy(2);
            return;
        }
        Graphics2D g2d = (Graphics2D) bs.getDrawGraphics();

        g2d.setColor(Color.DARK_GRAY);
        g2d.fillRect(0, 0, this.getWidth(), this.getHeight());

        this.handler.render(g2d);

        g2d.dispose();
        bs.show();
    }

    @Override
    public void run() {
        long timer = System.currentTimeMillis();
        int frames = 0;
        int ticks = 0;
        long lastTime = System.nanoTime();
        double delta = 0;
        double tps = 60;
        double ns = 1000000000 / tps;
        while (this.running) {
            long now = System.nanoTime();
            delta += (now - lastTime) / ns;
            lastTime = now;
            while (delta >= 1) {
                this.tick();
                ticks++;
                delta--;
            }
            this.render();
            frames++;
            if (System.currentTimeMillis() - timer >= 1000) {
                System.out.println("FPS: " + frames + " TPS: " + ticks);
                ticks = 0;
                frames = 0;
                timer += 1000;
            }
        }
    }

    public static void main(String[] args) {
        new Game();
    }

}
