package com.springmvc.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

/**
 * 공지사항 등록/수정 폼 (관리자)
 *  - noticeId == null → INSERT
 *  - noticeId != null → UPDATE
 */
public class NoticeForm {

    private Long noticeId;

    @NotBlank(message = "제목을 입력해 주세요.")
    @Size(max = 100, message = "제목은 100자 이하로 입력해 주세요.")
    private String title;

    @NotBlank(message = "내용을 입력해 주세요.")
    private String content;

    public NoticeForm() {}

    public Long getNoticeId() { return noticeId; }
    public void setNoticeId(Long noticeId) { this.noticeId = noticeId; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getContent() { return content; }
    public void setContent(String content) { this.content = content; }
}