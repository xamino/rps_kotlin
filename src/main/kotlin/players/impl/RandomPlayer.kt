package players.impl

import core.Moves
import players.Player
import kotlin.random.Random

/**
 * Player that randomly picks a move to play.
 */
class RandomPlayer : Player() {
	override fun play(): Moves {
		return Moves.values()[Random.nextInt(Moves.values().size)]
	}
}
