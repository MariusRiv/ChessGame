package Modele;

import java.util.ArrayList;
import java.util.List;

import Modele.Pieces.*;

public class ChessBoard implements Cloneable {
	private Square[][] board;

	public ChessBoard() {
		board = new Square[8][8];
		for(int j=0;j<board.length;j++)
			for(int i=0;i<board[j].length;i++)
				board[i][j] = new Square(i,j);
	}

	public void init() {
		//init white
		board[0][0].setPiece(new Rook(board[0][0],true));
		board[1][0].setPiece(new Knight(board[1][0],true));
		board[2][0].setPiece(new Bishop(board[2][0],true));
		board[3][0].setPiece(new Queen(board[3][0],true));
		board[4][0].setPiece(new King(board[4][0],true));
		board[5][0].setPiece(new Bishop(board[5][0],true));
		board[6][0].setPiece(new Knight(board[6][0],true));
		board[7][0].setPiece(new Rook(board[7][0],true));
		//pawn generator
		for(int i=0;i<8;i++)
			board[i][1].setPiece(new Pawn(board[i][1],true));

		//init black
		board[0][7].setPiece(new Rook(board[0][7],false));
		board[1][7].setPiece(new Knight(board[1][7],false));
		board[2][7].setPiece(new Bishop(board[2][7],false));
		board[3][7].setPiece(new Queen(board[3][7],false));
		board[4][7].setPiece(new King(board[4][7],false));
		board[5][7].setPiece(new Bishop(board[5][7],false));
		board[6][7].setPiece(new Knight(board[6][7],false));
		board[7][7].setPiece(new Rook(board[7][7],false));
		//pawn generator
		for(int i=0;i<8;i++)
			board[i][6].setPiece(new Pawn(board[i][6],false));
	}

	public void playMove(Move move) {
		this.board[move.getSquare0().getX()][move.getSquare0().getY()].getPiece().setSquare(this.board[move.getSquare1().getX()][move.getSquare1().getY()]);
		this.board[move.getSquare0().getX()][move.getSquare0().getY()].setPiece(null);
		this.board[move.getSquare1().getX()][move.getSquare1().getY()].setPiece(move.getPiece());
	}

	public void addPiece(Piece piece, int x, int y) {
		piece.setSquare(board[x][y]);
		board[x][y].setPiece(piece);
	}

	public List<Square> getSquaresPiece(boolean colorPlayer){
		List<Square> squares = new ArrayList<Square>();
		for(int j=0;j<board.length;j++)
			for(int i=0;i<board[j].length;i++)
				if(board[i][j].getPiece()!=null&&board[i][j].getPiece().isColor()==colorPlayer) {
					squares.add(board[i][j]);
				}
		return squares;
	}

	public Square getSquareKing(boolean color) throws Error {
		for(int j=0;j<board.length;j++)
			for(int i=0;i<board[j].length;i++)
				if((board[i][j].getPiece()!=null)
						&&board[i][j].getPiece().isColor()==color
						&&board[i][j].getPiece() instanceof King)
					return board[i][j];
		System.out.println(this);
		throw new Error();
	}

	public Square[][] getBoard() {
		return this.board;
	}

	public void setBoard(Square[][] board) {
		this.board = board;
	}

	public String toString() {
		String res="  A  B  C  D  E  F  G  H\n";
		String alphabet="12345678";
		for(int j=0;j<this.board.length;j++) {
			res+=alphabet.substring(j,j+1);
			for(int i=0;i<this.board[j].length;i++) {
				if(board[i][j].getPiece()!=null) {
					res+="["+board[i][j].getPiece().toString()+"]";
				}else {
					res+="[ ]";
				}
			}
			res+="\n";
		}
		return res;
	}

	public Object clone() {
		ChessBoard c = null;

		// On récupère l'instance à renvoyer par l'appel de la 
		// méthode super.clone()
		c = new ChessBoard();
		for(int j=0;j<this.board.length;j++)
			for(int i=0;i<this.board[j].length;i++) {
				c.board[i][j] = new Square(i, j);
				if(this.board[i][j].getPiece()!=null) {
					if(this.board[i][j].getPiece() instanceof Bishop )
						c.board[i][j].setPiece(new Bishop(this.board[i][j],this.board[i][j].getPiece().isColor()));
					if(this.board[i][j].getPiece() instanceof King )
						c.board[i][j].setPiece(new King(this.board[i][j],this.board[i][j].getPiece().isColor()));
					if(this.board[i][j].getPiece() instanceof Knight )
						c.board[i][j].setPiece(new Knight(this.board[i][j],this.board[i][j].getPiece().isColor()));
					if(this.board[i][j].getPiece() instanceof Pawn )
						c.board[i][j].setPiece(new Pawn(this.board[i][j],this.board[i][j].getPiece().isColor()));
					if(this.board[i][j].getPiece() instanceof Queen )
						c.board[i][j].setPiece(new Queen(this.board[i][j],this.board[i][j].getPiece().isColor()));
					if(this.board[i][j].getPiece() instanceof Rook )
						c.board[i][j].setPiece(new Rook(this.board[i][j],this.board[i][j].getPiece().isColor()));
				}
			}

		// on renvoie le clone
		return c;
	}
}
