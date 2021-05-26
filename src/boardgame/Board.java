package boardgame;

public class Board {
	private Piece[][] pieces;
	private int rows;
	private int columns;

	public Board( int rows, int columns) {

		
		this.rows = rows;
		this.columns = columns;
		pieces= new Piece[rows][columns];
	}

	public Piece[][] getPieces() {
		return pieces;
	}

	public void setPieces(Piece[][] pieces) {
		this.pieces = pieces;
	}

	public int getRows() {
		return rows;
	}

	public void setRows(int rows) {
		this.rows = rows;
	}

	public int getColumns() {
		return columns;
	}

	public void setColumns(int columns) {
		this.columns = columns;
	}
	
	public Piece piece (int row, int column) {
		return pieces[row][column];
	}
	
	public Piece piece(Position position) {
		return pieces[position.getRow()][position.getColumn()];
	}
	
	public void placePiece(Piece piece, Position position) {
	
		pieces[position.getRow()][position.getColumn()]=piece;
		piece.position=position;
	
		
	}
	
	
	
	
	
	

}
