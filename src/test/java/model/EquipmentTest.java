package model;

import cz.cvut.omo.model.equipment.Equipment;
import cz.cvut.omo.model.equipment.EquipmentStatus;
import cz.cvut.omo.model.equipment.Machine;
import cz.cvut.omo.model.equipment.Tool;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class EquipmentTest {

    @Test
    public void testMachine() {
        Machine machine = new Machine("Tractor", EquipmentStatus.OFF,100);
        assertEquals("Tractor", machine.getName());
        assertEquals(EquipmentStatus.OFF, machine.getStatus());
        assertEquals(100, machine.getFuelLevel());
    }

    @Test
    public void testMachineSetFuelLevel() {
        Machine machine = new Machine("Tractor", EquipmentStatus.OFF,100);
        machine.setFuelLevel(200);
        assertEquals(200, machine.getFuelLevel());
    }

    @Test
    public void testMachineStatus() {
        Machine machine = new Machine("Tractor", EquipmentStatus.OFF,100);
        assertEquals(EquipmentStatus.OFF, machine.getStatus());
        machine.setStatus(EquipmentStatus.ON);
        assertEquals(EquipmentStatus.ON, machine.getStatus());
        machine.setStatus(EquipmentStatus.BROKEN);
        assertEquals(EquipmentStatus.BROKEN, machine.getStatus());
        machine.setStatus(EquipmentStatus.REPAIRED);
        assertEquals(EquipmentStatus.REPAIRED, machine.getStatus());
    }

    @Test
    public void testTool() {
        Tool tool = new Tool("Hammer", EquipmentStatus.OFF, "Hand");
        assertEquals("Hammer", tool.getName());
        assertEquals(EquipmentStatus.OFF, tool.getStatus());
        assertEquals("Hand", tool.getUsageType());
    }

    @Test
    public void testToolSetUsageType() {
        Tool tool = new Tool("Hammer", EquipmentStatus.OFF, "Hand");
        tool.setUsageType("Electric");
        assertEquals("Electric", tool.getUsageType());
    }

}
