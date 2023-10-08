package top.chen.share.content.controller;

import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.chen.share.common.resp.CommonResp;
import top.chen.share.content.domain.entity.Notice;
import top.chen.share.content.service.NoticeService;

/**
 * Author:CJQ
 * Date:2023/10/8
 */
@RestController
@RequestMapping("/share")
public class ShareController {
    @Resource
    private NoticeService noticeService;

    @GetMapping("/notice")
    public CommonResp<Notice> getLatestNotice(){
        CommonResp<Notice> commonResp = new CommonResp<>();
        commonResp.setData(noticeService.getLatest());
        return commonResp;
    }
}
