package com.example.managerweb.controller;


import com.alibaba.dubbo.config.annotation.Reference;
import com.example.managerweb.util.FastDfsUtil;
import com.github.pagehelper.PageInfo;
import com.team.entity.TbContent;
import com.team.service.TbContentService;
import com.team.util.PageUtil;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.HashMap;
import java.util.Map;

@RestController
public class TbContentController {
    @Reference(interfaceClass = TbContentService.class)
    private TbContentService tbContentService;

    @Value("${FastDfs_nginx_server_address}")
    private String FastDfs_nginx_server_address;

    @RequestMapping("/showContent")
    public Map<String,Object> showContent(PageUtil pageUtil){
        PageInfo<TbContent> tbContent = tbContentService.getTbContent(pageUtil);
        Map<String,Object> map =  new HashMap<>();
        map.put("rows",tbContent.getList());
        map.put("total",tbContent.getTotal());
        return map;
    }

    @RequestMapping("/addContent")
    public String addContent(TbContent tbContent,
                             @RequestParam(value = "file",required = false)MultipartFile file){
        try {
            String fileName = file.getOriginalFilename();
            String extName = fileName.substring(fileName.lastIndexOf(".")+1);
            String[] pngs = FastDfsUtil.updata(file.getBytes(),extName);
            String savePath="http://"+FastDfs_nginx_server_address+"/"+pngs[0]+"/"+pngs[1];
            tbContent.setPic(savePath);
            tbContentService.addTbContent(tbContent);
            return "{\"result\":1}";
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "{\"result\":-1}";
    }
}
