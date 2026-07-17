package uk.gov.companieshouse.servicesdashboardapi.model.dao;

import org.junit.jupiter.api.Test;

import uk.gov.companieshouse.servicesdashboardapi.mapper.ProjectInfoMapper;
import uk.gov.companieshouse.servicesdashboardapi.model.deptrack.DepTrackMetricsInfo;
import uk.gov.companieshouse.servicesdashboardapi.utils.CustomJsonMapper;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class MongoMetricsInfoTest {
    @Test
    void shouldMapDepTrackMetricsInfoIntoMongoMetrics() throws Exception {
        String json = """
            {
                "critical": 1,
                "high": 2,
                "medium": 3,
                "low": 4,
                "vulnerabilities": 10,
                "components": 20,
                "policyViolationsTotal": 30,
                "policyViolationsWarn": 40,
                "policyViolationsFail": 50
            }
            """;

        CustomJsonMapper mapper = new CustomJsonMapper();
        DepTrackMetricsInfo depTrack =
            mapper.readValue(json, DepTrackMetricsInfo.class);

        MongoMetricsInfo mongoMetrics =
            ProjectInfoMapper.INSTANCE.mapDepTrackMetricsInfoToMongoMetricsInfo(depTrack);

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
