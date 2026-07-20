package uk.gov.companieshouse.servicesdashboardapi.model.dao;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class MongoMetricsInfoTest {
    @Test
    void shouldCreateMongoMetricsInfoWithValues() {
        MongoMetricsInfo mongoMetrics = new MongoMetricsInfo();
        mongoMetrics.setCritical(1);
        mongoMetrics.setHigh(2);
        mongoMetrics.setMedium(3);
        mongoMetrics.setLow(4);
        mongoMetrics.setVulnerabilities(10);
        mongoMetrics.setComponents(20);
        mongoMetrics.setPolicyViolationsTotal(30);
        mongoMetrics.setPolicyViolationsWarn(40);
        mongoMetrics.setPolicyViolationsFail(50);

        assertNotNull(mongoMetrics);
        assertEquals(1, mongoMetrics.getCritical());
        assertEquals(2, mongoMetrics.getHigh());
        assertEquals(3, mongoMetrics.getMedium());
        assertEquals(4, mongoMetrics.getLow());
        assertEquals(10, mongoMetrics.getVulnerabilities());
        assertEquals(20, mongoMetrics.getComponents());
        assertEquals(30, mongoMetrics.getPolicyViolationsTotal());
        assertEquals(40, mongoMetrics.getPolicyViolationsWarn());
        assertEquals(50, mongoMetrics.getPolicyViolationsFail());
    }
}
