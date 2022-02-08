package Test;

import org.junit.Before;
import org.junit.Test;
import org.junit.Assert;

import Modele.ChessBoard;
import Modele.Pieces.*;

public class TestMoveablePiece {
	ChessBoard chessBoard;
	@Before
	public void begginningtest() {
		chessBoard = new ChessBoard();
		
		//System.out.println(chessBoard);
	}
	@Test
	public void testPawnMove1() {
		Pawn pawn = new Pawn(chessBoard.getBoard()[3][1],true);
		chessBoard.addPiece(pawn,3,1);
		System.out.println(chessBoard);
		Assert.assertTrue("nombre de mouvements attendus : 2",
				pawn.getMoves(chessBoard).size()==2);
	}
	@Test
	public void testPawnMove2() {
		Pawn pawn1 = new Pawn(chessBoard.getBoard()[3][1],true);
		Pawn pawn2 = new Pawn(chessBoard.getBoard()[4][2],false);
		chessBoard.addPiece(pawn1,3,1);
		chessBoard.addPiece(pawn2,4,2);
		System.out.println(chessBoard);
		Assert.assertTrue("nombre de mouvements attendus : 3",
				pawn1.getMoves(chessBoard).size()==3);
	}
	@Test
	public void testPawnMove3() {
		Pawn pawn1 = new Pawn(chessBoard.getBoard()[3][1],true);
		Pawn pawn2 = new Pawn(chessBoard.getBoard()[3][2],false);
		chessBoard.addPiece(pawn1,3,1);
		chessBoard.addPiece(pawn2,3,2);
		System.out.println(chessBoard);
		Assert.assertTrue("nombre de mouvements attendus : 0",
				pawn1.getMoves(chessBoard).size()==0);
	}
	@Test
	public void testKnight1() {
		Knight knight1 = new Knight(chessBoard.getBoard()[3][1],true);
		chessBoard.addPiece(knight1,3,1);
		System.out.println(chessBoard);
		Assert.assertTrue("nombre de mouvements attendus : 6",
				knight1.getMoves(chessBoard).size()==6);
	}
	@Test
	public void testKnight2() {
		Knight knight1 = new Knight(chessBoard.getBoard()[3][3],true);
		chessBoard.addPiece(knight1,3,3);
		System.out.println(chessBoard);
		Assert.assertTrue("nombre de mouvements attendus : 8",
				knight1.getMoves(chessBoard).size()==8);
	}
	@Test
	public void testKnight3() {
		Knight knight1 = new Knight(chessBoard.getBoard()[3][3],true);
		Pawn pawn1 = new Pawn(chessBoard.getBoard()[1][2],true);
		chessBoard.addPiece(knight1,3,3);
		chessBoard.addPiece(pawn1,1,2);
		System.out.println(chessBoard);
		Assert.assertTrue("nombre de mouvements attendus : 7",
				knight1.getMoves(chessBoard).size()==7);
	}
	@Test
	public void testKnight4() {
		Knight knight1 = new Knight(chessBoard.getBoard()[3][3],true);
		Pawn pawn1 = new Pawn(chessBoard.getBoard()[1][2],false);
		chessBoard.addPiece(knight1,3,3);
		chessBoard.addPiece(pawn1,1,2);
		System.out.println(chessBoard);
		Assert.assertTrue("nombre de mouvements attendus : 8",
				knight1.getMoves(chessBoard).size()==8);
	}
}
