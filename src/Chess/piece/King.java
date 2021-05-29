package Chess.piece;

import Chess.ChessMatch;
import Chess.ChessPiece;
import Chess.Color;
import boardgame.Board;
import boardgame.Position;

public class King extends ChessPiece {
	private ChessMatch chessMatch;

	public King(Board board, Color color, ChessMatch chessMatch) {
		super(board, color);
		this.chessMatch=chessMatch;
		// TODO Auto-generated constructor stub
	}

	public String toString() {
		return "K";

	}

	private boolean canMove(Position position) {
		ChessPiece p = (ChessPiece) getBoard().piece(position);

		return p == null || p.getColor() != getColor();

	}
	private boolean testRookCastling  (Position position) {
		ChessPiece p = (ChessPiece)getBoard().piece(position);
		
		return p!=null && p instanceof Rook && p.getMoveCount()==0 && p.getColor()==getColor();
		
	}
	
	
	

	@Override
	public boolean[][] possibleMoves() {
		boolean[][] mat = new boolean[getBoard().getRows()][getBoard().getColumns()];

		Position p = new Position(0, 0);

		// above
		p.setValues(position.getRow() - 1, position.getColumn());
		if (getBoard().positionExists(p) && canMove(p)) {
			mat[p.getRow()][p.getColumn()] = true;

		}

		// above
		p.setValues(position.getRow() + 1, position.getColumn());

		if (getBoard().positionExists(p) && canMove(p)) {
			mat[p.getRow()][p.getColumn()] = true;

		}

		// left
		p.setValues(position.getRow(), position.getColumn() - 1);

		if (getBoard().positionExists(p) && canMove(p)) {
			mat[p.getRow()][p.getColumn()] = true;

		}

		// right

		p.setValues(position.getRow(), position.getColumn() + 1);

		if (getBoard().positionExists(p) && canMove(p)) {
			mat[p.getRow()][p.getColumn()] = true;

		}

		// nw
		p.setValues(position.getRow() - 1, position.getColumn() - 1);

		if (getBoard().positionExists(p) && canMove(p)) {
			mat[p.getRow()][p.getColumn()] = true;

		}
		// NE
		p.setValues(position.getRow() - 1, position.getColumn() + 1);

		if (getBoard().positionExists(p) && canMove(p)) {
			mat[p.getRow()][p.getColumn()] = true;

		}

		// SW
		p.setValues(position.getRow() + 1, position.getColumn() - 1);

		if (getBoard().positionExists(p) && canMove(p)) {
			mat[p.getRow()][p.getColumn()] = true;

		}
		// SE 

		p.setValues(position.getRow() + 1, position.getColumn() + 1);

		if (getBoard().positionExists(p) && canMove(p)) {
			mat[p.getRow()][p.getColumn()] = true;

		}
		if(getMoveCount()==0 && !chessMatch.getCheck()) {
			Position pT1 = new Position(position.getRow(), position.getColumn()+3);
			
			if(testRookCastling (pT1)) {	
			Position p1 = new Position(position.getRow(), position.getColumn()+1);	
			Position p2 = new Position(position.getRow(), position.getColumn()+2);
			if(getBoard().piece(p1)==null && getBoard().piece(p2) ==null) {
				mat[position.getRow()][position.getColumn()+2]=true;
				
			}
			
			
			}
			
			Position pT2= new Position(position.getRow(), position.getColumn()-4);
					
		if(testRookCastling(pT2)) {
			Position p1 = new Position(position.getRow(), position.getColumn()-1);	
			Position p2 = new Position(position.getRow(), position.getColumn()-2);
			Position p3 = new Position(position.getRow(), position.getColumn()-3);
			if(getBoard().piece(p1)==null && getBoard().piece(p2) ==null && getBoard().piece(p3)==null) {
				mat[position.getRow()][position.getColumn()-2]=true;
				
			}
			
		}
			
			
		}

		return mat;
	}

}
