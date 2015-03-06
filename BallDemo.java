import java.awt.Color;
import java.util.ArrayList;
import java.util.Random;

/**
 * Class BallDemo - a short demonstration showing animation with the 
 * Canvas class. 
 *
 * @author Michael KÃ¶lling and David J. Barnes
 * @version 2011.07.31
 */

public class BallDemo   
{
    private Canvas myCanvas;

    /**
     * Create a BallDemo object. Creates a fresh canvas and makes it visible.
     */
    public BallDemo()
    {
        myCanvas = new Canvas("Ball Demo", 600, 500);
    }

    /**
     * Simulate a number of bouncing balls
     * @param num Number of bouncing balls to simulate
     */
    public void bounce(int num)
    {
        int ground = 400;   // position of the ground line
        myCanvas.setVisible(true);
        // draw the ground
        myCanvas.drawLine(50, ground, 550, ground);
        // crate and show the balls
        int index = 0;
        // Creamos los random para generar cada uno de los datos
        Random rand = new Random();
        int xPo = 0;
        int yPo = 0;
        int dia = 0;
        ArrayList<BouncingBall> pelotas = new ArrayList<BouncingBall>();
        // Creamos las pelotas y las añadimos a un random
        while (index < num)
        {
            Color col = new Color(rand.nextInt(256), rand.nextInt(256), rand.nextInt(256));
            xPo = rand.nextInt(150) + 200;
            yPo = rand.nextInt(150);
            dia = rand.nextInt(20) + 10;
            pelotas.add(new BouncingBall(xPo, yPo, dia, col, ground, myCanvas));
            index++;
        }
        // make them bounce
        boolean finished =  false;
        while(!finished) {
            myCanvas.wait(50);           // small delay
            for(int i = 0;i < pelotas.size();i++)
            {
                pelotas.get(i).move();
                // stop once ball has travelled a certain distance on x axis
                if (pelotas.get(i).getXPosition() >= 550)
                {
                    finished = true;
                }
            }
        }
    }

    /**
     * Simulate a number of bouncing balls
     * @param num Number of bouncing balls to simulate
     */
    public void boxBounce(int num)
    {
        int ground = 400;   // position of the ground line
        myCanvas.setVisible(true);
        // draw the ground
        myCanvas.drawLine(50, 50, 450, 50);
        myCanvas.drawLine(450, 50, 450, 450);
        myCanvas.drawLine(450, 450, 50, 450);
        myCanvas.drawLine(50, 450, 50, 50);
        // crate and show the balls
        int index = 0;
        // Creamos los random para generar cada uno de los datos
        Random rand = new Random();
        int xPo = 0;
        int yPo = 0;
        int dia = 0;
        boolean direccion;
        ArrayList<BoxBall> pelotas = new ArrayList<BoxBall>();
        // Creamos las pelotas y las añadimos a un random
        while (index < num)
        {
            Color col = new Color(rand.nextInt(256), rand.nextInt(256), rand.nextInt(256));
            xPo = rand.nextInt(400) + 50;
            yPo = rand.nextInt(200) + 50;
            dia = rand.nextInt(40) + 10;
            direccion = rand.nextBoolean();
            pelotas.add(new BoxBall(xPo, yPo, dia, col, ground, myCanvas, direccion));
            index++;
        }
        // make them bounce
        boolean finished =  false;
        while(!finished) {
            myCanvas.wait(50);           // small delay
            for(int i = 0;i < pelotas.size();i++)
            {
                pelotas.get(i).move();
                // stop once ball has travelled a certain distance on x axis
                if (pelotas.get(i).getXPosition() >= 550)
                {
                    finished = true;
                }
            }

        }
    }
}
