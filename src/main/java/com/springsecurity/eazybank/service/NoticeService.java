package com.springsecurity.eazybank.service;

import com.springsecurity.eazybank.model.NoticeDetails;
import com.springsecurity.eazybank.repository.NoticeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class NoticeService {

    private final NoticeRepository noticeRepository;

    public NoticeDetails getNoticeDetails(Long noticeId) {
        return noticeRepository.findById(noticeId).orElse(null);
    }
}
