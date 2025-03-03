package com.UserBehaviorPredictor.entity;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "user_behavior")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserBehaviour {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int age;
    private String gender;
    private String browsing_history;
    private boolean purchase_made;
}
