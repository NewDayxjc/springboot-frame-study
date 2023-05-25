package com.security.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Menu {
    private Long id;
    private String name;
    private String url;
    private Long parentId;
    private String permission;
}
