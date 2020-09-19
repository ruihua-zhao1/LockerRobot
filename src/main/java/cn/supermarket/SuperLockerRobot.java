package cn.supermarket;

import java.util.List;

public class SuperLockerRobot extends LockerRobot {

    SuperLockerRobot(List<Locker> managedLockers) {
        super(managedLockers);
    }

    @Override
    public Locker getTargetLocker() {

        Locker maxCapacityRatioLocker = null;
        for (Locker locker : managedLockers) {
            if (maxCapacityRatioLocker == null) {
                maxCapacityRatioLocker = locker;
                continue;
            }
            if (maxCapacityRatioLocker.getAvailableRatio() < locker.getAvailableRatio()) {
                maxCapacityRatioLocker = locker;
            }
        }

        if (maxCapacityRatioLocker != null && maxCapacityRatioLocker.getAvailableSpaceNumber() > 0) {
            return maxCapacityRatioLocker;
        }
        return null;
    }
}
