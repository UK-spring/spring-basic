package com.example.springbasicmemo.controller;

import com.example.springbasicmemo.dto.MemoRequestDto;
import com.example.springbasicmemo.dto.MemoResponseDto;
import com.example.springbasicmemo.entity.Memo;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/memos") // Prefix
public class MemoController {

    private final Map<Long, Memo> memoList = new HashMap<>();

    @PostMapping
    public MemoResponseDto createMemo(@RequestBody MemoRequestDto requestDto) {

        // MemoId 식별자 계산
        Long memoId = memoList.isEmpty() ? 1 : Collections.max(memoList.keySet()) + 1;
        Memo memo = new Memo(memoId, requestDto.getTitle(), requestDto.getContents());

        // Inmemory DB에 Memo 저장
        memoList.put(memoId, memo);

        return new MemoResponseDto(memo);
    }

    @GetMapping
    public List<MemoResponseDto> findAllMemos() {

        List<MemoResponseDto> responseList = new ArrayList<>();

        for (Memo memo : memoList.values()) {
            MemoResponseDto responseDto = new MemoResponseDto(memo);
            responseList.add(responseDto);
        }

        // Map To List
//        responseList = memoList.values().stream().map(MemoResponseDto::new).toList();
        return responseList;
    }

}
