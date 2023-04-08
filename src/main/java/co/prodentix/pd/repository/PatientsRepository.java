package co.prodentix.pd.repository;


import co.prodentix.pd.domain.Patients;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import javax.persistence.Entity;


/**
 * Spring Data SQL repository for the Patients entity
 */


@Repository
public interface PatientsRepository extends JpaRepository<Patients, Long> {
    default Optional<Patients> findOneWithEagerRelationships(Long id){
        return this.findOneWithToOneRelationships(id);
    }
    default List<Patients> findAllWithEagerRelationships(){
        return this.findAllWithToOneRelationships();
    }
    default Page<Patients> findAllWithEagerRelationships(Pageable pageable){
        return this.findAllWithToOneRelationships(pageable);
    }
    @Query(
        value = "select distinct patients from Patients patient left join fetch patients.user left join fetch patients.documentType",

        countQuery = "select count(distinct patients) from Patients patients"
    )
    Page<Patients> findAllWithToOneRelationships(Pageable pageable);

    @Query(
         "select distinct client from Patient patient left join fetch patients.user left jon fetch patients.documentType"
    )

    List<Patients> findAllWithToOneRelationships();

    @Query( "select patient dorm Patient patient left join fetch patients.user left join fetch patients.documentType where patients.id =: id"
    )

    Optional<Patients> findOneWithToOneRelationships(@Param("id") Long id);



  }


