package observerPattern.interf;

/***
 * 主题，即 报刊发行方
 */
public interface Subject {
    public void registerObserver(Observer o);

    public void removeObserver(Observer o);

    public void notifyObservers();
}
