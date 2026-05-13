package com.prasad.pacemaker.entity;

import com.prasad.pacemaker.enums.SubscriptionTier;
import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table(name = "subscription_plans")
public class SubscriptionPlan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, unique = true)
    private SubscriptionTier tier;

    @Column(nullable = false)
    private BigDecimal price;

    @Column(nullable = false)
    private String duration;

    @Column(nullable = false)
    private boolean qbankAccess;

    @Column(nullable = false)
    private boolean videoAccess;

    @Column(nullable = false)
    private boolean liveClassAccess;

    // =========================
    // CONSTRUCTORS
    // =========================

    public SubscriptionPlan() {
    }

    // =========================
    // GETTERS & SETTERS
    // =========================

    public Long getId() {
        return id;
    }

    public SubscriptionTier getTier() {
        return tier;
    }

    public void setTier(SubscriptionTier tier) {
        this.tier = tier;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public boolean isQbankAccess() {
        return qbankAccess;
    }

    public void setQbankAccess(boolean qbankAccess) {
        this.qbankAccess = qbankAccess;
    }

    public boolean isVideoAccess() {
        return videoAccess;
    }

    public void setVideoAccess(boolean videoAccess) {
        this.videoAccess = videoAccess;
    }

    public boolean isLiveClassAccess() {
        return liveClassAccess;
    }

    public void setLiveClassAccess(boolean liveClassAccess) {
        this.liveClassAccess = liveClassAccess;
    }
}