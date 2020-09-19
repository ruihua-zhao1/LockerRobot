package cn.supermarket;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class FrontDeskTest {
    @Test
    public void given_locker_has_available_spaces_when_frontdesk_stores_S_bag__then_could_store_success() {
        Bag bagA = new Bag(BagType.S);
        Locker lockerA = new Locker(10);
        Ticket ticket = lockerA.store(bagA);

        Bag bagFromLocker = lockerA.getBag(ticket);

        Assert.assertEquals(bagA, bagFromLocker);
    }

    @Test
    public void given_XiaoYing_manages_LockerA_PrimaryLockerRobot_with_available_LockerP_and_SuperLockerRobot_with_available_LockerS_when_stores_M_bag_then_could_store_success() {
        Bag bagA = new Bag(BagType.M);
        Locker lockerA = new Locker(10);
        Locker lockerB = new Locker(10);
        PrimaryLockerRobot primaryLockerRobot = new PrimaryLockerRobot(Arrays.asList(lockerB));
        SuperLockerRobotTest SuperLockerRobot = new SuperLockerRobotTest();

        Ticket ticket = primaryLockerRobot.store(bagA);

        Bag bagFromLocker = primaryLockerRobot.getBag(ticket);
        Assert.assertEquals(bagA, bagFromLocker);
    }

    @Test
    public void given_XiaoYing_manages_LockerA_PrimaryLockerRobot_with_available_LockerP_and_SuperLockerRobot_with_available_LockerS_when_stores_L_bag_then_could_store_success() {
        Bag bagA = new Bag(BagType.L);
        Locker lockerB = new Locker(10);
        SuperLockerRobot superLockerRobot = new SuperLockerRobot(Arrays.asList(lockerB));

        Ticket ticket = superLockerRobot.store(bagA);

        Bag bagFromLocker = superLockerRobot.getBag(ticket);
        Assert.assertEquals(bagA, bagFromLocker);
    }


    @Test
    public void given_XiaoYing_manages_full_Super_when_stores_S_bag_then_store_failed_and_got_no_space_error() {
        Bag bagA = new Bag(BagType.S);
        Locker lockerA = new Locker(10);
        SuperLockerRobot superLockerRobot = new SuperLockerRobot(Arrays.asList(lockerA));

        Ticket ticket = superLockerRobot.store(bagA);

        Bag bagFromLocker = superLockerRobot.getBag(ticket);
        Assert.assertEquals(bagA, bagFromLocker);
    }
}
