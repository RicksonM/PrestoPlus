package usm.web.pretoplus.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import usm.web.pretoplus.model.Usuario;
import usm.web.pretoplus.repository.UsuarioRepository;

@Controller
public class SobreController {
	@Autowired
	private UsuarioRepository ur;
	
		
			@RequestMapping("/sobre")
			public ModelAndView sobre(HttpSession session) {
				Usuario usuarios = ur.findByEmail(SecurityContextHolder.getContext().getAuthentication().getName());
				ModelAndView resultado = new ModelAndView("presto/sobre/sobre");
				session.setAttribute("user", usuarios);
				return resultado;
				
			
			}
		}

