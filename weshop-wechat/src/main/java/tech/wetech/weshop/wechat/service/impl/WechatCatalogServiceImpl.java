package tech.wetech.weshop.wechat.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tech.wetech.weshop.common.utils.Criteria;
import tech.wetech.weshop.goods.api.CategoryApi;
import tech.wetech.weshop.goods.enums.CategoryLevelEnum;
import tech.wetech.weshop.goods.po.Category;
import tech.wetech.weshop.wechat.service.WechatCatalogService;
import tech.wetech.weshop.wechat.vo.CategoryIndexVO;
import tech.wetech.weshop.wechat.vo.CategoryVO;

import java.util.LinkedList;
import java.util.List;

@Service
public class WechatCatalogServiceImpl implements WechatCatalogService {

    @Autowired
    private CategoryApi categoryApi;

    @Override
    public List<Category> queryCategoryByLevel(CategoryLevelEnum categoryLevel) {
        Category category = new Category();
        category.setLevel(categoryLevel);
        return categoryApi.queryList(category).getData();
    }

    @Override
    public CategoryIndexVO index(Integer categoryId) {
        List<CategoryVO> categoryList = new LinkedList<>();
        categoryApi.queryByCriteria(Criteria.of(Category.class).andEqualTo(Category::getParentId, 0).page(1, 10)).getData().forEach(c -> {
            CategoryVO categoryDTO = new CategoryVO(c);
            Category category = new Category();
            category.setParentId(c.getId());
            List<Category> subCategoryList = categoryApi.queryList(category).getData();
            categoryDTO.setSubCategoryList(subCategoryList);
            categoryList.add(categoryDTO);
        });

        CategoryVO currentCategory;
        if (categoryId == null) {
            currentCategory = categoryList.get(0);
        } else {
            currentCategory = new CategoryVO(categoryApi.queryById(categoryId).getData());
        }
        return new CategoryIndexVO(categoryList, currentCategory);
    }

    @Override
    public CategoryVO current(Integer id) {
        CategoryVO categoryDTO = new CategoryVO(categoryApi.queryById(id).getData());
        Category category = new Category();
        category.setParentId(id);
        List<Category> subCategoryList = categoryApi.queryList(category).getData();
        categoryDTO.setSubCategoryList(subCategoryList);
        return categoryDTO;
    }
}
