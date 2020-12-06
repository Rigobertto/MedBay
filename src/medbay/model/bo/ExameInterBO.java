package medbay.model.vo;

public interface ExameInterBO {
    public static boolean cadastrar(ExameVO exame);
    public static boolean cadastrar(ExameVO exame, ProntuarioVO prontuario);

    public static boolean editar(ExameVO exame, String observacao);
    public static boolean editar(ExameVO exame, float valor);

    static ExameVO [] buscar(int id); // id do exame
    static ExameVO [] buscar(String nome); // nome do paciente, do médico ou do exame.
    static ExameVO [] buscar(CPF cpf); // paciente ou médico.
    static ExameVO [] buscar(Calendar data);
    static ExameVO [] buscar(MedicoVO medico); // busca por id_medico
    static ExameVO [] buscar(PacienteVO paciente) // busca por id_paciente
}