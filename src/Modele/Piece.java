package Modele;

import java.util.ArrayList;
import java.util.List;

public abstract class Piece implements Cloneable {
	protected Square square;
	private boolean color;
	private String name;
	
	protected Piece(Square square,boolean color,String name) {
		this.square=square;
		this.color=color;
		this.name=name;
	}

	public abstract boolean isMoveable(Square square,Square[][]board);

	public List<Move> getMoves(ChessBoard board,Player player){
		ArrayList<Move> listMoves= new ArrayList<Move>();
		for(int j=0;j<board.getBoard().length;j++)
			for(int i=0;i<board.getBoard()[j].length;i++) {
				if(isMoveable(board.getBoard()[i][j],board.getBoard())) {
					ChessBoard boardCopy=(ChessBoard) board.clone();
					if(board.getBoard()[i][j].getPiece()!=null) {
						listMoves.add(new Move(this.square,board.getBoard()[i][j],this,board.getBoard()[i][j].getPiece()));
					}else {
						listMoves.add(new Move(this.square,board.getBoard()[i][j],this));
					}
					boardCopy.playMove(listMoves.get(listMoves.size()-1));
					if(player.updateCheck(boardCopy)) {
						listMoves.remove(listMoves.size()-1);
					}
				}
			}
		return listMoves;
	}
	public List<Move> getMoves(ChessBoard board) {
		ArrayList<Move> listMoves= new ArrayList<Move>();
		for(int j=0;j<board.getBoard().length;j++)
			for(int i=0;i<board.getBoard()[j].length;i++) {
				if(isMoveable(board.getBoard()[i][j],board.getBoard())) {
					if(board.getBoard()[i][j].getPiece()!=null) {
						listMoves.add(new Move(this.square,board.getBoard()[i][j],this,board.getBoard()[i][j].getPiece()));
					}else {
						listMoves.add(new Move(this.square,board.getBoard()[i][j],this));
					}
				}
			}
		return listMoves;
	}

	public boolean isColor() {
		return color;
	}
	
	public String getName() {
		return name;
	}
	
	public Square getSquare() {
		return square;
	}
	
	public void setSquare(Square square) {
		this.square = square;
	}

}
