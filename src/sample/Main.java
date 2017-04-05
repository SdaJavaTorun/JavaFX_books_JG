package sample;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import sample.View.PersonOverviewController;
import sample.model.Person;
import javafx.collections.ObservableList;
import java.io.IOException;

public class Main extends Application {

    private Stage primaryStage;
    private BorderPane rootLayout;
    private ObservableList<Person> personData = FXCollections.observableArrayList();

    public Main(){
        personData.addAll(new Person.Builder("Jakub", "Gutkowski").postalCode("87-100").city("Toruń").build());
        personData.addAll(new Person.Builder("Marek", "Marecki").city("Gdańsk").street("Jedyna").build());
        personData.addAll(new Person.Builder("Karol", "Nowak").city("Kraków").build());
        personData.addAll(new Person.Builder("Ania", "Ktoś").build());
        personData.addAll(new Person("Zdzich", "Jedyny"));
        personData.addAll(new Person("Romek", "Kowal"));
        personData.addAll(new Person("Magda", "Awaria"));
        personData.addAll(new Person("Kamil", "Konieczny"));
    }

    public ObservableList<Person> getPersonData() {
        return personData;
    }

    @Override
    public void start(Stage primaryStage) throws Exception{
        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("Książka adresowa");

        initRootLayout();
        showPersonOverview();
    }

    public void initRootLayout(){

        try {
            FXMLLoader fxmlLoader = new FXMLLoader();  // klasa odpowiedzilaana za zaladowanie naszego widoku
            fxmlLoader.setLocation(Main.class.getResource("view/RootLayout.fxml")); // podajemy jaki widok ma byc zaladowany
            rootLayout = fxmlLoader.load();                // getResource dodaje pliki z projektu (inne)

            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);     //wrzuca stworzone przez nas sceny do STAGA czyli początku programu
            primaryStage.show();

        }catch (IOException e){
            e.printStackTrace();
        }
    }
    public void showPersonOverview(){

        try {
            FXMLLoader fxmlLoader = new FXMLLoader();  // klasa odpowiedzilaana za zaladowanie naszego widoku
            fxmlLoader.setLocation(Main.class.getResource("view/PersonOverview.fxml")); // podajemy jaki widok ma byc zaladowany
            AnchorPane personOverview  = fxmlLoader.load();

            rootLayout.setCenter(personOverview);

            PersonOverviewController controller = fxmlLoader.getController();
            controller.setMain(this);

        }catch (IOException e){
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {

        launch(args);
    }
}
