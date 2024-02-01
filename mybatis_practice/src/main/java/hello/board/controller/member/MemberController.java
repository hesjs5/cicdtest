package hello.board.controller.member;

import hello.board.domain.member.Grade;
import hello.board.service.member.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/members")
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public String create(@RequestParam String name, @RequestParam int age, @RequestParam String grade,
                         @RequestParam("images") List<MultipartFile> imageFiles) {

        System.out.println("name = " + name);
        System.out.println("age = " + age);
        System.out.println("grade = " + grade);
        System.out.println("imageFiles = " + imageFiles);

        memberService.saveMember(name, age, Grade.findByName(grade), imageFiles.get(0).getName());

        return "true";
    }
}
