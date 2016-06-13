package com.kevin.common.utils.repaying.handler;

public interface RuleHandler<K, V> {

    V handle(K model);
}


