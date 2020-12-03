import javax.swing.text.Position;
import java.awt.*;

public class RoadVehicle {

	/**
	 * Represents the number of doors of the  vehicle.
	 */
	private int nrDoors; // Number of doors on the vehicle
	private GeneralVehicle generalVehicle;
	private Vehicle vehicleModel;


	/**A constructor used by the constructor of specific vehicles to model the road behaviours of those vehicles
	 * @param generalVehicle The vehicle which used the RoadVehicle model
	 * @param nrDoors The number of doors
	 * @param color The color of the vehicle
	 * @param enginePower The power of the vehicle's engine
	 * @param modelName The model name of the vehicle
	 */
	public RoadVehicle(GeneralVehicle generalVehicle, int nrDoors, Color color, double enginePower, String modelName) {

		this.generalVehicle = generalVehicle;

		vehicleModel = new Vehicle(generalVehicle, color, enginePower, modelName);

		this.nrDoors = nrDoors;
	}

	/**Returns the number of doors of the vehicle.
	 * @return The number of doors of the vehicle.
	 */
	public int getNrDoors(){
		return nrDoors;
	}

	/**Returns the engine power of the vehicle.
	 * @return The engine power of the vehicle.
	 */
	public double getEnginePower(){
		return vehicleModel.getEnginePower();
	}


	/** Returns the model name of the vehicle.
	 * @return The model name of the vehicle.
	 */
	public String getModelName() {
		return vehicleModel.getModelName();
	}


	/**Returns the current speed of the vehicle.
	 * @return The current speed of the vehicle.
	 */
	public double getCurrentSpeed(){
		return vehicleModel.getCurrentSpeed();
	}


	/**Returns the color of the vehicle.
	 * @return The color of the vehicle.
	 */
	public Color getColor(){
		return vehicleModel.getColor();
	}

	/**
	 * Sets the color of the vehicle.
	 * @param clr color which is to be set.
	 */
	public void setColor(Color clr){
		vehicleModel.setColor(clr);
	}

	/** Sets the speed of the vehicle
	 * @param speed The speed of the vehicle
	 */
	public void setCurrentSpeed(double speed) {
		vehicleModel.setCurrentSpeed(speed);
	}

	/**
	 * Starts the vehicle by setting the variable currentspeed to a positive value.
	 */
	public void startEngine(){
		vehicleModel.startEngine();
	}

	/**
	 * Stops the vehicle by setting the variable currentspeed to zero.
	 */
	public void stopEngine(){
		vehicleModel.stopEngine();
	}

	/**
	 * Increases the speed of the vehicle up to a maximum limit of the vehicle's engine power.
	 * @param amount The factor by which the vehicle will increase its speed.
	 */
	public void incrementSpeed(double amount) {
		vehicleModel.incrementSpeed(amount);
	}

	/**
	 * Decreases the speed of the vehicle down to a minimum of zero.
	 * @param amount The factor by which the vehicle will decrease its speed.
	 */
	public void decrementSpeed(double amount) {
		vehicleModel.decrementSpeed(amount);
	}


	/**
	 * Increases the speed of the vehicle.
	 * @param amount The factor of the increase. Must be in the interval [0, 1].
	 * @throws RuntimeException If the input is not within the interval [0, 1].
	 */
	public void gas(double amount) throws RuntimeException{
		vehicleModel.gas(amount);
	}

	/**
	 * Decreases the speed of the vehicle.
	 * @param amount The factor of the decrease. Must be in the interval [0, 1].
	 * @throws RuntimeException If the input is not within the interval [0, 1].
	 */
	public void brake(double amount) throws RuntimeException{
		vehicleModel.brake(amount);
	}

	/**Returns the vehicle's current position as a Point.
	 * @return The vehicle's current position as a Point.
	 */
	public Point getPosition(){
		return vehicleModel.getPosition();
	}

	/** Sets the position of the vehicle
	 * @param position The position to be set.
	 */
	public void setPosition(Point position) {
		vehicleModel.setPosition(position);
	}

	/**Return the vehicle's current heading in radians.
	 * @return The vehicle's current heading in radians.
	 */
	public double getHeading() {
		return vehicleModel.getHeading();
	}

	/**
	 * Implements the move method from the Movable interface. Changes the vehicle's position to a position further along the current heading by a distance determined by the vehicle's current speed.
	 */
	public void move() {
		vehicleModel.move();
	}


	/**
	 * Implements the turnLeft method from the Movable interface. Changes the vehicle's heading by half a radian to the left.
	 */
	public void turnLeft() {
		vehicleModel.turnLeft();
	}

	/**
	 * Implements the turnRight method from the Movable interface. Changes the vehicle's heading by half a radian to the right.
	 */
	public void turnRight() {
		vehicleModel.turnRight();
	}

	public String toString() {
		return vehicleModel.toString();
	}

}
