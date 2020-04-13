package za.co.cardmanager.utils;

import java.util.Comparator;

import org.primefaces.model.SortOrder;

import za.co.cardmanager.entity.Card;

public class LazyCardSorter implements Comparator<Card>{
	
	private String sortField = null;
	
	private SortOrder sortOrder = null;
	
	  public LazyCardSorter(String sortField, SortOrder sortOrder) {
	        this.sortField = sortField;
	        this.sortOrder = sortOrder;
	    }

	@Override
	public int compare(Card card1, Card card2) {
		// TODO Auto-generated method stub
	    try {
            Object value1 = Card.class.getField(this.sortField).get(card1);
            Object value2 = Card.class.getField(this.sortField).get(card2);
 
            @SuppressWarnings("unchecked")
			int value = ((Comparable)value1).compareTo(value2);
             
            return SortOrder.ASCENDING.equals(sortOrder) ? value : -1 * value;
        }
        catch(Exception e) {
            throw new RuntimeException();
        }
	   

	}

}
