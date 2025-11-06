package com.emsdeviceservice.Repository;

import com.emsdeviceservice.Entity.UserSnapshot;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserSnapshotRepository extends JpaRepository<UserSnapshot, Long> {
}
