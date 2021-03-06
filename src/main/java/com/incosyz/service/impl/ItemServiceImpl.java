package com.incosyz.service.impl;

import com.incosyz.dao.AbstractDao;
import com.incosyz.dao.ItemDao;
import com.incosyz.dto.ItemDTO;
import com.incosyz.entity.Item;
import com.incosyz.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Stelan Briyan on 10/30/2016.
 */
@Service
public class ItemServiceImpl implements ItemService {

    @Autowired
    private ItemDao itemDao;
    @Autowired
    private AbstractDao abstractDao;

    @Override
    public void add(ItemDTO itemDTO) {
        Item item = new Item();
        item.setItemName(itemDTO.getName());
        item.setActive(true);
        abstractDao.save(item);
    }

    @Override
    public List<ItemDTO> get() {
        return generateItemDTOs(itemDao.getItem());
    }

    private ItemDTO generateItemDTO(Item item) {
        ItemDTO itemDTO = new ItemDTO();
        if (!StringUtils.isEmpty(item.getItemName())) {
            itemDTO.setName(item.getItemName());
        }
        return itemDTO;
    }

    private List<ItemDTO> generateItemDTOs(List<Item> items) {
        List<ItemDTO> itemDTOs = new ArrayList<>();
        for (Item item : items) {
            ItemDTO itemDTO = new ItemDTO();
            if (!StringUtils.isEmpty(item.getItemName())) {
                itemDTO.setName(item.getItemName());
            }
            itemDTOs.add(itemDTO);
        }
        return itemDTOs;
    }
}
