package uk.gov.companieshouse.servicesdashboardapi.service.github;

import org.junit.jupiter.api.Test;

import uk.gov.companieshouse.servicesdashboardapi.model.github.GitCustomProperty;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GitServiceTest {

    @Test
    void shouldReturnRepoOwnerFromCustomProperties() {
        GitService gitService = new GitService();

        GitCustomProperty teamOwner = new GitCustomProperty();
        teamOwner.setPropertyName("team-code-owner");
        teamOwner.setValue("team-services");

        GitCustomProperty otherProperty = new GitCustomProperty();
        otherProperty.setPropertyName("service-area");
        otherProperty.setValue("platform");

        String owner = gitService.getRepoOwner(new GitCustomProperty[] {otherProperty, teamOwner});

        assertEquals("team-services", owner);
    }

    @Test
    void shouldReturnServiceAreaFromCustomProperties() {
        GitService gitService = new GitService();

        GitCustomProperty teamOwner = new GitCustomProperty();
        teamOwner.setPropertyName("team-code-owner");
        teamOwner.setValue("team-services");

        GitCustomProperty serviceArea = new GitCustomProperty();
        serviceArea.setPropertyName("service-area");
        serviceArea.setValue("platform");

        String area = gitService.getServiceArea(new GitCustomProperty[] {teamOwner, serviceArea});

        assertEquals("platform", area);
    }
}
