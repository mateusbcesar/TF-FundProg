class Hackatona {
    private ArrayList<Time> times;
    private ArrayList<Double> notasAvaliadores;

    public Hackatona() {
        this.times = new ArrayList<>();
        this.notasAvaliadores = new ArrayList<>();
    }

    public void criarTime(String nomeTime) {
        if (times.size() >= 15) {
            System.out.println("Limite máximo de times atingido.");
            return;
        }

        Time time = new Time(nomeTime);
        times.add(time);
        System.out.println("Time \"" + nomeTime + "\" criado com sucesso.");
    }

    public void adicionarAluno(String nomeTime, Aluno aluno) {
        Time time = encontrarTime(nomeTime);
        
        if (time == null) {
            System.out.println("Time \"" + nomeTime + "\" não encontrado.");
            return;
        }
        
        if (time.getAlunos().size() == 5     && !existeAlunoDeOutroCurso(time, aluno)) {
            System.out.println("O time deve ter pelo menos 1 aluno de outro curso.");
            return;
        }
        
        if (time.getAlunos().size() > 5) {
            System.out.println("Limite máximo de alunos no time.");
            return;
        }

        time.adicionarAluno(aluno);
    }  
    
    public void adicionarAvaliador(double nota, String time ) { 
        Time time4 = encontrarTime(time);
        
        if (time4.getNotas().size() >= 5) {
            System.out.println("Limite máximo de avaliadores atingido.");
            return;
        }

        if (nota < 0 || nota > 5) {
            System.out.println("A nota deve estar entre 0 e 5.");
            return;
        }

        time4.adicionarNota(nota);
        System.out.println("Nota adicionada com sucesso.");
    }

    public Time identificarTimeVencedor() {
        Time vencedor = null;
        double maiorNota = -1;

        for (Time time : times) {
            double media = time.calcularMedia();
            if (media > maiorNota) {
                maiorNota = media;
                vencedor = time;
            }
        }

        return vencedor;
    }

    public List<Aluno> listarAlunos() {
        List<Aluno> listaAlunos = new ArrayList();
        
        for (Time time : times) {
            for(Aluno aluno : time.getAlunos()){
                listaAlunos.add(aluno);
            }
        }

        return listaAlunos;
    }

    public List<Time> listarTimesComNotaAcimaDe20() {
        List<Time> timesAcimaDe20 = new ArrayList<>();

        for (Time time : times) {
            double somaNotas = 0;
            for (double nota : time.getNotas()) {
                somaNotas += nota;
            }

            if (somaNotas > 20) {
                timesAcimaDe20.add(time);
            }
        }

        return timesAcimaDe20;
    }

    public void mudaTime(String nomeTime, Time newTime) {
        for (Time time : times) {
            if (time.getNome().equals(nomeTime)) {
                time = newTime;
            }
        }
    }
    
    public Time encontrarTime(String nomeTime) {
        for (Time time : times) {
            if (time.getNome().equals(nomeTime)) {
                return time;
            }
        }
        return null;
    }

    private boolean existeAlunoDeOutroCurso(Time time, Aluno aluno) {
        if(time.getAlunos().size() == 0) return true;
        
        for (Aluno a : time.getAlunos()) {
            if (!a.getCurso().equals(aluno.getCurso())) {
                return true;
            }
        }
        return false;
    }
}
