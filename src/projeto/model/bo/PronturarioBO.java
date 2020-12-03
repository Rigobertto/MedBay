package projeto.model.bo;

public class PronturarioBO implements ProntuarioInterBO {
    public static boolean cadastrar(ProntuarioVO prontuario) {
        // recebe um objeto do tipo ExameVO,
        // faz alguma validação pendente,
        // e chama ExameDAO para armazená-lo.
    }

    public static boolean editar(ProntuarioVO prontuario, String observacao) {
        // adiciona a um objeto do tipo ProntuarioVO uma observação.
    }

    static ProntuarioVO [] buscar(int id) {
        // Chama o DAO para buscar prontuarios com o ID indicado.
        // Cada ID de prontuario será hedado da consulta, assim podendo resultar divesos prontuarios por busca.
        // Retorna uma lista de objetos do tipo ProntuarioVO referente ao ID, caso so mesmos existam.
    }

    static ProntuarioVO [] buscar(String nome) {
        // Chama ExameBO.busca(nome).
        // Filtra os prontuarios referentes aos exames.
        // Retorna todos os resultados encontrados.
    }

    static ProntuarioVO [] buscar(CPF cpf) {
        // Chama ExameBO.busca(cpf).
        // Filtra os prontuarios atrelados aos exames.
        // Retorna todos os resultados encontrados.
    }

    static ProntuarioVO [] buscar(Calendar data) {
        // Precisa se comunicar com o DAO para encontrar prontuarios relacionados à data informada.
    }

    static ProntuarioVO [] buscar(MedicoVO medico) {
        // Chama ExameBO.busca(medico).
        // Filtra os prontuarios atrelados aos exames.
    }

    static ProntuarioVO [] buscar(PacienteVO paciente) {
        // Chama ExameBO.busca(paciente).
        // Filtra os prontuarios atrelados aos exames.
    }
}