package com.example.auth.domain.empresa;

import java.io.Serializable;
import java.util.List;

import com.example.auth.domain.aluno.Aluno;
import com.example.auth.domain.estagio.Estagio;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "empresas")
public class Empresa implements Serializable {
	private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String setor;
    private String endereco;

    @OneToMany(mappedBy = "empresa")
    private List<Aluno> alunos;

    @OneToMany(mappedBy = "empresa")
    private List<Estagio> estagios;

    // Getters e Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id =  id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSetor() {
        return setor;
    }

    public void setSetor(String setor) {
        this.setor = setor;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public List<Aluno> getAlunos() {
        return alunos;
    }

    public void setAlunos(List<Aluno> alunos) {
        this.alunos = alunos;
    }

    public List<Estagio> getEstagios() {
        return estagios;
    }

    public void setEstagios(List<Estagio> estagios) {
        this.estagios = estagios;
    }

	public List<Empresa> todas() {
		// TODO Auto-generated method stub
		return null;
	}
}
