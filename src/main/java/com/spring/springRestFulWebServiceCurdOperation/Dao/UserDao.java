package com.spring.springRestFulWebServiceCurdOperation.Dao;

import com.spring.springRestFulWebServiceCurdOperation.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDao extends JpaRepository<User, Long> {
}
