package com.example.demo.data;


import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;


@Entity
public class ApplicationUser implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty()
    @Size(min = 8)
    @Column(nullable = false)
    private String password;

    @NotEmpty()
    @Size(max = 35)
    @Column(unique = true, nullable = false)
    private String username;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "applicationUser", cascade = CascadeType.ALL)
    @OrderBy("id")
    private List<Album> album;

    public ApplicationUser(String password, String username) {
        this.password = password;
        this.username = username;
    }
    //Setters and getters

    public long getId() {
        return id;
    }

    //User Details

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    @Override
    public String toString() {
        return "ApplicationUser{" +
                "id=" + id +
                ", password='" + password + '\'' +
                ", username='" + username + '\'' +
                '}';
    }
}
