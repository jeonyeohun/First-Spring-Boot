package isel.edu.handong.iselweb.repository;

import isel.edu.handong.iselweb.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SpringDataJpaMemberRepository extends JpaRepository<Member, Long>, MemberRepository {
    // 기본적인 기능들은 모두 jparepository 에 만들어져 있고 제공되지 않는 findByName 만 override 하면 된다.
    @Override
    Optional<Member> findByName (String name); // => JPQL을 만들어준다: select m from Member m were m.name = ?
//    인터페이스 이름으로 쿼리를 만든다.
}
