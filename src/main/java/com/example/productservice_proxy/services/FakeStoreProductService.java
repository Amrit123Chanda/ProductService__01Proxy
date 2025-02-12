package com.example.productservice_proxy.services;

import com.example.productservice_proxy.clients.IClientProductDto;
import com.example.productservice_proxy.clients.fakestore.client.FakeStoreClient;
import com.example.productservice_proxy.clients.fakestore.dto.FakeStoreProductDto;
import com.example.productservice_proxy.dtos.ProductDto;
import com.example.productservice_proxy.models.Categories;
import com.example.productservice_proxy.models.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RequestCallback;
import org.springframework.web.client.ResponseExtractor;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

//@Service
public class FakeStoreProductService implements IProductService {

    private RestTemplateBuilder restTemplateBuilder;
    private FakeStoreClient fakeStoreClient;
    //@Autowired
    public FakeStoreProductService(RestTemplateBuilder restTemplateBuilder,FakeStoreClient fakeStoreClient)
    {
        this.restTemplateBuilder=restTemplateBuilder;
        this.fakeStoreClient=fakeStoreClient;
    }

    private <T> ResponseEntity<T> requestForEntity(HttpMethod httpMethod,String url, @Nullable Object request, Class<T> responseType, Object... uriVariables) throws RestClientException {
        RestTemplate restTemplate = restTemplateBuilder.requestFactory(HttpComponentsClientHttpRequestFactory.class).build();
        RequestCallback requestCallback = restTemplate.httpEntityCallback(request, responseType);
        ResponseExtractor<ResponseEntity<T>> responseExtractor = restTemplate.responseEntityExtractor(responseType);
        return restTemplate.execute(url, httpMethod, requestCallback, responseExtractor, uriVariables);
    }

//    private <T> Object execute(String url, HttpMethod post, RequestCallback requestCallback, ResponseExtractor<ResponseEntity<T>> responseExtractor, Map<String,?> uriVariables) {
//    }
//
//    private <T> ResponseExtractor<ResponseEntity<T>> responseEntityExtractor(Class<T> responseType) {
//    }
//
//    private <T> RequestCallback httpEntityCallback(Object request, Class<T> responseType) {
//    }

    /*
      RestTemplate object has been used to call FakeStore APi. getForEntity returns ResponseEntity object that
      holds ProductDto object. ProductDto object extracted with .getBody() and passed to getProduct method,that returns product.
      which is returned to respective product controller method.
     */
    @Override
    public Product getSingleProduct(Long productId)
    {
        RestTemplate restTemplate=restTemplateBuilder.build();
        ResponseEntity<FakeStoreProductDto> productDtos=restTemplate.getForEntity("https://fakestoreapi.com/products/{id}",FakeStoreProductDto.class,productId);

        Product product = getProduct(productDtos.getBody());

        return product;
    }
    /*
    getForEntity, we pass ProductDto[] array as we cannot pass List<Product> due to generic issue. In for each loop we get the array and convert
    it into product type object. Later we turn productDto array into product & add product to list. List<Product>
    */
    @Override
    public List<Product> getAllProducts()
    {
//        RestTemplate restTemplate=restTemplateBuilder.build();
//        ResponseEntity<ProductDto[]> productDtos =restTemplate.getForEntity("https://fakestoreapi.com/products",ProductDto[].class);


        List<FakeStoreProductDto> fakeStoreProductDtos = fakeStoreClient.getAllProducts();
        List<Product> answer = new ArrayList<>();
        for(FakeStoreProductDto productDto: fakeStoreProductDtos)
        {

            Product product = new Product();
            product.setId(productDto.getId());
            product.setTitle(productDto.getTitle());
            product.setPrice(productDto.getPrice());
            Categories category = new Categories();
            category.setName(productDto.getCategory());
            product.setCategory(category);
            product.setImageUrl(productDto.getImage());

            answer.add(product);

        }
            return answer;
    }

    @Override
    public Product addNewProduct(Product product) {
        return null;
    }

    /*
      postForEntity, we pass the input parameter - productDto, anb the type to be converted into-ProductDto.class.
      we are returning the information back. i,e return product.
     */

//
//    @Override
//    public Product addNewProduct(IClientProductDto productDto)
//    {
//        RestTemplate restTemplate = restTemplateBuilder.build();
//        restTemplate.postForEntity("https://fakestoreapi.com/products",productDto,ProductDto.class);
//        Product product=getProduct((FakeStoreProductDto)productDto);
//        return product;
//    }

    @Override
    public Product updateProduct(Long productId,Product product)
    {
      RestTemplate restTemplate = restTemplateBuilder.build();
      FakeStoreProductDto fakeStoreProductDto = new FakeStoreProductDto();

      fakeStoreProductDto.setDescription(product.getDescription());
      fakeStoreProductDto.setImage(product.getImageUrl());
      fakeStoreProductDto.setPrice(product.getPrice());
      fakeStoreProductDto.setTitle(product.getTitle());
      fakeStoreProductDto.setCategory(product.getCategory().getName());

      ResponseEntity<FakeStoreProductDto> fakeStoreProductDtoResponseEntity =
              requestForEntity(HttpMethod.GET,"https://fakestoreapi.com/products/{id}",fakeStoreProductDto,FakeStoreProductDto.class,productId);
      FakeStoreProductDto fakeStoreProductDto1 = fakeStoreProductDtoResponseEntity.getBody();
      return getProduct(fakeStoreProductDto1);
    }

    @Override
    public String deleteProductDe(Long productId)
    {
        return "deleting product " + productId;
    }

    @Override
    public String patchProduct(Long productId)
    {
        return "Patching Product ";
    }

    private Product getProduct(FakeStoreProductDto productDto) {
        Product product = new Product();
         product.setId(productDto.getId());
        product.setTitle(productDto.getTitle());
        product.setPrice(productDto.getPrice());
        Categories category = new Categories();
        category.setName(productDto.getCategory());
        product.setCategory(category);
        product.setImageUrl(productDto.getImage());
        product.setDescription(productDto.getDescription());
        return product;
    }
}

