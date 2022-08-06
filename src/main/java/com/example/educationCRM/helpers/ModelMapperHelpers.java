package com.example.educationCRM.helpers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
@Component
public class ModelMapperHelpers {
    @Autowired
    private ModelMapper modelMapper;

    public <T,K> T convertToModel(K obje,Class<T> classObject){
        T convertObje = modelMapper.map(obje,classObject);
        return convertObje;
    }
    public <D, T> List<D> mapAll(final Collection<T> entityList,
                                 Class<D> outCLass) {
        return entityList.stream()
                .map(entity -> convertToModel(entity, outCLass))
                .collect(Collectors.toList());
    }
}
