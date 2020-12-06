package medbay.model.bo;

public interface ConsultaInterBO {
    static boolean cadastrar(ConsultaVO consulta); // Cadastra uma consulta
    static boolean cadastrar(ConsultaVO consulta, ExameVO exame); // Vincula um exame a uma consulta

    static boolean editar(ConsultaVO consulta, String observacao);
    static boolean editar(ConsultaVO consulta, Calendar data_consulta);

    static ConsultaVO buscar(int id); // id da consulta
    static ConsultaVO [] buscar(String nome); // nome do paciente e ou do médico
    static ConsultaVO [] buscar(CPF cpf); // cpf do paciente e ou do médico
    static ConsultaVO [] buscar(Calendar data); // "marcados em" e "marcados para"
    static ConsultaVO [] buscar(MedicoVO medico); // busca por id_medico
    static ConsultaVO [] buscar(PacienteVO paciente) // busca por id_paciente
}