package Modele;

public class Square implements Cloneable {
	private int x,y;
	private Piece piece;
	private boolean color;

	public Square(int x, int y,Piece piece) {
		this.x=x;
		this.y=y;
		this.piece = piece;
		this.color =(Math.floorMod(x+y,2)==1);
	}
	
	public Square(int x, int y) {
		this(x,y,null);
	}
	
	public int getX() {
		return x;
	}
	
	public void setX(int x) {
		this.x = x;
	}
	
	public int getY() {
		return y;
	}
	
	public void setY(int y) {
		this.y = y;
	}
	
	public Piece getPiece() {
		return piece;
	}
	
	public void setPiece(Piece piece) {
		this.piece = piece;
	}
	
	public String toString() {
		String alphabet="ABCDEFGH";
		return alphabet.substring(this.x, x+1)+(int)(this.y+1);
	}
}
