package controller;

import java.io.IOException;
import java.math.BigDecimal;
import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ResourceBundle;

import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DateCell;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import javafx.util.Callback;
import model.Hotel;
import model.Vacation;

public class TemplateController implements Initializable {
	@FXML
	private Label title;

	@FXML
	private DatePicker ReturnDate;
	@FXML
	private DatePicker DepartureDate;

	@FXML
	private ComboBox<Vacation> VacationDestCB;
	@FXML
	private ComboBox<Hotel> HotelCB;
	@FXML
	private ComboBox<String> HomeCityCB;

	@FXML
	private CheckBox op1CBx;
	@FXML
	private CheckBox op2CBx;
	@FXML
	private CheckBox op3CBx;
	@FXML
	private CheckBox op4CBx;
	@FXML
	private CheckBox op5CBx;
	@FXML
	private CheckBox op6CBx;
	@FXML
	private CheckBox op7CBx;
	@FXML
	private CheckBox op8CBx;
	@FXML
	private CheckBox op9CBx;
	@FXML
	private CheckBox op10CBx;

	@FXML
	private Button ExitButton;
	@FXML
	private Button FinalizeButton;

	@FXML
	private TextArea hotelTextArea;
	@FXML
	private TextArea Itinerary;
	@FXML
	private TextArea Bill;

	@FXML
	private ImageView imageView;

	@FXML
	private Text SumofActivities;
	@FXML
	private Text vacationDestError;
	@FXML
	private Text dateOOBerror;
	@FXML
	private Text hotelError;

	// closes app when pressed
	@FXML
	public void lastButtonPressed(ActionEvent event) throws IOException {
		Platform.exit();
	}

	// loads hotel options and all required information
	@FXML
	void hotelChoiceMade(ActionEvent event) {
		// gets user choice for hotel
		Hotel selectedHotel = HotelCB.getSelectionModel().getSelectedItem();
		// loads info of hotel from user choice
		switch (HotelCB.getSelectionModel().getSelectedIndex()) {
		case 0:
			hotelName = selectedHotel.getHotelName();
			hotelCost = selectedHotel.getHotelPrice();
			hotelTextArea.setText(selectedHotel.getHotelInfo());
			Image x0 = (new Image(
					getClass().getResourceAsStream("/pictures/" + selectedHotel.getHotelImage() + ".jpg")));
			imageView.setImage(x0);
			break;

		case 1:
			hotelName = selectedHotel.getHotelName();
			hotelCost = selectedHotel.getHotelPrice();
			hotelTextArea.setText(selectedHotel.getHotelInfo());
			Image x1 = (new Image(
					getClass().getResourceAsStream("/pictures/" + selectedHotel.getHotelImage() + ".jpg")));
			imageView.setImage(x1);
			break;

		case 2:
			hotelName = selectedHotel.getHotelName();
			hotelCost = selectedHotel.getHotelPrice();
			hotelTextArea.setText(selectedHotel.getHotelInfo());
			Image x2 = (new Image(
					getClass().getResourceAsStream("/pictures/" + selectedHotel.getHotelImage() + ".jpg")));
			imageView.setImage(x2);
			break;

		case 3:
			hotelName = selectedHotel.getHotelName();
			hotelCost = selectedHotel.getHotelPrice();
			hotelTextArea.setText(selectedHotel.getHotelInfo());
			Image x3 = (new Image(
					getClass().getResourceAsStream("/pictures/" + selectedHotel.getHotelImage() + ".jpg")));
			imageView.setImage(x3);
			break;

		case 4:
			hotelName = selectedHotel.getHotelName();
			hotelCost = selectedHotel.getHotelPrice();
			hotelTextArea.setText(selectedHotel.getHotelInfo());
			Image x4 = (new Image(
					getClass().getResourceAsStream("/pictures/" + selectedHotel.getHotelImage() + ".jpg")));
			imageView.setImage(x4);
			break;
		}
	}

