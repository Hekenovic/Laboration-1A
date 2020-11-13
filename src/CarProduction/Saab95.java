package CarProduction;

import java.awt.*;

/**
 * Subclass of abstract class Car.
 */
public class Saab95 extends Car {
    /**
     * Instance variable.
     */
    private boolean turboOn;
    /**
     * Method to turn on the turbo.
     */
    public void setTurboOn(){
        turboOn = true;
    }
    /**
     * Method to turn off the turbo.
     */
    public void setTurboOff(){
        turboOn = false;
    }

    /**
     * Our constructor for the subclass
     * @param nrDoors Number of doors.
     * @param enginePower Engine power.
     * @param color Color.
     * @param modelName Model name.
     * @param turboOn Boolean for turbo, if it is on or not
     */
    public Saab95(int nrDoors, double enginePower, Color color, String modelName, boolean turboOn) {
        super(nrDoors, enginePower, color, modelName);
        this.turboOn = turboOn;
    }

    /**
     * Help method to the increment-/drecrementSpeed method. Overridden from superclass
     * @return Returns the speed factor
     */
    @Override
    public double speedFactor() {
        double turbo = 1;
        if(turboOn) turbo = 1.3;
        return getEnginePower() * 0.01 * turbo;
    }
}