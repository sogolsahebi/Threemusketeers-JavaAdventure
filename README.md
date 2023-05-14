# Threemusketeers-JavaAdventure
# Three Musketeers Game

This repository contains the implementation of the Three Musketeers Game, a 5x5 square grid strategic board game.  goal in the game is to outwit the Guards and capture them while avoiding being trapped themselves. The game follows to well-defined rules and objectives, providing players with a challenging and entertaining experience.
## Game Rules and Goals

The game follows the following rules:

1. **Turns**: The Musketeers always go first. Each player makes one move before passing the turn to their opponent.
2. **Musketeers**: On the Musketeers' turn, a Musketeer can move to an adjacent orthogonal (neighboring, non-diagonal) cell occupied by a Guard, capturing it and occupying that cell.
3. **Guards**: On the Guards' turn, a Guard can move to an adjacent orthogonal empty cell.
4. **Goals**: 
    - The Musketeers win if they cannot capture any Guards AND if they are not on the same row or column.
    - The Guards win if all the Musketeers are on the same row or column at any point in the game.

## Features

The project includes several user stories that were developed and implemented collaboratively:
### User Story 0.1: Save Feature

- Owner: BingMing Zhang
- Priority: 2
- Description: BingMing Zhang implemented a user interface that allows players to save chosen parts of their game progress. This feature enables players to start the game at a specific save point when they resume their gameplay. The user interface provides a convenient and flexible way to save the game on the player's computer at a desired location.

### User Story 0.2: Audience Feature

- Owner: Razi Messinger
- Priority: 3
- Description: Razi Messinger implemented the audience feature, which adds an interactive element to the game. By creating audience objects, players receive feedback and reactions that provide a sense of reward and motivation for their moves. This feature enhances the overall user experience and makes the game more engaging.

### User Story 0.3: Hint Feature

- Owner: BingMing Zhang
- Priority: 2
- Description: BingMing Zhang implemented the hint feature to assist players in navigating challenging situations. By creating string objects that provide hints, players can get guidance for their next moves when they feel lost or encounter difficulties. This feature improves the gameplay experience by helping players make informed decisions.

### User Story 0.4: Audio Feature

- Owner: Nasim Bondar Sahebi
- Priority: 3
- Description: Nasim Bondar Sahebi enhanced the game experience by implementing the audio feature. This feature incorporates various audio elements such as background music, sound effects for movements and captures, and other audio cues. By introducing auditory feedback, the game becomes more immersive, engaging, and enjoyable for the players.

### User Story 0.5: Special Move Feature

- Owner: Thomas Kolman
- Priority: 3
- Description: Thomas Kolman introduced the special move feature to add excitement and unpredictability to the game. This feature allows players to perform unique and challenging moves that deviate from the standard gameplay. The inclusion of special moves enhances the strategic depth of the game and provides players with new and thrilling strategies to explore.

### User Story 0.6: Changing Agent Feature

- Owner: Razi Messinger
- Priority: 2
- Description: Razi Messinger implemented the changing agent feature, which provides players with the ability to switch between different computer agents during gameplay. By creating a user interface that facilitates the swapping of agents, players can choose to play against different AI opponents. This feature adds flexibility and allows players to adjust the difficulty level or challenge themselves against various opponents.

For more details and documentation, please refer to the following files:

- [designPatterns.pdf](https://github.com/sogolsahebi/Threemusketeers-JavaAdventure/tree/master/doc/s2/designPatterns.pdf): This document provides insights into the design patterns used in the implementation of the game.
- [Presentation.pdf](https://github.com/sogolsahebi/Threemusketeers-JavaAdventure/tree/master/doc/s2/Presentation.pdf): This presentation provides an overview of the game and its features, giving a deeper understanding of its gameplay mechanics and design choices.

## Additional Resources

For more detailed information about the design and implementation of the game, please refer to the following documents:

- [Design Patterns Document](https://github.com/sogolsahebi/Threemusketeers-JavaAdventure/tree/master/doc/s2/designPatterns.pdf): This document provides insights into the design patterns utilized in the development of the game, offering a comprehensive overview of the software architecture.

- [Presentation Document](https://github.com/sogolsahebi/Threemusketeers-JavaAdventure/tree/master/doc/s2/Presentation.pdf): This document contains a presentation given by our team, outlining the features, challenges, and achievements of the Three Musketeers Game project.

We encourage you to explore these resources to gain a deeper understanding of the game's development process and underlying concepts.
