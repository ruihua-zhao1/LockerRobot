package cn.supermarket;

import java.util.List;

public class SuperLockerRobot extends LockerRobot {

    SuperLockerRobot(List<Locker> managedLockers) {
        super(managedLockers);
    }

    @Override
    public Locker getTargetLocker() {

        Locker maxCapacityLocaker = null;
        for (Locker locker : managedLockers) {
            if (maxCapacityLocaker == null) {
                maxCapacityLocaker = locker;
                continue;
            }
            if (maxCapacityLocaker.getAvailableSpaceNumber() < locker.getAvailableSpaceNumber()) {
                maxCapacityLocaker = locker;
            }
        }

        if (maxCapacityLocaker != null && maxCapacityLocaker.getAvailableSpaceNumber() > 0) {
            return maxCapacityLocaker;
        }
        return null;
    }
}
