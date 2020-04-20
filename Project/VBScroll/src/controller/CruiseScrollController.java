package controller;

import java.io.IOException;
import java.math.BigDecimal;
import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ResourceBundle;

import javafx.application.Platform;
import javafx.beans.binding.Bindings;
import javafx.beans.binding.IntegerBinding;
import javafx.collections.FXCollections;
import javafx.collections.ObservableSet;
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

public class CruiseScrollController implements Initializable {
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
	private TextArea Itenerary;
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

	//closes app when pressed
	@FXML
	public void lastButtonPressed(ActionEvent event) throws IOException {
		Platform.exit();
	}

	//loads hotel options and all required information
	@FXML
	void hotelChoiceMade(ActionEvent event) {
		Hotel selectedHotel = HotelCB.getSelectionModel().getSelectedItem();

		switch (HotelCB.getSelectionModel().getSelectedIndex()) {
		case 0:
			hotelName = selectedHotel.getHotelName();
			hotelCost = selectedHotel.getHotelPrice();
			hotelTextArea.setText(selectedHotel.getHotelInfo());
			Image x0 = (new Image(getClass().getResourceAsStream("/pictures/"+ selectedHotel.getHotelImage()+".jpg")));
			imageView.setImage(x0);
			break;

		case 1:
			hotelName = selectedHotel.getHotelName();
			hotelCost = selectedHotel.getHotelPrice();
			hotelTextArea.setText(selectedHotel.getHotelInfo());
			Image x1 = (new Image(getClass().getResourceAsStream("/pictures/"+ selectedHotel.getHotelImage()+".jpg")));
			imageView.setImage(x1);
			break;

		case 2:
			hotelName = selectedHotel.getHotelName();
			hotelCost = selectedHotel.getHotelPrice();
			hotelTextArea.setText(selectedHotel.getHotelInfo());
			Image x2 = (new Image(getClass().getResourceAsStream("/pictures/"+ selectedHotel.getHotelImage()+".jpg")));
			imageView.setImage(x2);
			break;

		case 3:
			hotelName = selectedHotel.getHotelName();
			hotelCost = selectedHotel.getHotelPrice();
			hotelTextArea.setText(selectedHotel.getHotelInfo());
			Image x3 = (new Image(getClass().getResourceAsStream("/pictures/"+ selectedHotel.getHotelImage()+".jpg")));
			imageView.setImage(x3);
			break;

		case 4:
			hotelName = selectedHotel.getHotelName();
			hotelCost = selectedHotel.getHotelPrice();
			hotelTextArea.setText(selectedHotel.getHotelInfo());
			Image x4 = (new Image(getClass().getResourceAsStream("/pictures/"+ selectedHotel.getHotelImage()+".jpg")));
			imageView.setImage(x4);
			break;
		}
	}

