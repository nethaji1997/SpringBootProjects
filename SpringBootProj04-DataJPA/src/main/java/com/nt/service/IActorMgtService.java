package com.nt.service;

import java.util.List;
import java.util.Optional;

import com.nt.entity.Actor;

public interface IActorMgtService {
public String registerActor(Actor actor);

public String registerActorGroup(List<Actor> list);

public long getCount();

public Iterable<Actor> fetchAllActors();	

public Optional<Actor> fetchActorById(int id);

public Actor showActorById(int id);

public String updateMobileNo(int aid, long mblNo);

public String updateActor(Actor actor);

public String removeActorById(int aid);

public String removeAllActors();

public Iterable<Actor> showActorByIds(boolean asc, String... propeties);
}
