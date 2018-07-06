package reactive;

import java.util.List;

public class Hello {

    private String dude;
    private String girl;
    private List<Integer> guys;

    @java.beans.ConstructorProperties({"dude", "girl", "guys"})
    Hello(String dude, String girl, List<Integer> guys) {
        this.dude = dude;
        this.girl = girl;
        this.guys = guys;
    }

    public static HelloBuilder builder() {
        return new HelloBuilder();
    }

    public static class HelloBuilder {
        private String dude;
        private String girl;
        private List<Integer> guys;

        HelloBuilder() {
        }

        public Hello.HelloBuilder dude(String dude) {
            this.dude = dude;
            return this;
        }

        public Hello.HelloBuilder girl(String girl) {
            this.girl = girl;
            return this;
        }

        public Hello.HelloBuilder guys(List<Integer> guys) {
            this.guys = guys;
            return this;
        }

        public Hello build() {
            return new Hello(dude, girl, guys);
        }

        public String toString() {
            return "reactive.Hello.HelloBuilder(dude=" + this.dude + ", girl=" + this.girl + ", guys=" + this.guys + ")";
        }
    }
}
