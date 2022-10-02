package game

import core.GameResult
import core.Moves
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.mockito.kotlin.*
import players.Player

internal class GameTest {

	/**
	 * Class under test, in this case the game itself
	 */
	private var classUnderTest: Game = Game()

	/**
	 * To make this a clearly defined unit test we don't want to test the [Player] class, so mock
	 * them – they have their own tests.
	 */
	private var oneMockPlayer: Player = mock()
	private var twoMockPlayer: Player = mock()

	@BeforeEach
	fun setup() {
		reset(oneMockPlayer)
		reset(twoMockPlayer)
	}

	@Test
	fun playTieWorks() {
		whenever(oneMockPlayer.play()).thenReturn(Moves.ROCK)
		whenever(twoMockPlayer.play()).thenReturn(Moves.ROCK)

		classUnderTest.play(oneMockPlayer, twoMockPlayer)

		verify(oneMockPlayer).play()
		verify(twoMockPlayer).play()

		verify(oneMockPlayer).record(eq(GameResult.TIE))
		verify(twoMockPlayer).record(eq(GameResult.TIE))
	}

	@Test
	fun playWinWorks() {
		whenever(oneMockPlayer.play()).thenReturn(Moves.ROCK)
		whenever(twoMockPlayer.play()).thenReturn(Moves.SCISSOR)

		classUnderTest.play(oneMockPlayer, twoMockPlayer)

		verify(oneMockPlayer).play()
		verify(twoMockPlayer).play()

		verify(oneMockPlayer).record(eq(GameResult.WIN))
		verify(twoMockPlayer).record(eq(GameResult.LOSE))
	}

	@Test
	fun playLoseWorks() {
		whenever(oneMockPlayer.play()).thenReturn(Moves.SCISSOR)
		whenever(twoMockPlayer.play()).thenReturn(Moves.ROCK)

		classUnderTest.play(oneMockPlayer, twoMockPlayer)

		verify(oneMockPlayer).play()
		verify(twoMockPlayer).play()

		verify(oneMockPlayer).record(eq(GameResult.LOSE))
		verify(twoMockPlayer).record(eq(GameResult.WIN))
	}
}
