package com.emsdeviceservice.Repository;

import com.emsdeviceservice.Entity.Device;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface DeviceRepository extends JpaRepository<Device, Long> {
    Optional<Device> findByDeviceId(String deviceId);
    boolean existsByDeviceId(String deviceId);
    boolean existsByDeviceName(String name);
    List<Device> findByUserId(long userId);
    Optional<List<Device>> findByDeviceName(String deviceName);

}
