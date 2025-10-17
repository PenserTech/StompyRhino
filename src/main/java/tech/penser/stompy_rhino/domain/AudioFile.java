package tech.penser.stompy_rhino.domain;

import tech.penser.stompy_rhino.domain.security.AccessControlList;

import java.net.URI;
import java.time.Duration;
import java.time.Instant;
import java.util.Set;
import java.util.UUID;

public record AudioFile(
        UUID id,
        String name,
        String mimeType,
        long sizeBytes,
        URI location,
        Set<ProjectId> projects,
        AccessControlList acl,
        ResourceMetadata metadata,
        Instant createdAt,
        Instant updatedAt,
        Duration duration,     // Length of the audio
        int bitrateKbps,       // e.g., 128, 256, 320
        int sampleRateHz,      // e.g., 44100, 48000
        String codec           // e.g., "mp3", "aac", "flac", "wav"
) implements Resource {}
