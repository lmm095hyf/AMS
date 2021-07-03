package com.yc.ams.controller;

import com.yc.ams.config.SystemVariable;
import com.yc.ams.db.dao.NewsinfoDao;
import com.yc.ams.db.dao.TevalutaDao;
import com.yc.ams.db.pojo.Newsinfo;
import com.yc.ams.db.pojo.Tevaluta;
import com.yc.ams.utils.ResultResponse;
import com.yc.ams.utils.ResultTypeEnum;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @program: AMS
 * @description:
 * @author: 作者 :林木木
 * @create: 2021-06-04 21:08
 */
@RestController
@RequestMapping("news")
public class newsController {


    @Resource
    NewsinfoDao newsinfoDao;

    //增加教评问题
    @RequestMapping("add")
    public ResultResponse addMajor(Newsinfo newsinfo) {
        newsinfoDao.insert(newsinfo);
        System.out.println(newsinfo);
        return ResultResponse.Build(ResultTypeEnum.success, SystemVariable.DO_SUCCESS);
    }

    @RequestMapping("/show")
    public Map<String, Object> showtable() {
        Map<String, Object> so = new HashMap<String, Object>();
        List<Newsinfo> ls = newsinfoDao.selectAll();
        so.put("code", SystemVariable.URL_SUCCESS);
        so.put("msg", "");
        so.put("count", ls.size());
        so.put("data", ls);
        return so;
    }

    @ResponseBody
    @RequestMapping("/img")
    public Map<String, Object> uploadImgQiniu(@RequestParam("files") MultipartFile file) throws IOException {
        Map<String, Object> map = new HashMap<String, Object>();
        if (!file.isEmpty()) {

            String path = ResourceUtils.getURL("classpath:").getPath() + "static/upload";
            String realPath = path.replace('/', '\\').substring(1, path.length());
            //用于查看路径是否正确
            System.out.println(realPath);
            //获取文件的名称
            final String fileName = file.getOriginalFilename();

            //限制文件上传的类型
            String contentType = file.getContentType();
            if ("image/jpeg".equals(contentType) || "image/jpg".equals(contentType)) {
                File file2 = new File(realPath, fileName);

                //完成文件的上传
                file.transferTo(file2);
                System.out.println("图片上传成功!");
                String path01 = "../upload/" + fileName;
                map.put("filename", "/upload/" + file.getOriginalFilename());

                return map;
            } else {
                System.out.println("上传失败！");
                //mv.setViewName("upload");
                return map;
            }

        } else {
            System.out.println("上传失败！");
//            //mv.setViewName("upload");
            return map;
        }
    }

 //       return map;
//    }

}
