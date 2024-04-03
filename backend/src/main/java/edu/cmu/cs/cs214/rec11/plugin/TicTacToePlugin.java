package edu.cmu.cs.cs214.rec11.plugin;

import java.util.List;

import edu.cmu.cs.cs214.rec11.framework.core.GameFramework;
import edu.cmu.cs.cs214.rec11.framework.core.GamePlugin;
import edu.cmu.cs.cs214.rec11.games.TicTacToe;

public class TicTacToePlugin implements GamePlugin<String>{
    private static final int WIDTH = 3;
    private static final int HEIGHT = 3;

    private static final String GAME_NAME = "Tic Tac Toe";
    private static final String GAME_FOOTER = "You are playing Tic Tac Toe!";

    private static final String GAME_TIED_MSG = "The game ended in a tie.";

    private GameFramework framework;
    private TicTacToe game;
    
    @Override
    public String getGameName() {
        return GAME_NAME;
    }

    @Override
    public int getGridWidth() {
        return WIDTH;
    }

    @Override
    public int getGridHeight() {
        return HEIGHT;
    }

    @Override
    public void onRegister(GameFramework f) {
        framework = f;
    }

    @Override
    public void onNewGame() {
        game = new TicTacToe();
        framework.setFooterText(GAME_FOOTER);
    }

    @Override
    public void onNewMove() {
    }

    @Override
    public boolean isMoveValid(int x, int y) {
        return game.isValidPlay(x, y);
    }

    @Override
    public boolean isMoveOver() {
        return game.isOver();
    }

    @Override
    public void onMovePlayed(int x, int y) {
        framework.setSquare(x, y, game.currentPlayer().toString());
        game.play(x, y);
    }

    @Override
    public boolean isGameOver() {
        return game.isOver();
    }

    @Override
    public String getGameOverMessage() {
        if (game.winner() == null) {
            return GAME_TIED_MSG;
        } else {
            return game.winner().toString() + " wins!";
        }
    }

    @Override
    public void onGameClosed() {
    }

    @Override
    public String currentPlayer() {
        return game.currentPlayer().toString();
    }
}
