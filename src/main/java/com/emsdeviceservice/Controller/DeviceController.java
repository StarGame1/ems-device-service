package com.emsdeviceservice.Controller;


import com.emsdeviceservice.Entity.Device;
import com.emsdeviceservice.Service.DeviceService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/devices")
@CrossOrigin(origins = "*")
public class DeviceController {
    private final DeviceService deviceService;
    public DeviceController(DeviceService deviceService) {
        this.deviceService = deviceService;
    }

    @GetMapping
    public List<Device> getAllDevices() {
        return deviceService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Device> getDeviceById(@RequestParam long id) {
        try{
            return ResponseEntity.ok(deviceService.findById(id));
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @GetMapping("/user/{id}")
    public ResponseEntity<List<Device>> getDeviceByUserId(@PathVariable long id) {
        return ResponseEntity.ok(deviceService.findByUserId(id));
    }

    @PostMapping
    public ResponseEntity<Device> createDevice(@RequestBody Device device) {
        Device savedDevice = deviceService.save(device);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedDevice);
    }

    @PutMapping("/{deviceId}/assign/{userId}")
    public ResponseEntity<Device> assignDeviceToUser(
            @PathVariable Long deviceId,
            @PathVariable Long userId) {
        try {
            return ResponseEntity.ok(deviceService.assignToUser(deviceId, userId));
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{deviceId}/unassign")
    public ResponseEntity<Device> unassignDeviceFromUser(@PathVariable Long deviceId) {
        try {
            return ResponseEntity.ok(deviceService.unassignFromUser(deviceId));
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }




}
