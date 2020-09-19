package cn.supermarket;

import cn.supermarket.exception.InvalidTicketException;
import cn.supermarket.exception.NoAvailableSpaceException;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.Arrays;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class SuperLockerRobotTest {

    @Rule
    public ExpectedException expectedEx = ExpectedException.none();

    @Test
    public void given_superLockerRobot_managed_lockerA_with_one_available_space_when_store_bagA_then_store_successfully() {
        Locker lockerA = new PrivateLocker(1, BagType.L);
        Bag bagA = new Bag(BagType.L);

        SuperLockerRobot superLockerRobot = new SuperLockerRobot(Arrays.asList(lockerA));

        Ticket ticketA = superLockerRobot.store(bagA);
        assertNotNull(ticketA);
    }

    @Test
    public void given_superLockerRobot_managed_lockerA_with_no_available_space_when_store_bagA_then_store_failed() throws NoAvailableSpaceException {
        Locker lockerA = new PrivateLocker(1, BagType.L);
        lockerA.store(new Bag(BagType.L));

        Bag bagA = new Bag(BagType.L);
        SuperLockerRobot superLockerRobot = new SuperLockerRobot(Arrays.asList(lockerA));

        expectedEx.expect(NoAvailableSpaceException.class);
        superLockerRobot.store(bagA);
    }

    @Test
    public void given_superLockerRobot_managed_lockerA_lockerB_and_lockerA_has_more_available_capacity_rate_when_store_bagA_then_bagA_is_stored_in_lockerA() {
        Locker lockerA = new PrivateLocker(2, BagType.L);
        Locker lockerB = new PrivateLocker(1, BagType.L);
        Bag bagA = new Bag(BagType.L);
        SuperLockerRobot superLockerRobot = new SuperLockerRobot(Arrays.asList(lockerA, lockerB));

        Ticket ticketA = superLockerRobot.store(bagA);

        assertNotNull(ticketA);
        assertEquals(bagA, lockerA.getBag(ticketA));
    }


    @Test
    public void given_superLockerRobot_managed_lockerA_lockerB_and_both_have_same_available_space_when_store_bagA_then_bagA_is_stored_by_locker_order() {
        Locker lockerA = new PrivateLocker(2, BagType.L);
        Locker lockerB = new PrivateLocker(2, BagType.L);
        Bag bagA = new Bag(BagType.L);
        SuperLockerRobot superLockerRobot = new SuperLockerRobot(Arrays.asList(lockerA, lockerB));

        Ticket ticketA = superLockerRobot.store(bagA);

        assertNotNull(ticketA);
        assertEquals(bagA, lockerA.getBag(ticketA));
    }

    @Test
    public void given_superLockerRobot_managed_lockerA_lockerB_and_lockerB_has_more_available_capacity_ratio_when_store_bagA_then_bagA_is_stored_by_available_capacity_ratio_order() {
        Locker lockerA = new PrivateLocker(2, BagType.L);
        lockerA.store(new Bag(BagType.L));
        Locker lockerB = new PrivateLocker(5, BagType.L);
        lockerB.store(new Bag(BagType.L));
        lockerB.store(new Bag(BagType.L));
        Bag bagA = new Bag(BagType.L);
        SuperLockerRobot superLockerRobot = new SuperLockerRobot(Arrays.asList(lockerA, lockerB));

        Ticket ticketA = superLockerRobot.store(bagA);

        assertNotNull(ticketA);
        assertEquals(bagA, lockerA.getBag(ticketA));
    }

    @Test
    public void given_superLockerRobot_managed_lockerA_lockerB_and_both_have_no_available_space_when_store_bagA_then_store_failed() throws NoAvailableSpaceException {
        Locker lockerA = new PrivateLocker(1, BagType.L);
        Locker lockerB = new PrivateLocker(1, BagType.L);
        lockerA.store(new Bag(BagType.L));
        lockerB.store(new Bag(BagType.L));
        Bag bagA = new Bag(BagType.L);
        SuperLockerRobot superLockerRobot = new SuperLockerRobot(Arrays.asList(lockerA, lockerB));

        expectedEx.expect(NoAvailableSpaceException.class);
        superLockerRobot.store(bagA);
    }

    @Test
    public void given_superLockerRobot_managed_lockerA_and_it_stored_bagA_when_get_bag_then_get_bagA() {
        Locker lockerA = new PrivateLocker(1, BagType.L);
        Bag bagA = new Bag(BagType.L);
        SuperLockerRobot superLockerRobot = new SuperLockerRobot(Arrays.asList(lockerA));

        Ticket ticketA = superLockerRobot.store(bagA);

        Bag bagFromSLRobot = superLockerRobot.getBag(ticketA);
        assertEquals(bagA, bagFromSLRobot);
    }

    @Test
    public void given_SuperLockerRobot_managed_LockerA_and_it_stored_bagA_when_get_bag_with_fake_ticket_then_get_error_message() throws InvalidTicketException {
        Locker lockerA = new PrivateLocker(12, BagType.L);
        Bag bagA = new Bag(BagType.L);
        Ticket invalidTicket = new Ticket();
        SuperLockerRobot superLockerRobot = new SuperLockerRobot(Arrays.asList(lockerA));

        superLockerRobot.store(bagA);

        expectedEx.expect(InvalidTicketException.class);
        superLockerRobot.getBag(invalidTicket);
    }

    @Test
    public void given_superLockerRobot_managed_lockerA_lockerB_and_it_stored_bagA_when_get_bag_then_get_bagA() {
        Locker lockerA = new PrivateLocker(1, BagType.L);
        Locker lockerB = new PrivateLocker(2, BagType.L);
        Bag bagB = new Bag(BagType.L);
        SuperLockerRobot superLockerRobot = new SuperLockerRobot(Arrays.asList(lockerA, lockerB));

        Ticket ticketB = superLockerRobot.store(bagB);

        Bag bagFromSLRobot = superLockerRobot.getBag(ticketB);
        assertEquals(bagB, bagFromSLRobot);
    }

    @Test
    public void given_SuperLockerRobot_managed_LockerA_lockerB_when_get_bag_with_fake_ticket_then_get_error_message() throws InvalidTicketException {
        Locker lockerA = new Locker(12);
        Locker lockerB = new Locker(12);
        Bag bagA = new Bag(BagType.L);
        Ticket invalidTicket = new Ticket();
        SuperLockerRobot superLockerRobot = new SuperLockerRobot(Arrays.asList(lockerA, lockerB));

        superLockerRobot.store(bagA);

        expectedEx.expect(InvalidTicketException.class);
        superLockerRobot.getBag(invalidTicket);
    }
}
