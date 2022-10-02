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
	open fun record(result: GameResult) {
		recordMap[result] = recordMap.getOrDefault(result, 0) + 1
	}

	/**
	 * Retrieves the total number of game results of the specified type. Defaults to zero if none
	 * played.
	 */
	open fun getRecordOf(result: GameResult): Int {
		return recordMap.getOrDefault(result, 0)
	}
}
