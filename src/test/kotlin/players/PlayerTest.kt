package players

import core.GameResult
import core.Moves
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import players.impl.StaticPlayer

internal class PlayerTest {

	/**
	 * Ensure the [StaticPlayer] plays the same move on subsequent calls. Very close to
	 * assert(true, true), but... you never know.
	 */
	@Test
	fun playStatic() {
		val staticPlayer = StaticPlayer(Moves.PAPER)

		for (x in 1..10) {
			assertEquals(Moves.PAPER, staticPlayer.play(), "Static player always plays same move")
		}
	}

	/**
	 * Ensure on a basic level that the recording of [GameResult] scores works on the [Player]
	 * class, including subsequent plays or before any play is even recorded.
	 */
	@Test
	fun record() {
		val player = StaticPlayer(Moves.ROCK)

		// Fetching a record before a result is recorded results in valid zero returned (even though map is empty)
		assertEquals(0, player.getRecordOf(GameResult.WIN))

		// Playing a game however updates the value
		player.record(GameResult.WIN)
		assertEquals(1, player.getRecordOf(GameResult.WIN))

		// Playing a second game increments it
		player.record(GameResult.WIN)
		assertEquals(2, player.getRecordOf(GameResult.WIN))
	}
}
