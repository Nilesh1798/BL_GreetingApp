package com.example.GreetingApp.controller;

import com.example.GreetingApp.model.Greeting;
import com.example.GreetingApp.model.AuthUser;
import com.example.GreetingApp.service.GreetingService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/greetings")
public class GreetingController {

    private final GreetingService service;

    public GreetingController(GreetingService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<Greeting> createGreeting(@RequestBody AuthUser user) {
        Greeting greeting = service.addGreeting(user);
        return ResponseEntity.status(201).body(greeting); // 201 Created
    }

    @GetMapping("/{id}")
    public ResponseEntity<Greeting> getGreetingById(@PathVariable Long id) {
        Optional<Greeting> greeting = Optional.ofNullable(service.getGreetingById(id));

        return greeting.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.status(404).body(null)); // 404 if not found
    }

    @GetMapping("/all")
    public ResponseEntity<List<Greeting>> getAllGreetings() {
        List<Greeting> greetings = service.getAllGreetings();
        return ResponseEntity.ok(greetings);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Greeting> updateGreeting(@PathVariable Long id, @RequestBody String message) {
        Greeting updatedGreeting = service.updateGreeting(id, message);
        return ResponseEntity.ok(updatedGreeting);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteGreeting(@PathVariable Long id) {
        service.deleteGreeting(id);
        return ResponseEntity.ok("Greeting deleted successfully.");
    }
}
