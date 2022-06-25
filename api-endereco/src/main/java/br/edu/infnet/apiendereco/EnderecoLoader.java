package br.edu.infnet.apiendereco;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import br.edu.infnet.apiendereco.model.domain.Endereco;
import br.edu.infnet.apiendereco.model.service.EnderecoService;

@Component
public class EnderecoLoader implements ApplicationRunner{
	
	@Autowired
	EnderecoService enderecoService;
	
	@Override
	public void run(ApplicationArguments args) throws Exception {
		Endereco endereco = null;
		
		try {
			endereco = new Endereco();
			endereco.setBairro("Centro");
			endereco.setCep("123456");
			endereco.setComplemento("2o andar");
			endereco.setLocalidade("Rio de Janeiro");
			endereco.setLogradouro("São José, 99");
			endereco.setUf("RJ");
			
			enderecoService.incluir(endereco);
			
			System.out.println("Gravação realizada com sucesso");
			
		} catch (Exception e) {
			System.err.println("Erro gravação endereco");
			
			Endereco enderecoBusca = enderecoService.obterPorCep(null);
			System.out.println("Endereco recuperado".concat(enderecoBusca.getCep()));
			System.err.printf("%s - %s, %s %s - %s\n" ,
					enderecoBusca.getLocalidade() ,
					enderecoBusca.getComplemento() ,
					enderecoBusca.getComplemento() ,
					enderecoBusca.getUf()
					);
			try {
				endereco.setCep("3454545");
				
			} catch (Exception e2) {
				System.err.println("Erro gravação endereco");
				
			}
			
			for (Endereco end : enderecoService.obterLista()) {
				System.err.printf("%s - %s, %s %s - %s\n" ,
						end.getLocalidade() ,
						end.getComplemento() ,
						end.getComplemento() ,
						end.getUf()
						);
			}
			//enderecoService.excluir(enderecoBusca.getId());
		}
		
	}

}
