package com.alleyway.service;

import com.alleyway.bean.Works;
import com.alleyway.bean.WorksLabel;
import io.swagger.models.auth.In;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Map;

public interface WorksService {


    /**
     * 获取指定的分类,通过redis ，传入0表示获取一级分类，传入一级id，表示根据一级id找二级
     * @param parentId 分类的id
     * @return
     */
    List<WorksLabel> getWorksLabelsAssignByReids(Integer parentId);

    /**
     *
     * 获取指定的分类，传入0表示获取一级分类，传入一级id，表示根据一级id找二级
     * 存入redis
     *
     * @param id 分类id
     * @return
     */
    List<WorksLabel> getWorksLabelsAssignToRedis(Integer id);

    /**
     * 插入新的作品分类
     * @param parentId 父级id
     * @param content 分类名称
     * @return 插入是否成功
     */
    boolean saveWorksLabel(Integer parentId, String content);

    /**
     * 获取分类，两级的关系排好的
     * @return
     */
    List<WorksLabel> getWorksLabels();

    /**
     * 删除分类，根据分类的id
     * @param id
     * @return
     */
    boolean deleteWorksLabel(Integer id);

    /**
     * 作品上传
     * @param userId 发布者id
     * @param labelId 分类id
     * @param title 标题
     * @param cover 封面拖
     * @param content 富文本作品内容
     * @return
     */
    int saveWorks(Integer userId, Integer labelId, String title, MultipartFile cover, String content);

    /**
     * 插入作品标签
     * @param worksId 作品id
     * @param content 多个标签的内容，用逗号分割
     * @return
     */
    boolean saveWorksKeyword(Integer worksId, String content);

    /**
     * 根据分类获取作品的数据
     * @param labelId 分类id，如果为0，表示全部分类都能拿到
     * @return
     */
    List<Works> getWorksList(Integer labelId);

    /**
     * 单个图片 相对地址转绝对地址
     * 将fasetDFS中的相对地址，拼接上服务器的地址
     * @param relativePath
     * @return
     */
    String relativeToAbsolute(String relativePath);


    /**
     * 将作品的内容中的图片地址变成绝对路径
     * @param content
     * @return
     */
    String contentImgToAbsolute(String content);

    /**
     * 获取单个作品的详细信息，根据id
     * @param id
     * @return
     */
    Works getWorksById(Integer id);

    /**
     * 插入评论
     * @param userId 用户id
     * @param worksId 作品id
     * @param content 评论内容
     * @return
     */
    boolean saveComment(Integer userId, Integer worksId, String content);

    /**
     * 发送回复
     * @param commentId 父级评论id
     * @param sendUsernickname 发送者昵称
     * @param receiveUsernickname 接收者昵称
     * @param content 回复的内容
     * @return
     */
    boolean saveReply(Integer commentId, String sendUsernickname, String receiveUsernickname, String content);

    /**
     * 删除评论
     * @param userId  用户id
     * @param commentId 评论id
     * @return
     */
    boolean deleteComment(Integer userId, Integer commentId);

    /**
     * 删除回复
     * @param replyId 回复id
     * @return
     */
    boolean deleteReply(Integer replyId);

    /**
     * 点赞作品
     * @param userId 用户id
     * @param worksId 作品id
     * @return
     */
    boolean saveLikeWorks(Integer userId, Integer worksId);

    /**
     * 收藏作品
     * @param userId 用户id
     * @param worksId 作品id
     * @return
     */
    boolean saveCollectWaorks(Integer userId, Integer worksId);

    /**
     * 点赞评论
     * @param userId 用户id
     * @param commentId 评论id
     * @return
     */
    boolean saveLikeComment(Integer userId, Integer commentId);
}
