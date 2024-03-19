package GoFish;
import ClassicCards.ClassicCard;
import ClassicCards.ClassicCardValue;
import Interfaces.*;

import java.util.ArrayList;

public class GoFish implements Game {
    private ArrayList<GoFishPlayer> players;
    private GoFishDeck deck;
    public GoFish(int numPlayers) {
        // TODO: Ask for names either in main or here. Add choosing of Bots
        players = new ArrayList<GoFishPlayer>();
        for(int i = 0; i < numPlayers; i++) {
            String name = "BOB"; // Temp variable
            players.add(new GoFishPlayer(name));
        }
        deck = new GoFishDeck();
        deck.shuffle();
    }

    @Override
    public void play() {
        boolean isDone = false;
        int playerIndex = 0;
        deal();
        while(!isDone) {
            GoFishPlayer activePlayer = players.get(playerIndex);
            // TODO: show player's cards, prompt for asking which card to pick and who to ask, receive answer
            ClassicCardValue value = ClassicCardValue.KING;
            GoFishPlayer askedPlayer = players.get(1);
            int valueCount = askedPlayer.has(value);
            if(valueCount > 0) { //asked player has cards with that rank case
                ClassicCard[] transferredCards = askedPlayer.loseCards(valueCount, value);
                //TODO: show cards in command line
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

}
