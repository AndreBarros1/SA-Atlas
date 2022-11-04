package br.atlas.service.contatos_service;

import br.atlas.model.Esqc;

import java.util.List;

public interface ContatosService {

    public Esqc createContatos(Esqc newEsqc);

    public List<Esqc> findAllContatos();

    public void deleteContatos(Long id);

    public Esqc updateContatos(Long id, Esqc updatedEsqc);

}
