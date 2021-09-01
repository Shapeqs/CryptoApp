package com.exemple.CryptoApp.Repository.Crypto;

import com.exemple.CryptoApp.DTO.CryptoDTO;
import com.exemple.CryptoApp.Model.Crypto;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.HttpEntity;
import org.apache.http.HttpHeaders;
import org.apache.http.NameValuePair;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

@Repository
public class CryptoRepositoryImpl implements CryptoRepository {

    private Logger LOGGER = LoggerFactory.getLogger(CryptoRepositoryImpl.class);
    private ObjectMapper mapper = new ObjectMapper();

    private static String apiKey = "d8c0733a-cc05-4408-8fe6-d821ecb8ead6";
    private static String uri = "https://pro-api.coinmarketcap.com/v1/cryptocurrency/listings/latest";

    @Override
    public List<CryptoDTO> findAll() {
        List<CryptoDTO> cryptoList = new ArrayList<>();
        List<NameValuePair> paratmers = new ArrayList<NameValuePair>();
        paratmers.add(new BasicNameValuePair("start", "1"));
        paratmers.add(new BasicNameValuePair("limit", "5000"));
        paratmers.add(new BasicNameValuePair("convert", "USD"));

        try {
            String result = makeAPICall(uri, paratmers);
            System.out.println(result);
            File myObj = new File("allData.json");
            FileWriter myWriter = new FileWriter("allData.json");
            myWriter.write(result);
            myWriter.close();
        } catch (IOException e) {
            System.out.println("Error: cannont access content - " + e.toString());
        } catch (URISyntaxException e) {
            System.out.println("Error: Invalid URL " + e.toString());
        }

        return cryptoList;
    }

    public static String makeAPICall(String uri, List<NameValuePair> parameters)
            throws URISyntaxException, IOException {
        String response_content = "";

        URIBuilder query = new URIBuilder(uri);
        query.addParameters(parameters);

        CloseableHttpClient client = HttpClients.createDefault();
        HttpGet request = new HttpGet(query.build());

        request.setHeader(HttpHeaders.ACCEPT, "application/json");
        request.addHeader("X-CMC_PRO_API_KEY", apiKey);

        CloseableHttpResponse response = client.execute(request);

        try {
            System.out.println(response.getStatusLine());
            HttpEntity entity = response.getEntity();
            response_content = EntityUtils.toString(entity);
            EntityUtils.consume(entity);
        } finally {
            response.close();
        }

        return response_content;
    }

    @Override
    public CryptoDTO findById(Integer id) {
        List<CryptoDTO> listBottle = findAll();
        for (CryptoDTO b : listBottle) {
            if (b.getId().equals(id)) {
                return b;
            }
        }
        return null;
    }

    @Override
    public void addNew(CryptoDTO bottle) {
        List<CryptoDTO> listBottle = findAll();
    }

    @Override
    public void modify(Integer id, CryptoDTO bottle) {
        List<CryptoDTO> listBottle = findAll();
    }

    @Override
    public void deleteById(Integer id) {
        List<CryptoDTO> listBottle = findAll();
        listBottle.removeIf(b -> b.getId().equals(id));
    }

    @Override
    public void deleteAll() {
    }
}
