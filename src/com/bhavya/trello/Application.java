package com.bhavya.trello;

import com.bhavya.trello.model.Board;
import com.bhavya.trello.model.BoardList;
import com.bhavya.trello.model.Card;
import com.bhavya.trello.service.BoardListService;
import com.bhavya.trello.service.BoardService;
import com.bhavya.trello.service.CardService;

public class Application {

    public static void main(String[] args) {
        BoardService boardService = new BoardService();

        Board board1 = boardService.createBoard("work@tech");
        System.out.println(board1.toString());

        board1 = boardService.updateBoard(board1.getId(), "PRIVATE");
        System.out.println(board1.toString());

        Board board2 = boardService.createBoard("workat");
        System.out.println(board2.toString());

        boardService.addMemberToBoard(board1.getId(), "user1", "user1@gmail.com");
        boardService.addMemberToBoard(board1.getId(), "user2", "user2@gmail.com");
        boardService.addMemberToBoard(board1.getId(), "user3", "user3@gmail.com");
        boardService.removeMemberFromBoard(board1.getId(), "user2@gmail.com");
        board1 = boardService.getBoard(board1.getId());
        System.out.println(board1.toString());

        boardService.deleteBoard(board2.getId());
        // below line should throw error
//        boardService.getBoard(board2.getId());

        board1 = boardService.getBoard(board1.getId());
        BoardListService listService1 = new BoardListService(board1);

        BoardList list1 = listService1.createList("Mock Interviews");
        System.out.println(list1.toString());

        list1 = listService1.updateList(list1.getId(), "Mock Interviews - Applied");
        System.out.println(list1.toString());

        BoardList list2 = listService1.createList("Mock Interviews - Scheduled");
        System.out.println(list2.toString());

        board1 = boardService.getBoard(board1.getId());
        System.out.println(board1.toString());

        CardService cardService1 = new CardService(list1);
        Card card1 = cardService1.createCard("abcd@gmail.com");
        Card card2 = cardService1.createCard("abcda@gmail.com");
        list1 = listService1.getList(list1.getId());
        System.out.println(list1.toString());
    }
}
