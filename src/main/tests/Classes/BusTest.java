package Classes;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

class BusTest {
    @Test
    void setGovernmentNumber() {
        Bus bus = new Bus("governmentNumber", "busNumber");
        String newGovernmentNumber = "newGovernmentNumber";
        bus.setGovernmentNumber(newGovernmentNumber);
        Assert.assertTrue(bus.getGovernmentNumber().equalsIgnoreCase(newGovernmentNumber));
    }

}