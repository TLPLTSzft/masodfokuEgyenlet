module com.example.masodfokuegyenlet {
	requires javafx.controls;
	requires javafx.fxml;
	
	
	opens com.example.masodfokuegyenlet to javafx.fxml;
	exports com.example.masodfokuegyenlet;
}