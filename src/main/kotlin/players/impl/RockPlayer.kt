package players.impl

import core.Moves
import players.Player

/**
 * The rock player plays only [Moves.ROCK] for its moves, all the time.
 */
class RockPlayer : Player() {
	override fun play(): Moves = Moves.ROCK
}
