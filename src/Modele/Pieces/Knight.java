package Modele.Pieces;

import Modele.Piece;
import Modele.Square;

public class Knight extends Piece  {

	public Knight(Square square, boolean color) {
		super(square, color,"Cavalier");
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean isMoveable(Square square, Square[][] board) {
		// TODO Auto-generated method stub
		int moveX = this.square.getX()-square.getX();
		int moveY =	this.square.getY()-square.getY();
		moveX*=((moveX>0)?1:-1);
		moveY*=((moveY>0)?1:-1);
		if(square.getPiece()==null) {
			return moveX+moveY==3&&moveX!=0&&moveY!=0;
		}else {
			return moveX+moveY==3&&moveX!=0&&moveY!=0
					&&square.getPiece().isColor()!=this.isColor();
		}
	}

	public String toString() {
		return isColor()?"c":"C";
	}
}
