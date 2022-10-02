import core.GameResult
import core.Moves
import game.Game
import players.Player
import players.impl.RandomPlayer
import players.impl.StaticPlayer

fun main(args: Array<String>) {
	var totalGames = 100
	if (args.isNotEmpty()) {
		totalGames = Integer.parseInt(args[0])
	}
	println("Will play <$totalGames> games")

	val game = Game()
	val randomPlayer = RandomPlayer()
	val rockPlayer = StaticPlayer(Moves.ROCK)
	println("Today's contestants: the random player and the rock player!")
	for (x in 0..totalGames) {
		game.play(randomPlayer, rockPlayer)
	}
	println("And here are the results:")
	printSumRecord(randomPlayer, rockPlayer)
}

fun printSumRecord(vararg players: Player) {
	for (player in players) {
		println("Player <${player.name()}> results:")
		println("\tWins: ${player.getRecordOf(GameResult.WIN)}")
		println("\tTies: ${player.getRecordOf(GameResult.TIE)}")
		println("\tLoses: ${player.getRecordOf(GameResult.LOSE)}")
	}
}
