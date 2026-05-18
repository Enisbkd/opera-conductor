package mc.sbm.operaconductor.repository;

import java.time.Instant;
import java.util.List;
import java.util.Optional;
import mc.sbm.operaconductor.domain.User;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.*;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Spring Data JPA repository for the {@link User} entity.
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    String USERS_BY_LOGIN_CACHE = "usersByLogin";

    String USERS_BY_EMAIL_CACHE = "usersByEmail";

    /** Finds a user by their activation key. */
    Optional<User> findOneByActivationKey(String activationKey);

    /** Returns all non-activated users whose activation key is not null and whose creation date is before the given date. */
    List<User> findAllByActivatedIsFalseAndActivationKeyIsNotNullAndCreatedDateBefore(Instant dateTime);

    /** Finds a user by their password reset key. */
    Optional<User> findOneByResetKey(String resetKey);

    /** Finds a user by email address, ignoring case. */
    Optional<User> findOneByEmailIgnoreCase(String email);

    /** Finds a user by login name. */
    Optional<User> findOneByLogin(String login);

    /** Finds a user with their authorities eagerly loaded, by login name. */
    @EntityGraph(attributePaths = "authorities")
    @Cacheable(cacheNames = USERS_BY_LOGIN_CACHE, unless = "#result == null")
    Optional<User> findOneWithAuthoritiesByLogin(String login);

    /** Finds a user with their authorities eagerly loaded, by email address (case-insensitive). */
    @EntityGraph(attributePaths = "authorities")
    @Cacheable(cacheNames = USERS_BY_EMAIL_CACHE, unless = "#result == null")
    Optional<User> findOneWithAuthoritiesByEmailIgnoreCase(String email);

    /** Returns a page of all activated users. */
    Page<User> findAllByIdNotNullAndActivatedIsTrue(Pageable pageable);
}
