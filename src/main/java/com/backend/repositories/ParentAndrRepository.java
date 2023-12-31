package com.backend.repositories;

import com.backend.entities.Eleve;
import com.backend.entities.Parent;
import com.backend.entities.UserAccountType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ParentAndrRepository extends JpaRepository<Parent, Long> {

    @Query("SELECT p FROM Parent p WHERE p.cni=?1")
    Optional<Parent> findParentByCNI(String cni);

    @Query("SELECT e FROM Eleve e, Parent p, User u WHERE p.user.id = u.id AND  e.parent.id = p.id AND u.username = ?1 AND u.type = ?2")
    Optional<List<Eleve>> FindParentByUsernameTp(String username, UserAccountType type);



}
