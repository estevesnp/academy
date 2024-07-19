package com.ctw.workstation.team.boundary;

import com.ctw.workstation.CommonProfile;
import com.ctw.workstation.entity.DefaultLocation;
import com.ctw.workstation.team.entity.Team;
import com.ctw.workstation.team.entity.TeamDTO;
import com.ctw.workstation.team.entity.TeamMapper;
import io.quarkus.test.common.http.TestHTTPEndpoint;
import io.quarkus.test.junit.QuarkusTest;
import io.quarkus.test.junit.TestProfile;
import io.restassured.common.mapper.TypeRef;
import io.restassured.http.ContentType;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.UUID;

import static io.restassured.RestAssured.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.equalTo;

@QuarkusTest
@TestProfile(CommonProfile.class)
@TestHTTPEndpoint(TeamResource.class)
class TeamResourceTest {

    @Test
    void teamGetTeams() {
        List<TeamDTO> expected = buildTeams().stream().map(TeamMapper::domainToDTO).toList();

        List<TeamDTO> response = get().then()
                .statusCode(200)
                .extract()
                .as(new TypeRef<>() {
                });

        assertThat(response)
                .usingRecursiveFieldByFieldElementComparatorIgnoringFields("id")
                .hasSameElementsAs(expected);
    }

    @Test
    void teamGetById() {


        String name = "my-team";
        String product = "my-product";
        DefaultLocation location = DefaultLocation.LISBON;
        Team team = buildTeam(null, name, product, location);
        UUID id = postTeam(team);

        get("/" + id).then()
                .statusCode(200)
                .assertThat()
                .body("id", equalTo(id.toString())).and()
                .body("name", equalTo(name)).and()
                .body("product", equalTo(product)).and()
                .body("default_location", equalTo(location.toString()));
    }

    @Test
    void teamGetByIdEmpty() {
        clean();
        get("/" + UUID.randomUUID()).then()
                .statusCode(404);
    }

    @Test
    void teamPostTeam() {
        String name = "my-team";
        String product = "my-product";
        DefaultLocation location = DefaultLocation.LISBON;
        TeamDTO dto = new TeamDTO(null, name, product, DefaultLocation.LISBON);

        given().contentType(ContentType.JSON)
                .body(dto)
                .post()
                .then()
                .statusCode(201)
                .assertThat()
                .body("name", equalTo(name)).and()
                .body("product", equalTo(product)).and()
                .body("default_location", equalTo(location.toString()));
    }

    @Test
    void teamUpdateTeam() {
        Team team = buildTeam(null, "my-team", "my-product", DefaultLocation.LISBON);
        UUID id = postTeam(team);
        String name = "new-team";
        String product = "new-product";
        DefaultLocation location = DefaultLocation.PORTO;

        TeamDTO dto = new TeamDTO(id, name, product, location);

        given().contentType(ContentType.JSON)
                .body(dto)
                .put("/" + id)
                .then()
                .statusCode(201)
                .assertThat()
                .body("id", equalTo(id.toString())).and()
                .body("name", equalTo(name)).and()
                .body("product", equalTo(product)).and()
                .body("default_location", equalTo(location.toString()));
    }

    @Test
    void teamDeleteTeam() {
        String name = "my-team";
        String product = "my-product";
        DefaultLocation location = DefaultLocation.LISBON;
        Team team = buildTeam(null, name, product, location);
        UUID id = postTeam(team);

        delete("/" + id)
                .then()
                .statusCode(200);

        get("/" + id)
                .then()
                .statusCode(404);
    }

    @BeforeEach
    void beforeEach() {
        clean();
        setup();
    }

    @Transactional
    void clean() {
        Team.deleteAll();
    }

    @Transactional
    void setup() {
        buildTeamsNull().forEach(team -> Team.persist(team));
    }

    @Transactional
    UUID postTeam(Team team) {
        Team.persist(team);
        return team.getId();
    }

    private static List<Team> buildTeamsNull() {
        return List.of(
                buildTeam(null, "team-1", "product-1", DefaultLocation.LISBON),
                buildTeam(null, "team-2", "product-2", DefaultLocation.PORTO),
                buildTeam(null, "team-3", "product-3", DefaultLocation.BRAGA),
                buildTeam(null, "team-4", "product-4", DefaultLocation.PORTO),
                buildTeam(null, "team-5", "product-5", DefaultLocation.LISBON)
        );
    }

    private static List<Team> buildTeams() {
        return List.of(
                buildTeam(UUID.fromString("3cb55fca-28cc-4fd9-a2d2-ec270fd31e5d"),
                        "team-1", "product-1", DefaultLocation.LISBON),
                buildTeam(UUID.fromString("75ff681b-b12c-4c0d-96f6-19b80313ab3f"),
                        "team-2", "product-2", DefaultLocation.PORTO),
                buildTeam(UUID.fromString("9d2cd8f3-d34c-4a99-a3fa-33edd016bb0a"),
                        "team-3", "product-3", DefaultLocation.BRAGA),
                buildTeam(UUID.fromString("2d45a567-2767-4a40-9120-8f3aa4f5b2cf"),
                        "team-4", "product-4", DefaultLocation.PORTO),
                buildTeam(UUID.fromString("a6d131e1-9c2b-4483-9fcc-14415ccdb3c8"),
                        "team-5", "product-5", DefaultLocation.LISBON)
        );
    }

    private static List<TeamDTO> buildTeamDTOs() {
        return List.of(
                new TeamDTO(UUID.fromString("3cb55fca-28cc-4fd9-a2d2-ec270fd31e5d"),
                        "team-1", "product-1", DefaultLocation.LISBON),
                new TeamDTO(UUID.fromString("75ff681b-b12c-4c0d-96f6-19b80313ab3f"),
                        "team-2", "product-2", DefaultLocation.PORTO),
                new TeamDTO(UUID.fromString("9d2cd8f3-d34c-4a99-a3fa-33edd016bb0a"),
                        "team-3", "product-3", DefaultLocation.BRAGA),
                new TeamDTO(UUID.fromString("2d45a567-2767-4a40-9120-8f3aa4f5b2cf"),
                        "team-4", "product-4", DefaultLocation.PORTO),
                new TeamDTO(UUID.fromString("a6d131e1-9c2b-4483-9fcc-14415ccdb3c8"),
                        "team-5", "product-5", DefaultLocation.LISBON)
        );
    }

    private static Team buildTeam(UUID id, String name, String product, DefaultLocation defaultLocation) {
        Team team = new Team();

        team.setId(id);
        team.setName(name);
        team.setProduct(product);
        team.setDefaultLocation(defaultLocation);

        return team;
    }
}