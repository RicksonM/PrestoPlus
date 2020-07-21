package usm.web.pretoplus.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import usm.web.pretoplus.model.Contrato;
import usm.web.pretoplus.model.Descricao;
import usm.web.pretoplus.model.Usuario;
import usm.web.pretoplus.repository.ContratoRepository;
import usm.web.pretoplus.repository.UsuarioRepository;

@Controller
public class ContratoController {
	
	    @Autowired
		private ContratoRepository cr;
	    
	    @Autowired
	    private UsuarioRepository ur;
	/* --------------------------CADASTRO DE CONTRATO------------------------------------------- */
	    
	//Método para Cadastro de usuario como Cliente através do INSERT
		@GetMapping("/contratos")
		public ModelAndView contrato(HttpSession session) {  
			Usuario usuarios = ur.findByEmail(SecurityContextHolder.getContext().getAuthentication().getName());
			ModelAndView resultado = new ModelAndView("presto/contrato/contratos");
			resultado.addObject("contrato", new Contrato());
			resultado.addObject("avaliacao", new Descricao());
			session.setAttribute("user", usuarios);
			return resultado;
		}	
		
		//URL que recebe, trata e salva os dados no banco de dados
		@PostMapping("/contratos")
		public String contrato (Contrato contrato) {
			contrato.setStatus("Pendente");
			cr.save(contrato);
			return "redirect:/cadsucess";
		}
		
		
	
		private static String UPLOADED_FOLDER = "C:\\Users\\ricks\\Desktop\\gitpresto\\PrestoPlus\\prestoplus\\src\\main\\resources\\static\\img\\perfil\\";
		
		
		@PostMapping("/contratos1")
		public String cadP(@RequestParam("files") MultipartFile file,
	            RedirectAttributes redirectAttributes, Contrato contrato) {
			
			if (file.isEmpty()) {
	            redirectAttributes.addFlashAttribute("message", "Please select a file to upload");
	            contrato.setStatus("Pendente");
				cr.save(contrato);
				return "redirect:/";
	        }

	        try {

	            // Get the file and save it somewhere
	            byte[] bytes = file.getBytes();
	            Path path = Paths.get(UPLOADED_FOLDER + file.getOriginalFilename());
	            Files.write(path, bytes);

	            redirectAttributes.addFlashAttribute("message",
	                    "You successfully uploaded '" + file.getOriginalFilename() + "'");
	            contrato.setFile(file.getOriginalFilename());

	        } catch (IOException e) {
	            e.printStackTrace();
	        }

	        
	        contrato.setStatus("Pendente");
			cr.save(contrato);
			return "redirect:/";
		}
	
	
		/* ------------------------------------ Listagem --------------------------------------------------- */
		
		
		
		@GetMapping("/teste/{email}")
		public ModelAndView dali(@PathVariable String email, HttpSession session) { //ALTERAR A PÁGINA ASSIM QUE RECEBER O LAYOUT
			Usuario usuarios = ur.findByEmail(SecurityContextHolder.getContext().getAuthentication().getName());
			ModelAndView resultado = new ModelAndView("presto/contrato/contratos");
			List<Contrato> contratos = cr.findByperfil(email); //Listagem apenas dos prestadores
			session.setAttribute("user", usuarios);
			resultado.addObject("contratos", contratos);
			return resultado;
		}
		
		
		/* ----------------------------------------Detalhe----------------------------------------------------------- */
		
		@GetMapping("/exibir/{id}")
		public ModelAndView exibir(@PathVariable Long id, HttpSession session) { //ALTERAR A PÁGINA ASSIM QUE RECEBER O LAYOUT
			Usuario usuarios = ur.findByEmail(SecurityContextHolder.getContext().getAuthentication().getName());
			ModelAndView resultado = new ModelAndView("presto/contrato/exibir");
			Contrato contratos = cr.findByid(id); //Listagem apenas dos prestadores
			session.setAttribute("user", usuarios);
			resultado.addObject("contratos", contratos);
			return resultado;
		}
		
		
		@PostMapping("/detail")
		public String detail (Contrato contrato) {
	
			cr.save(contrato);
			return "redirect:/";
		}
		
		
		
		@GetMapping("/fimcontrato/{id}")
		public String excluir(@PathVariable Long id) {
			cr.deleteById(id);
			return "redirect:/";	
			
		}
		
		
		
	
	
		
		
		
		
	
	
}
