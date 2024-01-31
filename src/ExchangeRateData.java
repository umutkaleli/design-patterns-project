import java.util.ArrayList;
import java.util.List;

// ExchangeRateData Class - Concrete Subject
public class ExchangeRateData implements Subject {
    private List<Observer> observers = new ArrayList<>();
    private double usdToTlRate = 29;
    private double eurToTlRate = 32;
    private double usdToEurRate = ((double) 29 /32);

    public void setExchangeRates(double usdToTlRate, double eurToTlRate,double usdToEur) {
        this.usdToTlRate = usdToTlRate;
        this.eurToTlRate = eurToTlRate;
        this.usdToEurRate = usdToEur;
        ratesChanged();
    }

    public void ratesChanged(){
        notifyObservers();
    }

    @Override
    public void registerObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(usdToTlRate,eurToTlRate, usdToEurRate);
        }
    }
}