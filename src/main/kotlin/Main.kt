import core.GameResult
import core.Moves
import game.Game
import players.Player
import players.impl.RandomPlayer
import players.impl.StaticPlayer

/**
 * Play an amount of rock paper scissor games. Defaults to 100 but can be changed by setting an
 * integer for the first argument.
 */
fun main(args: Array<String>) {
	var totalGames = 100
	if (args.isNotEmpty()) {
		try {
			totalGames = Integer.parseInt(args[0])
		} catch (e: NumberFormatException) {
			println("Can't parse <${args[0]}> to an integer!")
			return
		}
		if (totalGames < 0) {
			println("Negative games? \uD83D\uDE03 Please try again.")
			return
		}
	}
	println("Will play $totalGames games.")

	val game = Game()
	val randomPlayer = RandomPlayer()
	val rockPlayer = StaticPlayer(Moves.ROCK)
	println("Today's contestants: the players <${randomPlayer.name()}> and <${rockPlayer.name()}>!")

	val startTime = System.currentTimeMillis()
	for (x in 1..totalGames) {
		game.play(randomPlayer, rockPlayer)
	}
	val duration = System.currentTimeMillis() - startTime
	println("Played $totalGames games in $duration ms")

	println("And here are the results:")
	printSumRecord(randomPlayer, rockPlayer)
}

/**
 * Print the results for each player.
 */
fun printSumRecord(vararg players: Player) {
	for (player in players) {
		println("Player <${player.name()}>:")
		println("\tWins: ${player.getRecordOf(GameResult.WIN)}")
		println("\tDraws: ${player.getRecordOf(GameResult.DRAW)}")
		println("\tLoses: ${player.getRecordOf(GameResult.LOSE)}")
	}
}
