package cn.supermarket;

import org.junit.Assert;
import org.junit.Test;

public class FrontDeskTest {
    @Test
    public void given_locker_has_available_spaces_when_frontdesk_stores_S_bag__then_could_store_success() {
        Bag bagA = new Bag(BagType.S);
        Locker lockerA = new Locker(10);
        Ticket ticket = lockerA.store(bagA);

        Bag bagFromLocker = lockerA.getBag(ticket);

        Assert.assertEquals(bagA, bagFromLocker);
    }
}
