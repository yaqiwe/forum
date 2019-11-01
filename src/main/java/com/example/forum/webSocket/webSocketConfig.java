package com.example.forum.webSocket;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.server.standard.ServerEndpointExporter;

/**
 * @author ：yaqiwe
 * @date ：Created in 2019/10/30 16:14
 * @description：webSocket配置
 */
@Configuration
public class webSocketConfig{
    @Bean
    public ServerEndpointExporter serverEndpointExporter () {
        return new ServerEndpointExporter();
    }
}
