import org.junit.Before;
import org.junit.Test;

import java.awt.*;

import static org.junit.Assert.*;

public class TestScania{

	private Scania testVehicle;

	@Before
	public void init() {
		testVehicle = new Scania();
	}

	@Test
	public void testNrDoors() {
		assertTrue(testVehicle.getNrDoors() == 2);
	}

	@Test
	public void testEnginePower() {
		assertTrue(testVehicle.getEnginePower() == 100);
	}

	@Test
	public void testPlatform() {
		testVehicle.raisePlatform(1000);
		assertTrue(testVehicle.getPlatformAngle() > 10 && testVehicle.getPlatformAngle() < 1000);
	}

	@Test
	public void testModelName() {
		assertTrue(testVehicle.getModelName().equals("Scania"));
	}




	@Test
	public void testMaxPower() {
		for (int i = 0; i < 1000; i++)
			testVehicle.incrementSpeed(10);
		assertTrue(testVehicle.getCurrentSpeed() < 1000);
	}

	@Test
	public void testMinPower() {
		for (int i = 0; i < 500; i++)
			testVehicle.incrementSpeed(10);
		for (int i = 0; i < 1000; i++)
			testVehicle.brake(1);
		assertTrue(testVehicle.getCurrentSpeed() == 0);
	}

	@Test
	public void testColor() {
		testVehicle.setColor(Color.YELLOW);
		assertTrue(testVehicle.getColor().equals(Color.YELLOW));
	}

	@Test
	public void testStartCar() {
		testVehicle.startEngine();
		assertTrue(testVehicle.getCurrentSpeed() > 0);
	}

	@Test
	public void testStopCar() {
		testVehicle.startEngine();
		testVehicle.stopEngine();
		assertTrue(testVehicle.getCurrentSpeed() == 0);
	}

	@Test
	public void testMove() {
		Point originalPosition = testVehicle.getPosition();
		testVehicle.incrementSpeed(100);
		testVehicle.move();
		assertTrue(!testVehicle.getPosition().equals(originalPosition));
	}


	@Test
	public void testTurning() {

		double OriginalHeading = testVehicle.getHeading();
		testVehicle.turnLeft();
		if (testVehicle.getHeading() == OriginalHeading)
			fail();

		OriginalHeading = testVehicle.getHeading();
		testVehicle.turnRight();
		if (testVehicle.getHeading() == OriginalHeading)
			fail();

		assertTrue(true);
	}
}
