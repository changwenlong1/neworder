package com.example.order.service;

import org.springframework.web.bind.annotation.RequestParam;

/**
 * 内容展示service
 */
public interface ExhibitionService {

    /**
     * 新增富文本
     * @param content
     * @param sort
     * @return
     */
    boolean addRich(String content, Integer sort);


}
