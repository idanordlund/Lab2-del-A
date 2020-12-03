import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/*
* This class represents the Controller part in the MVC pattern.
* It's responsibilities is to listen to the View and responds in a appropriate manner by
* modifying the model state and the updating the view.
 */

public class CarController {
    // member fields:

    // The delay (ms) corresponds to 20 updates a sec (hz)
    private final int delay = 50;
    // The timer is started with an listener (see below) that executes the statements
    // each step between delays.
    private Timer timer = new Timer(delay, new TimerListener());
    // The frame that represents this instance View of the MVC pattern
    CarView frame;
    // A list of cars
    List<GeneralVehicle> cars = new ArrayList<>();

    //methods:

    public static void main(String[] args) {
        // Instance of this class
        CarController cc = new CarController();

        GeneralVehicle saab = new Saab95();
        GeneralVehicle scania = new Scania();

        cc.cars.add(new Volvo240());

        saab.setPosition(new Point(0, 100));
        scania.setPosition(new Point(0, 200));

        cc.cars.add(scania);
        cc.cars.add(saab);
        // Start a new view and send a reference of self
        cc.frame = new CarView("CarSim 1.0", cc);

        // Start the timer
        cc.timer.start();
    }

    /* Each step the TimerListener moves all the cars in the list and tells the
     * view to update its images.
     * */
    private class TimerListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            for (GeneralVehicle car : cars) {
                car.move();
                turnAround(car);
                int x = (int) Math.round(car.getPosition().getX());
                int y = (int) Math.round(car.getPosition().getY());
                frame.drawPanel.moveit(car, x, y);
                // repaint() calls the paintComponent method of the panel
                frame.drawPanel.repaint();
            }
        }
    }

    public List<GeneralVehicle> getCars() {
        return cars;
    }

    // Calls the gas method for each car once
    void gas(int amount) {
        double gas = ((double) amount) / 100;
        for (GeneralVehicle car : cars) {
            car.gas(gas);
        }
    }
    // Calls the brake method for each car once
    void brake(int amount) {
        double brake = ((double) amount) / 100;
        for (GeneralVehicle car : cars) {
            car.brake(brake);
        }
    }

    public void turboOn() {
        for (GeneralVehicle saab : cars.<GeneralVehicle>stream().filter(c -> c instanceof Saab95).collect(Collectors.toUnmodifiableList())) {
            ((Saab95) saab).setTurboOn();
        }
    }


    public void turboOff() {
        for (GeneralVehicle saab : cars.<GeneralVehicle>stream().filter(c -> c instanceof Saab95).collect(Collectors.toUnmodifiableList())) {
            ((Saab95) saab).setTurboOff();
        }
    }

    public void liftBed() {
        for (GeneralVehicle scania : cars.<GeneralVehicle>stream().filter(c -> c instanceof Scania).collect(Collectors.toUnmodifiableList())) {
            ((Scania) scania).raisePlatform(50);
        }
    }

    public void lowerBed() {
        for (GeneralVehicle scania : cars.<GeneralVehicle>stream().filter(c -> c instanceof Scania).collect(Collectors.toUnmodifiableList())) {
            ((Scania) scania).lowerPlatform(50);
        }
    }

    public void startAll() {
        for (GeneralVehicle car : cars)
            car.startEngine();
    }

    public void stopAll() {
        for (GeneralVehicle car : cars)
            car.stopEngine();

    }
    // turns the vehicle before it drives out of the panel
    public void turnAround(GeneralVehicle car) {

        int x = (int) (frame.drawPanel.getSize().getWidth() - frame.drawPanel.getImageDimension(car).getWidth());
        int y = (int) (frame.drawPanel.getSize().getHeight() - frame.drawPanel.getImageDimension(car).getHeight());

        if (car.getPosition().getX() > x) {
            turnCar(car,Math.PI);
        }
        else if (car.getPosition().getX() < 0) {
            turnCar(car,0);
        }
        else if (car.getPosition().getY() > y) {
            turnCar(car,1.5*Math.PI);
        }
        else if (car.getPosition().getY() < 0) {
            turnCar(car,0.5*Math.PI);
        }

    }

    public void turnCar(GeneralVehicle car, double heading) {
        while (Math.abs((car.getHeading() % (2 * Math.PI) - heading)) > 0.1) {
            car.turnLeft();
        }
    }
}