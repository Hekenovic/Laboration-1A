package CarProduction;
import java.awt.*;

/**
 * Abstract class for blueprint of cars.
 */
public abstract class Car implements Movable {
    /**
     * Our instance variables. Number of doors, engine power, current, color and model name
     */
    private int nrDoors;
    private double enginePower;
    private double currentSpeed;
    private Color color;
    private String modelName;

    /**
     * This is the constructor for our class Car. Have stopEngine(); so when we create a new
     * object of the class, the car is at rest.
     * @param nrDoors Number of doors.
     * @param enginePower Engine power.
     * @param color Color.
     * @param modelName Model name.
     */
    Car(int nrDoors, double enginePower, Color color, String modelName) {
        this.nrDoors = nrDoors;
        this.enginePower = enginePower;
        this.color = color;
        this.modelName = modelName;
        stopEngine();
    }

    /**
     * Getter for the number of doors.
     * @return Return number of doors.
     */
    public int getNrDoors(){
        return nrDoors;
    }

    /**
     * Getter for the engine power.
     * @return Return engine power.
     */
    public double getEnginePower(){
        return enginePower;
    }

    /**
     * Getter for the current speed.
     * @return Return the current speed of the car.
     */
    public double getCurrentSpeed(){
        return currentSpeed;
    }

    /**
     * Getter for the color.
     * @return Return the color of the car.
     */
    public Color getColor(){
        return color;
    }

    /**
     * Setter for color.
     * @param clr Setting the color of the car.
     */
    public void setColor(Color clr){
        color = clr;
    }

    /**
     * Method to start the engine.
     */
    public void startEngine(){
        currentSpeed = 0.1;
    }

    /**
     * Method to stop the engine.
     */
    public void stopEngine(){
        currentSpeed = 0;
    }

    /**
     * Create a abstract method for the speed factor, since it's unique for each subclass
     * and to be overridden.
     * @return Return the speed factor of car.
     */
    abstract double speedFactor();

    /**
     * @param amount Takes a double of how much we want to increase the speed.
     */
    private void incrementSpeed(double amount){
        currentSpeed = Math.min(getCurrentSpeed() + speedFactor() * amount,enginePower);
    }

    /**
     * @param amount Takes a double of how much we want to decrease the speed.
     */
    private void decrementSpeed(double amount) {
        currentSpeed = Math.max(0,getCurrentSpeed() - speedFactor() * amount);
    }

    /**
     * @param amount Takes a double between 0 and 1, and passes it to incrementSpeed();, increases the speed
     *               which is dependent on the subclasses speedFactor.
     */
    public void gas(double amount){
        if (0 <= amount && amount <= 1)
            incrementSpeed(amount);
        else
            System.out.println("Value needs to be in interval [0,1]. The current speed is unchanged.");
    }

    /**
     * @param amount Takes a double between 0 and 1, and passes it to decrementSpeed(); which decrease the speed
     *               depending on the subclasses speedFactor.
     */
    public void brake(double amount){
        if (0 <= amount && amount <= 1)
            decrementSpeed(amount);
        else
            System.out.println("Value needs to be in interval [0,1]. The current speed is unchanged.");
    }

    /**
     * Making enum for the directions, since they are not going to change. All uppercase for extra clarification.
     */
    enum Direction {
        NORTH,
        WEST,
        SOUTH,
        EAST
    }

    /**
     * New instance variables to keep track of where the cars current position.
     */
    private double xPosition = 0;
    private double yPosition = 0;
    private Direction facingDirection = Direction.EAST;

    /**
     * Getter for the cars current position. Used mainly for testing.
     * @return Return the current position of the car in the XY-plane.
     */
    public String getPosition(){
        String position = "(" + xPosition + "," + yPosition + ")";
        return position;
    }

    /**
     * Method to make the car move in the right direction depending on what way it's facing.
     */
    @Override
    public void move() {

        switch(facingDirection) {
            case EAST:  xPosition += currentSpeed; break;
            case WEST:  xPosition -= currentSpeed; break;
            case NORTH: yPosition += currentSpeed; break;
            case SOUTH: yPosition -= currentSpeed; break;
        }
    }

    /**
     * Turns the car 90 degrees left from current direction it's facing.
     */
    @Override
    public void turnLeft() {
        switch(facingDirection) {
            case EAST:  facingDirection = Direction.NORTH; break;
            case NORTH: facingDirection = Direction.WEST;  break;
            case WEST:  facingDirection = Direction.SOUTH; break;
            case SOUTH: facingDirection = Direction.EAST;  break;
        }
    }
    /**
     * Turns the car 90 degrees right from the current direction it's facing.
     */
    @Override
    public void turnRight() {
        switch(facingDirection) {
            case EAST:  facingDirection = Direction.SOUTH; break;
            case NORTH: facingDirection = Direction.EAST;  break;
            case WEST:  facingDirection = Direction.NORTH; break;
            case SOUTH: facingDirection = Direction.WEST;  break;
        }
    }
}