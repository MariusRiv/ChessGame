package Modele;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Player {
	protected boolean color;
	private boolean isChecked;
	private boolean littleRook,bigRook;
	private boolean defeated;

	public Player(boolean color) {
		this.color=color;
		this.isChecked=false;
		this.littleRook=true;
		this.bigRook=true;
		this.defeated=false;
	}

	public Move play(ChessBoard chessBoard) {
		List<Piece> l = this.getMovedPieces(chessBoard,this);

		Piece piece = null;
		Move move = null;
		Scanner sc = new Scanner(System.in);
		while(piece==null&&move==null) {
			String str ="";
			for(int i=0;i<l.size();i++) {
				str+=i+") "+l.get(i).getName()+" "+(l.get(i).isColor()?"blanc":"noir")+" "+l.get(i).getSquare().toString()+"\n";
			}
			System.out.println(str);

			int choice = sc.nextInt();
			piece = l.get(choice);
			List<Move> moves = piece.getMoves(chessBoard,this);

			str="";
			for(int i=0;i<moves.size();i++) {
				str+=i+") "+moves.get(i)+"\n";
			}
			System.out.println(str);
			choice = sc.nextInt();
			move=moves.get(choice);
		}
		return move;
	}

	public boolean updateCheck(ChessBoard chess) {
		boolean value=false;
		for(Piece p : this.getOpponentPieces(chess.getBoard())) {
			if(p.isMoveable(chess.getSquareKing(this.color),chess.getBoard())) {
				value=true;
			}	
		}
		return value;
	}

	public List<Piece> getPieces(Square[][] board){
		List<Piece> pieces = new ArrayList<Piece>();
		for(int j=0;j<board.length;j++)
			for(int i=0;i<board[j].length;i++)
				if(board[i][j].getPiece()!=null&&board[i][j].getPiece().isColor()==this.color) {
					pieces.add(board[i][j].getPiece());
				}
		return pieces;
	}
	public List<Piece> getOpponentPieces(Square[][] board){
		List<Piece> pieces = new ArrayList<Piece>();
		for(int j=0;j<board.length;j++)
			for(int i=0;i<board[j].length;i++)
				if(board[i][j].getPiece()!=null&&board[i][j].getPiece().isColor()!=this.color) {
					pieces.add(board[i][j].getPiece());
				}
		return pieces;
	}

	public List<Piece> getMovedPieces(ChessBoard board,Player player){
		List<Piece> pieces = this.getPieces(board.getBoard());
		List<Piece> res = new ArrayList<Piece>();
		for(Piece p : pieces) {
			if(p.getMoves(board,player).size()!=0)
				res.add(p);
		}
		return res;
	}

	public List<Move> getMoves(ChessBoard board,Player player){
		List<Move> moves= new ArrayList<Move>();
		for(Piece piece : this.getMovedPieces(board,player)) {
			moves.addAll(piece.getMoves(board,player));
		}
		return moves;
	}

	public boolean isChecked() {
		if(isChecked) {
			littleRook=false;
			bigRook=false;
		}
		return isChecked;
	}

	public void setChecked(boolean isChecked) {
		this.isChecked = isChecked;
	}

	public boolean isDefeated() {
		return defeated;
	}

	public void setDefeated(boolean defeated) {
		this.defeated = defeated;
	}

	public String toString() {
		return color?"Player 1":"Player 2";
	}

}
