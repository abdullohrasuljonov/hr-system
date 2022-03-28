package uz.pdp.hr.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.pdp.hr.entity.Tourniquet;

import java.util.Optional;
import java.util.UUID;

public interface TourniquetRepository extends JpaRepository<Tourniquet, UUID> {
    Optional<Tourniquet> findByEmployee_EmailAndStatusTrue(String employee_email);
}
