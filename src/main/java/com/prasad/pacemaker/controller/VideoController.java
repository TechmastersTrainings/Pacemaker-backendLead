package com.prasad.pacemaker.controller;

import com.prasad.pacemaker.service.MuxService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class VideoController {

    private final MuxService muxService;

    public VideoController(MuxService muxService) {
        this.muxService = muxService;
    }

    @GetMapping("/api/videos/upload-url")
    public Map<String, String> getUploadUrl() {

        return muxService.createUploadUrl();
    }
}