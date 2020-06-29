package usm.web.pretoplus.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import usm.web.pretoplus.model.Solicitante;
import usm.web.pretoplus.repository.*;

@Controller
public class SolicitanteController {
	
	@Autowired
	private SolicitanteRepository sr;
	
	//Método de listar
	
	@GetMapping("/listarsoli")
	public ModelAndView listar() {  //ALTERAR A PÁGINA ASSIM QUE RECEBER O LAYOUT
		ModelAndView resultado = new ModelAndView("presto/listar/listar");
		List<Solicitante> solicitantes = sr.findAll();
		resultado.addObject("solicitantes", solicitantes);
		return resultado;
	}
	

	//Método para realiazr inseção na base de dados
	
	@GetMapping("/inserirsoli")
	public ModelAndView inserir() {                  //ALTERAR A PÁGINA ASSIM QUE RECEBER O LAYOUT
		ModelAndView resultado = new ModelAndView("presto/cadastro/cadastro");
		resultado.addObject("solicitante", new Solicitante());
		return resultado;
	}
	
	@PostMapping("/inserirsoli")
	public String inserir(Solicitante solicitante) {
		sr.save(solicitante);
		return "redirect:/listarsoli";
	}
	//Método para eitar
//	
//	@GetMapping("/editarS/{IdSolicitante}")
//	public ModelAndView editar(@PathVariable("IdSolicitante") Long IdSolicitante) {
//		Solicitante solicitante = sr.getOne(IdSolicitante);
//		ModelAndView resultado = new ModelAndView("presto/edicao/editar");
//		resultado.addObject("solicitante", solicitante);
//		return resultado;
//	}
	
//	@PostMapping("/editarS")
//	public String editar(Solicitante solicitante) {
//		sr.save(solicitante);
//		return "redirect:/listarsoli";
//	}
	
	
	@GetMapping("/excluirS/{id}")
	public String excluir(@PathVariable Long id) {
		sr.deleteById(id);
		return "redirect:/listarsoli";
	}
	
	
	
	//Método de pesquisa por nome
	//Parametro opcional pois temos duas rotas, uma que recebe o nome, e outra não.
	
	@GetMapping({"/pesquisaNome/{nome}", "/pesquisaNome"})
	public @ResponseBody List<Solicitante> pesquisaNome(@PathVariable Optional<String> nome){
		if(nome.isPresent()) {
			return sr.findByPNomeSolicitanteContaining(nome.get());
		} else {
			return sr.findAll();
		}
		
	}

	
}
