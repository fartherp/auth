package cn.vansky.auth.controller.general;

import cn.vansky.auth.bo.general.AttachType;
import cn.vansky.auth.bo.general.Attachment;
import cn.vansky.auth.service.impl.general.AttachmentConfig;
import cn.vansky.auth.service.general.AttachmentStore;
import cn.vansky.framework.common.util.WebUtils;
import cn.vansky.framework.core.util.JsonResp;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang.math.NumberUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.OutputStream;

/**
 * Created by IntelliJ IDEA.
 * Author: CK
 * Date: 2016/1/23
 */
@Controller
@RequestMapping(value = "/attach")
public class AttachController {
    @Resource(name = "attachmentStore")
    AttachmentStore attachStore;

    @RequestMapping("/upload")
    @ResponseBody
    public String upload(@RequestParam("typeId") int typeId, @RequestParam("Filedata") MultipartFile file) {
        AttachType type = AttachType.fromTypeId(typeId);
        if (type == null) {
            return JsonResp.asEmpty().error("非法的附件类型").toJson();
        }
        Attachment attach = attachStore.saveStore(file, type, 0L);
        AttachmentConfig config = (AttachmentConfig) attachStore.getFileStoreConfig(type);
        return JsonResp.asData().add("fileId", attach.getId())
                .add("url", String.format(config.getUrlTpl(), attach.getId())).toJson();
    }

    @RequestMapping("/file")
    public void file(@RequestParam("key") String key, HttpServletRequest req, HttpServletResponse resp) {
        OutputStream output = null;
        try {
            output = resp.getOutputStream();
            long fid = NumberUtils.toLong(key);
            Attachment attach = attachStore.getAttachment(fid);
            String contentType = WebUtils.guessContentType(attach.getName());
            if (contentType == null) {
                contentType = "application/octet-stream";
            }
            resp.setContentType(contentType);
            String contentDisposition = WebUtils.encodeContentDisposition(req.getHeader("User-Agent"), attach.getName());
            resp.setHeader("Content-Disposition", contentDisposition);
            resp.setCharacterEncoding("utf-8");
            attachStore.fetch(attach, 0L, output);
        } catch (Exception e) {
        } finally {
            IOUtils.closeQuietly(output);
        }
    }
}
