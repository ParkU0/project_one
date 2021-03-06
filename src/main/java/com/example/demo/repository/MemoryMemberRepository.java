package com.example.demo.repository;

import com.example.demo.domain.Member;

import java.util.*;

public class MemoryMemberRepository implements MemberRepository {

    private static Map<Long, Member> store = new HashMap<>();
    private  static long sequence = 0L;

    @Override
    public Member save(Member memeber) {
        memeber.setId(++sequence);
        store.put(memeber.getId(), memeber);
        return memeber;
    }

    @Override
    public Optional<Member> findById(Long id) {
        return Optional.ofNullable(store.get(id));
    }

    @Override
    public Optional<Member> findByName(String name) {
        return store.values().stream()
                .filter(member -> member.getName().equals(name))
                .findAny(); //java8
    }

    @Override
    public List<Member> findAll() {
        return new ArrayList<>(store.values());
    }

    //store 초기화
    public void clearStore(){
        store.clear();
    }
}
