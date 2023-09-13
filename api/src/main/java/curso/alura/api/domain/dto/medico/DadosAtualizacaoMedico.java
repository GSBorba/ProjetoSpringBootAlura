package curso.alura.api.domain.dto.medico;

import curso.alura.api.domain.dto.endereco.DadosEndereco;
import curso.alura.api.domain.jpa.Endereco;
import jakarta.validation.constraints.NotNull;

public record DadosAtualizacaoMedico(
        @NotNull
        Long id,
        String nome,
        String telefone,
        DadosEndereco endereco) {
}
