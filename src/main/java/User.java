import java.util.List;

import javax.interceptor.Interceptors;
import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Interceptors(ShiroSecuredInterceptor.class)
@NamedQueries({
        @NamedQuery(
                name = "User.find",
                query = "SELECT u FROM User u WHERE u.username = :username AND u.password = :password"),
        @NamedQuery(
                name = "User.list",
                query = "SELECT u FROM User u")
})
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(unique = true)
    private String username;

    @NotNull
    private String password;

    @ElementCollection(targetClass = Role.class, fetch = FetchType.EAGER)
    @Enumerated(EnumType.STRING)
    @CollectionTable(name = "UserRoles", joinColumns = { @JoinColumn(name = "userId") })
    @Column(name = "role")
    private List<Role> roles;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }
}
