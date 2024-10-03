package com.example.springbasicmemo.entity;

import com.example.springbasicmemo.dto.MemoRequestDto;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Memo {

    private Long id;
    private String title;
    private String contents;

    public void update(MemoRequestDto requestDto) {
        this.title = requestDto.getTitle();
        this.contents = requestDto.getContents();
    }

    public void updateTitle(MemoRequestDto requestDto) {
        this.title = requestDto.getTitle();
    }

}
