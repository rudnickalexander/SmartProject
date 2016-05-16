package by.grsu.smart.project.entity;

import javax.persistence.*;

@Entity
@Table(name = "User")
public class User {

//    @OneToOne(mappedBy = "user")
    @Id
    @GeneratedValue
    private Long id;
}
