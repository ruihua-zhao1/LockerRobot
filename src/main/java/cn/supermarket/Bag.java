package cn.supermarket;

public class Bag {
    private BagType type;

    public Bag(BagType type) {
        this.type = type;
    }

    public BagType getType() {
        return type;
    }
}
