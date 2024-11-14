package com.gimhae.sts11;

@FunctionalInterface
public interface Inter04 {
	
	void func01();
	
	public static void func02() {
		System.out.println("func02 run...");
	}
	
	public default void func03() {
		System.out.println("func03 run...");
	}
	
	public default void func04() {
		System.out.println("func04 run...");
	}
}
