package com.github.saintdan.repo;

import com.github.saintdan.po.User;
import org.springframework.data.repository.CrudRepository;

/**
 * User repository.
 *
 * @author <a href="http://github.com/saintdan">Liao Yifan</a>
 * @date 6/25/15
 * @since JDK1.8
 */
public interface UserRepository extends CrudRepository<User, Long> {

	User findByUsr(String usr);

}
