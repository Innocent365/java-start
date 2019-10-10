package singlePattern;

/**
 * 常见的 饱汉子 模式
 */
public class ChocolateBoiler {
    private static ChocolateBoiler chocolateBoiler;

    private boolean empty;
    private boolean boiled;

    private ChocolateBoiler() {
    }

    public static ChocolateBoiler getInstance() {
        if (chocolateBoiler == null) {
            chocolateBoiler = new ChocolateBoiler();
        }
        return chocolateBoiler;
    }

    public void fill() {
        if (isEmpty()) {
            empty = false;
            boiled = false;
            // 在锅炉内填满巧克力和牛奶的混合物
        }
    }

    public void drain(boolean boiled) {
        if (!isEmpty() && isBoiled()) {
            //排出煮沸的巧克力和牛奶
            empty = true;
        }
        this.boiled = boiled;
    }

    public void boil() {
        if (!isEmpty() && !isBoiled()) {
            //将炉内物煮沸
            boiled = true;
        }
    }

    public boolean isEmpty() {
        return empty;
    }

    public boolean isBoiled() {
        return boiled;
    }
}
