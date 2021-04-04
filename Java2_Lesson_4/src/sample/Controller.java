package sample;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.Clipboard;
import javafx.scene.input.ClipboardContent;

public class Controller {
    @FXML
    TextArea mainTextArea;
    @FXML
    TextField sendTextField;

    @FXML
    public void sendMsg() {
        if(!sendTextField.getText().isEmpty()){
           mainTextArea.appendText("UserName1: "+sendTextField.getText()+"\n");
           sendTextField.clear();
           sendTextField.requestFocus();
        }
    }
    @FXML
    public void exitAction() {
        Platform.exit();
    }
    @FXML
    public void clearTextArea() {
        mainTextArea.clear();
    }
    @FXML
    public void cpToBuffer() {
        String copyText = mainTextArea.getText();
        Clipboard clipboard = Clipboard.getSystemClipboard();
        ClipboardContent content = new ClipboardContent();
        content.putString(copyText);
        clipboard.setContent(content);
    }
}
