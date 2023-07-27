package com.retroboard.db;

import com.retroboard.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDAO extends JpaRepository<UserEntity,Long> {
}