	// gets user choice for vacation destination
	@FXML
	void vacationDestMade(ActionEvent event) {
		// clears hotel options so each vacation has there own
		HotelCB.getItems().removeAll(HotelCB.getItems());
		// clears hotels information from text box
		hotelTextArea.clear();
		// function call to disable all images
		imageView.setImage(x);
		// gets user choice for vacation destination
		Vacation selectedVacation = VacationDestCB.getSelectionModel().getSelectedItem();
		// once user picks destination then these hotel options will be loaded
		// to hotel ComboBox
		switch (VacationDestCB.getSelectionModel().getSelectedIndex()) {
		case 0:
			vacationSpot = selectedVacation.getVacName();
			flightCost = selectedVacation.getFlightPrice();
			HotelCB.setItems(FXCollections.observableArrayList(
					new Hotel("Option 1a", 100.12, "haha\ni need to put hotel 1a's info here!!\ndammit", "question"),
					new Hotel("Option 2a", 200.12, "haha\ni need to put hotel 2a's info here!!\ndammit", "question"),
					new Hotel("Option 3a", 300.12, "haha\ni need to put hotel 3a's info here!!\ndammit", "question"),
					new Hotel("Option 4a", 400.12, "haha\ni need to put hotel 4a's info here!!\ndammit", "question"),
					new Hotel("Option 5a", 899.99, "haha\ni need to put hotel 5a's info here!!\ndammit", "question")));
			break;
		case 1:
			vacationSpot = selectedVacation.getVacName();
			flightCost = selectedVacation.getFlightPrice();
			HotelCB.setItems(FXCollections.observableArrayList(
					new Hotel("Option 1b", 100.12, "haha\ni need to put hotel 1b's info here!!\ndammit", "question"),
					new Hotel("Option 2b", 200.12, "haha\ni need to put hotel 2b's info here!!\ndammit", "question"),
					new Hotel("Option 3b", 300.12, "haha\ni need to put hotel 3b's info here!!\ndammit", "question"),
					new Hotel("Option 4b", 400.12, "haha\ni need to put hotel 4b's info here!!\ndammit", "question"),
					new Hotel("Option 5b", 899.99, "haha\ni need to put hotel 5b's info here!!\ndammit", "question")));
			break;
		case 2:
			vacationSpot = selectedVacation.getVacName();
			flightCost = selectedVacation.getFlightPrice();
			HotelCB.setItems(FXCollections.observableArrayList(
					new Hotel("Option 1c", 100.12, "haha\ni need to put hotel 1c's info here!!\ndammit", "question"),
					new Hotel("Option 2c", 200.12, "haha\ni need to put hotel 2c's info here!!\ndammit", "question"),
					new Hotel("Option 3c", 300.12, "haha\ni need to put hotel 3c's info here!!\ndammit", "question"),
					new Hotel("Option 4c", 400.12, "haha\ni need to put hotel 4c's info here!!\ndammit", "question"),
					new Hotel("Option 5c", 899.99, "haha\ni need to put hotel 5c's info here!!\ndammit", "question")));
			break;
		case 3:
			vacationSpot = selectedVacation.getVacName();
			flightCost = selectedVacation.getFlightPrice();
			HotelCB.setItems(FXCollections.observableArrayList(
					new Hotel("Option 1d", 100.12, "haha\ni need to put hotel 1d's info here!!\ndammit", "question"),
					new Hotel("Option 2d", 200.12, "haha\ni need to put hotel 2d's info here!!\ndammit", "question"),
					new Hotel("Option 3d", 300.12, "haha\ni need to put hotel 3d's info here!!\ndammit", "question"),
					new Hotel("Option 4d", 400.12, "haha\ni need to put hotel 4d's info here!!\ndammit", "question"),
					new Hotel("Option 5d", 899.99, "haha\ni need to put hotel 5d's info here!!\ndammit", "question")));
			break;
		case 4:
			vacationSpot = selectedVacation.getVacName();
			flightCost = selectedVacation.getFlightPrice();
			HotelCB.setItems(FXCollections.observableArrayList(
					new Hotel("Option 1e", 100.12, "haha\ni need to put hotel 1e's info here!!\ndammit", "question"),
					new Hotel("Option 2e", 200.12, "haha\ni need to put hotel 2e's info here!!\ndammit", "question"),
					new Hotel("Option 3e", 300.12, "haha\ni need to put hotel 3e's info here!!\ndammit", "question"),
					new Hotel("Option 4e", 400.12, "haha\ni need to put hotel 4e's info here!!\ndammit", "question"),
					new Hotel("Option 5e", 899.99, "haha\ni need to put hotel 5e's info here!!\ndammit", "question")));
			break;
		}
	}

