import CarProduction.Saab95;
import org.junit.Test;

import java.awt.*;

public class CarTest {

    @Test
    public void testStartEngine() {

        CarProduction.Car c = new Saab95(5,5, Color.red, "Volvo", true);
        c.startEngine();
        assert (c.getCurrentSpeed() == 0.1);
    }

    @Test
    public void testStopEngine() {

        CarProduction.Car c = new Saab95(5,5, Color.red, "Volvo", true);
        c.stopEngine();
        assert (c.getCurrentSpeed() == 0.0);
    }


    @Test
    public void testGas() {

        CarProduction.Car c = new Saab95(5,5, Color.red, "Volvo", true);
        c.startEngine();
        c.gas(0.9);
        assert (c.getCurrentSpeed() == 0.1585);

    }

    @Test
    public void testMove() {

        CarProduction.Car c = new Saab95(5,5, Color.red, "Volvo", true);
        c.startEngine();
        c.gas(0.4);
        c.move();
        System.out.println(c.getPosition());
        assert (c.getPosition().equals("(0.126,0.0)"));
    }

    @Test
    public void testTurnLeftAndRight() {

        CarProduction.Car c = new Saab95(5,5, Color.red, "Volvo", true);
        c.startEngine();
        c.turnLeft();
        c.move();
        assert (c.getPosition().equals("(0.0,0.1)"));

        CarProduction.Car d = new Saab95(5,5, Color.red, "Volvo", true);
        d.startEngine();
        d.turnRight();
        d.move();
        assert (d.getPosition().equals("(0.0,-0.1)"));

    }
}
