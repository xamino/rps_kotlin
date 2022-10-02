package core

/**
 * Game moves available
 */
enum class Moves(private val beats: Int) {
	ROCK(2),
	PAPER(0),
	SCISSOR(1);

	/**
	 * Compare this move against the given move. Returns the [GameResult] of comparing the two moves
	 * from the perspective of this move.
	 */
	fun compare(move: Moves): GameResult {
		if (this == move)
			return GameResult.DRAW
		return if (move == values()[this.beats]) {
			GameResult.WIN
		} else {
			GameResult.LOSE
		}
	}
}
