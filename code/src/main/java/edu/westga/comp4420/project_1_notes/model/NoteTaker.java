package edu.westga.comp4420.project_1_notes.model;

import java.util.ArrayList;
import java.util.List;

public class NoteTaker {
	private List<Note> notes;
	private List<String> topics;
	private static final String NOTE_NOT_FOUND = "The selected note was not found.";
	
	public NoteTaker() {
		this.notes = new ArrayList<Note>();
		this.topics = new ArrayList<String>();
	}
	
	public List<Note> getNotes() {
		return this.notes;
	}
	
	public List<String> getTopics() {
		return this.topics;
	}
	
	public void addNote(Note note) {
		this.notes.add(note);
	}
	
	public void removeNote(Note note) {
		if (!this.notes.contains(note)) {
			throw new IllegalArgumentException(NoteTaker.NOTE_NOT_FOUND);
		}
		this.notes.remove(note);
	}
	
	/*
	public Note getNote(String text) {
		for(Note note : this.notes) {
			if (note.getNoteText().equals(text)) {
				return note;
			}
		}
		return null;
	}
	*/
}