package edu.westga.comp4420.project_1_notes.view.codebehind;


import java.net.URL;
import java.util.ResourceBundle;

//import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import java.io.IOException;
import edu.westga.comp4420.project_1_notes.Main;
import edu.westga.comp4420.project_1_notes.viewmodel.NotesViewModel;


public class NoteWindow {
    @FXML private ResourceBundle resources;
    @FXML private URL location;
    @FXML private Button addTopicButton;
    @FXML private TextArea noteTextArea;
    @FXML private Button removeTopicButton;
    @FXML private Button returnButton;
    @FXML private ListView<String> noteTopicsListView;
    private static final String HOME_LAUNCH_ERROR = "Unable to change to the Home scene.";
    private NotesViewModel viewModel;
	

    @FXML
    void initialize() {
        assert this.addTopicButton != null : "fx:id=\"addTopicButton\" was not injected: check your FXML file 'NoteWindow.fxml'.";
        assert this.noteTextArea != null : "fx:id=\"noteTextArea\" was not injected: check your FXML file 'NoteWindow.fxml'.";
        assert this.removeTopicButton != null : "fx:id=\"removeTopicButton\" was not injected: check your FXML file 'NoteWindow.fxml'.";
        assert this.returnButton != null : "fx:id=\"returnButton\" was not injected: check your FXML file 'NoteWindow.fxml'.";
        assert this.noteTopicsListView != null : "fx:id=\"topicsListView\" was not injected: check your FXML file 'NoteWindow.fxml'.";
		
        this.viewModel = new NotesViewModel();
        //this.viewModel.setupNoteTopicsListProperty();
        this.bindToViewModel();
        //this.noteTextArea.setText(this.viewModel.getSelectedNoteProperty().getValue().getNoteText());
        //this.noteTopicsListView.setItems(FXCollections.observableArrayList(this.viewModel.getSelectedNoteProperty().getValue().getTopics()));
		this.setupListenerForReturnButton();
    }
    
    private void bindToViewModel() {
    	this.noteTextArea.textProperty().bindBidirectional(this.viewModel.getNoteTextProperty());
    	//this.noteTopicsListView.itemsProperty().bind(this.viewModel.getNoteTopicsListProperty());
    	//this.viewModel.getSelectedNoteTopicProperty().bind(this.noteTopicsListView.getSelectionModel().selectedItemProperty());
    }
    
	private void setupListenerForReturnButton() {
		this.returnButton.setOnAction(
			(event) -> {
				try {
					FXMLLoader loader = new FXMLLoader();
					loader.setLocation(Main.class.getResource(Main.GUI_RESOURCE));
					loader.load();
					Parent parent = loader.getRoot();
					Scene scene = new Scene(parent);
					Stage noteStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
					noteStage.setTitle(Main.WINDOW_TITLE);
					noteStage.setScene(scene);
					noteStage.initModality(Modality.APPLICATION_MODAL);
					noteStage.show();
				} catch (IOException e) {
					Alert alertWindow = new Alert(Alert.AlertType.ERROR);
					alertWindow.setContentText(NoteWindow.HOME_LAUNCH_ERROR);
					alertWindow.showAndWait();
				}
			}
		);
	}

}
