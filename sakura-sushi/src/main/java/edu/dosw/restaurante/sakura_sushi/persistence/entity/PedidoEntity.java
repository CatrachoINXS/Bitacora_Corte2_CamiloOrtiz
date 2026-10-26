package edu.dosw.restaurante.sakura_sushi.persistence.entity;

import edu.dosw.restaurante.sakura_sushi.model.domain.ItemPedido;
import edu.dosw.restaurante.sakura_sushi.model.domain.enums.EstadoPedido;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "pedidos")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PedidoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Long idMesa;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "pedido_id")
    private List<ItemPedidoEntity> items;

    @Enumerated(EnumType.STRING)
    private EstadoPedido estado;

    @CreationTimestamp
    private LocalDateTime timestamp;
}
