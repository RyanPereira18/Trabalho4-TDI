package br.edu.ifsuldeminas.mch.webii.crudmanager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import br.edu.ifsuldeminas.mch.webii.crudmanager.model.Address;
import br.edu.ifsuldeminas.mch.webii.crudmanager.model.Aeroporto;
import br.edu.ifsuldeminas.mch.webii.crudmanager.model.User;
import br.edu.ifsuldeminas.mch.webii.crudmanager.model.Voo;
import br.edu.ifsuldeminas.mch.webii.crudmanager.repo.AddressRepository;
import br.edu.ifsuldeminas.mch.webii.crudmanager.repo.AeroportoRepository;
import br.edu.ifsuldeminas.mch.webii.crudmanager.repo.UserRepository;
import br.edu.ifsuldeminas.mch.webii.crudmanager.repo.VooRepository;

import jakarta.transaction.Transactional;

@Component
@Transactional
public class InitializeDataBase implements CommandLineRunner {

    @Autowired
    private UserRepository userRepo;

    @Autowired
    private AddressRepository addressRepo;

    @Autowired
    private AeroportoRepository aeroportoRepo;

    @Autowired
    private VooRepository vooRepo;

    @Override
    public void run(String... args) throws Exception {
        // Inicialização de Usuários e Endereços
        User emerson = new User();
        emerson.setName("Emerson Carvalho");
        emerson.setGender("M");
        emerson.setEmail("emerson@mail.com");

        Address addressE = new Address();
        addressE.setPlace("Rua 25 de março");
        addressE.setNumber(11);
        addressE.setZipCode("37130-123");

        User lu = new User();
        lu.setName("Luiza Carvalho");
        lu.setGender("F");
        lu.setEmail("luiza@mail.com");

        Address addressL = new Address();
        addressL.setPlace("Rua 25 de julho");
        addressL.setNumber(111);
        addressL.setZipCode("37130-000");

        addressRepo.save(addressE);
        addressRepo.save(addressL);
        addressRepo.flush();

        emerson.setAddress(addressE);
        lu.setAddress(addressL);

        userRepo.save(emerson);
        userRepo.save(lu);

        // Inicialização de Aeroportos
        Aeroporto aeroportoA = new Aeroporto();
        aeroportoA.setName("Aeroporto Internacional de São Paulo");
        aeroportoA.setCode("GRU");
        aeroportoA.setLocation("Guarulhos, São Paulo, Brasil");
        aeroportoA.setTerminalCount(3);

        Aeroporto aeroportoB = new Aeroporto();
        aeroportoB.setName("Aeroporto Internacional do Rio de Janeiro");
        aeroportoB.setCode("GIG");
        aeroportoB.setLocation("Rio de Janeiro, Brasil");
        aeroportoB.setTerminalCount(2);

        aeroportoRepo.save(aeroportoA);
        aeroportoRepo.save(aeroportoB);

        // Inicialização de Voos
        Voo voo = new Voo();
        voo.setNumero("GRU1234");
        voo.setOrigem(aeroportoA);
        voo.setDestino(aeroportoB);
        voo.setDataPartida("28/03/2004");
        voo.setDataChegada("30/03/2004");

        vooRepo.save(voo);
    }
}
