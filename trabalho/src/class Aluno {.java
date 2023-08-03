class Aluno {
    int matricula; 
    private String nome;
    private String curso;
    private String email;

    public Aluno(int matricula, String nome, String curso, String email) {
        this.matricula = matricula;
        this.nome = nome;
        this.curso = curso;
        this.email = email;
    }

    public int getMatricula() {
        return matricula;
    }

    public String getNome() {
        return nome;
    }

    public String getCurso() {
        return curso;
    }

    public String getEmail() {
        return email;
    }
    
    public  void setMatricula(int matricula) {  
        this.matricula = matricula;
    }
    
    @Override 
    public String toString(){
        return "Nome: "+nome+". Matricula: "+matricula+". Email: "+email+". Curso: "+curso;
            
    }
}