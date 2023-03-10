package ru.kata.spring.boot_security.demo.repo;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ru.kata.spring.boot_security.demo.entity.User;

@Repository
public interface AdminRepository extends JpaRepository<User, Long> {


   @Query("select u from User u join fetch u.roles where u.username= :username")
   User findByUsername(@Param("username") String username);

}
