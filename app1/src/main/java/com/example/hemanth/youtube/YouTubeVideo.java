package com.example.hemanth.youtube;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;

/**
 * Created by hemanth on 26/10/16.
 */
public class YouTubeVideo extends YouTubeBaseActivity implements YouTubePlayer.OnInitializedListener {

    public static final String DEVELOPER_KEY = "AIzaSyDsUo1qdfljOvqsCRhzdZJCEnYPUJLcKEA";
    YouTubePlayerView youTubeView;
    String videoId;
    public MyPlayerStateChangeListener playerStateChangeListener;
    public MyPlaybackEventListener playbackEventListener;
    YouTubePlayer youTubePlayer;

    @Override
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.you_tube_video);
        youTubeView = (YouTubePlayerView) findViewById(R.id.youtube_view);
        youTubeView.initialize(DEVELOPER_KEY,this);
        playerStateChangeListener = new MyPlayerStateChangeListener();
        playbackEventListener = new MyPlaybackEventListener();

        Intent i = getIntent();
        videoId = i.getStringExtra("VIDEO_ID");
        


    }

    @Override
    public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean b) {
        this.youTubePlayer = youTubePlayer;
        youTubePlayer.setPlayerStateChangeListener(playerStateChangeListener);
        youTubePlayer.setPlaybackEventListener(playbackEventListener);

        //This flag tells the player to switch to landscape when in fullscreen, it will also return to portrait
        //when leaving fullscreen
        youTubePlayer.setFullscreenControlFlags(YouTubePlayer.FULLSCREEN_FLAG_CONTROL_ORIENTATION);

        //This flag tells the player to automatically enter fullscreen when in landscape. Since we don't have
        //landscape layout for this activity, this is a good way to allow the user rotate the video player.
        youTubePlayer.addFullscreenControlFlag(youTubePlayer.FULLSCREEN_FLAG_ALWAYS_FULLSCREEN_IN_LANDSCAPE);

        //This flag controls the system UI such as the status and navigation bar, hiding and showing them
        //alongside the player UI
        youTubePlayer.addFullscreenControlFlag(youTubePlayer.FULLSCREEN_FLAG_CONTROL_SYSTEM_UI);

        if(!b){
            youTubePlayer.loadVideo(videoId);
        }
    }

    @Override
    public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {
                 String error = youTubeInitializationResult.toString();
        Toast.makeText(YouTubeVideo.this,error,Toast.LENGTH_LONG).show();
    }

    public final class MyPlaybackEventListener implements YouTubePlayer.PlaybackEventListener {

        @Override
        public void onPlaying() {
            // Called when playback starts, either due to user action or call to play().
            Toast.makeText(YouTubeVideo.this, "Playing", Toast.LENGTH_LONG).show();
        }

        @Override
        public void onPaused() {
            // Called when playback is paused, either due to user action or call to pause().

            Toast.makeText(YouTubeVideo.this, "Paused", Toast.LENGTH_LONG).show();
        }

        @Override
        public void onStopped() {
            // Called when playback stops for a reason other than being paused.

            Toast.makeText(YouTubeVideo.this, "Stopped", Toast.LENGTH_LONG).show();
        }

        @Override
        public void onBuffering(boolean b) {
            // Called when buffering starts or ends.
        }

        @Override
        public void onSeekTo(int i) {
            // Called when a jump in playback position occurs, either
            // due to user scrubbing or call to seekRelativeMillis() or seekToMillis()
        }
    }

    public final class MyPlayerStateChangeListener implements YouTubePlayer.PlayerStateChangeListener {

        @Override
        public void onLoading() {
            // Called when the player is loading a video
            // At this point, it's not ready to accept commands affecting playback such as play() or pause()
        }

        @Override
        public void onLoaded(String s) {
            // Called when a video is done loading.
            // Playback methods such as play(), pause() or seekToMillis(int) may be called after this callback.
        }

        @Override
        public void onAdStarted() {
            // Called when playback of an advertisement starts.
        }

        @Override
        public void onVideoStarted() {
            // Called when playback of the video starts.
        }

        @Override
        public void onVideoEnded() {
            // Called when the video reaches its end.
        }

        @Override
        public void onError(YouTubePlayer.ErrorReason errorReason) {
            // Called when an error occurs.
        }
    }
}
