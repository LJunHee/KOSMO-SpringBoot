package com.gimhae.sts11;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.DoubleBinaryOperator;
import java.util.function.Function;
import java.util.function.IntBinaryOperator;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Sts11Application implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(Sts11Application.class, args);
	}
	
	@FunctionalInterface
	interface Inter01{
		void test(int a);
//		void func2();
	}
	
	@FunctionalInterface
	interface Inter02 {
		int test();
	}
	
	@FunctionalInterface
	interface Inter03 {
		int test(int a, int b);
	}
	
	void func01(Inter01 inter,int su) {
		inter.test(su);
	}
	
	int func02(Inter03 inter, int a, int b) {
		return inter.test(a, b);
	}
	
	int func03(Comparable inter, String msg) {
		return inter.compareTo(msg);
	}
	
	
	@Override
	public void run(String... args) throws Exception {
		int a = 1111;
//		var func = (a,b) => {return a+b;}
		//인터페이스(하나의 메서드만 선언)
//		Inter01 inter = (su)->{};
		Inter01 inter01 = su->{};
//		Inter02 inter02 = ()->{return a;};
		Inter02 inter02 = ()->0;
//		Inter03 inter03 = (x,y)->{return x+y};
		Inter03 inter03 = (x,y)->x+y;
		func02((x,y)->x*y,1,2);
		func03(o -> 1234,"test");

		Inter04 inter04 = ()->System.out.println("func01 run...");
		
//		inter04.func01();
//		Inter04.func02();
//		inter04.func03();
//		inter04.func04();
		
		// 매개변수 O, 리턴 X
		Consumer test1 = (x)->System.out.println(x);
		// 매개변수 X, 리턴 O
		Supplier test2 = ()->1234;
		// 매개변수 O, 리턴 O
		Function test3 = (x)->x;
		// 매개변수 O O, 리턴 O
		IntBinaryOperator test4 = (x,y)->x+y;
		DoubleBinaryOperator test6 = (x,y)->x+y;
		// 매개변수 O , 리턴 O t/f
		Predicate test5 = (x)-> true;		
		
		
		
//		Runnable func = () -> {
//			System.out.println(Thread.currentThread().getName());
//		};
//		Runnable func = new Runnable() {
//			@Override
//			public void run() {
//				System.out.println(Thread.currentThread().getName());
//			}
//		};
//		Thread thr = new Thread(func);
//		thr.start();
//		System.out.println("main: "+Thread.currentThread().getName());
		
		
		
		
		Stream<String> stream = Stream.of("item3","item2","item1","item4");
//		Stream<Integer> stream = Stream.of(1,2,3,4);
//		Stream<String> stream = Stream.empty();  //null;(null이 아닌 빈 배열)
//		List list = List.of("item1","item2","item3","item4");
//		Stream stream = list.stream();
//		String[] list = {"item1","item2","item3","item4"};
//		Stream<String> stream = Arrays.stream(list);
//		Stream<String> stream = Stream.generate(()->"item").limit(4); //무한(limit 으로 제한)
//		Stream<String> stream = Stream.iterate("item", n->n+1).limit(5); //무한(limit 으로 제한)
//		Stream<String> stream = Stream.<String>builder()
//										.add("item1")
//										.add("item2")
//										.add("item3")
//										.add("item4")
//										.build();
//		
//		stream.forEach(s -> System.out.println(s));
		IntStream intStream = IntStream.range(1, 10); // [1,2,3,4]
//		LongStream longStream = LongStream.rangeClosed(1, 5); // [1,2,3,4,5]
//		Stream<Integer> boxedIntStream = IntStream.range(1, 5).boxed();
//		DoubleStream doubles  = new Random().doubles(3); //난수 3개 생성
//		IntStream charsStream = "Stream".chars(); // [83, 116, 114, 101, 97, 109]
//		Stream<String> stringStream = Pattern.compile(", ").splitAsStream("item1, item2, item3");
//		stringStream.forEach(s -> System.out.println(s));
		
//		stream = stream.map(msg->"<li>"+msg+"</li>");
		
//		intStream = intStream.map(su->su*2);
//		intStream = intStream.filter(su->su%2!=0);
//		stream = stream.distinct();
//		stream = stream.sorted();
//		stream = stream.sorted((o1,o2) -> o2.compareTo(o1));
//		stream = stream.peek(msg->System.out.println("------------"));
//		stream = stream.sorted(String::compareTo);
//		
//		stream.forEach(System.out::println);
		
//		int sum = IntStream.range(1,5)
//					.peek(i->System.out.println("before확인:"+i))
//					.sorted()
//					.map(i->{System.out.println("after확인:"+i); return i;})
//					.sum();
//		System.out.println("합계:" + sum);
		
		
		
		List<String> numbers = Arrays.asList("1","2","3","4","5");
		List<String> chars = Arrays.asList("a","b","c","d","e");
		Stream<String> stream1 = numbers.stream();
		Stream<String> stream2 = chars.stream();
		Stream<String> stream3 = Stream.concat(stream1, stream2);
		
//		ArrayList<String> data = new ArrayList<>();
//		stream3.forEach(msg->data.add(msg));
		
//		Optional<String> data = stream3.reduce((x,y)-> x+y);
//		
//		System.out.println(data.get());
		
		double sum = IntStream.range(1, 5)
//						.reduce((x, y) -> x*y).getAsInt();
//						.sum();
//						.average().getAsDouble();
//						.count();
//						.max().getAsInt();
						.min().getAsInt();
		
		System.out.println("합계:"+sum);
		
//		int[] intArr = { 2, 4 ,6 };
//		boolean result = Arrays.stream(intArr)
//		.allMatch(a -> a%2==0);
//		System.out.println("모두 2의 배수인가? " + result);
//		result = Arrays.stream(intArr)
//		.anyMatch(a -> a%3==0);
//		System.out.println("하나라도 3의 배수가 있는가? " + result);
//		result = Arrays.stream(intArr)
//		.noneMatch(a -> a%3==0);
//		System.out.println("3의 배수가 없는가? " + result);
		
//		List<String> list = stream.collect(Collectors.toList());
//		System.out.println(list);
//		Set<String> set = stream.collect(Collectors.toSet());
//		System.out.println(set);
//		Map<String, String> map = stream.collect(
//				Collectors.toMap(k -> k,  v -> v.substring(4))
//				);
//				System.out.println(map);
				
//		String joined = stream.collect(Collectors.joining(","));
//		String joined = stream.collect(Collectors.minBy(Comparator.naturalOrder())).get();
		String joined = stream.collect(Collectors.maxBy(Comparator.naturalOrder())).get();
		System.out.println(joined);
		
		
		stream = Stream.of("apple", "banana", "cherry", "date");
		Map lengGroup =
		stream.collect(Collectors.groupingBy(t -> t.contains("a")));
		System.out.println(lengGroup);
		
		String string = "a string in optional";
		Optional<String> opString = Optional.of(string);
		System.out.println(opString.get());
		// Optional.of(null) 불가
		Optional<String> nullOpString = Optional.ofNullable(null);
		Optional<String> emptyOptional = Optional.empty();
		try {
		System.out.println(nullOpString.get());
		} catch (NoSuchElementException e) {
		System.out.println("No such element");
		}
		System.out.println(emptyOptional.isPresent());
		String name = emptyOptional.orElse("anonymous");
		System.out.println(name);
	}

}
