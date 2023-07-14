package com.github.jsjchai.springboot.demo.controller;

import com.github.jsjchai.springboot.demo.model.User;
import com.github.jsjchai.springboot.demo.service.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.List;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(MockitoExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
class UserControllerTest {

    @Mock
    private UserService userService;

    @InjectMocks
    private UserController userController;

    private MockMvc mockMvc;

    @BeforeEach
    void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(userController).build();
    }

    @Test
    void testGetAllUsers() throws Exception {
        User user = new User();
        user.setId(10000L);
        user.setUsername("test001");
        user.setEmail("test@163.com");

        when(userService.findAll()).thenReturn(List.of(user));

        this.mockMvc.perform(RestDocumentationRequestBuilders.get("/user/getAllUsers"))
                .andExpect(status().isOk())
                .andExpect(content().json("[{'id': 10000, 'username': 'test001', 'email': 'test@163.com'}]"));;

        verify(userService, times(1)).findAll();
    }


}