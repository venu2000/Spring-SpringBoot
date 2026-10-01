package com.flm.dto;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PersonDetailsDto {
	
	
    private int personId;
     
	private String userName;
	
	private String password;

}
