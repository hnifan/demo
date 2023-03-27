package cn.edu.scnu.product.mapper;

import com.easymall.common.pojo.Product;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ProductMapper {
    Integer queryTotal();

    List<Product> queryByPage(@Param("start") Integer start, @Param("rows") Integer rows);

    Product queryById(String productId);

    void productSave(Product product);
}
