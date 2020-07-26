package 创建型._0_singlePattern;

/**
 * 常见的 懒汉 模式
 */
public class _1_Singleton_lazy {
    private static _1_Singleton_lazy singletonlazy;


    private _1_Singleton_lazy() {
    }

    public static _1_Singleton_lazy getInstance() {
        //别人要用的时候你才去实例化
        if (singletonlazy == null) {
            singletonlazy = new _1_Singleton_lazy();
        }
        return singletonlazy;
    }

}
