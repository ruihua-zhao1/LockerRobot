package cn.supermarket;

import cn.supermarket.exception.InvalidTicketException;
import cn.supermarket.exception.NoAvailableSpaceException;

import java.util.List;

public class LockerRobotManager {
    private List<Locker> managedLockers;
    private List<LockerRobot> managedLockerRobots;

    public LockerRobotManager(List<Locker> managedLockers, List<LockerRobot> managedLockerRobots) {
        this.managedLockers = managedLockers;
        this.managedLockerRobots = managedLockerRobots;
    }

    public Ticket store(Bag bag, boolean isVIP) {
        if (bag.getType() == BagType.S) {
            if (managedLockers != null && !managedLockers.isEmpty()) {
                for (Locker locker : managedLockers) {
                    if (locker.getAvailableSpaceNumber() > 0) {
                        return locker.store(bag);
                    }
                }
            }

            throw new NoAvailableSpaceException();
        }

        if (bag.getType() == BagType.M) {
            if (managedLockerRobots != null && !managedLockerRobots.isEmpty()) {
                for (LockerRobot lockerRobot : managedLockerRobots) {
                    if (lockerRobot.isAvailable()) {

                        return lockerRobot.store(bag);
                    }
                }
            }
            throw new NoAvailableSpaceException();
        }
        if (bag.getType() == BagType.L) {
            if (managedLockerRobots != null && !managedLockerRobots.isEmpty()) {
                for (LockerRobot lockerRobot : managedLockerRobots) {
                    if (lockerRobot.isAvailable()) {

                        return lockerRobot.store(bag);
                    }
                }
            }
            throw new NoAvailableSpaceException();
        }
        return null;
    }

    public Bag getBag(Ticket ticket) {
        if (ticket.getType() == BagType.S) {
            if (managedLockers != null && !managedLockers.isEmpty()) {
                for (Locker locker : managedLockers) {
                    if (locker.exist(ticket)) {
                        return locker.getBag(ticket);
                    }
                }
            }
        }

        if (ticket.getType() == BagType.M) {
            if (managedLockerRobots != null && !managedLockerRobots.isEmpty()) {
                for (LockerRobot lockerRobot : managedLockerRobots) {
                    if (lockerRobot.exist(ticket)) {
                        return lockerRobot.getBag(ticket);
                    }
                }
            }
        }
        if (ticket.getType() == BagType.L) {
            if (managedLockerRobots != null && !managedLockerRobots.isEmpty()) {
                for (LockerRobot lockerRobot : managedLockerRobots) {
                    if (lockerRobot.exist(ticket)) {
                        return lockerRobot.getBag(ticket);
                    }
                }
            }
            throw new NoAvailableSpaceException();
        }
        throw new InvalidTicketException();
    }
}
