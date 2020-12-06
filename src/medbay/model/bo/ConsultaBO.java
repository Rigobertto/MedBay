package medbay.model.bo;

public class ConsultaBO implements ConsultaInterBO {
    static boolean cadastrar(ConsultaVO consulta) {
        // recebe um objeto do tipo ConsultaVO,
        // faz alguma validação pendente,
        // e chama ConsultaDAO para armazená-lo.
    }

    static boolean cadastrar(ConsultaVO consulta, ExameVO exame) {
        // atrela um objeto exame à consulta disponibilizada
    }

    static boolean editar(ConsultaVO consulta, String observacao) {
        // adiciona a um objeto do tipo ConsultaVO uma observação.
    }

    static boolean editar(ConsultaVO consulta, Calendar data_consulta) {
        // adiciona a um objeto do tipo ConsultaVO uma data nova que não pode ser menor que a data atual.
    }

    // BUSCA

    /* 
        Os métodos de busca irão chamar pelo MedicoBO e PacienteBO
        para que os mesmos encontrem médicos e/ou pacientes com a chave
        de pesquisa indicada.

        Muitos dos métodos indicados ainda precisam ser idealizados e implementados.
    */

    static ConsultaVO buscar(int id) {
        // Chama o DAO para buscar uma consulta com o ID indicado.
        // Cada ID de consulta será único, assim resulta em apenas 1 consulta por busca.
        // Retorna um objeto do tipo ConsultaVO referente ao ID, caso o mesmo exista.
    }

    static ConsultaVO [] buscar(String nome) {
        // Chama os métodos MedicoBO.buscar(nome) e PacienteBO.buscar(nome).
        // Filtra as consultas atreladas aos médicos e/ou pacientes
        // Retorna os dois resultados concatenados.
    }

    static ConsultaVO [] buscar(CPF cpf) {
        // Chama os métodos MedicoBO.busca(cpf) e PacienteBO.busca(cpf).
        // Filtra as consultas atreladas aos médicos e/ou pacientes
        // Retorna os dois resultados concatenados.
    }

    static ConsultaVO [] buscar(Calendar data) {
        // Chama ConsultaDAO para buscar um elemento por data.
        // Busca uma consulta com a data indicada.
        // (a data procurada é a data para qual foi marcada a consulta, para evitar conflitos)
        // Retorna todos os resultados encontrados.
    }

    static ConsultaVO [] buscar(MedicoVO medico) {
        // Chama ConsultaDAO para buscar um elemento por médico.
        // Retorna todas as consultas referentes a um médico usando o seu ID.
        // ainda precisa ser implementado no objeto ConsultaVO um atributo que armazene o ID do médico.
    }

    static ConsultaVO [] buscar(PacienteVO paciente) {
        // Chama ConsultaDAO para buscar um elemento por paciente.
        // Busca todas as consultas referentes a um paciente usando o seu ID.
        // ainda precisa ser implementado no objeto ConsultaVO um atributo que armazene o ID do paciente.
    }

    // lembrar: atributos Mid e Pid
}
