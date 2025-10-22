package com.emsdeviceservice.Service;

import com.emsdeviceservice.Entity.Device;
import com.emsdeviceservice.Repository.DeviceRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeviceService {
    private final DeviceRepository deviceRepository;

    public DeviceService(DeviceRepository deviceRepository) {
        this.deviceRepository = deviceRepository;
    }
    public List<Device> findAll() {
        return deviceRepository.findAll();
    }
    public Device findById(Long id) {
        return deviceRepository.findById(id).orElseThrow(()
        -> new EntityNotFoundException("Device with id " + id + " not found"));
    }
    public Device save(Device device) {
        return deviceRepository.save(device);
    }

    public List<Device> findByDeviceName(String deviceName) {
        return deviceRepository.findByDeviceName(deviceName).orElseThrow(()->new EntityNotFoundException("Device not found"));
    }

    public List<Device> findByUserId(Long userId) {
        return deviceRepository.findByUserId(userId);
    }

    public Device update(Long id, Device updatedDevice) {
        Device existingDevice = findById(id);

        existingDevice.setName(updatedDevice.getName());
        existingDevice.setMaxConsumption(updatedDevice.getMaxConsumption());

        return deviceRepository.save(existingDevice);
    }

    public void deleteById(Long id) {
        if (!deviceRepository.existsById(id)) {
            throw new RuntimeException("Device not found with id: " + id);
        }
        deviceRepository.deleteById(id);
    }

    public Device assignToUser(Long deviceId, Long userId) {
        Device device = findById(deviceId);
        device.setUserId(userId);
        return deviceRepository.save(device);
    }

    public Device unassignFromUser(Long deviceId) {
        Device device = findById(deviceId);
        device.setUserId(null);
        return deviceRepository.save(device);
    }


}
