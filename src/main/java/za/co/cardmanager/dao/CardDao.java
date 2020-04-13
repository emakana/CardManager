package za.co.cardmanager.dao;

import java.util.List;

import za.co.cardmanager.entity.Card;

public interface CardDao {
	void createCard(Card card) throws CardException;
	Card findCardByCardId(String cardId) throws CardException;
	List<Card> findAllCards() throws CardException;
}
