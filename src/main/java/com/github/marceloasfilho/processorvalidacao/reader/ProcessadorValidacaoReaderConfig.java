package com.github.marceloasfilho.processorvalidacao.reader;

import com.github.marceloasfilho.processorvalidacao.dominio.Cliente;
import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.builder.FlatFileItemReaderBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;

@Configuration
public class ProcessadorValidacaoReaderConfig {
    @Bean
    @StepScope
    public FlatFileItemReader<Cliente> processadorValidacaoReader(
            @Value("#{jobParameters['arquivoClientes']}") Resource arquivoClientes) {
        return new FlatFileItemReaderBuilder<Cliente>()
                .name("processadorValidacaoReader")
                .resource(arquivoClientes)
                .delimited()
                .names("nome", "idade", "email")
                .targetType(Cliente.class)
                .build();
    }
}
