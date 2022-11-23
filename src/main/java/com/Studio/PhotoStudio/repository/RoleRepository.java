package com.Studio.PhotoStudio.repository;

import java.util.Optional;

import com.Studio.PhotoStudio.models.ERole;
import com.Studio.PhotoStudio.models.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
  Optional<Role> findByName(ERole name);
}
