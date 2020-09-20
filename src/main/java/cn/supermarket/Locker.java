package cn.supermarket;

import cn.supermarket.exception.InvalidBagTypeException;
import cn.supermarket.exception.InvalidTicketException;
import cn.supermarket.exception.NoAvailableSpaceException;

import java.util.HashMap;


public class Locker {
    private HashMap<Ticket, Bag> bagMap = new HashMap<>();
    private Integer capacity;
    private BagType bagType;

    public Locker(int capacity, BagType bagType) {
        this.capacity = capacity;
        this.bagType = bagType;
    }

    public Ticket store(Bag bag) {
        if(bag.getType() != this.bagType){
            throw new InvalidBagTypeException();
        }
        if (this.getAvailableSpaceNumber() == 0) {
            throw new NoAvailableSpaceException();
        } else {
            Ticket ticket = new Ticket(bag.getType());
            bagMap.put(ticket, bag);
            return ticket;
        }
    }

    public Integer getAvailableSpaceNumber() {
        return this.capacity - bagMap.size();
    }

    public double getAvailableRatio() {
        return 1 - (bagMap.size() / this.capacity) * 1.0;

    }

    public Bag getBag(Ticket ticket) {
        if (bagMap.isEmpty()) {
            throw new InvalidTicketException();
        } else {
            if (bagMap.containsKey(ticket)) {
                return bagMap.remove(ticket);
            } else {
                throw new InvalidTicketException();
            }
        }
    }

    public boolean exist(Ticket ticket) {
        return bagMap.containsKey(ticket);
    }
}