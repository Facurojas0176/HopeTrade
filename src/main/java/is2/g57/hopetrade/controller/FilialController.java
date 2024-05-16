package is2.g57.hopetrade.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import is2.g57.hopetrade.entity.Filial;
<<<<<<< HEAD
import is2.g57.hopetrade.repository.FilialRepository;
=======
import is2.g57.hopetrade.entity.Ayudante;
import is2.g57.hopetrade.repository.AyudanteRepository;
import is2.g57.hopetrade.repository.FilialRepository;



>>>>>>> branch-lauty3

@RestController
@RequestMapping("/filial")
public class FilialController {

	@Autowired
	private FilialRepository filialRepository;
<<<<<<< HEAD

	@GetMapping("/{id}")
	public ResponseEntity<Filial> ObtenerFilialPorId(@PathVariable Long id) {
=======
	private AyudanteRepository ayudanteRepository;

	@GetMapping("/id")
	public ResponseEntity<?> ObtenerFilialPorIdd (@RequestBody FilialRequest filialRequest){
		Long id = filialRequest.getId();
>>>>>>> branch-lauty3
		Optional<Filial> filialOp = this.filialRepository.findById(id);
		if (filialOp.isPresent()) {
			return new ResponseEntity<>(filialOp.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<>("No se encontro la filial",HttpStatus.NOT_FOUND);
		}
<<<<<<< HEAD

	}

	@GetMapping("/{direccion}")
	public ResponseEntity<Filial> ObtenerFilialPorDireccion(@PathVariable String direccion) {
=======
	
}
	
	@GetMapping("/direccion")
	public ResponseEntity<?> ObtenerFilialPorDireccion(@RequestBody FilialRequest filialRequest) {
		String direccion = filialRequest.getDireccion();
>>>>>>> branch-lauty3
		Optional<Filial> filialOp = this.filialRepository.findByDireccion(direccion);
		if (filialOp.isPresent()) {
			return new ResponseEntity<>(filialOp.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<>("No se encontro la filial",HttpStatus.NOT_FOUND);
		}
	}
<<<<<<< HEAD

	@GetMapping("/{filial}")
	public ResponseEntity<?> GuardarFilial(String nombre, String direccion, String email) {
		try {
			Filial filial = new Filial(nombre, direccion, email);
=======
	
	@PostMapping("/save")
	public ResponseEntity<?> GuardarFilial(@RequestBody FilialRequest filialRequest) {
		if ((filialRequest.getNombre() == null || filialRequest.getDireccion() == null || filialRequest.getEmail() == null )){
			return new ResponseEntity<>("Todos los campos deben tener valores", HttpStatus.BAD_REQUEST);
		}
		try {
						Filial filial = new Filial(filialRequest.getNombre(),filialRequest.getDireccion(),filialRequest.getEmail());
>>>>>>> branch-lauty3
			this.filialRepository.save(filial);
			return new ResponseEntity<>("Filial registrada", HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>("La direccion ya pertenece a otra filial", HttpStatus.BAD_REQUEST);
		}
	}
<<<<<<< HEAD

}
=======
	
	
		@PostMapping("/ingresar-ayudante")  ResponseEntity<?> IngresarAyudante (@PathVariable(value = "id_ayudante") Long IdAyudante, @PathVariable (value = "id_filial") Long IdFilial){
			 Optional<Ayudante> ayudanteOp = ayudanteRepository.findAyudanteById(IdAyudante);
			 Optional<Filial> filialOp = filialRepository.findById(IdFilial);
			if (ayudanteOp.isPresent() && filialOp.isPresent()) {
				Ayudante ayudante = ayudanteOp.get();
				Filial filial = filialOp.get();
				filial.getAyudantes().add(ayudante);
				filialRepository.save(filial);
				return new ResponseEntity<> ("Ayudante registrado en filial", HttpStatus.OK);		
				} else { return new ResponseEntity<>("Ocurrio un error", HttpStatus.BAD_GATEWAY); 
					
				}
			
			
		}
		
		@GetMapping("/listar-filiales")
		public @ResponseBody Iterable<Filial> getAllFiliales() {
			return filialRepository.findAll();
		}
		
		@GetMapping("/listar-ayudantes")
		public @ResponseBody Iterable<Filial> getAllAyudantes() {
			return filialRepository.findAll();
		}
		
	
}			
>>>>>>> branch-lauty3
