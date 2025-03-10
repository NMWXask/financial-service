package fin.org.trst.db.repository;

import fin.org.trst.db.model.ClientAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ClientAccountRepository extends JpaRepository<ClientAccount, Long> {
    @Query("SELECT c FROM ClientAccount c WHERE c.email = :email")
    ClientAccount findByEmail(@Param("email") String email);
}
