import java.awt.Color;
import java.util.ArrayList;
import java.util.Random;

/**
 * Class BallDemo - a short demonstration showing animation with the 
 * Canvas class. 
 *
 * @author Michael Kölling and David J. Barnes
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
     * @param num NUmber of bouncing balls to simulate
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
        Random xPo = new Random();
        Random yPo = new Random();
        Random color = new Random();
        Random dia = new Random();
        ArrayList<BouncingBall> pelotas = new ArrayList<BouncingBall>();
        while (index < num)
        {
            pelotas.add(new BouncingBall(xPo.nextInt(50) + 200,yPo.nextInt (50), dia.nextInt(20) + 10, Color.color(color.nextInt(256), color.nextInt(256), color.nextInt(256)), ground, myCanvas));
        }
        // make them bounce
        boolean finished =  false;
        while(!finished) {
            myCanvas.wait(50);           // small delay
            for(int i = 0;i < pelotas.size();i++)
            {
                pelotas.get(i).move();
            }

//             // stop once ball has travelled a certain distance on x axis
//             if(ball.getXPosition() >= 550 || ball2.getXPosition() >= 550) {
//                 finished = true;
//             }
        }

    }
}
