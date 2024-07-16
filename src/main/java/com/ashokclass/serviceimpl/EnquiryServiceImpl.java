package com.ashokclass.serviceimpl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ashokclass.binding.DashBoardResponse;
import com.ashokclass.binding.EnquiryForm;
import com.ashokclass.binding.EnquirySearchCriteria;
import com.ashokclass.service.EnquiryService;

@Service
public class EnquiryServiceImpl implements EnquiryService{

	@Override
	public List<String> getCourseNames() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<String> getEnquiryStatus() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DashBoardResponse getDashboardData(Integer userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String upsertEnquiry(EnquiryForm form) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<EnquiryForm> getEnquiries(Integer userId, EnquirySearchCriteria criteria) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public EnquiryForm getEnquiry(Integer enquiryId) {
		// TODO Auto-generated method stub
		return null;
	}


}