	// sets all images to false, to make them not visible

	// CheckBoxes for activities each box has own price
	@FXML
	public void updateButtonPressed(ActionEvent event) throws IOException {
		double totalCost = 0.0;
		BigDecimal totalCostBD;
		if (op1CBx.isSelected()) {
			totalCost += 19.99;
		}
		if (op2CBx.isSelected()) {
			totalCost += 19.99;
		}
		if (op3CBx.isSelected()) {
			totalCost += 19.99;
		}
		if (op4CBx.isSelected()) {
			totalCost += 19.99;
		}
		if (op5CBx.isSelected()) {
			totalCost += 19.99;
		}
		if (op6CBx.isSelected()) {
			totalCost += 19.99;
		}
		if (op7CBx.isSelected()) {
			totalCost += 19.99;
		}
		if (op8CBx.isSelected()) {
			totalCost += 19.99;
		}
		if (op9CBx.isSelected()) {
			totalCost += 19.99;
		}
		if (op10CBx.isSelected()) {
			totalCost += 19.99;
		}
		// fixes floating decimals
		totalCostBD = truncateDecimal(totalCost);
		totalCostString = totalCostBD.toString();
		SumofActivities.setText("$" + totalCostString);
	}

	// makes the decimal only 2 spaces
	private static BigDecimal truncateDecimal(double x) {
		int numberofDecimals = 2;
		if (x > 0) {
			return new BigDecimal(String.valueOf(x)).setScale(numberofDecimals, BigDecimal.ROUND_FLOOR);
		} else {
			return new BigDecimal(String.valueOf(x)).setScale(numberofDecimals, BigDecimal.ROUND_CEILING);
		}
	}

	// does some error checking and if all is good, then updates bill and
	// itinerary
	@FXML
	public void finalizeButtonPressed(ActionEvent event) throws IOException {
		// calculations and conversions for the bill
		double activitiesCost = Double.parseDouble(totalCostString);

		BigDecimal hotelTotalBD = truncateDecimal(hotelCost * days);
		String hotelTotal = hotelTotalBD.toString();
		double hotelTotalCost = Double.parseDouble(hotelTotal);
		BigDecimal grandTotalBD = truncateDecimal((hotelCost * days) + activitiesCost + flightCost);
		grandTotal = grandTotalBD.toString();
		double grandTotalCost = Double.parseDouble(grandTotal);
		// sets error messages not visible
		vacationDestError.setVisible(false);
		dateOOBerror.setVisible(false);
		hotelError.setVisible(false);
		Bill.setText("");
		Itinerary.setText("");

		// error checking
		// makes sure they chose a vacation spot
		if (vacationSpotChosen())
			vacationDestError.setVisible(true);
		// makes sure they return date is after the departure date
		if (returnBeforeDep())
			dateOOBerror.setVisible(true);
		// makes sure they chose a vacation spot
		if (hotelChosen())
			hotelError.setVisible(true);
		// if no errors print the itinerary and bill
		if (hotelChosen() == false && returnBeforeDep() == false && vacationSpotChosen() == false) {
			// the itinerary set text area
			Bill.setText("\t\t     Receipt");
			Bill.appendText("\n\t   Cost                  Item Description");
			Bill.appendText(
					"\n\t$" + String.valueOf(hotelTotalCost) + "          " + hotelName + " for " + days + " nights");
			Bill.appendText("\n\t$" + String.valueOf(flightCost) + "          Roundtrip Flight to " + vacationSpot);
			Bill.appendText("\n\t$" + totalCostString + "          Packages Added");
			Bill.appendText("\n___________________________________________________");
			Bill.appendText("\n\t$" + String.valueOf(grandTotalCost) + "          Final Amount");

			Itinerary.setText("\t  " + (days + 1) + " Day Trip to " + vacationSpot);
			Itinerary.appendText("\nYou will be departing on " + formatter.format(DepartureDate.getValue()));
			Itinerary.appendText("\nYou will be returning on " + formatter.format(ReturnDate.getValue()));
			Itinerary.appendText("\nYou will be staying at " + hotelName);
		}
	}

