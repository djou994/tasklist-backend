package com.tasklist.tasklist.service;

import com.tasklist.tasklist.model.Task;
import com.tasklist.tasklist.repository.TaskRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.persistence.Table;
import java.security.PublicKey;
import java.time.LocalDate;

@Service
@Slf4j
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class TaskService {

    private final TaskRepository taskRepository;

    public Task save (Task task) {
        if (task.getId() == null) {
            task.setCreationDate(LocalDate.now());
            task.setStatus("Pendente");
        }

        setConclusionDate(task);
        task.setUpdateDate(LocalDate.now());
        return taskRepository.save(task);
    }

    private void setConclusionDate(Task task) {
        if(task.getConclusionDate() == null && task.getStatus() != null && task.getStatus().equals("Terminado")){
            task.setConclusionDate(LocalDate.now());
        } else if (task.getConclusionDate() != null && task.getStatus() != null && task.getStatus().equals("Pendente")){
            task.setConclusionDate(null);
        }
    }

    public void delete (Long id) {
        taskRepository.deleteById(id);
    }

    public Task get(Long id) {
        return taskRepository.findById(id).get();
    }

    public Iterable<Task> list (Pageable pageable) {
        log.info("LIstening all courses");
        return taskRepository.findAll(pageable);
    }
}
