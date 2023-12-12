package com.klagan.text.controller;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.klagan.text.dto.PriceListDto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class PriceListControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    @DisplayName("Test 1: request at 10:00 a.m. on the 14th for product 35455 for brand 1 (XYZ)")
    public void test1() throws Exception {

        String expectPriceResult = "35.50";

        String date = "2020-06-14 10:00:00";
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get("/price-list/get-prices")
                        .param("date",date ).param("productId", "35455")
                        .param("brandId", "1").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk()).andReturn();

        MockHttpServletResponse response = mvcResult.getResponse();

        List<PriceListDto> priceListDtos = objectMapper.readValue(response.getContentAsString(), new TypeReference<>() {});

        assertThat(priceListDtos.get(0).getProduct().getProductId()).isEqualTo(35455);
        assertThat(priceListDtos.get(0).getBrand().getBrandId()).isEqualTo(1);
        assertThat(priceListDtos.get(0).getPrice().toString()).isEqualTo(expectPriceResult);

        System.out.println("The price of this product: " + priceListDtos.get(0).getProduct().getProductId() +
                " from brand " + priceListDtos.get(0).getBrand().getName() +
                " for this time " + date + " is: " + expectPriceResult + " " +
                priceListDtos.get(0).getCurr());
    }

    @Test
    @DisplayName("Test 2: request at 4:00 p.m. on the 14th for product 35455 for brand 1 (XYZ)")
    public void test2() throws Exception {

        String expectPriceResult = "25.45";

        String date = "2020-06-14 16:00:00";
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get("/price-list/get-prices")
                        .param("date",date ).param("productId", "35455")
                        .param("brandId", "1").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk()).andReturn();

        MockHttpServletResponse response = mvcResult.getResponse();

        List<PriceListDto> priceListDtos = objectMapper.readValue(response.getContentAsString(), new TypeReference<>() {});

        assertThat(priceListDtos.get(0).getProduct().getProductId()).isEqualTo(35455);
        assertThat(priceListDtos.get(0).getBrand().getBrandId()).isEqualTo(1);
        assertThat(priceListDtos.get(0).getPrice().toString()).isEqualTo(expectPriceResult);

        System.out.println("The price of this product: " + priceListDtos.get(0).getProduct().getProductId() +
                " from brand " + priceListDtos.get(0).getBrand().getName() +
                " for this time " + date + " is: " + expectPriceResult + " " +
                priceListDtos.get(0).getCurr());
    }

    @Test
    @DisplayName("Test 3: request at 9:00 p.m. on day 14th for product 35455 for brand 1 (XYZ)")
    public void test3() throws Exception {

        String expectPriceResult = "35.50";

        String date = "2020-06-14 21:00:00";
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get("/price-list/get-prices")
                        .param("date",date ).param("productId", "35455")
                        .param("brandId", "1").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk()).andReturn();

        MockHttpServletResponse response = mvcResult.getResponse();

        List<PriceListDto> priceListDtos = objectMapper.readValue(response.getContentAsString(), new TypeReference<>() {});

        assertThat(priceListDtos.get(0).getProduct().getProductId()).isEqualTo(35455);
        assertThat(priceListDtos.get(0).getBrand().getBrandId()).isEqualTo(1);
        assertThat(priceListDtos.get(0).getPrice().toString()).isEqualTo(expectPriceResult);

        System.out.println("The price of this product: " + priceListDtos.get(0).getProduct().getProductId() +
                " from brand " + priceListDtos.get(0).getBrand().getName() +
                " for this time " + date + " is: " + expectPriceResult + " " +
                priceListDtos.get(0).getCurr());
    }

    @Test
    @DisplayName("Test 4: request at 10:00 a.m. on the 15th for product 35455 for brand 1 (XYZ)")
    public void test4() throws Exception {

        String expectPriceResult = "30.50";

        String date = "2020-06-15 10:00:00";
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get("/price-list/get-prices")
                        .param("date",date ).param("productId", "35455")
                        .param("brandId", "1").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk()).andReturn();

        MockHttpServletResponse response = mvcResult.getResponse();

        List<PriceListDto> priceListDtos = objectMapper.readValue(response.getContentAsString(), new TypeReference<>() {});

        assertThat(priceListDtos.get(0).getProduct().getProductId()).isEqualTo(35455);
        assertThat(priceListDtos.get(0).getBrand().getBrandId()).isEqualTo(1);
        assertThat(priceListDtos.get(0).getPrice().toString()).isEqualTo(expectPriceResult);

        System.out.println("The price of this product: " + priceListDtos.get(0).getProduct().getProductId() +
                " from brand " + priceListDtos.get(0).getBrand().getName() +
                " for this time " + date + " is: " + expectPriceResult + " " +
                priceListDtos.get(0).getCurr());
    }

    @Test
    @DisplayName("Test 5: request at 9:00 p.m. on day 16th for product 35455 for brand 1 (XYZ)")
    public void test5() throws Exception {

        String expectPriceResult = "38.95";

        String date = "2020-06-16 21:00:00";
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get("/price-list/get-prices")
                        .param("date",date ).param("productId", "35455")
                        .param("brandId", "1").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk()).andReturn();

        MockHttpServletResponse response = mvcResult.getResponse();

        List<PriceListDto> priceListDtos = objectMapper.readValue(response.getContentAsString(), new TypeReference<>() {});

        assertThat(priceListDtos.get(0).getProduct().getProductId()).isEqualTo(35455);
        assertThat(priceListDtos.get(0).getBrand().getBrandId()).isEqualTo(1);
        assertThat(priceListDtos.get(0).getPrice().toString()).isEqualTo(expectPriceResult);

        System.out.println("The price of this product: " + priceListDtos.get(0).getProduct().getProductId() +
                " from brand " + priceListDtos.get(0).getBrand().getName() +
                " for this time " + date + " is: " + expectPriceResult + " " +
                priceListDtos.get(0).getCurr());
    }

}