package Exceptions;

import javafx.scene.control.Alert;

public class ValueDoesntMatchPattern extends Exception {

    public ValueDoesntMatchPattern(String message) {
        super(message);
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Ошибка при сохранении файла");
        alert.setContentText(message);
        alert.showAndWait();
    }
}
