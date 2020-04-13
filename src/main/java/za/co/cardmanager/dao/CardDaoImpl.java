package za.co.cardmanager.dao;

import java.io.Serializable;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import za.co.cardmanager.entity.Card;

@Stateless
public class CardDaoImpl implements CardDao, Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@PersistenceContext(unitName = "card-unit")
	private EntityManager em;
	
	public void createCard(Card card) throws CardException {
		em.persist(card);
	}

	public Card findCardByCardId(String cardId) throws CardException {
		// TODO Auto-generated method stub
		
		 Card card = em.find(Card.class, cardId);
		 
		return card;
	}

	@Override
	public List<Card> findAllCards() throws CardException {
		// TODO Auto-generated method stub
		@SuppressWarnings("unchecked")
		List<Card> cardList = em.createNamedQuery("Card.findAll").getResultList();

		return cardList;
	}
	

	
	

}
