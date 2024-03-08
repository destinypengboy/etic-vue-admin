package top._867007845.project.article.dto;

import lombok.Data;

import java.util.List;

@Data
public class ArticleListQueryDto {

    /**
     * 是否分页
     */
    private Boolean paged;

    /**
     * 页码
     */
    private Integer pageNo;

    /**
     * 每页条数
     */
    private Integer pageSize;

    /**
     * 返回格式是否是以标签进行分组
     */
    private Boolean tagGrouped;

    /**
     * 返回格式是否是以分组进行分组
     */
    private Boolean cateGrouped;

    /**
     * 返回格式是否是以时间进行分组
     */
    private Boolean timeGrouped;

    /**
     * 标签ID列表
     */
    private List<Long> tagIds;

    /**
     * 分组ID列表
     */
    private List<Long> cateIds;

}
