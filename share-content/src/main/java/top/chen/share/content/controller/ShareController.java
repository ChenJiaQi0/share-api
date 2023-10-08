package top.chen.share.content.controller;

import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import top.chen.share.common.resp.CommonResp;
import top.chen.share.content.domain.entity.Notice;
import top.chen.share.content.domain.entity.Share;
import top.chen.share.content.service.NoticeService;
import top.chen.share.content.service.ShareService;

import java.util.List;

/**
 * Author:CJQ
 * Date:2023/10/8
 */
@RestController
@RequestMapping("/share")
public class ShareController {
    @Resource
    private ShareService shareService;
    @Resource
    private NoticeService noticeService;

    @GetMapping("/notice")
    public CommonResp<Notice> getLatestNotice(){
        CommonResp<Notice> commonResp = new CommonResp<>();
        commonResp.setData(noticeService.getLatest());
        return commonResp;
    }

    @GetMapping("/list")
    public CommonResp<List<Share>> getShareList(@RequestParam(required = false) String title) {
        CommonResp<List<Share>> commonResp = new CommonResp<>();
        Long userId = 2L;
        commonResp.setData(shareService.getList(title, userId));
        return commonResp;
    }
}
