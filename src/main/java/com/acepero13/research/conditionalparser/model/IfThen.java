package com.acepero13.research.conditionalparser.model;

import lombok.Data;

@Data
public class IfThen {
    private final Expr condition;
    private final Expr action;
}
