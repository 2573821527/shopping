package model;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;


public class cart implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4556103022608549667L;
	private double totalPrice = 0;
	private int totalQuantity = 0;
	private Map<goods, Integer> maps = new HashMap<>();
	public int add(goods goods, int quantity){
		
		if( maps.get( goods ) == null ){
			//如果maps 里没有该商品,直接添加
		} else {
			//如果maps 里已存在当前添加商品,则累加商品数�?
		}
		
		//添加商品后调用计算购物车总金额�?��?�价格方�?
		this.total();
		//返回该商品在购物车内总数�?
		return 0;
	}
	
	/**
	 * 将某件商品从购物车内移除
	 * @param goods 商品对象
	 * @return 返回移除数量
	 */
	public int remove(goods goods){
		
		int q = maps.remove( goods );
		
		//移除商品后调用计算购物车总金额�?��?�价格方�?
		total();
		
		return q;
	}
	public int remove(int gid){
		goods goods = new goods();
		goods.setGid(gid);
		
		return this.remove(goods);
	}
	
	
	/**
	 * 计算购物车�?�金额�?��?�数量方�?
	 */
	private void total(){
		//先将总金额�?��?�数量归�?
		this.totalPrice = 0;
		this.totalQuantity = 0;
		
		
		//遍历购物�? maps 重新计算购物车�?�价格�?��?�数�?
		//代码省略....
	}

	/**
	 * 返回购物车商品�?�金�?(此处不应提供set方法,因为修改购物车商品金额不能由外面修改)
	 * @return
	 */
	public double getTotalPrice() {
		return totalPrice;
	}

	/**
	 * 返回购物车商品�?�数�?(此处不应提供set方法,因为修改购物车商品数量不能由外面修改)
	 * @return
	 */
	public int getTotalQuantity() {
		return totalQuantity;
	}
}
