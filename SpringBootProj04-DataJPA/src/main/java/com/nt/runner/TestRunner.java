package com.nt.runner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.nt.entity.Actor;
import com.nt.service.IActorMgtService;

@Component
public class TestRunner implements CommandLineRunner {

	@Autowired
	private IActorMgtService service;

	@Override
	public void run(String... args) throws Exception {
		//Problem-01
				Actor actor=new Actor();
				actor.setAname("nethu");
				actor.setCategory("hero");
				actor.setMobileNo(987654l);
				String result= service.registerActor(actor);
				System.out.println(result+" "+actor.getAid());
		//		
		//		//Problem-02
		//		List<Actor> list=List.of(new Actor(2, "prakash", "heroooo", 9874345l));
		//		String registerActorGroup = service.registerActorGroup(list);
		//		System.out.println(registerActorGroup);
		//		
		//		//Problem-03
		//		long count = service.getCount();
		//		System.out.println("The total records are "+count);

		//Problem-04
		//		Iterable<Actor> it = service.fetchAllActors();
		//		it.forEach(actr1->{
		//			System.out.println(actr1);
		//		});
		//
		//		System.out.println("--------------------------------------");
		//
		//		it.forEach(System.out::println);
		//
		//		System.out.println("--------------------------------------");
		//
		//		for(Actor act:it)
		//		{
		//			System.out.println(act);
		//		}
		//
		//		System.out.println("--------------------------------------");
		//
		//		it.forEach(actor->System.out.println(actor));
		//
		//		System.out.println("--------------------------------------");
		//
		//		List<Actor> list = (List<Actor>)it;
		//		list.stream().forEach(System.out::println);

		//Problem-05
//		Optional<Actor> id = service.fetchActorById(2);
//		if(id.isPresent())
//		{
//			System.out.println(id.get());
//		}
//		System.out.println("--------------------------------------");
//
//		Actor actor = id.orElseThrow(()->new IllegalArgumentException("Actor not found"));
//		System.out.println(actor);
		
		//Problem-06
//		String updateMobileNo = service.updateMobileNo(1, 6666666);
//		System.out.println("Mbl no updated "+updateMobileNo);
		
		//Problem-07
//		Actor actor=new Actor(100,"vikas","hero",989898l);
//		String updateActor = service.updateActor(actor);
//		System.out.println(updateActor+ " Actor fully updated");
		
		
		//problem-08
//		String removeActorById = service.removeActorById(102);
//		System.out.println("Actor deleted succefully");
		
		//problem-09
//		String removeAllActors = service.removeAllActors();
//		System.out.println("All actors gone");

	}

}
