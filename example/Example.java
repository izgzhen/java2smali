package example;

import java.util.HashMap;

public class Example {
    public static class BaseClass {
        public void Foo() {

        }
    }

    public static class DerivedClass extends BaseClass {
    }

    public static void example() {
        DerivedClass o = new DerivedClass();
        o.Foo();
    }
}
