package Modele;

import java.util.ArrayList;
import java.util.List;

public class MoveHistory {
	private List<Move> moves;
	private Move progressMove;
	private static int progressTurn = 0;
	public MoveHistory() {
		moves = new ArrayList<Move>();
	}

	public void addMove(Move move) {
		moves.add(move);
	}

	public void previousMove() throws Exception {
		if(progressMove.getTurn()>=2) {
			progressMove = moves.get(progressMove.getTurn()-2);
		}else {
			throw new Exception();
		}
	}

	public static int getProgressTurn() {
		return progressTurn;
	}

	public static int incrementProgressTurn() {
		return MoveHistory.progressTurn ++;
	}
	
}
