package com.travel.app.server.Controller;


import com.travel.app.server.Entity.Pages;
import com.travel.app.server.Service.PageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@CrossOrigin
@RestController
@RequestMapping("/pages")
public class PageController {
	
	@Autowired
	PageService pageService;

	@PostMapping("")
	private Pages submitPage(@RequestBody Pages pages) {
		return pageService.submitMetaDataOfPage(pages);
	}

	@GetMapping("/getAllPages")
	public ArrayList<Pages> getAllPageDetails() {
		return pageService.retrieveAllPageDetails();
	}
	
	@GetMapping("/{pageid}")
	private Pages getPageDetails(@PathVariable("pageid") String pageId) {
		return pageService.displayPageMetaData(pageId);
	}
}
