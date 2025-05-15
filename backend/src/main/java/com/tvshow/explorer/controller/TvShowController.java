
package com.tvshow.explorer.controller;

import com.tvshow.explorer.model.TvShow;
import com.tvshow.explorer.service.TvShowService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping("/api/tvshows")
public class TvShowController {

    private final TvShowService tvShowService;

    public TvShowController(TvShowService tvShowService) {
        this.tvShowService = tvShowService;
    }

    @GetMapping
    public List<TvShow> getAllShows() {
        return tvShowService.getAllShows();
    }
}
