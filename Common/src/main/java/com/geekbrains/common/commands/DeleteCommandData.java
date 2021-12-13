package com.geekbrains.common.commands;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.io.Serial;
import java.io.Serializable;

@Getter
@AllArgsConstructor
public class DeleteCommandData implements Serializable {
    @Serial
    private static final long serialVersionUID = 4243876740777052015L;
    private String fileName;
}
