package Homework.JavaCore2.Homework4;
import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;


public class Controller implements Initializable {
    @FXML
    public ListView<String> contacts;
    @FXML
    private VBox main;
    @FXML
    private TextField userMessage;
    @FXML
    private TextArea chatArea;
    @FXML
    private Button btnSend;
    private String chosenUser = "default";

    public void mockAction(ActionEvent actionEvent) {
        System.out.println("mock");
    }

    public void closeApplication(ActionEvent actionEvent) {
        Platform.exit();
    }

    public void viewManual (ActionEvent actionEvent){

    Alert alert = new Alert(Alert.AlertType.INFORMATION);
    alert.setTitle("Manual");
    alert.setContentText("Press Send to send a message!");
    alert.showAndWait();
    }

    public void sendMessage(ActionEvent actionEvent) {
        String text = userMessage.getText();
        if (text == null || text.isBlank()) {
            return;
        }
        if (!(chosenUser.equals("default"))) {
            chatArea.appendText("[" + chosenUser + "]: " + text + System.lineSeparator());
            userMessage.clear();
        } else {
            chatArea.appendText("Broadcast: " + text + System.lineSeparator());
            userMessage.clear();
        }
        }

            @Override
            public void initialize (URL location, ResourceBundle Resources){
                String[] userContacts = {"Vasya", "Masha", "Petya", "Valera", "Nastya"};

                contacts.getItems().addAll(userContacts);
                contacts.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
                    @Override
                    public void changed(ObservableValue<? extends String> observableValue, String s, String t1) {
                       chosenUser = contacts.getSelectionModel().getSelectedItem();
                    }
                });
            }
        }