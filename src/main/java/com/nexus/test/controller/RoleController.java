package com.nexus.test.controller;

import com.nexus.test.models.Role;
import com.nexus.test.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("api/v1")
public class RoleController {
    @Autowired
    private RoleRepository roleRepository;

    @GetMapping("/roles")
    public List<Role> getAllRoles() {
        return roleRepository.findAll();
    }

    @GetMapping("/roles/{id}")
    public ResponseEntity<Role> getRoleById(@PathVariable("id") int id) throws ResourceNotFoundException {
        Role role = roleRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Role not found for this id :: " + id));
        return ResponseEntity.ok(role);
    }

    @PostMapping("/roles")
    public Role createRole(@RequestBody Role role) {
        return roleRepository.save(role);
    }

    @PutMapping("/roles/{id}")
    public ResponseEntity<Role> updateRole(@PathVariable(value = "id") int id, @RequestBody Role roleDetails) throws ResourceNotFoundException {
        Role role =  roleRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Role not found for this id :: " + id));

        role.setName(roleDetails.getName());
        final Role updatedRole = roleRepository.save(role);
        return ResponseEntity.ok(updatedRole);
    }

    @DeleteMapping("/roles/{id}")
    public Map<String, Boolean> deleteRole(@PathVariable(value = "id") int id) throws ResourceNotFoundException {
        Role role =  roleRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Role not found for this id :: " + id));

        roleRepository.delete(role);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return  response;
    }
}
