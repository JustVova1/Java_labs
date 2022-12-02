package com.example.studentapp;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.scene.layout.BorderPane;
import java.io.IOException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import com.example.studentapp.model.Person;
import com.example.studentapp.view.PersonOverviewController;
import javafx.stage.Modality;
import com.example.studentapp.view.PersonEditDialogController;


public class MainApp extends Application {
    private Stage primaryStage;
    private BorderPane rootLayout;
    /* Дані, у вигляді списку адресатів, що спостерігається.*/
    private ObservableList<Person> personData=
            FXCollections.observableArrayList();
    /**
     * Конструктор
     */
    public MainApp(){
//Як зразок додаємо деякі дані
        personData.add(new Person("Петро", "П'яточкін"  , "Статистика" ));
        personData.add(new Person("Іван","Зайців" ,"Кросплатформне програмування" ));
        personData.add(new Person("Катерина","Васильченка" ,"Комп'ютерні мережі "));
        personData.add(new Person("Ольга","Жук" , "Методи оптимізації "));
        personData.add(new Person("Людміла","Алексєєва","Кросплатформне програмування"));
        personData.add(new Person("Даніл","Кац" ,"Статистика"));
        personData.add(new Person("Євген","Васнецов" ,"Методи оптимізації "));
        personData.add(new Person("Дмитро","Жуликів" ,"Веб-технології"));
        personData.add(new Person("Мрат","Алібов" , "Комп'ютерні мережі "));
        personData.add(new Person("Martin","Mueller" ,"Веб-технології"));

    }
    /**
     * Повертає дані у вигляді спостережуваного списку студентів.
     * @return
     */
    public ObservableList<Person> getPersonData() {
        return personData;
    }

    @Override
    public void start(Stage stage) throws IOException {
        this.primaryStage = stage;
        this.primaryStage.setTitle("StudentGroupApp");

        initRootLayout();
        showPersonOverview();
    }

    /***Ініціалізує кореневий макет.*/
    public void initRootLayout() {
        FXMLLoader fxmlLoader = new FXMLLoader();
        //Завантажуємо кореневий макет з файлу fxml.

        fxmlLoader.setLocation(getClass().getResource("/com/example/studentapp/view/RootLayout.fxml"));
        try {
            rootLayout = (BorderPane) fxmlLoader.load();
            //Відображаємо сцену, яка містить кореневий макет.
            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void showPersonOverview() {
        FXMLLoader fxmlLoader = new FXMLLoader();
        //Завантажуємо відомості про студентів

        fxmlLoader.setLocation(MainApp.class.getResource("/com/example/studentapp/view/PersonOverview.fxml"));
        try {

            AnchorPane personOverview = (AnchorPane) fxmlLoader.load();//Поміщаємо відомості про студентів до центру кореневого макета.
            rootLayout.setCenter(personOverview);
            //Даємо контролеру доступ до головної програми.
            PersonOverviewController controller=fxmlLoader.getController();
            controller.setMainApp(this);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    //*Повертає головну сцену.*@return*/
    public Stage getPrimaryStage() {
        return primaryStage;
    }

    public static void main(String[] args) {
        launch();
    }

    /**
     * Відкриває діалогове вікно зміни даних зазначеного студента.
     * Якщо користувач натиснув OK, то зміни зберігаються у наданому
     * об'єкт студента і повертається значення true.
     *
     * @paramperson – об'єкт студента, який треба змінити
     * @returntrue, якщо користувач натиснув OK, інакше false.
     */
    public boolean showPersonEditDialog(Person person) {
        try{
// Завантажуємо файл fxml і створюємо нову сцену для діалогового вікна.
            FXMLLoader loader=new FXMLLoader();

            loader.setLocation(MainApp.class.getResource("view/PersonEditDialog.fxml"));
            AnchorPane page= (AnchorPane)loader.load();
//Створюємо діалогове вікно Stage.
            Stage dialogStage=new Stage();
            dialogStage.setTitle("Edit Person");
            dialogStage.initModality(Modality.WINDOW_MODAL);
            dialogStage.initOwner(primaryStage);
            Scene scene=new Scene(page);
            dialogStage.setScene(scene);
// Передаємо студента до контролера.
            PersonEditDialogController controller=loader.getController();
            controller.setDialogStage(dialogStage);
            controller.setPerson(person);
// Відображаємо діалогове вікно та чекаємо, поки користувач його не закриє
            dialogStage.showAndWait();
            return controller.isOkClicked();
        }catch(IOException e) {e.printStackTrace(); return false;
        }
    }



}