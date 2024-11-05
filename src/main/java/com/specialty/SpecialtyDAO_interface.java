package com.specialty;

import java.util.*;

public interface SpecialtyDAO_interface {
	public void insert(SpecialtyVO specialtyVO);

	public void update(SpecialtyVO specialtyVO);

	public void delete(Integer specNo);

	public SpecialtyVO findByPrimaryKey(Integer specNo);

	public List<SpecialtyVO> getAll();

	// �U�νƦX�d��(�ǤJ�Ѽƫ��AMap)(�^�� List)
//  public List<EmpVO> getAll(Map<String, String[]> map); 
	public SpecialtyVO findByName(String specName);

}
