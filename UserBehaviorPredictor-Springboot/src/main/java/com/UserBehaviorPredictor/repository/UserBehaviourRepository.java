package com.UserBehaviorPredictor.repository;

import com.UserBehaviorPredictor.entity.UserBehaviour;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserBehaviourRepository extends JpaRepository<UserBehaviour, Long> {
}