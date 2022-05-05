package com.scpg.gamelibrary.core.result.concretes;

import com.scpg.gamelibrary.core.result.abstracts.Result;

public class SuccessResult extends Result
{
    public SuccessResult()
    {
        super(true, null);
    }

    public SuccessResult(String message)
    {
        super(true, message);
    }
}
