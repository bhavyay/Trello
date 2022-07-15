package com.bhavya.trello.model;

import com.bhavya.trello.util.IdGenerator;
import com.bhavya.trello.util.IdGeneratorImpl;

public class BaseModel {

    protected IdGenerator idGenerator;

    public BaseModel()
    {
        idGenerator = new IdGeneratorImpl();
    }

    protected String generateId()
    {
        return idGenerator.generateId();
    }
}
