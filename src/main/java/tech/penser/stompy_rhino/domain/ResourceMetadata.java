package tech.penser.stompy_rhino.domain;

import java.util.Map;

public record ResourceMetadata(
        String createdBy,
        String owner,
        Map<String, String> attributes
) {
    public ResourceMetadata(String createdBy, String owner) {
        this(createdBy, owner, Map.of());
    }
}
