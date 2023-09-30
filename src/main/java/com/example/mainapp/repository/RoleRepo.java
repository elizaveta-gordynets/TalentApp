package com.example.mainapp.repository;

import com.example.mainapp.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepo extends JpaRepository<Role, Long> {

    Role findByRole(String role);
}
