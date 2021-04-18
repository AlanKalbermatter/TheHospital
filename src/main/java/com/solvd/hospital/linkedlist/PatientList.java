package com.solvd.hospital.linkedlist;

public class PatientList <E> {
    class Node{
        public E info;
        Node next;
    }

    private Node origin;

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

    public E extract() {
        if ( origin != null){
            E info = origin.info;
            origin = origin.next;
            return info;
        } else {
            return null;
        }
    }
    public int counter() {
        int count = 0;
        Node rec = origin;
        while ( rec != null ){
            rec = rec.next;
            count++;
        }
        return count;
    }

}
