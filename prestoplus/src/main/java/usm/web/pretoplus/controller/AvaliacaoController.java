package usm.web.pretoplus.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import usm.web.pretoplus.model.Contrato;
import usm.web.pretoplus.model.Descricao;
import usm.web.pretoplus.model.Usuario;
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
