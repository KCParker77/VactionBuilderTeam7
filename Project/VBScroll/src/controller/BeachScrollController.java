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

public class BeachScrollController implements Initializable {
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
					new Hotel("Super 8 by Wyndham", 269.99, 
							"Experience all San Francisco has to offer from our Super 8 San Francisco/Near the Marina hotel, \n"
									+ "conveniently located on Highway 101. Enjoy time-saving amenities from your comfortable \n"
									+ "hotel room, right in the heart of historic Fisherman's Wharf.", "super8SanFran"),
					new Hotel("Lodge at the Presidio", 320.99, 
							"The Lodge is an historic boutique hotel on the Main Post of the Presidio that’s been renovated\n"
									+ "into a comfortable and contemporary ‘basecamp’ for adventures in a unique national park setting.\n"
									+ "Guests escape the bustle of downtown and enjoy nature and recreation in the park, while being \n"
									+ "steps away from excellent dining options and a complimentary shuttle ride to the sidewalks of\n"
									+ "San Francisco.", "LodgeatPresidio_SanFran"),
					new Hotel("Marina Motel", 275.99, 
							"Walk around the corner to the numerous outdoor cafes, restaurants and boutiques on Chestnut and \n"
									+ "Union Street, take a walk on the beach to the Golden Gate Bridge or rent a bike and ride across \n"
									+ "it while taking the ferry back, ride a cable car at Fisherman's Wharf or visit the de Young Museum \n"
									+ "or California Academy of Science in Golden Gate Park. The best of San Francisco is within easy reach.", "MarinaMotel"),
					new Hotel("Infinity Hotel", 179.12, 
							"The Infinity Hotel San Francisco is located in the beautiful Marina District close to Fisherman’s Wharf\n"
									+ "and the Golden Gate Bridge. As part of the acclaimed Ascend Collection by Choice Hotels,\n"
									+ "the Infinity Hotel promises a unique experience to visitors of San Francisco. We are within walking \n"
									+ "distance to the Presidio, Palace of Fine Arts, Chestnut Street, Pier 39, and Ghirardelli Square. \n"
									+ "We are steps away from unique boutique shops, wine bars, and award-winning restaurants. \n"
									+ "Enjoy our stunning roof-top views of the Golden Gate Bridge and San Francisco’s Skyline. \n"
									+ "Drift away at Infinity Hotel SF where the best of San Francisco surrounds you.", "InfinitySanFran"),
					new Hotel("The Inn Above Tide", 425.99, 
							"This intimate Sausalito waterfront hotel with 33 rooms and suites is a magnificent location \n"
									+ "for a uniquely inspiring luxury retreat. Chic and understated interiors lead to simply \n"
									+ "mesmerizing views from the private furnished room decks. Sited directly on SF Bay, every\n"
									+ "room has sweeping views of the bay, city skyline, Alcatraz, Angel Island and Marin", "InnAboveTideSanFran")));
			break;
		case 1:
			vacationSpot = selectedVacation.getVacName();
			flightCost = selectedVacation.getFlightPrice();
			HotelCB.setItems(FXCollections.observableArrayList(
					new Hotel("Surfsand Resort", 199.99, 
						"Enjoy sweeping views of the Pacific Ocean and iconic Haystack Rock A friendly, experienced staff \n"
							+ "A short walk to galleries, shops and restaurants Plush bathrobes and deep soaking tubs Gas \n"
							+ "fireplaces in most guest rooms In-room dining, plus oceanfront dining at the Wayfarer Restaurant\n"  
							+ "& Lounge Surfsand Kids - Fun activities for our younger guests, including ice cream socials", "SurfsandResortOR"),
					new Hotel("Inn at Cannon Beach", 229.12, 
						"Their dream was to build a small Inn that would nurture its’ guests sense of renewal and discovery \n"
							+ "by providing them just the perfect environment, right here in Cannon Beach. The architects \n"  
							+ "undertook this project infusing their design with a celebration of nature and a warm sense of\n"   
							+ "Northwest hospitality. The cottage-style buildings are designed to be low in profile to provide\n"  
							+ " a very human scale. The majority of rooms were then arranged around a shared central courtyard \n"
							+ "and naturalized pond. It’s here that our guests congregate for companionship or to find that \n" 
							+ "perfect spot under a tree to begin reading their new novel. Guests often come together over a \n"
							+ "bottle of Oregon Pinot Noir to share their stories and make new friends.", "InnatCannonBeachOR"),
					new Hotel("Inn at HayStack Rock", 208.12, 
						"Our recently renovated Inn provides an intimate setting featuring 23 rooms situated around our quiet \n"
							+ "garden courtyards. As of this year, Inn at Haystack Rock encompasses the Blue Gull Inn as well. \n" 
							+ "The property hasn't changed, simply the name. Now we are referring to Blue Gull Inn as Inn at \n"
							+ "Haystack Rock - Site 2. We still have the same service and comfort our guests have come to love.\n" 
							+ "We offer a variety of amenities including hot tubs, kitchens, fireplaces, and private patios. \n" 
							+ "We invite you to discover our little spot of paradise along the Oregon Coast.", "innathaystackrockOR"),
					new Hotel("The Ocean Lodge", 279.99, 
						"Cannon Beach’s premiere oceanfront hotel, The Ocean Lodge, offers truly unique and romantic \n" 
							+ "lodging on the Oregon coast, just steps away from iconic Haystack Rock. The Ocean Lodge\n"   
							+ "is where the pace of life slows and the simple pleasures discovered at the beach are \n"
							+ "treasured.The magic of this property is its rare oceanfront location, its spectacular\n" 
							+ "architecture and the tasteful, fun beach interiors. The Ocean Lodge is located right \n"
							+ "on the ocean in Cannon Beach. It is the culture of this inn that guests continue to \n"
							+ "rave about. It’s a culture of caring and attention to detail that drives its \n"
							+ "extraordinary reputation for excellence, warmth and hospitality.", "TheOceanLodgeOR"),
					new Hotel("The Waves", 149.99, 
						"Whether you are looking for a romantic getaway, a weekend escape or a family adventure, we have\n"  
							+ "the right place for you to relax and unwind, create new memories and just get away for the\n" 
							+ "vacation you deserve. Situated oceanfront and a shells-throw from the Cannon Beach village,\n" 
							+ "The Waves at Cannon Beach is your most convenient lodging choice. Take a stroll on the beach,\n" 
							+ "wander Ecola Creek or venture off to browse and sample from the many specialty stores in the \n"
							+ "village area of Cannon Beach", "TheWavesOR")));
			break;
		case 2:
			vacationSpot = selectedVacation.getVacName();
			flightCost = selectedVacation.getFlightPrice();
			HotelCB.setItems(FXCollections.observableArrayList(
					new Hotel("Riviera Hotel South Beach", 148.99, 
						"Blending classic sophistication and contemporary chic, the Riviera South Beach hotel offers \n"
							+ "stylish Classic Rooms, Modern Balcony Rooms, as well as One-Bedroom apartment-like \n"
							+ "accommodations with gourmet kitchens, separate living and dining areas at affordable\n"
							+ "hotel room prices.", "RivieraHotelFL"),
					new Hotel("1 Hotel South Beach", 529.99, 
						"1 Vision. The future of the world and the future of hospitality are one in the same. 1 Hotels\n"
							+ "aspires to be a platform to spark conversations, between innovators and guests, that \n"
							+ "transform the industry and our lives.", "1HotelFL"),
					new Hotel("Loews Miami Beach", 192.12, 
						"Palm trees and paradise awaits at Loews Miami Beach Hotel. Located in the heart of the Art \n"
							+ "Deco District, we're only a wander away from the action on Lincoln Road and Ocean Drive,\n"
							+ "but we also offer endless entertainment, amenities and services right here at our resort \n"
							+ "to ensure a memorable stay.", "LoewsHotelFL"),
					new Hotel("Mondrian South Beach", 214.99, 
						"Soak up the sun at our legendary pool, prepare for relaxation at our signature South Beach Spa,\n"
							+ "GuyandGirl, or work off last night’s indulgence at our world-class gym. Savor a meal \n"
							+ "indoors or al fresco at Mondrian Caffe and enjoy a specialty crafted cocktail. Thrill \n"
							+ "seekers can enjoy water sports on Biscayne Bay including jet skis, boating, kayaks, \n"
							+ "and paddle boards.", "MondrainHotelFL"),
					new Hotel("Kimpton Surfcomber", 157.99, 
						"As part of the candy-colored historic Art Deco District, Kimpton Surfcomber Hotel welcomes \n"
							+ "you to the sea-and-be-seen revelry of Miami’s South Beach. Famed nightlife, shops, \n"
							+ "cafes and galleries are a stroll away. But even without leaving the hotel you can \n"
							+ "soak up the fun with Kimpton Surfcomber’s playful “Daylife.” Think ice cream sundaes\n"
							+ "by our glorious pool, bocce ball tournaments at a private sandy oasis and beach side \n"
							+ "food and beverage service on the beach. Some say we’re the most social hotel around. \n"
							+ "To that we say, SoBe it.", "KimptonHotelFL")));
			break;
		case 3:
			vacationSpot = selectedVacation.getVacName();
			flightCost = selectedVacation.getFlightPrice();
			HotelCB.setItems(FXCollections.observableArrayList(
					new Hotel("Four Seasons", 855.99, 
						"Resting on the picturesque Kona-Kohala coast of Hawaii Island, the Four Seasons Resort \n"
							+ "Hualalai combines the warm aloha of the Islands with the impeccable signature service \n"
							+ "recognized by Four Seasons guests worldwide. With 243 guest rooms, an award-winning  \n"
							+ "golf course, and seven pools, Four Seasons Resort Hualalai is the only Forbes Five \n"
							+ "Star and AAA Five Diamond Rated Resort in Hawaii.", "FourSeasonsHW"),
					new Hotel("CourtYard by Marriott", 208.99, 
						"Courtyard by Marriott King Kamehameha's Kona Beach Hotel welcomes you to the Big Island \n"
							+ "of Hawaii for a memorable vacation. Located on the historical site where the famed\n"
							+ "Hawaiian King Kamehameha once lived, our beachfront hotel in Kailua-Kona provides \n"
							+ "ocean views and direct access to Kailua Pier. Our Kona hotel is also a short distance\n"
							+ "from downtown Kona, Kahaluu Beach Park, Kealakekua Bay, and Kailua Village.", "CourtyardHW"),
					new Hotel("Holiday Inn Express", 132.99, 
						"Holiday Inn Express Hotel & Suites Kailua-Kona is an excellent choice for travelers visiting \n"
							+ "Kailua-Kona, offering many helpful amenities designed to enhance your stay. Guest rooms offer\n"
							+ "amenities such as a flat screen TV and air conditioning, and guests can go online with free \n"
							+ "wifi offered by the hotel. Holiday Inn Express Hotel & Suites Kailua-Kona features a 24 hour \n"
							+ "front desk, to help make your stay more enjoyable. The property also boasts a pool and breakfast.", "HolidayInnHW"),
					new Hotel("Castle Kona", 248.99, 
						"Kona Bali Kai is a condominium resort located on the ocean's edge, displaying an uninterrupted \n"
							+ "vista of magnificent Kona sunsets. Choose from studios, one-, two-, and three-bedroom suites\n"
							+ "with full-kitchens, private lanai, and ocean or mountainside views. Amenities include a swimming\n"
							+ "pool, barbecue areas throughout the resort, and a laundry facility.", "CastleKonaHW"),
					new Hotel("Aston Kona", 219.99, 
						"An intimate, oceanfront resort with breathtaking views and spacious suites. This condominium \n"
							+ "resort fronts a magnificent rocky shoreline with its own sandy lounging area, outdoor barbecue\n"
							+ "facilities and more. Located just south of historic Kailua-Kona with its charming shops, \n"
							+ "dining, and nightlife", "AstonKonaHW")));
			break;
		case 4:
			vacationSpot = selectedVacation.getVacName();
			flightCost = selectedVacation.getFlightPrice();
			HotelCB.setItems(FXCollections.observableArrayList(
					new Hotel("Hyatt Place", 461.99, 
						"Welcome to Hyatt Place Portland-Old Port, a hotel like no other in the country. As the\n"
							+ "only Hyatt hotel in Maine, we make an impression on our guests that lasts, with unique designs\n"
							+ "and guestroom layouts that put to shame the standard feel you get from other hotels. Not only \n"
							+ "that, but our views of Portland are impeccable-waterfront and city views set us aside as better \n"
							+ "than the rest, where a short walk is all you need to be inside Maine's renowned Old Port.", "HyattPlaceME"),
					new Hotel("Hampton Inn Dowtown", 299.99, 
						"The Hampton Inn® Portland/Downtown - Waterfront hotel is nestled in the city's Old Port\n"
							+ "District and offers breathtaking views of lovely Casco Bay and the historic waterfront. \n"
							+ "Stroll along the cobblestone streets as you explore the many boutiques, museums, galleries \n"
							+ "and bustling cafes. There's so much to see and do within walking distance of our Portland \n"
							+ "hotel! Valet parking only onsite $20 per night.", "HamptonInnME"),
					new Hotel("The Westin", 305.99, 
						"The Westin Portland Harborview is centrally located in the heart of downtown's vibrant \n"
							+ "Arts District. Formerly the Eastland Park Hotel, our historic hotel's 289 room hotel offer\n"
							+ "the uplifting, revitalizing amenities you have come to expect from Westin. Other property \n"
							+ "features include our full service Akari Spa, 24-hour WestinWORKOUT(R) Fitness Studio, and \n"
							+ "Congress Squared restaurant. Treat yourself to panoramic views of Portland and Casco Bay \n"
							+ "from our iconic rooftop lounge, Top of the East offering delicious and healthful local fare\n"
							+ "& signature cocktails.", "TheWestinME"),
					new Hotel("Embassy Suites", 277.99, 
						"Embassy Suites by Hilton Portland Maine is the best value in Portland, Maine! Located \n"
							+ "adjacent to the Portland airport and just minutes from two major interstates, the Maine \n"
							+ "Mall and the downtown district. Our modern all-suite hotel is centrally located to a variety\n"
							+ "of area attractions, historic sites, outdoor recreation and prominent businesses. ", "EmbassySuitesME"),
					new Hotel("Hilton Garden Inn", 279.99, 
						"The Hilton Garden Inn Downtown Waterfront Portland hotel in Portalnd, Maine is perfectly\n"
							+ "situated in the city's Historic Old Port District and offers fantastic views of Casco Bay\n"
							+ "and Portland's working waterfront. Everything is within walking distance and you will enjoy\n"
							+ "the convenience of boutique shopping, gourmet restaurants, and fabulous art galleries being \n"
							+ "nearby. Steps from our Portland, ME hotel's front door you will find the Portland Trails \n"
							+ "jogging path, fishing and sailing tours, as well as great family attractions.", "HiltonGardenInnME")));
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
			totalCost += 45.99;
		}
		if (op2CBx.isSelected()) {
			totalCost += 99.99;
		}
		if (op3CBx.isSelected()) {
			totalCost += 149.99;
		}
		if (op4CBx.isSelected()) {
			totalCost += 124.99;
		}
		if (op5CBx.isSelected()) {
			totalCost += 74.99;
		}
		if (op6CBx.isSelected()) {
			totalCost += 49.99;
		}
		if (op7CBx.isSelected()) {
			totalCost += 249.99;
		}
		if (op8CBx.isSelected()) {
			totalCost += 79.99;
		}
		if (op9CBx.isSelected()) {
			totalCost += 19.99;
		}
		if (op10CBx.isSelected()) {
			totalCost += 99.99;
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
				new Vacation("San Francisco, CA", 477.12), new Vacation("NewPort, OR", 211.01), new Vacation("Miami, FL", 310.08),
				new Vacation("Kona Coast, Hawaii", 203.23), new Vacation("Portland, ME", 587.99)));
		hotelTextArea.setEditable(false);
		hotelTextArea.setEditable(false);
		Itinerary.setEditable(false);
		Bill.setEditable(false);
		calenderFunction();
		// calculates days of trip
		days = (int) ChronoUnit.DAYS.between(DepartureDate.getValue(), ReturnDate.getValue());
		imageView.setImage(x);
	}
}
