package com.smit.test.repository;

import com.smit.test.model.ContactModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.query.Param;

public interface ContactRepository extends JpaRepository<ContactModel, Integer>, JpaSpecificationExecutor<ContactModel> {
    Page<ContactModel> findByFirstNameContainingOrLastNameContainingAllIgnoreCase(
            @Param("firstName") String firstName,
            @Param("lastName") String lastName,
            Pageable pageable);

}
