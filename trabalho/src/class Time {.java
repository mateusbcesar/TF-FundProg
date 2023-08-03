class Time {
    private String nome;
    private ArrayList<Aluno> alunos;
    private ArrayList<Double> notas;

    public Time(String nome) {
        this.nome = nome;
        this.alunos = new ArrayList<>();
        this.notas = new ArrayList<>();
    }

    public String getNome() {
        return nome;
    }
    
    public ArrayList<Aluno> getAlunos() {
        return alunos;
    }
    
    public ArrayList<Double> getNotas() {
        return notas;
    }

    public void adicionarAluno(Aluno aluno) {
        alunos.add(aluno);
        System.out.println(alunos.size()+"º aluno adicionado ao time.");
    }

    public void adicionarNota(double nota) {
        notas.add(nota);
    }

    public double calcularMedia() {
        double soma = 0;
        for (double nota : notas) {
            soma += nota;
        }
        return soma / notas.size();
    }
}