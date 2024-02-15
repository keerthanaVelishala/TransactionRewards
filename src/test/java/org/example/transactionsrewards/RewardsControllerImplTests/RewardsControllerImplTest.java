package org.example.transactionsrewards.RewardsControllerImplTests;

import org.example.transactionsrewards.RewardsService.RewardsService;
import org.example.transactionsrewards.rewardscontroller.RewardsControllerImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import java.util.HashMap;

import static org.mockito.Mockito.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

/**
 * The type Rewards controller impl test.
 */
@ExtendWith(SpringExtension.class)
public class RewardsControllerImplTest {

    private MockMvc mockMvc;

    @Mock
    private RewardsService rewardsService;

    @InjectMocks
    private RewardsControllerImpl rewardsController;

    /**
     * Sets .
     */
    @BeforeEach
    public void setup() {
        mockMvc = standaloneSetup(rewardsController).build();
    }

    /**
     * Total rewards should return status ok.
     *
     * @throws Exception the exception
     */
    @Test
    public void totalRewardsShouldReturnStatusOk() throws Exception {

        when(rewardsService.findTotalPointsByCustomerAndMonth(any())).thenReturn(new HashMap<>());

        mockMvc.perform(get("/calculaterewards/rewards/summary/monthly"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON));
    }

}
