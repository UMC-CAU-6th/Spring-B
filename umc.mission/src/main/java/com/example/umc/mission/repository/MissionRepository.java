package com.example.umc.mission.repository;

import com.example.umc.mission.domain.Mission;
import com.example.umc.mission.domain.Store;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MissionRepository extends JpaRepository<Mission, Long> {

    Page<Mission> findAllByStore(Store store, PageRequest pageRequest);
}
