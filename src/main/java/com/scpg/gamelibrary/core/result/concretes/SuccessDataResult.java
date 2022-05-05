package com.scpg.gamelibrary.core.result.concretes;

import com.scpg.gamelibrary.core.result.abstracts.DataResult;

public class SuccessDataResult<T> extends DataResult<T>
{
    public SuccessDataResult(T data)
    {
        super(true, null, data);
    }

    public SuccessDataResult(T data, String message)
    {
        super(true, message, data);
    }
}
