package Modele;

public class Move {
	private Square square0,square1;
	private Piece piece,pieceTaken;
	private boolean taken;
	private int turn;
	private int value=0;

	private Move(Square square0, Square square1, Piece piece,boolean taken,Piece pieceTaken) {
		// TODO Auto-generated constructor stub
		this.square0 = square0;
		this.square1 = square1;
		this.piece=piece;
		this.taken=taken;
		this.pieceTaken=pieceTaken;
		this.turn=MoveHistory.getProgressTurn();
	}

	public Move(Square square0, Square square1, Piece piece) {
		this(square0,square1,piece,false,null);
	}

	public Move(Square square0, Square square1, Piece piece,Piece pieceTaken) {
		this(square0,square1,piece,true,pieceTaken);
	}

	public Square getSquare0() {
		return square0;
	}

	public Square getSquare1() {
		return square1;
	}

	public Piece getPiece() {
		return piece;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public int getTurn() {
		return turn;
	}

	public void setTurn(int turn) {
		this.turn = turn;
	}

	public Piece getPieceTaken() {
		return pieceTaken;
	}

	public void setPieceTaken(Piece pieceTaken) {
		this.pieceTaken = pieceTaken;
	}

	public boolean isTaken() {
		return taken;
	}

	public void setTaken(boolean taken) {
		this.taken = taken;
	}

	public String toString() {
		return this.piece+":"+this.piece.getName()+this.square0+"-"+this.square1
				+(taken?pieceTaken:"")+" - "+value;
	}
}
