package uk.gov.companieshouse.servicesdashboardapi.model.github;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

class GitInfoTest {

    @Test
    void shouldSetAndGetBasicFields() {
        GitInfo gitInfo = new GitInfo();

        gitInfo.setRepo("https://github.com/companieshouse/services-dashboard-api");
        gitInfo.setLang("Java");
        gitInfo.setOwner("team-photon");
        gitInfo.setServiceArea("Common Components");

        assertEquals("https://github.com/companieshouse/services-dashboard-api", gitInfo.getRepo());
        assertEquals("Java", gitInfo.getLang());
        assertEquals("team-photon", gitInfo.getOwner());
        assertEquals("Common Components", gitInfo.getServiceArea());
    }

    @Test
    void shouldSetAndGetReleases() {
        GitInfo gitInfo = new GitInfo();

        GitReleaseInfo release = new GitReleaseInfo();
        release.setVersion("1.0.0");
        release.setDate("2026-01-01");

        List<GitReleaseInfo> releases = new ArrayList<>();
        releases.add(release);

        gitInfo.setReleases(releases);

        assertNotNull(gitInfo.getReleases());
        assertEquals(1, gitInfo.getReleases().size());
        assertEquals("1.0.0", gitInfo.getReleases().get(0).getVersion());
        assertEquals("2026-01-01", gitInfo.getReleases().get(0).getDate());
    }

    @Test
    void shouldSetEmptyReleasesList() {
        GitInfo gitInfo = new GitInfo();

        gitInfo.setReleases(new ArrayList<>());

        assertNotNull(gitInfo.getReleases());
        assertTrue(gitInfo.getReleases().isEmpty());
    }
}
