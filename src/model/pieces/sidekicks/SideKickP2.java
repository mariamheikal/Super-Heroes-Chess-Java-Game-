package model.pieces.sidekicks;

import model.game.Direction;
import model.game.Game;
import exceptions.UnallowedMovementException;

public class SideKickP2 extends SideKick {

	public SideKickP2(Game game, String name) {
		super(game.getPlayer2(), game, name);
	}

	@Override
	public void moveUp() throws UnallowedMovementException {
		throw new UnallowedMovementException("SideKick for player "+this.getOwner().getName()+" can not move Up.",this, Direction.UP);
	}

	@Override
	public void moveUpRight() throws UnallowedMovementException {
		throw new UnallowedMovementException("SideKick for player "+this.getOwner().getName()+" can not move Upright.",this, Direction.UPRIGHT);
	}

	@Override
	public void moveUpLeft() throws UnallowedMovementException {
		throw new UnallowedMovementException("SideKick for player "+this.getOwner().getName()+" can not move Upleft.",this, Direction.UPLEFT);
	}
}
