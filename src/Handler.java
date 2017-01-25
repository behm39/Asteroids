import java.awt.Graphics2D;
import java.util.LinkedList;

public class Handler {

    LinkedList<GameObject> objs;

    public Handler() {
        this.objs = new LinkedList<GameObject>();
    }

    public void addObject(GameObject obj) {
        this.objs.add(obj);
    }

    public void removeObject(GameObject obj) {
        this.objs.remove(obj);
    }

    public void tick() {
        for (int i = 0; i < this.objs.size(); i++) {
            this.objs.get(i).tick();
        }
    }

    public void render(Graphics2D g2d) {
        for (int i = 0; i < this.objs.size(); i++) {
            this.objs.get(i).render(g2d);
        }
    }

}