	// gets user choice for vacation destination
	@FXML
	void vacationDestMade(ActionEvent event) {
		// clears hotel options so each vacation has there own
		HotelCB.getItems().removeAll(HotelCB.getItems());
		hotelTextArea.clear();
		imageView.setImage(x);
		Vacation selectedVacation = VacationDestCB.getSelectionModel().getSelectedItem();

		switch (VacationDestCB.getSelectionModel().getSelectedIndex()) {
		case 0:// LA
			flightCost = selectedVacation.getFlightPrice();
			vacationSpot = selectedVacation.getVacName();
			HotelCB.setItems(FXCollections.observableArrayList(
					new Hotel("Norwegian: Mexican Riviera", 129.99,
							"Norwegian: Mexican Riviera\n"
									+ "Port calls: Cabo San Lucas, Mexico; Mazatlán, Mexico; Puerto Vallarta, Mexico\n"
									+ "Thank you for choosing Norwegian Cruise Line. You are about to embark on a cruise holiday\n"
									+ "where freedom and flexibility reign with our signature Freestyle Cruising", 
									"norweign"),
					new Hotel("Norwegian: Pacific Coastal", 105.99,
							"Norwegian: Pacific Coastal\n"
									+ "Port calls: San Francisco, California; Victoria, British Columbia; Vancouver, British Columbia\n"
									+ "Thank you for choosing Norwegian Cruise Line. You are about to embark on a cruise holiday\n"
									+ "where freedom and flexibility reign with our signature Freestyle Cruising", 
									"norweign"),
					new Hotel("Norwegian: Panama Canal", 100.99,
							"Norwegian: Panama Canal\n"
									+ "Port calls: Cabo San Lucas, Mexico; Puerto Vallarta, Mexico; Acapulco, Mexico; Puerto Quetzal,\nGuatemala; "
									+ "Puntarenas (Puerto Caldera),Costa Rica; Cartagena, Colombia; Miami, Florida\n"
									+ "Thank you for choosing Norwegian Cruise Line. You are about to embark on a cruise holiday\n"
									+ "where freedom and flexibility reign with our signature Freestyle Cruising", 
									"norweign"),
					new Hotel("Princess: Inside Passage", 65.99,
							"Princess: Inside Passage\n"
									+ "Port calls: Ketchikan, Alaska ; Icy Strait Point, Alaska ; Juneau, Alaska ;\n"
									+ "Glacier Bay National Park (Scenic Cruising), Alaska ; Skagway, Alaska ;\nSitka, Alaska ; Victoria, Canada\n"
									+ "Make the most of your vacation time. Be inspired to see and do more than ever.\nWith Princess, "
									+ "you can experience a truly personalized and hassle-free vacation,\nso you can do more of what you love.", 
									"princess"),
					new Hotel("Princess: Hawaii Island", 139.99, "Princess: Hawaii Island\n"
							+ "Port calls: Hilo, Hawaii ; Honolulu, Hawaii ; Maui (Lahaina), Hawaii ; Kauai (Nawiliwili), \nHawaii ; Ensenada, Mexico\n"
							+ "Make the most of your vacation time. Be inspired to see and do more than ever.\nWith Princess, "
							+ "you can experience a truly personalized and hassle-free vacation,\nso you can do more of what you love.", 
							"princess")));
			break;
		case 1:// San Francisco
			flightCost = selectedVacation.getFlightPrice();
			vacationSpot = selectedVacation.getVacName();
			HotelCB.setItems(FXCollections.observableArrayList(
					new Hotel("Princess: Inside Passage", 75.99,
							"Princess: Inside Passage\n"
									+ "Port calls: Juneau, Alaska ; Skagway, Alaska ; Glacier Bay National Park (Scenic Cruising),\nAlaska ; Ketchikan, Alaska ; Victoria, Canada\n"
									+ "Make the most of your vacation time. Be inspired to see and do more than ever.\nWith Princess, "
									+ "you can experience a truly personalized and hassle-free vacation,\nso you can do more of what you love.", 
									"princess"),
					new Hotel("Princess: Pacific Coastal", 88.99,
							"Princess: Pacific Coastal\n"
									+ "Port calls: Pacific Coastal -Astoria, Oregon ; Victoria, Canada ; Vancouver, Canada\n"
									+ "Make the most of your vacation time. Be inspired to see and do more than ever.\nWith Princess, "
									+ "you can experience a truly personalized and hassle-free vacation,\nso you can do more of what you love.", 
									"princess"),
					new Hotel("Princess: West Coast Getaway", 95.99,
							"Princess: West Coast Getaway\n"
									+ "Port calls: West Coast Getaway -San Diego, California ; Ensenada, Mexico\n"
									+ "Make the most of your vacation time. Be inspired to see and do more than ever.\nWith Princess, "
									+ "you can experience a truly personalized and hassle-free vacation,\nso you can do more of what you love.", 
									"princess"),
					new Hotel("Carnival : Baja Mexico Cruise", 100.99,
							"Carnival : Baja Cruise\n" + "Port calls: Ensenada, Mexico\n"
									+ "Fun For All!! We’re all about fun vacations at sea and ashore! \n"
									+ "A Carnival cruise features day and night time entertainment \n"
									+ "like stage shows, musical performances, deck parties, casinos and more.", 
									"carnival"),
					new Hotel("Carnival : Hawaii Cruise", 124.99,
							"Carnival : Hawaii Cruise\n"
									+ "Port calls: Honolulu, Oahu, Hawaii; Nawiliwili, Kauai, Hawaii; Kahului, Maui, Hawaii; \nKailua-Kona, Hawaii; Hilo, Hawaii; Ensenada, Mexico\n"
									+ "Fun For All!! We’re all about fun vacations at sea and ashore! \n"
									+ "A Carnival cruise features day and night time entertainment \n"
									+ "like stage shows, musical performances, deck parties, casinos and more.", 
									"carnival")));
			break;
		case 2:// Miami
			flightCost = selectedVacation.getFlightPrice();
			vacationSpot = selectedVacation.getVacName();
			HotelCB.setItems(FXCollections.observableArrayList(
					new Hotel("Norwegian: Panama Canal", 118.99,
							"Norwegian: Panama Canal\n"
									+ "Port calls: Santa Marta,Colombia; Cartagena,Colombia; Puntarenas (Puerto Caldera), Costa Rica; \nPuerto Quetzal, Guatemala; Puerto Vallarta, Mexico; Cabo San Lucas,Mexico; \nLos Angeles,California\n"
									+ "Thank you for choosing Norwegian Cruise Line. You are about to embark on a cruise holiday\n"
									+ "where freedom and flexibility reign with our signature Freestyle Cruising", 
									"norweign"),
					new Hotel("Disney: Bahama/Key West", 448.99,
							"Disney: Bahama Cruise Key West\n"
									+ "Port calls: Key West, Florida; Disney Castaway Cay; Nassau, Bahamas\n"
									+ "When you embark on a Disney Caribbean cruise, you’ll experience the one-of-a-kind \n"
									+ "magic of Disney entertainment, the relaxing wonder of an ocean voyage and the \n"
									+ "enchantment of tropical destinations.", 
									"disney"),
					new Hotel("Royal Caribbean: Bahamas ", 77.99,
							"Royal Caribbean: Bahama Cruise\n"
									+ "Port calls: Bahama Cruise - Coco Cay, Bahamas; Nassau, Bahamas\n"
									+ "Royal Caribbean International is an award-winning global cruise brand with a 46-year legacy\n"
									+ "of innovation and introducing industry “firsts” never before seen at sea. The cruise line\n"
									+ "features an expansive and unmatched array of features and amenities only found on\n"
									+ "Royal Caribbean including, jaw-dropping, Broadway-style entertainment and industry-acclaimed\n"
									+ "programming that appeals to families and adventurous vacationers alike.", 
									"royal"),
					new Hotel("Carnival : Bahama Cruise", 66.99,
							"Carnival : Bahama Cruise\n" + "Port calls: Nassau, Bahamas\n"
									+ "Fun For All!! We’re all about fun vacations at sea and ashore! \n"
									+ "A Carnival cruise features day and night time entertainment \n"
									+ "like stage shows, musical performances, deck parties, casinos and more.", 
									"carnival"),
					new Hotel("Oceania Cruises: Marina", 264.99, "Oceania Cruises: Marina\n"
							+ "Port calls: Oranjestad, Aruba; Willemstad, Curacao; Santa Marta, Colombia; \nCartagena, Colombia; Panama Canal Full Transit;\n"
							+ "Fuerte Amador (Balboa), Panama; Manta, Ecuador; Salaverry (Trujillo), Peru; Callao (Lima), Peru\n"
							+ "Each of our voyages is an invitation to discover your next travel story and reignite your passions.\n"
							+ "Experience faraway places that you have always dreamed of. Encounter new ways of looking at\n"
							+ "the world and travel to the far corners of the globe. Savor your experience with imaginative\n"
							+ "insider tours that immerse you in the heart of the destination’s culinary and cultural traditions.", 
							"oceana")));
			break;
		case 3:// NY
			flightCost = selectedVacation.getFlightPrice();
			vacationSpot = selectedVacation.getVacName();
			HotelCB.setItems(FXCollections.observableArrayList(
					new Hotel("Norwegian: Canada Cruise", 126.99,
							"Norwegian: Canada Cruise\n"
									+ "Port calls: Saint John (Bay Of Fundy), New Brunswick • Halifax, Nova Scotia\n"
									+ "Thank you for choosing Norwegian Cruise Line. You are about to embark on a cruise holiday\n"
									+ "where freedom and flexibility reign with our signature Freestyle Cruising", 
									"norweign"),
					new Hotel("Princess: Europe Cruise", 135.99,
							"Princess: Europe Cruise\n"
									+ "Port calls: Halifax, Nova Scotia; Qaqortoq (Julianehab), Greenland; Nanortalik, Greenland;\nAkureyri, Iceland; "
									+ "Seydisfjordur, Iceland; South Queensferry (Edinburgh), Scotland; \nNewcastle Upon Tyne, England; London, England\n"
									+ "Make the most of your vacation time. Be inspired to see and do more than ever.\nWith Princess, "
									+ "you can experience a truly personalized and hassle-free vacation,\nso you can do more of what you love.", 
									"princess"),
					new Hotel("Norwegian: Caribbean Cruise", 77.99,
							"Norwegian: Caribbean Cruise\n"
									+ "Port calls: Puerto Plata, Dominican Republic; Charlotte Amalie, St. Thomas, U.S.V.I.;\n"
									+ "Basseterre, St. Kitts; Bridgetown, Barbados; Castries, St. Lucia; St. John's, Antigua;\nRoad Town, Tortola, B.V.I.\n"
									+ "Thank you for choosing Norwegian Cruise Line. You are about to embark on a cruise holiday\n"
									+ "where freedom and flexibility reign with our signature Freestyle Cruising", 
									"norweign"),
					new Hotel("Norwegian: NorthEast Cruise", 295.99,
							"Norwegian: Canada/New England Cruise\n"
									+ "Port calls: Saint John (Bay Of Fundy), New Brunswick; Halifax, Nova Scotia; Bar Harbor, Maine;\nPortland, Maine\n"
									+ "Thank you for choosing Norwegian Cruise Line. You are about to embark on a cruise holiday\n"
									+ "where freedom and flexibility reign with our signature Freestyle Cruising", 
									"norweign"),
					new Hotel("Princess: World Cruise", 216.99, "Princess: World Cruise\n"
							+ "Port calls: Grand Turk Island, Turks & Caicos; Panama Canal Full Transit; Manta, Ecuador; \n"
							+ "Lima, Peru; General San Martin (Pisco), Peru; Easter Island; Papeete, Tahiti; Bora Bora, \nFrench Polynesia; "
							+ "Cross International Dateline; Auckland, New Zealand; Sydney, Australia\n"
							+ "Make the most of your vacation time. Be inspired to see and do more than ever.\nWith Princess, "
							+ "you can experience a truly personalized and hassle-free vacation,\nso you can do more of what you love.", 
							"princess")));
			break;
		case 4:// NJ
			flightCost = selectedVacation.getFlightPrice();
			vacationSpot = selectedVacation.getVacName();
			HotelCB.setItems(FXCollections.observableArrayList(
					new Hotel("Royal Caribbean: Bahama Cruise", 66.99,
							"Royal Caribbean: Bahama Cruise\n"
									+ "Port calls: Port Canaveral (Orlando), Florida; Perfect Day At Coco Cay, Bahamas; Nassau, Bahamas\n"
									+ "Royal Caribbean International is an award-winning global cruise brand with a 46-year legacy\n"
									+ "of innovation and introducing industry “firsts” never before seen at sea. The cruise line\n"
									+ "features an expansive and unmatched array of features and amenities only found on\n"
									+ "Royal Caribbean including, jaw-dropping, Broadway-style entertainment and industry-acclaimed\n"
									+ "programming that appeals to families and adventurous vacationers alike.", 
									"royal"),
					new Hotel("Royal Caribbean: Bermuda Cruise", 90.99,
							"Royal Caribbean: Bermuda Cruise\n" + "Port calls: King's Wharf, Bermuda\n"
									+ "Royal Caribbean International is an award-winning global cruise brand with a 46-year legacy\n"
									+ "of innovation and introducing industry “firsts” never before seen at sea. The cruise line\n"
									+ "features an expansive and unmatched array of features and amenities only found on\n"
									+ "Royal Caribbean including, jaw-dropping, Broadway-style entertainment and industry-acclaimed\n"
									+ "programming that appeals to families and adventurous vacationers alike.", 
									"royal"),
					new Hotel("Royal Caribbean: Bermuda Cruise", 116.99,
							"Royal Caribbean: Bermuda Cruise\n"
									+ "Port calls: King's Wharf, Bermuda; Philipsburg, St. Maarten; San Juan, Puerto Rico; Labadee\n"
									+ "Royal Caribbean International is an award-winning global cruise brand with a 46-year legacy\n"
									+ "of innovation and introducing industry “firsts” never before seen at sea. The cruise line\n"
									+ "features an expansive and unmatched array of features and amenities only found on\n"
									+ "Royal Caribbean including, jaw-dropping, Broadway-style entertainment and industry-acclaimed\n"
									+ "programming that appeals to families and adventurous vacationers alike.", 
									"royal"),
					new Hotel("Celebrity Cruises: Maine/Bahama Cruise", 101.99,
							"Celebrity Cruises: Maine & Bahama Cruise\n"
									+ "Port calls: Portland, Maine; Bar Harbor, Maine; King's Wharf, Bermuda\n"
									+ "From stunning industry-leading ships sailing to the most desirable destinations around the\n"
									+ "world, to our unrivalled service, discover the Celebrity Distinction we’ve become famous for.", 
									"celebrity"),
					new Hotel("Royal Caribbean: Bahama Cruise", 131.99,
							"Royal Caribbean: Bahama Cruise\n"
									+ "Port calls: Labadee; Oranjestad, Aruba; Willemstad, Curacao; George Town, Grand Cayman; \nGalveston, Texas\n"
									+ "Royal Caribbean International is an award-winning global cruise brand with a 46-year legacy\n"
									+ "of innovation and introducing industry “firsts” never before seen at sea. The cruise line\n"
									+ "features an expansive and unmatched array of features and amenities only found on\n"
									+ "Royal Caribbean including, jaw-dropping, Broadway-style entertainment and industry-acclaimed\n"
									+ "programming that appeals to families and adventurous vacationers alike.", 
									"royal")));
			break;
		}
		
	}
	

