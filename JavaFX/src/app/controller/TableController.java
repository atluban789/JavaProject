package app.controller;
import database.DBConnector;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import app.model.TableModel;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;


public class TableController {
    @FXML
    private TableView<TableModel> TableTwo;
    @FXML
    private TableColumn<TableModel, Integer> id;
    @FXML
    private TableColumn<TableModel, String> name;
    @FXML
    private TableColumn<TableModel, String> last;
    @FXML
    private TableColumn<TableModel, String> salary;
    @FXML
    private Button refresh;
    @FXML
    private Button delete;
    @FXML
    private Button update;
    @FXML
    private Button insert;
    @FXML
    private TextField tf_name;
    @FXML
    private TextField tf_last;
    @FXML
    private TextField tf_salary;
    @FXML
    private Button commit;
    @FXML
    private Label lbl_insert;
    @FXML
    private Button btn_update;
    
    public DBConnector db;
    public ObservableList<TableModel> data = FXCollections.observableArrayList();
    
    @FXML
    void btnRefreshAction(ActionEvent event) throws ClassNotFoundException {
    	tf_name.setDisable(true);
    	tf_last.setDisable(true);
    	tf_salary.setDisable(true);
    	commit.setDisable(true); 
    	try{
    	    Connection conn = db.Connection();
            data = FXCollections.observableArrayList();       
            ResultSet rs = conn.createStatement().executeQuery("SELECT * from employee");
            while (rs.next()){
            	data.add(new TableModel(rs.getInt(1),rs.getString(2), rs.getString(3), rs.getString(4)));
            }
        }catch (SQLException ex){
            System.out.print("Error" + ex);
        }
    
    	id.setCellValueFactory(new PropertyValueFactory<TableModel,Integer>("id"));
    	name.setCellValueFactory(new PropertyValueFactory<TableModel,String>("firstName"));
    	last.setCellValueFactory(new PropertyValueFactory<TableModel,String>("lastName"));
    	salary.setCellValueFactory(new PropertyValueFactory<TableModel,String>("salary"));
    
    	TableTwo.setItems(null);
    	TableTwo.setItems(data);
    	lbl_insert.setVisible(false);
    }
    @FXML
    void btnCommitAction(ActionEvent event) throws ClassNotFoundException, SQLException {
    	if(tf_name.equals(null) | tf_last.equals(null) | tf_salary.equals(null)){
    		lbl_insert.setVisible(true);
    		lbl_insert.setText("NaleÅ¼y wprowadziÄ‡ dane do wszyskich pÃ³l");
    	} else{
    		lbl_insert.setText("Wprowadz dane do tabeli");
    		java.sql.PreparedStatement preparedStatement = null;
	    	Connection conn = db.Connection();
	    	String sql = "INSERT INTO employee (firstName_employee, lastName_employee, gross_salary_employee) values (?,?,?);";
	    	preparedStatement = conn.prepareStatement(sql);
	    	preparedStatement.setString(1, tf_name.getText());
	    	preparedStatement.setString(2, tf_last.getText());
	    	preparedStatement.setString(3, tf_salary.getText());
	    	preparedStatement.executeUpdate();
    	
	        tf_name.setText("");
	        tf_last.setText("");
	        tf_salary.setText("");
	        lbl_insert.setVisible(false);
    	}
    }
    @FXML
    void btnDeleteAction(ActionEvent event) throws SQLException, ClassNotFoundException {
    	
    	java.sql.PreparedStatement preparedStatement = null;
    	int id_del = TableTwo.getSelectionModel().getSelectedItem().getId();
    	Connection conn = db.Connection();
    	
    	String sql = "DELETE FROM employee WHERE id_employee="+id_del+";";
    	preparedStatement = conn.prepareStatement(sql);
    	preparedStatement.executeUpdate();
    	lbl_insert.setVisible(false);
    }
    @FXML
    void btnSaveChangesAction(ActionEvent event) throws ClassNotFoundException, SQLException {
    	tf_name.setDisable(false);
    	tf_last.setDisable(false);
    	tf_salary.setDisable(false);
    	commit.setDisable(false); 
    	tf_name.setText(TableTwo.getSelectionModel().getSelectedItem().getFirstName());
    	tf_last.setText(TableTwo.getSelectionModel().getSelectedItem().getLastName());
    	tf_salary.setText(TableTwo.getSelectionModel().getSelectedItem().getSalary());
    }
    @FXML
    void btnSaveEmployeeAction(ActionEvent event) {
    //	tf_name.setText(null);     ¿eby okna siê zerowa³y
    	
    	tf_name.setDisable(false);
    	tf_last.setDisable(false);
    	tf_salary.setDisable(false);
    	commit.setDisable(false);
    	lbl_insert.setVisible(true);
    	lbl_insert.setText("Wprowadz dane do tabeli");
    }
    @FXML
    void btn_updata_action(MouseEvent event) throws ClassNotFoundException, SQLException {
    	java.sql.PreparedStatement preparedStatement = null;
    	int id_update = TableTwo.getSelectionModel().getSelectedItem().getId();
    	Connection conn = db.Connection();
    	
    	String sql = "UPDATE employee SET firstName_employee= ?, lastName_employee= ?, gross_salary_employee= ? where id_employee = ?;";
    	preparedStatement = conn.prepareStatement(sql);
    	preparedStatement.setString(1, tf_name.getText());
    	preparedStatement.setString(2, tf_last.getText());
    	preparedStatement.setString(3, tf_salary.getText());
    	preparedStatement.setInt(4, id_update);
    	preparedStatement.executeUpdate();
    }
    
    public void initialize() {
		db = new DBConnector();	
	}
}