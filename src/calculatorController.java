import com.jfoenix.controls.JFXButton;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class calculatorController {

    @FXML
    private Label label;

    @FXML
    private JFXButton btn7;

    @FXML
    private JFXButton btn8;

    @FXML
    private JFXButton btn9;

    @FXML
    private JFXButton btn4;

    @FXML
    private JFXButton btn5;

    @FXML
    private JFXButton btn6;

    @FXML
    private JFXButton btn1;

    @FXML
    private JFXButton btn2;

    @FXML
    private JFXButton btn3;

    @FXML
    private JFXButton btn0;

    @FXML
    private JFXButton btnDot;

    @FXML
    private JFXButton btnEqual;

    @FXML
    private JFXButton btnDevide;

    @FXML
    private JFXButton btnMultiply;

    @FXML
    private JFXButton btnMinus;

    @FXML
    private JFXButton btnPlus;

    @FXML
    private JFXButton btnExit;

    @FXML
    private JFXButton btnCear;

    @FXML
    private JFXButton btnRoot;

    @FXML
    private JFXButton btnSqure;

    public void exit(ActionEvent event)
    {
        showCalculator.primaryStage.close();
    }

    private double result;
    @FXML
    private void onButtonClick(ActionEvent event){
        if(event.getSource().equals(btn0)){
            label.setText(label.getText()+btn0.getText());
        }
        else if(event.getSource().equals(btn1)){
            label.setText(label.getText()+btn1.getText());
        }

        else if(event.getSource().equals(btn2)){
            label.setText(label.getText()+btn2.getText());
        }
        else if(event.getSource().equals(btn3)){
            label.setText(label.getText()+btn3.getText());
        }
        else if(event.getSource().equals(btn4)){
            label.setText(label.getText()+btn4.getText());
        }
        else if(event.getSource().equals(btn5)){
            label.setText(label.getText()+btn5.getText());
        }
        else if(event.getSource().equals(btn6)){
            label.setText(label.getText()+btn6.getText());
        }
        else if(event.getSource().equals(btn7)){
            label.setText(label.getText()+btn7.getText());
        }
        else if(event.getSource().equals(btn8)){
            label.setText(label.getText()+btn8.getText());
        }
        else if(event.getSource().equals(btn9)){
            label.setText(label.getText()+btn9.getText());
        }
        else if(event.getSource().equals(btnDot)){
            label.setText(label.getText()+btnDot.getText());
        }
        else if(event.getSource().equals(btnDevide)){
            label.setText(label.getText()+"/");
        }
        else if(event.getSource().equals(btnMultiply)){
            label.setText(label.getText()+"*");
        }
        else if(event.getSource().equals(btnMinus)){
            label.setText(label.getText()+btnMinus.getText());
        }
        else if(event.getSource().equals(btnPlus)){
            label.setText(label.getText()+btnPlus.getText());
        }
        else if(event.getSource().equals(btnEqual)){


            Calculator Es = new Calculator(label.getText());
            result = Es.Result(); String ans = Double.toString(result);
            label.setText(ans);

        } else if(event.getSource().equals(btnCear)){
            label.setText("");
        } else if(event.getSource().equals(btnExit)){
            String temp = label.getText();
            int len = temp.length();

            temp = temp.substring(0, len-1);

            label.setText(temp);
        } else if(event.getSource().equals(btnSqure)){
            String temp = label.getText();
            result = Double.parseDouble(temp);
            result = result*result;
            label.setText(Double.toString(result));

        } else if(event.getSource().equals(btnRoot)){

            String temp = label.getText();
            result = Double.parseDouble(temp);
            result = Math.sqrt(result);
            label.setText(Double.toString(result));
        }
        else{

        }
    }

}