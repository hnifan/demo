package cn.edu.scnu.product.controller;

import cn.edu.scnu.product.service.ProductService;
import com.easymall.common.pojo.Product;
import com.easymall.common.vo.EasyUIResult;
import com.easymall.common.vo.SysResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {
    @Autowired
    private ProductService productService;

    @RequestMapping("/product/manage/pageManage")
    public EasyUIResult productPageQuery(Integer page, Integer rows) {
        EasyUIResult result = productService.productPageQuery(page, rows);
        return result;
    }

    @RequestMapping("/product/manage/item/{productId}")
    public Product queryById(@PathVariable String productId) {
        return productService.queryById(productId);
    }


    @RequestMapping("/product/manage/save")
    public SysResult productSave(Product product) {
        try {
            productService.productSave(product);
            return SysResult.ok();
        } catch (Exception e) {
            e.printStackTrace();
            return SysResult.build(201, e.getMessage(), null);
        }
    }
}