package com.example.finstability.repository;

import com.example.finstability.model.SaveData;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DataRepository extends JpaRepository<Long, SaveData> {
}
