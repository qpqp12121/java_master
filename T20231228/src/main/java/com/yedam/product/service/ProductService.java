package com.yedam.product.service;

import java.util.List;

import com.yedam.product.vo.ProductVO;

public interface ProductService {
	//1.상품목록 2.상세조회(상품코드) 3.관련상품목록(현재상세조회상품 제외-별점높은순 4개만)
	List<ProductVO> productList();
	ProductVO getProduct(String pno);
	List<ProductVO> productRelated(String pno);
}
