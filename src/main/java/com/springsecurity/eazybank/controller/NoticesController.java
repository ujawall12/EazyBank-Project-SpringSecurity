package com.springsecurity.eazybank.controller;

import com.springsecurity.eazybank.model.NoticeDetails;
import com.springsecurity.eazybank.service.NoticeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.CacheControl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;
import java.util.concurrent.TimeUnit;

@RestController
@RequiredArgsConstructor
public class NoticesController {

    private final NoticeService noticesService;

    @GetMapping("/myNotices")
    public ResponseEntity<NoticeDetails> getNoticesDetails(@RequestParam Long noticeId) {
        if (Objects.isNull(noticesService.getNoticeDetails(noticeId))) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().cacheControl(CacheControl.maxAge(60, TimeUnit.SECONDS))
                .body(noticesService.getNoticeDetails(noticeId));

    }
}
