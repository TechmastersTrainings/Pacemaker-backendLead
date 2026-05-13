package com.prasad.pacemaker.controller;

import com.prasad.pacemaker.dto.LiveClassRequest;
import com.prasad.pacemaker.entity.LiveClass;
import com.prasad.pacemaker.service.LiveClassService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/live-classes")
public class LiveClassController {

    private final LiveClassService liveClassService;

    public LiveClassController(LiveClassService liveClassService) {
        this.liveClassService = liveClassService;
    }

    @PostMapping
    public LiveClass createLiveClass(@RequestBody LiveClassRequest request) {
        return liveClassService.createLiveClass(request);
    }

    @GetMapping
    public List<LiveClass> getAllLiveClasses() {
        return liveClassService.getAllLiveClasses();
    }

    @GetMapping("/{id}")
    public LiveClass getLiveClassById(@PathVariable Long id) {
        return liveClassService.getLiveClassById(id);
    }
}