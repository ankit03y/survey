package com.survey.survey;

public class Abstract {
    public int getNum() {
        return 45;
    }

    public abstract class Bar {
        public int getNum() {
            return 38;
        }
    }

    public static void main(String[] args) {
        Abstract t = new Abstract() {
            public int getNum() {
                return 22;
            }
        };

        Abstract.Bar f = t.new Bar() {
            public int getNum() {
                return 57;
            }
        };
        System.out.println(f.getNum() + " " + t.getNum());
    }
}

