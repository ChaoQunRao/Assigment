// This program is copyright VUW.
// You are granted permission to use it to construct your answer to a XMUT102 assignment.
// You may not distribute it in any other way without permission.

/* Code for XMUT102 - 2018T2
 * Name:
 * Username:
 * ID:
 */

import ecs100.*;
import java.awt.Color;

/** DroppingBall represents a ball that falls towards the ground.
 *    Each time the step() method is called, it will take one step.  
 * For the Challenge part, the ball bounces when it reaches the ground.
 */

public class DroppingBall{
    // Fields to store
    //   the state of the ball:  x, height, stepX, stepY, colour
    //   other constants for the ball: size, position of the ground
    /*# YOUR CODE HERE */
    private double xPos;
    private double yPos;
    private double height;
    private double stepX;
    private double stepY;
    private double s;
    public static final double acc = 0.15;
    Color c;
    public static final int GROUND = 450;   // ground level.
    public static final int SIZE = 30;      // diameter of the ball

    // Constructor
    /** Construct a new DroppingBall object.
     *  Parameters are the initial x position, the height above the ground,
     *  the initial speed to the right (ie, the horizontal step size), and 
     *  the colour.
     *  Stores the parameters into fields (computing the y position from the height)
     *  and initialises the other fields,
     */
    public DroppingBall(double x, double h, double s, Color c){
        /*# YOUR CODE HERE */
        this.xPos = x;
        this.height = h-this.SIZE;
        this.yPos = this.GROUND - this.height-this.SIZE;
        this.stepX = s;
        this.stepY = s;
        this.s = s;
        this.c = c;
    }

    // Methods
    /** Move the ball one step.
     *  Changes its height and x position using the vertical and horizonal steps
     *  If it would go below ground, then change its y position to ground level
     */
    public void step(){
        /*# YOUR CODE HERE */
        this.xPos = this.xPos + this.stepX;
        this.yPos = this.yPos + this.stepY;
        this.height = this.height - this.stepY;
        this.stepY += acc;
        UI.sleep(10);
    }
    /** Return the height of the ball above the ground */
    public double getHeight(){
        /*# YOUR CODE HERE */
        return this.height;
    }
    public double getX(){
        /*# YOUR CODE HERE */
        return this.xPos;
    }
    public void setStepY(){
        this.stepY = -this.stepY;
    }
    public void setStepX(){
        this.stepX = -this.stepX;
    }
    


    /** Draw the ball on the Graphics Pane in its current position */
    public void draw(){
        /*# YOUR CODE HERE */
        UI.setColor(this.c);
        UI.fillOval(this.xPos,this.yPos,this.SIZE,this.SIZE);
    }
}
