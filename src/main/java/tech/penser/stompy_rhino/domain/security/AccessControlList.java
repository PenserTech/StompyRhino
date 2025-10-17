package tech.penser.stompy_rhino.domain.security;

import java.util.Set;

public record AccessControlList(
        Set<AccessRule> rules
) {
    public boolean isEmpty() { return rules == null || rules.isEmpty(); }
}
