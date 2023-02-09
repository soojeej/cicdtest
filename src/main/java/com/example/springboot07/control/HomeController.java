package com.example.springboot07.control;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.springboot07.dto.SampleDTO;

@Controller
@RequestMapping("/home")
public class HomeController {

	@GetMapping("/ex1")
	public void ex1() {
		System.out.println("===========> ex1 ");
		//return "뷰이름"; 처럼 뷰이름 따로 안줘도 됨
	}
	
	@GetMapping("/ex2")
	public void ex2(Model model) {
		System.out.println("===========> ex2 ");
		List<SampleDTO> list = new ArrayList<SampleDTO>();
		for(Long i = 1L;i<10L;i++) {
			SampleDTO dto = SampleDTO.builder().sno(i).first("scott..."+i).last("tiger..."+i)
					.regtime(LocalDateTime.now()).build();
			list.add(dto);
		}
		
		model.addAttribute("list",list);
		System.out.println("list : "+list);
	
	}
	
	@GetMapping("/ex3")
	public String ex3(RedirectAttributes redirectAttributes,Model model) {
		//리다이렉트 해도 값 안잃어버리고 전달
		SampleDTO dto = SampleDTO.builder()
								.sno(100L).first("scott").last("tiger").regtime(LocalDateTime.now())
								.build();
		redirectAttributes.addAttribute("msg","hi hello"); //이건 겟방식으로 감 . 지속적
		redirectAttributes.addFlashAttribute("result","success"); //포스트 방식으로 감 . 일회성
		redirectAttributes.addFlashAttribute("dto",dto);
		return "redirect:/home/ex4";
	}
	
	@GetMapping("/ex4")
	public void ex4() {
		System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>> : ex4 지나는중");
	}
	
	@GetMapping("/ex5")
	public void ex5(Model model) {
		List<SampleDTO> list = new ArrayList<SampleDTO>();
		for(Long i = 1L;i<10L;i++) {
			SampleDTO dto = SampleDTO.builder().sno(i).first("scott..."+i).last("tiger..."+i)
					.regtime(LocalDateTime.now()).build();
			list.add(dto);
		}
		
		model.addAttribute("list",list);
	}
	
	@GetMapping("/ex6")
	public void ex6(Model model) {
		List<SampleDTO> list = new ArrayList<SampleDTO>();
		for(Long i = 1L;i<10L;i++) {
			SampleDTO dto = SampleDTO.builder().sno(i).first("scott..."+i).last("tiger..."+i)
					.regtime(LocalDateTime.now()).build();
			list.add(dto);
		}
		
		model.addAttribute("list",list);
	}
	
	@GetMapping("exview")
	public void exview(@RequestParam("sno")int sno, Model model) {
		model.addAttribute("sno",sno);
	}
	
	@GetMapping("/ex7")
	public void ex7(Model model) {
		List<SampleDTO> list = new ArrayList<SampleDTO>();
		for(Long i = 1L;i<10L;i++) {
			SampleDTO dto = SampleDTO.builder().sno(i).first("scott..."+i).last("tiger..."+i)
					.regtime(LocalDateTime.now()).build();
			list.add(dto);
		}
		
		model.addAttribute("list",list);
	}
	
}
