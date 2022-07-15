package com.bhavya.trello.service;

import com.bhavya.trello.model.Board;
import com.bhavya.trello.model.BoardList;
import com.bhavya.trello.model.Card;

public class BoardListService {

    private Board board;

    public BoardListService(Board board)
    {
        this.board = board;
    }

    public BoardList createList(String name)
    {
        BoardList list = new BoardList(name);
        board.addList(list);
        return list;
    }

    public BoardList deleteList(String id)
    {
        return board.removeList(id);
    }

    public BoardList getList(String id)
    {
        return board.getList(id);
    }

    public void moveCardToList(String cardId, String newListId)
    {
        BoardList existingListForCard = board.findListForCard(cardId);
        BoardList newListForCard = board.getList(newListId);
        Card card = existingListForCard.deleteCard(cardId);
        newListForCard.addCard(card);
    }

    public BoardList updateList(String id, String name)
    {
        BoardList list = getList(id);
        list.setName(name);
        return list;
    }
}
