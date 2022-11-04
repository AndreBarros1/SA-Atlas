package br.atlas.service.contatos_service;


import br.atlas.model.Esqc;
import br.atlas.repository.EsqcRepo;

import java.util.List;
import java.util.Optional;

public class ContatosServiceImpl implements ContatosService{

    private final EsqcRepo contatosRepo;

    public ContatosServiceImpl(EsqcRepo contatosRepo) {
        this.contatosRepo = contatosRepo;
    }


    @Override
    public Esqc createContatos(Esqc newEsqc) {

        try{
            contatosRepo.save(newEsqc);
        }
        catch (Exception e){
            throw new IllegalArgumentException("Erro ao criar Contato, tente Novamente.");
        }
        return newEsqc;
    }

    @Override
    public List<Esqc> findAllContatos() {
        return contatosRepo.findAll();
    }

    @Override
    public void deleteContatos(Long id) {

        try {
            Optional<Esqc> contatos_data = contatosRepo.findById(id);
            if (contatos_data.isEmpty()){
                throw new IllegalArgumentException("Contato Inexistente");
            }
        }
        catch (Exception e){
            throw new IllegalArgumentException("Tente Novamente");
        }

    }

    @Override
    public Esqc updateContatos(Long id, Esqc updatedEsqc) {
        try{
            Optional<Esqc> contatos_data = contatosRepo.findById(id);
            if(contatos_data.isEmpty()){
                throw new IllegalArgumentException("Contato Inexistente");
            }
            contatos_data.get().setNome(updatedEsqc.getNome());
            contatos_data.get().setEmail(updatedEsqc.getEmail());
            contatos_data.get().setTelefone(updatedEsqc.getTelefone());
            contatosRepo.save(contatos_data.get());

        }
        catch (Exception e){
            throw new IllegalArgumentException("Tente Novamente");
        }


        return updatedEsqc;
    }


}
