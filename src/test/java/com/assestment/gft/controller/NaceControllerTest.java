package com.assestment.gft.controller;

import com.assestment.gft.service.NaceService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(controllers = NaceController.class)
class NaceControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private NaceService naceService;

    @Test
    public void shouldProcessPutNaceDetailsCorrectly() throws Exception {
        // given
        ResultActions resultActions = mockMvc.perform(post("/v1/gft/putNaceDetails")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON));

        // then
        resultActions.andExpect(status().isOk());
    }

    @Test
    public void shouldProcessGettNaceDetailsCorrectly() throws Exception {
        // given
        ResultActions resultActions = mockMvc.perform(get("/v1/gft/getNaceDetails")
                .contentType(MediaType.APPLICATION_JSON)
                .queryParam("order", "1234")
                .accept(MediaType.APPLICATION_JSON));

        // then
        resultActions.andExpect(status().isOk());
    }

}