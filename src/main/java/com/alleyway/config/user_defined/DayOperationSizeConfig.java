package com.alleyway.config.user_defined;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * describe: 用来读取配置文件中的数据
 *  每日每种操作可加经验的次数，比如登录操作，每天只能加一次经验，发评论等能多次
 *
 * @author: 洪
 */
@Component
public class DayOperationSizeConfig {

    // 登录
    @Value("${day.operation.login}")
    private int login;

    @Value("${day.operation.save_words}")
    private int saveWords;

    @Value("${day.operation.comment}")
    private int comment;

    @Value("${day.operation.look_video}")
    private int lookVideo;


    public int getLogin() {
        return login;
    }

    public void setLogin(int login) {
        this.login = login;
    }

    public int getSaveWords() {
        return saveWords;
    }

    public void setSaveWords(int saveWords) {
        this.saveWords = saveWords;
    }

    public int getComment() {
        return comment;
    }

    public void setComment(int comment) {
        this.comment = comment;
    }

    public int getLookVideo() {
        return lookVideo;
    }

    public void setLookVideo(int lookVideo) {
        this.lookVideo = lookVideo;
    }
}
