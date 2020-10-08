package com.taeho.study.modules.event.event;

import com.taeho.study.modules.event.Enrollment;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public abstract class EnrollmentEvent {
    protected final Enrollment enrollment;
    protected final String message;
}
