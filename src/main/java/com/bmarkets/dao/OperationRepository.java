package com.bmarkets.dao;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.bmarkets.entities.Operation;

@Repository
public interface OperationRepository extends JpaRepository<Operation, Long>{

	@Query("select o from Operation o where o.account.accountCode=:x order by o.operationDate desc")
	public Page<Operation> listOperations(@Param("x") String accountCode,Pageable pageable);
}
// 