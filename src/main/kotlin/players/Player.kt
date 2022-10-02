package players

import core.GameResult
import core.Moves

/**
 * Abstract shared interfaces for a rock paper scissors player.
 */
abstract class Player {
	/**
	 * Map that stores the results of all games the player participates in.
	 */
	private val recordMap = HashMap<GameResult, Int>()

	/**
	 * Implementation of the player playing a game of rock paper scissors.
	 */
	abstract fun play(): Moves

	/**
	 * Stores the result of a single game.
	 */
	fun record(result: GameResult) {
		recordMap[result] = recordMap.getOrDefault(result, 0) + 1
	}
}
