package com.example.config;

import org.apache.shardingsphere.api.sharding.hint.HintShardingAlgorithm;
import org.apache.shardingsphere.api.sharding.hint.HintShardingValue;

import java.util.Collection;
import java.util.Collections;

public class TableHint implements HintShardingAlgorithm<Integer> {

    @Override
    public Collection<String> doSharding(Collection<String> availableTargetNames, HintShardingValue<Integer> shardingValue) {
        Integer[] values = shardingValue.getValues().toArray(new Integer[0]);
        String[] tables = availableTargetNames.toArray(new String[0]);
        return Collections.singleton(tables[values[0] % 2]);
    }
}
