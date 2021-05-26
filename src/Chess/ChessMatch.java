package Chess;

import Chess.piece.King;
import Chess.piece.Rook;
import boardgame.Board;
import boardgame.Position;

public class ChessMatch {

	private Board board;
	
	
	public ChessMatch() {
		board= new Board(8,8);
		initialSetup();
	}
	
	
	public ChessPiece[][] getPieces(){
		
		ChessPiece[][] mat= new ChessPiece[board.getRows()][board.getColumns()];
		
		for(int l=0;l<board.getRows();l++) {
			
			for(int c=0;c<board.getColumns();c++) {
				mat[l][c]= (ChessPiece)board.piece(l,c);
			}
		}

		return mat;
		
	}
	
	private void initialSetup() {
		board.placePiece(new Rook (board, Color.WHITE), new Position(9,1));
		board.placePiece(new King(board, Color.BLACK), new Position(0,4));
		board.placePiece(new King(board, Color.WHITE), new Position(7,4));
		
	}
	
	
	
}