	//CheckBoxes for activities each box has own price
	@FXML
	public void updateButtonPressed(ActionEvent event) throws IOException {
		double totalCost = 0.0;
		BigDecimal totalCostBD;
		if (op1CBx.isSelected()) {
			totalCost += 10.99;
		}
		if (op2CBx.isSelected()) {
			totalCost += 62.99;
		}
		if (op3CBx.isSelected()) {
			totalCost += 30.99;
		}
		if (op4CBx.isSelected()) {
			totalCost += 45.99;
		}
		if (op5CBx.isSelected()) {
			totalCost += 69.99;
		}
		if (op6CBx.isSelected()) {
			totalCost += 50.00;
		}
		if (op7CBx.isSelected()) {
			totalCost += 90.00;
		}
		if (op8CBx.isSelected()) {
			totalCost += 250.00;
		}
		if (op9CBx.isSelected()) {
			totalCost += 19.99;
		}
		if (op10CBx.isSelected()) {
			totalCost += 79.99;
		}
		totalCostBD = truncateDecimal(totalCost * days);
		totalCostString = totalCostBD.toString();
		SumofActivities.setText("$" + totalCostString);
	}

	//makes the decimal only 2 spaces
	private static BigDecimal truncateDecimal(double x) {
		int numberofDecimals = 2;
		if (x > 0) {
			return new BigDecimal(String.valueOf(x)).setScale(numberofDecimals, BigDecimal.ROUND_FLOOR);
		} else {
			return new BigDecimal(String.valueOf(x)).setScale(numberofDecimals, BigDecimal.ROUND_CEILING);
		}
	}

