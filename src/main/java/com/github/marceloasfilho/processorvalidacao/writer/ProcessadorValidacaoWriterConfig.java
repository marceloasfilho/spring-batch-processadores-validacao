package com.github.marceloasfilho.processorvalidacao.writer;

import com.github.marceloasfilho.processorvalidacao.dominio.Cliente;
import org.springframework.batch.item.ItemWriter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ProcessadorValidacaoWriterConfig {
    @Bean
    public ItemWriter<Cliente> processadorValidacaoWriter() {
        return clientes -> clientes.forEach(System.out::println);
    }
}
