package com.Admin;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminRepository extends JpaRepository<AdminBean, Integer> {
    AdminBean findByAdminIdAndPassword(Integer adminId, String password);
}