	//does some error checking and if all is good, then updates bill and itinerary
	@FXML
	public void finalizeButtonPressed(ActionEvent event) throws IOException {
		double activitiesCost = Double.parseDouble(totalCostString);

		BigDecimal grandTotalBD = truncateDecimal((hotelCost * days) + activitiesCost + flightCost);
		grandTotal = grandTotalBD.toString();
		double grandTotalCost = Double.parseDouble(grandTotal);

		BigDecimal hotelTotalBD = truncateDecimal(hotelCost * days);
		String hotelTotal = hotelTotalBD.toString();
		double hotelTotalCost = Double.parseDouble(hotelTotal);
		
		vacationDestError.setVisible(false);
		dateOOBerror.setVisible(false);
		hotelError.setVisible(false);
		Bill.setText("");
		Itenerary.setText("");

		if (vacationSpotChosen())
			vacationDestError.setVisible(true);
		if (returnBeforeDep())
			dateOOBerror.setVisible(true);
		if (hotelChosen())
			hotelError.setVisible(true);
		if (hotelChosen() == false && returnBeforeDep() == false && vacationSpotChosen() == false) {

			Bill.setText("\t\t     Receipt");
			Bill.appendText("\n\t   Cost                  Item Description");
			Bill.appendText("\n\t$" + String.valueOf(hotelTotalCost)+"          " +hotelName + " for " + days + " nights");
			Bill.appendText("\n\t$" + String.valueOf(flightCost)+ "          Roundtrip Flight to " + vacationSpot);
			Bill.appendText("\n\t$" + totalCostString+ "          Packages Added");
			Bill.appendText("\n___________________________________________________");
			Bill.appendText("\n\t$" + String.valueOf(grandTotalCost) + "          Final Amount");	
					
			Itenerary.setText("\t  "+(days + 1)+" Day Cruise out of "+ vacationSpot);
			Itenerary.appendText("\nYou will be departing on " + formatter.format(DepartureDate.getValue()));
			Itenerary.appendText("\nYou will be returning on " + formatter.format(ReturnDate.getValue()));
			Itenerary.appendText("\nYou will be staying at " + hotelName);
			
		}
	}

