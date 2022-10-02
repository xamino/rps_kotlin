package players

import core.GameResult
import core.Moves
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Timeout
import players.impl.RandomPlayer
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
	 * Test the random player, which is difficult because it is random. Thus, play game until we get
	 * any different result to ensure it is as non-static as possible. We fully expect this to
	 * return rapidly, but just to prevent it from playing longer than we want, we limit it to 100ms.
	 */
	@Test
	@Timeout(100)
	fun playRandom() {
		val randomPlayer = RandomPlayer()

		val firstMove = randomPlayer.play();
		while (true) {
			if (randomPlayer.play() != firstMove)
				break
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
