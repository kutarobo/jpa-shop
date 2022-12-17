package com.shop.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.shop.entity.Item;

public interface ItemRepository  extends JpaRepository<Item, Long> {
	List<Item> findByItemNm(String itemNm);
	List<Item> findByItemNmOrItemDetail(String itemNm, String itemDetail);
	List<Item> findByPriceLessThan(Integer price);
	List<Item> findByPriceLessThanOrderByPriceDesc(Integer price);

	@Query("select i from Item i where i.itemDetail like %:itemDetail% order by i.price desc")
	List<Item> findByItemDetail(@Param("itemDetail") String itemDetail);

	// value 안에 쿼리를 작성 후  `nativeQuery = true`옵션을 지정하면 네이티브 쿼리를 사용 할 수 있다.
	// 통계용 복잡한 쿼리를 수행하는데 사용될 수 있으나 db에 종속적이지 않는 다는 장점은 사라진다.
	@Query(value="select * from item i where i.item_detail like %:itemDetail% order by i.price desc", nativeQuery = true)
	List<Item> findByItemDetailByNative(@Param("itemDetail") String itemDetail);


}
