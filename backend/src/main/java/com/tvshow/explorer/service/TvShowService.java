
package com.tvshow.explorer.service;

import com.tvshow.explorer.model.TvShow;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import javax.annotation.PostConstruct;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

@Service
public class TvShowService {

    private final List<TvShow> tvShows = new ArrayList<>();

    @PostConstruct
    public void loadShows() {
        try {
            Files.lines(Paths.get("/mnt/data/tvtitles.txt")).forEach(this::fetchShowDetails);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void fetchShowDetails(String title) {
        try {
            WebClient webClient = WebClient.create("http://api.tvmaze.com");
            TvShow show = webClient.get()
                    .uri("/singlesearch/shows?q=" + title)
                    .retrieve()
                    .bodyToMono(TvShow.class)
                    .block();
            if (show != null) {
                tvShows.add(show);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<TvShow> getAllShows() {
        return tvShows;
    }
}
