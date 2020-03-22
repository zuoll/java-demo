package com.zll.demo.mockmvc;

import com.zll.demo.App;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

/**
 * springmvc 的单元测试mockMVC
 * <a>https://blog.csdn.net/kqZhu/article/details/78836275</a>
 * <a>https://blog.csdn.net/Adam_allen/article/details/79919921</a>
 */
@ExtendWith(SpringExtension.class)//集成junit5
@SpringBootTest(classes = App.class)
@WebAppConfiguration//springMVC配置
@DisplayName("mockmvc-test")
public class Test001 {

    private MockMvc mockMvc;

    @Autowired
    private WebApplicationContext wac;


    @BeforeEach
    void setUp() {
        System.out.println("初始化mockmvc........");
        mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
    }

    @Test
    void test001() throws Exception {
        System.out.println(wac);

        String contentAsString = mockMvc.perform
                (

                        MockMvcRequestBuilders.post("http://localhost:9090/say")
                                .contentType(MediaType.APPLICATION_FORM_URLENCODED_VALUE)
                                .param("name", "wangnima")
                )
                .andExpect(MockMvcResultMatchers.status().isOk())//200
                .andDo(MockMvcResultHandlers.print())//打印结果
                .andReturn().getResponse().getContentAsString();//将结果转化为字符串

        System.out.println(contentAsString);
    }


}
