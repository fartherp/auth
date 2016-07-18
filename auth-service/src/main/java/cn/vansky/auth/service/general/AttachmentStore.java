package cn.vansky.auth.service.general;

import cn.vansky.auth.bo.general.AttachType;
import cn.vansky.auth.bo.general.Attachment;
import cn.vansky.auth.dto.attachment.AttachmentDto;
import cn.vansky.framework.core.file.FileStore;
import cn.vansky.framework.core.file.FileStoreConfig;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;
import java.io.OutputStream;
import java.util.Collection;

/**
 * Created by IntelliJ IDEA.
 * Author: CK
 * Date: 2016/1/23
 */
public interface AttachmentStore {
    /**
     * 自动生成文件名
     * @param rawName 文件名
     * @return new文件名
     */
    String generateFilename(FileStore store, String rawName);
    /**
     * 存储文件
     *
     * @param in 文件输入流
     * @param fileName 文件名
     * @param typeId the type id
     * @param ucid the ucid
     * @return 文件id
     */
    Attachment saveStore(InputStream in, String fileName, AttachType typeId, Long ucid);

    /**
     * 存储文件
     *
     * @param file 文件对象, 非null
     * @param type 附件类型id, 用于目录划分
     * @param ucid 当前用户ucid, 非null
     * @return 文件id
     */
    Attachment saveStore(MultipartFile file, AttachType type, Long ucid);

    /**
     * 读取文件
     *
     * @param attach 文件id
     * @param ucid 当前用户ucid, 用于可能的存取控制
     * @param output 输出流
     */
    void fetch(Attachment attach, Long ucid, OutputStream output);

    /**
     * 读取指定业务实体下挂的附件集合.
     *
     * 读取后的AttachFile对象中,包含该文件下载的url字段.
     *
     * @param type 业务类型
     * @param busId 业务实体
     * @return 附件集合
     */
    Collection<AttachmentDto> readAttachments(AttachType type, Long busId);

    /**
     * 批量保存附件与业务关系, 当前业务实体有多个附件对象.
     * @param type 业务类型
     * @param busId 业务实体
     * @param fileIds 文件id集合
     */
    void saveRelations(AttachType type, Long busId, Collection<Long> fileIds);

    /**
     * 附件配置
     * @return 附件配置
     */
    FileStoreConfig getFileStoreConfig(AttachType type);

    /**
     * 通过ID获取附件信息
     * @param id id
     * @return 附件信息
     */
    Attachment getAttachment(Long id);
}
