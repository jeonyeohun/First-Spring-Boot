package isel.edu.handong.iselweb.service;

import isel.edu.handong.iselweb.domain.Member;
import isel.edu.handong.iselweb.repository.MemberRepository;
import isel.edu.handong.iselweb.repository.MemoryMemberRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
@Transactional
public class MemberServiceIntegrationTest {
    @Autowired MemberService memberService;
    @Autowired MemberRepository memberRepository;

    @Test
    void join() {
//        given
        Member member = new Member();
        member.setName("hello");

//        when
        Long saveId = memberService.join(member);

//        then
        Member findMember = memberService.findOne(saveId).get();
        Assertions.assertThat(member.getName()).isEqualTo(findMember.getName());
    }

    @Test
    void 중복_회원_예외(){
//        given
        Member member1 = new Member();
        member1.setName("spring");

        Member member2 = new Member();
        member2.setName("spring");

//        when
        memberService.join(member1);
//        Smarter method than try-catch
        assertThrows(IllegalStateException.class, () -> memberService.join(member2));
//        With Try-Catch
//        try{
//            memberService.join(member2);
//            fail();
//        }
//        catch (IllegalStateException e){
//            Assertions.assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다.");
//        }


//        then

    }

    @Test
    void findMembers() {
    }

    @Test
    void findOne() {
    }
}
