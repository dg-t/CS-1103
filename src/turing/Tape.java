package turing;

public class Tape {
	
	// Instance variable of type Cell
	Cell currentCell;
	
	// Constructor to create a single Cell Tape
	public Tape() {	
		Cell newCell = new Cell();
		currentCell = newCell;
	}
	
	// Create method to return the pointer that points to the current cell
	public Cell getCurrentCell() {
		return this.currentCell;
	}
	
	// Create method to return the char from the current cell
	public char getContent() {
		return this.currentCell.content;
	}
	
	// Create method to change the char in the current cell to the specified value
	public void setContent(char character) {
		this.currentCell.content = character;
	}
	
	/**
	 * Create method that moves the current cell one position to the left along the tape. 
	 * Note that if the current cell is the leftmost cell that exists, then a new cell must be created 
	 * and added to the tape at the left of the current cell, and then the current cell pointer can be moved to point to the new cell. 
	 * The content of the new cell should be a blank space.
	 */
	public void moveLeft() {
		if (this.currentCell.prev == null) {
			Cell newCell = new Cell();
			newCell.content = ' ';
			newCell.next = currentCell;
			currentCell = newCell;
		}else{currentCell = currentCell.prev;}
	}
	
	/**
	 * Create method that moves the current cell one position to the right along the tape. 
	 * Note that if the current cell is the rightmost cell that exists, then a new cell must be created 
	 * and added to the tape at the right of the current cell, and then the current cell pointer can be moved to point to the new cell. 
	 * The content of the new cell should be a blank space.
	 */
	public void moveRight() {
		if (this.currentCell.next == null) {
			Cell newCell = new Cell();
			newCell.content = ' ';
			newCell.prev = currentCell;
			currentCell = newCell;
		}else{currentCell = currentCell.next;}
	}
	
	/**
	 * returns a String consisting of the chars from all the cells on the tape, 
	 * read from left to right, except that leading or trailing blank characters should be discarded. 
	 * The current cell pointer should not be moved by this method; 
	 * it should point to the same cell after the method is called as it did before.
	 */
	public String getTapeContents() {
		Cell runner = currentCell;
		while (runner.prev != null){
			runner = runner.prev;
		}
		if (runner.content==' ')
			runner=runner.next;
		String tapeContent="";
		while (runner.next != null){
			tapeContent.concat(Character.toString(runner.content));
			runner=runner.next;
		}
		return tapeContent;
	}
}
