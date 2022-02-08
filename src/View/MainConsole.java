package View;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

import Modele.*;

public class MainConsole {
	public static final boolean FIRST_PLAYER=true;

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		String s ="*************************************************************";
		System.out.println(s+"\n                     DEBUT DE PARTIE\n"+s);
		ChessBoard chessBoard = new ChessBoard();
		chessBoard.init();
		Player player1 = new ComputerPlayer(true);
		Player player2 = new ComputerPlayer(false);
		boolean playerWhoPlay=FIRST_PLAYER;
		//System.out.println(chessBoard.toString());
		HashMap<Integer,Player> players = new HashMap<Integer,Player>();
		players.put(0,player1);
		players.put(1,player2);
		while(!(player1.isDefeated()) && !(player2.isDefeated())) {
			Player player = players.get(playerWhoPlay?0:1);
			System.out.println("Tour n°"+MoveHistory.incrementProgressTurn()+", de "+player.toString()+" :");
			System.out.println(chessBoard.toString());
			//Thread.sleep(1000);

			//Check
			player.setChecked(player.updateCheck(chessBoard));
			if(player.isChecked()){
				System.out.println("ECHEC");
			}else {
				System.out.println("PAS ECHEC");
			}

			//Check
			Move move = player.play(chessBoard);
			if(move!=null) {
				chessBoard.playMove(move);
			}else{
				if(player.isChecked()&&player.updateCheck(chessBoard)){
					player.setDefeated(true);
				}else {
				players.get(0).setDefeated(true);
				players.get(1).setDefeated(true);
				}
			}
			


			//change of player
			playerWhoPlay=!playerWhoPlay;

			//if(!player.isChecked(chessBoard)&&player.getMovedPieces(chessBoard.getBoard()).size()==0) {
			//	System.out.print("PAT");
			//}
		}
		if(players.get(0).isDefeated()&&players.get(1).isDefeated()){
			System.out.print("PAT");
		}else {
			System.out.println("ECHEC & MAT\nVictoire de"+players.get(playerWhoPlay?0:1));
			System.out.println(chessBoard.toString());
		}
	}

}
