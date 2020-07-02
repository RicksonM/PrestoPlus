package usm.web.pretoplus.controller;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

//Importando bibliotecas necessarias

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import usm.web.pretoplus.model.Contrato;
import usm.web.pretoplus.model.Descricao;
import usm.web.pretoplus.model.Usuario;
import usm.web.pretoplus.repository.DescricaoRepository;
import usm.web.pretoplus.repository.UsuarioRepository;

@Controller
public class UsuarioController {

	//Injeção do repositorio UsuarioRepository
	@Autowired
	private UsuarioRepository ur;
	
	@Autowired
	private DescricaoRepository dr;


	
	/* -------------------- CADASTRAR CLIENTE---------------------------------- */
	
	
	//Método para Cadastro de usuario como Cliente através do INSERT
	@GetMapping("/inseriruser")
	public ModelAndView inserir() {                  
		ModelAndView resultado = new ModelAndView("presto/cadastro/caduser");
		resultado.addObject("user", new Usuario());
		return resultado;
	}	
	
	private static String UPLOADED_FOLDER = "C:\\Users\\ricks\\Desktop\\gitpresto\\prestoplus\\src\\main\\resources\\static\\img\\perfil\\";

	
	//URL que recebe, trata e salva os dados no banco de dados
	@PostMapping("/inseriruser")
	public String inserir (@RequestParam("files") MultipartFile file,
            RedirectAttributes redirectAttributes, Usuario user) {

		if (file.isEmpty()) {
            redirectAttributes.addFlashAttribute("message", "Please select a file to upload");
            return "redirect:uploadStatus";
        }

        try {

            // Get the file and save it somewhere
            byte[] bytes = file.getBytes();
            Path path = Paths.get(UPLOADED_FOLDER + file.getOriginalFilename());
            Files.write(path, bytes);

            redirectAttributes.addFlashAttribute("message",
                    "You successfully uploaded '" + file.getOriginalFilename() + "'");
            user.setFile(file.getOriginalFilename());

        } catch (IOException e) {
            e.printStackTrace();
        }
        
		user.setSenha(new BCryptPasswordEncoder().encode(user.getPassword())); //Criptografando a senha para salvar no banco de dados
		user.setTipo("cliente");    //Definido FLAG, se é cliente ou prestador
		user.setEmail(user.getEmail());
		ur.save(user);
		return "redirect:/cadsucess";
				
	}
	
	
	/* ----------------------CADASTRAR PRESTADOR-------------------------------- */
	
	
	//Método de cadastro do usuario como Prestador através do INSERT
	@GetMapping("/cadP/{email}")
	public ModelAndView cadP(@PathVariable String email, HttpSession session) {
		Usuario usuarios = ur.findByEmail(SecurityContextHolder.getContext().getAuthentication().getName());
		Usuario usuario = ur.getOne(email);
		ModelAndView resultado = new ModelAndView("presto/cadastro/cadprest");
		session.setAttribute("usu", usuarios);
		resultado.addObject("user", usuario);
		return resultado;
	}
	
	//URL que recebe o cadastro de prestador e salva
	@PostMapping("/cad")
	public String cadP(Usuario user, HttpSession session) {
		Usuario usuarios = ur.findByEmail(SecurityContextHolder.getContext().getAuthentication().getName());
		
		session.setAttribute("user", usuarios);
		user.setEmail(user.getEmail());
		user.setTipo("prestador");  //Definindo FLAG como prestador
		ur.save(user);
		return "redirect:/";
	}
	
	/* ---------------------------- TESTE ------------------------------------- */
	
	
	
	/* ------------------------EDITANDO CADASTRO DE CLIENTE------------------------------ */

	
	//Método que recebe o objeto usuario com pelo email e edita os dados
	@GetMapping("/editarS/{email}")
	public ModelAndView edit(@PathVariable String email, HttpSession session) {
		Usuario usuarios = ur.findByEmail(SecurityContextHolder.getContext().getAuthentication().getName());
		Usuario usuario = ur.getOne(email);
		ModelAndView resultado = new ModelAndView("presto/edicao/editar");
		session.setAttribute("usu", usuarios);
		resultado.addObject("user", usuario);
		return resultado;
	}
	
