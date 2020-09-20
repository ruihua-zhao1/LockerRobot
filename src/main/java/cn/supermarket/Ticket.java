package cn.supermarket;

public class Ticket {
    private BagType type;

    public BagType getType() {
        return type;
    }

    public Ticket(BagType type) {
        this.type = type;
    }
}
