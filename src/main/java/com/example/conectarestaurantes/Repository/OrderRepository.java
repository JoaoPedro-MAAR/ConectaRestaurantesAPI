package com.example.conectarestaurantes.Repository;

import com.example.conectarestaurantes.model.Order;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
    @Query(value = "SELECT * FROM tb_orders o WHERE " +
            "(:id IS NULL OR o.id = :id) AND " +
            "(:obra IS NULL OR LOWER(CAST(o.obra AS TEXT)) LIKE LOWER(CONCAT('%', :obra, '%'))) AND " +
            "(:gestor IS NULL OR LOWER(CAST(o.gestor AS TEXT)) LIKE LOWER(CONCAT('%', :gestor, '%'))) AND " +
            "(:status IS NULL OR o.status = :status) AND " +
            "(:maiorQue IS NULL OR o.qtd_marmitas >= :maiorQue) AND " +
            "(:menorQue IS NULL OR o.qtd_marmitas <= :menorQue)",
            nativeQuery = true)
    Page<Order> search(
            @Param("id") Long id,
            @Param("obra") String obra,
            @Param("gestor") String gestor,
            @Param("status") String status,
            @Param("maiorQue") Integer maiorQue,
            @Param("menorQue") Integer menorQue,
            Pageable pageable
    );


}
