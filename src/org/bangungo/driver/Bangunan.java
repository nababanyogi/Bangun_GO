package org.bangungo.driver;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

/**
 *
 * @author Bangun Go
 */
public class Bangunan extends Application {

    /**
     *
     * @param primaryStage : parameter yang berfungi menampilkan tampilan
     * pertama dalam aplikasi
     * @throws Exception : melempar ke exception jika fungsi tidak berjalan
     */
    @Override
    public void start(Stage primaryStage) throws Exception {

        Parent parent = FXMLLoader.load(getClass().getResource("/org/bangungo/view/Login.fxml"));
        Scene scene = new Scene(parent);
        primaryStage.getIcons().add(new Image("Actions-go-home-icon.png"));
        primaryStage.setTitle("Login akun");
        primaryStage.setScene(scene);
        primaryStage.show();

    }

}
