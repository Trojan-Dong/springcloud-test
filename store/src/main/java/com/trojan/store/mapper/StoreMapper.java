package com.trojan.store.mapper;

import com.trojan.store.pojo.Store;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface StoreMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Store record);

    Store selectByPrimaryKey(Integer id);

    List<Store> selectAll();

    int updateByPrimaryKey(Store record);

    void reduct(Integer productId);
}