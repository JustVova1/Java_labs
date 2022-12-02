package com.example.studentapp.view;
import com.example.studentapp.model.Person;
import com.example.studentapp.util.DateUtil;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
public class PersonEditDialogController {
    /**
     * Вікно для зміни інформації про студента.
     */
    @FXML
    private TextField firstNameField;
    @FXML
    private TextField lastNameField;
    @FXML
    private TextField groupCodeField;
    @FXML
    private TextField birthdayField;
    @FXML
    private TextField subjectField;
    @FXML
    private TextField gradeField;
    @FXML
    private TextField attPercentageField;
    private Stage dialogStage;
    private Person person;
    private boolean okClicked=false;
    /**
     * Ініціалізує клас-контролер. Цей метод викликається автоматично
     * після того, як файл fxml буде завантажений.
     */
    @FXML
    private void initialize() {
    }
    /**
     * Встановлює сцену цього вікна.
     *
     * @paramdialogStage
     */
    public void setDialogStage(Stage dialogStage) {this.dialogStage=dialogStage;
    }
    /**
     * Задає адресата, інформацію про який змінюватимемо.
     *
     * @paramperson
     */
    public void setPerson(Person person) {
        this.person=person;
        firstNameField.setText(person.getFirstName());
        lastNameField.setText(person.getLastName());
        subjectField.setText(person.getSubject());
        groupCodeField.setText(String.valueOf(person.getGroupCode()));
        birthdayField.setText(DateUtil.format(person.getBirthday()));
        birthdayField.setPromptText("dd.mm.yyyy");
        gradeField.setText(String.valueOf(person.getGrade()));
        attPercentageField.setText(String.valueOf(person.getAttPercentage()));
    }
    /**
     * Returns true, якщо користувач клацнув OK, інакше false.
     *
     * @return
     */
    public boolean isOkClicked() {
        return okClicked;
    }
    /**
     * Викликається, коли користувач клацнув по кнопці OK.
     */
    @FXML
    private void handleOk() {
        if(isInputValid()) {
            person.setFirstName(firstNameField.getText());
            person.setLastName(lastNameField.getText());
            person.setSubject(subjectField.getText());
            person.setGroupCode(Integer.parseInt(groupCodeField.getText()));
            person.setGrade(Integer.parseInt(gradeField.getText()));
            person.setBirthday(DateUtil.parse(birthdayField.getText()));
            person.setAttPercentage(Double.parseDouble(attPercentageField.getText()));
            okClicked=true;
            dialogStage.close();
        }
    }
    /**
     * Викликається, коли користувач клацнув по кнопці Cancel.
     */
    @FXML
    private void handleCancel() {
        dialogStage.close();
    }
    /**
     * Перевіряє введення тексту в текстових полях.
     *
     * @returntrue, якщо введення користувача коректне
     */
    private boolean isInputValid() {
        String errorMessage="";
        if(firstNameField.getText() ==null||firstNameField.getText().length()
                ==0) { errorMessage+="No valid first name!\n";
        }
        if(lastNameField.getText() ==null||lastNameField.getText().length() ==0)
        { errorMessage+="No valid last name!\n";
        }
        if(subjectField.getText() ==null||subjectField.getText().length() ==0)
        { errorMessage+="No valid subject!\n";
        }
        if(groupCodeField.getText() ==null||groupCodeField.getText().length()
                ==0) { errorMessage+="No valid postal code!\n";
        }
        else{
// намагаємося перетворити номер групи на int.
            try{
                Integer.parseInt(groupCodeField.getText());
            }catch(NumberFormatException e) {
                errorMessage+="No valid group code (must be an integer)!\n";
            }
        }
        if(gradeField.getText() ==null||gradeField.getText().length()
                ==0) { errorMessage+="No valid postal code!\n";
        }
        else{
// намагаємося перетворити номер групи на int.
            try{
                Integer.parseInt(gradeField.getText());
            }catch(NumberFormatException e) {
                errorMessage+="No valid grade (must be an integer)!\n";
            }
        }

        if(attPercentageField.getText() ==null||attPercentageField.getText().length()
                ==0) { errorMessage+="No valid postal code!\n";
        }
        else{
// намагаємося перетворити номер групи на int.
            try{
                Double.parseDouble(attPercentageField.getText());
            }catch(NumberFormatException e) {
                errorMessage+="No valid attendance percentage (must be an double)!\n";
            }
        }
        if(birthdayField.getText() ==null||birthdayField.getText().length() ==0)
        { errorMessage+="No valid birthday!\n";
        }else{
            if(!DateUtil.validDate(birthdayField.getText())) {
                errorMessage+="No valid birthday. Use the format dd.mm.yyyy!\n";
            }
        }
        if(errorMessage.length() ==0) {
            return true;
        }else{
// Показуємо повідомлення про помилку.
            Alert alert=new Alert(AlertType.ERROR);
            alert.initOwner(dialogStage);
            alert.setTitle("Invalid Fields");
            alert.setHeaderText("Please correct invalid fields");
            alert.setContentText(errorMessage);
            alert.showAndWait();
            return false;
        }
    }
}