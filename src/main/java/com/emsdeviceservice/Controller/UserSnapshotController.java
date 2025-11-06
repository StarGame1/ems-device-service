package com.emsdeviceservice.Controller;

import com.emsdeviceservice.Entity.UserSnapshot;
import com.emsdeviceservice.Repository.UserSnapshotRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/internal/users")
public class UserSnapshotController {
    private final UserSnapshotRepository repo;
    public UserSnapshotController(UserSnapshotRepository repo){ this.repo=repo; }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void upsert(@RequestBody UserSnapshot dto){ repo.save(dto); }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id){ repo.deleteById(id); }
}

