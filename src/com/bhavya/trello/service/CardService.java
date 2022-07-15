package com.bhavya.trello.service;

import com.bhavya.trello.model.BoardList;
import com.bhavya.trello.model.Card;

public class CardService {

    private BoardList list;

    public CardService(BoardList list)
    {
        this.list = list;
    }

    public Card createCard(String assignUser)
    {
        Card card = new Card(assignUser);
        list.addCard(card);
        return card;
    }

    public Card deleteCard(String id)
    {
        return list.deleteCard(id);
    }

    public Card getCard(String id)
    {
        return list.getCard(id);
    }

    public void assign(String id, String userId)
    {
        Card card = getCard(id);
        card.assign(userId);
    }

    public void unAssign(String id)
    {
        Card card = getCard(id);
        card.unAssign();
    }

}
