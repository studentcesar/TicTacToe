package com.example.tictactoe;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Game game;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        if (savedInstanceState == null) {
            game = new Game();

        }
        else{
            game = (Game) savedInstanceState.getSerializable("game");

            for(int i=0; i<3; i++){
                for(int j=0; j<3; j++){
                    String numbers = Integer.toString(i) + Integer.toString(j);
                    int id = getResources().getIdentifier("button"+ numbers, "id", getPackageName());
                    Button button = findViewById(id);
                    button.setText(savedInstanceState.getString("button" + numbers));
                }
            }

            for(int i=0; i<3; i++){
                for(int j=0; j<3; j++){
                    String numbers = Integer.toString(i) + Integer.toString(j);
                    int id = getResources().getIdentifier("button"+ numbers, "id", getPackageName());
                    Button button = findViewById(id);
                    button.setEnabled(savedInstanceState.getBoolean("button",false));
                }
            }

            TextView winnerText = findViewById(R.id.win);
            winnerText.setText(savedInstanceState.getString("winnerText"));
        }

    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        outState.putSerializable("game", game);

        for(int i=0; i<3; i++){
            for(int j=0; j<3; j++){
                String numbers = Integer.toString(i) + Integer.toString(j);
                int id = getResources().getIdentifier("button"+ numbers, "id", getPackageName());
                Button button = findViewById(id);
                outState.putString("button" + numbers, button.getText().toString());
            }
        }
        for(int i=0; i<3; i++){
            for(int j=0; j<3; j++){
                String numbers = Integer.toString(i) + Integer.toString(j);
                int id = getResources().getIdentifier("button"+ numbers, "id", getPackageName());
                Button button = findViewById(id);
                outState.putBoolean("button", button.isEnabled());
            }
        }




        TextView winnerText = findViewById(R.id.win);
        outState.putString("winnerText", winnerText.getText().toString());

    }

    public void tileClicked(View view) {

        int id = view.getId();

        int row=0;
        int column=0;

        switch(id) {
            case R.id.button00:
                row =0;
                column=0;
                break;

            case R.id.button01:
                row=0;
                column=1;
                break;

            case R.id.button02:
                row=0;
                column=2;
                break;
            case R.id.button10:
                row=1;
                column=0;
                break;

            case R.id.button11:
                row=1;
                column=1;
                break;

            case R.id.button12:
                row=1;
                column=2;
                break;

            case R.id.button20:
                row=2;
                column=0;
                break;

            case R.id.button21:
                row=2;
                column=1;
                break;

            case R.id.button22:
                row=2;
                column=2;
                break;

        }

        TileState state = game.choose(row, column);

        Button button = (Button) view;

        switch(state) {
            case CROSS:
                button.setText("X");
                break;
            case CIRCLE:
                button.setText("O");
                break;
            case INVALID:
                break;
        }

        winner(game.win_row());
        winner(game.win_column());
        winner(game.win_diagonal());

    }



    public void resetClicked(View view) {

        int id = view.getId();

        switch(id){
            case R.id.reset_button:
                reset();
        }

    }

    public void reset(){

        game = new Game();

        for(int i=0; i<3; i++){
            for(int j=0; j<3; j++){
                String numbers = Integer.toString(i) + Integer.toString(j);
                int id = getResources().getIdentifier("button"+ numbers, "id", getPackageName());
                Button button = findViewById(id);
                button.setText("");
            }
        }

        for(int i=0; i<3; i++){
            for(int j=0; j<3; j++){
                String numbers = Integer.toString(i) + Integer.toString(j);
                int id = getResources().getIdentifier("button"+ numbers, "id", getPackageName());
                Button button = findViewById(id);
                button.setEnabled(true);
            }
        }

        TextView winnerText = findViewById(R.id.win);
        winnerText.setText("");



    }

    public void winner(GameState state){

        TextView winnerText = findViewById(R.id.win);
        Button button00 = findViewById(R.id.button00);
        Button button01 = findViewById(R.id.button01);
        Button button02 = findViewById(R.id.button02);
        Button button10 = findViewById(R.id.button10);
        Button button11 = findViewById(R.id.button11);
        Button button12 = findViewById(R.id.button12);
        Button button20 = findViewById(R.id.button20);
        Button button21 = findViewById(R.id.button21);
        Button button22 = findViewById(R.id.button22);

        switch(state){
            case PLAYER_ONE:
                winnerText.setText("Player one wins!!");
                winnerText.setVisibility(View.VISIBLE);
                button00.setEnabled(false);
                button01.setEnabled(false);
                button02.setEnabled(false);
                button10.setEnabled(false);
                button11.setEnabled(false);
                button12.setEnabled(false);
                button20.setEnabled(false);
                button21.setEnabled(false);
                button22.setEnabled(false);
                break;

            case PLAYER_TWO:
                winnerText.setText("Player two wins!!");
                winnerText.setVisibility(View.VISIBLE);
                button00.setEnabled(false);
                button01.setEnabled(false);
                button02.setEnabled(false);
                button10.setEnabled(false);
                button11.setEnabled(false);
                button12.setEnabled(false);
                button20.setEnabled(false);
                button21.setEnabled(false);
                button22.setEnabled(false);
                break;

            case DRAW:
                winnerText.setText("It's a draw!!");
                winnerText.setVisibility(View.VISIBLE);
                button00.setEnabled(false);
                button01.setEnabled(false);
                button02.setEnabled(false);
                button10.setEnabled(false);
                button11.setEnabled(false);
                button12.setEnabled(false);
                button20.setEnabled(false);
                button21.setEnabled(false);
                button22.setEnabled(false);
                break;
            case IN_PROGRESS:
                break;

        }
    }




}
