import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class TestRepairShop {


	private RepairShop<GeneralVehicle> genericWorkshop;

	@Before
	public void init() {
		genericWorkshop = new RepairShop<>(10);
	}

	@Test
	public void testNrOfVehicles() {
		genericWorkshop.addUnit(new Volvo240());
		genericWorkshop.addUnit(new CarTransport());
		assertTrue(genericWorkshop.getNrOfUnits() == 2);
	}

	@Test
	public void testRetrieveVehicle() {
		Scania scania = new Scania();
		genericWorkshop.addUnit(scania);
		assertTrue(genericWorkshop.retrieveVehicle("Scania").equals(scania));
	}
}
