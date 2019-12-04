package tech.wetech.weshop.wechat.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tech.wetech.weshop.common.query.Query;
import tech.wetech.weshop.goods.api.BrandApi;
import tech.wetech.weshop.goods.api.CategoryApi;
import tech.wetech.weshop.goods.api.ChannelApi;
import tech.wetech.weshop.goods.api.GoodsApi;
import tech.wetech.weshop.goods.po.Brand;
import tech.wetech.weshop.goods.po.Category;
import tech.wetech.weshop.goods.po.Channel;
import tech.wetech.weshop.goods.po.Goods;
import tech.wetech.weshop.user.api.AdApi;
import tech.wetech.weshop.user.api.TopicApi;
import tech.wetech.weshop.user.po.Ad;
import tech.wetech.weshop.user.po.Topic;
import tech.wetech.weshop.wechat.service.WechatHomeService;
import tech.wetech.weshop.wechat.vo.HomeCategoryVO;
import tech.wetech.weshop.wechat.vo.HomeIndexVO;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class WechatHomeServiceImpl implements WechatHomeService {
    @Autowired
    private AdApi adApi;

    @Autowired
    private ChannelApi channelApi;

    @Autowired
    private GoodsApi goodsApi;

    @Autowired
    private BrandApi brandApi;

    @Autowired
    private TopicApi topicApi;

    @Autowired
    private CategoryApi categoryApi;

    @Override
//    @Cacheable("index")
    public HomeIndexVO index() {

        List<Ad> bannerList = adApi.queryByCondition(new Query<Ad>().setSelects(Ad::getId, Ad::getLink, Ad::getImageUrl).andEqualTo(Ad::getAdPositionId, 1)).getData();

        List<Channel> channelList = channelApi.queryByCondition(new Query<Channel>().setSelects(Channel::getId, Channel::getIconUrl, Channel::getName, Channel::getUrl).setSort(new Query.Sort("sortOrder"))).getData();

        List<Goods> newGoodsList = goodsApi.queryByCondition(new Query<Goods>().setSelects(Goods::getId, Goods::getListPicUrl, Goods::getName, Goods::getRetailPrice).setPageNumber(1).setPageSize(4).andEqualTo(Goods::getNewly, true)).getData();

        List<Goods> hotGoodsList = goodsApi.queryByCondition(new Query<Goods>().setSelects(Goods::getId, Goods::getListPicUrl, Goods::getName, Goods::getGoodsBrief, Goods::getRetailPrice).setPageNumber(1).setPageSize(4).andEqualTo(Goods::getHot, true)).getData();

        List<Brand> brandList = brandApi.queryByCondition(new Query<Brand>().setSelects(Brand::getId, Brand::getNewPicUrl, Brand::getName, Brand::getFloorPrice).andEqualTo(Brand::getNewly, 1).setSort(new Query.Sort("newSortOrder"))).getData();

        List<Topic> topicList = topicApi.queryByCondition(new Query<Topic>().setSelects(Topic::getId, Topic::getScenePicUrl, Topic::getTitle, Topic::getPriceInfo, Topic::getSubtitle).setPageNumber(1).setPageSize(10)).getData();

        List<HomeCategoryVO> categoryList = new LinkedList<>();

        categoryApi.queryByCondition(
            new Query<Category>().setSelects(Category::getId, Category::getName).andEqualTo(Category::getParentId, 0)
        ).getData().forEach(c -> {

            List<Integer> categoryIdList = categoryApi.queryByCondition(new Query<Category>().setSelects(Category::getId).andEqualTo(Category::getParentId, c.getId())).getData().stream()
                .map(Category::getId)
                .collect(Collectors.toList());

            List<Goods> goodsList = goodsApi.queryByCondition(new Query<Goods>().setSelects(Goods::getId, Goods::getListPicUrl, Goods::getName, Goods::getRetailPrice).andIn(Goods::getCategoryId, categoryIdList).setPageNumber(1).setPageSize(3)).getData();
            categoryList.add(new HomeCategoryVO(c.getId(), c.getName(), goodsList));
        });

        return new HomeIndexVO().setBannerList(bannerList)
            .setChannelList(channelList)
            .setNewGoodsList(newGoodsList)
            .setHotGoodsList(hotGoodsList)
            .setBrandList(brandList)
            .setTopicList(topicList)
            .setCategoryList(categoryList);
    }
}
