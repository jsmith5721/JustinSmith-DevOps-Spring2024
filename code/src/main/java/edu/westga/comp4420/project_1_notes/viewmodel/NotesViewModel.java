package edu.westga.comp4420.project_1_notes.viewmodel;

import edu.westga.comp4420.project_1_notes.model.Note;
import edu.westga.comp4420.project_1_notes.model.NoteTaker;
import javafx.beans.property.ListProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;

public class NotesViewModel {
	private ListProperty<Note> recentNotesListProperty;
	private ObjectProperty<Note> selectedNoteProperty;
	private ListProperty<String> topicsListProperty;
	private ObjectProperty<String> selectedTopicProperty;
	private ListProperty<String> noteTopicsListProperty;
	private ObjectProperty<String> selectedNoteTopicProperty;
	private StringProperty noteTextProperty;
	private NoteTaker noteTaker;
	
	public NotesViewModel() {
		this.noteTaker = new NoteTaker();
		this.noteTextProperty = new SimpleStringProperty();
		this.recentNotesListProperty = new SimpleListProperty<Note>(FXCollections.observableArrayList(this.noteTaker.getNotes()));
		this.selectedNoteProperty = new SimpleObjectProperty<Note>();
		this.topicsListProperty = new SimpleListProperty<String>(FXCollections.observableArrayList(this.noteTaker.getTopics()));
		this.selectedTopicProperty = new SimpleObjectProperty<String>();
		this.selectedNoteTopicProperty = new SimpleObjectProperty<String>();
	}
	
	public void setupNoteTopicsListProperty() {
		this.noteTopicsListProperty = new SimpleListProperty<String>(FXCollections.observableArrayList(this.selectedNoteProperty.getValue().getTopics()));
	}
	
	public ListProperty<Note> getRecentNotesListProperty() {
		return this.recentNotesListProperty;
	}
	
	public ObjectProperty<Note> getSelectedNoteProperty() {
		return this.selectedNoteProperty;
	}
	
	public ListProperty<String> getTopicsListProperty() {
		return this.topicsListProperty;
	}
	
	public ObjectProperty<String> getSelectedTopicProperty() {
		return this.selectedTopicProperty;
	}
	
	public ListProperty<String> getNoteTopicsListProperty() {
		return this.noteTopicsListProperty;
	}
	
	public ObjectProperty<String> getSelectedNoteTopicProperty() {
		return this.selectedNoteTopicProperty;
	}
	
	public StringProperty getNoteTextProperty() {
		return this.noteTextProperty;
	}
	
	public void setSelectedNoteProperty(Note note) {
		this.selectedNoteProperty.setValue(note);
	}
	
	public void addNote(Note note) {
		this.noteTaker.addNote(note);
	}
}