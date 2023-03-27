package cn.edu.scnu.product.service;

import cn.edu.scnu.product.mapper.ProductMapper;
import com.easymall.common.vo.EasyUIResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.easymall.common.pojo.Product;

import java.util.List;
import java.util.UUID;

@Service
public class ProductService {

    @Autowired
    private ProductMapper productMapper;

    public EasyUIResult productPageQuery(Integer page, Integer rows){
        EasyUIResult result = new EasyUIResult();

        Integer total = productMapper.queryTotal();

        Integer start = (page-1)*rows;
        List<Product> pList=productMapper.queryByPage(start,rows);


        result.setTotal(total);
        result.setRows(pList);
        return result;
    }

    public Product queryById(String productId){
        return productMapper.queryById(productId);
    }

    public void productSave(Product product) {
        product.setProductId(UUID.randomUUID().toString());
        productMapper.productSave(product);
    }
}

