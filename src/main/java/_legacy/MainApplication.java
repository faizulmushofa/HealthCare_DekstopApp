import Controller.SceneController;
import Utils.TimeLogger;
import javafx.application.Application;
import javafx.stage.Stage;


public class MainApplication extends Application {

    static long startTime = System.currentTimeMillis();

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        SceneController sceneController = new SceneController(primaryStage);
        sceneController.BuildWindow(sceneController.getLOGIN_PAGE(), "Login");
        
        long startupElapsed = System.currentTimeMillis() - startTime;
        System.out.println("\n" + "=".repeat(65));
        System.out.printf("🚀 [APPLICATION STARTUP] Selesai dalam: %d ms%n", startupElapsed);
        System.out.println("=".repeat(65));

        TimeLogger.logSnapshot("APP_READY");
        new TimeLogger().start();
    }
}
