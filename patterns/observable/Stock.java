package patterns.observable;

import java.util.ArrayList;
import java.util.List;

public class Stock {

	String ticker;
	double price;
	List<StockListener> stockListeners = new ArrayList<>();
	
	public Stock(String ticker, double price) {
		this.ticker = ticker;
		this.price = price;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		for (StockListener listener : stockListeners) {
			listener.stockPriceChanged(this, this.price, price);
		}
		this.price = price;
	}

	public String getTicker() {
		return ticker;
	}
	
	public void addStockListener(StockListener stockListener) {
		if (!stockListeners.contains(stockListener)) {
			stockListeners.add(stockListener);
		}
	}
	
	public void removeStockListener(StockListener stockListener) {
		if (stockListeners.contains(stockListener)) {
			stockListeners.remove(stockListener);
		}
	}
}
