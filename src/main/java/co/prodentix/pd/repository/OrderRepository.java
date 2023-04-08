package co.prodentix.pd.repository;

import co.prodentix.pd.domain.Order;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
    default Optional<Order> findOneWithEagerRelationships(Long id){
        return this.findOneWithToOneRelationships(id);
    }
    default List<Order> findAllWithEagerRelationships(){
        return this.findAllWithToOneRelationships();
    }

    default Page<Order> findAllWithEagerRelationships(Pageable pageable){
        return this.findAllWithToOneRelationships(pageable);
    }

    @Query(
        value = "select distinct prodrentIXOrder from Order prodentIXOrder left join fetch prodentIXOrder.patients",
        countQuery = "select count(distinct prodentIXOrder) from Order prodentIXOrder"
    )

    Page<Order> findAllWithToOneRelationships(Pageable pageable);

    @Query("select distinct prodentIXOrder form Order prodentIXOrder left join fetch prodentIXOrder.patients")

    List<Order> findAllWithToOneRelationships();

    @Query("select prodentIXOrder form Order prodentIXOrder left join fetch prodentIXOrder.patients where prodentIXOrder.id =:id")
    Optional<Order> findOneWithToOneRelationships(@Param("id") Long id);
}

