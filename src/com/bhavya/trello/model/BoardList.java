package com.bhavya.trello.model;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class BoardList extends BaseModel {
    @Override
    public String toString() {
        return "BoardList{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", cards=" + cards +
                '}';
    }

    private String id;
    private String name;
    private Map<String, Card> cards = new HashMap<>();


    public BoardList(String name) {
        this.id = generateId();
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void addCard(Card card)
    {
        cards.put(card.getId(), card);
    }

    public Card deleteCard(String cardId)
    {
        Card card = getCard(cardId);
        cards.remove(cardId);
        return card;
    }

    public Card getCard(String cardId)
    {
        return cards.get(cardId);
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public boolean isCardPresent(String cardId)
    {
        return Optional.ofNullable(cards.getOrDefault(cardId, null)).isPresent();
    }
}
