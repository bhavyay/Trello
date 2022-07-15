package com.bhavya.trello.service;

import com.bhavya.trello.model.Board;
import com.bhavya.trello.model.User;
import com.bhavya.trello.util.IdBasedUrlGenerator;
import com.bhavya.trello.util.UrlGenerator;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class BoardService {
    public final static String BASE_DOMAIN = "bhavya.trello.com";

    private Map<String, Board> boards = new HashMap<>();

    private UrlGenerator urlGenerator;
    private UserService userService;

    public BoardService()
    {
        urlGenerator = new IdBasedUrlGenerator(BASE_DOMAIN);
        userService = new UserService();
    }

    public Board createBoard(String name)
    {
        return createBoard(name, null);
    }

    public Board createBoard(String name, String privacy)
    {
        Board board = new Board(name);
        board.setPrivacy(privacy);
        Board configuredBoard =  configureBoard(board);
        boards.put(board.getId(), configuredBoard);
        return board;
    }

    public Board updateBoard(String id, String privacy)
    {
        Board board = boards.get(id);
        board.setPrivacy(privacy);
        boards.put(board.getId(), board);
        return board;
    }

    public Board updateBoard(String id, Map<String, Object> options)
    {
        Board board = boards.get(id);

        Optional.ofNullable(options.get("name"))
                .ifPresent(name -> board.setName(name.toString()));

        Optional.ofNullable(options.get("privacy"))
                .ifPresent(privacy -> board.setPrivacy(privacy.toString()));

        boards.put(board.getId(), board);
        return board;
    }

    public void addMemberToBoard(String id, String userName, String userEmail)
    {
        User user = userService.findOrcreateUser(userName, userEmail);
        Board board = boards.get(id);
        board.addMember(user);
    }

    public void removeMemberFromBoard(String id, String userEmail)
    {
        User user = userService.findUser(userEmail);
        Board board = boards.get(id);
        board.removeMember(user);
    }

    public Board getBoard(String id)
    {
        return boards.get(id);
    }

    public void deleteBoard(String id) {
        Board board = boards.get(id);
        boards.remove(id);
    }

    private Board configureBoard(Board board)
    {
        Map<String, String> options = new HashMap<>();
        options.put("ENTITY", "board");
        options.put("ID", board.getId());
        board.setUrl(urlGenerator.generateUrl(options));
        return board;
    }
}
