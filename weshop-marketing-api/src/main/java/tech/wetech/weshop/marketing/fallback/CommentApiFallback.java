package tech.wetech.weshop.marketing.fallback;

import org.springframework.stereotype.Component;
import tech.wetech.weshop.fallback.ApiFallback;
import tech.wetech.weshop.marketing.api.CommentApi;
import tech.wetech.weshop.marketing.dto.CommentCountDTO;
import tech.wetech.weshop.marketing.dto.CommentResultDTO;
import tech.wetech.weshop.marketing.po.Comment;
import tech.wetech.weshop.marketing.query.CommentQuery;
import tech.wetech.weshop.utils.Result;

import java.util.List;

@Component
public class CommentApiFallback extends ApiFallback<Comment> implements CommentApi {
    @Override
    public Result<List<CommentResultDTO>> queryList(CommentQuery commentQuery) {
        return null;
    }

    @Override
    public Result<CommentCountDTO> countList(CommentQuery commentQuery) {
        return null;
    }
}
