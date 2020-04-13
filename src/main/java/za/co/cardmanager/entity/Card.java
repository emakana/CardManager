package za.co.cardmanager.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Transient;

@Entity
@NamedQueries({ @NamedQuery(name = "Card.findAll", query = "SELECT c FROM Card c"), })
public class Card implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id = 0L;
   
	@Column(nullable = true)
	private String cardId = null;
	
	@Column
	private String cardNumber = null;
	@Column
	private String status = null;
	@Column
	private String createDate = null;
	@Column
	private String activatedDate = null;
	@Column
	private String primarySecondaryIndicator = null;
	@Column
	private String expiryDate = null;
	@Column
	private String availableBalance = null;
	@Column
	private String actualBalance = null;

	public Card() {
	}

	public Card(String cardId, String cardNumber, String status, String createDate, String activatedDate,
			String primarySecondaryIndicator, String expiryDate, String availableBalance, String actualBalance) {
		// TODO Auto-generated constructor stub
		
		this.cardId = cardId;
		this.cardNumber = cardNumber;
		this.status = status;
		this.createDate = createDate;
		this.activatedDate = activatedDate;
		this.primarySecondaryIndicator = primarySecondaryIndicator;
		this.expiryDate = expiryDate;
		this.availableBalance = availableBalance;
		this.actualBalance = actualBalance;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	
	public String getCardId() {
		return cardId;
	}

	public void setCardId(String cardId) {
		this.cardId = cardId;
	}

	
	public String getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}

	
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	
	public String getCreateDate() {
		return createDate;
	}

	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}

	
	public String getActivatedDate() {
		return activatedDate;
	}

	public void setActivatedDate(String activatedDate) {
		this.activatedDate = activatedDate;
	}

	
	public String getPrimarySecondaryIndicator() {
		return primarySecondaryIndicator;
	}

	public void setPrimarySecondaryIndicator(String primarySecondaryIndicator) {
		this.primarySecondaryIndicator = primarySecondaryIndicator;
	}

	
	public String getExpiryDate() {
		return expiryDate;
	}

	public void setExpiryDate(String expiryDate) {
		this.expiryDate = expiryDate;
	}

	
	public String getAvailableBalance() {
		return availableBalance;
	}

	public void setAvailableBalance(String availableBalance) {
		this.availableBalance = availableBalance;
	}

	
	public String getActualBalance() {
		return actualBalance;
	}

	public void setActualBalance(String actualBalance) {
		this.actualBalance = actualBalance;
	}

	@Transient
	@Override
	public int hashCode() {
		int hash = 7;
		hash = 59 * hash + (this.id != null ? this.id.hashCode() : 0);
		return hash;
	}

	@Transient
	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		final Card other = (Card) obj;
		if ((this.id == null) ? (other.id != null) : !this.id.equals(other.id)) {
			return false;
		}
		return true;
	}

}
