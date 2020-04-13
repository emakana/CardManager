package za.co.cardmanager.controller;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.primefaces.event.SelectEvent;
import org.primefaces.model.LazyDataModel;

import za.co.cardmanager.dao.CardDao;
import za.co.cardmanager.dao.CardException;
import za.co.cardmanager.dao.CardHolderDao;
import za.co.cardmanager.entity.Card;
import za.co.cardmanager.utils.LazyCardDataModel;


@ManagedBean(name="dtLazyView")
@SessionScoped
public class CardManagerController implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Card selectedCard;

	@EJB
	CardDao cardDao;

	@EJB
	CardHolderDao cardHolderDao;

	private LazyDataModel<Card> lazyCardModel = null;
	
	private List<Card> cardList = null;

	@PostConstruct
	public void init() {
		try {
			cardList = cardDao.findAllCards();
		} catch (CardException e) {
			e.printStackTrace();
		}
		
		lazyCardModel = new LazyCardDataModel(cardList);
	}

	public LazyDataModel<Card> getLazyCardModel() {
		if (lazyCardModel == null) {
			try{
			lazyCardModel = new LazyCardDataModel(cardDao.findAllCards());
			} catch (CardException e) {
				e.printStackTrace();
			}
		}

		return lazyCardModel;
	}

	public void setLazyCardModel(LazyDataModel<Card> lazyCardModel) {
		this.lazyCardModel = lazyCardModel;
	}

	public Card getSelectedCard() {
		return selectedCard;
	}

	public void setSelectedCard(Card selectedCard) {
		this.selectedCard = selectedCard;
	}

	public void onRowSelect(SelectEvent event) {
		FacesMessage msg = new FacesMessage("Card Selected", ((Card) event.getObject()).getCardId());
		FacesContext.getCurrentInstance().addMessage(null, msg);
	}

}
