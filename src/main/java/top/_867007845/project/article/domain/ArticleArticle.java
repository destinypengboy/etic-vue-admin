package top._867007845.project.article.domain;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

@Data
@TableName("`article_article`")
public class ArticleArticle {
    @TableId
    private Long id;

    /**
     * 文章标题
     */
    private String articleTitle;

    /**
     * 文章类型（1跳转链接 2markdown格式）
     */
    private Integer articleType;

    /**
     * 文章内容
     */
    private String articleContent;

    /** 文章状态（0正常 1关闭） */
    private String status;

    /** 文章是否支持开启评论（0否 1是） */
    private String commentStatus;

    /**
     * 标签ID列表
     */
    private String tagIdList;

    /**
     * 分类ID列表
     */
    private String categoryIdList;

    /** 创建者 */
    private String createBy;

    /** 创建时间 */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;

    /** 更新者 */
    private String updateBy;

    /** 更新时间 */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date updateTime;

    /** 备注 */
    private String remark;
}
