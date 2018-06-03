package com.itacademy.service;

import com.itacademy.configServiceTest.ApplicationConfigurationServiceTest;
import com.itacademy.utill.TestDataDelete;
import com.itacademy.utill.TestDataImporter;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = ApplicationConfigurationServiceTest.class)
@Transactional
public class BaseServiceTest {

    @Autowired
    private TestDataDelete projectTestDataDelete;
    @Autowired
    private TestDataImporter projectTestDataImporter;

    @Before
    public void clean() {
        projectTestDataDelete.deleteTestData();
        projectTestDataImporter.importTestData();
    }
}
