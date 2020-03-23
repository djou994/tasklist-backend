package com.tasklist.tasklist.repository;

import com.tasklist.tasklist.model.Task;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface TaskRepository extends PagingAndSortingRepository<Task, Long> {

}
