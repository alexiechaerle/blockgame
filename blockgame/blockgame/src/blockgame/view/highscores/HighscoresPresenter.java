package blockgame.view.highscores;

import blockgame.model.Game;
import blockgame.view.mainMenu.MainMenuPresenter;
import blockgame.view.mainMenu.MainMenuView;
import javafx.event.EventHandler;
import javafx.scene.Cursor;
import javafx.scene.chart.XYChart;
import javafx.scene.input.MouseEvent;

/**
 * @author Maxim Derboven
 * @version 1.0 7/03/2021 16:35
 */
public class HighscoresPresenter {
    private Game model;
    private HighscoresView view;


    public HighscoresPresenter(Game model, HighscoresView view) {
        this.model = model;
        this.view = view;
        addEventHandlers();
        updateView();
    }

    private void updateView() {
        //xx
    }

    private void addEventHandlers() {
        /* Barchart aanvullen in HighscoresView */
        String[] cutted;
        for (String row : model.getAm().getLeaderboard()) {
            cutted = row.split(";");
            view.getInfo().getData().add(new XYChart.Data<>(cutted[0], Integer.parseInt(cutted[1])));
        }
        view.getChart().getData().add(view.getInfo());

        view.getImgClose().setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                view.getImgClose().setCursor(Cursor.HAND);
            }
        });

        view.getImgClose().setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                MainMenuView mv = new MainMenuView();
                MainMenuPresenter mp = new MainMenuPresenter(model, mv);
                view.getScene().setRoot(mv);
            }
        });
    }

}