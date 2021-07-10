package foodlist.demo.naver;

import foodlist.demo.naver.dto.SearchImageReq;
import foodlist.demo.naver.dto.SearchImageRes;
import foodlist.demo.naver.dto.SearchLocalReq;
import foodlist.demo.naver.dto.SearchLocalRes;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

@Component
public class NaverClient {

    @Value("${naver.client.id}")
    private String naverClientId;

    @Value("${naver.client.secret}")
    private String naverClientSecret;

    @Value("${naver.url.search.local}")
    private String naverLocalSearchUrl;

    @Value("${naver.url.search.image}")
    private String naverImageSearchUrl;

    public SearchLocalRes searchLocal(SearchLocalReq searchLocalReq) {
        var uri = UriComponentsBuilder.fromUriString(naverLocalSearchUrl)
                .queryParams(searchLocalReq.toMultiValueMap())
                .build()
                .encode()
                .toUri();

        var hearders = new HttpHeaders();
        hearders.set("X-Naver-Client-Id", naverClientId);
        hearders.set("X-Naver-Client-Secret", naverClientSecret);
        hearders.setContentType(MediaType.APPLICATION_JSON);

        var httpEntitry = new HttpEntity<>(hearders);
        var responseType = new ParameterizedTypeReference<SearchLocalRes>(){};

        var responseEntity = new RestTemplate().exchange(
                uri,
                HttpMethod.GET,
                httpEntitry,
                responseType
        );

        return responseEntity.getBody();
    }

    public SearchImageRes searchImage(SearchImageReq searchImageReq) {
        var uri = UriComponentsBuilder.fromUriString(naverImageSearchUrl)
                .queryParams(searchImageReq.toMultiValueMap())
                .build()
                .encode()
                .toUri();

        var hearders = new HttpHeaders();
        hearders.set("X-Naver-Client-Id", naverClientId);
        hearders.set("X-Naver-Client-Secret", naverClientSecret);
        hearders.setContentType(MediaType.APPLICATION_JSON);

        var httpEntitry = new HttpEntity<>(hearders);
        var responseType = new ParameterizedTypeReference<SearchImageRes>(){};

        var responseEntity = new RestTemplate().exchange(
                uri,
                HttpMethod.GET,
                httpEntitry,
                responseType
        );

        return responseEntity.getBody();
    }
}
