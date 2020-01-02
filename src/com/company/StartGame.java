package com.company;


import com.company.game.Game;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.File;
import java.util.Timer;

public class StartGame extends Application {
    static int interval;
    static Timer timer;

    public static void main(String[] args) {
      //  launch(args);
        new Game();
    }


    @Override
    public void start(Stage stage) throws Exception {
  ///     Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        FXMLLoader loader = new FXMLLoader(new File("sample.fxml").toURI().toURL());
        Parent root = loader.load();
        stage.setTitle("Tacticl Chaos ");
        stage.setScene(new Scene(root));
        stage.show();

    }
}


//        Timer t = new Timer(1000, updateClockAction);
//        t.start();
     /*   Scanner sc = new Scanner(System.in);
        System.out.print("Input seconds => : ");
        String secs = sc.nextLine();
        int delay = 1000;
        int period = 1000;
        timer = new Timer();
        interval = Integer.parseInt(secs);
        System.out.println(secs);
        timer.scheduleAtFixedRate(new TimerTask() {

            public void run() {
                System.out.println(setInterval());

            }
        }, delay, period);*/


     /*  ActionListener updateClockAction = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            // Assumes clock is a custom component
            yourClock.setTime(System.currentTimeMillis());
            // OR
            // Assumes clock is a JLabel
            yourClock.setText(new Date().toString());
        }


    };
    private static int setInterval() {
        if (interval == 1)
            timer.cancel();
        return --interval;
    }*/