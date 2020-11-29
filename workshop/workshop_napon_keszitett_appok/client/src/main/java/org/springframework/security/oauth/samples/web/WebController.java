package org.springframework.security.oauth.samples.web;

import hu.webvalto.domain.CegDTO;
import hu.webvalto.domain.MaganemberDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
public class WebController {

    private Logger logger = LoggerFactory.getLogger(WebController.class);

    @Value("${resource-server.base-uri}")
    private String bevallasLekerdekezeUrl;

    @Autowired
    private RestTemplate securedRestTemplate;

    @GetMapping("/maganember")
    public List<MaganemberDTO> maganember() {

        logger.info("Meghivasra kerult maganember");
        return securedRestTemplate.getForObject(bevallasLekerdekezeUrl + "/maganember", List.class);
    }

    @GetMapping("/ceg")
    public List<CegDTO> ceg() {
        logger.info("Meghivasra kerult maganember");
        return securedRestTemplate.getForObject(bevallasLekerdekezeUrl + "/ceg", List.class);
    }
}
