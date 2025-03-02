package fin.org.trst.db.repository;

import fin.org.trst.db.model.ClientAccount;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientAccountRepository extends JpaRepository<ClientAccount, Long> {
}
