package tech.penser.stompy_rhino.domain;

import tech.penser.stompy_rhino.domain.security.AccessControlList;

import java.net.URI;
import java.time.Instant;
import java.util.Set;
import java.util.UUID;

public record PdfFile(
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
        String title,
        String body,
        String author
) implements Resource {}
