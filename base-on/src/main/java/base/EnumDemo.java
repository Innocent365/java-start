package base;

/**
 * @author hw
 * @version on 2019/4/20
 */
public enum EnumDemo {

    CONTRACT("contract", "合同类", null),
    PROTOCOL("protocol", "协议类",null),

    Weekday(null, "WeekDay", new String[]{"Mon", "Tue", "Thu", "Wed", "Friday"});

    final String code;
    final String desc;

    final String[] array;

    EnumDemo(String code, String desc, String[] array) {
        this.code = code;
        this.desc = desc;
        this.array = array;
    }
}

class EnumTest{
    public static void main(String[] args) {
        System.out.println(EnumDemo.PROTOCOL.code);
        //EnumDemo.PROTOCOL.code = "sdds";      //编译不通过
        System.out.println(EnumDemo.PROTOCOL.code);

        System.out.println(EnumDemo.Weekday.array[1]);
        EnumDemo.Weekday.array[1] = "Sun";
        System.out.println(EnumDemo.Weekday.array[1]);
    }
}