	// error checking function
	public boolean vacationSpotChosen() {
		boolean picked = VacationDestCB.getSelectionModel().isEmpty();
		return picked;
	}

	// error checking function
	public boolean returnBeforeDep() {
		boolean gtg = false;
		days = (int) ChronoUnit.DAYS.between(DepartureDate.getValue(), ReturnDate.getValue());
		if (days < 0)
			gtg = true;
		return gtg;
	}

	// error checking function
	public boolean hotelChosen() {
		boolean picked = HotelCB.getSelectionModel().isEmpty();
		return picked;
	}

	// loads the calendars for users to pick dates
	public void calenderFunction() {
		final Callback<DatePicker, DateCell> dayCellFactory = new Callback<DatePicker, DateCell>() {
			public DateCell call(final DatePicker datePicker) {
				return new DateCell() {
					public void updateItem(LocalDate item, boolean empty) {
						super.updateItem(item, empty);
						if (item.isBefore(LocalDate.now())) {
							setDisable(true);
							setStyle("-fx-background-color: black;");
						}
					}
				};
			}
		};
		final Callback<DatePicker, DateCell> dayCellFactory1 = new Callback<DatePicker, DateCell>() {
			public DateCell call(final DatePicker datePicker) {
				return new DateCell() {
					public void updateItem(LocalDate item, boolean empty) {
						super.updateItem(item, empty);
						if (item.isBefore(DepartureDate.getValue().plusDays(1))) {
							setDisable(true);
							setStyle("-fx-background-color: #ffc0cb;");
						}
					}
				};
			}
		};

		DepartureDate.setDayCellFactory(dayCellFactory);
		DepartureDate.setValue(LocalDate.now());
		ReturnDate.setDayCellFactory(dayCellFactory1);
		ReturnDate.setValue(LocalDate.now().plusDays(3));

	}

	// Important variables used for filling in text
	String totalCostString = "0.00";
	String grandTotal = "";
	int days;
	String hotelName = "";
	String vacationSpot = "";
	double hotelCost = 0.00;
	double flightCost = 0.00;
	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMM dd, yyyy");
	Image x = (new Image(getClass().getResourceAsStream("/pictures/grey.jpg")));

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// sets starting location to san antonio like they all fly from there
		HomeCityCB.getItems().addAll("San Antonio, TX");
		HomeCityCB.setValue("San Antonio, TX");
		// loads the items into vacation options
		VacationDestCB.setItems(FXCollections.observableArrayList(
				// EXAMPLE new Vacation("Los Angeles, CA", 206.99)
				new Vacation("Option 1", 300.12), new Vacation("Option 2", 230.23), new Vacation("Option 3", 150.08),
				new Vacation("Option 4", 190.01), new Vacation("Option 5", 899.99)));
		hotelTextArea.setEditable(false);
		Itinerary.setEditable(false);
		Bill.setEditable(false);
		calenderFunction();
		// calculates days of trip
		days = (int) ChronoUnit.DAYS.between(DepartureDate.getValue(), ReturnDate.getValue());
		imageView.setImage(x);
	}
}
