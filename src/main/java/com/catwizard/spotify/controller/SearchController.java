package com.catwizard.spotify.controller;

import com.catwizard.spotify.service.SearchService;
import com.wrapper.spotify.models.Album;
import com.wrapper.spotify.models.Track;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

/**
 * Created by poolebu on 8/10/16.
 */
@RestController
@RequestMapping("/search")
public class SearchController {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @Autowired
    SearchService searchService;

    /**
     * E.G. http://localhost:8080/search/album?albumId=7e0ij2fpWaxOEHv5fUYZjd
     * @param albumNameRequest
     * @return
     */
    @RequestMapping("/album")
    public Album album(@RequestParam(value = "albumId") String albumNameRequest) {


        return searchService.searchAblumById(albumNameRequest);

    }

    @RequestMapping("/userPlaylist")
    public String userPlaylist(@RequestParam(value = "userId") String userId,
                               @RequestParam(value = "playlistId") String playlistId){

        return searchService.searchPlaylistSongs(userId,playlistId);


    }

    /**
     * EG http://localhost:8080/search/track?trackId=1vpwWCCXYYMAaRMTfsnDpk
     * @param trackId
     * @return
     */
    @RequestMapping("/track")
    public Track track(@RequestParam(value = "trackId") String trackId) {

        return searchService.searchTrackById(trackId);

    }

    ///search/audio

    @RequestMapping("/audio")
       public String audio(@RequestParam(value = "trackId") String trackId) {

           return searchService.searchAudioById(trackId);

       }



}