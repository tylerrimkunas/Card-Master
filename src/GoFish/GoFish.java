package GoFish;
import ClassicCards.ClassicCard;
import ClassicCards.ClassicCardValue;
import Interfaces.*;

import java.util.ArrayList;
import java.util.Scanner;

public class GoFish implements Game {
    private ArrayList<GoFishPlayer> players;
    private GoFishDeck deck;
    public GoFish(int numPlayers) {
        players = new ArrayList<>();
        players.add(new GoFishPlayer("Player 1"));
        for(int i = 1; i < numPlayers; i++) {
            players.add(new GoFishBot("Bot " + i));
        }
        deck = new GoFishDeck();
        deck.shuffle();
        deal();
    }

    @Override
    public void play() {
        boolean isDone = false;
        int playerIndex = 0;
        Scanner strInput = new Scanner(System.in);
        Scanner intInput = new Scanner(System.in);
        while(!isDone) {
            GoFishPlayer activePlayer = players.get(playerIndex);
            GoFishPlayer askedPlayer;
            ClassicCardValue value;
            if(playerIndex == 0) { //Player's turn
                System.out.println("Your cards are: " + activePlayer.cardsToString() + "\nWho would you like to ask? ");
                String askName = strInput.nextLine();
                askedPlayer = findPlayer(askName);
                System.out.println("What card would you like to ask for? ");
                value = ClassicCardValue.convertInt(intInput.nextInt());
            }
            else { //bot's turn
                askedPlayer = findPlayer("Player 1");
                value = ClassicCardValue.ACE; //TODO: Needs further implementation
            }
            int valueCount = askedPlayer.has(value);
            if(valueCount > 0) { //asked player has cards with that rank case
                ClassicCard[] transferredCards = askedPlayer.loseCards(valueCount, value);
                activePlayer.gainCards(transferredCards);
                continue; //Repeat active player's turn
            }
            else if(deck.getTopCard() != null){ //Go Fish case
                activePlayer.gainCard((ClassicCard) deck.takeCard());
            } 
            if(isGameOver()) {
                isDone = true;
            }
            else {
                if(++playerIndex >= players.size()) {
                    playerIndex = 0;
                }
            }
        }
        Player winner = determineWinner();
        // Todo: show Winner
    }

    // TODO: deal either here or in GoFishDeck
    @Override
    public void deal() {
        for(GoFishPlayer p : players) {
            p.setCards(deck.deal());
        }
    }

    public Player determineWinner() {
        GoFishPlayer winner = players.get(0);
        for(GoFishPlayer p: players) {
            if(p.getScore() > winner.getScore()) {
                winner = p;
            }
        }
        return winner;
    }

    public boolean isGameOver() {
        if(deck.getTopCard() != null)
            return false;
        for(GoFishPlayer p: players) {
            if(p.getCards() != null)
                return false;
        }
        return true;
    }

    public GoFishPlayer findPlayer(String name) {
        for(GoFishPlayer p: players) {
            if(p.getName().equals(name)) {
                return p;
            }
        }
        return null;
    }

}
