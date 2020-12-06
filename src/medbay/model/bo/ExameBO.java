package medbay.model.bo;

public class ExameBO implements ExameInterBO {
    public static boolean cadastrar(ExameVO exame) {
        // recebe um objeto do tipo ExameVO,
        // faz alguma validação pendente,
        // e chama ExameDAO para armazená-lo.
    }

    public static boolean cadastrar(ExameVO exame, ProntuarioVO prontuario) {
        // atrela um exame à consulta atual.
    }

    public static boolean editar(ExameVO exame, String observacao) {
        // adiciona a um objeto do tipo ExameVO uma observação.
    }

    public static boolean editar(ExameVO exame, float valor) {
        // edita o valor colocado como preço do exame disponibilizado.
    }

    static ExameVO [] buscar(int id); {
        // Chama o DAO para buscar exames com o ID indicado.
        // Cada ID de exame será hedado da consulta, assim podendo resultar divesos exames por busca.
        // Retorna uma lista de objetos do tipo ExameVO referente ao ID, caso os mesmos existam.

        /*
            Exames buscados assim são referentes a apenas uma consulta (que pode ser pesquisada facilmente)
            e por isso são referentes a apenas um PacienteVO
        */
    }

    static ExameVO [] buscar(String nome) {
        // Chama ConsultaBO.busca(nome).
        // Filtra os exames atrelados às consultas.
        // Também filtra o nome do exame.
        // Retorna todos os resultados encontrados.
    }

    static ExameVO [] buscar(CPF cpf) {
        // Chama ConsultaBO.busca(cpf).
        // Filtra os exames atrelados às consultas.
        // Retorna todos os resultados encontrados.
    }

    static ExameVO [] buscar(Calendar data) {
        // Precisa se comunicar com o DAO para encontrar exames relacionados à data informada.
        // Retorna todos os resultados encontrados.
    }

    static ExameVO [] buscar(MedicoVO medico) {
        // Chama ConsultaBO.busca(medico).
        // Filtra os exames atrelados às consultas.
    }

    static ExameVO [] buscar(PacienteVO paciente) {
        // Chama ConsultaBO.busca(paciente).
        // Filtra os exames atrelados às consultas.
    }
}