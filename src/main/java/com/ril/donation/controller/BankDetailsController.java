package com.ril.donation.controller;

import java.util.HashMap;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.persistence.Cacheable;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ril.donation.modal.BankDetails;
import com.ril.donation.repository.BankDetailsRepository;
import com.ril.donation.util.BankDetailsUtil;
import com.ril.donation.util.DeleteBankDetails;



@RestController
public class BankDetailsController
{
	@Autowired
	BankDetailsRepository  bankDetailsRepository;
		

	
	
	@org.springframework.cache.annotation.Cacheable(value="users")
	@RequestMapping(value="viewBankDetails" ,method=RequestMethod.GET)
	   public ResponseEntity<Object> viewBankDetails() {
		HashMap<String,Object> responseObject=new HashMap<String,Object>();
		List<BankDetails> list=bankDetailsRepository.findAll();
		responseObject.put("data", list);
		responseObject.put("message", "success");
		return new ResponseEntity<>(responseObject, HttpStatus.OK);
	   }
	
	@CachePut(value="users",key="#bankDetailsUtil.getSerialNo()")
	@RequestMapping(value="viewByIdBankDetails" ,method=RequestMethod.POST)
	 public ResponseEntity<Object> viewBankDetails(@Valid @RequestBody BankDetailsUtil bankDetailsUtil) {
		HashMap<String,Object> responseObject=new HashMap<>();
		java.util.Optional<BankDetails> cmp=bankDetailsRepository.findById(bankDetailsUtil.getSerialNo());
		responseObject.put("data", cmp);
		responseObject.put("message", "success");
		return new ResponseEntity<>(responseObject, HttpStatus.OK);

		
	   }
	
	@CachePut(value="users",key="#bankDetails.serialNo")
	@RequestMapping(value="saveBankDetails" ,method=RequestMethod.POST)
	public ResponseEntity<Object> saveBankDetails(@Valid @RequestBody BankDetails bankDetails)
	{
		HashMap<String,Object> responseObject=new HashMap<>();
		bankDetailsRepository.save(bankDetails);
		responseObject.put("message", "success");
		return new ResponseEntity<>(responseObject, HttpStatus.OK);

		
	}
    
	@CacheEvict(value="users",key="#bankDetailsUtil.getSerialNo()")
	@RequestMapping(value="deleteBankDetail" ,method=RequestMethod.POST)
    public ResponseEntity<Object> deleteBankDetail(  @Valid @RequestBody BankDetailsUtil bankDetailsUtil) {
		HashMap<String,Object> responseObject=new HashMap<>();
		bankDetailsRepository.deleteById(bankDetailsUtil.getSerialNo());
		responseObject.put("message", "success");
		return new ResponseEntity<>(responseObject, HttpStatus.OK);
	}
	
	@CacheEvict(value="users",key="#deleteBankDetails.getBankSerialNumbers()")
	@RequestMapping(value="deleteBankDetails" ,method=RequestMethod.POST)
    public ResponseEntity<Object> deleteBankDetails(  @Valid @RequestBody DeleteBankDetails deleteBankDetails) {
		HashMap<String,Object> responseObject=new HashMap<>();
		bankDetailsRepository.deleteBySerialNoIn(deleteBankDetails.getBankSerialNumbers());
		responseObject.put("message", "success");
		return new ResponseEntity<>(responseObject, HttpStatus.OK);
	}
	
	@CacheEvict(value="users",allEntries=true)
	public void evictCache()
	{
		
	}

	

}
