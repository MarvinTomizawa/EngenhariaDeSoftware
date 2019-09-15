package br.com.unicesumar.aep3.aep;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConceitoRepository extends JpaRepository<Conceito, String> {
}
