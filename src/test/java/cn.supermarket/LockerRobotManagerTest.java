package cn.supermarket;

import cn.supermarket.exception.InvalidBagTypeException;
import cn.supermarket.exception.InvalidCustomerException;
import cn.supermarket.exception.InvalidTicketException;
import cn.supermarket.exception.NoAvailableSpaceException;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class LockerRobotManagerTest {
    @Rule
    public ExpectedException expectedEx = ExpectedException.none();

    @Test
    public void given_LockerRobotManager_managed_lockerA_PrimaryLockerRobot_andSuperLockerRobot_All_have_available_spaces_when_VIP_store_S_bag_then_store_successfully() {
        Locker lockerA = new Locker(1, BagType.S);
        Bag bagA = new Bag(BagType.S);

        LockerRobotManager lockerRobotManager = new LockerRobotManager(Arrays.asList(lockerA), null);
        Ticket ticketA = lockerRobotManager.store(bagA, true);

        assertNotNull(ticketA);
        assertEquals(BagType.S, ticketA.getType());
        assertEquals(bagA, lockerRobotManager.getBag(ticketA));
    }


    @Test
    public void given_LockerRobotManager_managed_full_lockerA_PrimaryLockerRobot_andSuperLockerRobot_All_have_available_spaces_when_VIP_store_S_bag_then_store_successfully() {
        Locker lockerA = new Locker(1, BagType.S);
        Bag bagA = new Bag(BagType.S);
        lockerA.store(new Bag(BagType.S));

        LockerRobotManager lockerRobotManager = new LockerRobotManager(Arrays.asList(lockerA), null);

        expectedEx.expect(NoAvailableSpaceException.class);
        lockerRobotManager.store(bagA, true);
    }

    @Test
    public void given_LockerRobotManager_managed_lockerA_PrimaryLockerRobot_and_SuperLockerRobot_All_have_available_spaces_when_VIP_store_M_bag_then_store_successfully() {
        Locker lockerA = new Locker(1, BagType.M);
        Bag bagA = new Bag(BagType.M);
        PrimaryLockerRobot primaryLockerRobot = new PrimaryLockerRobot(Arrays.asList(lockerA));

        LockerRobotManager lockerRobotManager = new LockerRobotManager(null, Arrays.asList(primaryLockerRobot));
        Ticket ticketA = lockerRobotManager.store(bagA, true);

        assertNotNull(ticketA);
        assertEquals(BagType.M, ticketA.getType());
        assertEquals(bagA, lockerRobotManager.getBag(ticketA));
    }


    @Test
    public void given_LockerRobotManager_managed_full_lockerA_PrimaryLockerRobot_andSuperLockerRobot_All_have_available_spaces_when_VIP_store_M_bag_then_store_successfully() {
        Locker lockerA = new Locker(1, BagType.M);
        Bag bagA = new Bag(BagType.M);
        lockerA.store(new Bag(BagType.M));
        PrimaryLockerRobot primaryLockerRobot = new PrimaryLockerRobot(Arrays.asList(lockerA));

        LockerRobotManager lockerRobotManager = new LockerRobotManager(null, Arrays.asList(primaryLockerRobot));

        expectedEx.expect(NoAvailableSpaceException.class);
        lockerRobotManager.store(bagA, true);
    }

    @Test
    public void given_LockerRobotManager_managed_lockerA_PrimaryLockerRobot_and_SuperLockerRobot_All_have_available_spaces_when_VIP_store_L_bag_then_store_successfully() {
        Locker lockerA = new Locker(1, BagType.L);
        Bag bagA = new Bag(BagType.L);
        SuperLockerRobot superLockerRobot = new SuperLockerRobot(Arrays.asList(lockerA));

        LockerRobotManager lockerRobotManager = new LockerRobotManager(null, Arrays.asList(superLockerRobot));
        Ticket ticketA = lockerRobotManager.store(bagA, true);

        assertNotNull(ticketA);
        assertEquals(BagType.L, ticketA.getType());
        assertEquals(bagA, lockerRobotManager.getBag(ticketA));
    }


    @Test
    public void given_LockerRobotManager_managed_full_lockerA_PrimaryLockerRobot_and_SuperLockerRobot_All_have_available_spaces_when_VIP_store_L_bag_then_store_successfully() {
        Locker lockerA = new Locker(1, BagType.L);
        Bag bagA = new Bag(BagType.L);
        lockerA.store(new Bag(BagType.L));
        SuperLockerRobot superLockerRobot = new SuperLockerRobot(Arrays.asList(lockerA));

        LockerRobotManager lockerRobotManager = new LockerRobotManager(null, Arrays.asList(superLockerRobot));

        expectedEx.expect(NoAvailableSpaceException.class);
        lockerRobotManager.store(bagA, true);
    }

    @Test
    public void given_LockerRobotManager_managed_lockerA_PrimaryLockerRobot_and_SuperLockerRobot_And_VIP_store_S_bag_and_can_get_bag_successfully() {
        Locker lockerA = new Locker(1, BagType.S);
        Bag bagA = new Bag(BagType.S);
        LockerRobotManager lockerRobotManager = new LockerRobotManager((Arrays.asList(lockerA)), null);
        Ticket ticket = lockerRobotManager.store(bagA, true);

        assertEquals(bagA, lockerRobotManager.getBag(ticket));
    }

    @Test
    public void given_LockerRobotManager_managed_lockerA_PrimaryLockerRobot_and_SuperLockerRobot_And_VIP_store_S_bag_and_get_bag_with_invalid_ticket() {
        Locker lockerA = new Locker(2, BagType.S);
        Bag bagA = new Bag(BagType.S);
        LockerRobotManager lockerRobotManager = new LockerRobotManager((Arrays.asList(lockerA)), null);
        Ticket ticket = lockerRobotManager.store(bagA, true);
        Ticket invalidTicket = new Ticket(BagType.S);

        expectedEx.expect((InvalidTicketException.class));
        assertEquals(bagA, lockerRobotManager.getBag(invalidTicket));
    }

    @Test
    public void given_LockerRobotManager_managed_lockerA_PrimaryLockerRobot_and_SuperLockerRobot_And_VIP_store_M_bag_and_get_valid_ticket() {
        Locker lockerA = new Locker(1, BagType.M);
        Bag bagA = new Bag(BagType.M);
        PrimaryLockerRobot primaryLockerRobot = new PrimaryLockerRobot(Arrays.asList(lockerA));
        LockerRobotManager lockerRobotManager = new LockerRobotManager(null, Arrays.asList(primaryLockerRobot));
        Ticket ticket = lockerRobotManager.store(bagA, true);

        assertEquals(bagA, lockerRobotManager.getBag(ticket));
    }

    @Test
    public void given_LockerRobotManager_managed_lockerA_PrimaryLockerRobot_and_SuperLockerRobot_And_VIP_store_L_bag_and_get_valid_ticket() {
        Locker lockerA = new Locker(1, BagType.L);
        Bag bagA = new Bag(BagType.L);
        SuperLockerRobot superLockerRobot = new SuperLockerRobot(Arrays.asList(lockerA));
        LockerRobotManager lockerRobotManager = new LockerRobotManager(null, Arrays.asList(superLockerRobot));
        Ticket ticket = lockerRobotManager.store(bagA, true);

        assertEquals(bagA, lockerRobotManager.getBag(ticket));
    }
}
