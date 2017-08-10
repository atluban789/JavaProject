package app.controller;
import database.DBConnector;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class LoginController{
	
    @FXML
    private Button btn;  
    @FXML
    private PasswordField pass;  
    @FXML
    private TextField tf;
    @FXML
    private Label lbl;
    @FXML
    private TextField tf1;
    @FXML
    private CheckBox cb1;
    
    public DBConnector db;
    String logowanie;
    
	public void Login(ActionEvent event) throws IOException, ClassNotFoundException, SQLException{
		Connection conn1 = db.Connection();	
		Statement stat = conn1.createStatement();
        ResultSet rs = stat.executeQuery("select * from login where users= '"+tf.getText()+"';");
        
        while (rs.next()) {
        	  logowanie = rs.getString("users");
        }
        System.out.println(logowanie);
		if(!logowanie.equals(null)){
			Stage stageTable = new Stage();
			Parent root = (Parent) FXMLLoader.load(getClass().getResource("/app/view/TableView.fxml"));
	        Scene sceneTable = new Scene(root);
	        stageTable.setScene(sceneTable);
	        stageTable.setTitle("Table page");
	        stageTable.show();	
		} else {
			System.out.println("Logowanie błędne");
			lbl.setText(lbl.getText() + " - błędne hasło lub login!");	
			tf.setText(null);
			tf1.setText(null);
			pass.setText(null);
		}
	}
    @FXML
    void show(MouseEvent event) {
    	if(cb1.isSelected()){
			pass.setDisable(true);
			tf1.setVisible(true);
			tf1.setText(pass.getText());
		}
		if(cb1.isSelected() == false){
			pass.setDisable(false);
			tf1.setVisible(false);
			pass.setText(tf1.getText());
		}
    }

    public void initialize() {
		db = new DBConnector();	
	}	
}