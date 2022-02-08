package Modele;

public enum ValueOfPiece {
	
	King(100),
	Queen(9),
	Rook(5),
	Bishop(3),
	Knight(3),
	Pawn(1);
	public int value;
	
	ValueOfPiece(int i) {
		this.value=i;
	}
}
