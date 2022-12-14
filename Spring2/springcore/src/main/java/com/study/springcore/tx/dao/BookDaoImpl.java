package com.study.springcore.tx.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.study.springcore.tx.exception.InsufficientAmount;
import com.study.springcore.tx.exception.InsufficientQuantity;

@Repository
public class BookDaoImpl implements BookDao{
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public Integer getPrice(Integer bid) {
		String sql = "select price from book where bid=?";
		return jdbcTemplate.queryForObject(sql, Integer.class, bid);
	}

	@Override
	public Integer getStockAmount(Integer bid) {
		String sql = "select amount from stock where bid=?";
		return jdbcTemplate.queryForObject(sql, Integer.class, bid);
	}

	@Override
	public Integer getWalletMoney(Integer wid) {
		String sql = "select money from wallet where wid=?";
		return jdbcTemplate.queryForObject(sql, Integer.class, wid);
	}

	@Override
	public Integer updateStock(Integer bid, Integer amount) throws InsufficientQuantity {
		//確認該書的最新庫存量
		Integer new_amount = getStockAmount(bid);
		if(new_amount <= 0) {
			throw new InsufficientQuantity(String.format("Book Num: %d No stocks, So far Amount: %d", bid, new_amount));
		} else if(new_amount <amount) {
			throw new InsufficientQuantity(String.format("Book Num: %d No stocks, So far Amount: %d , Want Amount %d", bid, new_amount, amount));
		}
		//修改庫存
		String sql = "update stock set amount = amount - ? where bid =?";
		return jdbcTemplate.update(sql, amount, bid);
	}

	@Override
	public Integer updateWallet(Integer wid, Integer money) throws InsufficientAmount{
		//先確認錢包裡的餘額
		Integer new_money = getWalletMoney(wid);
		if(new_money <= 0) {
			throw new InsufficientAmount(String.format("Wallet Num: %d$ No money: %d$", wid, new_money));
		} else if(new_money < money) {
			throw new InsufficientAmount(String.format("Wallet Num: %d$ balance not enough, So far money:%d$. Want minus money %d$", wid, new_money, money));
		}
		//修改餘額
		String sql = "update wallet set money = money - ? where wid =?";
		return jdbcTemplate.update(sql, money, wid);
	}

}
