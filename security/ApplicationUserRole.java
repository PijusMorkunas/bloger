package firstweb.web.security;

import com.google.common.collect.Sets;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Set;
import java.util.stream.Collectors;

import static firstweb.web.security.ApplicationUserPermission.*;

public enum ApplicationUserRole {
    CLIENT(Sets.newHashSet(CLIENT_READ, CLIENT_WRITE)),
    ADMIN(Sets.newHashSet(ADMIN_READ, ADMIN_WRITE, CLIENT_READ, CLIENT_WRITE)),
    ADMINTRAINEE(Sets.newHashSet(ADMIN_READ, CLIENT_READ));


    ApplicationUserRole(Set<ApplicationUserPermission> permissions) {
        this.permissions = permissions;
    }

    private final Set<ApplicationUserPermission> permissions;

    public Set<ApplicationUserPermission> getPermissions() {
        return permissions;
    }

    public Set<SimpleGrantedAuthority> getGrantedAuthorities() {
        Set<SimpleGrantedAuthority> permissions = getPermissions().stream()
                .map(permission -> new SimpleGrantedAuthority(permission.getPermission()))
                .collect(Collectors.toSet());
        permissions.add(new SimpleGrantedAuthority("ROLE_" + this.name()));
        return permissions;
    }
}
