package observerPattern2;


import java.util.Date;
import java.util.Observable;

public class SalaryData extends Observable {
    private Date date;
    private float account;
    private String bankName;

    public void setSubscribe(Date date, float account, String bankName) {
        this.date = date;
        this.account = account;
        this.bankName = bankName;

        SalaryTake();
    }

    private void SalaryTake() {
        setChanged();
        notifyObservers("发工资咯！");
    }

    public Date getDate() {
        return date;
    }

    public float getAccount() {
        return account;
    }

    public String getBankName() {
        return bankName;
    }
}
