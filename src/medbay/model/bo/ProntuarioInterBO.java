package medbay.model.bo;

public interface ProntuarioInterBO {
    public static boolean cadastrar(ProntuarioVO prontuario);

    public static boolean editar(ProntuarioVO prontuario, String observacao);

    static ProntuarioVO [] buscar(int id); // id do prontuario.
    static ProntuarioVO [] buscar(String nome); // nome do paciente, do médico ou do exame.
    static ProntuarioVO [] buscar(CPF cpf); // paciente ou médico.
    static ProntuarioVO [] buscar(Calendar data);
    static ProntuarioVO [] buscar(MedicoVO medico); // busca por id_medico.
    static ProntuarioVO [] buscar(PacienteVO paciente) // busca por id_paciente
}
