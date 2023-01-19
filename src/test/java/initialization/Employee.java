package initialization;

import java.util.Date;

public class Employee {


    private String name = "default name value";//this assignment performs before constructor (2)
    private static int nextId;//this assignment performs before constructor (3)

    private static int staticBlockId;
    private int blockId;
    private int id = assignId();//this assignment performs before constructor (3)
    private Date hireDay;

    private static int assignId() {//can do it without static
        var r = nextId;
        nextId++;
        return r;
    }

    public Employee(String name) { //(5)
        System.out.println(this.name);
        System.out.println(nextId);
        System.out.println(this.id);
        this.name = name;
        System.out.println(this.name);
    }

    { //(4)
        blockId = 44;
    }

    static { //this assignment performs before constructor (1)
        staticBlockId = 3;
    }

    public Date getHireDay() {
        return hireDay;
    }
}
