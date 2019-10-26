package tech.wetech.weshop.goods.po;

import lombok.Data;

import javax.persistence.*;

@Data
@Table(name = "weshop_goods_issue")
public class GoodsIssue {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String question;

    private String answer;

    @Column(name = "goods_id")
    private String goodsId;

}
