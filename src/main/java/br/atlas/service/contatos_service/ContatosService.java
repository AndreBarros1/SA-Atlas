package br.atlas.service.contatos_service;

import br.atlas.model.Contatos;

import java.util.List;

public interface ContatosService {

    public Contatos createContatos(Contatos newContatos);

    public List<Contatos> findAllContatos();

    public void deleteContatos(Long id);

    public Contatos updateContatos(Long id, Contatos updatedContatos);

}
