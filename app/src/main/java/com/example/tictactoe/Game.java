package com.example.tictactoe;

public class Game implements java.io.Serializable{
    final private int BOARD_SIZE = 3;
    private TileState[][] board;
    private Boolean playerOneTurn;  // true if player 1's turn, false if player 2's turn
    private int movesPlayed;
    private Boolean gameOver;

    public Game() {
        board = new TileState[BOARD_SIZE][BOARD_SIZE];
        for(int i=0; i<BOARD_SIZE; i++)
            for(int j=0; j<BOARD_SIZE; j++)
                board[i][j] = TileState.BLANK;

        playerOneTurn = true;
        gameOver = false;
    }

    public TileState choose(int row, int column) {
        if(board[row][column] == TileState.BLANK){
            if(playerOneTurn){
                board[row][column] = TileState.CROSS;
                playerOneTurn = false;
                movesPlayed ++;
                return TileState.CROSS;
            }
            else{
                board[row][column] = TileState.CIRCLE;
                playerOneTurn = true;
                movesPlayed ++;
                return TileState.CIRCLE;
            }

        }
        else{
            return TileState.INVALID;
        }

    }

    public GameState win_row(){
      if(movesPlayed >= 9){
          return GameState.DRAW;
      }
      else if(board[0][0] == board[0][1] && board[0][1] == board[0][2] && board[0][1] != TileState.BLANK){
          if(!playerOneTurn){
              return GameState.PLAYER_ONE;
          }
          else{
              return GameState.PLAYER_TWO;
          }
      }
      else if(board[1][0] == board[1][1] && board[1][1] == board[1][2] && board[1][0] != TileState.BLANK){
          if(!playerOneTurn){
              return GameState.PLAYER_ONE;
          }
          else{
              return GameState.PLAYER_TWO;
          }
      }
      else if(board[2][0] == board[2][1] && board[2][1] == board[2][2] && board[2][0] != TileState.BLANK){
          if(!playerOneTurn){
              return GameState.PLAYER_ONE;
          }
          else{
              return GameState.PLAYER_TWO;
          }
      }
      else{
          return GameState.IN_PROGRESS;
      }


    }

    public GameState win_column(){
        if(movesPlayed >= 9){
            return GameState.DRAW;
        }
        else if(board[0][0] == board[1][0] && board[1][0] == board[2][0] && board[0][0] != TileState.BLANK){
            if(!playerOneTurn){
                return GameState.PLAYER_ONE;
            }
            else{
                return GameState.PLAYER_TWO;
            }
        }
        else if(board[0][1] == board[1][1] && board[1][1] == board[2][1] && board[0][1] != TileState.BLANK){
            if(!playerOneTurn){
                return GameState.PLAYER_ONE;
            }
            else{
                return GameState.PLAYER_TWO;
            }
        }
        else if(board[0][2] == board[1][2] && board[1][2] == board[2][2] && board[0][2] != TileState.BLANK){
            if(!playerOneTurn){
                return GameState.PLAYER_ONE;
            }
            else{
                return GameState.PLAYER_TWO;
            }
        }
        else{
            return GameState.IN_PROGRESS;
        }


    }

    public GameState win_diagonal(){
        if(movesPlayed >= 9){
            return GameState.DRAW;
        }
        else if(board[0][0] == board[1][1] && board[1][1] == board[2][2] && board[0][0] != TileState.BLANK){
            if(!playerOneTurn){
                return GameState.PLAYER_ONE;
            }
            else{
                return GameState.PLAYER_TWO;
            }
        }
        else if(board[2][0] == board[1][1] && board[1][1] == board[0][2] && board[2][0] != TileState.BLANK){
            if(!playerOneTurn){
                return GameState.PLAYER_ONE;
            }
            else{
                return GameState.PLAYER_TWO;
            }
        }
        else{
            return GameState.IN_PROGRESS;
        }


    }






}
