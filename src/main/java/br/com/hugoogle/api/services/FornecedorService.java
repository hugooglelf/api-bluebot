package br.com.hugoogle.api.services;

import br.com.hugoogle.api.dtos.FornecedorDto;
import br.com.hugoogle.api.dtos.FornecedorProdutoDto;
import br.com.hugoogle.api.dtos.PrecoDto;
import br.com.hugoogle.api.model.Fornecedor;
import br.com.hugoogle.api.repositories.FornecedorProdutoRepository;
import br.com.hugoogle.api.repositories.FornecedorRepository;
import br.com.hugoogle.api.services.exception.DataIntegratyonViolationException;
import br.com.hugoogle.api.services.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Service
public class FornecedorService {

    @Autowired
    private FornecedorRepository repository;
    @Autowired
    private FornecedorProdutoRepository fornecedorProdutoRepository;

     public List<FornecedorProdutoDto> findByGtin(Long gtin) {
        return fornecedorProdutoRepository.listaFornecedorGtin(gtin);
     }

     public List<PrecoDto> listaPreco(Long gtin, String cnpj, String cpf) {
         return fornecedorProdutoRepository.listaPrecoQuantidadePorGtin(gtin, cnpj, cpf);
     }
    public Fornecedor findById(Integer id) {
        Optional<Fornecedor> obj = repository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Fornecedor não foi encontrado! id: " + id + ", Tipo: " + Fornecedor.class.getName()));
    }
    public List<Fornecedor> findAll() {
        return repository.findAll();
    }


    public Fornecedor update(Integer id, @Valid FornecedorDto fornecedorDto) {
        Fornecedor oldFornecedor = findById(id);
        if (findByCPF(fornecedorDto) != null && findByCPF(fornecedorDto).getId() != id) {
            throw new DataIntegratyonViolationException("CPF já cadastrado na base de dados!");
        }
        oldFornecedor.setNome(fornecedorDto.getNome());
        oldFornecedor.setCpf(fornecedorDto.getCpf());
        oldFornecedor.setCnpj(fornecedorDto.getCnpj());
        oldFornecedor.setTelefone(fornecedorDto.getTelefone());
        return repository.save(oldFornecedor);
    }

    public Fornecedor create(FornecedorDto fornecedorDto) {
        if (findByCPF(fornecedorDto) != null) {
            throw new DataIntegratyonViolationException("CPF já cadastrado na base de dados!");
        }

        return repository.save(new Fornecedor(fornecedorDto.getNome(), fornecedorDto.getCpf(), fornecedorDto.getCnpj(), fornecedorDto.getTelefone()));

    }

    public void delete(Integer id) {
        Fornecedor obj = findById(id);
        repository.deleteById(id);
    }

    private Fornecedor findByCPF(FornecedorDto fornecedorDto) {
        Fornecedor obj = repository.findByCPF(fornecedorDto.getCpf());
        if (obj != null) {
            return obj;
        }
        return null;
    }


}
