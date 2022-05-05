package com.scpg.gamelibrary.core.result.abstracts;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public abstract class Result
{
    private final boolean success;
    private final String message;
}
