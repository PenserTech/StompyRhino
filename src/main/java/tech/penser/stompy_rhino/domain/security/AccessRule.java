package tech.penser.stompy_rhino.domain.security;

import java.util.Set;

public record AccessRule(
        Principal principal,          // could be a person, group, or role
        Set<Permission> permissions
) {}
