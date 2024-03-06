package edu.westga.comp4420.project_1_notes.test.model.note;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import edu.westga.comp4420.project_1_notes.model.Note;

public class TestAddTopic {
	private String testTopic = "Test";
	private Note note;
	
	@BeforeEach
	private void setUpPerTest() {
		note = new Note(); 
	}
	
	@Test
	public void testValidTopic() {
		note.addTopic(this.testTopic);
		
		assertTrue(note.isTopicAssociated(this.testTopic), "Checking that the Test was added to the topics.");
	}
	
	@Test
	public void testTopicAlreadyAssociated() {
		note.addTopic(this.testTopic);
		
		assertThrows(IllegalArgumentException.class, 
			()->{
				note.addTopic(this.testTopic);	
			}
		);
	}
}