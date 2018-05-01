package me.www.dubbo.client.ontroller;

import com.alibaba.dubbo.config.annotation.Reference;
import me.www.dubbo.api.model.Product;
import me.www.dubbo.api.service.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;

/**
 * @author: www
 * @date: 2018/5/1 15:32
 * @description: TODO
 */
@RestController
public class ProductController {

    @Reference(version = "1.0.0")
    private ProductService productService;

    @RequestMapping(value = "/products/{id}", method = RequestMethod.GET)
    public Product getById(@PathVariable("id") Long id, HttpServletResponse response) {
        Product product = productService.getById(id);
        if (product == null) {
            response.setStatus(HttpStatus.NOT_FOUND.value());
        }

        return product;
    }

}
