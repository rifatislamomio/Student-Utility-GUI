import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.sun.xml.internal.ws.api.ha.StickyFeature;
import javafx.animation.ParallelTransition;
import javafx.animation.TranslateTransition;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.util.Duration;
import sun.audio.AudioPlayer;

import java.net.URL;
import java.util.LinkedList;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.TreeMap;

public class MainPanelController implements Initializable {

    @FXML
    private GridPane menuPane;

    @FXML
    private AnchorPane timerPane;

    @FXML
    private Text hoursTimer;

    @FXML
    private Text minutesTimer;

    @FXML
    private Text secondsTimer;

    @FXML
    private JFXButton cancleButton;

    @FXML
    private JFXComboBox<Integer> hoursInput;

    @FXML
    private JFXComboBox<Integer> minutesInput;

    @FXML
    private JFXComboBox<Integer> secondsInput;

    Map<Integer, String> numberMap;
    Integer currSecond;
    Thread thread;

    public void start(ActionEvent e)
    {
        currSecond = hmsToSeconds(hoursInput.getValue(),minutesInput.getValue(),secondsInput.getValue());
        hoursInput.setValue(0);
        minutesInput.setValue(0);
        secondsInput.setValue(0);
        scrollUp();
        startCountdown();
    }

    void startCountdown(){
        thread = new Thread(new Runnable() {
            @Override
            public void run() {
                try{
                    while (true)
                    {
                        setOutput();
                        Thread.sleep(1000);
                        if(currSecond==0){
                            AudioPlayer.player.start(MainPanelController.class.getResourceAsStream("buzzer.wav"));
                            Thread.sleep(9000);
                            scrollDown();
                        }

                        currSecond -= 1;
                    }
                }catch (Exception e)
                {

                }

            }
        });
        thread.start();
    }

    public void close(ActionEvent e)
    {
        showTime.primaryStage.close();
    }

    void setOutput(){
        LinkedList<Integer> currHms = secondsToHms(currSecond);
        hoursTimer.setText(numberMap.get(currHms.get(0)));
        minutesTimer.setText(numberMap.get(currHms.get(1)));
        secondsTimer.setText(numberMap.get(currHms.get(2)));



    }

    public void cancle(ActionEvent e)
    {
        thread.stop();
        scrollDown();
    }
    Integer hmsToSeconds(Integer h,Integer m,Integer s)
    {
        Integer hToSeconds = h*3600;
        Integer mToSeconds = m*60;
        Integer total = hToSeconds+ mToSeconds+s;
        return  total;
    }

    LinkedList<Integer> secondsToHms(Integer currSecond){
        Integer hours = currSecond/3600;
        currSecond = currSecond%3600;
        Integer minutes = currSecond/60;
        currSecond %= 60;
        Integer seconds = currSecond;
        LinkedList<Integer> answer = new LinkedList<>();
        answer.add(hours);
        answer.add(minutes);
        answer.add(seconds);
        return answer;

    }

    public void scrollUp()
    {
        TranslateTransition tr1 = new TranslateTransition();
        tr1.setDuration(Duration.millis(100));
        tr1.setToX(0);
        tr1.setToY(-250);
        tr1.setNode(menuPane);
        TranslateTransition tr2 = new TranslateTransition();
        tr2.setDuration(Duration.millis(100));
        tr2.setFromX(0);
        tr2.setFromY(300);
        tr2.setToX(0);
        tr2.setToY(0);
        tr2.setNode(timerPane);
        ParallelTransition pt = new ParallelTransition(tr1,tr2);
        pt.setOnFinished(e -> {
            try{


            }catch (Exception z)
            {

            }
        });
        pt.play();
    }


    public void scrollDown()
    {
        TranslateTransition tr1 = new TranslateTransition();
        tr1.setDuration(Duration.millis(100));
        tr1.setToX(0);
        tr1.setToY(250);
        tr1.setNode(timerPane);
        TranslateTransition tr2 = new TranslateTransition();
        tr2.setDuration(Duration.millis(100));
        tr2.setFromX(0);
        tr2.setFromY(-300);
        tr2.setToX(0);
        tr2.setToY(0);
        tr2.setNode(menuPane);
        ParallelTransition pt = new ParallelTransition(tr1,tr2);
        pt.setOnFinished(e -> {
            try{
                thread.stop();

            }catch (Exception z2)
            {

            }
        });
        pt.play();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        ObservableList<Integer> hoursList = FXCollections.observableArrayList();
        ObservableList<Integer> minuesAndSecondsList = FXCollections.observableArrayList();
        for(int i =0;i<=59;i++)
        {
            if(0<=i && i<=24)
            {
                hoursList.add(new Integer(i));
            }
            minuesAndSecondsList.add(new Integer(i));
        }
        hoursInput.setItems(hoursList);
        hoursInput.setValue(0);

        minutesInput.setItems(minuesAndSecondsList);
        minutesInput.setValue(0);

        secondsInput.setItems(minuesAndSecondsList);
        secondsInput.setValue(0);

        numberMap = new TreeMap<Integer,String>();
        for(Integer i =0;i<=59;i++)
        {
            if(0<=i && i<=9)
            {
                numberMap.put(i,("0" + i.toString()));
            }
            else
            {
                numberMap.put(i,(""+i.toString()));
            }

        }

    }
}
