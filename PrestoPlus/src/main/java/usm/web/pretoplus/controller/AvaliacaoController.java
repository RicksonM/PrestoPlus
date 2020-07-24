package usm.web.pretoplus.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import usm.web.pretoplus.model.Descricao;
import usm.web.pretoplus.repository.DescricaoRepository;

@Controller
public class AvaliacaoController {
	
	@Autowired
	private DescricaoRepository dr;

	
	@RequestMapping("/avaliacao")
	public String contrato (Descricao descricao) {			
		dr.save(descricao);
		return "redirect:/busca";
		
		
		}
	
}
