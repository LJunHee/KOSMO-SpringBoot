package com.gimhae.sts03;

public class Tv implements Machine {

	@Override
	public void on() {
		System.out.println("켜고");
	}
	@Override
	public void off() {
		System.out.println("끄고");
	}
	@Override
	public void work() {
		System.out.println("방송 보여주고");
	}
}
