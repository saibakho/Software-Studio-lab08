import de.looksgood.ani.Ani;
import processing.core.PApplet;
import java.util.ArrayList;
import java.util.Random;

public class Main extends PApplet {

    public static void main(String[] args) {
        PApplet.main("Main", args);
    }
    int num;

    public ArrayList<Ball> balls = new ArrayList<>();
    @Override
    public void setup() {

        Ani.init(this);
        num = 10;
        //calculate the position of the balls
        Random rand = new Random();
        //you can assign by yourself
        for (int i = 0; i < num; i++) {
            int x = (i % 5 * 120) + 60;
            int y = i / 5 * 200 + 100;
            println("" + x + "," + y);
            int radius = 50;
            Ball b = new Ball(this, x, y, radius);
            balls.add(b);
        }
    }

    @Override
    public void draw() {
        background(51);
        for (Ball b : balls) {
            //physics calculation
            b.update();
            b.checkBoundaryCollision();
            //draw ball
            b.display();
        }
        int i, j;
        for (i = 0, j = 0; i < balls.size(); i++) {
            for (j = i + 1; j < balls.size(); j++) {
                balls.get(i).checkCollision(balls.get(j));
            }
        }
    }
    @Override
    public void mousePressed() {
        println("mouse pressed");
        //TODO iterate through the balls and check if the mouse is inside the ball
        for (int i = 0; i < num; i++)
            if (balls.get(i).checkMouseClicked(mouseX, mouseY)) {
                Random rand = new Random();
                balls.get(i).setForm(rand.nextInt(256),
                                    rand.nextInt(256),
                                    rand.nextInt(256),
                                    20 + rand.nextInt(40));
            }
    }

    @Override
    public void settings() {
        super.settings();
        size(720, 480);
    }
}

