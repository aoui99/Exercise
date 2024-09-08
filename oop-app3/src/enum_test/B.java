package enum_test;

public enum B {
    X("张三") {
        @Override
        public void go() {
            System.out.println(getName() + "在跑~~");
        }
    };
    private String name;

    B(String name) {
        this.name = name;
    }

    public abstract void go();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
