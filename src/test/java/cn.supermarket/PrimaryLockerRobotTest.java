package cn.supermarket;

import cn.supermarket.exception.InvalidTicketException;
import cn.supermarket.exception.NoAvailableSpaceException;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class PrimaryLockerRobotTest {
    @Rule
    public ExpectedException expectedEx = ExpectedException.none();

    @Test
    public void given_PrimaryLockerRobot_manages_LockerA_and_lockerA_has_one_available_space_when_PrimaryLockerRobot_stores_bagA_then_store_successfully_and_get_valid_ticketA() {
        Locker lockerA = new Locker(1);
        Bag bagA = new Bag(BagType.M);

        List<Locker> lockers = new ArrayList<Locker>();
        lockers.add(lockerA);
        PrimaryLockerRobot primaryLockerRobot = new PrimaryLockerRobot(lockers);
        Ticket ticketA = primaryLockerRobot.store(bagA);
        assertNotNull(ticketA);
    }

    @Test
    public void given_primaryLockerRobot_manages_LockerA_and_lockerA_has_no_available_space_when_PrimaryLockerRobot_stores_bagA_then_get_error_message() throws NoAvailableSpaceException {
        Locker lockerA = new Locker(1);
        lockerA.store(new Bag(BagType.M));
        Bag bagA = new Bag(BagType.M);


        PrimaryLockerRobot primaryLockerRobot = new PrimaryLockerRobot(Arrays.asList(lockerA));

        expectedEx.expect(NoAvailableSpaceException.class);
        primaryLockerRobot.store(bagA);
    }

    @Test
    public void given_PrimaryLockerRobot_manage_LockerA_and_LockerB_both_lockers_have_available_spaces_when_PrimaryLockerRobot_stores_bagA_then_get_valid_ticketA_and_bagA_is_stored_in_LockerA() {
        Locker lockerA = new Locker(12);
        Locker lockerB = new Locker(12);
        Bag bagA = new Bag(BagType.M);

        PrimaryLockerRobot primaryLockerRobot = new PrimaryLockerRobot(Arrays.asList(lockerA, lockerB));
        Ticket ticketA = primaryLockerRobot.store(bagA);

        assertNotNull(ticketA);
        assertEquals(bagA, lockerA.getBag(ticketA));
    }

    @Test
    public void given_PrimaryLockerRobot_manage_LockerA_and_LockerB_only_LockerB_has_available_spaces_when_PrimaryLockerRobot_store_bagA_then_get_valid_ticketA_and_bagA_is_stored_in_LockerB() {
        Locker lockerA = new Locker(1);
        Locker lockerB = new Locker(12);
        lockerA.store(new Bag(BagType.M));
        Bag bagB = new Bag(BagType.M);

        PrimaryLockerRobot primaryLockerRobot = new PrimaryLockerRobot(Arrays.asList(lockerA, lockerB));
        Ticket ticketB = primaryLockerRobot.store(bagB);

        assertNotNull(ticketB);
        assertEquals(bagB, lockerB.getBag(ticketB));
    }

    @Test
    public void given_PrimaryLockerRobot_manage_LockerA_and_LockerB_both_lockers_have_no_available_space_when_PrimaryLockerRobot_store_bagA_then_get_error_message() throws NoAvailableSpaceException {
        Locker lockerA = new Locker(1);
        Locker lockerB = new Locker(1);
        lockerA.store(new Bag(BagType.M));
        lockerB.store(new Bag(BagType.M));
        Bag bagA = new Bag(BagType.M);

        PrimaryLockerRobot primaryLockerRobot = new PrimaryLockerRobot(Arrays.asList(lockerA, lockerB));

        expectedEx.expect(NoAvailableSpaceException.class);
        primaryLockerRobot.store(bagA);
    }

    @Test
    public void given_PrimaryLockerRobot_manages_LockerA_and_it_stored_bagA_and_ticketA_when_PrimaryLockerRobot_get_bag_with_ticketA_then_get_bagA() {
        Locker lockerA = new Locker(12);
        Bag bagA = new Bag(BagType.M);

        PrimaryLockerRobot primaryLockerRobot = new PrimaryLockerRobot(Arrays.asList(lockerA));
        Ticket ticketA = primaryLockerRobot.store(bagA);

        Bag bagFromLocker = primaryLockerRobot.getBag(ticketA);

        assertNotNull(bagFromLocker);
        assertEquals(bagA, bagFromLocker);
    }

    @Test
    public void given_PrimaryLockerRobot_manages_LockerA_and_it_stored_bagA_and_invalid_ticketA_when_PrimaryLockerRobot_get_bag_with_ticketA_then_get_error_message() throws InvalidTicketException {
        Locker lockerA = new Locker(12);
        Bag bagA = new Bag(BagType.M);
        Ticket invalidTicket = new Ticket();

        PrimaryLockerRobot primaryLockerRobot = new PrimaryLockerRobot(Arrays.asList(lockerA));
        primaryLockerRobot.store(bagA);

        expectedEx.expect(InvalidTicketException.class);
        primaryLockerRobot.getBag(invalidTicket);
    }

    @Test
    public void given_PrimaryLockerRobot_manages_lockerA_lockerB_and_lockerB_stored_a_bagB_with_ticketB_when_PrimaryLockerRobot_get_bag_with_ticketB_then_get_bagB() {
        Locker lockerA = new Locker(1);
        Locker lockerB = new Locker(12);
        Bag bagB = new Bag(BagType.M);
        Ticket ticketB = lockerB.store(bagB);
        PrimaryLockerRobot primaryLockerRobot = new PrimaryLockerRobot(Arrays.asList(lockerA, lockerB));

        Bag actualBag = primaryLockerRobot.getBag(ticketB);

        assertEquals(bagB, actualBag);
    }

    @Test
    public void given_PrimaryLockerRobot_manages_lockerA_lockerB_and_invalid_ticketA_when_PrimaryLockerRobot_get_bag_with_ticketA_then_get_error_message() throws InvalidTicketException {
        Locker lockerA = new Locker(1);
        Locker lockerB = new Locker(1);
        lockerA.store(new Bag(BagType.M));
        lockerB.store(new Bag(BagType.M));
        Ticket invalidTicket = new Ticket();

        PrimaryLockerRobot primaryLockerRobot = new PrimaryLockerRobot(Arrays.asList(lockerA, lockerB));

        expectedEx.expect(InvalidTicketException.class);
        primaryLockerRobot.getBag(invalidTicket);
    }
}
