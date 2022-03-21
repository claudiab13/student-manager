package loose.oose.fis.lab.student.manager.controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import loose.oose.fis.lab.student.manager.model.Student;

public class ViewStudentsController {

    @FXML
    public TableView<Student> studentTable;

    @FXML
    public TableColumn<Student, String> studentLastNameColumn;
    @FXML
    public TableColumn<Student, String> studentFirstNameColumn;
    @FXML
    public TableColumn<Student, Integer> studentAgeColumn;
    @FXML
    public TableColumn<Student, Double> studentMeanGradeColumn;

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("fxml/view-students.fxml"));
        primaryStage.setTitle("Student Manager");
        primaryStage.setScene(new Scene(root, 600, 400));
        primaryStage.show();
    }


    @FXML
    public void initialize() {
        studentLastNameColumn.setCellValueFactory(new PropertyValueFactory<>("lastName"));
        studentFirstNameColumn.setCellValueFactory(new PropertyValueFactory<>("firstName"));
        studentAgeColumn.setCellValueFactory(new PropertyValueFactory<>("age"));
        studentMeanGradeColumn.setCellValueFactory(new PropertyValueFactory<>("meanGrade"));

        studentTable.setItems(students);
    }

    private ObservableList<Student> students = FXCollections.observableArrayList(
            new Student("John", "Doe", 20, 8.73),
            new Student("Jane", "Does", 23, 9.35),
            new Student("Jack", "Black", 19, 6.58),
            new Student("Julia", "Nice", 21, 9.85),
            new Student("Johnny", "Jackson", 24, 9.97),
            new Student("Michelle", "Roberts", 22, 7.65)
    );
}

