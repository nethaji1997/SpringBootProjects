package com.nt.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.ScrollPosition.Direction;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.nt.entity.Actor;
import com.nt.repository.IActorRepository;

@Service("actorService")
public class ActorMgtServiceImpl implements IActorMgtService {

	@Autowired
	private IActorRepository repo;

	@Override
	public String registerActor(Actor actor) {
		Actor actr = repo.save(actor);
		return "Actor saved successfully "+actr.getAid();
	}

	@Override
	public String registerActorGroup(List<Actor> list) {
		if(list!=null) {
			List<Actor> sEntities = (List<Actor>) repo.saveAll(list);
			List<Integer> ids = sEntities.stream().map(actor->actor.getAid()).collect(Collectors.toList());
			return ids.size() +" Objects are saved having ids "+ids;
		}
		return "problem in batch insertion";
	}

	@Override
	public long getCount() {
		long count = repo.count();
		return count;
	}

	@Override
	public Iterable<Actor> fetchAllActors() {
		Iterable<Actor> all = repo.findAll();
		return all;
	}

	@Override
	public Optional<Actor> fetchActorById(int id) {
		Optional<Actor> aid= repo.findById(id);
		return aid;
	}

	@Override
	public Actor showActorById(int id) {
		Optional<Actor> sid = repo.findById(id);
		if(sid.isPresent())
		{
			return sid.get();
		}
		else
			throw new IllegalArgumentException("Actor not found");
	}
	
	@Override
	public String updateMobileNo(int aid, long mblNo) {
		Optional<Actor> actorId = repo.findById(aid);
		if(actorId.isPresent())
		{
			Actor actor = actorId.get();
			actor.setMobileNo(mblNo);
			repo.save(actor);
			return aid+" Actor is updated";
		}
		else
		{
			return "Problem in updation";
		}
	}

	@Override
	public String updateActor(Actor actor) {
		boolean existsById = repo.existsById(actor.getAid());
		if(existsById)
		{
			repo.save(actor);
			return actor.getAid()+"Actor is updated";
		}else
			return actor.getAid()+"Actor is not updated";
	}

	@Override
	public String removeActorById(int aid) {
		Optional<Actor> byId = repo.findById(aid);
		if(byId.isPresent())
		{
			repo.deleteById(aid);
			return aid+"actor deleted successfully";
		}
		else
			return "problem in deletion";
	}

	@Override
	public String removeAllActors() {
		 repo.deleteAll();
		 return "all gone";
	}

	@Override
	public Iterable<Actor> showActorByIds(boolean asc, String... propeties) {
		Sort sort= Sort.by(asc?org.springframework.data.domain.Sort.Direction.ASC:org.springframework.data.domain.Sort.Direction.DESC,propeties);
		return repo.findAll(sort);
	}

}

