package com.bhavya.trello.model;

import com.bhavya.trello.service.UserService;

import java.util.*;

public class Board extends BaseModel {
    @Override
    public String toString() {
        return "Board{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", privacy=" + privacy +
                ", url='" + url + '\'' +
                ", members=" + members +
                ", lists=" + lists +
                '}';
    }

    private final String id;

    public void setName(String name) {
        this.name = name;
    }

    private String name;
    private PrivacyPolicy privacy;
    private String url;
    private List<String> members = new ArrayList<>();
    private Map<String, BoardList> lists = new HashMap<>();

    public Board(String name) {
        this.id = generateId();
        this.name = name;
    }

    public void setUrl(String url)
    {
        this.url = url;
    }

    public String getId() {
        return id;
    }

    public void addMember(User user)
    {
        members.add(user.getUserId());
    }

    public void removeMember(User user)
    {
        members.remove(user.getUserId());
    }

    public void addList(BoardList list)
    {
        lists.put(list.getId(), list);
    }

    public BoardList removeList(String listId)
    {
        BoardList list = lists.get(listId);
        lists.remove(listId);
        return list;
    }

    public BoardList getList(String listId)
    {
        return lists.get(listId);
    }

    public BoardList findListForCard(String cardId)
    {
        return lists.values()
                .stream()
                .filter(list -> list.isCardPresent(cardId))
                .findFirst()
                .get();
    }

    public void setPrivacy(String privacy) {
        this.privacy = Optional.ofNullable(privacy).isPresent() ?
                PrivacyPolicy.valueOf(privacy) :
                PrivacyPolicy.PUBLIC;
    }
}
