package nl.gerimedica.assignment.repository;

import nl.gerimedica.assignment.model.Code;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository(value = "codeRepository")
public interface CodeRepository extends JpaRepository<Code, Long>
{
    Code findCodeByCode(String code);

    @Modifying
    @Query("update Code code set code.deleted = ?1 where code.deleted = '0'")
    void deleteAllCodes(String deleted);
}
