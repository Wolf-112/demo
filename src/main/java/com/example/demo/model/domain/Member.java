package com.example.demo.model.domain;

import jakarta.persistence.*;

public class Member {
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY) //기본 키 1씩 증가
    @Column(name = "id", updatable = false) // 수정 x 
    private Long id;

    @Column(name = "name", nullable = false) //null x
    private String name = "";

    @Column(name = "email", unique = true, nullable = false) //unique 중복 x
    private String email = "";

    @Column(name = "password", nullable = false)
    private String password = "";
    
}
