package com.github.marceloasfilho.processorvalidacao.processor;

import com.github.marceloasfilho.processorvalidacao.dominio.Cliente;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.validator.BeanValidatingItemProcessor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ProcessadorValidacaoProcessorConfig {

    @Bean
    public ItemProcessor<Cliente, Cliente> processadorValidacaoProcessor() {
        BeanValidatingItemProcessor<Cliente> beanValidatingItemProcessor = new BeanValidatingItemProcessor<>();
        // beanValidatingItemProcessor.setFilter(true);
        return beanValidatingItemProcessor;
    }
}
