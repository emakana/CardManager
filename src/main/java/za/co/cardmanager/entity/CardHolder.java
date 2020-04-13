package za.co.cardmanager.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

@Entity
@NamedQueries({ @NamedQuery(name = "CardHolder.findAll", query = "SELECT c FROM CardHolder c"),
		@NamedQuery(name = "CardHolder.findAllSortedBySurname", query = "SELECT c FROM CardHolder c ORDER BY c.surname ASC"), })
public class CardHolder implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id = 0L;

	private String title = null;
	private String name = null;
	private String surname = null;
	private String dateOfBirth = null;
	private String govId = null;
	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Card> cards = new ArrayList<Card>();
	
	public CardHolder() {}

	public CardHolder(String title, String name, String surname, String dateOfBirth, String govId) {
		// TODO Auto-generated constructor stub
		this.title = title;
		this.name = name;
		this.surname = surname;
		this.dateOfBirth = dateOfBirth;
		this.govId = govId;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Column
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@Column
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column
	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	@Column
	public String getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	@Column
	public String getGovId() {
		return govId;
	}

	public void setGovId(String govId) {
		this.govId = govId;
	}

	public List<Card> getCards() {
		return cards;
	}

	public void setCards(List<Card> cards) {
		this.cards = cards;
	}

}
