package me.www.dubboapi.model;

/**
 * @author: www
 * @date: 2018/5/1 10:06
 * @description: TODO
 */
public class Product {

    /**
     * 产品id
     */
    private Long id;
    /**
     * 产品名称
     */
    private String proName;
    /**
     * 产品价格
     */
    private Double proPrice;
    /**
     * 产品描述
     */
    private String proDesc;

    public Product() {
        super();
    }

    public Product(String proName, Double proPrice, String proDesc) {
        this.proName = proName;
        this.proPrice = proPrice;
        this.proDesc = proDesc;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProName() {
        return proName;
    }

    public void setProName(String proName) {
        this.proName = proName;
    }

    public Double getProPrice() {
        return proPrice;
    }

    public void setProPrice(Double proPrice) {
        this.proPrice = proPrice;
    }

    public String getProDesc() {
        return proDesc;
    }

    public void setProDesc(String proDesc) {
        this.proDesc = proDesc;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", proName='" + proName + '\'' +
                ", proPrice=" + proPrice +
                ", proDesc='" + proDesc + '\'' +
                '}';
    }
}

