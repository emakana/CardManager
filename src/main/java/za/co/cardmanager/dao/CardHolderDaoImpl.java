package za.co.cardmanager.dao;

import java.io.Serializable;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;

import za.co.cardmanager.entity.Card;
import za.co.cardmanager.entity.CardHolder;

@Stateless
public class CardHolderDaoImpl implements CardHolderDao, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@PersistenceContext(unitName = "card-unit", type = PersistenceContextType.EXTENDED)
	private EntityManager em;

	/**
	 * During creation a card holder must be linked to a selected card
	 * 
	 * @param cardHolder
	 * @param card
	 * @throws Exception
	 */
	public void createCardHolder(CardHolder cardHolder, Card card) throws CardException {
		
		if(card.getStatus().equals(CardStatus.INACTIVE)) {
		cardHolder.getCards().add(card);
		
		em.persist(cardHolder);
		}
	}

	public CardHolder findCardHolderByGovId(String govId) {
		// TODO Auto-generated method stub

		CardHolder cardHolder = em.find(CardHolder.class, govId);

		return cardHolder;
	}

	public List<CardHolder> findAllCardHolders() {
		// TODO Auto-generated method stub
		@SuppressWarnings("unchecked")
		List<CardHolder> cardList = em.createNamedQuery("CardHolder.findAll").getResultList();

		return cardList;
	}

	public List<CardHolder> findAllSortedBySurname() {
		// TODO Auto-generated method stub
		@SuppressWarnings("unchecked")
		List<CardHolder> cardList = em.createNamedQuery("CardHolder.findAllSortedBySurname").getResultList();

		return cardList;
	}

	public void replaceCardHolderCard(CardHolder cardHolder, Card sourceCard, Card replacementCard) {
		// TODO Auto-generated method stub
	 cardHolder = em.find(CardHolder.class, cardHolder.getGovId());
	 cardHolder.getCards().forEach(c->{
		 if (c.equals(sourceCard) && c.getStatus().equals(CardStatus.INACTIVE)) {
		 c = replacementCard;
	 }
	 });
		em.persist(cardHolder);
	}


	@Override
	public void addSecondaryCard(CardHolder cardHolder, Card secondaryCard) throws CardException {
		// TODO Auto-generated method stub
		 cardHolder = em.find(CardHolder.class, cardHolder.getGovId());
		 
		 cardHolder.getCards().add(secondaryCard);
		 em.persist(cardHolder);
	}

	
}
