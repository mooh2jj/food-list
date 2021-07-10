package foodlist.demo.naver;

import foodlist.demo.naver.dto.SearchLocalReq;
import foodlist.demo.naver.dto.SearchLocalRes;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.server.reactive.HttpHandler;
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

    public SearchLocalRes localSearch(SearchLocalReq searchLocalReq) {
        var uri = UriComponentsBuilder.fromOriginHeader(naverLocalSearchUrl)
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

    public void imageSearch() {

    }
}
