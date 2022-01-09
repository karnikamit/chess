package com.personal.game.chess.impl;

public class Pawn extends Piece {

	public Pawn(boolean white) {
		super(white);
	}

	@Override
	public boolean canMove(Board board, Spot start, Spot end) {	// TODO moves => initial move, in the passing
		if (end.getPiece().isWhite() == this.isWhite()) {
            return false;	//pawn is blocked by its teammate
        }
		
		int x = Math.abs(start.getX() - end.getX());
        int y = Math.abs(start.getY() - end.getY());
        if(x + y == 1) {
        	if(end.getPiece() != null) {
        		return false;	// pawn is blocked to move forward
        	}return true;
        }else if(x - y == 0){
        	end.getPiece().setKilled(true);
        	return true;	// pawn captures the piece in spot
        }
        return false;	//anyother move is illeagal
        
	}

}
