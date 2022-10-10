# Rock Paper Scissors game
A simple rock paper scissors, game. The game is implemented in pure java, no helper libraries were used, apart the UI which is build using a small command line interface lib. 
The game supports a bot, against which the human player can play. There is a symulation option that has two bots playing against eachother. 

## Tech Stack

1. Java 17
1. Gradle with kotlin DSL 
2. JUnit 5
3. SLFJ + Logback for internal logging.
3. PicoCLI for the UI

## How to build 

Simple run the following command to build an executable jar.
```bash 
gradle clean build 
```

## How to run 
Simply run the executable jar. Picocli will show all available option. 

```bash
java -jar ui.jar 
```

## Structure 

The app consist of two parts the game engine and the game ui. The ui is build using [picocli](https://picocli.info/). 

## Motivation
A classic two game rock-paper-scissors game. The game assumes two players, but a different player count can be implemented if needed. The interaction is based on events so that any type of UI can be added. A simple UI will be implemented for the purposes of the interview.

## TODO

1. Better test coverage (at least 85% )
2. Complete the UI, allowing a human player to player against a bot. 
