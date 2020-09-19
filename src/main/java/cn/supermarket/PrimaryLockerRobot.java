package cn.supermarket;

import cn.supermarket.exception.InvalidTicketException;
import cn.supermarket.exception.NoAvailableSpaceException;

import java.util.HashMap;
import java.util.List;

public class PrimaryLockerRobot {
    List<Locker> managedLockers;

    private HashMap<Ticket, Bag> bagMap = new HashMap<>();
    private Integer capacity;

    public PrimaryLockerRobot(List<Locker> managedLockers) {
        this.managedLockers = managedLockers;
    }

    public Ticket store(Bag bagA) {
        for (Locker locker : managedLockers) {
            if (locker.getAvailableSpaceNumber() > 0) {
                return locker.store(bagA);
            }
        }

        throw new NoAvailableSpaceException();
    }

    public Bag getBag(Ticket ticket) {
        for (Locker locker : managedLockers) {
            if (locker.exist(ticket)) {
                return locker.getBag(ticket);
            }
        }
        throw new InvalidTicketException();
    }

    public boolean isAvailable() {
        if (managedLockers != null) {
            for (Locker locker : managedLockers) {
                if (locker.getAvailableSpaceNumber() > 0) {
                    return true;
                }
            }
        }
        return false;
    }
}
