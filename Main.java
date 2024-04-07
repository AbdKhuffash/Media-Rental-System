package application;


import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.*;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.event.*;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;


public class Main extends Application{
	
	static MediaRentalManager mRental = new MediaRentalManager();
	@Override
	public void start(Stage primaryStage) {
		try {
			//primaryStage.setMaximized(true);
			readfiles();
//////////////////////////////////////////////////////////////////////////////////////Main Scene
			BorderPane mainroot = new BorderPane();
			mainroot.setPadding(new Insets(50));

			VBox buttons = new VBox();
			buttons.setSpacing(50);
			buttons.setPrefWidth(400);
			buttons.setAlignment(Pos.CENTER_LEFT);

			Button customer = new Button("Customer");
			Button media = new Button("Media");
			Button rent = new Button("Rent");

			customer.setFont(Font.font("Times new Roman", FontWeight.BOLD, FontPosture.REGULAR, 40));
			media.setFont(Font.font("Times new Roman", FontWeight.BOLD, FontPosture.REGULAR, 40));
			rent.setFont(Font.font("Times new Roman", FontWeight.BOLD, FontPosture.REGULAR, 40));

			customer.setMinWidth(buttons.getPrefWidth());
			media.setMinWidth(buttons.getPrefWidth());
			rent.setMinWidth(buttons.getPrefWidth());

			ImageView custimage = new ImageView(new Image("C:\\Users\\Abood\\Desktop\\New folder\\customer.jpg"));
			custimage.setFitWidth(350);
			custimage.setFitHeight(100);
			customer.setGraphic(custimage);

			ImageView medimage = new ImageView(new Image("C:\\Users\\Abood\\Desktop\\New folder\\media.png"));
			medimage.setFitWidth(350);
			medimage.setFitHeight(100);
			media.setGraphic(medimage);

			ImageView rentimage = new ImageView(new Image("C:\\Users\\Abood\\Desktop\\New folder\\rent.png"));
			rentimage.setFitWidth(350);
			rentimage.setFitHeight(100);
			rent.setGraphic(rentimage);

			buttons.getChildren().addAll(customer, media, rent);

			VBox image = new VBox();

			ImageView mainpic = new ImageView(new Image("C:\\Users\\Abood\\Desktop\\New folder\\mainpic.png"));
			Label mainlp = new Label("Rental Media System");

			mainlp.setFont(Font.font("Times new Roman", FontWeight.BOLD, FontPosture.REGULAR, 40));
			image.setAlignment(Pos.CENTER);
			image.setSpacing(50);

			image.getChildren().addAll(mainpic, mainlp);

			mainroot.setLeft(buttons);
			mainroot.setCenter(image);

			Scene mainscene = new Scene(mainroot, 1500, 750);

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////Customer Scene
			VBox custroot = new VBox();
			custroot.setAlignment(Pos.CENTER);
			custroot.setSpacing(50);
			custroot.setPadding(new Insets(50));
			custroot.setPrefWidth(700);
			
			Button newCust=new Button("Add new Customer");
			Button delCust=new Button("Delete Customer");
			Button updCust=new Button("Update Information about Customer");
			Button searchCust=new Button("Search a Customer by id");
			Button printallcustsinfo=new Button("Print all Customers Info");
			Button returntomain=new Button("Return to main page");
			
			newCust.setFont(Font.font("Times new Roman", FontWeight.BOLD, FontPosture.REGULAR, 40));
			delCust.setFont(Font.font("Times new Roman", FontWeight.BOLD, FontPosture.REGULAR, 40));
			updCust.setFont(Font.font("Times new Roman", FontWeight.BOLD, FontPosture.REGULAR, 40));
			searchCust.setFont(Font.font("Times new Roman", FontWeight.BOLD, FontPosture.REGULAR, 40));
			printallcustsinfo.setFont(Font.font("Times new Roman", FontWeight.BOLD, FontPosture.REGULAR, 40));
			returntomain.setFont(Font.font("Times new Roman", FontWeight.BOLD, FontPosture.REGULAR,40));
			
			newCust.setMinWidth(custroot.getPrefWidth());
			delCust.setMinWidth(custroot.getPrefWidth());
			updCust.setMinWidth(custroot.getPrefWidth());
			searchCust.setMinWidth(custroot.getPrefWidth());
			printallcustsinfo.setMinWidth(custroot.getPrefWidth());
			returntomain.setMinWidth(custroot.getPrefWidth());
			
			custroot.getChildren().addAll(newCust,delCust,updCust,searchCust,printallcustsinfo,returntomain);
			
			Scene custscene = new Scene(custroot,1500, 750);
			customer.setOnAction(e -> {
				primaryStage.setScene(custscene);
			});
			
///////////////////////////////////////////////////////////////////////////////scene3-addcust
			BorderPane addcustroot=new BorderPane();
			
			
			HBox addbtns=new HBox();
			addbtns.setAlignment(Pos.CENTER);
			addbtns.setSpacing(100);
			
			Button add=new Button();
			Button backadd=new Button();
			
			ImageView addimage = new ImageView(new Image("C:\\Users\\Abood\\Desktop\\New folder\\add.png"));
			addimage.setFitWidth(50);
			addimage.setFitHeight(50);
			//addimage.setPreserveRatio(true);
			add.setGraphic(addimage);
			
			ImageView backimage = new ImageView(new Image("C:\\Users\\Abood\\Desktop\\New folder\\back.png"));
			backimage.setFitWidth(50);
			backimage.setFitHeight(50);
			//backimage.setPreserveRatio(true);
			backadd.setGraphic(backimage);
			
			addbtns.getChildren().addAll(add,backadd);
			
			
			
			GridPane centeradd=new GridPane();
			centeradd.setAlignment(Pos.CENTER);
			centeradd.setVgap(40);
			centeradd.setHgap(40);
			
			Label idladd=new Label("Customer Id:");
			Label nameladd=new Label("Customer Name:");
			Label addressladd=new Label("Customer Address:");
			Label mobileladd=new Label("Customer Mobile:");
			Label planladd=new Label ("Customer Plan");
	
			TextField idtadd=new TextField();
			TextField nametadd=new TextField();
			TextField addresstadd=new TextField();
			TextField mobiletadd=new TextField();
			TextField planlimitadd=new TextField(); 
			planlimitadd.setPromptText("Set Limited Plan Limit");

			
			ComboBox<String> plancadd=new ComboBox<String>();
			plancadd.getItems().add("LIMITED");
			plancadd.getItems().add("Not-LIMITED");
			
			
			idladd.setStyle("-fx-font-size:40px");
			nameladd.setStyle("-fx-font-size:40px");
			addressladd.setStyle("-fx-font-size:40px");
			mobileladd.setStyle("-fx-font-size:40px");
			planladd.setStyle("-fx-font-size:40px");
			
			idtadd.setStyle("-fx-font-size:20px");
			nametadd.setStyle("-fx-font-size:20px");
			addresstadd.setStyle("-fx-font-size:20px");
			mobiletadd.setStyle("-fx-font-size:20px");
			plancadd.setStyle("-fx-font-size:20px");
			planlimitadd.setStyle("-fx-font-size:20px");

			
			centeradd.add(idladd, 0, 0); centeradd.add(idtadd, 1, 0);
			centeradd.add(nameladd, 0, 1); centeradd.add(nametadd, 1,1);
			centeradd.add(addressladd, 0, 2); centeradd.add(addresstadd, 1, 2);
			centeradd.add(mobileladd, 0, 3); centeradd.add(mobiletadd, 1, 3);
			centeradd.add(planladd, 0, 4); centeradd.add(plancadd, 1, 4); centeradd.add(planlimitadd, 2, 4);
			centeradd.add(addbtns, 1, 5);
			
	
			addcustroot.setCenter(centeradd);
			
			
			nametadd.setDisable(true);
			addresstadd.setDisable(true);
			mobiletadd.setDisable(true);
			plancadd.setDisable(true);
			add.setDisable(true);
			planlimitadd.setVisible(false);

			idtadd.setOnAction(e ->{
				if(idtadd.getText() !=null && idtadd.getText() != "") nametadd.setDisable(false);
				nametadd.requestFocus();
			});
			
			nametadd.setOnAction(e ->{
				if(nametadd.getText() !=null && nametadd.getText() != "")	addresstadd.setDisable(false);
				addresstadd.requestFocus();
			});
			
			addresstadd.setOnAction(e->{
				if(addresstadd.getText() != null && addresstadd.getText() != "") mobiletadd.setDisable(false);
				mobiletadd.requestFocus();
			});
			
			mobiletadd.setOnAction(e ->{
				if(mobiletadd.getText() != null && mobiletadd.getText() != "") plancadd.setDisable(false);
				plancadd.requestFocus();
				
			});
			
			plancadd.setOnAction(e ->{	
				if(plancadd.getValue() != null && plancadd.getValue() != "") {
					//add.setDisable(false);
					if(plancadd.getValue().trim().equals("LIMITED")) {
						planlimitadd.setVisible(true);
						//planlimitadd.requestFocus();	
					}else planlimitadd.setVisible(false );

					add.setDisable(false);
				}
			});
			planlimitadd.setOnAction(e->{
				if(planlimitadd.isVisible()&&(planlimitadd.getText() !=null || planlimitadd.getText() != "")) {
					mRental.setLimitedPlanLimit(Integer.parseInt(planlimitadd.getText()));
				}
			});
			
			add.setOnAction(e->{
				int idadd =Integer.parseInt(idtadd.getText());
				String nameadd=nametadd.getText().trim();
				String addressadd=addresstadd.getText().trim();
				String mobileadd=mobiletadd.getText().trim();
				String planadd=plancadd.getValue();
			   
				if(mRental.findcustomerid(idadd)==null) {
				    mRental.addCustomer(nameadd,addressadd ,planadd,idadd ,mobileadd);
				    idtadd.setStyle("-fx-font-size:20px");
				    idtadd.setPromptText("");
				}else {
					idtadd.setStyle("-fx-border-color:red;-fx-font-size:20px");
					idtadd.setPromptText("Id  Exists!");
				}
				idtadd.setText("");
				nametadd.setText("");
				addresstadd.setText("");
				mobiletadd.setText("");
				plancadd.setValue("");
				planlimitadd.setText("");
				planlimitadd.setVisible(false);
				
				
			});
			backadd.setOnAction(e->{
				primaryStage.setScene(custscene);
				idtadd.setText("");
				nametadd.setText("");
				addresstadd.setText("");
				mobiletadd.setText("");
				plancadd.setValue("");
				planlimitadd.setText("");
				planlimitadd.setVisible(false);
				nametadd.setDisable(true);
				addresstadd.setDisable(true);
				mobiletadd.setDisable(true);
				plancadd.setDisable(true);
				add.setDisable(true);
				idtadd.setStyle("-fx-font-size:20px");
				idtadd.setPromptText("");
			});
			
			
			Scene addcustScene=new Scene(addcustroot,1500,750);
			newCust.setOnAction(e->{
				primaryStage.setScene(addcustScene);
			});
/////////////////////////////////////////////////////////////scene4-deletecust
			BorderPane delcustroot= new BorderPane();
			
			HBox delbtns=new HBox();
			delbtns.setAlignment(Pos.CENTER);
			delbtns.setSpacing(100);
			
			Button delete=new Button();
			Button finddel=new Button();
			Button backdel=new Button();
			
			ImageView delimage = new ImageView(new Image("C:\\Users\\Abood\\Desktop\\New folder\\delete.png"));
			delimage.setFitWidth(50);
			delimage.setFitHeight(50);
			delete.setGraphic(delimage);
						
			ImageView fingimage = new ImageView(new Image("C:\\Users\\Abood\\Desktop\\New folder\\find.png"));
			fingimage.setFitWidth(50);
			fingimage.setFitHeight(50);
			finddel.setGraphic(fingimage);
			ImageView backimdel = new ImageView(new Image("C:\\Users\\Abood\\Desktop\\New folder\\back.png"));
			backimdel.setFitWidth(50);
			backimdel.setFitHeight(50);
			backdel.setGraphic(backimdel);
			
			delbtns.getChildren().addAll(finddel,delete);
			GridPane centerdel=new GridPane();
			centerdel.setAlignment(Pos.CENTER);
			centerdel.setVgap(40);
			centerdel.setHgap(40);
			
			Label idldel=new Label("Customer Id:");
			Label allcustinfoldel=new Label("Customer Info:");
			idldel.setStyle("-fx-font-size:40px");
			allcustinfoldel.setStyle("-fx-font-size:40px");
	
			TextField idtdel=new TextField();
			TextField Allcustinfotdel=new TextField();
			
			
			idtdel.setStyle("-fx-font-size:20px");
			
			Allcustinfotdel.setPromptText("Customer Info will appear here");
			Allcustinfotdel.setMinSize(500,100);
		    Allcustinfotdel.setStyle("-fx-font-size:20px");
		    Allcustinfotdel.setEditable(false);

			centerdel.add(idldel, 0, 0); centerdel.add(idtdel, 1, 0);
			centerdel.add(allcustinfoldel, 0, 1); centerdel.add(Allcustinfotdel, 1, 1);
			centerdel.add(delbtns, 1, 4);
			centerdel.add(backdel, 3, 4);
	
			delcustroot.setCenter(centerdel);
			
			
			delete.setDisable(true);
			finddel.setDisable(true);

			idtdel.setOnAction(e ->{
			if(idtdel.getText() !=null && idtdel.getText() != "") finddel.setDisable(false);
			finddel.requestFocus();
				
			});
		
			
			
			finddel.setOnAction(e ->{
				int iddel =Integer.parseInt(idtdel.getText());
				if(mRental.findcustomerid(iddel)!=null) {
					Allcustinfotdel.setText(mRental.getAllInfoCustomer(iddel));
					delete.setDisable(false);
				}else {
					Allcustinfotdel.setText("Customer Not Found!");
				}
				
			});
			
			delete.setOnAction(e->{
				int iddel =Integer.parseInt(idtdel.getText());
				if (mRental.removeFromCustomer(iddel)) {
					Allcustinfotdel.setText("Customer Deleted!");

				}
				
			});

			backdel.setOnAction(e->{
				primaryStage.setScene(custscene);
				idtdel.setText("");
				Allcustinfotdel.setText("Customer Info will appear here");
				delete.setDisable(true);
				finddel.setDisable(true);

				
			});
			
			Scene delCustScene=new Scene(delcustroot,1500,750);
			delCust.setOnAction(e->{
				primaryStage.setScene(delCustScene);
			});
////////////////////////////////////////////////////////////////////scene5-updatecust
			
			VBox updatecustroot=new VBox();
			updatecustroot.setAlignment(Pos.CENTER);
			updatecustroot.setSpacing(50);
		
			GridPane findcustupdate=new GridPane();
			findcustupdate.setAlignment(Pos.CENTER);
			findcustupdate.setVgap(40);
			findcustupdate.setHgap(40);
			
			Label idlupd=new Label("Customer Id:");
			Label allcustinfolupd=new Label("Customer Info:");
			idlupd.setStyle("-fx-font-size:40px");
			allcustinfolupd.setStyle("-fx-font-size:40px");
	
			TextField idtupd=new TextField();
			TextField Allcustinfotupd=new TextField();
			
			idtupd.setStyle("-fx-font-size:20px");
			
			Allcustinfotupd.setPromptText("Customer Info will appear here");
			Allcustinfotupd.setMinSize(500,100);
			Allcustinfotupd.setStyle("-fx-font-size:20px");
			Allcustinfotupd.setEditable(false);
			
			findcustupdate.add(idlupd, 0, 0); findcustupdate.add(idtupd, 1, 0);
			findcustupdate.add(allcustinfolupd, 0, 1); findcustupdate.add(Allcustinfotupd, 1, 1);
			
			GridPane editcustupdate=new GridPane();
			editcustupdate.setAlignment(Pos.CENTER);
			editcustupdate.setVgap(10);
			editcustupdate.setHgap(40);
			
			Label namelupd=new Label("New Customer Name");
			Label addresslupd=new Label("New Customer Address");
			Label mobilelupd=new Label("New Customer Mobile");
			Label planlupd=new Label ("New Customer Plan");
	
			TextField nametupd=new TextField();
			TextField addresstupd=new TextField();
			TextField mobiletupd=new TextField();
			TextField planlimitupd=new TextField(); 
			planlimitupd.setPromptText("Set Limited Plan Limit");

			
			ComboBox<String> plancupd=new ComboBox<String>();
			plancupd.getItems().add("LIMITED");
			plancupd.getItems().add("Not-LIMITED");
			
			
			namelupd.setStyle("-fx-font-size:30px");
			addresslupd.setStyle("-fx-font-size:30px");
			mobilelupd.setStyle("-fx-font-size:30px");
			planlupd.setStyle("-fx-font-size:30px");
			
			nametupd.setStyle("-fx-font-size:20px");
			addresstupd.setStyle("-fx-font-size:20px");
			mobiletupd.setStyle("-fx-font-size:20px");
			plancupd.setStyle("-fx-font-size:20px");
			planlimitupd.setStyle("-fx-font-size:20px");
			
			editcustupdate.add(namelupd, 0, 0);editcustupdate.add(addresslupd, 1, 0);editcustupdate.add(mobilelupd,2,0);editcustupdate.add(planlupd, 3, 0);
			editcustupdate.add(nametupd, 0, 1);editcustupdate.add(addresstupd, 1, 1);editcustupdate.add(mobiletupd,2,1);editcustupdate.add(plancupd, 3, 1);
			editcustupdate.add(planlimitupd, 3, 2);
			
			HBox updbtns=new HBox();
			updbtns.setAlignment(Pos.CENTER);
			updbtns.setSpacing(250);
			
			Button editupd=new Button();
			Button backupd=new Button();
			Button findupd=new Button();
			
			
			ImageView fingimageupd = new ImageView(new Image("C:\\Users\\Abood\\Desktop\\New folder\\find.png"));
			fingimageupd.setFitWidth(50);
			fingimageupd.setFitHeight(50);
			findupd.setGraphic(fingimageupd);
			
			ImageView backimupd = new ImageView(new Image("C:\\Users\\Abood\\Desktop\\New folder\\back.png"));
			backimupd.setFitWidth(50);
			backimupd.setFitHeight(50);
			backupd.setGraphic(backimupd);
			
			ImageView editimupd = new ImageView(new Image("C:\\Users\\Abood\\Desktop\\New folder\\edit.jpg"));
			editimupd.setFitWidth(50);
			editimupd.setFitHeight(50);
			editupd.setGraphic(editimupd);
			
			updbtns.getChildren().addAll(editupd,findupd,backupd);
			
			updatecustroot.getChildren().addAll(findcustupdate,editcustupdate,updbtns);
			
			
			planlimitupd.setVisible(false);
			editupd.setDisable(true);
			editcustupdate.setVisible(false);
			findupd.setDisable(true);
			
			idtupd.setOnAction(e->{
				if(idtupd.getText() !=null && idtupd.getText() != "") findupd.setDisable(false);
				findupd.requestFocus();
			});
			
			
			findupd.setOnAction(e->{
				int idsearch =Integer.parseInt(idtupd.getText());
				if(mRental.findcustomerid(idsearch)!=null) {
					Allcustinfotupd.setText(mRental.getAllInfoCustomer(idsearch));
					editupd.setDisable(false);
					editcustupdate.setVisible(true);

					editupd.requestFocus();
				}else {
					Allcustinfotupd.setText("Customer Not Found!");
				}
			});
			
			plancupd.setOnAction(e ->{	
				if(plancupd.getValue() != null && plancupd.getValue() != "") {
					//add.setDisable(false);
					if(plancupd.getValue().trim().equals("LIMITED")) {
						planlimitupd.setVisible(true);
						//planlimitadd.requestFocus();	
					}else planlimitupd.setVisible(false );

					editupd.setDisable(false);
				}
			});
			
			planlimitupd.setOnAction(e->{
				if(planlimitupd.isVisible()&&(planlimitupd.getText() !=null && planlimitupd.getText() != "")) {
					mRental.setLimitedPlanLimit(Integer.parseInt(planlimitupd.getText()));
				}
			});
			
			editupd.setOnAction(e->{
				int idupd =Integer.parseInt(idtupd.getText());
				
				String nameupd="";
				String addressupd="";
				String mobileupd="";
				String planupd="";
				
				if(nametupd.getText().trim()==null ||nametupd.getText().trim()=="") {
					nameupd=mRental.findcustomerid(idupd).getName();
				}else {
					nameupd=nametupd.getText().trim();
				}
				
				
				if(addresstupd.getText().trim()==null || addresstupd.getText().trim()=="") {
					addressupd=mRental.findcustomerid(idupd).getAddress();
				}else {
					addressupd=addresstupd.getText().trim();
				}
				
				if(mobiletupd.getText().trim()==null || mobiletupd.getText().trim()=="") {
					mobileupd=mRental.findcustomerid(idupd).getMobile();
				}else {
					mobileupd=mobiletupd.getText().trim();
				}
				
				if(plancupd.getValue()==null || plancupd.getValue()=="") {
					planupd=mRental.findcustomerid(idupd).getPLAN_TYPE();
				}else {
					planupd=plancupd.getValue();
				}
				mRental.removeFromCustomer(idupd);
				mRental.addCustomer(nameupd, addressupd, planupd, idupd, mobileupd);
				
				
				
				Allcustinfotupd.setText("Customer info Updated Successfully!");
				planlimitupd.setVisible(false);
				editupd.setDisable(true);
				editcustupdate.setVisible(false);
				findupd.setDisable(true);
				idtupd.setText("");
				nametupd.setText("");
				addresstupd.setText("");
				mobiletupd.setText("");
				planlimitupd.setPromptText("Set Limited Plan Limit");
				plancupd.setValue("");
				
				
			});
			
			
			
			
			backupd.setOnAction(e->{
				primaryStage.setScene(custscene);
				
				planlimitupd.setVisible(false);
				editupd.setDisable(true);
				editcustupdate.setVisible(false);
				findupd.setDisable(true);
				idtupd.setText("");
				nametupd.setText("");
				addresstupd.setText("");
				mobiletupd.setText("");
				planlimitupd.setPromptText("Set Limited Plan Limit");
				Allcustinfotupd.setPromptText("Customer Info will appear here");
				plancupd.setValue("");


			});
			
			Scene updateCust=new Scene(updatecustroot,1500,750);
			updCust.setOnAction(e->{
				primaryStage.setScene(updateCust);
			});
			
			
////////////////////////////////////////////////////////////////////scene6 - seach customer
			  BorderPane seachcustroot= new BorderPane();
				
				HBox searchbtns=new HBox();
				searchbtns.setAlignment(Pos.CENTER);
				searchbtns.setSpacing(100);
				
				Button findsearch=new Button();
				Button backsearch=new Button();
				
				
							
				ImageView fingimagesearch = new ImageView(new Image("C:\\Users\\Abood\\Desktop\\New folder\\find.png"));
				fingimagesearch.setFitWidth(50);
				fingimagesearch.setFitHeight(50);
				findsearch.setGraphic(fingimagesearch);
				
				ImageView backimsearch = new ImageView(new Image("C:\\Users\\Abood\\Desktop\\New folder\\back.png"));
				backimsearch.setFitWidth(50);
				backimsearch.setFitHeight(50);
				backsearch.setGraphic(backimsearch);
				
				searchbtns.getChildren().addAll(findsearch,backsearch);
				
				GridPane centersearch=new GridPane();
				centersearch.setAlignment(Pos.CENTER);
				centersearch.setVgap(40);
				centersearch.setHgap(40);
				
				Label idlsearch=new Label("Customer Id:");
				Label allcustinfolsearch=new Label("Customer Info:");
				idlsearch.setStyle("-fx-font-size:40px");
				allcustinfolsearch.setStyle("-fx-font-size:40px");
		
				TextField idtsearch=new TextField();
				TextField Allcustinfotsearch=new TextField();
				
				idtsearch.setStyle("-fx-font-size:20px");
				
				Allcustinfotsearch.setPromptText("Customer Info will appear here");
				Allcustinfotsearch.setMinSize(500,100);
				Allcustinfotsearch.setStyle("-fx-font-size:20px");
				Allcustinfotsearch.setEditable(false);
				
				centersearch.add(idlsearch, 0, 0); centersearch.add(idtsearch, 1, 0);
				centersearch.add(allcustinfolsearch, 0, 1); centersearch.add(Allcustinfotsearch, 1, 1);
				centersearch.add(searchbtns, 1, 4);
				
		
				seachcustroot.setCenter(centersearch);
				
				findsearch.setDisable(true);

				idtsearch.setOnAction(e ->{
					if(idtsearch.getText() !=null && idtsearch.getText() != "") findsearch.setDisable(false);
					findsearch.requestFocus();
						
					});
				
					
					
			    findsearch.setOnAction(e ->{
					int idsearch =Integer.parseInt(idtsearch.getText());
					if(mRental.findcustomerid(idsearch)!=null) {
						Allcustinfotsearch.setText(mRental.getAllInfoCustomer(idsearch));
					}else {
						Allcustinfotsearch.setText("Customer Not Found!");
						}
						
					});
			    backsearch.setOnAction(e->{
					primaryStage.setScene(custscene);
					idtsearch.setText("");
					Allcustinfotsearch.setText("Customer Info will appear here");
					
					findsearch.setDisable(true);

					
				});
				
				
				
				Scene searchCustScene=new Scene(seachcustroot,1500,750);
				searchCust.setOnAction(e->{
					primaryStage.setScene(searchCustScene);
				});
				///////////////////////////////////////////////////////////////////////////////print all custs info 
				BorderPane printcustroot=new BorderPane();
				printcustroot.setPadding(new Insets(50));
				   
				   
				Label printallcust=new Label("Print All Customers Information");
				printallcust.setStyle("-fx-font-size:40px");
				   
				   
				TextArea printallcustt=new TextArea ();
		
				printallcustt.setPromptText("Customers Info will appear here");
				printallcustt.setStyle("-fx-font-size:20px");
			    printallcustt.setFocusTraversable(false);
				printallcustt.setEditable(false);
				      
				HBox printbtnscust=new HBox();
				printbtnscust.setSpacing(150);
				printbtnscust.setAlignment(Pos.CENTER);
				   
				Button printcust=new Button();
				Button backpcust=new Button();
				ImageView printmsimagecust = new ImageView(new Image("C:\\Users\\Abood\\Desktop\\New folder\\print.png"));
				printmsimagecust.setFitWidth(50);
				printmsimagecust.setFitHeight(50);
				printcust.setGraphic(printmsimagecust);
				   
				ImageView backmsimcust = new ImageView(new Image("C:\\Users\\Abood\\Desktop\\New folder\\back.png"));
				backmsimcust.setFitWidth(50);
				backmsimcust.setFitHeight(50);
				backpcust.setGraphic(backmsimcust);
			        
				printbtnscust.getChildren().addAll(printcust,backpcust);   
				printcustroot.setTop(printallcust);
				printcustroot.setCenter(printallcustt);
				printcustroot.setBottom(printbtnscust);
				printcustroot.setAlignment(printallcust, Pos.CENTER);
				printcustroot.setAlignment(printallcustt, Pos.CENTER);
				printcustroot.setAlignment(printbtnscust, Pos.BOTTOM_CENTER);
				
				printcust.setOnAction(e->{
					if(mRental.getAllCustomersInfo()!="")
					 printallcustt.setText(mRental.getAllCustomersInfo());
					else printallcustt.setText("There is no Customers");
					
				});
				
				backpcust.setOnAction(e->{
					primaryStage.setScene(custscene);
				});
				
				Scene printcustscene=new Scene(printcustroot,1500,750);
				printallcustsinfo.setOnAction(e->{
					primaryStage.setScene(printcustscene);
					printallcustt.setText("");
					
				});
				////////////////////////
				returntomain.setOnAction(e->{
					primaryStage.setScene(mainscene);
				});
				
////////////////////////////////////////////////////////////////////////////////////////////MediaScene
				VBox mediaroot = new VBox();
				mediaroot.setAlignment(Pos.CENTER);
				mediaroot.setSpacing(50);
				mediaroot.setPadding(new Insets(50));
				mediaroot.setPrefWidth(700);
				
				Button addMedia=new Button("Add new Media");
				Button delMedia=new Button("Delete Media");
				Button updMedia=new Button("Update Information about Media");
				Button searchMedia=new Button("Search a Media by Code");
				Button printMedia=new Button("Print All Media Information");
				Button returntomainn=new Button("Return to main page");
				
				addMedia.setFont(Font.font("Times new Roman", FontWeight.BOLD, FontPosture.REGULAR, 40));
				delMedia.setFont(Font.font("Times new Roman", FontWeight.BOLD, FontPosture.REGULAR, 40));
				updMedia.setFont(Font.font("Times new Roman", FontWeight.BOLD, FontPosture.REGULAR, 40));
				searchMedia.setFont(Font.font("Times new Roman", FontWeight.BOLD, FontPosture.REGULAR, 40));
				returntomainn.setFont(Font.font("Times new Roman", FontWeight.BOLD, FontPosture.REGULAR,40));
				printMedia.setFont(Font.font("Times new Roman", FontWeight.BOLD, FontPosture.REGULAR,40));
				
				addMedia.setMinWidth(mediaroot.getPrefWidth());
				delMedia.setMinWidth(mediaroot.getPrefWidth());
				updMedia.setMinWidth(mediaroot.getPrefWidth());
				searchMedia.setMinWidth(mediaroot.getPrefWidth());
				returntomainn.setMinWidth(mediaroot.getPrefWidth());
				printMedia.setMinWidth(mediaroot.getPrefWidth());
				
				mediaroot.getChildren().addAll(addMedia,delMedia,updMedia,searchMedia,printMedia,returntomainn);
				
				Scene mediascene = new Scene(mediaroot,1500, 750);
				media.setOnAction(e -> {
					primaryStage.setScene(mediascene);
				});
//////////////////////////////////////////////////////////////////////////////////Addmedia Scene
				BorderPane addmedroot=new BorderPane();
				addmedroot.setPadding(new Insets(50));
				
				ComboBox<String> mediaCtypes=new ComboBox<String>();
				addmedroot.setAlignment(mediaCtypes, Pos.CENTER);
				mediaCtypes.setStyle("-fx-font-size:30px;-fx-border-color:red;-fx-background-color:yellow");
				mediaCtypes.setPromptText("Select the Media Type");
				mediaCtypes.getItems().add("Movie");
				mediaCtypes.getItems().add("Game");
				mediaCtypes.getItems().add("Album");



				
				addmedroot.setTop(mediaCtypes);
				

				////////
				StackPane center=new StackPane();
				
				GridPane albuminfo=new GridPane();///////////////////////////////////////
				albuminfo.setAlignment(Pos.CENTER);
				albuminfo.setVgap(40);
				albuminfo.setHgap(40);
				Label albumlcode=new Label("Album Code:");
				Label albumltitle=new Label("Album Title:");
				Label albumlcopies=new Label("Number of Copies Available:");
				Label albumlartist=new Label("Album Artist:");
				Label albumlsongs=new Label ("Album Songs:");
		
				TextField albumtcode=new TextField();
				TextField albumttitle=new TextField();
				TextField albumtcopies=new TextField();
				TextField albumtartist=new TextField();
				TextField albumtsongs=new TextField(); 

				albumlcode.setStyle("-fx-font-size:40px");
				albumltitle.setStyle("-fx-font-size:40px");
				albumlcopies.setStyle("-fx-font-size:40px");
				albumlartist.setStyle("-fx-font-size:40px");
				albumlsongs.setStyle("-fx-font-size:40px");
				albumtcode.setStyle("-fx-font-size:20px");
				albumttitle.setStyle("-fx-font-size:20px");
				albumtcopies.setStyle("-fx-font-size:20px");
				albumtartist.setStyle("-fx-font-size:20px");
				albumtsongs.setStyle("-fx-font-size:20px");
				
				albuminfo.add(albumlcode, 0, 0);albuminfo.add(albumtcode, 1, 0);
				albuminfo.add(albumltitle, 0, 1);albuminfo.add(albumttitle, 1, 1);
				albuminfo.add(albumlcopies, 0, 2);albuminfo.add(albumtcopies, 1, 2);
				albuminfo.add(albumlartist, 0, 3);albuminfo.add(albumtartist, 1, 3);
				albuminfo.add(albumlsongs, 0, 4);albuminfo.add(albumtsongs, 1, 4);
				
				albumttitle.setDisable(true);
				albumtcopies.setDisable(true);
				albumtartist.setDisable(true);
				albumtsongs.setDisable(true);
				
				GridPane gameinfo=new GridPane();///////////////////////////////////////
				gameinfo.setAlignment(Pos.CENTER);
				gameinfo.setVgap(40);
				gameinfo.setHgap(40);
				Label gamelcode=new Label("Game Code:");
				Label gameltitle=new Label("Game Title:");
				Label gamelcopies=new Label("Number of Copies Available:");
				Label gamelwieght=new Label("Game Weight:");

				TextField gametcode=new TextField();
				TextField gamettitle=new TextField();
				TextField gametcopies=new TextField();
				TextField gametweight=new TextField();

				gamelcode.setStyle("-fx-font-size:40px");
				gameltitle.setStyle("-fx-font-size:40px");
				gamelcopies.setStyle("-fx-font-size:40px");
				gamelwieght.setStyle("-fx-font-size:40px");

				gametcode.setStyle("-fx-font-size:20px");
				gamettitle.setStyle("-fx-font-size:20px");
				gametcopies.setStyle("-fx-font-size:20px");
				gametweight.setStyle("-fx-font-size:20px");
				
				gameinfo.add(gamelcode, 0, 0);	    gameinfo.add(gametcode, 1, 0);
				gameinfo.add(gameltitle, 0, 1);  	gameinfo.add(gamettitle, 1, 1);
				gameinfo.add(gamelcopies, 0, 2);	gameinfo.add(gametcopies, 1, 2);
				gameinfo.add(gamelwieght, 0, 3);	gameinfo.add(gametweight, 1, 3);
				
				GridPane movieinfo=new GridPane();///////////////////////////////////////
				movieinfo.setAlignment(Pos.CENTER);
				movieinfo.setVgap(40);
				movieinfo.setHgap(40);
				
				Label movielcode=new Label("Movie Code:");
				Label movieltitle=new Label("Movie Title:");
				Label movielcopies=new Label("Number of Copies Available:");
				Label movielrating=new Label("Select Movie rating");

				TextField movietcode=new TextField();
				TextField moviettitle=new TextField();
				TextField movietcopies=new TextField();
				
		        ComboBox<String> moviecrating=new ComboBox<String>();
		        moviecrating.getItems().add("DR");
		        moviecrating.getItems().add("HR");
		        moviecrating.getItems().add("AC");
		        moviecrating.setStyle("-fx-font-size:20px");

				movielcode.setStyle("-fx-font-size:40px");
				movieltitle.setStyle("-fx-font-size:40px");
				movielcopies.setStyle("-fx-font-size:40px");
				movielrating.setStyle("-fx-font-size:40px");

				movietcode.setStyle("-fx-font-size:20px");
				moviettitle.setStyle("-fx-font-size:20px");
				movietcopies.setStyle("-fx-font-size:20px");				
				
				
				movieinfo.add(movielcode, 0, 0);movieinfo.add(movietcode, 1, 0);
				movieinfo.add(movieltitle, 0, 1);movieinfo.add(moviettitle, 1, 1);
				movieinfo.add(movielcopies, 0, 2);movieinfo.add(movietcopies, 1, 2);
				movieinfo.add(movielrating, 0, 3);movieinfo.add(moviecrating, 1, 3);

				center.getChildren().addAll(albuminfo,gameinfo,movieinfo);

				
				addmedroot.setCenter(center);
	
				///////
				HBox addmediabtns=new HBox();
				addmediabtns.setSpacing(200);
				addmediabtns.setAlignment(Pos.BOTTOM_CENTER);
				
				Button addmed=new Button();
				Button backmed=new Button();
				
				ImageView addmedimage = new ImageView(new Image("C:\\Users\\Abood\\Desktop\\New folder\\add.png"));
				addmedimage.setFitWidth(75);
				addmedimage.setFitHeight(75);
				addmed.setGraphic(addmedimage);
				
				ImageView backmedimage = new ImageView(new Image("C:\\Users\\Abood\\Desktop\\New folder\\back.png"));
				backmedimage.setFitWidth(75);
				backmedimage.setFitHeight(75);
				backmed.setGraphic(backmedimage);
 				
				addmediabtns.getChildren().addAll(addmed,backmed);
				addmedroot.setBottom(addmediabtns);
				
/////////////////////////////////////////////////////////////////////////////////////////////////////////
				albumttitle.setDisable(true);
				albumtcopies.setDisable(true);
				albumtartist.setDisable(true);
				albumtsongs.setDisable(true);
				
				gamettitle.setDisable(true);
				gametcopies.setDisable(true);
				gametweight.setDisable(true);
				
				moviettitle.setDisable(true);
				movietcopies.setDisable(true);
				moviecrating.setDisable(true);
				
				albuminfo.setVisible(false);
				gameinfo.setVisible(false);
				movieinfo.setVisible(false);
				addmed.setDisable(true);
/////////////////////////////////////////////////////////////////////////////////////////////////////////
				///album
				albumtcode.setOnAction(e->{
					if(albumtcode.getText()!=null && albumtcode.getText() !="") albumttitle.setDisable(false);
					albumttitle.requestFocus();	
				});
				albumttitle.setOnAction(e->{
					if(albumttitle.getText()!=null && albumttitle.getText() !="")	albumtcopies.setDisable(false);
					albumtcopies.requestFocus();	
				});
				
				albumtcopies.setOnAction(e->{
					if(albumtcopies.getText()!=null && albumtcopies.getText() !="")	albumtartist.setDisable(false);
					albumtartist.requestFocus();	
				});
				albumtartist.setOnAction(e->{
					if(albumtartist.getText()!=null && albumtartist.getText() !="")	albumtsongs.setDisable(false);
					albumtsongs.requestFocus();	
				});
				albumtsongs.setOnAction(e->{
					if(albumtsongs.getText()!=null && albumtsongs.getText() !="") addmed.setDisable(false);
					addmed.requestFocus();	
				});
                //////////game
				gametcode.setOnAction(e->{
					if(gametcode.getText()!=null && gametcode.getText() !="") gamettitle.setDisable(false);
					gamettitle.requestFocus();	
				});
				gamettitle.setOnAction(e->{
					if(gamettitle.getText()!=null && gamettitle.getText() !="")	gametcopies.setDisable(false);
					gametcopies.requestFocus();	
				});
				
				gametcopies.setOnAction(e->{
					if(gametcopies.getText()!=null && gametcopies.getText() !="")	gametweight.setDisable(false);
					gametweight.requestFocus();	
				});
				gametweight.setOnAction(e->{
					if(gametweight.getText()!=null && gametweight.getText() !="")addmed.setDisable(false);
					addmed.requestFocus();	
				});
				/////////////movie
				movietcode.setOnAction(e->{
					if(movietcode.getText()!=null && movietcode.getText() !="") moviettitle.setDisable(false);
					moviettitle.requestFocus();	
				});
				moviettitle.setOnAction(e->{
					if(moviettitle.getText()!=null && moviettitle.getText() !="")	movietcopies.setDisable(false);
					movietcopies.requestFocus();	
				});
				
				movietcopies.setOnAction(e->{
					if(movietcopies.getText()!=null && movietcopies.getText() !="")	moviecrating.setDisable(false);
					moviecrating.requestFocus();	
				});
				moviecrating.setOnAction(e->{
					if(moviecrating.getValue() != null && moviecrating.getValue() != "") addmed.setDisable(false);
					addmed.requestFocus();
				});
                ////////
				mediaCtypes.setOnAction(e->{
					if(mediaCtypes.getValue()=="Album") {
						albuminfo.setVisible(true);
						movieinfo.setVisible(false);
						gameinfo.setVisible(false);
						
						albumttitle.setDisable(true);
						albumtcopies.setDisable(true);
						albumtartist.setDisable(true);
						albumtsongs.setDisable(true);
						
						gamettitle.setDisable(true);
						gametcopies.setDisable(true);
						gametweight.setDisable(true);
						
						moviettitle.setDisable(true);
						movietcopies.setDisable(true);
						moviecrating.setDisable(true);
						
						albumtcode.setText("");
						albumttitle.setText("");
						albumtcopies.setText("");
						albumtartist.setText("");
						albumtsongs.setText("");
						
						gametcode.setText("");
						gamettitle.setText("");
						gametcopies.setText("");
						gametweight.setText("");
						
						movietcode.setText("");
						moviettitle.setText("");
						movietcopies.setText("");
						moviecrating.setValue("");
						
						albumtcode.setStyle("-fx-font-size:20px");
						albumtcode.setPromptText("");
						gametcode.setStyle("-fx-font-size:20px");
						gametcode.setPromptText("");
						movietcode.setStyle("-fx-font-size:20px");
						movietcode.setPromptText("");
						
																		
						addmed.setDisable(true);
					}
					if(mediaCtypes.getValue()=="Movie") {
						albuminfo.setVisible(false);
						movieinfo.setVisible(true);
						gameinfo.setVisible(false);
						
						albumttitle.setDisable(true);
						albumtcopies.setDisable(true);
						albumtartist.setDisable(true);
						albumtsongs.setDisable(true);
						
						gamettitle.setDisable(true);
						gametcopies.setDisable(true);
						gametweight.setDisable(true);
						
						moviettitle.setDisable(true);
						movietcopies.setDisable(true);
						moviecrating.setDisable(true);
						
						albumtcode.setText("");
						albumttitle.setText("");
						albumtcopies.setText("");
						albumtartist.setText("");
						albumtsongs.setText("");
						
						gametcode.setText("");
						gamettitle.setText("");
						gametcopies.setText("");
						gametweight.setText("");
						
						movietcode.setText("");
						moviettitle.setText("");
						movietcopies.setText("");
						moviecrating.setValue("");
						
						albumtcode.setStyle("-fx-font-size:20px");
						albumtcode.setPromptText("");
						gametcode.setStyle("-fx-font-size:20px");
						gametcode.setPromptText("");
						movietcode.setStyle("-fx-font-size:20px");
						movietcode.setPromptText("");
						
						
						addmed.setDisable(true);
					}
					if(mediaCtypes.getValue()=="Game") {
						albuminfo.setVisible(false);
						movieinfo.setVisible(false);
						gameinfo.setVisible(true);
						
						albumttitle.setDisable(true);
						albumtcopies.setDisable(true);
						albumtartist.setDisable(true);
						albumtsongs.setDisable(true);
						
						gamettitle.setDisable(true);
						gametcopies.setDisable(true);
						gametweight.setDisable(true);
						
						moviettitle.setDisable(true);
						movietcopies.setDisable(true);
						moviecrating.setDisable(true);
						
						albumtcode.setText("");
						albumttitle.setText("");
						albumtcopies.setText("");
						albumtartist.setText("");
						albumtsongs.setText("");
						
						gametcode.setText("");
						gamettitle.setText("");
						gametcopies.setText("");
						gametweight.setText("");
						
						movietcode.setText("");
						moviettitle.setText("");
						movietcopies.setText("");
						moviecrating.setValue("");
						
						albumtcode.setStyle("-fx-font-size:20px");
						albumtcode.setPromptText("");
						gametcode.setStyle("-fx-font-size:20px");
						gametcode.setPromptText("");
						movietcode.setStyle("-fx-font-size:20px");
						movietcode.setPromptText("");
						
						addmed.setDisable(true);
					}

				});
				
				addmed.setOnAction(e->{
					if(albuminfo.isVisible()) {
						int code=Integer.parseInt(albumtcode.getText());
						String title=albumttitle.getText();
						int copies=Integer.parseInt(albumtcopies.getText());
						String artist=albumtartist.getText();
						String songs=albumtsongs.getText();
						
						if(mRental.findmediaCode(code)==null) {
							mRental.addAlbum(title, copies, artist, songs, code);
							albumtcode.setStyle("-fx-font-size:20px");
							albumtcode.setPromptText("");
						}else {
							albumtcode.setStyle("-fx-border-color:red;-fx-font-size:20px");
							albumtcode.setPromptText("Code Exists!");
						}
						
					}
					if(gameinfo.isVisible()) {
						int code=Integer.parseInt(gametcode.getText());
						String title=gamettitle.getText();
						int copies=Integer.parseInt(gametcopies.getText());
						double weight=Double.parseDouble(gametweight.getText());
						if(mRental.findmediaCode(code)==null) {
							mRental.addGame(title, copies, weight, code);
							gametcode.setStyle("-fx-font-size:20px");
							gametcode.setPromptText("");
						}else {
							gametcode.setStyle("-fx-border-color:red;-fx-font-size:20px");
							gametcode.setPromptText("Code Exists!");
						}
						
						
					}
					if(movieinfo.isVisible()) {
						int code=Integer.parseInt(movietcode.getText());
						String title=moviettitle.getText();
						int copies=Integer.parseInt(movietcopies.getText());
						String rating=moviecrating.getValue();
						if(mRental.findmediaCode(code)==null) {
							mRental.addMovie(title, copies, rating, code);
							movietcode.setStyle("-fx-font-size:20px");
							movietcode.setPromptText("");
						}else {
							movietcode.setStyle("-fx-border-color:red;-fx-font-size:20px");
							movietcode.setPromptText("Code Exists!");
						}
						
						
					}
					albumtcode.setText("");
					albumttitle.setText("");
					albumtcopies.setText("");
					albumtartist.setText("");
					albumtsongs.setText("");
					albumtcode.setStyle("-fx-font-size:20px");
					gametcode.setText("");
					gamettitle.setText("");
					gametcopies.setText("");
					gametweight.setText("");
					gametcode.setStyle("-fx-font-size:20px");

					movietcode.setText("");
					moviettitle.setText("");
					movietcopies.setText("");
					moviecrating.setValue("");
					moviecrating.setStyle("-fx-font-size:20px");
					
					albumttitle.setDisable(true);
					albumtcopies.setDisable(true);
					albumtartist.setDisable(true);
					albumtsongs.setDisable(true);
					
					gamettitle.setDisable(true);
					gametcopies.setDisable(true);
					gametweight.setDisable(true);
					
					moviettitle.setDisable(true);
					movietcopies.setDisable(true);
					moviecrating.setDisable(true);
					
					
					addmed.setDisable(true);
					
				});
				backmed.setOnAction(e->{
					albumtcode.setText("");
					albumttitle.setText("");
					albumtcopies.setText("");
					albumtartist.setText("");
					albumtsongs.setText("");
					
					gametcode.setText("");
					gamettitle.setText("");
					gametcopies.setText("");
					gametweight.setText("");
					
					movietcode.setText("");
					moviettitle.setText("");
					movietcopies.setText("");
					moviecrating.setValue("");
					
					albumttitle.setDisable(true);
					albumtcopies.setDisable(true);
					albumtartist.setDisable(true);
					albumtsongs.setDisable(true);
					
					gamettitle.setDisable(true);
					gametcopies.setDisable(true);
					gametweight.setDisable(true);
					
					moviettitle.setDisable(true);
					movietcopies.setDisable(true);
					moviecrating.setDisable(true);
					
					albuminfo.setVisible(false);
					gameinfo.setVisible(false);
					movieinfo.setVisible(false);
					addmed.setDisable(true);
					mediaCtypes.setValue("");
					mediaCtypes.setPromptText("Select the Media Type");
					primaryStage.setScene(mediascene);
				});
				
				Scene addmediascene=new Scene(addmedroot,1500,750);
			/////
				addMedia.setOnAction(e->{
					primaryStage.setScene(addmediascene);
				});
////////////////////////////////////////////////////////////////////////////////////////////////deletemedia-scene
				 BorderPane delmediaroot= new BorderPane();
					
					HBox delmbtns=new HBox();
					delmbtns.setAlignment(Pos.CENTER);
					delmbtns.setSpacing(100);
					
					Button deletem=new Button();
					Button finddelm=new Button();
					Button backdelm=new Button();
					
					ImageView delmimage = new ImageView(new Image("C:\\Users\\Abood\\Desktop\\New folder\\delete.png"));
					delmimage.setFitWidth(50);
					delmimage.setFitHeight(50);
					deletem.setGraphic(delmimage);
								
					ImageView fingmimage = new ImageView(new Image("C:\\Users\\Abood\\Desktop\\New folder\\find.png"));
					fingmimage.setFitWidth(50);
					fingmimage.setFitHeight(50);
					finddelm.setGraphic(fingmimage);
					ImageView backmimdel = new ImageView(new Image("C:\\Users\\Abood\\Desktop\\New folder\\back.png"));
					backmimdel.setFitWidth(50);
					backmimdel.setFitHeight(50);
					backdelm.setGraphic(backimdel);
					
					delmbtns.getChildren().addAll(finddelm,deletem);
					
					GridPane centermdel=new GridPane();
					centermdel.setAlignment(Pos.CENTER);
					centermdel.setVgap(40);
					centermdel.setHgap(40);
					
					Label codeldel=new Label("Media Code:");
					Label allmedinfoldel=new Label("Media Info:");
					codeldel.setStyle("-fx-font-size:40px");
					allmedinfoldel.setStyle("-fx-font-size:40px");
			
					TextField codetdel=new TextField();
					TextField Allmediainfotdel=new TextField();
					
					
					codetdel.setStyle("-fx-font-size:20px");
					
					Allmediainfotdel.setPromptText("Media Info will appear here");
					Allmediainfotdel.setMinSize(500,100);
					Allmediainfotdel.setStyle("-fx-font-size:20px");
				    Allmediainfotdel.setEditable(false);
				    
				    
				    centermdel.add(codeldel, 0, 0);centermdel.add(codetdel, 1, 0);
				    centermdel.add(allmedinfoldel, 0, 1);centermdel.add(Allmediainfotdel, 1, 1);
				    centermdel.add(delmbtns, 1, 4);centermdel.add(backdelm, 2, 4);

					
					
				    delmediaroot.setCenter(centermdel);
				    
					deletem.setDisable(true);
					finddelm.setDisable(true);
					
					codetdel.setOnAction(e->{
						if(codetdel.getText()!=null && codetdel.getText()!="")finddelm.setDisable(false);
						finddelm.requestFocus();
					});

					finddelm.setOnAction(e->{
						int code=Integer.parseInt(codetdel.getText());
						if(mRental.findmediaCode(code)!=null) {
							Allmediainfotdel.setText(mRental.getMediaInfo(code));
							deletem.setDisable(false);
						}else {
							Allmediainfotdel.setText("Media Not Found!");
						}
						
					});
					
					
					deletem.setOnAction(e->{
						int code = Integer.parseInt(codetdel.getText());
						if(mRental.removeFromMedia(code)) {
							Allmediainfotdel.setText("Media Deleted!");
						}
					});
				
					backdelm.setOnAction(e->{
						deletem.setDisable(true);
						finddelm.setDisable(true);
						codetdel.setText("");
						Allmediainfotdel.setText("");
						primaryStage.setScene(mediascene);
					});
				    
				    Scene delmedScene=new Scene(delmediaroot,1500,750);
				    delMedia.setOnAction(e->{
						primaryStage.setScene(delmedScene);
					});
				    ////////////////////////////////////////////////////////////////////////updatemedia-scene
				    BorderPane updmedroot=new BorderPane();
				    updmedroot.setPadding(new Insets(50));
				 
				    VBox centerrootupd=new VBox();
				    centerrootupd.setAlignment(Pos.CENTER);
				    centerrootupd.setSpacing(50);
				    
				    GridPane searchmedupdate=new GridPane();
				    searchmedupdate.setAlignment(Pos.CENTER);
				    searchmedupdate.setVgap(40);
				    searchmedupdate.setHgap(40);
				    
				    Label codelupd=new Label("Media Code:");
				    Label allmedinfolupd=new Label("Media Info:");
				    
				    codelupd.setStyle("-fx-font-size:40px");
				    allmedinfolupd.setStyle("-fx-font-size:40px");
				    
				    TextField codetupd=new TextField();
					TextField Allmediainfotupd=new TextField();
					
					codetupd.setStyle("-fx-font-size:20px");
					Allmediainfotupd.setPromptText("Media Info will appear here");
					Allmediainfotupd.setMinSize(500,100);
					Allmediainfotupd.setStyle("-fx-font-size:20px");
					Allmediainfotupd.setEditable(false);
					
					searchmedupdate.add(codelupd, 0, 0);searchmedupdate.add(codetupd, 1, 0);
					searchmedupdate.add(allmedinfolupd, 0, 1);searchmedupdate.add(Allmediainfotupd, 1, 1);
					
					StackPane centerupd=new StackPane();
					//
					//////////////////////////////////////////game
					GridPane gameupd=new GridPane();
					gameupd.setAlignment(Pos.CENTER);
					gameupd.setVgap(40);
					gameupd.setHgap(40);
					
					Label gametitlelupd=new Label("New Game Title");
					Label gamenocopieslupd=new Label("New Number Of Copies");
					Label gamewieghtlupd=new Label ("New Game Weight");
					
					gametitlelupd.setStyle("-fx-font-size:40px");
					gamenocopieslupd.setStyle("-fx-font-size:40px");
					gamewieghtlupd.setStyle("-fx-font-size:40px");
					
					TextField gametitletupd=new TextField();
					TextField gamenocopiestupd=new TextField();
					TextField gamewieghttupd=new TextField();
					
					gametitletupd.setStyle("-fx-font-size:20px");
					gamenocopiestupd.setStyle("-fx-font-size:20px");
					gamewieghttupd.setStyle("-fx-font-size:20px");
					
					gameupd.add(gametitlelupd, 0, 0); gameupd.add(gamenocopieslupd, 1, 0); gameupd.add(gamewieghtlupd,2, 0);
					gameupd.add(gametitletupd, 0, 1); gameupd.add(gamenocopiestupd, 1, 1); gameupd.add(gamewieghttupd,2, 1);
					///////////////////////////////////////////album
					GridPane albumupd=new GridPane();
					albumupd.setAlignment(Pos.CENTER);
					albumupd.setVgap(40);
					albumupd.setHgap(40);
					
					Label albumtitlelupd=new Label("New Album Title");
					Label albumnocopieslupd=new Label("New Number Of Copies");
					Label albumartistlupd=new Label ("New Album Artist");
					Label albumsonglupd=new Label ("New Album Songs");
					albumtitlelupd.setStyle("-fx-font-size:30px");
					albumnocopieslupd.setStyle("-fx-font-size:30px");
					albumartistlupd.setStyle("-fx-font-size:30px");
					albumsonglupd.setStyle("-fx-font-size:30px");
					
					TextField albumtitletupd=new TextField();
					TextField albumnocopiestupd=new TextField();
					TextField albumartisttupd=new TextField();
					TextField albumsongtupd=new TextField();
					albumtitletupd.setStyle("-fx-font-size:20px");
					albumnocopiestupd.setStyle("-fx-font-size:20px");
					albumartisttupd.setStyle("-fx-font-size:20px");
					albumsongtupd.setStyle("-fx-font-size:20px");
					
					albumupd.add(albumtitlelupd, 0, 0);albumupd.add(albumnocopieslupd, 1, 0);albumupd.add(albumartistlupd, 2, 0);albumupd.add(albumsonglupd, 3, 0);
					albumupd.add(albumtitletupd, 0, 1);albumupd.add(albumnocopiestupd, 1, 1);albumupd.add(albumartisttupd, 2, 1);albumupd.add(albumsongtupd, 3, 1);
					////////////////////////////////////Movie
					GridPane movieupd=new GridPane();
					movieupd.setAlignment(Pos.CENTER);
					movieupd.setVgap(40);
					movieupd.setHgap(40);
					
					Label movietitlelupd=new Label("New Movie Title");
					Label movienocopieslupd=new Label("New Number Of Copies");
					Label movieratinglupd=new Label("New Movie Rating");
					movietitlelupd.setStyle("-fx-font-size:40px");
					movienocopieslupd.setStyle("-fx-font-size:40px");
					movieratinglupd.setStyle("-fx-font-size:40px");
					
					TextField movietitletupd=new TextField();
					TextField movienocopiestupd=new TextField();
					movietitletupd.setStyle("-fx-font-size:20px");
					movienocopiestupd.setStyle("-fx-font-size:20px");
					ComboBox<String> moviecratingupd=new ComboBox<String>();
					moviecratingupd.getItems().add("DR");
					moviecratingupd.getItems().add("HR");
					moviecratingupd.getItems().add("AC");
					moviecratingupd.setStyle("-fx-font-size:20px");
					
					movieupd.add(movietitlelupd, 0, 0);movieupd.add(movienocopieslupd, 1, 0);movieupd.add(movieratinglupd, 2, 0);
					movieupd.add(movietitletupd, 0, 1);movieupd.add(movienocopiestupd, 1, 1);movieupd.add(moviecratingupd, 2, 1);

					
					centerupd.getChildren().addAll(movieupd,albumupd,gameupd);
					
					//
					centerrootupd.getChildren().addAll(searchmedupdate,centerupd);
					//
					
					HBox btnsupd=new HBox();
					btnsupd.setSpacing(150);
					btnsupd.setAlignment(Pos.CENTER);
					
					Button findmedupd=new Button();
					Button backmedupd=new Button();
					Button updatemedupd=new Button();
					
					ImageView findmedview = new ImageView(new Image("C:\\Users\\Abood\\Desktop\\New folder\\find.png"));
					findmedview.setFitWidth(50);
					findmedview.setFitHeight(50);
					findmedupd.setGraphic(fingimageupd);
					
					ImageView backmedview = new ImageView(new Image("C:\\Users\\Abood\\Desktop\\New folder\\back.png"));
					backmedview.setFitWidth(50);
					backmedview.setFitHeight(50);
					backmedupd.setGraphic(backimupd);
					
					ImageView updatemedview = new ImageView(new Image("C:\\Users\\Abood\\Desktop\\New folder\\edit.jpg"));
					updatemedview.setFitWidth(50);
					updatemedview.setFitHeight(50);
					updatemedupd.setGraphic(editimupd);
					
					btnsupd.getChildren().addAll(updatemedupd,findmedupd,backmedupd);
					updmedroot.setBottom(btnsupd);
					updmedroot.setCenter(centerrootupd);
					

					albumupd.setVisible(false);
					gameupd.setVisible(false);
					movieupd.setVisible(false);
					findmedupd.setDisable(true);
					updatemedupd.setDisable(true);
					
					
					codetupd.setOnAction(e->{
						if(codetupd.getText()!=null && codetupd.getText()!="")findmedupd.setDisable(false);
						findmedupd.requestFocus();
					});
					
					findmedupd.setOnAction(e->{
						int code=Integer.parseInt(codetupd.getText());
						if(mRental.findmediaCode(code)!=null) {
							updatemedupd.setDisable(false);
							Allmediainfotupd.setText(mRental.getMediaInfo(code));
							if(mRental.findmediaCode(code).getType().toLowerCase().trim().equals("game")) {
								albumupd.setVisible(false);
								gameupd.setVisible(true);
								movieupd.setVisible(false);
								
								gametitletupd.setText("");
								gamenocopiestupd.setText("");
								gamewieghttupd.setText("");
								albumtitletupd.setText("");
								albumnocopiestupd.setText("");
								albumartisttupd.setText("");
								albumsongtupd.setText("");
								movietitletupd.setText("");
								movienocopiestupd.setText("");
								moviecratingupd.setValue("");
								
							}else if(mRental.findmediaCode(code).getType().toLowerCase().trim().equals("album")) {
								albumupd.setVisible(true);
								gameupd.setVisible(false);
								movieupd.setVisible(false);
								
								gametitletupd.setText("");
								gamenocopiestupd.setText("");
								gamewieghttupd.setText("");
								albumtitletupd.setText("");
								albumnocopiestupd.setText("");
								albumartisttupd.setText("");
								albumsongtupd.setText("");
								movietitletupd.setText("");
								movienocopiestupd.setText("");
								moviecratingupd.setValue("");
							}else {
								albumupd.setVisible(false);
								gameupd.setVisible(false);
								movieupd.setVisible(true);
								
								gametitletupd.setText("");
								gamenocopiestupd.setText("");
								gamewieghttupd.setText("");
								albumtitletupd.setText("");
								albumnocopiestupd.setText("");
								albumartisttupd.setText("");
								albumsongtupd.setText("");
								movietitletupd.setText("");
								movienocopiestupd.setText("");
								moviecratingupd.setValue("");
							}
						}else {
							Allmediainfotupd.setText("Media Not Found!");
							albumupd.setVisible(false);
							gameupd.setVisible(false);
							movieupd.setVisible(false);
							
							gametitletupd.setText("");
							gamenocopiestupd.setText("");
							gamewieghttupd.setText("");
							albumtitletupd.setText("");
							albumnocopiestupd.setText("");
							albumartisttupd.setText("");
							albumsongtupd.setText("");
							movietitletupd.setText("");
							movienocopiestupd.setText("");
							moviecratingupd.setValue("");
						}
					});

					updatemedupd.setOnAction(e->{
						int code=Integer.parseInt(codetupd.getText());
						if(mRental.findmediaCode(code).getType().toLowerCase().trim().equals("game")) {
							String title="";
							int nofcopies;
							double wieght;
							
							if(gametitletupd.getText().trim()==null ||gametitletupd.getText().trim()=="") {
								title=mRental.findmediaCode(code).getTitle();
							}else {
								title=gametitletupd.getText().trim();
							}
							
							if(gamenocopiestupd.getText().trim()==null ||gamenocopiestupd.getText().trim()=="") {
								nofcopies=mRental.findmediaCode(code).getNUMBER_OF_COPIES_AVAILABLE();
							}else {
								nofcopies=Integer.parseInt(gametitletupd.getText());
							}
							
							if(gamewieghttupd.getText().trim()==null ||gamewieghttupd.getText().trim()=="") {
								wieght=((Game)(mRental.findmediaCode(code))).getWeight();
							}else {
								wieght=Double.parseDouble(gamewieghttupd.getText());
							}
							mRental.removeFromMedia(code);
							mRental.addGame(title, nofcopies, wieght, code);
							
							gametitletupd.setText("");
							gamenocopiestupd.setText("");
							gamewieghttupd.setText("");
							
						}else if(mRental.findmediaCode(code).getType().toLowerCase().trim().equals("album")) {
							String title="";
							int nofcopies;
							String songs="";
							String artist="";
							
							if(albumtitletupd.getText().trim()==null ||albumtitletupd.getText().trim()=="") {
								title=mRental.findmediaCode(code).getTitle();
							}else {
								title=albumtitletupd.getText().trim();
							}
							if(albumnocopiestupd.getText().trim()==null ||albumnocopiestupd.getText().trim()=="") {
								nofcopies=mRental.findmediaCode(code).getNUMBER_OF_COPIES_AVAILABLE();
							}else {
								nofcopies=Integer.parseInt(albumnocopiestupd.getText());
							}
							if(albumartisttupd.getText().trim()==null ||albumartisttupd.getText().trim()=="") {
								artist=((Album)(mRental.findmediaCode(code))).getArtist();
							}else {
								artist=albumartisttupd.getText().trim();
							}
							if(albumsongtupd.getText().trim()==null ||albumsongtupd.getText().trim()=="") {
								songs=((Album)(mRental.findmediaCode(code))).getSongs();
							}else {
								songs=albumsongtupd.getText().trim();
							}
							mRental.removeFromMedia(code);
							mRental.addAlbum(title, nofcopies, artist, songs, code);
							
							albumtitletupd.setText("");
							albumnocopiestupd.setText("");
							albumartisttupd.setText("");
							albumsongtupd.setText("");

							
						}else {
							String title="";
							int nofcopies;
							String rating="";
							if(movietitletupd.getText().trim()==null ||movietitletupd.getText().trim()=="") {
								title=mRental.findmediaCode(code).getTitle();
							}else {
								title=movietitletupd.getText().trim();
							}
							if(movienocopiestupd.getText().trim()==null ||movienocopiestupd.getText().trim()=="") {
								nofcopies=mRental.findmediaCode(code).getNUMBER_OF_COPIES_AVAILABLE();
							}else {
								nofcopies=Integer.parseInt(movienocopiestupd.getText());
							}
							if(moviecratingupd.getValue()==null||moviecratingupd.getValue()=="") {
								rating=((Movie)(mRental.findmediaCode(code))).getRating();
							}else {
								rating=moviecratingupd.getValue();
							}
							mRental.removeFromMedia(code);
							mRental.addMovie(title, nofcopies, rating, code);
							
							movietitletupd.setText("");
							movienocopiestupd.setText("");
							moviecratingupd.setValue("");
						}
						
					});
					
					backmedupd.setOnAction(e->{
						albumupd.setVisible(false);
						gameupd.setVisible(false);
						movieupd.setVisible(false);
						findmedupd.setDisable(true);
						updatemedupd.setDisable(true);
						gametitletupd.setText("");
						gamenocopiestupd.setText("");
						gamewieghttupd.setText("");
						albumtitletupd.setText("");
						albumnocopiestupd.setText("");
						albumartisttupd.setText("");
						albumsongtupd.setText("");
						movietitletupd.setText("");
						movienocopiestupd.setText("");
						moviecratingupd.setValue("");
						codetupd.setText("");
						Allmediainfotupd.setText("");
						
						primaryStage.setScene(mediascene);
					});
					
				     Scene updmedScene=new Scene(updmedroot,1500,750);
					 updMedia.setOnAction(e->{
						 primaryStage.setScene(updmedScene);
				     });
					 
				    ////////////////////////////////////////////////////////////////////////searchmedia-scene
				    BorderPane seatchmediaroot= new BorderPane();
					
					HBox searchmbtns=new HBox();
					searchmbtns.setAlignment(Pos.CENTER);
					searchmbtns.setSpacing(100);
					
				
					Button findsearchm=new Button();
					Button backsearchm=new Button();
					
					
								
					ImageView fingmsimage = new ImageView(new Image("C:\\Users\\Abood\\Desktop\\New folder\\find.png"));
					fingmsimage.setFitWidth(50);
					fingmsimage.setFitHeight(50);
					findsearchm.setGraphic(fingmsimage);
					ImageView backmsimsearch = new ImageView(new Image("C:\\Users\\Abood\\Desktop\\New folder\\back.png"));
					backmsimsearch.setFitWidth(50);
					backmsimsearch.setFitHeight(50);
					backsearchm.setGraphic(backmsimsearch);
					
					searchmbtns.getChildren().addAll(findsearchm,backsearchm);
					
					GridPane centermsearch=new GridPane();
					centermsearch.setAlignment(Pos.CENTER);
					centermsearch.setVgap(40);
					centermsearch.setHgap(40);
					
					Label codelsearch=new Label("Media Code:");
					Label allmedinfolsearch=new Label("Media Info:");
					codelsearch.setStyle("-fx-font-size:40px");
					allmedinfolsearch.setStyle("-fx-font-size:40px");
			
					TextField codetsearch=new TextField();
					TextField Allmediainfotsearch=new TextField();
					
					
					codetsearch.setStyle("-fx-font-size:20px");
					
					Allmediainfotsearch.setPromptText("Media Info will appear here");
					Allmediainfotsearch.setMinSize(500,100);
					Allmediainfotsearch.setStyle("-fx-font-size:20px");
					Allmediainfotsearch.setEditable(false);
				    
				    
					centermsearch.add(codelsearch, 0, 0);centermsearch.add(codetsearch, 1, 0);
					centermsearch.add(allmedinfolsearch, 0, 1);centermsearch.add(Allmediainfotsearch, 1, 1);
					centermsearch.add(searchmbtns, 1, 4);
				
				    seatchmediaroot.setCenter(centermsearch);
				    
				    
				    
					findsearchm.setDisable(true);

				    codetsearch.setOnAction(e->{
						if(codetsearch.getText()!=null && codetsearch.getText()!="")findsearchm.setDisable(false);
						findsearchm.requestFocus();
					});

					findsearchm.setOnAction(e->{
						int code=Integer.parseInt(codetsearch.getText());
						if(mRental.findmediaCode(code)!=null) {
							Allmediainfotsearch.setText(mRental.getMediaInfo(code));
						}else {
							Allmediainfotsearch.setText("Media Not Found!");
						}
						
					});
					
					backsearchm.setOnAction(e->{
						findsearchm.setDisable(true);
						codetsearch.setText("");
						Allmediainfotsearch.setText("");
						primaryStage.setScene(mediascene);
					});
				    
				    Scene seachmedScene=new Scene(seatchmediaroot,1500,750);
					   searchMedia.setOnAction(e->{
							primaryStage.setScene(seachmedScene);
						});
				
				    
				    ////////////////////////////////////////////////////////////////////////printallmedia-scene
					   BorderPane printmediaroot=new BorderPane();
					   printmediaroot.setPadding(new Insets(50));
					   
					   
					   Label printallmed=new Label("Print All Media Information");
					   printallmed.setStyle("-fx-font-size:40px");
					   
					   
					   TextArea printallmedt=new TextArea ();
			
					   printallmedt.setPromptText("Media Info will appear here");
					
				
					   printallmedt.setStyle("-fx-font-size:20px");
					   printallmedt.setFocusTraversable(false);
					   printallmedt.setEditable(false);
					   
					   
					   HBox printbtns=new HBox();
					   printbtns.setSpacing(150);
					   printbtns.setAlignment(Pos.CENTER);
					   
					   Button printmed=new Button();
					   Button backpmed=new Button();
					   ImageView printmsimage = new ImageView(new Image("C:\\Users\\Abood\\Desktop\\New folder\\print.png"));
					   printmsimage.setFitWidth(50);
					   printmsimage.setFitHeight(50);
					   printmed.setGraphic(printmsimage);
					   
					   ImageView backmsimprint = new ImageView(new Image("C:\\Users\\Abood\\Desktop\\New folder\\back.png"));
					   backmsimprint.setFitWidth(50);
					   backmsimprint.setFitHeight(50);
					   backpmed.setGraphic(backmsimprint);
				        
					   printbtns.getChildren().addAll(printmed,backpmed);
				       
					   printmediaroot.setTop(printallmed);
					   printmediaroot.setCenter(printallmedt);
					   printmediaroot.setBottom(printbtns);
					   
					   printmediaroot.setAlignment(printallmed, Pos.CENTER);
					   printmediaroot.setAlignment(printallmedt, Pos.CENTER);
					   printmediaroot.setAlignment(printbtns, Pos.BOTTOM_CENTER);
					   
					   
					   printmed.setOnAction(e->{
						   if( mRental.getAllMediaInfo()!="") 
						   printallmedt.setText(mRental.getAllMediaInfo());
						   else printallmedt.setText("There is no Media!");
					   });
					   
					   backpmed.setOnAction(e->{
						   printallmedt.setText("");
						   primaryStage.setScene(mediascene);
					   });
					   
					   Scene printmedScene=new Scene(printmediaroot,1500,750);
					   printMedia.setOnAction(e->{
							primaryStage.setScene(printmedScene);
						});
					   ///////////////////////////
					   returntomainn.setOnAction(e->{
							primaryStage.setScene(mainscene);
						});
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////RENT SCENE
					   VBox rentroot=new VBox();
					   
					   rentroot.setAlignment(Pos.CENTER);
					   rentroot.setSpacing(50);
					   rentroot.setPadding(new Insets(50));
					   rentroot.setPrefWidth(700);
						
					   Button rentmediamain=new Button("Rent Media");
					   Button printintrested=new Button("Print Requested Intrested Media");
					   Button printrented=new Button("Print Rented Media");
					   Button returnmedia=new Button("Return Rented Media");
					   Button returntomainpagee=new Button("Return To Main Page");
					   
					   rentmediamain.setFont(Font.font("Times new Roman", FontWeight.BOLD, FontPosture.REGULAR, 40));
					   printintrested.setFont(Font.font("Times new Roman", FontWeight.BOLD, FontPosture.REGULAR, 40));
					   printrented.setFont(Font.font("Times new Roman", FontWeight.BOLD, FontPosture.REGULAR, 40));
					   returnmedia.setFont(Font.font("Times new Roman", FontWeight.BOLD, FontPosture.REGULAR, 40));
					   returntomainpagee.setFont(Font.font("Times new Roman", FontWeight.BOLD, FontPosture.REGULAR, 40));
					   
					   rentmediamain.setMinWidth(rentroot.getPrefWidth());
					   printintrested.setMinWidth(rentroot.getPrefWidth());
					   printrented.setMinWidth(rentroot.getPrefWidth());
					   returnmedia.setMinWidth(rentroot.getPrefWidth());
					   returntomainpagee.setMinWidth(rentroot.getPrefWidth());

					   
					   
					   rentroot.getChildren().addAll(rentmediamain,printintrested,printrented,returnmedia,returntomainpagee);
					   
					   
					   Scene rentmediaScene=new Scene(rentroot,1500,750);
					   rent.setOnAction(e->{
						   primaryStage.setScene(rentmediaScene);
					   });
				   
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////rent media scene
					   BorderPane rentmediaroot=new BorderPane();
					
					   
					   GridPane customermediainfo=new GridPane();
					   customermediainfo.setAlignment(Pos.CENTER);
					   customermediainfo.setVgap(40);
					   customermediainfo.setHgap(40);
					   
					   Label custidlrent=new Label("Customer ID:");
					   Label mediacodelrent=new Label("Media Code:");
					   Label rentedldate=new Label("Rented Date:");
					   
					   custidlrent.setStyle("-fx-font-size:40px");
					   mediacodelrent.setStyle("-fx-font-size:40px");
					   rentedldate.setStyle("-fx-font-size:40px");
					   
					   TextField custidtrent=new TextField();
					   TextField mediacodetrent=new TextField();
					   TextField rentedtdate=new TextField();
					   
					   custidtrent.setStyle("-fx-font-size:20px");
					   mediacodetrent.setStyle("-fx-font-size:20px");
					   rentedtdate.setStyle("-fx-font-size:20px");
					   rentedtdate.setEditable(false);
					   
					   TextField custinforent=new TextField();
					   TextField mediainforent=new TextField();
					   
					   custinforent.setPromptText("Customer Info Will Appear Here");
					   custinforent.setMinSize(500, 100);
					   custinforent.setStyle("-fx-font-size:20px");
					   custinforent.setEditable(false);
					   
					   mediainforent.setPromptText("Media Info Will Appear Here");
					   mediainforent.setMinSize(500, 100);
					   mediainforent.setStyle("-fx-font-size:20px");
					   mediainforent.setEditable(false);
					   
					   
					   
					   customermediainfo.add(custidlrent, 0, 0);customermediainfo.add(custidtrent, 1, 0);
					   customermediainfo.add(custinforent, 1, 1);
					   customermediainfo.add(mediacodelrent, 0, 2);customermediainfo.add(mediacodetrent, 1, 2);
					   customermediainfo.add(mediainforent, 1, 3);
					   customermediainfo.add(rentedldate, 0, 4);customermediainfo.add(rentedtdate, 1, 4);
					   

					   HBox cartbtns=new HBox();
					   cartbtns.setPadding(new Insets(150));
					   cartbtns.setAlignment(Pos.CENTER);
					   cartbtns.setSpacing(50);
					   
					   Button addtocart=new Button("Add to Cart");
					   Button removefromocart=new Button("Remove From Cart");
					   Button Proccess=new Button("Process Cart");
					   Button searchcust=new Button("Find Customer");
					   Button searchmedia=new Button("Find Media");
					   Button Backtorentscene=new Button();
					   
					   ImageView backtorentview = new ImageView(new Image("C:\\Users\\Abood\\Desktop\\New folder\\back.png"));
                       backtorentview.setFitWidth(50);
                       backtorentview.setFitHeight(50);
                       Backtorentscene.setGraphic(backtorentview);
					   
					   
					   addtocart.setStyle("-fx-font-size:20px");
					   removefromocart.setStyle("-fx-font-size:20px");
					   Proccess.setStyle("-fx-font-size:20px");
					   searchcust.setStyle("-fx-font-size:20px");
					   searchmedia.setStyle("-fx-font-size:20px");
					   
					   cartbtns.getChildren().addAll(addtocart,removefromocart,Proccess,searchcust,searchmedia,Backtorentscene);

					   rentmediaroot.setBottom(cartbtns);
					   rentmediaroot.setCenter(customermediainfo);
					   
					   searchcust.setDisable(true);
					   searchmedia.setDisable(true);
					   addtocart.setDisable(true);
					   removefromocart.setDisable(true);
					   //Proccess.setDisable(true);
					   
					   custidtrent.setOnAction(e->{
						   if(custidtrent.getText()!=null && custidtrent.getText()!="")searchcust.setDisable(false);
						   searchcust.requestFocus();
					   });
					   searchcust.setOnAction(e->{
						   int id=Integer.parseInt(custidtrent.getText());
						   if(mRental.findcustomerid(id)!=null) {
							   custinforent.setText(mRental.getAllInfoCustomer(id));
						   }else {
							   custinforent.setText("Customer Not Found");
						   }
					   });
					   
					   mediacodetrent.setOnAction(e->{
						   if(mediacodetrent.getText()!=null && mediacodetrent.getText()!="") {
							   searchmedia.setDisable(false);
							   
						   }
						   searchmedia.requestFocus();
						   
					   });
					   searchmedia.setOnAction(e->{
						   int code=Integer.parseInt(mediacodetrent.getText());
						   if(mRental.findmediaCode(code)!=null) {
							   mediainforent.setText(mRental.getMediaInfo(code));
							   addtocart.setDisable(false);
							   removefromocart.setDisable(false); 
						   }else {
							   mediainforent.setText("Media Not Found");
							   
						   }
					   });
					   addtocart.setOnAction(e->{
						   int id=Integer.parseInt(custidtrent.getText());
						   int code=Integer.parseInt(mediacodetrent.getText());
						   if(mRental.addToCart(id, code)) {
							   Proccess.setDisable(false);
							   mediacodetrent.setText("");
							   mediainforent.setText("");
						   }
						   

					   });
					   removefromocart.setOnAction(e->{
						   int id=Integer.parseInt(custidtrent.getText());
						   int code=Integer.parseInt(mediacodetrent.getText());
						   if(mRental.removeFromCart(id, code)) {
							   mediainforent.setText("Removed from your cart Successfuly!");
							   mediacodetrent.setText("");
						   }else {
							   mediainforent.setText("An Error Occured!");
							   mediacodetrent.setText("");
						   }
					   });
					   
					   Proccess.setOnAction(e->{
						  
						   String info=mRental.ProcessRequests();
						   mediainforent.setText(info);
						   SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");  //no need to parseException since we just parse from date to text.
						   Date date=new Date();
						   rentedtdate.setText(formatter.format(date));
					
						   int id=Integer.parseInt(custidtrent.getText());
						   mRental.clearReq(id);
						
					   });
					   
					   
					   Backtorentscene.setOnAction(e->{
						   searchcust.setDisable(true);
						   searchmedia.setDisable(true);
						   addtocart.setDisable(true);
						   removefromocart.setDisable(true);
						   //Proccess.setDisable(true);
						   
						   mediacodetrent.setText("");
						   mediainforent.setText("");
						   custinforent.setText("");
						   //custidtrent.setText("");
						   rentedtdate.setText("");
						   
						   primaryStage.setScene(rentmediaScene);
					   });
					   
					   
					  
					   Scene rentmediascene=new Scene(rentmediaroot,1500,750);
					   rentmediamain.setOnAction(e->{
						   primaryStage.setScene(rentmediascene);
					   });
/////////////////////////////////////////////////////////////////////////////////////print requested media scene
					   BorderPane printrequestroot=new BorderPane();
					   printrequestroot.setPadding(new Insets(50));
					   
					   HBox topinfo=new HBox();
					   topinfo.setAlignment(Pos.CENTER);
					   topinfo.setSpacing(50);
					   
					   Label custidprintlreq=new Label("Customer Id:");
					   TextField custidprinttreq=new TextField();
					   
					   custidprintlreq.setStyle("-fx-font-size:40px");
					   custidprinttreq.setStyle("-fx-font-size:20px");
					   
					   topinfo.getChildren().addAll(custidprintlreq,custidprinttreq);
					   
					   
					   
					   TextArea printreq=new TextArea ();
					   printreq.setPromptText("Requested Media Info will appear here");
					   printreq.setStyle("-fx-font-size:20px");
					   printreq.setFocusTraversable(false);
					   printreq.setEditable(false);
					   
					   HBox downinfo=new HBox();
					   downinfo.setAlignment(Pos.CENTER);
					   downinfo.setSpacing(50);
					   
					   Button searchprint=new Button();
                       Button backprint=new Button();
					   
					   ImageView backprintview = new ImageView(new Image("C:\\Users\\Abood\\Desktop\\New folder\\back.png"));
					   backprintview.setFitWidth(50);
					   backprintview.setFitHeight(50);
                       backprint.setGraphic(backprintview);
                       
                       ImageView searchprintview = new ImageView(new Image("C:\\Users\\Abood\\Desktop\\New folder\\print.png"));
                       searchprintview.setFitWidth(50);
                       searchprintview.setFitHeight(50);
                       searchprint.setGraphic(searchprintview);
					   
                       downinfo.getChildren().addAll(searchprint,backprint);
					   
					   printrequestroot.setTop(topinfo);
					   printrequestroot.setBottom(downinfo);
					   printrequestroot.setCenter(printreq);
					   
					   
					   
					   searchprint.setOnAction(e->{
						   if(custidprinttreq.getText()!=null&&custidprinttreq.getText()!="") {
							   int id = Integer.parseInt(custidprinttreq.getText());
							   printreq.setText(mRental.PrintRequestedMedia(id));
						   }
						  
						   
					   });
					   
					   
					   backprint.setOnAction(e->{
						   primaryStage.setScene(rentmediaScene);
						   printreq.setText("");
						   custidprinttreq.setText("");
						   
					   });
					   
					   Scene printreqscene=new Scene(printrequestroot,1500,750);
					   printintrested.setOnAction(e->{
						   primaryStage.setScene(printreqscene);
					   });
					   
/////////////////////////////////////////////////////////////////////////////////////print rented  media scene
					   BorderPane printrentedmed=new BorderPane();
					   printrentedmed.setPadding(new Insets(50));
					   
					   HBox topinforent=new HBox();
					   topinforent.setAlignment(Pos.CENTER);
					   topinforent.setSpacing(50);
					   
					   Label custidprintlrent=new Label("Customer Id:");
					   TextField custidprinttrent=new TextField();
					   
					   custidprintlrent.setStyle("-fx-font-size:40px");
					   custidprinttrent.setStyle("-fx-font-size:20px");
					   
					   topinforent.getChildren().addAll(custidprintlrent,custidprinttrent);
					   
					   
					   TextArea printrent=new TextArea ();
					   printrent.setPromptText("Rented Media Info will appear here");
					   printrent.setStyle("-fx-font-size:20px");
					   printrent.setFocusTraversable(false);
					   printrent.setEditable(false);
					   
					   HBox downinforent=new HBox();
					   downinforent.setAlignment(Pos.CENTER);
					   downinforent.setSpacing(50);
					   
					   Button searchprintrent=new Button();
                       Button backprintrent=new Button();
					   
					   ImageView backprintrentview = new ImageView(new Image("C:\\Users\\Abood\\Desktop\\New folder\\back.png"));
					   backprintrentview.setFitWidth(50);
					   backprintrentview.setFitHeight(50);
					   backprintrent.setGraphic(backprintrentview);
                       
                       ImageView searchprintrentview = new ImageView(new Image("C:\\Users\\Abood\\Desktop\\New folder\\print.png"));
                       searchprintrentview.setFitWidth(50);
                       searchprintrentview.setFitHeight(50);
                       searchprintrent.setGraphic(searchprintrentview);
					   
                       downinforent.getChildren().addAll(searchprintrent,backprintrent);
					   
					   
					   
					   
					   printrentedmed.setTop(topinforent);
					   printrentedmed.setCenter(printrent);
					   printrentedmed.setBottom(downinforent);
					   
					   searchprintrent.setOnAction(e->{
						   if(custidprinttrent.getText()!=null&&custidprinttrent.getText()!="") {
							   int id=Integer.parseInt(custidprinttrent.getText());
							   printrent.setText(mRental.PrintRentedMedia(id)); 
						   }
						   
					   });
					   
					   backprintrent.setOnAction(e->{
						   primaryStage.setScene(rentmediaScene);
						   custidprinttrent.setText("");
						   printrent.setText("");
					   });

					   
					   Scene printrentscene=new Scene(printrentedmed,1500,750);
					   printrented.setOnAction(e->{
						  primaryStage.setScene(printrentscene);
					   });
////////////////////////////////////////////////////////////////////////////////////return rented media scene
					   BorderPane returnrentroot=new BorderPane();
					   returnrentroot.setPadding(new Insets(50));
					   
					   GridPane centerreturn=new GridPane();
					   centerreturn.setAlignment(Pos.CENTER);
					   centerreturn.setVgap(40);
					   centerreturn.setHgap(40);
					   
					   Label custidlreturn=new Label("Customer id:");
					   Label mediacodelreturn=new Label("Media Code");
					   
					   custidlreturn.setStyle("-fx-font-size:40px");
					   mediacodelreturn.setStyle("-fx-font-size:40px");
					   
					   TextField custidtreturn=new TextField();
					   TextField mediacodetreturn=new TextField();
					   
					   custidtreturn.setStyle("-fx-font-size:20px");
					   mediacodetreturn.setStyle("-fx-font-size:20px");
					   
					   TextField returninfo=new TextField();
					   returninfo.setPromptText("Return  Info Will Appear Here");
					   returninfo.setMinSize(500, 100);
					   returninfo.setStyle("-fx-font-size:20px");
					   returninfo.setEditable(false);
					   
					   centerreturn.add(custidlreturn, 0, 0); centerreturn.add(custidtreturn, 1, 0);
					   centerreturn.add(mediacodelreturn, 0, 1); centerreturn.add(mediacodetreturn, 1, 1);
					   centerreturn.add(returninfo, 1, 3);

					   
					   HBox returnbtns=new HBox();
					   returnbtns.setAlignment(Pos.CENTER);
					   returnbtns.setSpacing(50);
					   
					   Button backreturn=new Button();
					   Button returnmed=new Button("Return Media");
					  
					   ImageView backreturnview = new ImageView(new Image("C:\\Users\\Abood\\Desktop\\New folder\\back.png"));
					   backreturnview.setFitWidth(50);
					   backreturnview.setFitHeight(50);
					   backreturn.setGraphic(backreturnview);
					   
					   returnmed.setStyle("-fx-font-size:25px");
					   
					   returnbtns.getChildren().addAll(returnmed,backreturn);
					   
					   
					   returnrentroot.setCenter(centerreturn);
					   returnrentroot.setBottom(returnbtns);
					   
					   returnmed.setOnAction(e->{
						   if(custidtreturn.getText()!=null &&custidtreturn.getText()!="" && mediacodetreturn.getText()!=null &&mediacodetreturn.getText()!="") {
							   int id=Integer.parseInt(custidtreturn.getText());
							   int code=Integer.parseInt(mediacodetreturn.getText());
							   if(mRental.returnMedia(id, code)) {
								   Media m=mRental.findmediaCode(code);
								   returninfo.setText("Returned ["+m.getTitle().toUpperCase()+"] Succesfully");

								   
							   }else {
								   returninfo.setText("An Error Occured!");
							   }
							   
						   }
						   
					   });
					   
					   backreturn.setOnAction(e->{
						   primaryStage.setScene(rentmediaScene);
						   custidtreturn.setText("");
						   mediacodetreturn.setText("");
						   returninfo.setText("");
					   });
					  
					   Scene returnmediascene=new Scene(returnrentroot,1500,750);
					   returnmedia.setOnAction(e->{
						  primaryStage.setScene(returnmediascene); 
					   });
					   
					   
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////					   
					   returntomainpagee.setOnAction(e->{
						   primaryStage.setScene(mainscene);
					   });
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////			
			primaryStage.setScene(mainscene);
			primaryStage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		launch(args);
	}
	
	
	static void readfiles() throws IOException{
		File customer=new File("Files/CustomersData.txt");
		File media=new File("Files/MediaData.txt");
		File rented=new File("Files/RentingData.txt");
		
		Scanner reader= new Scanner(customer);
		ArrayList<String[]> ListOfTokens=new ArrayList<String[]>();
		try {
        if(customer.length()!=0) {
        	while (reader.hasNextLine()) {
    			ListOfTokens.add(reader.nextLine().split(">>"));
    		}
    		for(String[] tokens :ListOfTokens) {
    			Customer NewCust=new Customer(tokens[1],tokens[2],tokens[4],Integer.parseInt(tokens[0]),tokens[3]);
    			mRental.customers.add(NewCust);
    		}
        }
		reader.close();
		reader=new Scanner(media);
		ListOfTokens = new ArrayList<String[]>();
		if(media.length()!=0) {
		while (reader.hasNextLine()) {
			ListOfTokens.add(reader.nextLine().split(">>"));
		}
		for(String[] tokens :ListOfTokens) {
			if(tokens[1].equals("Movie")) {
				Movie newMovie=new Movie(tokens[2],Integer.parseInt(tokens[3]),tokens[4],Integer.parseInt(tokens[0]));
				mRental.Media.add(newMovie);
			}else if(tokens[1].equals("Game")) {
				Game newGame=new Game(tokens[2],Integer.parseInt(tokens[3]),Double.parseDouble(tokens[4]), Integer.parseInt(tokens[0]));
				mRental.Media.add(newGame);
			}else if(tokens[1].equals("Album")){
				Album newAlbum=new Album(tokens[2], Integer.parseInt(tokens[3]), tokens[4], tokens[5], Integer.parseInt(tokens[0]));
				mRental.Media.add(newAlbum);
			}
		}
	    }
		
		reader.close();
		
		reader = new Scanner(rented);
		ListOfTokens = new ArrayList<String[]>();
		if(rented.length()!=0) {
		while (reader.hasNextLine()) {
			ListOfTokens.add(reader.nextLine().split(">>"));
		}
		for (String[] tokens : ListOfTokens) {
			Customer c=mRental.findcustomerid(Integer.parseInt(tokens[0]));
			String toBeAdded=tokens[0]+">>"+tokens[1];
			c.Rented.add(toBeAdded);
		}
		}
		}catch (Exception e) {
			e.printStackTrace();
		}
		reader.close();
		
	}
}
//PHASE 1-not needed methods.
/*
private static void readfiles() throws IOException {
	System.out.println("\nLOADING FILES...\n");
	System.out.println("=======================");

	Scanner reader = new Scanner(new File("Files/CustomersData.txt"));
	ArrayList<String[]> ListOfTokens = new ArrayList<String[]>();
	while (reader.hasNextLine()) {
		ListOfTokens.add(reader.nextLine().split(">>"));
	}
		reader.close();

		for (String[] tokens : ListOfTokens) {
			mRental.addCustomer(tokens[0], tokens[1], tokens[2]);
		}
	
	reader.close();
	reader = new Scanner(new File("Files/MediaData.txt"));
	ListOfTokens = new ArrayList<String[]>();
	while (reader.hasNextLine()) {
		ListOfTokens.add(reader.nextLine().split(">>"));
	}

		for (String[] tokens : ListOfTokens) {
			if (tokens[0].equals("Movie"))
				mRental.addMovie(tokens[1], Integer.parseInt(tokens[2]), tokens[3]);

			else if (tokens[0].equals("Game"))
				mRental.addGame(tokens[1], Integer.parseInt(tokens[2]),Double.parseDouble(tokens[3]));
			else if (tokens[0].equals("Album"))
				mRental.addAlbum(tokens[1], Integer.parseInt(tokens[2]), tokens[3], tokens[4]);
		}
		reader.close();

		reader = new Scanner(new File("Files/InterestedData.txt"));
		ListOfTokens = new ArrayList<String[]>();
		while (reader.hasNextLine()) {
			ListOfTokens.add(reader.nextLine().split(">>"));
			
		}
		reader.close();
		for (String[] tokens : ListOfTokens) {
			Customer customer = mRental.findCustomer(tokens[0]);
			customer.AddRequest(tokens[1]);
		}
		
		
		reader = new Scanner(new File("Files/RentingData.txt"));
		ListOfTokens = new ArrayList<String[]>();
		while (reader.hasNextLine()) {
			ListOfTokens.add(reader.nextLine().split(">>"));
			
		}
		reader.close();
		for (String[] tokens : ListOfTokens) {
			Customer customer = mRental.findCustomer(tokens[0]);
			customer.Rented.add(mRental.findMedia(tokens[1]));
		}
	}*/
/*
 * static void readfiles() throws IOException{ File customer=new
 * File("Files/CustomersData.txt"); File media=new File("Files/MediaData.txt");
 * File intrested=new File("Files/InterestedData.txt"); File rented=new
 * File("Files/RentingData.txt");
 * 
 * Scanner reader= new Scanner(customer); ArrayList<String[]> ListOfTokens=new
 * ArrayList<String[]>();
 * 
 * while (reader.hasNextLine()) {
 * ListOfTokens.add(reader.nextLine().split(">>")); } for(String[] tokens
 * :ListOfTokens) { Customer NewCust=new Customer(tokens[1],tokens[2],tokens[4],
 * Integer.parseInt(tokens[0]),tokens[3]); mRental.customers.add(NewCust); }
 * 
 * 
 * reader.close(); reader=new Scanner(media); ListOfTokens = new
 * ArrayList<String[]>();
 * 
 * while (reader.hasNextLine()) {
 * ListOfTokens.add(reader.nextLine().split(">>")); } for(String[] tokens
 * :ListOfTokens) { if(tokens[1].equals("Movie")) { Movie newMovie=new
 * Movie(tokens[2],Integer.parseInt(tokens[3]),tokens[4]
 * ,Integer.parseInt(tokens[0])); mRental.Media.add(newMovie); }else
 * if(tokens[1].equals("Game")) { Game newGame=new
 * Game(tokens[2],Integer.parseInt(tokens[3]),Double.parseDouble(tokens[4]),
 * Integer.parseInt(tokens[0])); mRental.Media.add(newGame); }else
 * if(tokens[1].equals("Album")){ Album newAlbum=new Album(tokens[2],
 * Integer.parseInt(tokens[3]), tokens[4], tokens[5],
 * Integer.parseInt(tokens[0])); mRental.Media.add(newAlbum); } }
 * 
 * reader.close(); reader = new Scanner(intrested); ListOfTokens = new
 * ArrayList<String[]>();
 * 
 * while (reader.hasNextLine()) {
 * ListOfTokens.add(reader.nextLine().split(">>")); } for(String
 * tokens[]:ListOfTokens) { Customer
 * c=mRental.findcustomerid(Integer.parseInt(tokens[0])); String
 * toBeAdded=tokens[0]+">>"+tokens[1]; c.requests.add(toBeAdded); }
 * 
 * reader.close(); reader = new Scanner(rented); ListOfTokens = new
 * ArrayList<String[]>();
 * 
 * while (reader.hasNextLine()) {
 * ListOfTokens.add(reader.nextLine().split(">>")); } for (String[] tokens :
 * ListOfTokens) { Customer
 * c=mRental.findcustomerid(Integer.parseInt(tokens[0])); String
 * toBeAdded=tokens[0]+">>"+tokens[1]; c.Rented.add(toBeAdded); }
 * 
 * reader.close(); }
 */
