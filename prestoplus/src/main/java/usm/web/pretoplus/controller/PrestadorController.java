package usm.web.pretoplus.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import usm.web.pretoplus.model.Prestador;
import usm.web.pretoplus.model.Usuario;
import usm.web.pretoplus.repository.PrestadorRepository;
import usm.web.pretoplus.repository.UsuarioRepository;

@Controller
public class PrestadorController {
	
	@Autowired
	private PrestadorRepository pr;
	private UsuarioRepository ur;
	
	
	
	
	
//	----------------------------------- x ---------------------------------
	
	//Método de listar
	
	@GetMapping("/listarprest")
	public ModelAndView listar() {  //ALTERAR A PÁGINA ASSIM QUE RECEBER O LAYOUT
		ModelAndView resultado = new ModelAndView("presto/listapre");
		List<Prestador> prestadores = pr.findAll();
		resultado.addObject("prestadores", prestadores);
		return resultado;
	}
	
	
	
	//Método para realiazr inseção na base de dados
	@GetMapping("/inserirprest")
	public ModelAndView inserir() {
		ModelAndView resultado = new ModelAndView("presto/cadastro/cadastroprestador");
		resultado.addObject("prestador", new Prestador());
		return resultado;
	}
	
	@PostMapping("/inserirprest")
	public String inserir (Prestador prestador) {
		pr.save(prestador);
		return "redirect:/";
	}
	
	
	
	//Método para eitar
	
//		@GetMapping("/editarP/{login}")
//		public ModelAndView editar(@PathVariable String login) {
//			Prestador prestador = us.getOne(login);
//			ModelAndView resultado = new ModelAndView("presto/editarpres");
//			resultado.addObject("prestador", prestador);
//			return resultado;
//		}
		
		@PostMapping("/editarP")
		public String editar(Usuario user) {
			ur.save(user);
			return "redirect:/listarprest";
		}
		
		@GetMapping("/excluirP/{id}")
		public String excluir(@PathVariable Long id) {
			pr.deleteById(id);
			return "redirect:/listarprest";
		}
}
