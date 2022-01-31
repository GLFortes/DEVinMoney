package enums;

public enum Agencia {
    FLORIANOPOLIS("Florianópolis", "SC"), SAO_JOSE("São José", "SC");
    private String nome;
    private String estado;

    Agencia(String nome, String estado) {
        this.nome = nome;
        this.estado = estado;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public static Agencia getAgenciaNumero(int numero) {
        switch (numero) {
            case 1:
                return FLORIANOPOLIS;
            case 2:
                return SAO_JOSE;
            default:
                throw new IllegalArgumentException("Número de agência inválido");
        }
    }
}
