package is2.g57.hopetrade.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import is2.g57.hopetrade.entity.Ayudante;



public interface AyudanteRepository extends JpaRepository<Ayudante, Long> {
	Optional<Ayudante> findById(Long id);
	Optional<Ayudante> findByMail(String mail);
}
