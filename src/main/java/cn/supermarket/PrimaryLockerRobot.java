package cn.supermarket;

import cn.supermarket.exception.InvalidBagTypeException;
import cn.supermarket.exception.InvalidTicketException;
import cn.supermarket.exception.NoAvailableSpaceException;

import java.util.HashMap;
import java.util.List;

public class PrimaryLockerRobot extends LockerRobot {

    private HashMap<Ticket, Bag> bagMap = new HashMap<>();
    private Integer capacity;

    public PrimaryLockerRobot(List<Locker> managedLockers) {
        super(managedLockers);
    }

    @Override
    public Locker getTargetLocker() {
        for (Locker locker : managedLockers) {
            if (locker.getAvailableSpaceNumber() > 0) {
                return locker;
            }
        }
        return null;
    }

    @Override
    void verifyBag(Bag bag) {
        if(bag.getType() != BagType.M ) {
            throw new InvalidBagTypeException();
        }
    }
}
