package com.ril.donation.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ril.donation.modal.BankDetails;



@Repository
public interface BankDetailsRepository extends JpaRepository<BankDetails, Integer> {
	@Transactional
	public void deleteBySerialNoIn(List<Integer> bankSerialNumbers);

	void evictCache();

}
