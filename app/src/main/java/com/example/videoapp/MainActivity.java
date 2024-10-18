
package com.example.videoapp;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.viewpager2.widget.ViewPager2;

import java.util.ArrayList;
import java.util.List;


/**
 * the main class
 */
public class MainActivity extends AppCompatActivity {

    /**
     * initialization function
     * @param savedInstanceState default parameter
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        final ViewPager2 videoViewPager = findViewById(R.id.videosViewPager);

        List<VideoItem> videoItemsList = new ArrayList<>();

        VideoItem videoExample1 = new VideoItem();
        videoExample1.videoURL = "https://firebasestorage.googleapis.com/v0/b/example-project-364f0.appspot.com/o/quake_gameplay.mp4?alt=media&token=e2c89ff8-b30d-43e4-8f1e-a90c157abca2";
        videoExample1.videoTitle = "example video 1";
        videoExample1.videoID = "ID: 12345";
        videoExample1.videoDescription = "example video 1 description";
        videoItemsList.add(videoExample1);

        VideoItem videoExample2 = new VideoItem();
        videoExample2.videoURL = "https://firebasestorage.googleapis.com/v0/b/example-project-364f0.appspot.com/o/mspaint_circle.mp4?alt=media&token=c2561d2c-9c1d-4963-b40f-06b4e6aa1d7a";
        videoExample2.videoTitle = "example video 2";
        videoExample2.videoID = "ID: 54321";
        videoExample2.videoDescription = "example video 2 description";
        videoItemsList.add(videoExample2);

        VideoItem videoExample3 = new VideoItem();
        videoExample3.videoURL = "https://firebasestorage.googleapis.com/v0/b/example-project-364f0.appspot.com/o/mspaint_square.mp4?alt=media&token=5fb9f579-5c92-4be4-9cd4-ae944e070918";
        videoExample3.videoTitle = "example video 3";
        videoExample3.videoID = "ID: 02468";
        videoExample3.videoDescription = "example video 3 description";
        videoItemsList.add(videoExample3);

        videoViewPager.setAdapter(new VideoAdapter(videoItemsList));
    }
}
