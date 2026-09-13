package com.tutor.service;


import java.util.List;

import com.tutor.dto.TutorDTO;

public interface TutorService {
	
	TutorDTO addTutor(TutorDTO dto);
	TutorDTO updateTutor(long tutor_id,TutorDTO dto);
	String deleteTutor(long tutor_id);
	TutorDTO getTutor(long tutor_id);
	
	List<TutorDTO> findByName(String name);

    TutorDTO findByPhonenumber(long phonenumber);

    TutorDTO findByEmail(String email);

    List<TutorDTO> findByCity(String city);
    
    List<TutorDTO> findByCourse(String course);

	
	List<TutorDTO> getAllTutors();
	
	
	

}
