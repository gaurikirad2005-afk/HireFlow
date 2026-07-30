package com.hireflow.backend.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.hireflow.backend.entity.Job;
import com.hireflow.backend.repository.JobRepository;

@Service
public class JobService {

    private final JobRepository jobRepository;

    public JobService(JobRepository jobRepository) {
        this.jobRepository = jobRepository;
    }

    // Create a new job
    public Job createJob(Job job) {
        return jobRepository.save(job);
    }

    // Get all jobs
    public List<Job> getAllJobs() {
        return jobRepository.findAll();
    }

    // Get a job by ID
    public Optional<Job> getJobById(Long id) {
        return jobRepository.findById(id);
    }

    public Optional<Job> updateJob(Long id, Job updatedJob) {

    return jobRepository.findById(id).map(existingJob -> {

        existingJob.setTitle(updatedJob.getTitle());
        existingJob.setCompany(updatedJob.getCompany());
        existingJob.setDescription(updatedJob.getDescription());
        existingJob.setLocation(updatedJob.getLocation());
        existingJob.setJobType(updatedJob.getJobType());
        existingJob.setSalary(updatedJob.getSalary());
        existingJob.setExperienceLevel(updatedJob.getExperienceLevel());

        return jobRepository.save(existingJob);
    });
}
    // Delete a job
    public void deleteJob(Long id) {
        jobRepository.deleteById(id);
    }
}