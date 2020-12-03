//import org.junit.Before;
//import org.junit.Test;
//
//import java.awt.*;
//import java.util.ArrayList;
//
//import static org.junit.Assert.*;
//
//public class TestVehicle {
//
//	private Car volvo;
//	private Car saab;
//	private Truck scania;
//	private ArrayList<GeneralVehicle> listOfVehicles;
//
//	@Before
//	public void init() {
//		volvo = new Volvo240();
//		saab = new Saab95();
//		scania = new Scania();
//
//		listOfVehicles = new ArrayList<>();
//		listOfVehicles.add(volvo);
//		listOfVehicles.add(saab);
//		listOfVehicles.add(scania);
//	}
//
//	@Test
//	public void testNrDoors() {
//		assertTrue(volvo.getNrDoors() == 4 && saab.getNrDoors() == 2 && scania.getNrDoors() == 2);
//	}
//
//	@Test
//	public void testEnginePower() {
//		assertTrue(volvo.getEnginePower() == 100 && saab.getEnginePower() == 125 && scania.getEnginePower() == 100);
//	}
//
//	@Test
//	public void testMaxPower() {
//
//		for (GeneralVehicle vehicle : listOfVehicles) {
//			for (int i = 0; i < 1000; i++)
//				vehicle.gas(1);
//			if (vehicle.getCurrentSpeed() > 1000)
//				fail();
//		}
//		assertTrue(true);
//	}
//
//	@Test
//	public void testMinPower() {
//		for (GeneralVehicle vehicle : listOfVehicles) {
//			for (int i = 0; i < 500; i++)
//				vehicle.gas(1);
//			for (int i = 0; i < 1000; i++)
//				vehicle.brake(1);
//			if (vehicle.getCurrentSpeed() != 0)
//				fail();
//		}
//		assertTrue(true);
//	}
//
//	@Test
//	public void testColor() {
//		for (GeneralVehicle vehicle : listOfVehicles) {
//			vehicle.setColor(Color.YELLOW);
//			if (!(vehicle.getColor().equals(Color.YELLOW)))
//				fail();
//		}
//		assertTrue(true);
//	}
//
//	@Test
//	public void testStartCar() {
//		for (GeneralVehicle vehicle : listOfVehicles) {
//			vehicle.startEngine();
//			if (vehicle.getCurrentSpeed() <= 0)
//				fail();
//		}
//		assertTrue(true);
//	}
//
//	@Test
//	public void testStopCar() {
//
//		for (GeneralVehicle vehicle : listOfVehicles) {
//			vehicle.startEngine();
//			vehicle.stopEngine();
//			if (vehicle.getCurrentSpeed() > 0)
//				fail();
//		}
//		assertTrue(true);
//	}
//
//	@Test
//	public void testMove() {
//
//		for (GeneralVehicle vehicle : listOfVehicles) {
//			Point originalPosition = vehicle.getPosition();
//			vehicle.incrementSpeed(10);
//			vehicle.move();
//			if (vehicle.getPosition().equals(originalPosition))
//				fail();
//		}
//		assertTrue(true);
//	}
//
//
//	@Test
//	public void testTurning() {
//
//		for (GeneralVehicle vehicle : listOfVehicles) {
//			double OriginalHeading = vehicle.getHeading();
//			vehicle.turnLeft();
//			if (vehicle.getHeading() == OriginalHeading)
//				fail();
//
//			OriginalHeading = vehicle.getHeading();
//			vehicle.turnRight();
//			if (vehicle.getHeading() == OriginalHeading)
//				fail();
//		}
//		assertTrue(true);
//	}
//
//	@Test
//	public void testVolvoSpeedfactor() {
//		double volvoFactor = 1.25*0.01*100;
//		assertEquals(volvo.speedFactor(), volvoFactor, 0.001);
//	}
//
//	@Test
//	public void testSaabSpeedFactor() {
//
//		Saab95 saab2 = new Saab95();
//		saab2.setTurboOn();
//		double initialSpeedFactor = saab2.speedFactor();
//		saab2.setTurboOff();
//		assertTrue(initialSpeedFactor > saab2.speedFactor());
//	}
//
//	@Test
//	public void testModelName() {
//		assertTrue(volvo.getModelName().equals("Volvo240") && saab.getModelName().equals("Saab95") && scania.getModelName().equals("Scania"));
//	}
//}
