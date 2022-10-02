package game

import core.GameResult
import players.Player

/**
 * Implementation of a single game for two players. Plays the game and records the result.
 */
class Game {
	fun play(a: Player, b: Player) {
		val aMove = a.play()
		val bMove = b.play()

		when (aMove.compare(bMove)) {
			GameResult.WIN -> {
				a.record(GameResult.WIN)
				b.record(GameResult.LOSE)
			}
			GameResult.LOSE -> {
				a.record(GameResult.LOSE)
				b.record(GameResult.WIN)
			}
			GameResult.TIE -> {
				a.record(GameResult.TIE)
				b.record(GameResult.TIE)
			}
		}
	}
}
