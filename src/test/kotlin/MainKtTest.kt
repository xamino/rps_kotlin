import org.junit.jupiter.api.Test

/**
 * Test some functionality of the main method. Note: I don't verify the System.out messages, really
 * all we're testing here automatically is that no exceptions happen. Anything else is human parsing
 * to check the sanity. We could change this if we wanted to.
 */
internal class MainKtTest {
	/**
	 * Test that we can call the program with no arguments, and it runs with no exceptions.
	 */
	@Test
	fun play100Games() {
		main(arrayOf())
	}

	/**
	 * Ensure we can pass a number as a string, and it is parsed correctly with no exception.
	 */
	@Test
	fun playTwoGames() {
		main(arrayOf("2"))
	}

	/**
	 * Edge case: negative, but valid number. Ideally we'd verify that this returns early and plays
	 * no games.
	 */
	@Test
	fun playNegativeGames() {
		main(arrayOf("-1"))
	}

	/**
	 * Ensure passing in a non-number doesn't break anything.
	 */
	@Test
	fun failParsing() {
		main(arrayOf("string"))
	}

	@Test
	fun ignoreMultipleArguments() {
		main(arrayOf("1", "ignored"))
	}
}
