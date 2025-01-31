package com.shriram.crm.service;



import com.shriram.crm.entity.Developer;
import com.shriram.crm.repository.DeveloperRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class DeveloperService {

    @Autowired
    private DeveloperRepository developerRepository;

    public List<Developer> getAllDevelopers() {
        return developerRepository.findAll();
    }

    public Developer getDeveloperById(Long id) {
        return developerRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Developer not found with ID: " + id));
    }

    public Developer createDeveloper(Developer developer) {
        return developerRepository.save(developer);
    }

    public Developer updateDeveloper(Long id, Developer developerDetails) {
        Developer developer = getDeveloperById(id);
        developer.setName(developerDetails.getName());
        developer.setRole(developerDetails.getRole());
        return developerRepository.save(developer);
    }

    public void deleteDeveloper(Long id) {
        Developer developer = getDeveloperById(id);
        developerRepository.delete(developer);
    }
}
