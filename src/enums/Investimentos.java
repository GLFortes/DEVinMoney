package enums;

public enum Investimentos {
    CDB(1), LCI(2), LCA(3);

    private int codigo;

    private Investimentos(int codigo) {
        this.codigo = codigo;
    }

    public int getCodigo() {
        return codigo;
    }
}
