package com.ashokclass.service;

import java.util.List;

import com.ashokclass.binding.DashBoardResponse;
import com.ashokclass.binding.EnquiryForm;
import com.ashokclass.binding.EnquirySearchCriteria;

public interface EnquiryService {
	public List<String> getCourseNames();
	public List<String> getEnquiryStatus();
	public DashBoardResponse getDashboardData(Integer userId);
	public String upsertEnquiry(EnquiryForm form);
	public List<EnquiryForm> getEnquiries(Integer userId,EnquirySearchCriteria criteria);
	public EnquiryForm getEnquiry(Integer enquiryId);
}
