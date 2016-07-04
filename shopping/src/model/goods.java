package model;

import java.io.Serializable;

public class goods implements Serializable {

	/**
	 * 
	 */
	/**
	 * 
	 */
	private static final long serialVersionUID = 9054500118211405217L;

	private int gid;
	private float price;
	private String sum;
	/*
	 * 商品名称
	 */
	private String goodsName;
	/*
	 * 商品单价
	 */

	public int getGid() {
		return gid;
	}
	public void setGid(int gid) {
		this.gid = gid;
	}
	public String getGoodsName() {
		return goodsName;
	}
	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public String getSum() {
		return sum;
	}
	public void setSum(String sum) {
		this.sum = sum;
	}
	@Override
	public String toString() {
		return "goods [gid=" + gid + ", price=" + price + ", sum=" + sum + ", goodsName=" + goodsName + "]";
	}
}
