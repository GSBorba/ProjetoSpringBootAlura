package curso.alura.api.repository;

import curso.alura.api.domain.jpa.Medico;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MedicoRepository extends JpaRepository<Medico, Long> {

}
