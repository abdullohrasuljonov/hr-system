package uz.pdp.hr.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.pdp.hr.entity.TourniquetHistory;

import java.sql.Timestamp;
import java.util.List;
import java.util.UUID;

public interface TourniquetHistoryRepository extends JpaRepository<TourniquetHistory, UUID> {
    List<TourniquetHistory> findAllByExitedAtBetween(Timestamp exitedAt, Timestamp exitedAt2);
    List<TourniquetHistory> findAllByEnteredAtBetween(Timestamp exitedAt, Timestamp exitedAt2);
}
