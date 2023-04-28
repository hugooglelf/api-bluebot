package br.com.hugoogle.api.repositories;

import br.com.hugoogle.api.model.Departamento;
import br.com.hugoogle.api.model.PedidoItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PedidoItemRepository extends JpaRepository<PedidoItem, Integer> {
}
