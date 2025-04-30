package fhv.omni.auth.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.io.Serializable;
import java.util.Collection;
import java.util.Set;
import java.util.stream.Collectors;

@Entity
public class OmniUser implements UserDetails, Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    private String id;

    private String email;
    private String username;
    private String password;

    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "user_roles", joinColumns = @JoinColumn(name = "user_id"))
    @Column(name = "role")
    private Set<String> roles;

    public OmniUser() {
        // Empty Constructor for ORM
    }

    public OmniUser(String id, String email, String username, String password, Collection<Role> roles) {
        this.id = id;
        this.email = email;
        this.username = username;
        this.password = password;
        this.roles = roles.stream()
                .map(Enum::name)
                .collect(Collectors.toSet());
    }

    // Required for serialization
    @Transient
    private Set<SimpleGrantedAuthority> authorities;
    
    @JsonProperty
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        if (authorities != null) {
            return authorities;
        }
        return roles.stream()
                .map(SimpleGrantedAuthority::new)
                .collect(Collectors.toSet());
    }

    // Required for serialization
    @JsonProperty
    private void setAuthorities(Set<SimpleGrantedAuthority> authorities) {
        this.authorities = authorities;
    }

    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public String getUsername() {
        return this.username;
    }
    
    @JsonIgnore
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @JsonIgnore
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @JsonIgnore
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @JsonIgnore
    @Override
    public boolean isEnabled() {
        return true;
    }
}
