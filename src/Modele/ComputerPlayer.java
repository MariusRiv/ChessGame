package Modele;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import Modele.Pieces.*;

public class ComputerPlayer extends Player {

	public ComputerPlayer(boolean color) {
		super(color);
		// TODO Auto-generated constructor stub
	}

	public Move play(ChessBoard chessBoard) {
		List<Move> moves = this.getMoves(chessBoard,this);
		for(Move m : moves) {
			m.setValue(this.revalue(m,chessBoard));
		}
		Collections.shuffle(moves);
		moves.sort(new Comparator<Move>() {
			@Override
			public int compare(Move o1, Move o2) {
				// TODO Auto-generated method stub
				return o2.getValue()-o1.getValue();
			}	
		});
		System.out.println(moves);
		if(moves.size()==0) {
			return null;
		}else {
			return moves.get(0);
		}
	}

	public boolean OpponentisChecked(ChessBoard chess) {
		for(Piece p : this.getPieces(chess.getBoard())) {
			if(p.isMoveable(chess.getSquareKing(!this.color),chess.getBoard())) {
				return true;
			}
		}
		return false;
	}
	public int revalue(Move move,ChessBoard chess) {
		int value=0;
		ChessBoard chess0 = (ChessBoard) chess.clone();
		Move movebis = new Move(chess.getBoard()[move.getSquare0().getX()][move.getSquare0().getY()]
				,chess.getBoard()[move.getSquare1().getX()][move.getSquare1().getY()]
						,chess.getBoard()[move.getSquare0().getX()][move.getSquare0().getY()].getPiece());
		chess0.playMove(movebis);

		int valueOfPiece=0;
		if(move.isTaken())
			valueOfPiece = 1*((move.getPieceTaken() instanceof Queen)?ValueOfPiece.Queen.value:1)
			*((move.getPieceTaken() instanceof Rook)?ValueOfPiece.Rook.value:1)
			*((move.getPieceTaken() instanceof Bishop)?ValueOfPiece.Bishop.value:1)
			*((move.getPieceTaken() instanceof Knight)?ValueOfPiece.Knight.value:1)
			*((move.getPieceTaken() instanceof Pawn)?ValueOfPiece.Rook.value:1);


		//Checked
		if(this.updateCheck(chess0)) {
			value-=1000;
		}
		//Opponent Checked
		if(this.OpponentisChecked(chess0)) {
			value+=66;
		}
		//PieceTaken
		if(chess.getSquaresPiece(!color).size()>chess0.getSquaresPiece(!color).size()) {
			value+=10*valueOfPiece;
		}

		return value;
	}
}
