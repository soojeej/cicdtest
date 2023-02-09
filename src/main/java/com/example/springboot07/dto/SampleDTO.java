package com.example.springboot07.dto;

import java.time.LocalDateTime;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class SampleDTO {

	private Long sno;
	private String first;
	private String last;
	private LocalDateTime regtime;
	
	
}
