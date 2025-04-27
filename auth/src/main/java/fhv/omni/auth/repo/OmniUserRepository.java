package fhv.omni.auth.repo;

import fhv.omni.auth.entity.OmniUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface OmniUserRepository extends JpaRepository<OmniUser, String> {
    Optional<OmniUser> findByUsername(String username);
}
