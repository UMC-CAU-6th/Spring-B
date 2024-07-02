package umc.practice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import umc.practice.domain.Store;

public interface StoreRepository extends JpaRepository<Store,Long> {

}
