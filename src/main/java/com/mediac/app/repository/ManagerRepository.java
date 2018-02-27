package com.mediac.app.repository;

import com.mediac.app.entity.Manager;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ManagerRepository extends JpaRepository<Manager, Long> {

    Manager save(Manager manager);

    Manager findByName(String name);

}
