package by.grsu.smart.project.entity;

import javax.persistence.*;

@Entity
@Table(name = "User_Roles")
public class UserRole {
    private Long id;
    private String userEmail;
    private String role;

    public UserRole() {
    }

    @Id
    @GeneratedValue
    @Column(name = "user_role_id")
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name = "email")
    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    @Column(name = "role")
    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
