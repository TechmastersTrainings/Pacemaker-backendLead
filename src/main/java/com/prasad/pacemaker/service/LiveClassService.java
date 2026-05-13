package com.prasad.pacemaker.service;

import com.prasad.pacemaker.dto.LiveClassRequest;
import com.prasad.pacemaker.entity.LiveClass;
import com.prasad.pacemaker.repository.LiveClassRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class LiveClassService {

    private final LiveClassRepository liveClassRepository;

    public LiveClassService(LiveClassRepository liveClassRepository) {
        this.liveClassRepository = liveClassRepository;
    }

    public LiveClass createLiveClass(LiveClassRequest request) {

        LiveClass liveClass = new LiveClass();

        liveClass.setTitle(request.getTitle());
        liveClass.setDescription(request.getDescription());
        liveClass.setStartTime(request.getStartTime());
        liveClass.setMeetingLink(request.getMeetingLink());
        liveClass.setCreatedAt(LocalDateTime.now());

        return liveClassRepository.save(liveClass);
    }

    public List<LiveClass> getAllLiveClasses() {
        return liveClassRepository.findAll();
    }

    public LiveClass getLiveClassById(Long id) {
        return liveClassRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Live class not found"));
    }
}