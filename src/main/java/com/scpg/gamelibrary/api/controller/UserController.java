package com.scpg.gamelibrary.api.controller;

import com.scpg.gamelibrary.business.abstracts.IUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public abstract class UserController<T, S extends IUserService<T>>
{
    protected final S genericUserService;

    @GetMapping("/getall")
    public List<T> getAll()
    {
        return genericUserService.getAll();
    }
}
