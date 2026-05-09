package com.example.app.entity;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.ZonedDateTime;
import java.util.UUID;

@Entity
@Table(name = "study_group_sets")
public class StudyGroupSet {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "group_id", nullable = false)
    @org.hibernate.annotations.OnDelete(action = org.hibernate.annotations.OnDeleteAction.CASCADE)
    private StudyGroup group;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "set_id", nullable = false)
    @org.hibernate.annotations.OnDelete(action = org.hibernate.annotations.OnDeleteAction.CASCADE)
    private FlashcardSet set;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "added_by")
    @org.hibernate.annotations.OnDelete(action = org.hibernate.annotations.OnDeleteAction.SET_NULL)
    private User addedBy;

    @CreationTimestamp
    @Column(nullable = false, updatable = false)
    private ZonedDateTime addedAt;

    public StudyGroupSet() {
    }

    public StudyGroupSet(StudyGroup group, FlashcardSet set, User addedBy) {
        this.group = group;
        this.set = set;
        this.addedBy = addedBy;
    }

    // Getters & Setters
    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public StudyGroup getGroup() {
        return group;
    }

    public void setGroup(StudyGroup group) {
        this.group = group;
    }

    public FlashcardSet getSet() {
        return set;
    }

    public void setSet(FlashcardSet set) {
        this.set = set;
    }

    public User getAddedBy() {
        return addedBy;
    }

    public void setAddedBy(User addedBy) {
        this.addedBy = addedBy;
    }

    public ZonedDateTime getAddedAt() {
        return addedAt;
    }

    public void setAddedAt(ZonedDateTime addedAt) {
        this.addedAt = addedAt;
    }
}
