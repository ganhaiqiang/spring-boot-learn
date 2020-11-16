package com.ikeguang.jpa.repository;

import java.util.Iterator;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.test.context.junit4.SpringRunner;

import com.ikeguang.jpa.model.User;

/**
 * @ Author: keguang @ Date: 2019/7/5 16:54 @ version: v1.0.0 @ description:
 */

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserMutiRepositoryTest {

	@Resource
	private UserMutiRepository userMutiRepository;

	@Test
	public void testPageQuery() {
		// page 表示需要取的页的index，从0开始取值。
		int page = 0, size = 2;
		Sort sort = Sort.by(Direction.ASC, "id");
		Pageable pageable = PageRequest.of(page, size, sort);

		Page<User> pageUsers = userMutiRepository.findAll(pageable);
		System.out.println("totalElements => " + pageUsers.getTotalElements());
		System.out.println("totalPages => " + pageUsers.getTotalPages());
		Iterator<User> users = pageUsers.iterator();
		while (users.hasNext()) {
			User user = users.next();
			System.out.println("user => " + user);
		}

		Page<User> pageUsers2 = userMutiRepository.findByUserName("bb", pageable);
		for (User user : pageUsers2) {
			System.out.println(user);
		}

	}
}
