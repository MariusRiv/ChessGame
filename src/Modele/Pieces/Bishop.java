package Modele.Pieces;

import Modele.Piece;
import Modele.Square;

public class Bishop extends Piece {

	public Bishop(Square square, boolean color) {
		super(square, color,"Fou");
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean isMoveable(Square square, Square[][] board) {
		// TODO Auto-generated method stub
		int moveX = this.square.getX()-square.getX();
		int moveY =	this.square.getY()-square.getY();
		int sensX=((moveX>0)?-1:1);
		int sensY=((moveY>0)?-1:1);
		if(moveX==0&&moveY==0)
			return false;
		if((moveX!=0&&moveY!=0)&&(moveX*sensX==moveY*sensY)) {
			int x = this.square.getX()+sensX;
			int y = this.square.getY()+sensY;
			if(x!=square.getX()&&y!=square.getY()){
				while(x!=square.getX()||y!=square.getY()) {
					if(x!=square.getX()&&y!=square.getY())
						if(board[x][y].getPiece()!=null)
							return false;
					x+=sensX;
					y+=sensY;
				}
				if(square.getPiece()==null) {
					return true;
				}else if(square.getPiece().isColor()!=this.isColor()) {
					return true;
				}
			}
		}
		return false;
	}
	public String toString() {
		return isColor()?"f":"F";
	}
}
