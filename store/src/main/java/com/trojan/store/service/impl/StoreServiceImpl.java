package com.trojan.store.service.impl;

import com.trojan.store.mapper.StoreMapper;
import com.trojan.store.service.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/***
 * @Author 徐庶   QQ:1092002729
 * @Slogan 致敬大师，致敬未来的你
 */
@Service
public class StoreServiceImpl implements StoreService {

    @Autowired
    StoreMapper storeMapper;

    @Override
    public void reduct(Integer productId) {
        System.out.println("更新商品:"+productId);
        storeMapper.reduct(productId);
    }
}
