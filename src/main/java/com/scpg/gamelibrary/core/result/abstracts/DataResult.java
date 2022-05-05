package com.scpg.gamelibrary.core.result.abstracts;

import lombok.Getter;

@Getter
public abstract class DataResult<T> extends Result
{
    private final T data;


    public DataResult(boolean success, String message, T data)
    {
        super(success, message);
        this.data = data;
    }
}
