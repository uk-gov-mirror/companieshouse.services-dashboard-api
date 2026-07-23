package uk.gov.companieshouse.servicesdashboardapi.model.github;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertSame;
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
        assertEquals("{r:https://github.com/companieshouse/services-dashboard-api l:Java o:team-photon sA:Common Components [R:unknown]}", gitInfo.toString());
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

    @Test
    void shouldKeepFirstReleaseAndFirstDifferentReleaseCycle() {
        GitInfo gitInfo = new GitInfo();

        GitReleaseInfo first = new GitReleaseInfo();
        first.setVersion("ecs-service-1.0.22");
        first.setDate("2026-01-22");

        GitReleaseInfo sameCycleOne = new GitReleaseInfo();
        sameCycleOne.setVersion("ecs-service-1.0.21");
        sameCycleOne.setDate("2026-01-21");

        GitReleaseInfo sameCycleTwo = new GitReleaseInfo();
        sameCycleTwo.setVersion("ecs-service-1.0.20");
        sameCycleTwo.setDate("2026-01-20");

        GitReleaseInfo differentCycle = new GitReleaseInfo();
        differentCycle.setVersion("4.0.11");
        differentCycle.setDate("2025-12-11");

        List<GitReleaseInfo> releases = new ArrayList<>();
        releases.add(first);
        releases.add(sameCycleOne);
        releases.add(sameCycleTwo);
        releases.add(differentCycle);

        gitInfo.setReleases(releases);

        assertNotNull(gitInfo.getReleases());
        assertEquals(2, gitInfo.getReleases().size());
        assertEquals("ecs-service-1.0.22", gitInfo.getReleases().get(0).getVersion());
        assertEquals("4.0.11", gitInfo.getReleases().get(1).getVersion());
    }

    @Test
    void shouldAddFirstNonMatchingReleaseToFilteredList() {
        GitInfo gitInfo = new GitInfo();

        GitReleaseInfo first = new GitReleaseInfo();
        first.setVersion("1.2.3");
        first.setDate("2026-01-23");

        GitReleaseInfo nonMatching = new GitReleaseInfo();
        nonMatching.setVersion("release-1.2.3");
        nonMatching.setDate("2026-01-22");

        List<GitReleaseInfo> releases = new ArrayList<>();
        releases.add(first);
        releases.add(nonMatching);

        gitInfo.setReleases(releases);

        assertEquals(2, gitInfo.getReleases().size());
        assertSame(first, gitInfo.getReleases().get(0));
        assertSame(nonMatching, gitInfo.getReleases().get(1));
    }

    @Test
    void shouldOnlyAddOneIfAllMatchingVersions() {
        GitInfo gitInfo = new GitInfo();

        GitReleaseInfo first = new GitReleaseInfo();
        first.setVersion("1.2.3");
        first.setDate("2026-01-23");

        GitReleaseInfo matching = new GitReleaseInfo();
        matching.setVersion("1.2.3");
        matching.setDate("2026-01-22");

        List<GitReleaseInfo> releases = new ArrayList<>();
        releases.add(first);
        releases.add(matching);

        gitInfo.setReleases(releases);

        assertEquals(1, gitInfo.getReleases().size());
        assertSame(first, gitInfo.getReleases().get(0));
    }

    @Test
    void shouldHandleAlphabeticReleasePatternWhenFiltering() {
        GitInfo gitInfo = new GitInfo();

        GitReleaseInfo first = new GitReleaseInfo();
        first.setVersion("abc");
        first.setDate("2026-01-23");

        GitReleaseInfo matchingAlphabetic = new GitReleaseInfo();
        matchingAlphabetic.setVersion("xyz");
        matchingAlphabetic.setDate("2026-01-22");

        GitReleaseInfo differentPattern = new GitReleaseInfo();
        differentPattern.setVersion("123");
        differentPattern.setDate("2026-01-21");

        List<GitReleaseInfo> releases = new ArrayList<>();
        releases.add(first);
        releases.add(matchingAlphabetic);
        releases.add(differentPattern);

        gitInfo.setReleases(releases);

        assertEquals(2, gitInfo.getReleases().size());
        assertSame(first, gitInfo.getReleases().get(0));
        assertSame(differentPattern, gitInfo.getReleases().get(1));
    }
}
