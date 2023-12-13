package br.com.cadastro.controller.dto;

import java.time.LocalDate;

import lombok.Data;

@Data
public class PessoaDTO {
	
	private Long id;
	private String nome;
	private LocalDate dataNascimento;
	private String cpf;
	private boolean gerente;

}