	//Salvando as edições
	@PostMapping("/edit")
	public String editarus (@RequestParam("files") MultipartFile file,
            RedirectAttributes redirectAttributes, Usuario user) {

		if (file.isEmpty()) {
           redirectAttributes.addFlashAttribute("message", "Please select a file to upload");
           user.setFile(user.getFile());
           user.setSenha(new BCryptPasswordEncoder().encode(user.getPassword()));
	   		user.setEmail(user.getEmail());
	   		
	   		//Verificando o tipo do usuario (cliente ou prestador) 
	   		if(user.getTipo() == "cliente") {
	   			user.setTipo("cliente");
	   		} else if (user.getTipo().toString() == "prestador") {
	   			user.setTipo("prestador");
	   		}
	   		ur.save(user);
	   		return "redirect:/";       
	   		}

       try {

           // Get the file and save it somewhere
           byte[] bytes = file.getBytes();
           Path path = Paths.get(UPLOADED_FOLDER + file.getOriginalFilename());
           Files.write(path, bytes);

           redirectAttributes.addFlashAttribute("message",
                   "You successfully uploaded '" + file.getOriginalFilename() + "'");
           user.setFile(file.getOriginalFilename());

       } catch (IOException e) {
           e.printStackTrace();
       }
		user.setSenha(new BCryptPasswordEncoder().encode(user.getPassword()));
		user.setEmail(user.getEmail());
		
		//Verificando o tipo do usuario (cliente ou prestador) 
		if(user.getTipo() == "cliente") {
			user.setTipo("cliente");
		} else if (user.getTipo().toString() == "prestador") {
			user.setTipo("prestador");
		}
		ur.save(user);
		return "redirect:/";
	}
	
	
	/* -----------------------EDITAR CADASTRO PERSTADOR------------------------------- */
	
	
	//Método de editar o cadastro de prestador
	@GetMapping("/editarP/{email}")
	public ModelAndView editar(@PathVariable String email, HttpSession session) {
		Usuario usuarios = ur.findByEmail(SecurityContextHolder.getContext().getAuthentication().getName());
		Usuario usuario = ur.getOne(email);
		ModelAndView resultado = new ModelAndView("presto/cadastro/editarP");
		session.setAttribute("usu", usuarios);
		resultado.addObject("user", usuario);
		return resultado;
	}
	//URL que recebe o cadastro de prestador e salva
	@PostMapping("/editP")
	public String edits(Usuario user) {
		user.setEmail(user.getEmail());
		user.setTipo("prestador");
		ur.save(user);
		return "redirect:/";
	}
	
	
	/* ------------------------METODO DE CADASTRO ERRO E SUCESSO------------------------------ */
	
	
	//Método de erro no cadastro
	@RequestMapping("/caderror")
	public ModelAndView error(HttpSession session) {
		Usuario usuarios = ur.findByEmail(SecurityContextHolder.getContext().getAuthentication().getName());
		ModelAndView resultado = new ModelAndView("presto/cadastro/error");
		session.setAttribute("user", usuarios);
		return resultado;
		
	}
	
	//Método de sucesso no cadastro
	@RequestMapping("/cadsucess")
	public ModelAndView sucess(HttpSession session) {
		Usuario usuarios = ur.findByEmail(SecurityContextHolder.getContext().getAuthentication().getName());
		ModelAndView resultado = new ModelAndView("/presto/cadastro/cadastrosucesso");
		session.setAttribute("user", usuarios);
		return resultado;
		
	}
	 
	
	/* -----------------------LISTAGEM DE PRESTADORES------------------------------- */


	//Método da listagem
	@GetMapping("/busca")
	public ModelAndView busca(HttpSession session) {  //ALTERAR A PÁGINA ASSIM QUE RECEBER O LAYOUT
		Usuario usuario = ur.findByEmail(SecurityContextHolder.getContext().getAuthentication().getName());
		String teste = SecurityContextHolder.getContext().getAuthentication().getName();
		ModelAndView resultado = new ModelAndView("presto/busca/buscar");
		List<Usuario> usuarios = ur.findByprest(teste); //Listagem apenas dos prestadores
		session.setAttribute("usu", usuario);
		resultado.addObject("prest", usuarios);
		return resultado;
	}
	
	
	/* -----------------------BUSCA PELO INPUT DE BUSCAR------------------------------- */
	
	
	@PostMapping("/pesquisaProfissao")
	public ModelAndView findpro(@RequestParam("profissao") String profissao, HttpSession session){
		Usuario usuario = ur.findByEmail(SecurityContextHolder.getContext().getAuthentication().getName());
		ModelAndView resultado = new ModelAndView("presto/busca/buscar");
		resultado.addObject("user", ur.findByprofissao(profissao));
		resultado.addObject("usu", usuario);
		return resultado;
		
	}
	
	@PostMapping("/filtro")
	public ModelAndView findfiltro(@RequestParam("profissao") String profissao,
		@RequestParam("local") String local, HttpSession session){
		Usuario usuario = ur.findByEmail(SecurityContextHolder.getContext().getAuthentication().getName());
		ModelAndView resultado = new ModelAndView("presto/busca/buscar");
		resultado.addObject("user", ur.findByfiltro(local, profissao));
		resultado.addObject("usu", usuario);
		return resultado;
		
	}
	
	
	@RequestMapping("/prestador/{email}")
	public ModelAndView visualizarPrest(@PathVariable String email, HttpSession session) {  //ALTERAR A PÁGINA ASSIM QUE RECEBER O LAYOUT
		Usuario usuarios = ur.findByEmail(SecurityContextHolder.getContext().getAuthentication().getName());
		Usuario usuario = ur.getOne(email);
		ModelAndView resultado = new ModelAndView("presto/visPrestador/visualizarpres");
		Descricao avalia = new Descricao();
		List<Descricao> descr = dr.findByperfil(email);
		resultado.addObject("prestador", usuario);
		resultado.addObject("avaliacao", avalia);
		resultado.addObject("desc", descr);
		resultado.addObject("contrato", new Contrato()); // CONTRATO PARA SER ACEITO NO MOLDAL DE CONTRATO
		session.setAttribute("user", usuarios);
		return resultado;
	}
	
	
	
}


