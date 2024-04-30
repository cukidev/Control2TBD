package grupo6.control2.repositories;

import grupo6.control2.entities.UserEntity;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<UserEntity,Long> {
    @Query(value = "SELECT * FROM users ", nativeQuery = true)
    List<UserEntity> getAll();

    @Query(value = "SELECT * FROM users WHERE users.id=:id ", nativeQuery = true)
    UserEntity getUserById(@Param("id") Long id);

    @Query(value = "SELECT * FROM users WHERE users.username=:username ", nativeQuery = true)
    UserEntity getUserByUsername(@Param("username") String username);

    @Transactional
    @Modifying
    @Query(value = "INSERT INTO users (username, password) VALUES (:username, :password)", nativeQuery = true)
    UserEntity saveUserCustom(@Param("username") String username, @Param("password") String password);

    @Transactional
    @Modifying
    @Query(value = "DELETE FROM users WHERE id = :id", nativeQuery = true)
    void deleteByIdCustom(@Param("id") Long id);
}
