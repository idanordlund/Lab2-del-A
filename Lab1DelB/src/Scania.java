import java.awt.*;

/**
 * A class for a Scania truck
 */
public class Scania implements Truck{
	private RoadVehicle vehicleModel;
	private double platformAngle;

	/**
	 * Constructor for a Scania truck.
	 */
	public Scania() {
		vehicleModel = new RoadVehicle(this, 2, Color.GRAY, 100, "Scania");
		platformAngle = 0;
	}


	/** Raises the trucks platform
	 * @param degreesIncrease The angle to lift the raise the platform
	 * @throws RuntimeException throws exceptions if the platform is lifted while the vehicle is moving
	 */
	public void raisePlatform(double degreesIncrease) throws RuntimeException{
		if (getCurrentSpeed() != 0)
			throw new RuntimeException("The platform can not be raised while the vehicle is moving");
		platformAngle += degreesIncrease;
		if (platformAngle > 70)
			platformAngle = 70;
	}

	/** lowers the trucks platform
	 * @param degreesDecrease The angle to lift the lower the platform
	 */
	public void lowerPlatform(double degreesDecrease) {
		platformAngle -= degreesDecrease;
		if (platformAngle < 0)
			platformAngle = 0;
	}

	/**Returns the angle of the truck's platform.
	 * @return The current angle of the truck's platform
	 */
	public double getPlatformAngle() {
		return platformAngle;
	}

	/**
	 * Method which returns the speed factor of the car.
	 * @return the speed factor which determines how the car accelerates or decelerates.
	 */
	public double speedFactor() {
		return vehicleModel.getEnginePower() * 0.005;
	}

	/**
	 * Increases the speed of the vehicle up to a maximum limit of the vehicle's engine power.
	 * @param amount The factor by which the vehicle will increase its speed.
	 * @throws RuntimeException throws exceptions if truck is not ready to drive
	 */
	@Override
	public void incrementSpeed(double amount) throws RuntimeException{
		if (!isReadyToDrive())
			throw new RuntimeException("The vehicle can not accelerate when the platform is raised");
		vehicleModel.setCurrentSpeed(Math.min(getCurrentSpeed() + speedFactor() * amount, getEnginePower()));
	}

	/**Returns the number of doors of the vehicle.
	 * @return The number of doors of the vehicle.
	 */
	@Override
	public int getNrDoors() {
		return vehicleModel.getNrDoors();
	}

	/** Returns true if the vehicle can drive.
	 * @return True if the vehicle can drive.
	 */
	@Override
	public boolean isReadyToDrive() {
		return platformAngle == 0;
	}

	/**Returns the engine power of the vehicle.
	 * @return The engine power of the vehicle.
	 */
	@Override
	public double getEnginePower() {
		return vehicleModel.getEnginePower();
	}

	/** Returns the model name of the vehicle.
	 * @return The model name of the vehicle.
	 */
	@Override
	public String getModelName() {
		return vehicleModel.getModelName();
	}

	/**Returns the current speed of the vehicle.
	 * @return The current speed of the vehicle.
	 */
	@Override
	public double getCurrentSpeed() {
		return vehicleModel.getCurrentSpeed();
	}

	/**Returns the color of the vehicle.
	 * @return The color of the vehicle.
	 */
	@Override
	public Color getColor() {
		return vehicleModel.getColor();
	}

	/** Sets the position of the vehicle
	 * @param position The position to be set.
	 */
	@Override
	public void setPosition(Point position) {
		vehicleModel.setPosition(position);
	}

	/**Returns the vehicle's current position as a Point.
	 * @return The vehicle's current position as a Point.
	 */
	@Override
	public Point getPosition() {
		return vehicleModel.getPosition();
	}

	/**Return the vehicle's current heading in radians.
	 * @return The vehicle's current heading in radians.
	 */
	@Override
	public double getHeading() {
		return vehicleModel.getHeading();
	}

	/**
	 * Sets the color of the vehicle.
	 * @param color color which is to be set.
	 */
	@Override
	public void setColor(Color color) {
		vehicleModel.setColor(color);
	}

	/**
	 * Decreases the speed of the vehicle down to a minimum of zero.
	 * @param amount The factor by which the vehicle will decrease its speed.
	 */
	@Override
	public void decrementSpeed(double amount) {
		vehicleModel.decrementSpeed(amount);
	}

	/**
	 * Increases the speed of the vehicle.
	 * @param amount The factor of the increase. Must be in the interval [0, 1].
	 * @throws RuntimeException If the input is not within the interval [0, 1].
	 */
	@Override
	public void gas(double amount) {
		vehicleModel.gas(amount);
	}

	/**
	 * Decreases the speed of the vehicle.
	 * @param amount The factor of the decrease. Must be in the interval [0, 1].
	 * @throws RuntimeException If the input is not within the interval [0, 1].
	 */
	@Override
	public void brake(double amount) {
		vehicleModel.brake(amount);
	}

	/**
	 * Starts the vehicle by setting the variable currentspeed to a positive value.
	 */
	@Override
	public void startEngine() {
		vehicleModel.startEngine();
	}

	/**
	 * Stops the vehicle by setting the variable currentspeed to zero.
	 */
	@Override
	public void stopEngine() {
		vehicleModel.stopEngine();
	}

	/**
	 * Implements the move method from the Movable interface. Changes the vehicle's position to a position further along the current heading by a distance determined by the vehicle's current speed.
	 */
	@Override
	public void move() {
		vehicleModel.move();
	}

	/**
	 * Implements the turnLeft method from the Movable interface. Changes the vehicle's heading by half a radian to the left.
	 */
	@Override
	public void turnLeft() {
		vehicleModel.turnLeft();
	}

	/**
	 * Implements the turnRight method from the Movable interface. Changes the vehicle's heading by half a radian to the right.
	 */
	@Override
	public void turnRight() {
		vehicleModel.turnRight();
	}

	@Override
	public String toString() {
		return vehicleModel.toString();
	}
}
