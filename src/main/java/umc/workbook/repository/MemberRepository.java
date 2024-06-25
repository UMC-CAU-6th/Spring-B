package umc.workbook.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import umc.workbook.domain.entity.Member;

public interface MemberRepository extends JpaRepository<Member, Long> {
}
