package za.co.cardmanager.utils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.primefaces.model.FilterMeta;
import org.primefaces.model.LazyDataModel;
import org.primefaces.model.SortMeta;
import org.primefaces.model.SortOrder;

import za.co.cardmanager.entity.Card;

public class LazyCardDataModel extends LazyDataModel<Card> {
    /**
     * 
     */
    private static final long serialVersionUID = 1L;


    private List<Card> datasource;

    public LazyCardDataModel(List<Card> cardList) {
        this.datasource = cardList;
    }

    @Override
    public Card getRowData(String rowKey) {
        int intRowKey = Integer.parseInt(rowKey);
        for(Card card : datasource) {
            if(Integer.parseInt(card.getCardNumber()) == intRowKey) {
                return card;
            }
        }
        return null;
    }

    @Override
    public Object getRowKey(Card card) {
        return card.getCardNumber();
    }

    @Override
    public List<Card> load(int first, int pageSize, String sortField, SortOrder sortOrder, Map<String,Object> filters) {
        List<Card> data = new ArrayList<Card>();
          //filter
        for(Card card : datasource) {
            boolean match = true;
            if (filters != null) {
                for (Iterator<String> it = filters.keySet().iterator(); it.hasNext();) {
                    try {
                        String filterProperty = it.next();
                        Object filterValue = filters.get(filterProperty);
                        String fieldValue = String.valueOf(card.getClass().getField(filterProperty).get(card));
                        if(filterValue == null || fieldValue.startsWith(filterValue.toString())) {
                            match = true;
                        } else {
                            match = false;
                            break;
                        }
                    } catch(Exception ex) {
                        match = false;
                    }
                }
            }
            if(match) {
                data.add(card);
            }
        }

        //sort
        if(sortField != null) {
            Collections.sort(data, new LazyCardSorter(sortField, sortOrder));
        }

        //rowCount
        int dataSize = data.size();
        this.setRowCount(dataSize);

        //paginate
        if(dataSize > pageSize) {
            try {
                return data.subList(first, first + pageSize);
            }
            catch(IndexOutOfBoundsException e) {
                return data.subList(first, first + (dataSize % pageSize));
            }
        }
        else {
            return data;
        }
    }
}