package org.kazi.toufique.projectmgr.repository;

import org.kazi.toufique.projectmgr.model.User;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import javax.transaction.Transactional;
import java.util.List;

public interface UserRepository extends CrudRepository<User, Long> {
    @Query(
            value = "SELECT * FROM user u WHERE u.project_id = ?1",
            nativeQuery = true)
    List<User> findByProjectId(long projectId);

    @Transactional
    @Modifying
    @Query(
            value = "UPDATE user SET project_id=NULL WHERE user_id = ?1",
            nativeQuery = true)
    void flushProjectIdForOtherUser(long userId);
}
