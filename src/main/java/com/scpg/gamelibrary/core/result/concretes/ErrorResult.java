package com.scpg.gamelibrary.core.result.concretes;

import com.scpg.gamelibrary.core.result.abstracts.Result;

public class ErrorResult extends Result
{
    public ErrorResult()
    {
        super(false, null);
    }

    public ErrorResult(String message)
    {
        super(false, message);
    }
}
