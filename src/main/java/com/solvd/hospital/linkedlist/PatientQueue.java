package com.solvd.hospital.linkedlist;

import org.apache.log4j.Logger;

public class PatientQueue<E> {
    private static final Logger logger = Logger.getLogger(PatientQueue.class);

    class Node{
        public E info;
        Node next;
    }

    private Node origin;

    public PatientQueue(){ origin = null; }

    public void insert(E x){
        Node newbie =  new Node();
        newbie.info = x;
        if ( origin == null ){
            newbie.next = null;
            origin = newbie;
        } else {
            newbie.next = origin;
            origin = newbie;
        }
    }

    public int counter() {
        int count = 0;
        Node rec = origin;
        while ( rec != null ){
            rec = rec.next;
            count++;
        }
        logger.info(count);
        return count;
    }
    public void run() {
        PatientQueue.Node pos = origin;
        while (pos.next != null) {
            logger.info(pos.info.toString());
            pos = pos.next;
        }
        logger.info(pos.info.toString());
    }

}
