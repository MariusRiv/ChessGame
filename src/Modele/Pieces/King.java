package Modele.Pieces;

import Modele.Piece;
import Modele.Square;

public class King extends Piece {

	public King(Square square, boolean color) {
		super(square, color,"Roi");
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean isMoveable(Square square, Square[][] board) {
		// TODO Auto-generated method stub
		int moveX = this.square.getX()-square.getX();
		int moveY =	this.square.getY()-square.getY();
		//moveX*=((moveX>0)?1:-1);
		//moveY*=((moveY>0)?1:-1);
		if(moveX==0&&moveY==0)
			return false;
		if(square.getPiece()==null) {
			return ((moveX>=-1&&moveX<=1)&&(moveY>=-1&&moveY<=1));
		}else {
			return ((moveX>=-1&&moveX<=1)&&(moveY>=-1&&moveY<=1))
					&&square.getPiece().isColor()!=this.isColor();
		}
	}

	public String toString() {
		return isColor()?"r":"R";
	}

}
