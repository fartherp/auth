package cn.vansky.auth.service.impl.general;

import cn.vansky.auth.bo.general.AttachType;
import cn.vansky.auth.bo.general.Attachment;
import cn.vansky.auth.dto.attachment.AttachmentDto;
import cn.vansky.auth.service.general.AttachmentService;
import cn.vansky.auth.service.general.AttachmentStore;
import cn.vansky.framework.core.bean.ServiceLocator;
import cn.vansky.framework.core.file.FileStore;
import cn.vansky.framework.core.file.FileStoreConfig;
import com.google.common.base.Preconditions;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

/**
 * Created by IntelliJ IDEA.
 * Author: CK
 * Date: 2016/1/23
 */
@Service("attachmentStore")
public class DefaultAttachmentStoreImpl implements AttachmentStore {
    @Resource(name = "attachmentService")
    AttachmentService attachmentService;

    public String generateFilename(FileStore store, String rawName) {
        return store.generateFilename(rawName);
    }

    public Attachment saveStore(MultipartFile file, AttachType type, Long ucid) {
        FileStore store = ServiceLocator.getInstance().getBean(type.getBeanName());
        String dir = store.partitionDir(type.getTypeId());
        String name = generateFilename(store, file.getOriginalFilename());
        try {
            store.store(dir, file.getInputStream(), name);
        } catch (IOException e) {
            throw new RuntimeException("IOException." + name);
        }

        Attachment attach = new Attachment();
        Date date = new Date();
        attach.setAddTime(date);
        attach.setBusinessType(type.getTypeId());
        attach.setName(file.getOriginalFilename());
        attach.setAddUserId(ucid);
        attach.setFileName(name);
        attach.setPath(dir);
        attach.setFileType(StringUtils.substringAfterLast(file.getOriginalFilename(), "."));
        attachmentService.saveEntitySelective(attach);
        return attach;
    }

    public Attachment saveStore(InputStream in, String fileName, AttachType type, Long ucid) {
        FileStore store = ServiceLocator.getInstance().getBean(type.getBeanName());
        String dir = store.partitionDir(type.getTypeId());
        String name = generateFilename(store, fileName);
        store.store(dir, in, name);
        Attachment attach = new Attachment();
        Date date = new Date();
        attach.setAddTime(date);
        attach.setBusinessType(type.getTypeId());
        attach.setName(fileName);
        attach.setAddUserId(ucid);
        attach.setFileName(name);
        attach.setPath(dir);
        attach.setFileType(StringUtils.substringAfterLast(fileName, "."));
        attachmentService.saveEntitySelective(attach);
        return attach;
    }

    public void fetch(Attachment attach, Long ucid, OutputStream output) {
        Preconditions.checkNotNull(attach, "attachment file not found");
        AttachType type = AttachType.fromTypeId(attach.getBusinessType());
        FileStore store = ServiceLocator.getInstance().getBean(type.getBeanName());
        String dir = store.partitionDir(type.getTypeId());
        store.fetch(dir, attach.getFileName(), output);
    }

    public Collection<AttachmentDto> readAttachments(AttachType type, Long busId) {
        FileStore store = ServiceLocator.getInstance().getBean(type.getBeanName());
        Collection<AttachmentDto> attachments = attachmentService.readAttachments(type, busId);
        if (null == attachments || attachments.isEmpty()) {
            return new ArrayList<AttachmentDto>();
        }

        for (AttachmentDto file : attachments) {
            AttachmentConfig config = (AttachmentConfig) store.getFileStoreConfig();
            file.setUrl(String.format(config.getUrlTpl(), file.getId()));
        }
        return attachments;
    }

    @Override
    public void saveRelations(AttachType type, Long busId, Collection<Long> fileIds) {
        attachmentService.saveRelations(type, busId, fileIds);
    }

    @Override
    public FileStoreConfig getFileStoreConfig(AttachType type) {
        FileStore store = ServiceLocator.getInstance().getBean(type.getBeanName());
        return store.getFileStoreConfig();
    }

    @Override
    public Attachment getAttachment(Long id) {
        return attachmentService.findById(id);
    }
}
