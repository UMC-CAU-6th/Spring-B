package umc.practice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import umc.practice.domain.Member;

public interface MemberRepository extends JpaRepository<Member,Long> {
}
