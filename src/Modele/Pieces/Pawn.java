package Modele.Pieces;

import java.util.List;

import Modele.ChessBoard;
import Modele.Move;
import Modele.Piece;
import Modele.Square;

public class Pawn extends Piece {

	public Pawn(Square square, boolean color) {
		super(square, color,"Pion");
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean isMoveable(Square square, Square[][] board) {
		// TODO Auto-generated method stub
		int moveX = this.square.getX()-square.getX();
		int moveY =	this.square.getY()-square.getY();
		moveX*=((moveX>0)?1:-1);
		int sensY=(moveY>0)?-1:1;
		//management of player's color
		if(this.isColor()) {
			switch(moveY) {
			case -1 :
				//attack
				if(moveX==1&&square.getPiece()!=null&&square.getPiece().isColor()!=this.isColor()) {
					return true;
				}
				//simple move
				if(moveX==0&&square.getPiece()==null) {
					return true;
				}
				//super first move
			case -2 :
				if(this.square.getY()==1&&moveX==0&&board[square.getX()][square.getY()-sensY].getPiece()==null&&square.getPiece()==null) {
					return true;
				}
			default :

			}
		}else {
			switch(moveY) {
			case 1 :
				//simple move
				if(moveX==0&&square.getPiece()==null) {
					return true;
				}
				//attack
				if(moveX==1&&square.getPiece()!=null&&square.getPiece().isColor()!=this.isColor()) {
					return true;
				}
				//super first move
			case 2 :
				if(this.square.getY()==6&&moveX==0&&board[square.getX()][square.getY()-sensY].getPiece()==null&&square.getPiece()==null) {
					return true;
				}
			default :
			}

		}
		return false;
	}
	public String toString() {
		return isColor()?"p":"P";
	}

	
}
