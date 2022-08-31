package br.atlas.service.contatos_service;


import br.atlas.model.Contatos;
import br.atlas.repository.ContatosRepo;

import java.util.List;
import java.util.Optional;

public class ContatosServiceImpl implements ContatosService{

    private final ContatosRepo contatosRepo;

    public ContatosServiceImpl(ContatosRepo contatosRepo) {
        this.contatosRepo = contatosRepo;
    }


    @Override
    public Contatos createContatos(Contatos newContatos) {

        try{
            contatosRepo.save(newContatos);
        }
        catch (Exception e){
            throw new IllegalArgumentException("Erro ao criar Contato, tente Novamente.");
        }
        return newContatos;
    }

    @Override
    public List<Contatos> findAllContatos() {
        return contatosRepo.findAll();
    }

    @Override
    public void deleteContatos(Long id) {

        try {
            Optional<Contatos> contatos_data = contatosRepo.findById(id);
            if (contatos_data.isEmpty()){
                throw new IllegalArgumentException("Contato Inexistente");
            }
        }
        catch (Exception e){
            throw new IllegalArgumentException("Tente Novamente");
        }

    }

    @Override
    public Contatos updateContatos(Long id, Contatos updatedContatos) {
        try{
            Optional<Contatos> contatos_data = contatosRepo.findById(id);
            if(contatos_data.isEmpty()){
                throw new IllegalArgumentException("Contato Inexistente");
            }
            contatos_data.get().setNome(updatedContatos.getNome());
            contatos_data.get().setEmail(updatedContatos.getEmail());
            contatos_data.get().setTelefone(updatedContatos.getTelefone());
            contatosRepo.save(contatos_data.get());

        }
        catch (Exception e){
            throw new IllegalArgumentException("Tente Novamente");
        }


        return updatedContatos;
    }


}
