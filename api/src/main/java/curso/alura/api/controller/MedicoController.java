package curso.alura.api.controller;

import curso.alura.api.domain.dto.medico.DadosAtualizacaoMedico;
import curso.alura.api.domain.dto.medico.DadosCadastroMedico;
import curso.alura.api.domain.dto.medico.DadosListagemMedico;
import curso.alura.api.domain.jpa.Medico;
import curso.alura.api.repository.MedicoRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("medicos")
public class MedicoController {

    @Autowired
    private MedicoRepository medicoRepository;

    @PostMapping
    @Transactional
    public void cadastrar(@RequestBody @Valid DadosCadastroMedico dados){

        medicoRepository.save(new Medico(dados));
    }

    @GetMapping
    public Page<DadosListagemMedico> listar(@PageableDefault(size = 10, sort = {"nome"}) Pageable paginacao){
        return medicoRepository.findAllByAtivoTrue(paginacao).map(DadosListagemMedico::new);
    }

    @PutMapping
    @Transactional
    public void atualizar(@RequestBody @Valid DadosAtualizacaoMedico dados){
        var medico = medicoRepository.getReferenceById(dados.id());
        medico.atualizarInformacoes(dados);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public void excluir(@PathVariable Long id){
        var medico = medicoRepository.getReferenceById(id);
        medico.excluir();
    }
}
