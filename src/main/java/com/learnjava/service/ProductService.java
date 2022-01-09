package com.learnjava.service;

import com.learnjava.domain.Product;
import com.learnjava.domain.ProductInfo;
import com.learnjava.domain.Review;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import static com.learnjava.util.CommonUtil.stopWatch;
import static com.learnjava.util.LoggerUtil.log;

public class ProductService {
    private static ExecutorService exe = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors() * 80);
    private static String[] PROD_IDS = {"ABC123", "ABC124", "ABC125", "ABC126", "ABC127", "ABC128", "ABC129", "ABC130",
            "ABC131", "ABC132", "ABC133", "ABC134", "ABC135", "ABC136", "ABC137", "ABC138",
            "ABC123", "ABC124", "ABC125", "ABC126", "ABC127", "ABC128", "ABC129", "ABC130",
            "ABC131", "ABC132", "ABC133", "ABC134", "ABC135", "ABC136", "ABC137", "ABC138",
            "ABC123", "ABC124", "ABC125", "ABC126", "ABC127", "ABC128", "ABC129", "ABC130",
            "ABC131", "ABC132", "ABC133", "ABC134", "ABC135", "ABC136", "ABC137", "ABC138",
            "ABC123", "ABC124", "ABC125", "ABC126", "ABC127", "ABC128", "ABC129", "ABC130",
            "ABC131", "ABC132", "ABC133", "ABC134", "ABC135", "ABC136", "ABC137", "ABC138",
            "ABC123", "ABC124", "ABC125", "ABC126", "ABC127", "ABC128", "ABC129", "ABC130",
            "ABC131", "ABC132", "ABC133", "ABC134", "ABC135", "ABC136", "ABC137", "ABC138",
            "ABC123", "ABC124", "ABC125", "ABC126", "ABC127", "ABC128", "ABC129", "ABC130",
            "ABC131", "ABC132", "ABC133", "ABC134", "ABC135", "ABC136", "ABC137", "ABC138",
            "ABC123", "ABC124", "ABC125", "ABC126", "ABC127", "ABC128", "ABC129", "ABC130",
            "ABC131", "ABC132", "ABC133", "ABC134", "ABC135", "ABC136", "ABC137", "ABC138",
            "ABC123", "ABC124", "ABC125", "ABC126", "ABC127", "ABC128", "ABC129", "ABC130",
            "ABC131", "ABC132", "ABC133", "ABC134", "ABC135", "ABC136", "ABC137", "ABC138",
            "ABC123", "ABC124", "ABC125", "ABC126", "ABC127", "ABC128", "ABC129", "ABC130",
            "ABC131", "ABC132", "ABC133", "ABC134", "ABC135", "ABC136", "ABC137", "ABC138",
            "ABC123", "ABC124", "ABC125", "ABC126", "ABC127", "ABC128", "ABC129", "ABC130",
            "ABC131", "ABC132", "ABC133", "ABC134", "ABC135", "ABC136", "ABC137", "ABC138",
            "ABC123", "ABC124", "ABC125", "ABC126", "ABC127", "ABC128", "ABC129", "ABC130",
            "ABC131", "ABC132", "ABC133", "ABC134", "ABC135", "ABC136", "ABC137", "ABC138",
            "ABC123", "ABC124", "ABC125", "ABC126", "ABC127", "ABC128", "ABC129", "ABC130",
            "ABC131", "ABC132", "ABC133", "ABC134", "ABC135", "ABC136", "ABC137", "ABC138",
            "ABC123", "ABC124", "ABC125", "ABC126", "ABC127", "ABC128", "ABC129", "ABC130",
            "ABC131", "ABC132", "ABC133", "ABC134", "ABC135", "ABC136", "ABC137", "ABC138",
            "ABC123", "ABC124", "ABC125", "ABC126", "ABC127", "ABC128", "ABC129", "ABC130",
            "ABC131", "ABC132", "ABC133", "ABC134", "ABC135", "ABC136", "ABC137", "ABC138",
            "ABC123", "ABC124", "ABC125", "ABC126", "ABC127", "ABC128", "ABC129", "ABC130",
            "ABC131", "ABC132", "ABC133", "ABC134", "ABC135", "ABC136", "ABC137", "ABC138",
            "ABC123", "ABC124", "ABC125", "ABC126", "ABC127", "ABC128", "ABC129", "ABC130",
            "ABC131", "ABC132", "ABC133", "ABC134", "ABC135", "ABC136", "ABC137", "ABC138",
            "ABC123", "ABC124", "ABC125", "ABC126", "ABC127", "ABC128", "ABC129", "ABC130",
            "ABC131", "ABC132", "ABC133", "ABC134", "ABC135", "ABC136", "ABC137", "ABC138",
            "ABC123", "ABC124", "ABC125", "ABC126", "ABC127", "ABC128", "ABC129", "ABC130",
            "ABC131", "ABC132", "ABC133", "ABC134", "ABC135", "ABC136", "ABC137", "ABC138",
            "ABC123", "ABC124", "ABC125", "ABC126", "ABC127", "ABC128", "ABC129", "ABC130",
            "ABC131", "ABC132", "ABC133", "ABC134", "ABC135", "ABC136", "ABC137", "ABC138",
            "ABC123", "ABC124", "ABC125", "ABC126", "ABC127", "ABC128", "ABC129", "ABC130",
            "ABC131", "ABC132", "ABC133", "ABC134", "ABC135", "ABC136", "ABC137", "ABC138",
            "ABC123", "ABC124", "ABC125", "ABC126", "ABC127", "ABC128", "ABC129", "ABC130",
            "ABC131", "ABC132", "ABC133", "ABC134", "ABC135", "ABC136", "ABC137", "ABC138",
            "ABC123", "ABC124", "ABC125", "ABC126", "ABC127", "ABC128", "ABC129", "ABC130",
            "ABC131", "ABC132", "ABC133", "ABC134", "ABC135", "ABC136", "ABC137", "ABC138",
            "ABC123", "ABC124", "ABC125", "ABC126", "ABC127", "ABC128", "ABC129", "ABC130",
            "ABC131", "ABC132", "ABC133", "ABC134", "ABC135", "ABC136", "ABC137", "ABC138",
            "ABC123", "ABC124", "ABC125", "ABC126", "ABC127", "ABC128", "ABC129", "ABC130",
            "ABC131", "ABC132", "ABC133", "ABC134", "ABC135", "ABC136", "ABC137", "ABC138",
            "ABC123", "ABC124", "ABC125", "ABC126", "ABC127", "ABC128", "ABC129", "ABC130",
            "ABC131", "ABC132", "ABC133", "ABC134", "ABC135", "ABC136", "ABC137", "ABC138",
            "ABC123", "ABC124", "ABC125", "ABC126", "ABC127", "ABC128", "ABC129", "ABC130",
            "ABC131", "ABC132", "ABC133", "ABC134", "ABC135", "ABC136", "ABC137", "ABC138",
            "ABC123", "ABC124", "ABC125", "ABC126", "ABC127", "ABC128", "ABC129", "ABC130",
            "ABC131", "ABC132", "ABC133", "ABC134", "ABC135", "ABC136", "ABC137", "ABC138",
            "ABC123", "ABC124", "ABC125", "ABC126", "ABC127", "ABC128", "ABC129", "ABC130",
            "ABC131", "ABC132", "ABC133", "ABC134", "ABC135", "ABC136", "ABC137", "ABC138",
            "ABC123", "ABC124", "ABC125", "ABC126", "ABC127", "ABC128", "ABC129", "ABC130",
            "ABC131", "ABC132", "ABC133", "ABC134", "ABC135", "ABC136", "ABC137", "ABC138",
            "ABC123", "ABC124", "ABC125", "ABC126", "ABC127", "ABC128", "ABC129", "ABC130",
            "ABC131", "ABC132", "ABC133", "ABC134", "ABC135", "ABC136", "ABC137", "ABC138",
            "ABC123", "ABC124", "ABC125", "ABC126", "ABC127", "ABC128", "ABC129", "ABC130",
            "ABC131", "ABC132", "ABC133", "ABC134", "ABC135", "ABC136", "ABC137", "ABC138",
            "ABC123", "ABC124", "ABC125", "ABC126", "ABC127", "ABC128", "ABC129", "ABC130",
            "ABC131", "ABC132", "ABC133", "ABC134", "ABC135", "ABC136", "ABC137", "ABC138",
            "ABC123", "ABC124", "ABC125", "ABC126", "ABC127", "ABC128", "ABC129", "ABC130",
            "ABC131", "ABC132", "ABC133", "ABC134", "ABC135", "ABC136", "ABC137", "ABC138",
            "ABC123", "ABC124", "ABC125", "ABC126", "ABC127", "ABC128", "ABC129", "ABC130",
            "ABC131", "ABC132", "ABC133", "ABC134", "ABC135", "ABC136", "ABC137", "ABC138",
            "ABC123", "ABC124", "ABC125", "ABC126", "ABC127", "ABC128", "ABC129", "ABC130",
            "ABC131", "ABC132", "ABC133", "ABC134", "ABC135", "ABC136", "ABC137", "ABC138",
            "ABC123", "ABC124", "ABC125", "ABC126", "ABC127", "ABC128", "ABC129", "ABC130",
            "ABC131", "ABC132", "ABC133", "ABC134", "ABC135", "ABC136", "ABC137", "ABC138",
            "ABC123", "ABC124", "ABC125", "ABC126", "ABC127", "ABC128", "ABC129", "ABC130",
            "ABC131", "ABC132", "ABC133", "ABC134", "ABC135", "ABC136", "ABC137", "ABC138",
            "ABC123", "ABC124", "ABC125", "ABC126", "ABC127", "ABC128", "ABC129", "ABC130",
            "ABC131", "ABC132", "ABC133", "ABC134", "ABC135", "ABC136", "ABC137", "ABC138",
            "ABC123", "ABC124", "ABC125", "ABC126", "ABC127", "ABC128", "ABC129", "ABC130",
            "ABC131", "ABC132", "ABC133", "ABC134", "ABC135", "ABC136", "ABC137", "ABC138",
            "ABC123", "ABC124", "ABC125", "ABC126", "ABC127", "ABC128", "ABC129", "ABC130",
            "ABC131", "ABC132", "ABC133", "ABC134", "ABC135", "ABC136", "ABC137", "ABC138",
            "ABC123", "ABC124", "ABC125", "ABC126", "ABC127", "ABC128", "ABC129", "ABC130",
            "ABC131", "ABC132", "ABC133", "ABC134", "ABC135", "ABC136", "ABC137", "ABC138",
            "ABC123", "ABC124", "ABC125", "ABC126", "ABC127", "ABC128", "ABC129", "ABC130",
            "ABC131", "ABC132", "ABC133", "ABC134", "ABC135", "ABC136", "ABC137", "ABC138",
            "ABC123", "ABC124", "ABC125", "ABC126", "ABC127", "ABC128", "ABC129", "ABC130",
            "ABC131", "ABC132", "ABC133", "ABC134", "ABC135", "ABC136", "ABC137", "ABC138",
            "ABC123", "ABC124", "ABC125", "ABC126", "ABC127", "ABC128", "ABC129", "ABC130",
            "ABC131", "ABC132", "ABC133", "ABC134", "ABC135", "ABC136", "ABC137", "ABC138",
            "ABC123", "ABC124", "ABC125", "ABC126", "ABC127", "ABC128", "ABC129", "ABC130",
            "ABC131", "ABC132", "ABC133", "ABC134", "ABC135", "ABC136", "ABC137", "ABC138",
            "ABC123", "ABC124", "ABC125", "ABC126", "ABC127", "ABC128", "ABC129", "ABC130",
            "ABC131", "ABC132", "ABC133", "ABC134", "ABC135", "ABC136", "ABC137", "ABC138",
            "ABC123", "ABC124", "ABC125", "ABC126", "ABC127", "ABC128", "ABC129", "ABC130",
            "ABC131", "ABC132", "ABC133", "ABC134", "ABC135", "ABC136", "ABC137", "ABC138",
            "ABC123", "ABC124", "ABC125", "ABC126", "ABC127", "ABC128", "ABC129", "ABC130",
            "ABC131", "ABC132", "ABC133", "ABC134", "ABC135", "ABC136", "ABC137", "ABC138",
            "ABC123", "ABC124", "ABC125", "ABC126", "ABC127", "ABC128", "ABC129", "ABC130",
            "ABC131", "ABC132", "ABC133", "ABC134", "ABC135", "ABC136", "ABC137", "ABC138",
            "ABC123", "ABC124", "ABC125", "ABC126", "ABC127", "ABC128", "ABC129", "ABC130",
            "ABC131", "ABC132", "ABC133", "ABC134", "ABC135", "ABC136", "ABC137", "ABC138",
            "ABC123", "ABC124", "ABC125", "ABC126", "ABC127", "ABC128", "ABC129", "ABC130",
            "ABC131", "ABC132", "ABC133", "ABC134", "ABC135", "ABC136", "ABC137", "ABC138",
            "ABC123", "ABC124", "ABC125", "ABC126", "ABC127", "ABC128", "ABC129", "ABC130",
            "ABC131", "ABC132", "ABC133", "ABC134", "ABC135", "ABC136", "ABC137", "ABC138",
            "ABC123", "ABC124", "ABC125", "ABC126", "ABC127", "ABC128", "ABC129", "ABC130",
            "ABC131", "ABC132", "ABC133", "ABC134", "ABC135", "ABC136", "ABC137", "ABC138",
            "ABC123", "ABC124", "ABC125", "ABC126", "ABC127", "ABC128", "ABC129", "ABC130",
            "ABC131", "ABC132", "ABC133", "ABC134", "ABC135", "ABC136", "ABC137", "ABC138",
            "ABC123", "ABC124", "ABC125", "ABC126", "ABC127", "ABC128", "ABC129", "ABC130",
            "ABC131", "ABC132", "ABC133", "ABC134", "ABC135", "ABC136", "ABC137", "ABC138",
            "ABC123", "ABC124", "ABC125", "ABC126", "ABC127", "ABC128", "ABC129", "ABC130",
            "ABC131", "ABC132", "ABC133", "ABC134", "ABC135", "ABC136", "ABC137", "ABC138",
            "ABC123", "ABC124", "ABC125", "ABC126", "ABC127", "ABC128", "ABC129", "ABC130",
            "ABC131", "ABC132", "ABC133", "ABC134", "ABC135", "ABC136", "ABC137", "ABC138",
            "ABC123", "ABC124", "ABC125", "ABC126", "ABC127", "ABC128", "ABC129", "ABC130",
            "ABC131", "ABC132", "ABC133", "ABC134", "ABC135", "ABC136", "ABC137", "ABC138",
            "ABC123", "ABC124", "ABC125", "ABC126", "ABC127", "ABC128", "ABC129", "ABC130",
            "ABC131", "ABC132", "ABC133", "ABC134", "ABC135", "ABC136", "ABC137", "ABC138",
            "ABC123", "ABC124", "ABC125", "ABC126", "ABC127", "ABC128", "ABC129", "ABC130",
            "ABC131", "ABC132", "ABC133", "ABC134", "ABC135", "ABC136", "ABC137", "ABC138",
            "ABC123", "ABC124", "ABC125", "ABC126", "ABC127", "ABC128", "ABC129", "ABC130",
            "ABC131", "ABC132", "ABC133", "ABC134", "ABC135", "ABC136", "ABC137", "ABC138",
            "ABC123", "ABC124", "ABC125", "ABC126", "ABC127", "ABC128", "ABC129", "ABC130",
            "ABC131", "ABC132", "ABC133", "ABC134", "ABC135", "ABC136", "ABC137", "ABC138",
            "ABC123", "ABC124", "ABC125", "ABC126", "ABC127", "ABC128", "ABC129", "ABC130",
            "ABC131", "ABC132", "ABC133", "ABC134", "ABC135", "ABC136", "ABC137", "ABC138",
            "ABC123", "ABC124", "ABC125", "ABC126", "ABC127", "ABC128", "ABC129", "ABC130",
            "ABC131", "ABC132", "ABC133", "ABC134", "ABC135", "ABC136", "ABC137", "ABC138"};

    private ProductInfoService productInfoService;
    private ReviewService reviewService;

    public ProductService(ProductInfoService productInfoService, ReviewService reviewService) {
        this.productInfoService = productInfoService;
        this.reviewService = reviewService;
    }

    public List<Product> retrieveProductDetails(String[] prodIds) throws ExecutionException, InterruptedException {
        stopWatch.start();

        List<Product> products = new ArrayList<>();

        List<Future<Product>> results = new ArrayList<>();
        for (int i = 0; i < prodIds.length; ++i) {
            final String prodId = prodIds[i];
            Future<Product> futureProduct = exe.submit(()->retrieveProduct(prodId));
            results.add(futureProduct);
        }

        for (Future<Product> futureProd : results) {
            products.add(futureProd.get());
        }

        stopWatch.stop();
        log("Total Time Taken : "+ stopWatch.getTime());
        return products;
    }

    private Product retrieveProduct(String prodId) throws ExecutionException, InterruptedException {
        return new Product(prodId,
                productInfoService.retrieveProductInfo(prodId),
                reviewService.retrieveReviews(prodId));
    }

    public static void main(String[] args) {

        ProductInfoService productInfoService = new ProductInfoService();
        ReviewService reviewService = new ReviewService();
        ProductService productService = new ProductService(productInfoService, reviewService);

        List<Product> products = null;
        try {
            products = productService.retrieveProductDetails(PROD_IDS);
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

//        for (Product product : products) {
//            log("Product is " + product);
//        }

        exe.shutdown();
    }
}