	//error checking function
	public boolean vacationSpotChosen() {
		boolean picked = VacationDestCB.getSelectionModel().isEmpty();
		return picked;
	}

	//error checking function
	public boolean returnBeforeDep() {
		boolean gtg = false;
		days = (int) ChronoUnit.DAYS.between(DepartureDate.getValue(), ReturnDate.getValue());
		if (days < 0)
			gtg = true;
		return gtg;
	}
	
	//error checking function
	public boolean hotelChosen() {
		boolean picked = HotelCB.getSelectionModel().isEmpty();
		return picked;
	}

	//loads the calendars for users to pick dates
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

    private void configureCheckBox(CheckBox checkBox) {

        if (checkBox.isSelected()) {
            selectedCheckBoxes.add(checkBox);
        } else {
            unselectedCheckBoxes.add(checkBox);
        }

        checkBox.selectedProperty().addListener((obs, wasSelected, isNowSelected) -> {
            if (isNowSelected) {
                unselectedCheckBoxes.remove(checkBox);
                selectedCheckBoxes.add(checkBox);
            } else {
                selectedCheckBoxes.remove(checkBox);
                unselectedCheckBoxes.add(checkBox);
            }

        });

    }
	
	// Important variables used for filling in text
	String totalCostString = "0.00";
	String grandTotal = "";
	int days;
	String hotelName = "";
	double hotelCost = 0.00;
	double flightCost = 0.00;
	String vacationSpot = "";
	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMM dd, yyyy");
	private ObservableSet<CheckBox> selectedCheckBoxes = FXCollections.observableSet();
    private ObservableSet<CheckBox> unselectedCheckBoxes = FXCollections.observableSet();
    private IntegerBinding numCheckBoxesSelected = Bindings.size(selectedCheckBoxes);
    private final int maxNumSelected =  1; 
    Image x = (new Image(getClass().getResourceAsStream("/pictures/water.jpg")));
    
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		HomeCityCB.getItems().addAll("San Antonio, TX");
		HomeCityCB.setValue("San Antonio, TX");
		VacationDestCB.setItems(FXCollections.observableArrayList(new Vacation("Los Angeles, CA", 206.99),
				new Vacation("San Francisco, CA", 172.99), new Vacation("Miami, FL", 89.99),
				new Vacation("New York, NY", 253.99), new Vacation("Cape Liberty, NJ", 108.99)));
		hotelTextArea.setEditable(false);
		Itenerary.setEditable(false);
		Bill.setEditable(false);
		calenderFunction();
		days = (int) ChronoUnit.DAYS.between(DepartureDate.getValue(), ReturnDate.getValue());
		imageView.setImage(x);
		 configureCheckBox(op6CBx);
	     configureCheckBox(op7CBx);
	     configureCheckBox(op8CBx);
	     
	        numCheckBoxesSelected.addListener((obs, oldSelectedCount, newSelectedCount) -> {
	            if (newSelectedCount.intValue() >= maxNumSelected) {
	                unselectedCheckBoxes.forEach(cb -> cb.setDisable(true));
	            } else {
	                unselectedCheckBoxes.forEach(cb -> cb.setDisable(false));
	            }
	        });
	}
}
