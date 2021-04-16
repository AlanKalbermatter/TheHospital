package linkedlist;

import org.apache.log4j.Logger;

public class MedicineContainer {
    private static final Logger logger = Logger.getLogger(MedicineContainer.class);

    class Node{
        int info;
        Node prev, next;
    }

    private Node origin;

    public MedicineContainer(){
        origin = null;
    }

    public int quantity() {
        int count = 0;
        Node rec = origin;
        while (rec != null) {
            rec = rec.next;
            count++;
        }
        return count;
    }

    public void insert( int position, int x ) {
        if ( position <= quantity() + 1 ) {
            Node newbie = new Node();
            newbie.info = x;
            if ( position == 1 ){
                newbie.next = origin;
                if ( origin != null )
                    origin.prev = newbie;
                origin = newbie;
            } else if ( position == quantity() + 1 ){
                Node rec = origin;
                while ( rec.next != null ) {
                    rec = rec.next;
                }
                rec.next = newbie;
                newbie.prev = rec;
                newbie.next = null;
            } else {
                Node rec = origin;
                for ( int i = 1 ; i <= position - 2; i++ ) {
                    rec = rec.next;
                }
                Node next = rec.next;
                rec.next = newbie;
                newbie.prev = rec;
                newbie.next = next;
                next.prev = newbie;
            }
        }
    }

    public int extract ( int position ) {
        if ( position <= quantity() ) {
            int info;
            if ( position == 1 ) {
                info = origin.info;
                origin = origin.next;
                if ( origin != null )
                    origin.prev = null;
            } else {
                Node rec;
                rec = origin;
                for (int i = 1 ; i <= position - 2 ; i++)
                    rec = rec.next;
                Node prox = rec.next;
                rec.next = prox.next;
                Node next = prox.next;
                if ( next != null )
                    next.prev = rec;
                info = prox.info;
            }
            return info;
        }
        else
            return Integer.MAX_VALUE;
    }

    public void delete ( int position ){
        if (position <= quantity() ) {
            if ( position == 1 ) {
                origin = origin.next;
                if ( origin != null )
                    origin.prev = null;
            } else {
                Node rec;
                rec = origin;
                for ( int i = 1 ; i <= position - 2 ; i++ )
                    rec = rec.next;
                Node prox = rec.next;
                prox = prox.next;
                rec.next = prox;
                if ( prox != null )
                    prox.prev = rec;
            }
        }
    }
    public void swap ( int pos1, int pos2 ) {
        if ( pos1 <= quantity() && pos2 <= quantity() ) {
            Node rec1 = origin;
            for ( int i = 1 ; i < pos1 ; i++ )
                rec1 = rec1.next;
            Node rec2 = origin;
            for ( int f = 1 ; f < pos2 ; f++ )
                rec2 = rec2.next;
            int aux = rec1.info;
            rec1.info = rec2.info;
            rec2.info = aux;
        }
    }

    public void run() {
        Node pos = origin;
        while (pos.next != null) {
            logger.info(pos.info);
            pos = pos.next;
        }
        logger.info(pos.info);
    }

    public void reverseRun() {
        Node pos = origin;
        while ( pos.next != null ) {
            pos = pos.next;
        }
        while( pos != origin ) {
            logger.info(pos.info);
            pos = pos.prev;
        }
        logger.info(pos.info);
    }
}
