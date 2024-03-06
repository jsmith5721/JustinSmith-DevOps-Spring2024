package edu.westga.comp4420.project_1_notes.view.codebehind;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.Node;
import javafx.stage.Stage;
import javafx.scene.control.Alert;
import java.io.IOException;
import edu.westga.comp4420.project_1_notes.Main;
import edu.westga.comp4420.project_1_notes.model.Note;
import edu.westga.comp4420.project_1_notes.viewmodel.NotesViewModel;

public class HomeWindow {
    @FXML private ResourceBundle resources;
    @FXML private URL location;
    @FXML private Button addNoteButton;
    @FXML private ListView<Note> recentNotesListView;
    @FXML private Button removeNoteButton;
    @FXML private ListView<String> topicsListView;
    private static final String NOTE_LAUNCH_ERROR = "Unable to change to the Note scene.";
    private NotesViewModel viewModel;

    @FXML
    void initialize() {
        assert this.addNoteButton != null : "fx:id=\"addNoteButton\" was not injected: check your FXML file 'HomeWindow.fxml'.";
        assert this.recentNotesListView != null : "fx:id=\"recentNotesListView\" was not injected: check your FXML file 'HomeWindow.fxml'.";
        assert this.removeNoteButton != null : "fx:id=\"removeNoteButton\" was not injected: check your FXML file 'HomeWindow.fxml'.";
        assert this.topicsListView != null : "fx:id=\"topicsListView\" was not injected: check your FXML file 'HomeWindow.fxml'.";
		
        this.viewModel = new NotesViewModel();
        this.bindToViewModel();
		this.setupListenerForAddNoteButton();
    }
    
    private void bindToViewModel() {
    	this.recentNotesListView.itemsProperty().bind(this.viewModel.getRecentNotesListProperty());
    	this.viewModel.getSelectedNoteProperty().bind(this.recentNotesListView.getSelectionModel().selectedItemProperty());
    	this.topicsListView.itemsProperty().bind(this.viewModel.getTopicsListProperty());
    	this.viewModel.getSelectedTopicProperty().bind(this.topicsListView.getSelectionModel().selectedItemProperty());
    }
	
	private void setupListenerForAddNoteButton() {
		this.addNoteButton.setOnAction(
			(event) -> {
				try {
					Note newNote = new Note();
					this.viewModel.addNote(newNote);
					//this.viewModel.setSelectedNoteProperty(newNote);
					FXMLLoader loader = new FXMLLoader();
					loader.setLocation(Main.class.getResource(Main.NOTE_DIALOG));
					loader.load();
					Parent parent = loader.getRoot();
					Scene scene = new Scene(parent);
					Stage noteStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
					noteStage.setTitle(Main.NOTE_TITLE);
					noteStage.setScene(scene);
					noteStage.show();
				} catch (IOException e) {
					Alert alertWindow = new Alert(Alert.AlertType.ERROR);
					alertWindow.setContentText(HomeWindow.NOTE_LAUNCH_ERROR);
					alertWindow.showAndWait();
				}
			}
		);
	}
	
}

