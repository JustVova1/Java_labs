package com.example.studentapp.model;
import javafx.beans.property.*;

import java.time.LocalDate;

/**
 * Клас модель для студента (Person).
 */
public class Person {
    private final StringProperty firstName;
    private final StringProperty lastName;
    private final StringProperty subject;
    private final IntegerProperty groupCode;
    private final IntegerProperty grade;

    private final DoubleProperty attPercentage;
    private final ObjectProperty<LocalDate> birthday;


    /**
     * Конструктор за замовчуванням.
     */
    public Person() {
        this(null, null, null);
    }
    /**
     * Конструктор із деякими початковими даними.
     *
     * @paramfirstName
     * @paramlastName
     */
    public Person(String firstName, String lastName ,String subject) {
        this.firstName=new SimpleStringProperty(firstName);
        this.subject = new SimpleStringProperty(subject);
        this.lastName=new SimpleStringProperty(lastName);

//Фіктивні дані для зручності
        this.groupCode=new SimpleIntegerProperty(1747);
        this.grade = new SimpleIntegerProperty(5);
        this.birthday=new SimpleObjectProperty<LocalDate>(LocalDate.of(2000,2,21));
        this.attPercentage = new SimpleDoubleProperty(80.8);
    }
    public String getFirstName() {
        return firstName.get();
    }
    public void setFirstName(String firstName) {
        this.firstName.set(firstName);
    }
    public StringProperty firstNameProperty() {
        return firstName;
    }
    public String getLastName() {
        return lastName.get();
    }
    public void setLastName(String lastName) {
        this.lastName.set(lastName);
    }
    public StringProperty lastNameProperty() {
        return lastName;
    }
    public int getGroupCode() {
        return groupCode.get();
    }
    public void setGroupCode(int groupCode) {
        this.groupCode.set(groupCode);
    }
    public IntegerProperty groupCodeProperty() {
        return groupCode;
    }
    public LocalDate getBirthday() {
        return birthday.get();
    }
    public void setBirthday(LocalDate birthday)
    {this.birthday.set(birthday);
    }
    public ObjectProperty<LocalDate>birthdayProperty() {return birthday;
    }
    /* new
    *
    * -------
    *
    *
    * */
    public String getSubject() {
        return subject.get();
    }
    public void setSubject(String subject) {
        this.subject.set(subject);
    }
    public StringProperty subjectProperty() {
        return subject;
    }

    public int getGrade() {
        return grade.get();
    }
    public void setGrade(int grade) {
        this.grade.set(grade);
    }
    public IntegerProperty gradeProperty() {
        return grade;
    }

    public double getAttPercentage() {
        return attPercentage.get();
    }
    public void setAttPercentage(double attPercentage) {
        this.attPercentage.set(attPercentage);
    }
    public DoubleProperty attPercentageProperty() {
        return attPercentage;
    }

}