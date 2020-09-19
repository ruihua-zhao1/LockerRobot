package cn.supermarket;

import cn.supermarket.exception.InvalidTicketException;
import cn.supermarket.exception.NoAvailableSpaceException;

import java.util.HashMap;


public class Locker {
    private HashMap<Ticket, Bag> bagMap = new HashMap<>();
    private Integer capacity;

    public Locker(int capacity) {
        this.capacity = capacity;
    }

    public Ticket store(Bag bag) {
        if (this.getAvailableSpaceNumber() == 0) {
            throw new NoAvailableSpaceException();
        } else {
            Ticket ticket = new Ticket();
            bagMap.put(ticket, bag);
            return ticket;
        }
    }

    public Integer getAvailableSpaceNumber() {
        return this.capacity - bagMap.size();

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