package org.main.culturesolutioncalculation;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.main.culturesolutioncalculation.service.database.DatabaseConnector;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Main extends Application {


    private final String url = "jdbc:mysql://localhost:3306/CultureSolutionCalculation?useSSL=false";
    private final String user = "root";
    private final String password = "root";

    @Override
    public void start(Stage stage) {
        try {
            initStage(stage);
            System.out.println("start program : 프로그램 실행");
            Connection conn = DatabaseConnector.getInstance(url, user, password).getConnection();

            //종료 시 DB 연결 해제
            stage.setOnCloseRequest(e -> DatabaseConnector.disconnect(conn));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws ClassNotFoundException {

        launch();
    }

    public static void reload(Stage stage) {
        try {
            initStage(stage);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void initStage(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(Main.class.getResource("Main.fxml"));
        Scene scene = new Scene(root, 950, 750);

        stage.setTitle("배양액 계산 프로그램");
        stage.setMinWidth(950);
        stage.setMinHeight(750);

        stage.setScene(scene);
        stage.show();
    }
}