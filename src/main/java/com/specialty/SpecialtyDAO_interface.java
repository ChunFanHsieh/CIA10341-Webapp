package com.specialty;

import java.util.*;

public interface SpecialtyDAO_interface {
	public void insert(SpecialtyVO specialtyVO);

	public void update(SpecialtyVO specialtyVO);

	public void delete(Integer specNo);

	public SpecialtyVO findByPrimaryKey(Integer specNo);

	public List<SpecialtyVO> getAll();

	// 萬用複合查詢(傳入參數型態Map)(回傳 List)
//  public List<EmpVO> getAll(Map<String, String[]> map); 
	public SpecialtyVO findByName(String specName);

}
