/*
 * Copyright (C) 2016 CK, Inc. All Rights Reserved.
 */

package cn.vansky.auth.service.impl.general;

import cn.vansky.auth.bo.general.AttachType;
import cn.vansky.auth.service.general.AttachmentService;
import cn.vansky.auth.service.general.AttachmentStore;
import cn.vansky.framework.core.bean.ServiceLocator;
import cn.vansky.framework.core.file.FileStoreConfig;
import cn.vansky.framework.core.util.SpringUtils;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

@ContextConfiguration(locations = { "classpath:/conf/applicationContext-test.xml" }, inheritLocations = false)
@TransactionConfiguration(transactionManager = "transactionManager")
public class DefaultAttachmentStoreImplTest extends AbstractTestNGSpringContextTests {

    @InjectMocks
    AttachmentStore attachmentStore;

    @Mock
    AttachmentService attachmentService;

    @BeforeClass(alwaysRun = true)
    public void initMocks() {
        attachmentStore = new DefaultAttachmentStoreImpl();
        MockitoAnnotations.initMocks(this);
        ServiceLocator.getInstance().setFactory(SpringUtils.getApplicationContext());
    }

    @Test
    public void testGenerateFilename() throws Exception {

    }

    @Test
    public void testSaveStore() throws Exception {

    }

    @Test
    public void testSaveStore1() throws Exception {

    }

    @Test
    public void testFetch() throws Exception {

    }

    @Test
    public void testReadAttachs() throws Exception {

    }

    @Test
    public void testSaveRelations() throws Exception {

    }

    @Test
    public void testGetAttachmentConfig() throws Exception {
        FileStoreConfig attachmentConfig = attachmentStore.getFileStoreConfig(AttachType.TEST);
        Assert.assertNotNull(attachmentConfig);
    }

    @Test
    public void testGetAttachment() throws Exception {

    }
}