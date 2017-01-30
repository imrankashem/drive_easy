package com.example.hemanth.youtube;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.zip.Inflater;

public class YouTubeList extends AppCompatActivity {

    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(YouTubeList.this, LinearLayoutManager.VERTICAL,false);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setHasFixedSize(true);

        YouTubeHolder data[] = new YouTubeHolder[]
                {
                        new YouTubeHolder("9-_ul5omIN0","Cheetah vs Gazelle 110km h Cheetah attack gazelle"),
                        new YouTubeHolder("YJhK24Yewgk","15 CRAZIEST Animal attacks Caught On Camera #2 - Most Amazing Wild Animal Attacks"),
                        new YouTubeHolder("Z_PODraXg4E","Ae Dil Hai Mushkil | Trailer | Karan Johar | Aishwarya Rai Bachchan | Ranbir Kapoor | Anushka Sharma"),
                        new YouTubeHolder("1xo3af_6_Jk","Teaser Trailer: Pirates of the Caribbean: Dead Men Tell No Tales"),
                        new YouTubeHolder("LKFuXETZUsI","Moana Official Trailer"),
                        new YouTubeHolder("bwpMyf5Sxaw","RAAJAKUMARA | OFFICIAL TEASER | PUNEETH RAJKUMAR | SANTHOSH ANANDDRAM | VIJAY KIRAGANDUR"),
                        new YouTubeHolder("eABtGsf4ts8","Lions Chase Buffaloes Into Tourist's Car"),
                        new YouTubeHolder("8PM97Bzgilc","Official Android 7.0 Nougat Review!"),

                };


        YouTubeVideoListAdapter youTubeVideoListAdapter = new YouTubeVideoListAdapter(YouTubeList.this,recyclerView,data);
        recyclerView.setAdapter(youTubeVideoListAdapter);


    }

    public class YouTubeVideoListAdapter extends RecyclerView.Adapter<MyViewHolder>{

        public Context mContext;
        RecyclerView recyclerView;
        YouTubeHolder[] hold;

        public YouTubeVideoListAdapter(YouTubeList youTubeList, RecyclerView recyclerView, YouTubeHolder[] data) {
            this.mContext = youTubeList;
            this.recyclerView = recyclerView;
            this.hold = data;

        }

        @Override
        public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.you_tube_list,parent,false);

            return new MyViewHolder(view);

        }

        @Override
        public void onBindViewHolder(MyViewHolder holder, int position) {

            final YouTubeHolder data = hold[position];
             holder.text.setText(data.getVideo());

              View itemView = holder.itemView;
              itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    Intent i = new Intent(mContext,YouTubeVideo.class);
                    i.putExtra("VIDEO_ID",data.getId());
                    startActivity(i);

                }
              });
        }

        @Override
        public int getItemCount() {
            return hold.length;
        }
    }

    private class MyViewHolder extends RecyclerView.ViewHolder {
        TextView text;
        public MyViewHolder(View itemView) {
            super(itemView);
            text = (TextView) itemView.findViewById(R.id.list_item_text);
        }
    }
}
