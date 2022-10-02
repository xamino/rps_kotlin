package players.impl

import core.Moves
import players.Player

/**
 * The static player always plays the same move, defined at creation.
 */
class StaticPlayer(private val move: Moves) : Player() {
	override fun name(): String = "$move"

	override fun play(): Moves = move
}
