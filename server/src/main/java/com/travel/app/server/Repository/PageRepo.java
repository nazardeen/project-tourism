package com.travel.app.server.Repository;

import com.travel.app.server.Entity.Pages;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface PageRepo extends CrudRepository<Pages, Integer>{

	Pages save(Pages page);
	Pages findByPageId(String pageId);

	ArrayList<Pages> findAll();
}
