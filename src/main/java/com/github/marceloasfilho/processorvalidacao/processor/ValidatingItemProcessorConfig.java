package com.github.marceloasfilho.processorvalidacao.processor;

import com.github.marceloasfilho.processorvalidacao.dominio.Cliente;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.validator.ValidatingItemProcessor;
import org.springframework.batch.item.validator.ValidationException;
import org.springframework.batch.item.validator.Validator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashSet;
import java.util.Set;

@Configuration
public class ValidatingItemProcessorConfig {

    private final Set<String> emails = new HashSet<>();

    @Bean
    public ItemProcessor<Cliente, Cliente> processadorValidatingItemProcessor() {
        ValidatingItemProcessor<Cliente> processor = new ValidatingItemProcessor<>();
        processor.setValidator(clienteValidator());
        // processor.setFilter(true);
        return processor;
    }

    private Validator<Cliente> clienteValidator() {
        return cliente -> {
            if (this.emails.contains(cliente.email())) {
                throw new ValidationException("Email já cadastrado: " + cliente.email());
            }
            this.emails.add(cliente.email());
        };
    }
}
