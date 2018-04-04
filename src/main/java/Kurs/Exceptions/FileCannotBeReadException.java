package Kurs.Exceptions;

import javafx.scene.control.Alert;

public class FileCannotBeReadException extends Exception {

    public FileCannotBeReadException(String message) {
        super(message);
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Ошибка при открытии файла");
        alert.setContentText(message);
        alert.showAndWait();
    }
}
