package edu.dosw.restaurante.sakura_sushi.repository;

import edu.dosw.restaurante.sakura_sushi.persistence.entity.ItemPedidoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemPedidoRepository extends JpaRepository<ItemPedidoEntity, Long> {
}
