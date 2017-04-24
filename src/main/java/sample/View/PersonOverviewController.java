package sample.View;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import sample.Main;
import sample.model.Person;

public class PersonOverviewController {

    @FXML
    private TableView<Person> personTable;
    @FXML
    private TableColumn<Person, String> firstNameColumn;
    @FXML
    private TableColumn<Person, String> lastNameColumn;
    @FXML
    private Label firstNameLabel;
    @FXML
    private Label lastNameLabel;
    @FXML
    private Label streetLabel;
    @FXML
    private Label cityLabel;
    @FXML
    private Label postalCodeLabel;
    @FXML
    private Label birthdayLabel;

    // referencja do glownje klasy
    private Main main;

    public PersonOverviewController(){

    }
    @FXML
    private void initialize(){      // metoda z adnotacja czyli java FX ją poprostu zrobi bez wywolania
        firstNameColumn.setCellValueFactory(data -> data.getValue().firstNameProperty());
        lastNameColumn.setCellValueFactory(data -> data.getValue().lastNameProperty());
        showPersonDetails(null);

        personTable.getSelectionModel().selectedItemProperty().addListener((observable,x,y) -> showPersonDetails(y) );
        // dwa argumenty x - przechowuje stare dane  y - wrzuca nowe dane
    }

    public void setMain(Main main){
        this.main = main;
        personTable.setItems(main.getPersonData());
    }

    private void showPersonDetails(Person person){
        if (person != null){
            firstNameLabel.setText(person.getFirstName());
            lastNameLabel.setText(person.getLastName());

                try  {
                    streetLabel.setText(person.getStreet());
                }
                catch (NullPointerException e){
                    streetLabel.setText("");
                }

                try  {
                    cityLabel.setText(person.getCity());
                }
                catch (NullPointerException e){
                    cityLabel.setText("");
                }

                try  {
                    postalCodeLabel.setText(person.getPostalCode());
                }
                catch (NullPointerException e){
                    postalCodeLabel.setText("");
                }


        } else{
            firstNameLabel.setText("");
            lastNameLabel.setText("");
            streetLabel.setText("");
            cityLabel.setText("");
            postalCodeLabel.setText("");
        }
    }
}


