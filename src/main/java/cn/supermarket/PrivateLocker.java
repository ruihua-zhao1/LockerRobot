package cn.supermarket;

class PrivateLocker extends Locker {
    BagType bagType;

    public PrivateLocker(int capacity, BagType bagType) {
        super(capacity, bagType);
        this.bagType = bagType;
    }
}
