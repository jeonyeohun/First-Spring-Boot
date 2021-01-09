package isel.edu.handong.iselweb.controller;

import isel.edu.handong.iselweb.domain.Member;
import isel.edu.handong.iselweb.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
//  register as component so that the spring can do component scan and register Bean.
public class MemberController {

    private final MemberService memberService;

    @Autowired
//    Autowired makes connection between component and component
    public MemberController(MemberService memberService){
        this.memberService = memberService;
    }

    @GetMapping("/members/new")
    public String createForm(){
        return "members/createMemberForm";
    }

    @PostMapping("/members/new")
    public String create(MemberForm form){
//        전달된 데이터가 form 안에 setter로 들어간다. 스프링이 해준다.
        Member member = new Member();
//        form 안에 데이터가 이미 있기 때문에 회원가입을 위해서 getter로 읽기만 하면 된다.
        member.setName(form.getName());

        memberService.join(member);
        return "redirect:/";
    }

    @GetMapping("/members")
    public String list(Model model){
        List<Member> members = memberService.findMembers();
        model.addAttribute("members", members);

        return "members/memberList";
    }
}
