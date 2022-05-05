package com.scpg.gamelibrary.core.result.concretes;

import com.scpg.gamelibrary.core.result.abstracts.DataResult;

public class ErrorDataResult<T> extends DataResult<T>
{
    public ErrorDataResult(T data)
    {
        super(false, null, data);
    }

    public ErrorDataResult(T data, String message)
    {
        super(false, message, data);
    }
}
