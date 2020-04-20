package controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class MenuController implements Initializable {
	@FXML
	private Button next;
	@FXML
	private RadioButton Cruise_RadioButton;
	@FXML
	private RadioButton City_RadioButton;
	@FXML
	private AnchorPane rootPane;
	@FXML
	private RadioButton Camping_RadioButton;
	@FXML
	private RadioButton Beach_RadioButton;
	@FXML
	private RadioButton Snow_RadioButton;
	@FXML
	private ToggleGroup VacationSelection;

	@FXML
	public void nextButtonPressed(ActionEvent event) throws IOException {
		String path = VacationSelection.getSelectedToggle().getUserData().toString();
		System.out.println(path);
		Parent scene2 = FXMLLoader.load(getClass().getResource("/view/" + path + "Scroll.fxml"));
		//Parent scene2 =FXMLLoader.load(getClass().getResource("/view/CruiseScroll.fxml"));
		Scene scene2Scene = new Scene(scene2);
		Stage scene2Window = (Stage) ((Node) event.getSource()).getScene().getWindow();
		scene2Window.setScene(scene2Scene);
		scene2Window.show();
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub

	}

}