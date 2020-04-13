package za.co.cardmanager.dao;

import java.util.List;

import za.co.cardmanager.entity.Card;
import za.co.cardmanager.entity.CardHolder;

public interface CardHolderDao {
 void createCardHolder(CardHolder cardHolder, Card card) throws CardException;
 CardHolder findCardHolderByGovId(String govId) throws CardException;
 List<CardHolder> findAllCardHolders() throws CardException;
 List<CardHolder> findAllSortedBySurname() throws CardException;
 void replaceCardHolderCard(CardHolder cardHolder,Card sourceCard, Card replacementCard) throws CardException;
 void addSecondaryCard(CardHolder cardHolder, Card secondaryCard) throws CardException;
}
