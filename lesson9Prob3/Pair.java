package lesson9Prob3;

import java.util.Objects;

public class Pair {
	String name;
	int salary;
	public Pair(String n, int s) {
		this.name = n;
		this.salary = s;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(name,salary);
	}
	@Override
	public boolean equals(Object ob) {
		if(ob==null) return false;
		if(!(ob instanceof Pair)) return false;
		Pair p = (Pair) ob;
		return this.name.equals(p.name) && this.salary==p.salary;
	}

}
