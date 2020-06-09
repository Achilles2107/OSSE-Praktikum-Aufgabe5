package de.hfu;

import org.junit.Test;

import static org.junit.Assert.*;
import de.hfu.Queue.*;

public class QueueTest {

    /**
     * Function and Methods Testing
     */

    /**
     * Test for correct inserting into the Queue
     */
    @Test
    public void enqueueTest() {

        Queue q = new Queue(3);

        for(int i = 0; i < 3; ++i ){
            q.enqueue(i);
        }

        for(int i = 0; i < 3; ++i ){
            assertEquals(i, q.dequeue());
        }

    }

    /**
     * Exception Testing
     */

    /**
     * Test for correct Queue Length
     */

    @Test(expected = IllegalArgumentException.class)
    public void invalidQueueLength(){
        Queue q1 = new Queue(-1);
        q1 = new Queue(0);
    }

    /**
     * Test for empty Queue
     */

    @Test(expected = IllegalStateException.class)
    public void emptyQueue(){
        Queue q1 = new Queue(3);

        for(int i = 0; i < 3; ++i){
            q1.enqueue(i);
        }

        for(int i = 0; i < 5; ++i){
            assertEquals(i, q1.dequeue());
        }

    }
}