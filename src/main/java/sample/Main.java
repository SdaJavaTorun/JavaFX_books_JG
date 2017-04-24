package sample;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import sample.View.PersonOverviewController;
import sample.model.Connect;
import sample.model.Person;
import javafx.collections.ObservableList;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Main extends Application {

    private Stage primaryStage;
    private BorderPane rootLayout;
    private ObservableList<Person> personData = FXCollections.observableArrayList();
    Statement statement;

    public Main() throws SQLException, ClassNotFoundException {
        statement = Connect.getInstance().getConnection().createStatement();
        statement.executeUpdate("UPDATE books SET title ='cos nowego' WHERE id = 1");
        ResultSet resultSet = statement.executeQuery("SELECT * FROM books");

        while (resultSet.next()) {
            personData.addAll(new Person.Builder(resultSet.getString("author"),resultSet.getString("title" )).build());
        }

        resultSet.close();
        statement.close();
        Connect.getInstance().getConnection().close();
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
            fxmlLoader.setLocation(Main.class.getResource("/RootLayout.fxml")); // podajemy jaki widok ma byc zaladowany
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
            fxmlLoader.setLocation(Main.class.getResource("/PersonOverview.fxml")); // podajemy jaki widok ma byc zaladowany
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
