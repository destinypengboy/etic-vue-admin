package top._867007845.project.article.domain;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

@Data
@TableName("`article_nav`")
public class ArticleNav {
    @TableId
    private Long id;

    /**
     * 导航标题
     */
    private String navTitle;

    /**
     * 导航类型（1html自定义 2跳转链接 3markdown格式转html）
     */
    private Integer navType;

    /**
     * 导航标记
     */
    private String navCode;

    /**
     * 导航内容 导航类型为1的时候，为空 为2的时候，为链接 为3的时候 为html格式的文本
     */
    private String navContent;

    /** 导航状态（0正常 1关闭） */
    private String status;

    /**
     * 导航排序
     */
    private Integer orderNum;

    /** 文章是否支持开启评论（0否 1是） */
    private String commentStatus;

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
