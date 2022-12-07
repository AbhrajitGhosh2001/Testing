package sampleQueue;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.NoSuchElementException;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class QueueTest {

	/**
	 * Tests for Queue.
	 */

	private static final String SOME_ITEM = "some-content";
	private Queue<String> q;

	@Test
	@DisplayName("is instantiated with new Queue()")
	void isInstantiatedWithNew() {
		new Queue<>();
	}
	
	@Test
	@DisplayName("is instantiated with new Queue(size)")
	void isInstantiatedWithNewSize() {
		new Queue<>(10);
	}

	@Test
	@DisplayName("enqueue")
	void  ifEnqueueWorks(){
		this.q = new Queue<String>();
		q.enqueue(SOME_ITEM);
		assertFalse(q.isEmpty());
	}

	@Test
	@DisplayName("enqueuewithmax")
	void  ifEnqueuewithmaxWorks(){
		this.q = new Queue<String>(3);
		q.enqueue(SOME_ITEM);
		q.enqueue(SOME_ITEM);
		q.enqueue(SOME_ITEM);
		assertThrows(RuntimeException.class, () -> this.q.enqueue(SOME_ITEM));
	}

	@Test
	@DisplayName("dequeue")
	void  ifDequeueWorks(){
		int x=0;
		this.q = new Queue<String>();
		q.enqueue(SOME_ITEM);
		if(q.isEmpty()==false){
			x++;
			q.dequeue();
		}
		assertTrue(x==1&&q.isEmpty());
	}



	@Test
	@DisplayName("Dequeue should throw an Exception if called on empty queue")
	void dequeueThrowsExceptionOnEmpty(){
		assertThrows(NoSuchElementException.class, () -> this.q.dequeue());
	}

	@Test
	@DisplayName("peek")
	void  ifpeekWorks(){
		this.q = new Queue<String>();
		q.enqueue(SOME_ITEM);
		assertTrue(q.peek()==SOME_ITEM);
	}

	@Test
	@DisplayName("length")
	void  iflengthWorks(){
		this.q = new Queue<String>();
		q.enqueue(SOME_ITEM);
		q.enqueue(SOME_ITEM);
		q.enqueue(SOME_ITEM);
		q.enqueue(SOME_ITEM);
		assertTrue(q.length()==4);
	}

	@Test
	@DisplayName("RemoveAllWorks")
	void  ifRemoveAllWorks(){
		int x=0;
		this.q = new Queue<String>();
		q.enqueue(SOME_ITEM);
		q.enqueue(SOME_ITEM);
		q.enqueue(SOME_ITEM);
		q.enqueue(SOME_ITEM);
		if(q.length()==4){
			x++;
			q.removeAll();
		}
		assertTrue(x==1&&q.isEmpty());
	}

	@Test
	@DisplayName("Verify Queue isEmpty returns false when queue is not empty")
	void isEmptyWorks() {
		assertTrue(q.isEmpty());
	}




	@BeforeEach
	@Disabled
	void init() {
		this.q = new Queue<String>();
	}

	@Test
	@DisplayName("Verify Queue isEmpty when queue is initialized")
	void isEmptyShouldGiveTrueOnQueueInit() {
		assertTrue(q.isEmpty());
	}

	@Test
	@DisplayName("Peek should throw an Exception if called on empty queue")
	void peekThrowsExceptionOnEmpty(){
		assertThrows(NoSuchElementException.class, () -> this.q.peek());
	}

	//Example of Wrong Test! 
	@Test
	@DisplayName("Verify Queue isEmpty returns false when queue is not empty")
	void isEmptyShouldGiveFalseWhenQueueIsNotEmpty() {
		this.q.enqueue(SOME_ITEM);
		assertFalse(q.isEmpty());
	}

	
	
}