package springboot.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by sunlele
 * Date 2019/2/24 15:37
 * Description
 */

@Controller
@Slf4j //取代private  static final Logger logger = LoggerFactory.getLogger(getClass());
@RequestMapping("/uploads")
public class FileUploadController {

    @GetMapping
    public String index(){
        return "index";
    }

    /**
     * 单个文件上传
     * @param file
     * @return
     * @throws IOException
     */
    @PostMapping("upload1")
    @ResponseBody
    public Map<String,String> upload1(@RequestParam("file") MultipartFile file) throws IOException {
        log.info("[文件类型] - [{}] ",file.getContentType());
        log.info("[文件类型] - [{}] ",file.getOriginalFilename());
        log.info("[文件类型] - [{}] ",file.getSize());
        //将文件写入到指定目录中
        file.transferTo(new File("C:\\Users\\Administrator\\Desktop\\temp\\" + file.getOriginalFilename()));
        Map<String,String> result = new HashMap<>(16);
        result.put("contentType",file.getContentType());
        result.put("fileName",file.getOriginalFilename());
        result.put("size",file.getSize() + "");
        return result;
    }

    /**
     * 多个文件上传
     * @param files
     * @return
     * @throws IOException
     */
    @PostMapping("/upload2")
    @ResponseBody
    public List<Map<String,String>> upload2(@RequestParam("files") MultipartFile[] files) throws IOException {
        if(files == null || files.length == 0){
           return null;
        }
        List<Map<String,String>> results = new ArrayList<>();
        for (MultipartFile file : files){
            file.transferTo(new File("C:\\Users\\Administrator\\Desktop\\temp\\" + file.getOriginalFilename()));
            Map<String,String> map = new HashMap<>(16);
            map.put("contentType",file.getContentType());
            map.put("fileName",file.getOriginalFilename());
            map.put("size",file.getSize() + "");
            results.add(map);
        }
        return results;
    }

}
