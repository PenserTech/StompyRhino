package tech.penser.stompy_rhino.domain.security;

public sealed interface Principal permits UserPrincipal, GroupPrincipal, RolePrincipal {}

