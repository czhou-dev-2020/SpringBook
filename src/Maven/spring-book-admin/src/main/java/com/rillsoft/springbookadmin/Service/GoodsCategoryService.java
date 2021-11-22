package com.rillsoft.springbookadmin.Service;

import com.rillsoft.springbookadmin.mapper.AuthRolesMapper;
import com.rillsoft.springbookadmin.mapper.GoodsCategoryMapper;
import com.rillsoft.springbookadmin.model.GoodsCategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GoodsCategoryService {
    @Autowired
    private GoodsCategoryMapper m_objGoodsCategoryMapper;

    /**
     *
     * @param m_objGoodsCategoryMapper
     */
    public GoodsCategoryService(GoodsCategoryMapper m_objGoodsCategoryMapper) {
        this.m_objGoodsCategoryMapper = m_objGoodsCategoryMapper;
    }

    public List<GoodsCategory> getAllGoodsCategoryList() {
        return m_objGoodsCategoryMapper.selectAll();
    }
}
