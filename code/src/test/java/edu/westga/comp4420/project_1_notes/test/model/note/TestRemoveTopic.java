package edu.westga.comp4420.project_1_notes.test.model.note;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import edu.westga.comp4420.project_1_notes.model.Note;

public class TestRemoveTopic {
	private String testTopic = "Test";
	private Note note;
	
	@BeforeEach
	private void setUpPerTest() {
		this.note = new Note();
		this.note.addTopic(this.testTopic);
	}
	
	@Test
	public void testTopicNotAssociatedToNote() {
		assertThrows(IllegalArgumentException.class, 
				()->{
					note.removeTopic("Not Test");	
				}
			);
	}
	
	@Test
	public void testValidTopicToRemove() {
		this.note.removeTopic("Test");
		
		assertFalse(this.note.isTopicAssociated(this.testTopic), "Tests that the Test topic is not associated with this note any more.");
	}
}