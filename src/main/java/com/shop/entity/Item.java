package com.shop.entity;

import java.time.LocalDateTime;

import javax.persistence.*;
import com.shop.constant.ItemSellStatus;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name="item")
@Getter
@Setter
@ToString
public class Item {

	@Id
	@Column(name = "item_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(nullable = false, length = 50)
	private String itemNm;

	@Column(name = "price", nullable = false)
	private int price;

	@Column(nullable = false)
	private int stockNumber;    // 재고수량

	@Lob
	@Column(nullable = false)
	private String itemDetail;

	@Enumerated(EnumType.STRING)
	private ItemSellStatus itemSellStatus;

	private LocalDateTime regTime; // 등록시간

	private LocalDateTime updateTime; // 수정시간
}
