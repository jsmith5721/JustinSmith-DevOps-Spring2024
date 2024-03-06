package edu.westga.comp4420.project_1_notes.model;

import java.util.List;
import java.util.ArrayList;

public class Note {
	private String noteText;
	private List<String> topics;
	private static final String TOPIC_ALREADY_USED = "This topic is already associated to this note";
	private static final String TOPIC_NOT_FOUND = "That topic is not associated to this note.";
	
	/*
	 * Creates a new Note object and initializes the noteText to be a blank string and the topics list to an ArrayList
	 */
	public Note() {
		this.noteText = "";
		this.topics = new ArrayList<String>();
	}
	
	/*
	 * Returns the note's text.
	 */
	public String getNoteText() {
		return this.noteText;
	}
	
	/*
	 * Returns the list of topics that have been added to the note.
	 */
	public List<String> getTopics() {
		return this.topics;
	}
	
	/*
	 * Sets the noteText to the text provided.
	 * 
	 * @param text       the text to be added to the note.
	 */
	public void setNoteText(String text) {
		this.noteText = text;
	}
	
	/*
	 * Returns true if the topic was already added to this note and false if the topic has not been added to this note
	 */
	public boolean isTopicAssociated(String topic) {
		return this.topics.contains(topic);
	}
	
	/*
	 * Adds a topic to the list of topics associated to this note.
	 * 
	 * @param topic     the topic to be added to the note.
	 * @precondition    this.isTopicAssociated(topic) == false
	 * @postcondition   this.isTopicAssociated(topic) == true
	 */
	public void addTopic(String topic) {
		if (this.isTopicAssociated(topic)) {
			throw new IllegalArgumentException(Note.TOPIC_ALREADY_USED);
		}
		this.topics.add(topic);
	}
	
	/*
	 * Removes a topic from this note.
	 * 
	 * @param topic     the topic to remove.
	 * @precondition    this.isTopicAssociated(topic) == true
	 * @precondition    this.isTopicAssociated(topic) == false
	 */
	public void removeTopic(String topic) {
		if (!this.isTopicAssociated(topic)) {
			throw new IllegalArgumentException(Note.TOPIC_NOT_FOUND);
		}
		this.topics.remove(topic);
	}
}