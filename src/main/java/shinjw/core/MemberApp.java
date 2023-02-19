package shinjw.core;

import shinjw.core.member.Grade;
import shinjw.core.member.Member;
import shinjw.core.member.MemberService;
import shinjw.core.member.MemberServiceImpl;

public class MemberApp {

    public static void main(String[] args) {
        MemberService memberService = new MemberServiceImpl();
        Member memberA = new Member(1L, "memberA", Grade.VIP);
        memberService.join(memberA);

        Member findMember = memberService.findMember(memberA.getId());
        System.out.println("newMember = " + memberA.getName());
        System.out.println("findMember = " + findMember.getName());
    }
}
