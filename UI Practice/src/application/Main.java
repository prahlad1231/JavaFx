package application;
	
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.Tooltip;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			BorderPane border = new BorderPane();
			border.setPadding(new Insets(5, 5, 10, 5));
			border.setTop(topPane());
			GridPane centerPane = centerPane();
			BorderPane.setAlignment(centerPane, Pos.CENTER);
			BorderPane.setMargin(centerPane, new Insets(50, 10, 30, 110));
			border.setCenter(centerPane);
			
			Scene scene = new Scene(border,600,500);
			scene.setFill(Color.LIGHTCYAN);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setMinHeight(500);
			primaryStage.setMinWidth(600);
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
	
	public HBox topPane() {
		HBox hbox = new HBox();
		hbox.setAlignment(Pos.TOP_CENTER);
		Text title = new Text();
		title.setText("Summary Generator");
		title.setFont(Font.font("Arial", FontWeight.BOLD, 25));
		title.setFill(Color.DARKVIOLET);
		hbox.getChildren().add(title);
		
		return hbox;
	}
	
	public GridPane centerPane() {
		
		Text textName = new Text("Name: ");
		TextField name = new TextField();
		
		Text textAge = new Text("Age: ");
		TextField age = new TextField();
		
		Text textGender = new Text("Gender: ");
		ToggleGroup genderGroup = new ToggleGroup();
		RadioButton maleBtn = new RadioButton("Male");
		maleBtn.setToggleGroup(genderGroup);
		RadioButton femaleBtn = new RadioButton("Female");
		femaleBtn.setToggleGroup(genderGroup);
		HBox genderBox = new HBox(18, maleBtn, femaleBtn);
		
		Text textAddress = new Text("Address: ");
		TextField address = new TextField();
		
		Text textBranch = new Text("Branch: ");
		String[] branchNames = new String[] {"CIVIL", "MECH", "CSE", "IT", "EEE", "ECE"};
		ChoiceBox<String> branch = new ChoiceBox<String>(FXCollections.observableArrayList(branchNames));
		branch.setTooltip(new Tooltip("Select your branch"));
		
		Text textInterests = new Text("Interests: ");
		String[] str = new String[] {"Coding", "Designing", "Testing", "Documentation"};
		CheckBox[] interests = new CheckBox[str.length];
		for(int i = 0; i < str.length; i++) {
			interests[i] = new CheckBox(str[i]);
		}
		HBox interestsBox = new HBox(10);
		for(int i = 0; i < str.length; i++) {
			interestsBox.getChildren().add(i, interests[i]);
		}
		
		HBox buttons = new HBox(50);
		Button generateBtn = new Button("Generate");
		
		Button resetBtn = new Button("RESET");
		resetBtn.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				name.setText("");
				age.setText("");
				maleBtn.setSelected(false);
				femaleBtn.setSelected(false);
				address.setText("");
				for(int i = 0; i < str.length; i++) {
					interests[i].setSelected(false);
				}
				
			}
		});
		
		GridPane gridPane = new GridPane();
		gridPane.setHgap(10);
		gridPane.setVgap(10);
		gridPane.addColumn(0, textName, textAge, textGender, textAddress, textBranch, textInterests);
		gridPane.addColumn(1, name, age, genderBox, address, branch, interestsBox);
			
		return gridPane;
	}
}
