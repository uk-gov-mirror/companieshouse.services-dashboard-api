package uk.gov.companieshouse.servicesdashboardapi.model.dao;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;

class MongoGitInfoTest {
    @Test
    void shouldCreateMongoGitInfoWithValues() {
        MongoGitInfo mongoGitInfo = new MongoGitInfo();
        mongoGitInfo.setRepo("repo");
        mongoGitInfo.setLang("lang");
        mongoGitInfo.setOwner("owner");
        mongoGitInfo.setServiceArea("serviceArea");

        assertNotNull(mongoGitInfo);
        assertEquals("repo", mongoGitInfo.getRepo());
        assertEquals("lang", mongoGitInfo.getLang());
        assertEquals("owner", mongoGitInfo.getOwner());
        assertEquals("serviceArea", mongoGitInfo.getServiceArea());
    }
}
