package andrei.albu.year2020.myhistoryasareader;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class BooksBackgroundAdapter extends RecyclerView.Adapter<BooksBackgroundAdapter.ViewHolder> {

    private ArrayList<Book> myData;
    private int screenHeight;
    private Context context;

    public BooksBackgroundAdapter(ArrayList<Book> myData, Context context) {
        this.myData =myData;
        this.context = context;
        screenHeight = MainActivityChannel.getHeightScreen((MainActivity)context);
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public ImageView imageView1;
        public ImageView imageView2;
        public TextView textView1;
        public TextView textView2;
        public TextView textView3;

        CardView cardView1;
        CardView cardView2;

        RelativeLayout relativeLayout;

        public ViewHolder(View view) {
            super(view);
            // Define click listener for the ViewHolder's View

            imageView1 = view.findViewById(R.id.imageView1);
            imageView2 = view.findViewById(R.id.imageView2);
            textView1 = view.findViewById(R.id.textView1);
            textView2 = view.findViewById(R.id.textView2);
            textView3 = view.findViewById(R.id.textView3);

            cardView1 = view.findViewById(R.id.cardView1);
            cardView1.setLayoutParams(new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,screenHeight/10));
            cardView2 = view.findViewById(R.id.cardView2);

            relativeLayout = view.findViewById(R.id.relativeLayout1);
        }

        public ImageView getImageView1(){
            return imageView1;
        }

        public ImageView getImageView2(){
            return imageView2;
        }

        public TextView getTextView1() {
            return textView1;
        }

        public TextView getTextView2(){
            return textView2;
        }

        public TextView getTextView3(){
            return textView3;
        }
    }

    // Create new views 
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        // Create a new view, which defines the UI of the list item
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.books_background_layout, viewGroup, false);

        return new ViewHolder(view);
    }

    // Replace the contents of a view 
    @Override
    public void onBindViewHolder(final ViewHolder viewHolder, final int position) {
        if(myData.get(position).getImageUriString().equals(Book.DEFAULT_STRING)){
            viewHolder.imageView1.setImageResource(myData.get(position).getImageID());
        }
        else{
            Uri imageUri = Uri.parse(myData.get(position).getImageUriString());
            viewHolder.imageView1.setImageURI(imageUri);
        }
        viewHolder.imageView2.setImageResource(myData.get(position).getHeartImageID());
        viewHolder.textView1.setText(myData.get(position).getTitle());
        viewHolder.textView2.setText(myData.get(position).getAuthor());
        viewHolder.textView3.setText(myData.get(position).getPriorityReadText());

        viewHolder.relativeLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentHelper.addFragment(((AppCompatActivity)context),((MainActivity)context).getFragmentAnchorID(),new BookInfoFragment(myData.get(position)));
            }
        });
        
        viewHolder.imageView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferencesChannel sharedPreferencesChannelLastOpened = new SharedPreferencesChannel(context, SharedPreferencesChannel.SHARED_PREFERENCES_NAME_LAST_LISTFRAGMENT_OPENED,false);
                if(myData.get(position).getHeartImageID()==R.drawable.empty_heart){
                    myData.get(position).setFavorite(true);
                    myData.get(position).setHeartImageID(R.drawable.red_heart);
                    viewHolder.imageView2.setImageResource(myData.get(position).getHeartImageID());
                    SharedPreferencesChannel.updateBook(myData.get(position),context);

                    if(sharedPreferencesChannelLastOpened.readPairStringString(SharedPreferencesChannel.LAST_LISTFRAGMENT_KEY).equals(SharedPreferencesChannel.FAVORITE)){
                        FragmentHelper.addFragment((AppCompatActivity) context, ((MainActivity)context).getFragmentAnchorID(),new BooksListFragment(SharedPreferencesChannel.FAVORITE));
                    }
                }
                else{
                    myData.get(position).setFavorite(false);
                    myData.get(position).setHeartImageID(R.drawable.empty_heart);
                    viewHolder.imageView2.setImageResource(myData.get(position).getHeartImageID());
                    SharedPreferencesChannel.updateBook(myData.get(position),context);

                    if(sharedPreferencesChannelLastOpened.readPairStringString(SharedPreferencesChannel.LAST_LISTFRAGMENT_KEY).equals(SharedPreferencesChannel.FAVORITE)){
                        FragmentHelper.addFragment((AppCompatActivity) context, ((MainActivity)context).getFragmentAnchorID(),new BooksListFragment(SharedPreferencesChannel.FAVORITE));
                    }
                }
            }
        });
    }

    // Return the size of the dataset 
    @Override
    public int getItemCount() {
        return myData.size();
    }
}
