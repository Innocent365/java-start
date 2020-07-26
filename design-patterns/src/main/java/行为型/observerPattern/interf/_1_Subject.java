package 行为型.observerPattern.interf;

/***
 * 主题，即 报刊发行方
 */
public interface _1_Subject {
    public void registerObserver(Observer o);

    public void removeObserver(Observer o);

    public void notifyObservers();
}
