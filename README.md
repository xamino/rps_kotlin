# Rock Paper Scissors in Kotlin

This is a test project for trying out Kotlin.

# What it Does

The implemented program plays multiple games of rock paper scissors using implemented players.
There is a truly random player (selects the move to play randomly each time they play) and another
one which always picks the same move.

The main method plays by default 100 games and prints the results.

# Technology

* Kotlin
* Gradle
* Mockito for test mocking
* Tests are run using JUnit

# Running

* `Main.kt` is the main program. Simply executing it with `./gradlew run` will play 100 games with a
  random player against a static player playing rock.
    * You can pass in a positive integer to play the specified amount of games instead.
* Tests can be found in the test directory. Notably, the players and the "play one game" class have
  full test coverage.
    * While 'Main.kt' also has a test, the test only verifies it executes successfully – I do not
      check the println outputs.
* You can run `./gradlew jar` (for Linux) to get a compiled JAR under `/build/libs`
