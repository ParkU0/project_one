package com.example.demo.repository;

import com.example.demo.domain.Member;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MemberRepository {
    Member save(Member memeber);
    Optional<Member> findById(Long id); //Id가 없을 경우 Null을 반환 하는데 Optional로 감싸서 반환, java8에 포함
    Optional<Member> findByName(String name);
    List<Member> findAll();

}
