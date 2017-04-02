package patterns.observable;

import java.util.ArrayList;
import java.util.List;

public class StockIndex implements StockListener {
	
	String name;
	double index;
	List<Stock> stockList = new ArrayList<>();
	
	public StockIndex(String name, Stock... stocks) {
		for (Stock stock : stocks) {
			stockList.add(stock);
			stock.addStockListener(this);
			index += stock.getPrice();
		}
	}
	
	public void addStock(Stock stock) {
		if (!stockList.contains(stock)) {
			stockList.add(stock);
			index += stock.getPrice();
			stock.addStockListener(this);
		}
	}
	
	public void removeStock(Stock stock) {
		if (stockList.contains(stock)) {
			stockList.remove(stock);
			index -= stock.getPrice();
			stock.removeStockListener(this);
		}
	}

	public double getIndex() {
		return index;
	}

	@Override
	public void stockPriceChanged(Stock stock, double oldPrice, double newPrice) {
		if (stockList.contains(stock)) {
			if (stock.getPrice() == oldPrice) {
				index += newPrice - oldPrice;
			}
		}
	}
}
