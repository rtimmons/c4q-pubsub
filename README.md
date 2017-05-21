	**Ryan Timmons**
	**@rtimmons**

# Front Matter

[Lesson Plan](https://docs.google.com/document/d/1dyOgdAQXVWeSzw2mJZ5A-u4uS_svcUAFDodmRR7_ugQ/edit)

# Agenda.todo

- **Welcome and Import Project**

```sh

git clone 	https://github.com/rtimmons/c4q-pubsub 	 pubsub

./gradlew test
./gradlew idea
open pubsub.ipr

# Play the game:
./gradlew shadowJar
java -jar build/libs/*.jar

java -jar build/libs/*.jar 50 100

# (control+d to quit)
```

- **Warmup** @done(2017-05-21)

	- **Individual**: Change `GuessingGame` to pass in `min`/`max` from command-line @done(2017-05-21)

- **Morning New Material: Dependency Injection** @done(2017-05-21)

	- **Group**: Introduce Dependency Injection @done(2017-05-21)
	- **Group**: Extract `Printer` and inject into `GuessingGame` @done(2017-05-21)

		**Solution**: `printer-refactor`

```sh
git stash
git checkout printer-refactor
```

- **Morning Exercise**: Practice DI-Based Refactoring @done(2017-05-21)

	- **Individual**: Extract `Player` and inject @done(2017-05-21)
	- **Individual**: Add automated testing @done(2017-05-21)

		**Solution**: `player-refactor`


```sh

git stash
git fetch
git checkout lab-player

git stash
git fetch
git checkout player-refactor

```

- **Mockito**

- **Afternoon New Material: PubSub**

	- **Group**: Define PubSub together; Why use it?
	- **Group**: `Dispatcher`, and `Listener` interfaces

- **Afternoon Exercises**

	- **Individual**: Write `SerialDispatcher` and `PrintingListener` implementations and tests.

		**Solution**: `pubsub`

	- **Individual**: Model `NumberGame` as Events and Listeners

# PubSub

**Events**

- GameStarted
- RoundStarted
- RoundEnded
- GuessCreated
- PlayerDecision

**Context**

- StartMin
- StartMax
- KnownMax
- KnownMin
- CurrentGuess
- GuessCount

# Resources

- Mockito: http://www.vogella.com/tutorials/Mockito/article.html
- DI with Android: https://tech.just-eat.com/2015/10/26/dependency-injection-on-android/
