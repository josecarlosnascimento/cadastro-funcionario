package br.com.cadastro.controller;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.cadastro.controller.dto.PessoaDTO;
import br.com.cadastro.model.PessoaModel;
import br.com.cadastro.repository.PessoaRepository;

@RestController
@RequestMapping("/pessoa")
public class PessoaController {
	
	@Autowired
	private PessoaRepository pessoaRepository;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@PostMapping
	public ResponseEntity<PessoaModel> inserir(@RequestBody PessoaDTO pessoaDTO){
		var pessoaModel = modelMapper.map(pessoaDTO, PessoaModel.class);
		pessoaModel.setFuncionario(!pessoaDTO.isGerente());
		return ResponseEntity.ok(pessoaRepository.save(pessoaModel));
	}
}
