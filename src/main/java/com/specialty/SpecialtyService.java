package com.specialty;

import java.util.List;



public class SpecialtyService {
	private SpecialtyDAO_interface dao;

	public SpecialtyService() {
		dao = new SpecialtyJDBCDAO();
	}

	public SpecialtyVO addSpecialty(Integer specNo, String specName, String specDesc) {

		SpecialtyVO specialtyVO = new SpecialtyVO();

		specialtyVO.setSpecNo(specNo);
		specialtyVO.setSpecName(specName);
		specialtyVO.setSpecDesc(specDesc);
		
		dao.insert(specialtyVO);

		return specialtyVO;
	}

	public SpecialtyVO updateSpecialty(Integer specNo, String specName, String specDesc) {

		SpecialtyVO specialtyVO = new SpecialtyVO();

		specialtyVO.setSpecNo(specNo);
		specialtyVO.setSpecName(specName);
		specialtyVO.setSpecDesc(specDesc);
		dao.update(specialtyVO);

		return specialtyVO;
	}

	public void deleteSpecialty(Integer specNo) {
		dao.delete(specNo);
	}

	public SpecialtyVO getOneSpecialty(Integer specNo) {
		return dao.findByPrimaryKey(specNo);
	}

	public List<SpecialtyVO> getAll() {
		return dao.getAll();
	}

}
