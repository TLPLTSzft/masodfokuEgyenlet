package com.example.masodfokuegyenlet;

import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class MasodfokuEgyenletController {
	@FXML
	private TextField aSzam, bSzam, cSzam;
	@FXML
	private Label megoldas;
	@FXML
	private Button szamolGomb;
	
	double a, b, c, x1, x2, szam;
	String hiba, megoldasString;
	
	@FXML
	public void szamol(ActionEvent actionEvent) {
		hiba = "";
		szamHelyesE(this.aSzam, "a");
		szamHelyesE(this.bSzam, "b");
		szamHelyesE(this.cSzam, "c");
		if (!hiba.equals("")) {
			Alert alert = new Alert(Alert.AlertType.WARNING);
			alert.setContentText(hiba);
			alert.show();
		} else {
			a = Double.parseDouble(aSzam.getText());
			b = Double.parseDouble(bSzam.getText());
			c = Double.parseDouble(cSzam.getText());
			megoldasString = "";
			double D = b * b - 4 * a * c;
			if (D < 0) {
				megoldasString = "Nem oldható meg:\n    a valós számok halmazán";
			} else if (D == 0) {
				megoldasString += String.format("x1 = x2 = %.2f", -b / (2 * a));
			} else {
				x1 = (-b + Math.sqrt(D)) / (2 * a);
				x2 = (-b - Math.sqrt(D)) / (2 * a);
				megoldasString += String.format("x1 = %.2f", x1);
				megoldasString += String.format("\nx2 = %.2f", x2);
			}
			megoldas.setText(String.format("%s", megoldasString));
		}
	}
	
	private String szamHelyesE(TextField szam, String string) {
		if (szam.getText().length() == 0) {
			hiba += "\n'" + string + "' megadása kötelező";
		} else {
			try {
				this.szam = Double.parseDouble(szam.getText());
			} catch (NumberFormatException e) {
				hiba += "\n'" + string + "' csak szám lehet";
			}
		}
		return hiba;
	}
	
	@FXML
	public void megoldasTorlese(Event event) {
		megoldas.setText("");
	}
	
}