package com.prasad.pacemaker.service;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

@Service
public class MuxService {

    @Value("${mux.token.id}")
    private String muxTokenId;

    @Value("${mux.token.secret}")
    private String muxTokenSecret;

    public Map<String, String> createUploadUrl() {

        String url = "https://api.mux.com/video/v1/uploads";

        RestTemplate restTemplate = new RestTemplate();

        HttpHeaders headers = new HttpHeaders();

        String auth = muxTokenId + ":" + muxTokenSecret;

        String encodedAuth = Base64.getEncoder()
                .encodeToString(auth.getBytes(StandardCharsets.UTF_8));

        headers.set("Authorization", "Basic " + encodedAuth);
        headers.setContentType(MediaType.APPLICATION_JSON);

        JSONObject body = new JSONObject();
        body.put("new_asset_settings", new JSONObject());
        body.put("cors_origin", "*");

        HttpEntity<String> request =
                new HttpEntity<>(body.toString(), headers);

        ResponseEntity<String> response = restTemplate.exchange(
                url,
                HttpMethod.POST,
                request,
                String.class
        );

        JSONObject jsonResponse = new JSONObject(response.getBody());

        String uploadUrl = jsonResponse
                .getJSONObject("data")
                .getString("url");

        Map<String, String> result = new HashMap<>();

        result.put("uploadUrl", uploadUrl);

        return result;
    }
}