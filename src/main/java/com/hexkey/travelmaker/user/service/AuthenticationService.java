package com.hexkey.travelmaker.user.service;

import com.hexkey.travelmaker.user.dao.MemberMMapper;
import com.hexkey.travelmaker.user.dto.MemberMDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class AuthenticationService implements UserDetailsService {

    private final MemberMMapper memberMMapper;

    public AuthenticationService(MemberMMapper memberMMapper) { this.memberMMapper = memberMMapper; }

    @Override
    public UserDetails loadUserByUsername(String memberId) throws UsernameNotFoundException {

        log.info("memberId : {}", memberId);

        MemberMDTO member = memberMMapper.findByMemberId(memberId);

        log.info("member : {}", member);

        if(member == null) throw new UsernameNotFoundException("회원 정보가 존재하지 않습니다");

        return member;

    }
}